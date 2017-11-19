package myjava.semantics.mapping;

import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.scoping.LocalScope;
import myjava.semantics.scoping.LocalScopeCreator;

/**
 * Maps an identifier to a given value found in the function level. First, we search the mapped parameters if a variable already exists.
 * Then we search its parent local scope using depth-first search.
 * @author NeilDG
 *
 */
public class FunctionIdentifierMapper implements ParseTreeListener, IValueMapper {

    private String originalExp = null;
    private String modifiedExp = null;

    private MyJAVAFunction assignedFunction;
    private MyJAVAValue myJAVAValue;
    private LocalScope functionLocalScope;

    public FunctionIdentifierMapper(String originalExp, MyJAVAFunction assignedFunction) {
        this.originalExp = originalExp;
        this.modifiedExp = originalExp;
        this.assignedFunction = assignedFunction;
        this.functionLocalScope = assignedFunction.getParentLocalScope();
    }

    public void analyze(ExpressionContext exprContext) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprContext);
    }

    public void analyze(ParExpressionContext exprContext) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprContext);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {
        if(context instanceof PrimaryContext) {
            PrimaryContext primaryContext = (PrimaryContext) context;

            if(primaryContext.Identifier() != null) {
                String variableKey = primaryContext.getText();
                searchVariable(variableKey);
            }
        }
    }

    private void searchVariable(String identifierString) {
        if(assignedFunction.hasParameter(identifierString)) {
            modifiedExp = modifiedExp.replace(identifierString, assignedFunction.getParameter(identifierString).getValue().toString());
        }
        else {
            myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, functionLocalScope);

            if(myJAVAValue != null) {
                modifiedExp = modifiedExp.replace(identifierString, myJAVAValue.getValue().toString());
            }
            else {
                LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
                myJAVAValue = localScope.searchVariableIncludingLocal(identifierString);
                
                modifiedExp = modifiedExp.replace(identifierString, myJAVAValue.getValue().toString());
            }
        }
    }

    @Override
    public String getOriginalExp() {
        return originalExp;
    }

    @Override
    public String getModifiedExp() {
        return modifiedExp;
    }

    @Override
    public MyJAVAValue getMyJAVAValue() {
        return myJAVAValue;
    }
}