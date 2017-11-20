package myjava.semantics.analyzers;

import myjava.antlrgen.ITextWriter;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.controlled.*;
import myjava.execution.commands.simple.PrintCommand;
import myjava.execution.commands.simple.ReturnCommand;
import myjava.execution.commands.simple.ScanCommand;
import myjava.antlrgen.MyJAVALexer;
import myjava.antlrgen.MyJAVAParser.BlockContext;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.StatementContext;
import myjava.semantics.statements.StatementControlOverseer;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * A bridge for statement listener
 *
 */
public class StatementAnalyzer implements ITextWriter{

	public StatementAnalyzer() {
		
	}
	
	public void analyze(StatementContext ctx) {

		//print statement
		if(ctx.printStatement() != null) handlePrintStatement(ctx);
		else if(ctx.scanStatement() != null) handleScanStatement(ctx);
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

			StatementContext statementCtx = ctx.statement(0);

			IfCommand ifCommand = new IfCommand(ctx.parExpression());
			StatementControlOverseer.getInstance().openConditionalCommand(ifCommand);

			StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
			statementAnalyzer.analyze(statementCtx);

			StatementControlOverseer.getInstance().reportExitPositiveRule();

			//check if there is an ELSE statement
			if(isELSEStatement(ctx)) {
				statementCtx = ctx.statement(1);

				statementAnalyzer.analyze(statementCtx);
			}

			StatementControlOverseer.getInstance().compileControlledCommand();
		}

		else if(isWHILEStatement(ctx)) {
			txtWriter.writeMessage(StringUtils.formatDebug("While par expression: " +ctx.parExpression().getText()));

			StatementContext statementCtx = ctx.statement(0);

			WhileCommand whileCommand = new WhileCommand(ctx.parExpression());
			StatementControlOverseer.getInstance().openControlledCommand(whileCommand);

			StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
			statementAnalyzer.analyze(statementCtx);

			StatementControlOverseer.getInstance().compileControlledCommand();
			txtWriter.writeMessage(StringUtils.formatDebug("End of WHILE expression: " +ctx.parExpression().getText()));
		}

		else if(isDOWHILEStatement(ctx)) {
			txtWriter.writeMessage(StringUtils.formatDebug("Do while expression: " +ctx.parExpression().getText()));

			StatementContext statementCtx = ctx.statement(0);

			DoWhileCommand doWhileCommand = new DoWhileCommand(ctx.parExpression());
			StatementControlOverseer.getInstance().openControlledCommand(doWhileCommand);

			StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
			statementAnalyzer.analyze(statementCtx);

			StatementControlOverseer.getInstance().compileControlledCommand();
			txtWriter.writeMessage(StringUtils.formatDebug("End of DO-WHILE expression: " +ctx.parExpression().getText()));
		}

		else if(isFORStatement(ctx)) {
			txtWriter.writeMessage(StringUtils.formatDebug("FOR expression: " +ctx.forControl().getText()));

			LocalScopeCreator.getInstance().openLocalScope();

			ForControlAnalyzer forControlAnalyzer = new ForControlAnalyzer();
			forControlAnalyzer.analyze(ctx.forControl());

			ForCommand forCommand = new ForCommand(forControlAnalyzer.getLocalVarDecContext(), forControlAnalyzer.getExprContext(), forControlAnalyzer.getUpdateCommand());
			StatementControlOverseer.getInstance().openControlledCommand(forCommand);

			StatementContext statementCtx = ctx.statement(0);
			StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
			statementAnalyzer.analyze(statementCtx);

			StatementControlOverseer.getInstance().compileControlledCommand();

			LocalScopeCreator.getInstance().closeLocalScope();
			txtWriter.writeMessage(StringUtils.formatDebug("End of FOR loop"));
		}

		else if(isRETURNStatement(ctx) && ExecutionManager.getExecutionManager().isInFunctionExecution()) {
			txtWriter.writeMessage(StringUtils.formatDebug("Detected return expression: " +ctx.expression().getText()));
			handleReturnStatement(ctx.expression());
		}
	}
	
	private void handlePrintStatement(StatementContext ctx) {
		PrintCommand printCommand = new PrintCommand(ctx.expression());
		
		StatementControlOverseer statementControl = StatementControlOverseer.getInstance();
		//add to conditional controlled command
		if(statementControl.isInConditionalCommand()) {
			IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();
			
			if(statementControl.isInPositiveRule()) {
				conditionalCommand.addPositiveCommand(printCommand);
			}
			else {
				conditionalCommand.addNegativeCommand(printCommand);
			}
		}
		
		else if(statementControl.isInControlledCommand()) {
			IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
			controlledCommand.addCommand(printCommand);
		}
		else {
			ExecutionManager.getExecutionManager().addCommand(printCommand);
		}
		
	}
	
	private void handleScanStatement(StatementContext ctx) {
		ScanCommand scanCommand = new ScanCommand(ctx.expression().getText(), ctx.Identifier().getText()); // not sure if edited right
		UndeclaredChecker.verifyVarOrConstForScan(ctx.Identifier().getText(), ctx);
		
		StatementControlOverseer statementControl = StatementControlOverseer.getInstance();
		//add to conditional controlled command
		if(statementControl.isInConditionalCommand()) {
			IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();
			
			if(statementControl.isInPositiveRule()) {
				conditionalCommand.addPositiveCommand(scanCommand);
			}
			else {
				conditionalCommand.addNegativeCommand(scanCommand);
			}
		}
		
		else if(statementControl.isInControlledCommand()) {
			IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
			controlledCommand.addCommand(scanCommand);
		}
		else {
			ExecutionManager.getExecutionManager().addCommand(scanCommand);
		}
		
	}
	
	private void handleReturnStatement(ExpressionContext exprCtx) {
		ReturnCommand returnCommand = new ReturnCommand(exprCtx, ExecutionManager.getExecutionManager().getCurrentFunction());
		/*
		 * TODO: Return commands supposedly stops a controlled or conditional command and returns back the control to the caller.
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
