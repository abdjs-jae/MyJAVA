/**
 * 
 */
package myjava.semantics.symboltable.scopes;

import android.util.Log;
import myjava.ide.console.Console;
import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.utils.RecognizedKeywords;

import java.util.HashMap;

/**
 * Represents a class scope with mappings of variables and functions

 *
 */
public class ClassScope implements IScope {

	private final static String TAG = "MyJAVAProg_ClassScope";
	
	private String className;
	
	private HashMap<String, MyJAVAValue> publicVariables;
	private HashMap<String, MyJAVAValue> privateVariables;
	
	private HashMap<String, MyJAVAFunction> publicFunctions;
	private HashMap<String, MyJAVAFunction> privateFunctions;
	
	private LocalScope parentLocalScope; //represents the parent local scope which is the local scope covered by the main() function. Other classes may not contain this.
	
	public ClassScope(String className) {
		this.className = className;
		
		this.publicVariables = new HashMap<String, MyJAVAValue>();
		this.privateVariables = new HashMap<String, MyJAVAValue>();
		
		this.publicFunctions = new HashMap<String, MyJAVAFunction>();
		this.privateFunctions = new HashMap<String, MyJAVAFunction>();
	}
	
	public String getClassName() {
		return this.className;
	}
	
	
	/*
	 * Sets the parent local scope which is instantiated if this class contains a main function.
	 */
	public void setParentLocalScope(LocalScope localScope) {
		this.parentLocalScope = localScope;
	}
	
	@Override
	/* 
	 * A class scope is automatically the parent of local scopes.
	 * (non-Javadoc)
	 * @see myjava.semantics.symboltable.scopes.IScope#isParent()
	 */
	public boolean isParent(){
		return true;
	}
	
	/*
	 * Attempts to add an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString) {
		boolean isPublic = true;
		
		if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
			isPublic = false;
		}
		
		//create empty myJAVA value
		MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(primitiveTypeString);
		
		if(isPublic) {
			this.publicVariables.put(identifierString, myJAVAValue);
			Console.log(LogType.DEBUG, "Created public variable " +identifierString+ " type: " +myJAVAValue.getPrimitiveType());
		}
		else {
			this.privateVariables.put(identifierString, myJAVAValue);
			Console.log(LogType.DEBUG, "Created private variable " +identifierString+ " type: " +myJAVAValue.getPrimitiveType());
		}
	}
	
	/*
	 * Attempts to add an initialized variable myJAVA value
	 */
	public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {
		boolean isPublic = true;
		
		if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
			isPublic = false;
		}
		
		this.addEmptyVariableFromKeywords(classModifierString, primitiveTypeString, identifierString);
		
		if(isPublic) {
			MyJAVAValue myJAVAValue = this.publicVariables.get(identifierString);
			myJAVAValue.setValue(valueString);
			Console.log(LogType.DEBUG, "Updated public variable " +identifierString+ " of type " +myJAVAValue.getPrimitiveType()+ " with value " +valueString);
		}
		else {
			MyJAVAValue myJAVAValue = this.privateVariables.get(identifierString);
			myJAVAValue.setValue(valueString);
			Console.log(LogType.DEBUG, "Updated private variable " +identifierString+ " of type " +myJAVAValue.getPrimitiveType()+ " with value " +valueString);
		}
	}
	
	public MyJAVAValue getPublicVariable(String identifier) {
		if(this.containsPublicVariable(identifier)) {
			return this.publicVariables.get(identifier);
		}
		else {
			Log.e(TAG, "Public " +identifier + " is not found.");
			return null;
		}
	}
	
	public MyJAVAValue getPrivateVariable(String identifier) {
		if(this.containsPrivateVariable(identifier)) {
			return this.privateVariables.get(identifier);
		}
		else {
			Log.e(TAG, "Private " +identifier + " is not found.");
			return null;
		}
	}
	
	public void addPrivateMyJAVAFunction(String identifier, MyJAVAFunction myJAVAFunction) {
		this.privateFunctions.put(identifier, myJAVAFunction);
		Console.log(LogType.DEBUG, "Created private function " +identifier+ " with return type " +myJAVAFunction.getReturnType());
	}
	
	public void addPublicMyJAVAFunction(String identifier, MyJAVAFunction myJAVAFunction) {
		this.publicFunctions.put(identifier, myJAVAFunction);
		Console.log(LogType.DEBUG, "Created public function " +identifier+ " with return type " +myJAVAFunction.getReturnType());
	}
	
	public void addMyJAVAValue(String accessControlModifier, String identifier, MyJAVAValue myJAVAValue) {
		boolean isPublic = true;
		
		if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, accessControlModifier)) {
			isPublic = false;
		}
		
		if(isPublic){
			this.publicVariables.put(identifier, myJAVAValue);
		}
		else {
			this.privateVariables.put(identifier, myJAVAValue);
		}	
	}
	
	public MyJAVAFunction getPublicFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.publicFunctions.get(identifier);
		}
		else {
			Log.e(TAG, "Private " +identifier+ " function is not found.");
			return null;
		}
	}
	
	public MyJAVAFunction getPrivateFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.privateFunctions.get(identifier);
		}
		else {
			Log.e(TAG, "Public " +identifier+ " function is not found");
			return null;
		}
	}
	
	public MyJAVAFunction searchFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.publicFunctions.get(identifier);
		}
		else if(this.containsPrivateFunction(identifier)) {
			return this.privateFunctions.get(identifier);
		}
		else {
			Log.e(TAG, identifier + " is not found in " +this.className);
			return null;
		}
	}
	
	public boolean containsPublicFunction(String identifier) {
		return this.publicFunctions.containsKey(identifier);
	}
	
	public boolean containsPrivateFunction(String identifier) {
		return this.privateFunctions.containsKey(identifier);
	}
	
	@Override
	/* Attempts to find a variable first in the private and public variable storage, then on the local scopes.
	 * (non-Javadoc)
	 * @see myjava.semantics.symboltable.scopes.IScope#getVariable(java.lang.String)
	 */
	public MyJAVAValue searchVariableIncludingLocal(String identifier) {
		MyJAVAValue value;
		if(this.containsPrivateVariable(identifier)) {
			value = this.getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = this.getPublicVariable(identifier);
		}
		else {
			value = LocalScopeCreator.searchVariableInLocalIterative(identifier, this.parentLocalScope);
		}
		
		return value;
	}
	
	public MyJAVAValue searchVariable(String identifier) {
		MyJAVAValue value = null;
		if(this.containsPrivateVariable(identifier)) {
			value = this.getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = this.getPublicVariable(identifier);
		}
		
		return value;
	}
	
	public boolean containsPublicVariable(String identifier) {
		return this.publicVariables.containsKey(identifier);
	}
	
	public boolean containsPrivateVariable(String identifier) {
		return this.privateVariables.containsKey(identifier);
	}
	
	/*
	 * Resets all stored variables. This is called after the execution manager finishes
	 */
	public void resetValues() {
		MyJAVAValue[] publicMyJAVAValues = this.publicVariables.values().toArray(new MyJAVAValue[this.publicVariables.size()]);
		MyJAVAValue[] privateMyJAVAValues = this.privateVariables.values().toArray(new MyJAVAValue[this.privateVariables.size()]);
		
		for(int i = 0; i < publicMyJAVAValues.length; i++) {
			publicMyJAVAValues[i].reset();
		}
		
		for(int i = 0; i < privateMyJAVAValues.length; i++) {
			privateMyJAVAValues[i].reset();
		}
	}
}
