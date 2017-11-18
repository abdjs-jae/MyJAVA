package myjava.semantics.mapping;

import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.builder.ParserHandler; 
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
    public void analyze(ExpressionContext exprCtx) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprCtx);
    }

    /* (non-Javadoc)
     * @see myjava.semantics.mapping.IValueMapper#analyze(myjava.generatedexp.JavaParser.ParExpressionContext)
     */
    @Override
    public void analyze(ParExpressionContext exprCtx) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprCtx);
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
    public void enterEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof PrimaryContext) {
            PrimaryContext primaryCtx = (PrimaryContext) ctx;

            if(primaryCtx.Identifier() != null) {
                String variableKey = primaryCtx.getText();
                ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());

                this.myJAVAValue = classScope.searchVariableIncludingLocal(variableKey);
                this.modifiedExp = this.modifiedExp.replace(variableKey, this.myJAVAValue.getValue().toString());
            }
        }
    }

    @Override
    public MyJAVAValue getMyJAVAValue() {
        return this.myJAVAValue;
    }

    /* (non-Javadoc)
     * @see myjava.semantics.mapping.IValueMapper#getOriginalExp()
     */
    @Override
    public String getOriginalExp() {
        return this.originalExp;
    }

    /* (non-Javadoc)
     * @see myjava.semantics.mapping.IValueMapper#getModifiedExp()
     */
    @Override
    public String getModifiedExp() {
        return this.modifiedExp;
    }

}