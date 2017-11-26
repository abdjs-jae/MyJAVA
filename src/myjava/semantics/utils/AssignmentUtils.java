package myjava.semantics.utils;

import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;

import java.math.BigDecimal;

/**
 * Assignment utilities are put here.

 *
 */
public class AssignmentUtils {

	/*
	 * Assigns an appropriate value depending on the primitive type. Since expression class returns a double value, we attempt
	 * to properly cast it. All expression commands accept INT, LONG, BYTE, SHORT, FLOAT and DOUBLE.
	 */
	public static void assignAppropriateValue(MyJAVAValue myJAVAValue, BigDecimal evaluationValue) {

		// No type specified
		if(myJAVAValue == null){
			System.out.println("MyJAVAValue: No type specified :(");
		}
		else {
			if (myJAVAValue.getPrimitiveType() == PrimitiveType.INT) {
				myJAVAValue.setValue(Integer.toString(evaluationValue.intValue()));
			} else if (myJAVAValue.getPrimitiveType() == PrimitiveType.LONG) {
				myJAVAValue.setValue(Long.toString(evaluationValue.longValue()));
			} else if (myJAVAValue.getPrimitiveType() == PrimitiveType.BYTE) {
				myJAVAValue.setValue(Byte.toString(evaluationValue.byteValue()));
			} else if (myJAVAValue.getPrimitiveType() == PrimitiveType.SHORT) {
				myJAVAValue.setValue(Short.toString(evaluationValue.shortValue()));
			} else if (myJAVAValue.getPrimitiveType() == PrimitiveType.FLOAT) {
				myJAVAValue.setValue(Float.toString(evaluationValue.floatValue()));
			} else if (myJAVAValue.getPrimitiveType() == PrimitiveType.DOUBLE) {
				myJAVAValue.setValue(Double.toString(evaluationValue.doubleValue()));
			} else if (myJAVAValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
				int result = evaluationValue.intValue();

				if (result == 1) {
					myJAVAValue.setValue(RecognizedKeywords.BOOLEAN_TRUE);
				} else {
					myJAVAValue.setValue(RecognizedKeywords.BOOLEAN_FALSE);
				}
			} else {
				System.out.println("MyJAVAValue: No appropriate type :(");
			}
		}
	}

	public static PrimitiveType assignPrimitiveType(String primitiveTypeString){
		if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString))
			return PrimitiveType.BOOLEAN;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BYTE, primitiveTypeString))
			return PrimitiveType.BYTE;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_CHAR, primitiveTypeString))
			return PrimitiveType.CHAR;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_DOUBLE, primitiveTypeString))
			return PrimitiveType.DOUBLE;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString))
			return PrimitiveType.FLOAT;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_INT, primitiveTypeString))
			return PrimitiveType.INT;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_LONG, primitiveTypeString))
			return PrimitiveType.LONG;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_SHORT, primitiveTypeString))
			return PrimitiveType.SHORT;
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_STRING, primitiveTypeString))
			return PrimitiveType.STRING;
		return PrimitiveType.NOT_YET_IDENTIFIED;
	}
	
}
