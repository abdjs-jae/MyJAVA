package myjava.semantics.mapping;

import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.ParExpressionContext;
import myjava.semantics.representations.MyJAVAValue;

public interface IValueMapper {

	void analyze(ExpressionContext exprCtx);
	void analyze(ParExpressionContext exprCtx);
	String getOriginalExp();
	String getModifiedExp();
	MyJAVAValue getMyJAVAValue();

}