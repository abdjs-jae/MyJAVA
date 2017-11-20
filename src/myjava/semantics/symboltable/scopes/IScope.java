package myjava.semantics.symboltable.scopes;

import myjava.semantics.representations.MyJAVAValue;

/**
 * A generic scope interface
 *
 */
public interface IScope {

	MyJAVAValue searchVariableIncludingLocal(String identifier);
	boolean isParent();
}
