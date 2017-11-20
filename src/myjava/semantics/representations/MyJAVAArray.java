package myjava.semantics.representations;

import myjava.antlrgen.ITextWriter;
import myjava.error.MyJAVAErrorStrategy;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.utils.AssignmentUtils;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;

/**
 * A representation of an array. For now, we only accept 1D array.
 */
public class MyJAVAArray implements ITextWriter{
	
	private MyJAVAValue[] myJAVAValueArray;
	private PrimitiveType arrayPrimitiveType;
	private String arrayIdentifier;
	private boolean finalFlag = false;
	
	public MyJAVAArray(PrimitiveType primitiveType, String identifier) {
		arrayPrimitiveType = primitiveType;
		arrayIdentifier = identifier;
	}
	
	public void setPrimitiveType(PrimitiveType primitiveType) {
		arrayPrimitiveType = primitiveType;
	}
	
	public PrimitiveType getPrimitiveType() {
		return arrayPrimitiveType;
	}
	
	public void markFinal() {
		finalFlag = true;
	}
	
	public boolean isFinal() {
		return finalFlag;
	}
	
	public void initializeSize(int size) {
		myJAVAValueArray = new MyJAVAValue[size];
		System.out.println("MyJAVA array initialized to size " + myJAVAValueArray.length);
	}
	
	public int getSize() {
		return myJAVAValueArray.length;
	}
	
	public void updateValueAt(MyJAVAValue myJAVAValue, int index) {
		if(index >= myJAVAValueArray.length) {
			txtWriter.writeMessage(StringUtils.formatError(
					"MyJAVAArray: Out of bounds exception for array " + arrayIdentifier + " Index: " + index));
			return;
		}
		myJAVAValueArray[index] = myJAVAValue;
	}
	
	public MyJAVAValue getValueAt(int index) {
		if(index >= myJAVAValueArray.length) {
			txtWriter.writeMessage(StringUtils.formatError(
					"MyJAVAArray: Out of bounds exception for array " + arrayIdentifier + " Index: " + index));
			return myJAVAValueArray[myJAVAValueArray.length - 1];
		}
		else {
			return myJAVAValueArray[index];
		}
	}
	
	/*
	 * Utility function that returns an arary of specified primitive type.
	 */
	public static MyJAVAArray createArray(String primitiveTypeString, String arrayIdentifier) {
		//identify primitive type
		PrimitiveType primitiveType = AssignmentUtils.assignPrimitiveType(primitiveTypeString);
		return new MyJAVAArray(primitiveType, arrayIdentifier);
	}
}
