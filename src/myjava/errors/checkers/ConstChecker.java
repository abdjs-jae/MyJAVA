package myjava.errors.checkers;

import myjava.MyJAVAParser.*;
import myjava.errors.MyJAVAErrorStrategy;
import myjava.execution.ExecutionManager;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searcher.VariableSearcher;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ConstChecker implements IChecker, ParseTreeListener{
    private ExpressionContext exprContext;
    private int lineNum;

    public ConstChecker(ExpressionContext exprContext) {
        this.exprContext = exprContext;
        lineNum = exprContext.getStart().getLine();
    }

    @Override
    public void check() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.exprContext);
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
        if(context instanceof ExpressionContext) {
            ExpressionContext exprContext = (ExpressionContext) context;
            if(EvaluationCommand.isVariableOrConst(exprContext)) {
                this.verifyVariableOrConst(exprContext);
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {
        // TODO Auto-generated method stub

    }

    private void verifyVariableOrConst(ExpressionContext varExprContext) {
        MyJAVAValue myJAVAValue = null;

        if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
            MyJAVAFunction myJAVAFunction = ExecutionManager.getExecutionManager().getCurrentFunction();
            myJAVAValue = VariableSearcher.searchVariableInFunction(myJAVAFunction, varExprContext.primary().Identifier().getText());
        }

        //if after function finding, myJAVA value is still null, search class
        if(myJAVAValue == null) {
            LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
            myJAVAValue = VariableSearcher.searchVariableLocal(localScope, varExprContext.primary().Identifier().getText());
        }

        if(myJAVAValue != null && myJAVAValue.isFinal()) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.CONST_REASSIGNMENT, varExprContext.getText(), lineNum);
        }
    }
}
