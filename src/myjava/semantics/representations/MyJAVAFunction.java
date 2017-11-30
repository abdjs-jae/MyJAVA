package myjava.semantics.representations;

import myjava.antlrgen.ITextWriter;
import myjava.error.checkers.TypeChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.FunctionTracker;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IControlledCommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Represents the intermediate representation of a function
 *
 */
public class MyJAVAFunction implements ITextWriter, IControlledCommand{
	
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
		commandSequences = new ArrayList<>();
		parameterValues = new LinkedHashMap<>();
		parameterReferences = new LinkedHashMap<>();
	}

	// for the recursion stuff
	public MyJAVAFunction(MyJAVAFunction myJAVAFunction) {
	    this.functionName = myJAVAFunction.functionName;
	    this.commandSequences = new ArrayList<>(myJAVAFunction.commandSequences);
	    this.parentLocalScope = myJAVAFunction.parentLocalScope;
	    this.parameterReferences = new LinkedHashMap<>(myJAVAFunction.parameterReferences);
	    this.parameterValues = new LinkedHashMap<>(myJAVAFunction.parameterValues);
	    this.returnValue = myJAVAFunction.returnValue;
	    this.returnType = myJAVAFunction.returnType;
    }
	
	public void setParentLocalScope(LocalScope localScope) {
		parentLocalScope = localScope;
	}
	
	public LocalScope getParentLocalScope() {
		return parentLocalScope;
	}
	
	public void setReturnType(FunctionType functionType) {
		returnType = functionType;
		
		//create an empty myJAVA value as a return value
		switch(returnType) {
			case BOOLEAN_TYPE: returnValue = new MyJAVAValue(true, PrimitiveType.BOOLEAN); break;
			case BYTE_TYPE: returnValue = new MyJAVAValue(0, PrimitiveType.BYTE); break;
			case CHAR_TYPE: returnValue = new MyJAVAValue(' ', PrimitiveType.CHAR); break;
			case INT_TYPE: returnValue = new MyJAVAValue(0, PrimitiveType.INT); break;
			case DOUBLE_TYPE: returnValue = new MyJAVAValue(0, PrimitiveType.DOUBLE); break;
			case FLOAT_TYPE: returnValue = new MyJAVAValue(0, PrimitiveType.FLOAT); break;
			case LONG_TYPE: returnValue = new MyJAVAValue(0, PrimitiveType.LONG); break;
			case SHORT_TYPE: returnValue = new MyJAVAValue(0, PrimitiveType.SHORT); break;
			case STRING_TYPE: returnValue = new MyJAVAValue("", PrimitiveType.STRING); break;
			default: break;
		}
	}
	
	public FunctionType getReturnType() {
		return returnType;
	}
	
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public String getFunctionName() {
		return functionName;
	}
	
	/*
	 * Maps parameters by values, which means that the value is copied to its parameter listing
	 */
	public void mapParameterByValue(String... values) {
		for(int i = 0; i < values.length; i++) {
			MyJAVAValue myJAVAValue = getParameterAt(i);
			myJAVAValue.setValue(values[i]);
		}
	}
	
	public void mapParameterByValueAt(String value, int index) {
		if(index >= parameterValues.size()) {
			return;
		}
		
		MyJAVAValue myJAVAValue = getParameterAt(index);
		myJAVAValue.setValue(value);
	}
	
	public void mapArrayAt(MyJAVAValue myJAVAValue, int index, String identifier) {
		if(index >= parameterValues.size()) {
			return;
		}
		
		MyJAVAArray myJAVAArray = (MyJAVAArray) myJAVAValue.getValue();
		
		MyJAVAArray newArray = new MyJAVAArray(myJAVAArray.getPrimitiveType(), identifier);
		MyJAVAValue newValue = new MyJAVAValue(newArray, PrimitiveType.ARRAY);
		
		newArray.initializeSize(myJAVAArray.getSize());
		
		for(int i = 0; i < newArray.getSize(); i++) {
			newArray.updateValueAt(myJAVAArray.getValueAt(i), i);
		}
		
		parameterValues.put(getParameterKeyAt(index), newValue);
		
	}
	
	public int getParameterValueSize() {
		return parameterValues.size();
	}
	
	public void verifyParameterByValueAt(ExpressionContext exprCtx, int index) {
		if(index >= parameterValues.size()) {
			return;
		}
		
		MyJAVAValue myJAVAValue = getParameterAt(index);
		TypeChecker typeChecker = new TypeChecker(myJAVAValue, exprCtx);
		typeChecker.verify();
	}
	
	/*
	 * Maps parameters by reference, in this case, accept a class scope.
	 */
	public void mapParameterByReference(ClassScope... classScopes) {
		System.err.println("Mapping of parameter by reference not yet supported.");
	}
	
	public void addParameter(String identifierString, MyJAVAValue myJAVAValue) {
		parameterValues.put(identifierString, myJAVAValue);
		txtWriter.writeMessage(StringUtils.formatDebug(functionName + " added an empty parameter " +
				identifierString+ " type " +myJAVAValue.getPrimitiveType()));
	}
	
	public boolean hasParameter(String identifierString) {
		return parameterValues.containsKey(identifierString);
	}
	public MyJAVAValue getParameter(String identifierString) {
		if(this.hasParameter(identifierString)) {
			return parameterValues.get(identifierString);
		}
		else {
			System.err.println("MyJAVAFunction: " + identifierString + " not found in parameter list");
			return null;
		}
	}
	
	public MyJAVAValue getParameterAt(int index) {
		int i = 0;

		for(MyJAVAValue myJAVAValue : parameterValues.values()) {
			if(i == index) {
				return myJAVAValue;
			}
			
			i++;
		}

		System.err.println("MyJAVAFunction: " + index + " has exceeded parameter list.");
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

		System.err.println("MyJAVAFunction: " + index + " has exceeded parameter list.");
		return null;
	}
	
	public MyJAVAValue getReturnValue() {
		if(this.returnType == FunctionType.VOID_TYPE) {
			txtWriter.writeMessage(StringUtils.formatDebug(functionName + " is a void function. Null myJAVA value is returned"));
			return null;
		}
		else {
			return this.returnValue;
		}
	}
	
	@Override
	public void addCommand(ICommand command) {
		this.commandSequences.add(command);
		//Console.log("Command added to " +this.functionName);
	}
	
	@Override
	public void execute() {
		ExecutionMonitor executionMonitor = ExecutionManager.getExecutionManager().getExecutionMonitor();
		FunctionTracker.getInstance().reportEnterFunction(this);
		try {
			for(ICommand command : this.commandSequences) {
				executionMonitor.tryExecution();
				command.execute();
			}

		} catch(InterruptedException e) {
			System.err.println("MyJAVAFunction: " + "Monitor block interrupted! " +e.getMessage());
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
