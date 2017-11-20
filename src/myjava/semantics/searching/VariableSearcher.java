/**
 * 
 */
package myjava.semantics.searching;

import myjava.error.ParserHandler;
import myjava.execution.FunctionTracker;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

/**
 * A utility class to search for a certain variable depending on where the control flow is.

 *
 */
public class VariableSearcher {
	private final static String TAG = "VariableSearcher";
	
	public static MyJAVAValue searchVariable(String identifierString) {
		MyJAVAValue myJAVAValue = null;
		
		if(FunctionTracker.getInstance().isInsideFunction()) {
			myJAVAValue = searchVariableInFunction(FunctionTracker.getInstance().getLatestFunction(), identifierString);
		}
		
		if(myJAVAValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			myJAVAValue = searchVariableInClassIncludingLocal(classScope, identifierString);
		}
		
		return myJAVAValue;
	}
	
	public static MyJAVAValue searchVariableInFunction(MyJAVAFunction myJAVAFunction, String identifierString) {
		MyJAVAValue myJAVAValue = null;
		
		if(myJAVAFunction.hasParameter(identifierString)) {
			myJAVAValue = myJAVAFunction.getParameter(identifierString);
		}
		else {
			myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, myJAVAFunction.getParentLocalScope());
		}
		
		return myJAVAValue;
	}
	
	public static MyJAVAValue searchVariableInClassIncludingLocal(ClassScope classScope, String identifierString) {
		return classScope.searchVariableIncludingLocal(identifierString);
	}
	
	public static MyJAVAValue searchVariableInClass(ClassScope classScope, String identifierString) {
		return classScope.searchVariable(identifierString);
	}
	
}
