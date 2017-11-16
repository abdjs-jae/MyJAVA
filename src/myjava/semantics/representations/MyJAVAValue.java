package myjava.semantics.representations;

import myjava.ITextWriter;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;

/**
 * Created by jasonsapdos on 16/11/2017.
 */
public class MyJAVAValue implements ITextWriter {

    // Accepted primitive types
    public enum PrimitiveType {
        NOT_YET_IDENTIFIED,
        BOOLEAN,
        CHAR,
        INT,
        BYTE,
        SHORT,
        LONG,
        FLOAT,
        DOUBLE,
        STRING,
        ARRAY
    }

    private Object defaultValue; //this value will no longer change.
    private Object value;
    private PrimitiveType primitiveType = PrimitiveType.NOT_YET_IDENTIFIED;
    private boolean finalFlag = false;

    public MyJAVAValue(Object value, PrimitiveType primitiveType) {
        if(value == null || checkValueType(value, primitiveType)) {
            this.value = value;
            this.primitiveType = primitiveType;
        }
        else {
            txtWriter.writeMessage(StringUtils.formatError("MyJAVAValue: " + "Entered value is not accepted for type " + primitiveType));
        }
    }

    public Object getValue() {
        return this.value;
    }

    public PrimitiveType getPrimitiveType() {
        return this.primitiveType;
    }

    public void setPrimitiveType(PrimitiveType primitiveType) {
        this.primitiveType = primitiveType;
    }

    public void reset() {
        this.value = this.defaultValue;
    }

    /*
     * Marks this value as final if there is a final keyword
     */
    public void markFinal() {
        this.finalFlag = true;
    }

    public boolean isFinal() {
        return this.finalFlag;
    }

    public void setValue(String value) {

        if(this.primitiveType == PrimitiveType.NOT_YET_IDENTIFIED) {
            txtWriter.writeMessage(StringUtils.formatError("MyJAVAValue: " + "Primitive type is not yet identified."));
        }
        else if(this.primitiveType == PrimitiveType.STRING) {
            this.value = StringUtils.removeQuotes(value);
        }
        else if(this.primitiveType == PrimitiveType.ARRAY) {
            txtWriter.writeMessage(StringUtils.formatError("MyJAVAValue: " + this.primitiveType + " is an array. Cannot directly change value."));
        }
        else {
            //attempts to type cast the value
            this.value = this.attemptTypeCast(value);
        }
    }


    private Object attemptTypeCast(String value) {
        switch(this.primitiveType) {
            case BOOLEAN: return Boolean.valueOf(value);
            case BYTE: return Byte.valueOf(value);
            case CHAR: return value.charAt(0); //only get first char at value
            case INT: return Integer.valueOf(value);
            case LONG: return Long.valueOf(value);
            case SHORT: return Short.valueOf(value);
            case FLOAT: return Float.valueOf(value);
            case DOUBLE: return Double.valueOf(value);
            case STRING: return value;
            default: return null;
        }
    }


    public static boolean checkValueType(Object value, PrimitiveType primitiveType) {
        switch(primitiveType) {
            case BOOLEAN:
                return value instanceof Boolean;
            case CHAR:
                return value instanceof Character;
            case INT:
                return value instanceof Integer;
            case BYTE:
                return value instanceof Byte;
            case SHORT:
                return value instanceof Short;
            case LONG:
                return value instanceof Long;
            case FLOAT:
                return value instanceof Float;
            case DOUBLE:
                return value instanceof Double;
            case STRING:
                return value instanceof String;
            case ARRAY:
                return value != null;
            default:
                return false;
        }
    }

    /*
     * Utility function.
     * Attempts to add an empty variable based from keywords
     */
    public static MyJAVAValue createEmptyVariableFromKeywords(String primitiveTypeString) {

        //identify primitive type
        PrimitiveType primitiveType = RecognizedKeywords.setPrimitiveType(primitiveTypeString);

        //return empty MyJAVA value
        return new MyJAVAValue(null, primitiveType);
    }

}
