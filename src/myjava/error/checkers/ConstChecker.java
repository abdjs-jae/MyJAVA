package myjava.error.checkers;

import myjava.error.MyJAVAErrorStrategy;
import myjava.error.ParserHandler;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.analyzers.LocalVariableAnalyzer;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ConstChecker implements IErrorChecker, ParseTreeListener {

	private ExpressionContext exprCtx;
	private int lineNumber;

	public ConstChecker(ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;

		lineNumber = exprCtx.getStart().getLine();
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
			if(EvaluationCommand.isVariableOrConst(exprCtx)) {
				verifyVariableOrConst(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	private void verifyVariableOrConst(ExpressionContext varExprCtx) {
		MyJAVAValue myJAVAValue = null;

		if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
			MyJAVAFunction myJAVAFunction = ExecutionManager.getExecutionManager().getCurrentFunction();
			myJAVAValue = VariableSearcher.searchVariableInFunction(myJAVAFunction, varExprCtx.getText());
		}

		//if after function finding, myJAVA value is still null, search class
		if(myJAVAValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			myJAVAValue = VariableSearcher.searchVariableInClassIncludingLocal(classScope, varExprCtx.getText());
			if(LocalVariableAnalyzer.currentlyConst){
				myJAVAValue.markFinal();
			}
		}

		if(myJAVAValue != null && myJAVAValue.isFinal()) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.CONST_REASSIGNMENT, varExprCtx.getText(), lineNumber);
		}
	}

}