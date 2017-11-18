package myjava.semantics.mapping;
 
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAValue;

public interface IValueMapper {

    public abstract void analyze(ExpressionContext exprCtx);
    public abstract void analyze(ParExpressionContext exprCtx);
    public abstract String getOriginalExp();
    public abstract String getModifiedExp();
    public abstract MyJAVAValue getMyJAVAValue();

}