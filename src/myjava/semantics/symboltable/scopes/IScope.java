package myjava.semantics.symboltable.scopes;

import myjava.semantics.representations.MyJAVAValue;

public interface IScope {

    MyJAVAValue searchVariableIncludingLocal(String identifier);
    boolean isParent();

}
