package myjava.semantics.utils;

import myjava.errors.TXTWriter;

public class StringUtils {

    public static String removeQuotes(String stringWithQuotes) {
        return stringWithQuotes.replace("\"", "");
    }
    public static String formatError(String message){ return "[ERROR] " + message; }
    public static String formatProgram(String message){ return "[PROGR] " + message; }
    public static String formatDebug(String message){ return "[DEBUG] " + message; }
}
