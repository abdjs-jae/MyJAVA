/**
 * 
 */
package myjava.semantics.symboltable.scopes;

import myjava.semantics.representations.MobiValue;

/**
 * A generic scope interface
 *
 *
 */
public interface IScope {

	MobiValue searchVariableIncludingLocal(String identifier);
	boolean isParent();
}
