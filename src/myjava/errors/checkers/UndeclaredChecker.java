package myjava.errors.checkers;

import myjava.ITextWriter;
import myjava.MyJAVAParser.*;
import myjava.errors.MyJAVAErrorStrategy;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.evaluate.EvaluationCommand;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searcher.VariableSearcher;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class UndeclaredChecker implements IChecker, ITextWriter, ParseTreeListener{
    private ExpressionContext exprContext;
    private int lineNum;

    public UndeclaredChecker(ExpressionContext exprContext) {
        this.exprContext = exprContext;
        lineNum = exprContext.getStart().getLine();
    }

    @Override
    public void check() {
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
        if(context instanceof ExpressionContext) {
            ExpressionContext exprContext = (ExpressionContext) context;
            if(EvaluationCommand.isFunctionCall(exprContext)) {
                verifyFunctionCall(exprContext);
            }
            else if(EvaluationCommand.isVariableOrConst(exprContext)) {
                verifyVariableOrConst(exprContext);
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {
        // TODO Auto-generated method stub

    }

    private void verifyFunctionCall(ExpressionContext funcExprContext) {

        // No need for this since MyJAVA is not an object-oriented language.

        if(funcExprContext.expression(0).Identifier() == null)
            return;

        String functionName = funcExprContext.expression(0).Identifier().getText();

        LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
        MyJAVAFunction myJAVAFunction = localScope.searchFunction(functionName);

        if(myJAVAFunction == null) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.UNDECLARED_FUNCTION, functionName, lineNum);
        }
        else {
            txtWriter.writeMessage(StringUtils.formatDebug("Function found: " +functionName));
        }

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

        //after second pass, we conclude if it cannot be found already
        if(myJAVAValue == null) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.UNDECLARED_VARIABLE, varExprContext.getText(), lineNum);
        }
    }

    /*
     * Verifies a var or const identifier from a scan statement since scan grammar is different.
     */
    public static void verifyVarOrConstForScan(String identifier, StatementContext statementContext) {
        LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
        MyJAVAValue myJAVAValue = VariableSearcher.searchVariableLocal(localScope, identifier);

        if(myJAVAValue == null) {
            MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.UNDECLARED_VARIABLE, identifier, statementContext.getStart().getLine());
        }
    }
}
