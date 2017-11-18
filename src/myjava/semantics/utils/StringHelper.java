package myjava.semantics.utils;

import myjava.errors.TXTWriter;

public class StringHelper {

    public static String removeQuotes(String stringWithQuotes) {
        return stringWithQuotes.replace("\"", "");
    }
    public static String formatCustomError(int lineNum, String message) {
        return formatError("Line " + lineNum + ": " + message);
    }
    public static String formatError(String message){ return "[ERROR] " + message; }
    public static String formatProgram(String message){ return "[PROGR] " + message; }
    public static String formatDebug(String message){ return "[DEBUG] " + message; }
}
