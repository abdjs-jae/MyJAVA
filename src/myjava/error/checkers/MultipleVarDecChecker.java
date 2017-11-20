package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.error.MyJAVAErrorStrategy;
import myjava.error.ParserHandler;
import myjava.execution.ExecutionManager;
import myjava.generatedexp.JavaParser.VariableDeclaratorIdContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Checks for multiple declarations of variables.
 *
 */
public class MultipleVarDecChecker implements IErrorChecker, ParseTreeListener {
	private final static String TAG = "MyJAVAProg_MultipleVarDecChecker";
	
	private VariableDeclaratorIdContext varDecIdCtx;
	private int lineNumber;
	
	public MultipleVarDecChecker(VariableDeclaratorIdContext varDecIdCtx) {
		this.varDecIdCtx = varDecIdCtx;
		
		Token firstToken = this.varDecIdCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	/* (non-Javadoc)
	 * @see myjava.error.checkers.IErrorChecker#verify()
	 */
	@Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.varDecIdCtx);
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
		if(ctx instanceof VariableDeclaratorIdContext) {
			VariableDeclaratorIdContext varDecCtx = (VariableDeclaratorIdContext) ctx;
			this.verifyVariableOrConst(varDecCtx.getText());
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyVariableOrConst(String identifierString) {
		MyJAVAValue myJAVAValue = null;
		
		if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
			MyJAVAFunction myJAVAFunction = ExecutionManager.getExecutionManager().getCurrentFunction();
			myJAVAValue = VariableSearcher.searchVariableInFunction(myJAVAFunction, identifierString);
		}
		
		//if after function finding, myJAVA value is still null, search local scope
		if(myJAVAValue == null) {
			myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, LocalScopeCreator.getInstance().getActiveLocalScope());
		}
		
		//if myJAVA value is still null, search class
		if(myJAVAValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			myJAVAValue = VariableSearcher.searchVariableInClass(classScope, identifierString);
		}
		
		
		if(myJAVAValue != null) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.MULTIPLE_VARIABLE, identifierString, this.lineNumber);
		}
	}
	

}
