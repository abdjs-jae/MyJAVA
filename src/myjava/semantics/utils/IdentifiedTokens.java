/**
 * 
 */
package myjava.semantics.utils;

import android.util.Log;

import java.util.HashMap;

/**
 * Holder for identified tokens found while parsing. Contains a key for easy retrieval of the actual text

 *
 */
public class IdentifiedTokens {

	private final static String TAG = "MyJAVAProg_IdentifiedTokens";
	
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
			Log.e(TAG, key +" not found in list of tokens.");
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
		for(int i = 0; i < keys.length; i++) {
			if(!this.tokenMapping.containsKey(keys[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public void clearTokens() {
		this.tokenMapping.clear();
	}
}
