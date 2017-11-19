package myjava.semantics.analyzers;

import java.util.List;

import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.builder.ParserHandler; 
import myjava.errors.checkers.ParameterMismatchChecker;
import myjava.execution.ExecutionManager; 
import myjava.execution.commands.evaluate.EvaluationCommand;
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.LocalScope;

public class FunctionCallVerifier implements ParseTreeListener {

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
        if(ctx instanceof ExpressionContext) {
            ExpressionContext exprCtx = (ExpressionContext) ctx;
            if (EvaluationCommand.isFunctionCall(exprCtx)) {
                if(exprCtx.expression(0).Identifier() == null)
                    return;

                String functionName = exprCtx.expression(0).Identifier().getText();

                LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
                MyJAVAFunction myJAVAFunction = localScope.searchFunction(functionName);

                if (exprCtx.arguments() != null) {
                    ParameterMismatchChecker paramsMismatchChecker = new ParameterMismatchChecker(myJAVAFunction, exprCtx.arguments());
                    paramsMismatchChecker.check();
                }
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

}