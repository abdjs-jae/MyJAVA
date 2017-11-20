package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.error.ParserHandler;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
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

public class ConstChecker implements IErrorChecker, ParseTreeListener {
	private final static String TAG = "MyJAVAProg_ConstChecker";
	
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public ConstChecker(ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;
		
		Token firstToken = this.exprCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
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
			if(EvaluationCommand.isVariableOrConst(exprCtx)) {
				this.verifyVariableOrConst(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
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
		
		if(myJAVAValue != null && myJAVAValue.isFinal()) {
			BuildChecker.reportCustomError(ErrorRepository.CONST_REASSIGNMENT, "", varExprCtx.getText(), this.lineNumber);
		}
	}

}
