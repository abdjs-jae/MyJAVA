/**
 * 
 */
package myjava.semantics.mapping;

import myjava.execution.FunctionTracker;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.ParExpressionContext;
import myjava.semantics.representations.MyJAVAValue;

/**
 * An identifier mapper that delegates the behavior to a class or function mapper depending on the control flow of execution.

 *
 */
public class IdentifierMapper implements IValueMapper{
	private final static String TAG = "MyJAVAProg_IdentifierMapper";
	
	private IValueMapper valueMapper;
	
	public IdentifierMapper(String originalExp) {
		if(FunctionTracker.getInstance().isInsideFunction()) {
			this.valueMapper = new FunctionIdentifierMapper(originalExp, FunctionTracker.getInstance().getLatestFunction());
		}
		else {
			this.valueMapper = new ClassIdentifierMapper(originalExp);
		}
	}

	@Override
	public void analyze(ExpressionContext exprCtx) {
		this.valueMapper.analyze(exprCtx);
	}

	@Override
	public void analyze(ParExpressionContext exprCtx) {
		this.valueMapper.analyze(exprCtx);
	}

	@Override
	public String getOriginalExp() {
		return this.valueMapper.getOriginalExp();
	}

	@Override
	public String getModifiedExp() {
		return this.valueMapper.getModifiedExp();
	}

	@Override
	public MyJAVAValue getMyJAVAValue() {
		return this.valueMapper.getMyJAVAValue();
	}
}
