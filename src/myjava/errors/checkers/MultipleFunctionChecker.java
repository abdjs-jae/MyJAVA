package myjava.errors.checkers;

import myjava.MyJAVAParser.*;
import myjava.errors.MyJAVAErrorStrategy;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

public class MultipleFunctionChecker implements IChecker {
    
    private MethodDeclarationContext methodDecContext;
    private int lineNum;

    public MultipleFunctionChecker (MethodDeclarationContext methodDecContext) {
        this.methodDecContext = methodDecContext;
        lineNum = methodDecContext.getStart().getLine();
    }

    @Override
    public void check() {
        this.verifyFunctionCall(this.methodDecContext.Identifier().getText());
    }

    private void verifyFunctionCall(String identifierString) {

        // Get the localScope
        LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
        MyJAVAFunction myJAVAFunction = localScope.searchFunction(identifierString);

        if(myJAVAFunction != null) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.MULTIPLE_FUNCTION, identifierString, lineNum);
        }
    }
    
}
