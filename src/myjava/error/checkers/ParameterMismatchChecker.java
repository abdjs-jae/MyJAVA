/**
 * 
 */
package myjava.error.checkers;

import myjava.error.MyJAVAErrorStrategy;
import myjava.antlrgen.MyJAVAParser.ArgumentsContext;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAFunction;

import java.util.List;

/**
 * Just checks if the number of parameters to be passed is equal to the required number

 *
 */
public class ParameterMismatchChecker implements IErrorChecker {
	
	private MyJAVAFunction myJAVAFunction;
	private List<ExpressionContext> exprCtxList;
	private int lineNumber;
	
	public ParameterMismatchChecker(MyJAVAFunction myJAVAFunction, ArgumentsContext argumentsCtx) {
		this.myJAVAFunction = myJAVAFunction;

		if(argumentsCtx.expressionList() != null) {
			exprCtxList = argumentsCtx.expressionList().expression();
		}
		
		lineNumber = argumentsCtx.getStart().getLine();
	}

	@Override
	public void verify() {
		if(myJAVAFunction == null) {
			return;
		}
		
		if(exprCtxList == null && myJAVAFunction.getParameterValueSize() != 0) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.PARAMETER_COUNT_MISMATCH, myJAVAFunction.getFunctionName(), lineNumber);
		}
		else if(exprCtxList != null && exprCtxList.size() != myJAVAFunction.getParameterValueSize()) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.PARAMETER_COUNT_MISMATCH, myJAVAFunction.getFunctionName(), lineNumber);
		}
	}

}
