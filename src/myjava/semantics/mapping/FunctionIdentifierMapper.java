package myjava.semantics.mapping;

import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.builder.ParserHandler; 
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.ClassScope; 
import myjava.semantics.symboltable.scopes.LocalScope; 
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

/**
 * Maps an identifier to a given value found in the function level. First, we search the mapped parameters if a variable already exists.
 * Then we search its parent local scope using depth-first search.
 * @author NeilDG
 *
 */
public class FunctionIdentifierMapper implements ParseTreeListener, IValueMapper {
    private final static String TAG = "MyJAVA_FunctionIdentifierMapper";

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

    public void analyze(ExpressionContext exprCtx) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprCtx);
    }

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
                this.searchVariable(variableKey);
            }
        }
    }

    private void searchVariable(String identifierString) {
        if(this.assignedFunction.hasParameter(identifierString)) {
            this.modifiedExp = this.modifiedExp.replace(identifierString, this.assignedFunction.getParameter(identifierString).getValue().toString());
        }
        else {
            this.myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, this.functionLocalScope);

            if(this.myJAVAValue != null) {
                this.modifiedExp = this.modifiedExp.replace(identifierString, this.myJAVAValue.getValue().toString());
            }
            else {
                ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
                this.myJAVAValue = classScope.searchVariableIncludingLocal(identifierString);

                //Console.log("Variable in global scope: " +this.mobiValue.getValue());
                this.modifiedExp = this.modifiedExp.replace(identifierString, this.myJAVAValue.getValue().toString());
            }
        }
    }

    @Override
    public String getOriginalExp() {
        return this.originalExp;
    }

    @Override
    public String getModifiedExp() {
        return this.modifiedExp;
    }

    @Override
    public MyJAVAValue getMyJAVAValue() {
        return this.myJAVAValue;
    }
}