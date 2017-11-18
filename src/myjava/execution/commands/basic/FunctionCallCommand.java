package myjava.execution.commands.basic;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import myjava.builder.ParserHandler; 
import myjava.builder.errorcheckers.ParameterMismatchChecker; 
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluate.EvaluationCommand;
import myjava.MyJAVAParser.ExpressionContext;
import myjava.ide.console.Console; 
import myjava.ide.console.LogItemView.LogType; 
import myjava.semantics.analyzers.FunctionCallVerifier; 
import myjava.semantics.mapping.IValueMapper; 
import myjava.semantics.mapping.IdentifierMapper; 
import myjava.semantics.representations.MyJAVAFunction; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.representations.MyJAVAValue.PrimitiveType; 
import myjava.semantics.searching.VariableSearcher; 
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.ClassScope;

/**
 * Represents a function call command
 * @author Patrick
 *
 */
public class FunctionCallCommand implements ICommand {
    private final static String TAG = "MyJAVAProg_FunctionCallCommand";

    private MyJAVAFunction myJAVAFunction;
    private ExpressionContext exprCtx;
    private String functionName;

    public FunctionCallCommand(String functionName, ExpressionContext exprCtx) {
        this.functionName = functionName;
        this.exprCtx = exprCtx;


        this.searchFunction();

        ParseTreeWalker functionWalker = new ParseTreeWalker();
        functionWalker.walk(new FunctionCallVerifier(), this.exprCtx);

        this.verifyParameters();
    }

    /* (non-Javadoc)
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        this.mapParameters();
        this.myJAVAFunction.execute();
    }

    private void searchFunction() {
        ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
        this.myJAVAFunction = classScope.searchFunction(this.functionName);
    }

    private void verifyParameters() {
        if(this.exprCtx.arguments() == null || this.exprCtx.arguments().expressionList() == null
                || this.exprCtx.arguments().expressionList().expression() == null) {
            return;
        }

        List<ExpressionContext> exprCtxList = this.exprCtx.arguments().expressionList().expression();
        //map values in parameters
        for(int i = 0; i < exprCtxList.size(); i++) {
            ExpressionContext parameterExprCtx = exprCtxList.get(i);
            this.myJAVAFunction.verifyParameterByValueAt(parameterExprCtx, i);
        }
    }

    /*
     * Maps parameters when needed
     */
    private void mapParameters() {
        if(this.exprCtx.arguments() == null || this.exprCtx.arguments().expressionList() == null
                || this.exprCtx.arguments().expressionList().expression() == null) {
            return;
        }

        List<ExpressionContext> exprCtxList = this.exprCtx.arguments().expressionList().expression();

        //map values in parameters
        for(int i = 0; i < exprCtxList.size(); i++) {
            ExpressionContext parameterExprCtx = exprCtxList.get(i);

            if(this.myJAVAFunction.getParameterAt(i).getPrimitiveType() == PrimitiveType.ARRAY) {
                MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(parameterExprCtx.getText());
                this.myJAVAFunction.mapArrayAt(myJAVAValue, i, parameterExprCtx.getText());
            }
            else {
                EvaluationCommand evaluationCommand = new EvaluationCommand(parameterExprCtx);
                evaluationCommand.execute();

                this.myJAVAFunction.mapParameterByValueAt(evaluationCommand.getResult().toEngineeringString(), i);
            }
        }
    }

    public MyJAVAValue getReturnValue() {
        return this.myJAVAFunction.getReturnValue();
    }

}