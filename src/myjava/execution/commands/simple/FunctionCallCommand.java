package myjava.execution.commands.simple;

import myjava.error.ParserHandler;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.analyzers.FunctionCallVerifier;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

/**
 * Represents a function call command
 *
 */
public class FunctionCallCommand implements ICommand {
	
	private MyJAVAFunction myJAVAFunction;
	private ExpressionContext exprCtx;
	private String functionName;
	
	public FunctionCallCommand(String functionName, ExpressionContext exprCtx) {
		this.functionName = functionName;
		this.exprCtx = exprCtx;
		
		searchFunction();
		
		ParseTreeWalker functionWalker = new ParseTreeWalker();
		functionWalker.walk(new FunctionCallVerifier(), this.exprCtx);
		
		verifyParameters();
	}

	@Override
	public void execute() {
		mapParameters();
		myJAVAFunction.execute();
	}
	
	private void searchFunction() {
		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
		myJAVAFunction = classScope.searchFunction(functionName);
	}
	
	private void verifyParameters() {
		if(exprCtx.arguments() == null || exprCtx.arguments().expressionList() == null
				|| exprCtx.arguments().expressionList().expression() == null) {
			return;
		}
		
		List<ExpressionContext> exprCtxList = exprCtx.arguments().expressionList().expression();
		//map values in parameters
		for(int i = 0; i < exprCtxList.size(); i++) {
			ExpressionContext parameterExprCtx = exprCtxList.get(i);
			myJAVAFunction.verifyParameterByValueAt(parameterExprCtx, i);
		}	
	}
	
	/*
	 * Maps parameters when needed
	 */
	private void mapParameters() {
		if(exprCtx.arguments() == null || exprCtx.arguments().expressionList() == null
				|| exprCtx.arguments().expressionList().expression() == null) {
			return;
		}
		
		List<ExpressionContext> exprCtxList = exprCtx.arguments().expressionList().expression();
		
		//map values in parameters
		for(int i = 0; i < exprCtxList.size(); i++) {
			ExpressionContext parameterExprCtx = exprCtxList.get(i);
			
			if(this.myJAVAFunction.getParameterAt(i).getPrimitiveType() == PrimitiveType.ARRAY) {
				MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(parameterExprCtx.getText());
				myJAVAFunction.mapArrayAt(myJAVAValue, i, parameterExprCtx.getText());
			}
			else {
				EvaluationCommand evaluationCommand = new EvaluationCommand(parameterExprCtx);
				evaluationCommand.execute();
				
				myJAVAFunction.mapParameterByValueAt(evaluationCommand.getResult().toEngineeringString(), i);
			}
		}	
	}
	
	public MyJAVAValue getReturnValue() {
		return myJAVAFunction.getReturnValue();
	}

}
