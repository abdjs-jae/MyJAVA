package myjava.semantics.mapping;

import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.ParExpressionContext;
import myjava.semantics.representations.MyJAVAValue;

public interface IValueMapper {

	void analyze(ExpressionContext exprCtx);
	void analyze(ParExpressionContext exprCtx);
	String getOriginalExp();
	String getModifiedExp();
	MyJAVAValue getMyJAVAValue();

}