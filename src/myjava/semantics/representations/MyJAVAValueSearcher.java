package myjava.semantics.representations;

import myjava.error.ParserHandler;
import myjava.execution.FunctionTracker;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

/**
 * A component that searches for the corresponding myJAVA value.
 * If it is in a function, it looks in the function parameters and local scope first before the global scope.
 * TODO: Can be expanded to properly search for a value if OOP is implemented.

 *
 */
public class MyJAVAValueSearcher {

	public static MyJAVAValue searchMyJAVAValue(String identifier) {
		
		MyJAVAValue myJAVAValue = null;
		
		if(FunctionTracker.getInstance().isInsideFunction()) {
			MyJAVAFunction myJAVAFunction = FunctionTracker.getInstance().getLatestFunction();
			
			if(myJAVAFunction.hasParameter(identifier)) {
				myJAVAValue =  myJAVAFunction.getParameter(identifier);
			}
			else {
				myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifier, myJAVAFunction.getParentLocalScope());
			}
		}
		
		if(myJAVAValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			myJAVAValue = classScope.searchVariableIncludingLocal(identifier);
		}
		
		return myJAVAValue;
		
	}
}
