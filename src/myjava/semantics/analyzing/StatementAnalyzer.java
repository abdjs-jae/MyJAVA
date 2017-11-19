package myjava.semantics.analyzing;

import java.util.List;

import myjava.semantics.SemanticUtils;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.errors.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.controlled.DoWhileCommand;
import myjava.execution.commands.controlled.ForCommand;
import myjava.execution.commands.controlled.IConditionalCommand;
import myjava.execution.commands.controlled.IControlledCommand;
import myjava.execution.commands.controlled.IfCommand;
import myjava.execution.commands.controlled.WhileCommand;
import myjava.execution.commands.basic.PrintCommand;
import myjava.execution.commands.basic.ReturnCommand;
import myjava.execution.commands.basic.ScanCommand;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser.*;
import myjava.semantics.StatementControlOverseer;
import myjava.semantics.scoping.LocalScopeCreator;

import static myjava.ITextWriter.txtWriter;

/**
 * A bridge for statement listener
 * @author Patrick
 *
 */
public class StatementAnalyzer {

    public StatementAnalyzer() {

    }

    public void analyze(StatementContext ctx) {
        //print statement
        if(ctx.printStatement() != null) {
            this.handlePrintStatement(ctx);
        }
        else if(ctx.scanStatement() != null) {
            this.handleScanStatement(ctx);
        }
        //an expression
        else if(ctx.statementExpression() != null) {
            StatementExpressionAnalyzer expressionAnalyzer = new StatementExpressionAnalyzer();
            expressionAnalyzer.analyze(ctx.statementExpression());
        }

        //a block statement
        else if(ctx.block() != null) {
            BlockContext blockCtx = ctx.block();

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(blockCtx);
        }

        //an IF statement
        else if(isIFStatement(ctx)) {
            //Console.log("Par expression: " +ctx.parExpression().getText());

            StatementContext statementCtx = ctx.statement(0);

            //Console.log(LogType.DEBUG, "IF statement: " +statementCtx.getText());

            IfCommand ifCommand = new IfCommand(ctx.parExpression());
            StatementControlOverseer.getInstance().openConditionalCommand(ifCommand);

            StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
            statementAnalyzer.analyze(statementCtx);

            StatementControlOverseer.getInstance().reportExitPositiveRule();

            //check if there is an ELSE statement
            if(isELSEStatement(ctx)) {
                statementCtx = ctx.statement(1);

                //Console.log(LogType.DEBUG, "ELSE statement: " +statementCtx.getText());
                statementAnalyzer.analyze(statementCtx);
            }

            StatementControlOverseer.getInstance().compileControlledCommand();
        }

        else if(isWHILEStatement(ctx)) {
            //Console.log(LogType.DEBUG, "While par expression: " +ctx.parExpression().getText());
            txtWriter.writeMessage(StringUtils.formatDebug("While par expression: " +ctx.parExpression().getText()));
            StatementContext statementCtx = ctx.statement(0);

            WhileCommand whileCommand = new WhileCommand(ctx.parExpression());
            StatementControlOverseer.getInstance().openControlledCommand(whileCommand);

            StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
            statementAnalyzer.analyze(statementCtx);

            StatementControlOverseer.getInstance().compileControlledCommand();
            //Console.log(LogType.DEBUG, "End of WHILE expression: " +ctx.parExpression().getText());
            txtWriter.writeMessage(StringUtils.formatDebug("End of WHILE expression " +ctx.parExpression().getText()));
        }

        else if(isDOWHILEStatement(ctx)) {
            //Console.log(LogType.DEBUG, "Do while expression: " +ctx.parExpression().getText());
            txtWriter.writeMessage(StringUtils.formatDebug("Do while expression: " +ctx.parExpression().getText()));

            StatementContext statementCtx = ctx.statement(0);

            DoWhileCommand doWhileCommand = new DoWhileCommand(ctx.parExpression());
            StatementControlOverseer.getInstance().openControlledCommand(doWhileCommand);

            StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
            statementAnalyzer.analyze(statementCtx);

            StatementControlOverseer.getInstance().compileControlledCommand();
            //Console.log(LogType.DEBUG, "End of DO-WHILE expression: " +ctx.parExpression().getText());
            txtWriter.writeMessage(StringUtils.formatDebug("End of do-while: " +ctx.parExpression().getText()));
        }

        else if(isFORStatement(ctx)) {
            //Console.log(LogType.DEBUG, "FOR expression: " +ctx.forControl().getText());
            txtWriter.writeMessage(StringUtils.formatDebug("For expression: " +ctx.parExpression().getText()));
            LocalScopeCreator.getLocalScopeCreator().openLocalScope();

            ForControlAnalyzer forControlAnalyzer = new ForControlAnalyzer();
            forControlAnalyzer.analyze(ctx.forControl());

            ForCommand forCommand = new ForCommand(forControlAnalyzer.getLocalVarDecContext(), forControlAnalyzer.getExprContext(), forControlAnalyzer.getUpdateCommand());
            StatementControlOverseer.getInstance().openControlledCommand(forCommand);

            StatementContext statementCtx = ctx.statement(0);
            StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
            statementAnalyzer.analyze(statementCtx);

            StatementControlOverseer.getInstance().compileControlledCommand();

            LocalScopeCreator.getLocalScopeCreator().closeLocalScope();
            txtWriter.writeMessage(StringUtils.formatDebug("End of For loop"));
        }

        else if(isRETURNStatement(ctx) && ExecutionManager.getExecutionManager().isInFunctionExecution()) {
            //Console.log(LogType.DEBUG, "Detected return expression: " +ctx.expression(0).getText());
            txtWriter.writeMessage(StringUtils.formatDebug("Detected return expression " +ctx.expression().getText()));
            this.handleReturnStatement(ctx.expression());
        }
    }

