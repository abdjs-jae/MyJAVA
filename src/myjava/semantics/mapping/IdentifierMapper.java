package myjava.semantics.mapping;

import myjava.execution.FunctionTracker;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.ParExpressionContext;
import myjava.semantics.representations.MyJAVAValue;

/**
 * An identifier mapper that delegates the behavior to a class or function mapper depending on the control flow of execution.
 *
 */
public class IdentifierMapper implements IValueMapper{
	
	private IValueMapper valueMapper;
	
	public IdentifierMapper(String originalExp) {
		if(FunctionTracker.getInstance().isInsideFunction()) {
			valueMapper = new FunctionIdentifierMapper(originalExp, FunctionTracker.getInstance().getLatestFunction());
		}
		else {
			valueMapper = new ClassIdentifierMapper(originalExp);
		}
	}

	@Override
	public void analyze(ExpressionContext exprCtx) {
		valueMapper.analyze(exprCtx);
	}

	@Override
	public void analyze(ParExpressionContext exprCtx) {
		valueMapper.analyze(exprCtx);
	}

	@Override
	public String getOriginalExp() {
		return valueMapper.getOriginalExp();
	}

	@Override
	public String getModifiedExp() {
		return valueMapper.getModifiedExp();
	}

	@Override
	public MyJAVAValue getMyJAVAValue() {
		return valueMapper.getMyJAVAValue();
	}
}
