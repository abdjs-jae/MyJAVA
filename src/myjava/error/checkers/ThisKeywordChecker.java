/**
 * 
 */
package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.generatedexp.JavaParser.ExpressionContext;

/**

 *
 */
public class ThisKeywordChecker implements IErrorChecker {
	private final static String TAG = "ThisKeywordChecker";
	
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public ThisKeywordChecker(ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;
		this.lineNumber = this.exprCtx.getStart().getLine();
	}
	
	/* (non-Javadoc)
	 * @see myjava.error.checkers.IErrorChecker#verify()
	 */
	@Override
	public void verify() {
		if(exprCtx.Identifier() == null && this.exprCtx.primary() == null) {
			BuildChecker.reportCustomError(ErrorRepository.MISSING_THIS_KEYWORD, "", this.exprCtx.getText(), this.lineNumber);
		}
	}

}