    private void handlePrintStatement(StatementContext ctx) {
        PrintCommand printCommand = new PrintCommand(ctx.printStatement());
        SemanticUtils.addToConditionalCommand(printCommand);

    }

    private void handleScanStatement(StatementContext ctx) {
        ScanCommand scanCommand = new ScanCommand(ctx.expression().getText(), ctx.Identifier().getText());
        UndeclaredChecker.verifyVarOrConstForScan(ctx.Identifier().getText(), ctx);
        SemanticUtils.addToConditionalCommand(scanCommand);
    }

    private void handleReturnStatement(ExpressionContext exprCtx) {
        ReturnCommand returnCommand = new ReturnCommand(exprCtx, ExecutionManager.getExecutionManager().getCurrentFunction());
		/*
		 * Return commands supposedly stops a controlled or conditional command and returns back the control to the caller.
		 * Find a way to halt such commands if they are inside a controlled command.
		 */
        StatementControlOverseer statementControl = StatementControlOverseer.getInstance();

        if(statementControl.isInConditionalCommand()) {
            IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();

            if(statementControl.isInPositiveRule()) {
                conditionalCommand.addPositiveCommand(returnCommand);
            }
            else {
                String functionName = ExecutionManager.getExecutionManager().getCurrentFunction().getFunctionName();
                conditionalCommand.addNegativeCommand(returnCommand);
            }
        }

        else if(statementControl.isInControlledCommand()) {
            IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
            controlledCommand.addCommand(returnCommand);
        }
        else {
            ExecutionManager.getExecutionManager().addCommand(returnCommand);
        }

    }

    public static boolean isIFStatement(StatementContext ctx) {
        List<TerminalNode> tokenList = ctx.getTokens(MyJAVALexer.IF);

        return (tokenList.size() != 0);
    }

    public static boolean isELSEStatement(StatementContext ctx) {
        List<TerminalNode> tokenList = ctx.getTokens(MyJAVALexer.ELSE);

        return (tokenList.size() != 0);
    }

    public static boolean isWHILEStatement(StatementContext ctx) {
        List<TerminalNode> whileTokenList = ctx.getTokens(MyJAVALexer.WHILE);
        List<TerminalNode> doTokenList = ctx.getTokens(MyJAVALexer.DO);

        return (whileTokenList.size() != 0 && doTokenList.size() == 0);
    }

    public static boolean isDOWHILEStatement(StatementContext ctx) {
        List<TerminalNode> whileTokenList = ctx.getTokens(MyJAVALexer.WHILE);
        List<TerminalNode> doTokenList = ctx.getTokens(MyJAVALexer.DO);

        return (whileTokenList.size() != 0 && doTokenList.size() != 0);
    }

    public static boolean isFORStatement(StatementContext ctx) {
        List<TerminalNode> forTokenList = ctx.getTokens(MyJAVALexer.FOR);

        return (forTokenList.size() != 0);
    }

    public static boolean isRETURNStatement(StatementContext ctx) {
        List<TerminalNode> returnTokenList = ctx.getTokens(MyJAVALexer.RETURN);

        return (returnTokenList.size() != 0);
    }
}
