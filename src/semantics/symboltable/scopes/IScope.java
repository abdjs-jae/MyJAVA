package semantics.symboltable.scopes;

import semantics.representations.MyJAVAValue;

public interface IScope {

    MyJAVAValue searchVariableIncludingLocal(String identifier);
    boolean isParent();

}
