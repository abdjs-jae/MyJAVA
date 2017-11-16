package myjava.semantics.symboltable.scopes;

import myjava.ITextWriter;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;

import java.util.HashMap;

public class ClassScope implements IScope, ITextWriter {

    private String className;

    private HashMap<String, MyJAVAValue> variables;

    private HashMap<String, MyJAVAFunction> functions;

    // represents the parent local scope which is the local scope covered by the main function.
    // other classes may not contain this
    private LocalScope parentLocalScope;

    public ClassScope(String className) {
        this.className = className;

        this.variables = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public String getClassName() {
        return this.className;
    }

    public void setParentLocalScope(LocalScope localScope) {
        this.parentLocalScope = localScope;
    }

    /*
	 * Attempts to add an empty variable based from keywords
	 */
    public void addEmptyVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString) {

        MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(primitiveTypeString);

        this.variables.put(identifierString, myJAVAValue);
        txtWriter.writeMessage(StringUtils.formatDebug("Created variable " +identifierString+ " of type: " +myJAVAValue.getPrimitiveType()));
    }

    /*
     * Attempts to add an initialized variable myJAVA value
     */
    public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {

        this.addEmptyVariableFromKeywords(classModifierString, primitiveTypeString, identifierString);

        MyJAVAValue myJAVAValue = this.variables.get(identifierString);
        myJAVAValue.setValue(valueString);
        txtWriter.writeMessage(StringUtils.formatDebug("Updated variable " +identifierString+ " of type " +
                myJAVAValue.getPrimitiveType()+ " with value " +valueString));

    }

    public MyJAVAValue getVariable(String identifier) {
        if(this.containsVariable(identifier)) {
            return this.variables.get(identifier);
        }
        else {
            txtWriter.writeMessage(StringUtils.formatError(identifier + " is not found."));
            return null;
        }
    }

    public void addMyJAVAFunction(String identifier, MyJAVAFunction myJAVAFunction) {
        this.functions.put(identifier, myJAVAFunction);
        txtWriter.writeMessage(StringUtils.formatDebug("Created function " +identifier
                + " with return type " +myJAVAFunction.getReturnType()));
    }

    public void addMyJAVAValue(String identifier, MyJAVAValue myJAVAValue) {
        this.variables.put(identifier, myJAVAValue);
    }

    public MyJAVAFunction getFunction(String identifier) {
        if(this.containsFunction(identifier)) {
            return this.functions.get(identifier);
        }
        else {
            txtWriter.writeMessage(StringUtils.formatError(identifier+ " function is not found"));
            return null;
        }
    }

    public MyJAVAFunction searchFunction(String identifier) {
        if(this.containsFunction(identifier)) {
            return this.functions.get(identifier);
        }
        else {
            txtWriter.writeMessage(StringUtils.formatError(identifier + " is not found in " +this.className));
            return null;
        }
    }

    public boolean containsFunction(String identifier) {
        return this.functions.containsKey(identifier);
    }

    @Override
	/* Attempts to find a variable first in the private and public variable storage, then on the local scopes.
	 */
    public MyJAVAValue searchVariableIncludingLocal(String identifier) {
        MyJAVAValue value;
        if(this.containsVariable(identifier)) {
            value = this.getVariable(identifier);
        }
        else {
            value = LocalScopeCreator.searchVariableInLocalIterative(identifier, this.parentLocalScope);
        }

        return value;
    }

    @Override
    public boolean isParent() {
        return false;
    }

    public MyJAVAValue searchVariable(String identifier) {
        MyJAVAValue value = null;
        if(this.containsVariable(identifier)) {
            value = this.getVariable(identifier);
        }

        return value;
    }

    public boolean containsVariable(String identifier) {
        return this.variables.containsKey(identifier);
    }

    /*
     * Resets all stored variables. This is called after the execution manager finishes
     */
    public void resetValues() {
        MyJAVAValue[] myJAVAValues = this.variables.values().toArray(new MyJAVAValue[this.variables.size()]);

        for(int i = 0; i < myJAVAValues.length; i++) {
            myJAVAValues[i].reset();
        }

    }
}
