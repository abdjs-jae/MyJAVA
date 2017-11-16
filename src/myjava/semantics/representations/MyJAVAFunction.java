package myjava.semantics.representations;

import myjava.ITextWriter;
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAValue.*;
import myjava.execution.ICommand;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MyJAVAFunction implements ITextWriter{
    public enum FunctionType {
        INT_TYPE,
        BOOLEAN_TYPE,
        BYTE_TYPE,
        CHAR_TYPE,
        DOUBLE_TYPE,
        FLOAT_TYPE,
        LONG_TYPE,
        SHORT_TYPE,
        STRING_TYPE,
        VOID_TYPE,
    }

    private String functionName;
    private List<ICommand> commandSequences; //the list of commands execution by the function

    private LocalScope parentLocalScope; //refers to the parent local scope of this function.

    private LinkedHashMap<String, ClassScope> parameterReferences; //the list of parameters accepted that follows the 'call-by-reference' standard.
    private LinkedHashMap<String, MyJAVAValue> parameterValues;	//the list of parameters accepted that follows the 'call-by-value' standard.
    private MyJAVAValue returnValue; //the return value of the function. null if it's a void type
    private FunctionType returnType = FunctionType.VOID_TYPE; //the return type of the function

    public MyJAVAFunction() {
        this.commandSequences = new ArrayList<ICommand>();
        this.parameterValues = new LinkedHashMap<String,MyJAVAValue>();
        this.parameterReferences = new LinkedHashMap<String, ClassScope>();
    }

    public void setParentLocalScope(LocalScope localScope) {
        this.parentLocalScope = localScope;
    }

    public LocalScope getParentLocalScope() {
        return this.parentLocalScope;
    }

    public void setReturnType(FunctionType functionType) {
        this.returnType = functionType;

        //create an empty myJAVA value as a return value
        switch(this.returnType) {
            case BOOLEAN_TYPE: this.returnValue = new MyJAVAValue(true, PrimitiveType.BOOLEAN); break;
            case BYTE_TYPE: this.returnValue = new MyJAVAValue(0, PrimitiveType.BYTE); break;
            case CHAR_TYPE: this.returnValue = new MyJAVAValue(' ', PrimitiveType.CHAR); break;
            case INT_TYPE: this.returnValue = new MyJAVAValue(0, PrimitiveType.INT); break;
            case DOUBLE_TYPE: this.returnValue = new MyJAVAValue(0, PrimitiveType.DOUBLE); break;
            case FLOAT_TYPE: this.returnValue = new MyJAVAValue(0, PrimitiveType.FLOAT); break;
            case LONG_TYPE: this.returnValue = new MyJAVAValue(0, PrimitiveType.LONG); break;
            case SHORT_TYPE: this.returnValue = new MyJAVAValue(0, PrimitiveType.SHORT); break;
            case STRING_TYPE: this.returnValue = new MyJAVAValue("", PrimitiveType.STRING); break;
            default: break;
        }
    }

    public FunctionType getReturnType() {
        return this.returnType;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    /*
     * Maps parameters by values, which means that the value is copied to its parameter listing
     */
    public void mapParameterByValue(String... values) {
        for(int i = 0; i < values.length; i++) {
            MyJAVAValue myJAVAValue = this.getParameterAt(i);
            myJAVAValue.setValue(values[i]);
        }
    }

    public void mapParameterByValueAt(String value, int index) {
        if(index >= this.parameterValues.size()) {
            return;
        }

        MyJAVAValue myJAVAValue = this.getParameterAt(index);
        myJAVAValue.setValue(value);
    }

    public void mapArrayAt(MyJAVAValue myJAVAValue, int index, String identifier) {
        if(index >= this.parameterValues.size()) {
            return;
        }

        MyJAVAArray myJAVAArray = (MyJAVAArray) myJAVAValue.getValue();

        MyJAVAArray newArray = new MyJAVAArray(myJAVAArray.getPrimitiveType(), identifier);
        MyJAVAValue newValue = new MyJAVAValue(newArray, PrimitiveType.ARRAY);

        newArray.initializeSize(myJAVAArray.getSize());

        for(int i = 0; i < newArray.getSize(); i++) {
            newArray.updateValueAt(myJAVAArray.getValueAt(i), i);
        }

        this.parameterValues.put(this.getParameterKeyAt(index), newValue);

    }

    public int getParameterValueSize() {
        return this.parameterValues.size();
    }

    public void verifyParameterByValueAt(ExpressionContext exprCtx, int index) {
        if(index >= this.parameterValues.size()) {
            return;
        }

        MyJAVAValue myJAVAValue = this.getParameterAt(index);
        TypeChecker typeChecker = new TypeChecker(myJAVAValue, exprCtx);
        typeChecker.verify();
    }

    /*
     * Maps parameters by reference, in this case, accept a class scope.
     */
    public void mapParameterByReference(ClassScope... classScopes) {
        txtWriter.writeMessage(StringUtils.formatError("MyJAVAFunction: " +
                "Mapping of parameter by reference not yet supported."));
    }

    public void addParameter(String identifierString, MyJAVAValue myJAVAValue) {
        this.parameterValues.put(identifierString, myJAVAValue);
        txtWriter.writeMessage(StringUtils.formatDebug(this.functionName +
                " added an empty parameter " +identifierString+ " of type " +myJAVAValue.getPrimitiveType()));
    }

    public boolean hasParameter(String identifierString) {
        return this.parameterValues.containsKey(identifierString);
    }
    public MyJAVAValue getParameter(String identifierString) {
        if(this.hasParameter(identifierString)) {
            return this.parameterValues.get(identifierString);
        }
        else {
            txtWriter.writeMessage(StringUtils.formatError("MyJAVAFunction: "
                    + identifierString + " not found in parameter list"));
            return null;
        }
    }

    public MyJAVAValue getParameterAt(int index) {
        int i = 0;

        for(MyJAVAValue myJAVAValue : this.parameterValues.values()) {
            if(i == index) {
                return myJAVAValue;
            }

            i++;
        }

        txtWriter.writeMessage(StringUtils.formatError("MyJAVAFunction: "
                + index + " has exceeded parameter list."));
        return null;
    }

    private String getParameterKeyAt(int index) {
        int i = 0;

        for(String key : this.parameterValues.keySet()) {
            if(i == index) {
                return key;
            }

            i++;
        }

        txtWriter.writeMessage(StringUtils.formatError("MyJAVAFunction: "
                + index + " has exceeded parameter list."));
        return null;
    }

    public MyJAVAValue getReturnValue() {
        if(this.returnType == FunctionType.VOID_TYPE) {
            txtWriter.writeMessage(StringUtils.formatDebug(this.functionName
                    + " is a void function. Null myJAVA value will be returned."));
            return null;
        }
        else {
            return this.returnValue;
        }
    }

    @Override
    public void addCommand(ICommand command) {
        this.commandSequences.add(command);
    }

    @Override
    public void execute() {
        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();
        FunctionTracker.getInstance().reportEnterFunction(this);
        try {
            for(ICommand command : this.commandSequences) {
                executionMonitor.tryExecution();
                command.execute();
            }

        } catch(InterruptedException e) {
            txtWriter.writeMessage(StringUtils.formatError("MyJAVAFunction: " +
                    "Monitor block interrupted! " + e.getMessage()));
        }

        FunctionTracker.getInstance().reportExitFunction();
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.FUNCTION_TYPE;
    }

    public static FunctionType identifyFunctionType(String primitiveTypeString) {

        if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
            return FunctionType.BOOLEAN_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BYTE, primitiveTypeString)) {
            return FunctionType.BYTE_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_CHAR, primitiveTypeString)) {
            return FunctionType.CHAR_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_DOUBLE, primitiveTypeString)) {
            return FunctionType.DOUBLE_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
            return FunctionType.FLOAT_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
            return FunctionType.INT_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_LONG, primitiveTypeString)) {
            return FunctionType.LONG_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_SHORT, primitiveTypeString)) {
            return FunctionType.SHORT_TYPE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
            return FunctionType.STRING_TYPE;
        }

        return FunctionType.VOID_TYPE;
    }
}
