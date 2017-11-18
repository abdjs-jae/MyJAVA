package myjava.semantics.symboltable.scopes;

import myjava.ITextWriter;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class LocalScope implements IScope, ITextWriter {

    private IScope parentScope;
    private ArrayList<LocalScope> childScopeList = null;
    private HashMap<String, MyJAVAValue> localVariables = null;
    private HashMap<String, MyJAVAFunction> localFunctions = null;

    public LocalScope() {
        this.parentScope = null;
    }

    public LocalScope(IScope parentScope) {
        this.parentScope = parentScope;
    }

    /*
     * Initialize the moment a variable is about to be placed.
     */
    public void initializeLocalVariableMap() {
        if(localVariables == null) {
            localVariables = new HashMap<>();
        }
    }

    /*
     * Initialize the moment a function is about to be placed.
     */
    public void initializeLocalFunctionMap() {
        if(localFunctions == null) {
            localFunctions = new HashMap<>();
        }
    }

    /*
     * Initialize the child list the moment a child scope is about to be placed
     */
    public void initializeChildList() {
        if(childScopeList == null) {
            childScopeList = new ArrayList<>();
        }
    }

    public void setParent(IScope parentScope) {
        this.parentScope = parentScope;
    }

    public void addChild(LocalScope localScope) {
        initializeChildList();
        childScopeList.add(localScope);
    }

    public boolean isParent() {
        return (this.parentScope == null);
    }

    public IScope getParent() {
        return this.parentScope;
    }

    public int getChildCount() {
        if(childScopeList != null)
            return childScopeList.size();
        else
            return 0;
    }

    public LocalScope getChildAt(int index) {
        if(childScopeList != null)
            return childScopeList.get(index);
        else
            return null;
    }

    @Override
    public MyJAVAValue searchVariableIncludingLocal(String identifier) {
        if(containsVariable(identifier)) {
            return localVariables.get(identifier);
        }
        else {
            return LocalScopeCreator.searchVariableInLocalIterative(identifier, this);
        }
    }

    public boolean containsVariable(String identifier) {
        return localVariables != null && localVariables.containsKey(identifier);
    }

    public MyJAVAValue getVariable(String identifier) {
        if(containsVariable(identifier)) {
            return localVariables.get(identifier);
        }
        else {
            txtWriter.writeMessage(StringHelper.formatError("Oops! " + identifier + " was not found."));
            return null;
        }
    }

    /*
     * Adds an empty variable based from keywords
     */
    public void addEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
        initializeLocalVariableMap();

        MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(primitiveTypeString);
        localVariables.put(identifierString, myJAVAValue);
        txtWriter.writeMessage(StringHelper.formatDebug("Created new variable " +
                identifierString+ " of primitiveType: " +myJAVAValue.getPrimitiveType()));
    }

    /*
     * Adds an initialized variable based from keywords
     */
    public void addInitializedVariableFromKeywords(String primitiveTypeString, String identifierString, String valueString) {
        initializeLocalVariableMap();
        addEmptyVariableFromKeywords(primitiveTypeString, identifierString);

        MyJAVAValue myJAVAValue = localVariables.get(identifierString);
        myJAVAValue.setValue(valueString);

        txtWriter.writeMessage(StringHelper.formatDebug("Updated variable " +identifierString+ " of primitiveType " +
                myJAVAValue.getPrimitiveType()+ " with value " +valueString));
    }

    public void addMyJAVAValue(String identifier, MyJAVAValue myJAVAValue) {
        initializeLocalVariableMap();
        localVariables.put(identifier, myJAVAValue);
    }

    public void addMyJAVAFunction(String identifier, MyJAVAFunction myJAVAFunction) {
        initializeLocalFunctionMap();
        localFunctions.put(identifier, myJAVAFunction);
        txtWriter.writeMessage(StringHelper.formatDebug("Created new function " +identifier
                + " with return type " +myJAVAFunction.getReturnType()));
    }

    public boolean containsFunction(String identifier) {
        return localFunctions != null && localFunctions.containsKey(identifier);
    }

    public MyJAVAFunction getFunction(String identifier) {
        if(containsFunction(identifier)) {
            return localFunctions.get(identifier);
        }
        else {
            txtWriter.writeMessage(StringHelper.formatError("Oops! " + identifier+ " function was not found."));
            return null;
        }
    }

    public MyJAVAFunction searchFunction(String identifier) {
        if(containsFunction(identifier)) {
            return localFunctions.get(identifier);
        }
        else {
            txtWriter.writeMessage(StringHelper.formatError("Oops! " + identifier + " is not found in local scope."));
            return null;
        }
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
            scope = (LocalScope) abstractScope;
        }

        return depthCount;
    }

    /*
     * Resets all stored variables. This is called after the execution manager finishes
     */
    public void resetValues() {
        MyJAVAValue[] myJAVAValues = localVariables.values().toArray(new MyJAVAValue[localVariables.size()]);

        for (MyJAVAValue myJAVAValue : myJAVAValues) {
            myJAVAValue.reset();
        }
    }
}
