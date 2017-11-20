/**
 * 
 */
package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.generatedexp.JavaParser.ArgumentsContext;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAFunction;

import java.util.List;

/**
 * Just checks if the number of parameters to be passed is equal to the required number

 *
 */
public class ParameterMismatchChecker implements IErrorChecker {
	private final static String TAG = "MyJAVAProg_ParameterMismatchChecker";
	
	private MyJAVAFunction myJAVAFunction;
	private List<ExpressionContext> exprCtxList;
	private int lineNumber;
	
	public ParameterMismatchChecker(MyJAVAFunction myJAVAFunction, ArgumentsContext argumentsCtx) {
		this.myJAVAFunction = myJAVAFunction;

		if(argumentsCtx.expressionList() != null) {
			this.exprCtxList = argumentsCtx.expressionList().expression();
		}
		
		this.lineNumber = argumentsCtx.getStart().getLine();
	}
	
	/* (non-Javadoc)
	 * @see myjava.error.checkers.IErrorChecker#verify()
	 */
	@Override
	public void verify() {
		if(this.myJAVAFunction == null) {
			return;
		}
		
		if(this.exprCtxList == null && this.myJAVAFunction.getParameterValueSize() != 0) {
			BuildChecker.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.myJAVAFunction.getFunctionName(), this.lineNumber);
		}
		else if(this.exprCtxList != null && this.exprCtxList.size() != this.myJAVAFunction.getParameterValueSize()) {
			BuildChecker.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.myJAVAFunction.getFunctionName(), this.lineNumber);
		}
	}

}
