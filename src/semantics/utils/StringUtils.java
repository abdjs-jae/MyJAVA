package semantics.utils;

public class StringUtils {

    public static String removeQuotes(String stringWithQuotes) {
        return stringWithQuotes.replace("\"", "");
    }
}
