package myjava.errors.checkers;

import myjava.MyJAVAParser.*;
import myjava.errors.MyJAVAErrorStrategy;
import myjava.execution.ExecutionManager;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searcher.VariableSearcher;
import myjava.semantics.scoping.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MultipleVariableChecker implements IChecker, ParseTreeListener {

    private VariableDeclaratorIdContext varDecIdCtx;
    private int lineNum;

    public MultipleVariableChecker(VariableDeclaratorIdContext varDecIdCtx) {
        this.varDecIdCtx = varDecIdCtx;
        lineNum = varDecIdCtx.getStart().getLine();
    }

    @Override
    public void check() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.varDecIdCtx);
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
        if(ctx instanceof VariableDeclaratorIdContext) {
            VariableDeclaratorIdContext varDecCtx = (VariableDeclaratorIdContext) ctx;
            this.verifyVariableOrConst(varDecCtx.getText());
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void verifyVariableOrConst(String identifierString) {
        
        MyJAVAValue myJAVAValue = null;

        if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
            MyJAVAFunction myJAVAFunction = ExecutionManager.getExecutionManager().getCurrentFunction();
            myJAVAValue = VariableSearcher.searchVariableInFunction(myJAVAFunction, identifierString);
        }

        //if after function finding, myJAVA value is still null, search local scope
        if(myJAVAValue == null) {
            myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString,
                    LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope());
        }

        if(myJAVAValue != null) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.MULTIPLE_VARIABLE, identifierString, lineNum);
        }
    }
    
}
