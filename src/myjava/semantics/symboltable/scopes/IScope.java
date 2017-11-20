/**
 * 
 */
package myjava.semantics.symboltable.scopes;

import myjava.semantics.representations.MobiValue;

/**
 * A generic scope interface
 * @author NeilDG
 *
 */
public interface IScope {

	MobiValue searchVariableIncludingLocal(String identifier);
	boolean isParent();
}
