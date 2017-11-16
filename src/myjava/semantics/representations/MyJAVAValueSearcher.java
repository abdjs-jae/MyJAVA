package myjava.semantics.representations;

import myjava.execution.FunctionTracker;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

public class MyJAVAValueSearcher {

    public static MyJAVAValue searchMyJAVAValue(String identifier) {

        MyJAVAValue myJAVAValue = null;

        if(FunctionTracker.getFunctionTracker().isInsideFunction()) {
            MyJAVAFunction myJAVAFunction = FunctionTracker.getFunctionTracker().getLatestFunction();

            if(myJAVAFunction.hasParameter(identifier)) {
                myJAVAValue =  myJAVAFunction.getParameter(identifier);
            }
            else {
                myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifier, myJAVAFunction.getParentLocalScope());
            }
        }

        //if(myJAVAValue == null) {
        //}

        return myJAVAValue;

    }
}
