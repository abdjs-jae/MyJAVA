package myjava.semantics.utils;

import java.util.HashMap;

import static myjava.ITextWriter.txtWriter;

/**
 * Holder for identified tokens found while parsing. Contains a key for easy retrieval of the actual text
 */
public class IdentifiedTokens {

    private HashMap<String, String> tokenMapping;

    public IdentifiedTokens() {
        this.tokenMapping = new HashMap<String, String>();
    }

    public void addToken(String key, String text) {
        this.tokenMapping.put(key, text);
    }

    public void removeToken(String key) {
        if(this.tokenMapping.containsKey(key)) {
            this.tokenMapping.remove(key);
        }
    }

    public String getToken(String key) {
        if(this.tokenMapping.containsKey(key)) {
            return this.tokenMapping.get(key);
        }
        else {
            //Log.e(TAG, key +" not found in list of tokens.");
            txtWriter.writeMessage(StringUtils.formatError("TokenRepository: " + key + "not found in the list of tokens"));
            return null;
        }
    }

    public int getTokenListLength() {
        return this.tokenMapping.size();
    }


    /*
     * Returns true if all of the specified keys has been found
     */
    public boolean containsTokens(String...keys) {
        for (String key : keys) {
            if (!this.tokenMapping.containsKey(key)) {
                return false;
            }
        }

        return true;
    }

    public void clearTokens() {
        this.tokenMapping.clear();
    }
}