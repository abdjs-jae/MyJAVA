package myjava.semantics.mapping;

import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.ParExpressionContext;
import myjava.semantics.representations.MobiValue;

public interface IValueMapper {

	public abstract void analyze(ExpressionContext exprCtx);
	public abstract void analyze(ParExpressionContext exprCtx);
	public abstract String getOriginalExp();
	public abstract String getModifiedExp();
	public abstract MobiValue getMobiValue();

}