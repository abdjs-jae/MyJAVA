package myjava.semantics.symboltable.scopes;

import myjava.antlrgen.MyJAVALexer;
import myjava.semantics.analyzers.ClassAnalyzer;
import myjava.semantics.representations.MyJAVAValue;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a local scope, which is either a function, a code block or inside a certain loop/conditional statement.
 * This local scope starts as an empty representation of a class.
 *
 * LocalScope can be viewed as a tree structure wherein it has a parent and children.

 *
 */
public class LocalScope implements IScope {

	private IScope parentScope;
	private ArrayList<LocalScope> childScopeList = null;

	private HashMap<String, MyJAVAValue> localVariables = null;

	public LocalScope() {
		parentScope = null;
	}

	public LocalScope(IScope parentScope) {
		setParent(parentScope);
	}

	/*
	 * Initialize the moment a variable is about to be placed.
	 */
	public void initializeLocalVariableMap() {
		if(localVariables == null) localVariables = new HashMap<>();
	}

	/*
	 * Initialize the child list the moment a child scope is about to be placed
	 */
	public void initializeChildList() {
		if(childScopeList == null) childScopeList = new ArrayList<>();
	}

	public void setParent(IScope parentScope) {
		this.parentScope = parentScope;
	}

	public void addChild(LocalScope localScope) {
		initializeChildList();

		childScopeList.add(localScope);
	}

	public boolean isParent() {
		return (parentScope == null);
	}

	public IScope getParent() {
		return parentScope;
	}

	public int getChildCount() {
		return childScopeList != null ? childScopeList.size() : 0;
	}

	public LocalScope getChildAt(int index) {
		return childScopeList != null ? childScopeList.get(index) : null;
	}

	@Override
	public MyJAVAValue searchVariableIncludingLocal(String identifier) {
		if(containsVariable(identifier)) return localVariables.get(identifier);
		else {
			System.err.println("LocalScope: " + identifier + " not found!");
			return null;
		}
	}

	public boolean containsVariable(String identifier) {
		return localVariables != null && localVariables.containsKey(identifier);
	}

	/*
	 * Adds an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
		initializeLocalVariableMap();

		MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(primitiveTypeString);
		localVariables.put(identifierString, myJAVAValue);
	}

	/*
	 * Adds an empty variable based from keywords
	 */
	public void addEmptyConstFromKeywords(String primitiveTypeString, String identifierString) {
		initializeLocalVariableMap();

		MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(primitiveTypeString);
		myJAVAValue.markFinal();
		localVariables.put(identifierString, myJAVAValue);
	}

	/*
	 * Adds an empty variable based from keywords
	 */
	public void addInitializedConstVariableFromKeywords(String primitiveTypeString, String identifierString, String valueString) {
		initializeLocalVariableMap();

		addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
		MyJAVAValue myJAVAValue = localVariables.get(identifierString);
		myJAVAValue.markFinal();
		myJAVAValue.setValue(valueString);
	}

	/*
	 * Adds an initialized variable based from keywords
	 */
	public void addInitializedVariableFromKeywords(String primitiveTypeString, String identifierString, String valueString) {
		initializeLocalVariableMap();

		addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
		MyJAVAValue myJAVAValue = localVariables.get(identifierString);
		myJAVAValue.setValue(valueString);
	}

	public void addMyJAVAValue(String identifier, MyJAVAValue myJAVAValue) {
		initializeLocalVariableMap();
		localVariables.put(identifier, myJAVAValue);
	}

	public int getNumOfVariables(){
		if(localVariables != null)
			return localVariables.size();
		return 0;
	}

	/*
	 * Returns the depth of this local scope.
	 */
	public int getDepth() {
		int depthCount = -1;

		LocalScope scope = this;

		while(scope != null) {
			depthCount++;

			IScope abstractScope = scope.getParent();

			if(abstractScope instanceof ClassScope)
				break;

			scope = (LocalScope) abstractScope;
		}


		return depthCount;
	}

}