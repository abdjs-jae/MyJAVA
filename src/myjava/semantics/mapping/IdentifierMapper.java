package myjava.semantics.mapping;

import myjava.execution.FunctionTracker; 
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAValue;

/**
 * An identifier mapper that delegates the behavior to a class or function mapper depending on the control flow of execution.
 * @author NeilDG
 *
 */
public class IdentifierMapper implements IValueMapper{

    private IValueMapper valueMapper;

    public IdentifierMapper(String originalExp) {
        if(FunctionTracker.getFunctionTracker().isInsideFunction()) {
            valueMapper = new FunctionIdentifierMapper(originalExp, FunctionTracker.getFunctionTracker().getLatestFunction());
        }
        else {
            valueMapper = new ClassIdentifierMapper(originalExp);
        }
    }

    @Override
    public void analyze(ExpressionContext exprContext) {
        valueMapper.analyze(exprContext);
    }

    @Override
    public void analyze(ParExpressionContext exprContext) {
        valueMapper.analyze(exprContext);
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
        return null;
    }

}