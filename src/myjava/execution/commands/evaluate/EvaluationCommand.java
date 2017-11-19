package myjava.execution.commands.evaluate;

import java.math.BigDecimal; 
import java.util.List;

import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.execution.commands.ICommand;
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAFunction; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.searcher.VariableSearcher;
import myjava.semantics.utils.Expression; 
import myjava.semantics.utils.RecognizedKeywords;

/**
 * A command that evaluates a given expression at runtime.
 * @author Patrick
 *
 */
public class EvaluationCommand implements ICommand, ParseTreeListener {

    private ExpressionContext parentExprContext;
    private String modifiedExp;
    private BigDecimal resultValue;

    public EvaluationCommand(ExpressionContext exprContext) {
        this.parentExprContext = exprContext;
    }

    @Override
    public void execute() {
        modifiedExp = parentExprContext.getText();

        //catch rules if the value has direct boolean flags
        if(modifiedExp.contains(RecognizedKeywords.BOOLEAN_TRUE)) {
            resultValue = new BigDecimal(1);
        }
        else if(modifiedExp.contains(RecognizedKeywords.BOOLEAN_FALSE)) {
            resultValue = new BigDecimal(0);
        }
        else {
            ParseTreeWalker treeWalker = new ParseTreeWalker();
            treeWalker.walk(this, parentExprContext);

            Expression evalEx = new Expression(this.modifiedExp);
            //Log.i(TAG,"Modified exp to eval: " +this.modifiedExp);
            resultValue = evalEx.eval();
        }

    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext context) {
        if (context instanceof ExpressionContext) {
            ExpressionContext exprContext = (ExpressionContext) context;
            if (EvaluationCommand.isFunctionCall(exprContext)) {
                this.evaluateFunctionCall(exprContext);
            }

            else if (EvaluationCommand.isVariableOrConst(exprContext)) {
                this.evaluateVariable(exprContext);
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {

    }

    public static boolean isFunctionCall(ExpressionContext exprContext) {
        return exprContext.arguments() != null;
    }

    public static boolean isVariableOrConst(ExpressionContext exprContext) {
        return exprContext.primary() != null && exprContext.primary().Identifier() != null;
    }

    private void evaluateFunctionCall(ExpressionContext exprContext) {
        String functionName = exprContext.expression(0).Identifier().getText();
        
        LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
        MyJAVAFunction myJAVAFunction = localScope.searchFunction(functionName);

        if (exprContext.arguments().expressionList() != null) {
            List<ExpressionContext> exprContextList = exprContext.arguments()
                    .expressionList().expression();

            for (int i = 0; i < exprContextList.size(); i++) {
                ExpressionContext parameterExprContext = exprContextList.get(i);

                EvaluationCommand evaluationCommand = new EvaluationCommand(parameterExprContext);
                evaluationCommand.execute();

                myJAVAFunction.mapParameterByValueAt(evaluationCommand.getResult().toEngineeringString(), i);
            }
        }

        myJAVAFunction.execute();

        //Log.i(TAG, "Before modified EXP function call: " + modifiedExp);
        this.modifiedExp = modifiedExp.replace(exprContext.getText(),
                myJAVAFunction.getReturnValue().getValue().toString());
        //Log.i(TAG, "After modified EXP function call: " + modifiedExp);

    }

    private void evaluateVariable(ExpressionContext exprContext) {
        MyJAVAValue myJAVAValue = VariableSearcher
                .searchVariable(exprContext.getText());

        this.modifiedExp = modifiedExp.replaceFirst(exprContext.getText(),
                myJAVAValue.getValue().toString());
    }

    /*
     * Returns the result
     */
    public BigDecimal getResult() {
        return resultValue;
    }
}