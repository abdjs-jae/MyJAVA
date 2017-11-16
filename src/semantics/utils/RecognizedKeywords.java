package semantics.utils;

import semantics.representations.MyJAVAValue.PrimitiveType;

public class RecognizedKeywords {

    public static String PRIMITIVE_TYPE_BOOLEAN = "boolean";
    public static String PRIMITIVE_TYPE_CHAR = "char";
    public static String PRIMITIVE_TYPE_INT = "int";
    public static String PRIMITIVE_TYPE_BYTE = "byte";
    public static String PRIMITIVE_TYPE_SHORT = "short";
    public static String PRIMITIVE_TYPE_LONG = "long";
    public static String PRIMITIVE_TYPE_FLOAT = "float";
    public static String PRIMITIVE_TYPE_DOUBLE = "double";
    public static String PRIMITIVE_TYPE_STRING = "String";

    public static String BOOLEAN_TRUE = "true";
    public static String BOOLEAN_FALSE = "false";


    /*
     * Returns true if the keywords match. This is case-sensitive
     * Thus, a function to always keep the String keyword in lower case is needed
     * this is called.
     */
    public static boolean matchesKeyword(String keyword, String textToMatch) {
        if(textToMatch.contains(keyword)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static PrimitiveType setPrimitiveType(String primitiveTypeString) {
        if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
            return PrimitiveType.BOOLEAN;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BYTE, primitiveTypeString)) {
            return PrimitiveType.BYTE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_CHAR, primitiveTypeString)) {
            return PrimitiveType.CHAR;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_DOUBLE, primitiveTypeString)) {
            return PrimitiveType.DOUBLE;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
            return PrimitiveType.FLOAT;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
            return PrimitiveType.INT;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_LONG, primitiveTypeString)) {
            return PrimitiveType.LONG;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_SHORT, primitiveTypeString)) {
            return PrimitiveType.SHORT;
        }
        else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
            return PrimitiveType.STRING;
        }
        return PrimitiveType.NOT_YET_IDENTIFIED;
    }
}
