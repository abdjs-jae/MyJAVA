/**
 * 
 */
package myjava.execution.commands.simple;

import myjava.error.ParserHandler;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.analyzers.FunctionCallVerifier;
import myjava.semantics.representations.MobiFunction;
import myjava.semantics.representations.MobiValue;
import myjava.semantics.representations.MobiValue.PrimitiveType;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

/**
 * Represents a function call command
 *
 *
 */
public class FunctionCallCommand implements ICommand {
	private final static String TAG = "MobiProg_FunctionCallCommand";
	
	private MobiFunction mobiFunction;
	private ExpressionContext exprCtx;
	private String functionName;
	
	public FunctionCallCommand(String functionName, ExpressionContext exprCtx) {
		this.functionName = functionName;
		this.exprCtx = exprCtx;
		
		this.searchFunction();
		
		ParseTreeWalker functionWalker = new ParseTreeWalker();
		functionWalker.walk(new FunctionCallVerifier(), this.exprCtx);
		
		this.verifyParameters();
	}
	
	/* (non-Javadoc)
	 * @see myjava.execution.commands.ICommand#execute()
	 */
	@Override
	public void execute() {
		this.mapParameters();
		this.mobiFunction.execute();
	}
	
	private void searchFunction() {
		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
		this.mobiFunction = classScope.searchFunction(this.functionName);
	}
	
	private void verifyParameters() {
		if(this.exprCtx.arguments() == null || this.exprCtx.arguments().expressionList() == null
				|| this.exprCtx.arguments().expressionList().expression() == null) {
			return;
		}
		
		List<ExpressionContext> exprCtxList = this.exprCtx.arguments().expressionList().expression();
		//map values in parameters
		for(int i = 0; i < exprCtxList.size(); i++) {
			ExpressionContext parameterExprCtx = exprCtxList.get(i);
			this.mobiFunction.verifyParameterByValueAt(parameterExprCtx, i);
		}	
	}
	
	/*
	 * Maps parameters when needed
	 */
	private void mapParameters() {
		if(this.exprCtx.arguments() == null || this.exprCtx.arguments().expressionList() == null
				|| this.exprCtx.arguments().expressionList().expression() == null) {
			return;
		}
		
		List<ExpressionContext> exprCtxList = this.exprCtx.arguments().expressionList().expression();
		
		//map values in parameters
		for(int i = 0; i < exprCtxList.size(); i++) {
			ExpressionContext parameterExprCtx = exprCtxList.get(i);
			
			if(this.mobiFunction.getParameterAt(i).getPrimitiveType() == PrimitiveType.ARRAY) {
				MobiValue mobiValue = VariableSearcher.searchVariable(parameterExprCtx.getText());
				this.mobiFunction.mapArrayAt(mobiValue, i, parameterExprCtx.getText());
			}
			else {
				EvaluationCommand evaluationCommand = new EvaluationCommand(parameterExprCtx);
				evaluationCommand.execute();
				
				this.mobiFunction.mapParameterByValueAt(evaluationCommand.getResult().toEngineeringString(), i);
			}
		}	
	}
	
	public MobiValue getReturnValue() {
		return this.mobiFunction.getReturnValue();
	}

}
