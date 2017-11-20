package myjava.semantics.analyzing;

import java.util.List;

import myjava.semantics.SemanticUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluate.AssignmentCommand;
import myjava.execution.commands.basic.FunctionCallCommand;
import myjava.execution.commands.basic.IntDecCommand;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser.*;

/**
 * Analyzes a given expression on the statement level.
 * This does not include field declaration analysis.
 * @author NeilDG
 *
 */
public class StatementExpressionAnalyzer implements ParseTreeListener {

    private ExpressionContext readRightHandExprCtx; //used to avoid mistakenly reading right hand expressions as direct function calls as well.

    //TODO: find a way to not rely on tree depth for function calls.
    public final static int FUNCTION_CALL_NO_PARAMS_DEPTH = 13;
    public final static int FUNCTION_CALL_WITH_PARAMS_DEPTH = 14;

    public StatementExpressionAnalyzer() {

    }

    public void analyze(StatementExpressionContext statementExprCtx) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, statementExprCtx);
    }

    public void analyze(ExpressionContext exprCtx) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprCtx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof ExpressionContext) {
            ExpressionContext exprCtx = (ExpressionContext) ctx;

            if(isAssignmentExpression(exprCtx)) {
                //Console.log(LogType.DEBUG, "Assignment expr detected: " +exprCtx.getText());

                List<ExpressionContext> exprListCtx = exprCtx.expression();
                AssignmentCommand assignmentCommand = new AssignmentCommand(exprListCtx.get(0), exprListCtx.get(1));

                this.readRightHandExprCtx = exprListCtx.get(1);
                this.handleStatementExecution(assignmentCommand);

            }
            else if(isIncrementExpression(exprCtx)) {
                //Console.log(LogType.DEBUG, "Increment expr detected: " +exprCtx.getText());

                List<ExpressionContext> exprListCtx = exprCtx.expression();

                IntDecCommand incDecCommand = new IntDecCommand(exprListCtx.get(0) ,MyJAVALexer.INC);
                this.handleStatementExecution(incDecCommand);
            }

            else if(isDecrementExpression(exprCtx)) {
                //Console.log(LogType.DEBUG, "Decrement expr detected: " +exprCtx.getText());

                List<ExpressionContext> exprListCtx = exprCtx.expression();

                IntDecCommand incDecCommand = new IntDecCommand(exprListCtx.get(0) ,MyJAVALexer.DEC);
                this.handleStatementExecution(incDecCommand);

            }

            else if(this.isFunctionCallWithParams(exprCtx)) {
                this.handleFunctionCallWithParams(exprCtx);
            }

            else if(this.isFunctionCallWithNoParams(exprCtx)) {
                this.handleFunctionCallWithNoParams(exprCtx);
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void handleStatementExecution(ICommand command) {
        SemanticUtils.addToConditionalCommand(command);
    }

    private void handleFunctionCallWithParams(ExpressionContext funcExprCtx) {
        ExpressionContext functionExprCtx = funcExprCtx.expression(0);
        String functionName = functionExprCtx.Identifier().getText();

        FunctionCallCommand functionCallCommand = new FunctionCallCommand(functionName, funcExprCtx);
        this.handleStatementExecution(functionCallCommand);

        //Console.log(LogType.DEBUG, "Function call with params detected: " +functionName);
    }

    private void handleFunctionCallWithNoParams(ExpressionContext funcExprCtx) {
        String functionName = funcExprCtx.Identifier().getText();

        FunctionCallCommand functionCallCommand = new FunctionCallCommand(functionName, funcExprCtx);
        this.handleStatementExecution(functionCallCommand);

        //Console.log(LogType.DEBUG, "Function call with no params detected: " +functionName);
    }

    public static boolean isAssignmentExpression(ExpressionContext exprCtx) {
        List<TerminalNode> tokenList = exprCtx.getTokens(MyJAVALexer.ASSIGN);
        return (tokenList.size() > 0);
    }

    public static boolean isIncrementExpression(ExpressionContext exprCtx) {
        List<TerminalNode> incrementList = exprCtx.getTokens(MyJAVALexer.INC);

        return (incrementList.size() > 0);
    }

    public static boolean isDecrementExpression(ExpressionContext exprCtx) {
        List<TerminalNode> decrementList = exprCtx.getTokens(MyJAVALexer.DEC);

        return (decrementList.size() > 0);
    }

    private boolean isFunctionCallWithParams(ExpressionContext exprCtx) {
        ExpressionContext firstExprCtx = exprCtx.expression(0);

        if(firstExprCtx != null) {
            if(exprCtx != this.readRightHandExprCtx) {
                return (firstExprCtx.Identifier() != null);
            }
        }

        return false;

    }

    private boolean isFunctionCallWithNoParams(ExpressionContext exprCtx) {
        if(exprCtx.depth() == FUNCTION_CALL_NO_PARAMS_DEPTH) {
            if(exprCtx.Identifier() != null)
                return true;
        }

        return false;
    }
}