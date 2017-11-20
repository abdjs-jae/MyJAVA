package myjava.semantics.symboltable.scopes;

import myjava.semantics.representations.MyJAVAValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A singleton instance that creates a corresponding local scope and properly links them together
 * with other local scope
 * 

 *
 */
public class LocalScopeCreator {
	
	private static LocalScopeCreator localScopeCreator = null;
	
	public static LocalScopeCreator getInstance() {
		return localScopeCreator;
	}
	
	private LocalScope activeLocalScope = null;
	
	private LocalScopeCreator() {
		
	}
	
	public static void initialize() {
		localScopeCreator = new LocalScopeCreator();
	}
	
	public static void reset() {
		localScopeCreator.activeLocalScope = null;
	}
	
	/*
	 * Opens a new local scope instance. If the active local scope instance is null,
	 * it creates a new one and sets it as a parent. Otherwise, the active local scope is set as
	 * a parent of the new instance, then the new instance becomes the active local scope.
	 */
	public LocalScope openLocalScope() {
		if(activeLocalScope == null) {
			activeLocalScope = new LocalScope();
		}
		else {
			LocalScope childLocalScope = new LocalScope(); 
			childLocalScope.setParent(activeLocalScope);//point this current local scope as parent
			activeLocalScope.addChild(childLocalScope); //add the new scope as child for this current local scope
			activeLocalScope = childLocalScope; //change pointer to the child scope
		}
		
		return activeLocalScope;
	}
	
	public LocalScope getActiveLocalScope() {
		return activeLocalScope;
	}
	
	/*
	 * Closes the active local scope which changes the pointer to the parent of the active local scope.
	 */
	public void closeLocalScope() {
		if(activeLocalScope.getParent() != null && activeLocalScope.getParent() instanceof LocalScope) {
			activeLocalScope = (LocalScope) activeLocalScope.getParent();
		}
		else if(activeLocalScope.getParent() == null) {
			System.err.println("LocalScopeCreator: Cannot change parent. Current active local scope no longer has a parent.");
		}
		else {
			System.err.println("LocalScopeCreator: Cannot change parent. Current active local scope's parent is now a class scope.");
		}
	}
	
	/*
	 * Searches for a local variable using an iterative depth-first search.
	 */
	public static MyJAVAValue searchVariableInLocalIterative(String identifier, LocalScope localScope) {
		
		if(localScope == null) {
			System.err.println("LocalScopeCreator: " + identifier + " not found in any local scope!");
			return null;
		}
		
		Stack<LocalScope> stack = new Stack<LocalScope>();
		
		stack.push(localScope);
		
		List<LocalScope> discoveredScopes = new ArrayList<LocalScope>();
		LocalScope scope;
		
		while(!stack.isEmpty()) {
			scope = stack.pop();
			
			if(scope.containsVariable(identifier)) {
				return scope.searchVariableIncludingLocal(identifier);
			}
			
			if(!discoveredScopes.contains(scope)) {
				discoveredScopes.add(scope);
				
				for(int i = 0; i < scope.getChildCount(); i++) {
					LocalScope childScope = scope.getChildAt(i);
					stack.push(childScope);
				}
			}
		}

		System.err.println("LocalScopeCreator: " + identifier + " not found in any local scope!");
		return null;
	}
}
