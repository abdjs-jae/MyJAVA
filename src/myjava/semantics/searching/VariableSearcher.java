/**
 * 
 */
package myjava.semantics.searching;

import myjava.error.ParserHandler;
import myjava.execution.FunctionTracker;
import myjava.semantics.representations.MobiFunction;
import myjava.semantics.representations.MobiValue;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

/**
 * A utility class to search for a certain variable depending on where the control flow is.
 *
 *
 */
public class VariableSearcher {
	private final static String TAG = "VariableSearcher";
	
	public static MobiValue searchVariable(String identifierString) {
		MobiValue mobiValue = null;
		
		if(FunctionTracker.getInstance().isInsideFunction()) {
			mobiValue = searchVariableInFunction(FunctionTracker.getInstance().getLatestFunction(), identifierString);
		}
		
		if(mobiValue == null) {
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			mobiValue = searchVariableInClassIncludingLocal(classScope, identifierString);
		}
		
		return mobiValue;
	}
	
	public static MobiValue searchVariableInFunction(MobiFunction mobiFunction, String identifierString) {
		MobiValue mobiValue = null;
		
		if(mobiFunction.hasParameter(identifierString)) {
			mobiValue = mobiFunction.getParameter(identifierString);
		}
		else {
			mobiValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, mobiFunction.getParentLocalScope());
		}
		
		return mobiValue;
	}
	
	public static MobiValue searchVariableInClassIncludingLocal(ClassScope classScope, String identifierString) {
		return classScope.searchVariableIncludingLocal(identifierString);
	}
	
	public static MobiValue searchVariableInClass(ClassScope classScope, String identifierString) {
		return classScope.searchVariable(identifierString);
	}
	
}
