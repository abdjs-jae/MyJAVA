package myjava.semantics.utils;

import java.math.BigDecimal;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;

/**
 * Assignment utilities are put here.
 * @author NeilDG
 *
 */
public class AssignmentUtils {

    /*
     * Assigns an appropriate value depending on the primitive type. Since expression class returns a double value, we attempt
     * to properly cast it. All expression commands accept INT, LONG, BYTE, SHORT, FLOAT and DOUBLE.
     */
    public static void assignAppropriateValue(MyJAVAValue myJAVAValue, BigDecimal evaluationValue) {
        if(myJAVAValue.getPrimitiveType() == PrimitiveType.INT) {
            myJAVAValue.setValue(Integer.toString(evaluationValue.intValue()));
        }
        else if(myJAVAValue.getPrimitiveType() == PrimitiveType.LONG) {
            myJAVAValue.setValue(Long.toString(evaluationValue.longValue()));
        }
        else if(myJAVAValue.getPrimitiveType() == PrimitiveType.BYTE) {
            myJAVAValue.setValue(Byte.toString(evaluationValue.byteValue()));
        }
        else if(myJAVAValue.getPrimitiveType() == PrimitiveType.SHORT) {
            myJAVAValue.setValue(Short.toString(evaluationValue.shortValue()));
        }
        else if(myJAVAValue.getPrimitiveType() == PrimitiveType.FLOAT) {
            myJAVAValue.setValue(Float.toString(evaluationValue.floatValue()));
        }
        else if(myJAVAValue.getPrimitiveType() == PrimitiveType.DOUBLE) {
            myJAVAValue.setValue(Double.toString(evaluationValue.doubleValue()));
        }
        else if(myJAVAValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
            int result = evaluationValue.intValue();

            if(result == 1) {
                myJAVAValue.setValue(RecognizedKeywords.BOOLEAN_TRUE);
            }
            else {
                myJAVAValue.setValue(RecognizedKeywords.BOOLEAN_FALSE);
            }
        }
        else {
           //Console.log(LogType.DEBUG, "MyJAVAValue: DID NOT FIND APPROPRIATE TYPE!!");
        }
    }

}