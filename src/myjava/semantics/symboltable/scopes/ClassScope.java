package myjava.semantics.symboltable.scopes;

import myjava.antlrgen.ITextWriter;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;

import java.util.HashMap;

/**
 * Represents a class scope with mappings of variables and functions
 */
public class ClassScope implements IScope, ITextWriter {
	
	private String className;
	
	private HashMap<String, MyJAVAValue> publicVariables;
	private HashMap<String, MyJAVAValue> privateVariables;

	private HashMap<String, MyJAVAFunction> publicFunctions;
	private HashMap<String, MyJAVAFunction> privateFunctions;
	
	private LocalScope parentLocalScope; //represents the parent local scope which is the local scope covered by the main() function. Other classes may not contain this.
	
	public ClassScope(String className) {
		this.className = className;
		System.out.println("New ClassScope: " + getClassName());

		publicVariables = new HashMap<>();
		privateVariables = new HashMap<>();

		publicFunctions = new HashMap<>();
		privateFunctions = new HashMap<>();
	}
	
	public String getClassName() {
		return className;
	}
	
	
	/*
	 * Sets the parent local scope which is instantiated if this class contains a main function.
	 */
	public void setParentLocalScope(LocalScope localScope) {
		parentLocalScope = localScope;
	}
	
	@Override
	/* 
	 * A class scope is automatically the parent of local scopes.
	 */
	public boolean isParent(){
		return true;
	}
	
	/*
	 * Attempts to add an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString) {
		boolean isPublic = true;

		//if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
		//	isPublic = false;
		//}
		
		//create empty myJAVA value
		MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(primitiveTypeString);
		
		if(isPublic) {
			publicVariables.put(identifierString, myJAVAValue);
			txtWriter.writeMessage(StringUtils.formatDebug("Created public variable " +
					identifierString+ " type: " +myJAVAValue.getPrimitiveType()));
		}
		else {
			privateVariables.put(identifierString, myJAVAValue);
			txtWriter.writeMessage(StringUtils.formatDebug("Created private variable " +
					identifierString+ " type: " +myJAVAValue.getPrimitiveType()));
		}
	}
	
	/*
	 * Attempts to add an initialized variable myJAVA value
	 */
	public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {
		boolean isPublic = true;
		
		//if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
		//	isPublic = false;
		//}
		
		addEmptyVariableFromKeywords(classModifierString, primitiveTypeString, identifierString);
		
		if(isPublic) {
			MyJAVAValue myJAVAValue = this.publicVariables.get(identifierString);
			myJAVAValue.setValue(valueString);
			txtWriter.writeMessage(StringUtils.formatDebug("Updated public variable " +
					identifierString+ " of type " +myJAVAValue.getPrimitiveType()+ " with value " +valueString));
		}
		else {
			MyJAVAValue myJAVAValue = this.privateVariables.get(identifierString);
			myJAVAValue.setValue(valueString);
			txtWriter.writeMessage(StringUtils.formatDebug("Updated private variable " +
					identifierString+ " of type " +myJAVAValue.getPrimitiveType()+ " with value " +valueString));
		}
	}
	
	public MyJAVAValue getPublicVariable(String identifier) {
		if(containsPublicVariable(identifier)) {
			return publicVariables.get(identifier);
		}
		else {
			System.err.println("ClassScope: Public " + identifier + " is not found.");
			return null;
		}
	}
	
	public MyJAVAValue getPrivateVariable(String identifier) {
		if(containsPrivateVariable(identifier)) {
			return privateVariables.get(identifier);
		}
		else {
			System.err.println("ClassScope: Private " + identifier + " is not found.");
			return null;
		}
	}
	
	public void addPrivateMyJAVAFunction(String identifier, MyJAVAFunction myJAVAFunction) {
		privateFunctions.put(identifier, myJAVAFunction);
		txtWriter.writeMessage(StringUtils.formatDebug("Created private function " +
				identifier+ " with return type " +myJAVAFunction.getReturnType()));
	}
	
	public void addPublicMyJAVAFunction(String identifier, MyJAVAFunction myJAVAFunction) {
		publicFunctions.put(identifier, myJAVAFunction);
		txtWriter.writeMessage(StringUtils.formatDebug("Created public function " +
				identifier+ " with return type " +myJAVAFunction.getReturnType()));
	}
	
	public void addMyJAVAValue(String accessControlModifier, String identifier, MyJAVAValue myJAVAValue) {
		boolean isPublic = true;
		
		//if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, accessControlModifier)) {
		//	isPublic = false;
		//}
		
		if(isPublic){
			publicVariables.put(identifier, myJAVAValue);
		}
		else {
			privateVariables.put(identifier, myJAVAValue);
		}	
	}
	
	public MyJAVAFunction getPublicFunction(String identifier) {
		if(containsPublicFunction(identifier)) {
			return publicFunctions.get(identifier);
		}
		else {
			System.err.println("ClassScope: Private " +identifier+ " function is not found.");
			return null;
		}
	}
	
	public MyJAVAFunction getPrivateFunction(String identifier) {
		if(containsPublicFunction(identifier)) {
			return privateFunctions.get(identifier);
		}
		else {
			System.err.println("ClassScope: Public " +identifier+ " function is not found");
			return null;
		}
	}
	
	public MyJAVAFunction searchFunction(String identifier) {
		if(containsPublicFunction(identifier)) {
			return publicFunctions.get(identifier);
		}
		else if(this.containsPrivateFunction(identifier)) {
			return privateFunctions.get(identifier);
		}
		else {
			System.err.println("ClassScope: " + identifier + " is not found in " + className);
			return null;
		}
	}
	
	public boolean containsPublicFunction(String identifier) {
		return publicFunctions.containsKey(identifier);
	}
	
	public boolean containsPrivateFunction(String identifier) {
		return privateFunctions.containsKey(identifier);
	}
	
	@Override
	/* Attempts to find a variable first in the private and public variable storage, then on the local scopes.
	 * (non-Javadoc)
	 * @see myjava.semantics.symboltable.scopes.IScope#getVariable(java.lang.String)
	 */
	public MyJAVAValue searchVariableIncludingLocal(String identifier) {
		MyJAVAValue value;
		if(this.containsPrivateVariable(identifier)) {
			value = getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = getPublicVariable(identifier);
		}
		else {
			value = LocalScopeCreator.searchVariableInLocalIterative(identifier, parentLocalScope);
		}
		
		return value;
	}
	
	public MyJAVAValue searchVariable(String identifier) {
		MyJAVAValue value = null;
		if(containsPrivateVariable(identifier)) {
			value = getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = getPublicVariable(identifier);
		}
		
		return value;
	}
	
	public boolean containsPublicVariable(String identifier) {
		return publicVariables.containsKey(identifier);
	}
	
	public boolean containsPrivateVariable(String identifier) {
		return privateVariables.containsKey(identifier);
	}
	
	/*
	 * Resets all stored variables. This is called after the execution manager finishes
	 */
	public void resetValues() {
		MyJAVAValue[] publicMyJAVAValues = publicVariables.values().toArray(new MyJAVAValue[publicVariables.size()]);
		MyJAVAValue[] privateMyJAVAValues = privateVariables.values().toArray(new MyJAVAValue[privateVariables.size()]);

		for (MyJAVAValue publicMyJAVAValue : publicMyJAVAValues) {
			publicMyJAVAValue.reset();
		}

		for (MyJAVAValue privateMyJAVAValue : privateMyJAVAValues) {
			privateMyJAVAValue.reset();
		}
	}
}
