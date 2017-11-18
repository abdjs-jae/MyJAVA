package myjava.errors.checkers;

import myjava.MyJAVAParser.*;
import myjava.errors.MyJAVAErrorStrategy;
import myjava.semantics.representations.MyJAVAFunction;

import java.util.List;

public class ParameterMismatchChecker implements IChecker{
    private MyJAVAFunction myJAVAFunction;
    private List<ExpressionContext> exprContextList;
    private int lineNum;

    public ParameterMismatchChecker(MyJAVAFunction myJAVAFunction, ArgumentsContext argumentsContext) {
        this.myJAVAFunction = myJAVAFunction;

        if(argumentsContext.expressionList() != null) {
            this.exprContextList = argumentsContext.expressionList().expression();
        }

        lineNum = argumentsContext.getStart().getLine();
    }
    
    @Override
    public void check() {
        if(this.myJAVAFunction == null) {
            return;
        }
        if(this.exprContextList == null && this.myJAVAFunction.getParameterValueSize() != 0) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.PARAMETER_COUNT_MISMATCH,
                    myJAVAFunction.getFunctionName(), lineNum);
        }
        else if(this.exprContextList != null && this.exprContextList.size() != this.myJAVAFunction.getParameterValueSize()) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.PARAMETER_COUNT_MISMATCH,
                    myJAVAFunction.getFunctionName(), lineNum);
        }
    }
}
