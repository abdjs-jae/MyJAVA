package myjava.semantics.searcher;

import myjava.execution.FunctionTracker;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

public class VariableSearcher {

    public static MyJAVAValue searchVariable(String identifierString) {
        MyJAVAValue myJAVAValue = null;

        // Checks if variable is inside a function
        if(FunctionTracker.getFunctionTracker().isInsideFunction()) {
            myJAVAValue = searchVariableInFunction(FunctionTracker.getFunctionTracker().getLatestFunction(), identifierString);
        }

        // Checks if variable is inside locally
        if(myJAVAValue == null) {
            LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
            myJAVAValue = searchVariableLocal(localScope, identifierString);
        }

        return myJAVAValue;
    }

    public static MyJAVAValue searchVariableInFunction(MyJAVAFunction myJAVAFunction, String identifierString) {

        if(myJAVAFunction.hasParameter(identifierString)) {
            return myJAVAFunction.getParameter(identifierString);
        }
        else {
            return LocalScopeCreator.searchVariableInLocalIterative(identifierString, myJAVAFunction.getParentLocalScope());
        }

    }

    public static MyJAVAValue searchVariableLocal(LocalScope localScope, String identifierString) {
        return localScope.searchVariableIncludingLocal(identifierString);
    }
}
