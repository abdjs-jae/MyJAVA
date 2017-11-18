package myjava.semantics.mapping;

import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.ClassScope;

/**
 * Maps an identifier to a given value found in the symbol table manager in the class level.
 * @author NeilDG
 *
 */
public class ClassIdentifierMapper implements ParseTreeListener, IValueMapper {

    private MyJAVAValue myJAVAValue;
    private String originalExp = null;
    private String modifiedExp = null;

    public ClassIdentifierMapper(String originalExp) {
        this.originalExp = originalExp;
        this.modifiedExp = originalExp;
    }

    /* (non-Javadoc)
     * @see myjava.semantics.mapping.IValueMapper#analyze(myjava.generatedexp.JavaParser.ExpressionContext)
     */
    @Override
    public void analyze(ExpressionContext exprContext) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprContext);
    }

    /* (non-Javadoc)
     * @see myjava.semantics.mapping.IValueMapper#analyze(myjava.generatedexp.JavaParser.ParExpressionContext)
     */
    @Override
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
                LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();

                myJAVAValue = localScope.searchVariableIncludingLocal(variableKey);
                modifiedExp = modifiedExp.replace(variableKey, myJAVAValue.getValue().toString());
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