package myjava.semantics.analyzers;

import myjava.error.MyJAVAErrorStrategy;
import myjava.error.checkers.ConstChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IConditionalCommand;
import myjava.execution.commands.controlled.IControlledCommand;
import myjava.execution.commands.evaluation.AssignmentCommand;
import myjava.execution.commands.simple.FunctionCallCommand;
import myjava.execution.commands.simple.IncDecCommand;
import myjava.antlrgen.MyJAVALexer;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.StatementExpressionContext;
import myjava.semantics.statements.StatementControlOverseer;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * Analyzes a given expression on the statement level.
 * This does not include field declaration analysis.
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
				ExecutionManager.getExecutionManager().consoleListModel.addElement(StringUtils.formatDebug("Assignment expr detected: " +exprCtx.getText()));
				
				List<ExpressionContext> exprListCtx = exprCtx.expression();
				AssignmentCommand assignmentCommand = new AssignmentCommand(exprListCtx.get(0), exprListCtx.get(1));
				
				readRightHandExprCtx = exprListCtx.get(1);
				handleStatementExecution(assignmentCommand);
				
			}
			else if(isIncrementExpression(exprCtx)) {
				ExecutionManager.getExecutionManager().consoleListModel.addElement(StringUtils.formatDebug("Increment expr detected: " +exprCtx.getText()));

				List<ExpressionContext> exprListCtx = exprCtx.expression();
				if(!ConstChecker.isConstFormat(exprListCtx.get(0))) {
					IncDecCommand incDecCommand = new IncDecCommand(exprListCtx.get(0), MyJAVALexer.INC);
					handleStatementExecution(incDecCommand);
				} else {
					MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.CONST_INTDEC,
							exprListCtx.get(0).getText(), exprListCtx.get(0).getStart().getLine());
				}
			}

			else if(isDecrementExpression(exprCtx)) {
				ExecutionManager.getExecutionManager().consoleListModel.addElement(StringUtils.formatDebug("Decrement expr detected: " +exprCtx.getText()));

				List<ExpressionContext> exprListCtx = exprCtx.expression();
				if(!ConstChecker.isConstFormat(exprListCtx.get(0))) {
					IncDecCommand incDecCommand = new IncDecCommand(exprListCtx.get(0), MyJAVALexer.DEC);
					handleStatementExecution(incDecCommand);
				} else {
					MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.CONST_INTDEC,
							exprListCtx.get(0).getText(), exprListCtx.get(0).getStart().getLine());
				}
			}
			
			else if(isFunctionCallWithParams(exprCtx)) {
				handleFunctionCallWithParams(exprCtx);
			}
			
			else if(isFunctionCallWithNoParams(exprCtx)) {
				handleFunctionCallWithNoParams(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void handleStatementExecution(ICommand command) {
		
		StatementControlOverseer statementControl = StatementControlOverseer.getInstance();
		
		//add to conditional controlled command
		if(statementControl.isInConditionalCommand()) {
			IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();
			
			if(statementControl.isInPositiveRule()) {
				conditionalCommand.addPositiveCommand(command);
			}
			else {
				conditionalCommand.addNegativeCommand(command);
			}
		}
		
		else if(statementControl.isInControlledCommand()) {
			IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
			controlledCommand.addCommand(command);
		}
		else {
			ExecutionManager.getExecutionManager().addCommand(command);
		}
		
	}
	
	private void handleFunctionCallWithParams(ExpressionContext funcExprCtx) {
		ExpressionContext functionExprCtx = funcExprCtx.expression(0);
		String functionName = functionExprCtx.Identifier().getText();
		
		FunctionCallCommand functionCallCommand = new FunctionCallCommand(functionName, funcExprCtx);
		this.handleStatementExecution(functionCallCommand);

		ExecutionManager.getExecutionManager().consoleListModel.addElement(StringUtils.formatDebug("Function call with params detected: " +functionName));
	}
	
	private void handleFunctionCallWithNoParams(ExpressionContext funcExprCtx) {
		String functionName = funcExprCtx.Identifier().getText();
		
		FunctionCallCommand functionCallCommand = new FunctionCallCommand(functionName, funcExprCtx);
		this.handleStatementExecution(functionCallCommand);

		ExecutionManager.getExecutionManager().consoleListModel.addElement(StringUtils.formatDebug("Function call with no params detected: " +functionName));
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
