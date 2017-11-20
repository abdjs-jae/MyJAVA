/**
 * 
 */
package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.error.ParserHandler;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.StatementContext;
import myjava.ide.console.Console;
import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
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
public class UndeclaredChecker implements IErrorChecker, ParseTreeListener {
	private final static String TAG = "MyJAVAProg_UndeclaredChecker";
	
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public UndeclaredChecker(ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;
		
		Token firstToken = this.exprCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	/* (non-Javadoc)
	 * @see myjava.error.checkers.IErrorChecker#verify()
	 */
	@Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.exprCtx);
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
				this.verifyFunctionCall(exprCtx);
			}
			else if(EvaluationCommand.isVariableOrConst(exprCtx)) {
				this.verifyVariableOrConst(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyFunctionCall(ExpressionContext funcExprCtx) {
		
		ThisKeywordChecker thisChecker = new ThisKeywordChecker(funcExprCtx.expression(0));
		thisChecker.verify();
		
		if(funcExprCtx.expression(0).Identifier() == null)
			return;
		
		String functionName = funcExprCtx.expression(0).Identifier().getText();

		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
				ParserHandler.getInstance().getCurrentClassName());
		MyJAVAFunction myJAVAFunction = classScope.searchFunction(functionName);
		
		if(myJAVAFunction == null) {
			BuildChecker.reportCustomError(ErrorRepository.UNDECLARED_FUNCTION, "", functionName, this.lineNumber);
		}
		else {
			Console.log(LogType.DEBUG, "Function found: " +functionName);
		}
	}
	
	private void verifyVariableOrConst(ExpressionContext varExprCtx) {
		MyJAVAValue myJAVAValue = null;
		
		if(ExecutionManager.getInstance().isInFunctionExecution()) {
			MyJAVAFunction myJAVAFunction = ExecutionManager.getInstance().getCurrentFunction();
			myJAVAValue = VariableSearcher.searchVariableInFunction(myJAVAFunction, varExprCtx.primary().Identifier().getText());
		}
		
		//if after function finding, myJAVA value is still null, search class
		if(myJAVAValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			myJAVAValue = VariableSearcher.searchVariableInClassIncludingLocal(classScope, varExprCtx.primary().Identifier().getText());
		}
		
		//after second pass, we conclude if it cannot be found already
		if(myJAVAValue == null) {
			BuildChecker.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", varExprCtx.getText(), this.lineNumber);
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
			BuildChecker.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", identifier, firstToken.getLine());
		}
	}

}
