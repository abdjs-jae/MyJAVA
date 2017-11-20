/**
 * 
 */
package myjava.error.checkers;

import myjava.antlrgen.ITextWriter;
import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.error.MyJAVAErrorStrategy;
import myjava.error.ParserHandler;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.StatementContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Checker for undeclared variables and function

 *
 */
public class UndeclaredChecker implements ITextWriter, IErrorChecker, ParseTreeListener {
	
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public UndeclaredChecker(ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;
		this.lineNumber = this.exprCtx.getStart().getLine();
	}

	@Override
	public void verify() {
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
			if(EvaluationCommand.isFunctionCall(exprCtx)) {
				verifyFunctionCall(exprCtx);
			}
			else if(EvaluationCommand.isVariableOrConst(exprCtx)) {
				verifyVariableOrConst(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyFunctionCall(ExpressionContext funcExprCtx) {
		
		if(funcExprCtx.expression(0).Identifier() == null)
			return;
		
		String functionName = funcExprCtx.expression(0).Identifier().getText();

		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
				ParserHandler.getInstance().getCurrentClassName());
		MyJAVAFunction myJAVAFunction = classScope.searchFunction(functionName);
		
		if(myJAVAFunction == null) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.UNDECLARED_FUNCTION, functionName, lineNumber);
		}
		else {
			txtWriter.writeMessage(StringUtils.formatDebug("Function found: " +functionName));
		}
	}
	
	private void verifyVariableOrConst(ExpressionContext varExprCtx) {
		MyJAVAValue myJAVAValue = null;
		
		if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
			MyJAVAFunction myJAVAFunction = ExecutionManager.getExecutionManager().getCurrentFunction();
			myJAVAValue = VariableSearcher.searchVariableInFunction(myJAVAFunction, varExprCtx.primary().Identifier().getText());
		}
		
		//if after function finding, myJAVA value is still null, search class
		if(myJAVAValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			myJAVAValue = VariableSearcher.searchVariableInClassIncludingLocal(classScope, varExprCtx.primary().Identifier().getText());
		}
		
		//after second pass, we conclude if it cannot be found already
		if(myJAVAValue == null) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.UNDECLARED_VARIABLE, varExprCtx.getText(), lineNumber);
		}
	}
	
	/*
	 * Verifies a var or const identifier from a scan statement since scan grammar is different.
	 */
	public static void verifyVarOrConstForScan(String identifier, StatementContext statementCtx) {
		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
		MyJAVAValue myJAVAValue = VariableSearcher.searchVariableInClassIncludingLocal(classScope, identifier);
		
		Token firstToken = statementCtx.getStart();
		
		if(myJAVAValue == null) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.UNDECLARED_VARIABLE, identifier, firstToken.getLine());
		}
	}

}
