package myjava.execution.evaluate;

import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.errors.checkers.ConstChecker;
import myjava.errors.checkers.TypeChecker;
import myjava.errors.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager; 
import myjava.execution.FunctionTracker; 
import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IConditionalCommand; 
import myjava.execution.commands.controlled.IControlledCommand; 
import myjava.execution.commands.basic.IntDecCommand;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser.*;
import myjava.semantics.analyzers.FunctionCallVerifier; 
import myjava.semantics.analyzers.StatementExpressionAnalyzer; 
import myjava.semantics.mapping.IValueMapper; 
import myjava.semantics.mapping.IdentifierMapper; 
import myjava.semantics.representations.MyJAVAArray; 
import myjava.semantics.representations.MyJAVAFunction; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.searcher.VariableSearcher;
import myjava.semantics.StatementControlOverseer;
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.utils.AssignmentUtils; 
import myjava.semantics.utils.Expression;

/**
 * A new assignment command that walks a given expression and replaces values to it
 * before being passed to Eval-Ex library.
 * @author Patrick
 *
 */
public class AssignmentCommand implements ICommand{

    private final static String TAG = "MyJAVA_NewAssignmentCommand";

    private ExpressionContext leftHandExprCtx;
    private ExpressionContext rightHandExprCtx;

    public AssignmentCommand(ExpressionContext leftHandExprCtx,
                             ExpressionContext rightHandExprCtx) {
        this.leftHandExprCtx = leftHandExprCtx;
        this.rightHandExprCtx = rightHandExprCtx;

        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.leftHandExprCtx);
        undeclaredChecker.check();

        ConstChecker constChecker = new ConstChecker(this.leftHandExprCtx);
        constChecker.check();

        undeclaredChecker = new UndeclaredChecker(this.rightHandExprCtx);
        undeclaredChecker.check();

        ParseTreeWalker functionWalker = new ParseTreeWalker();
        functionWalker.walk(new FunctionCallVerifier(), this.rightHandExprCtx);

        //type check the myJAVAvalue
        MyJAVAValue myJAVAValue;
        if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
            myJAVAValue = VariableSearcher.searchVariableInFunction(ExecutionManager.getExecutionManager().getCurrentFunction(), this.leftHandExprCtx.getText());
        }
        else {
            myJAVAValue = VariableSearcher.searchVariable(this.leftHandExprCtx.getText());
        }

        TypeChecker typeChecker = new TypeChecker(myJAVAValue, this.rightHandExprCtx);
        typeChecker.check();
    }

    /*
     * (non-Javadoc)
     * 
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        EvaluationCommand evaluationCommand = new EvaluationCommand(this.rightHandExprCtx);
        evaluationCommand.execute();

        if(this.isLeftHandArrayAccessor()) {
            this.handleArrayAssignment(evaluationCommand.getResult().toEngineeringString());
        }
        else {
            MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(this.leftHandExprCtx.getText());
            AssignmentUtils.assignAppropriateValue(myJAVAValue, evaluationCommand.getResult());
        }
    }

    private boolean isLeftHandArrayAccessor() {
        List<TerminalNode> lBrackTokens = this.leftHandExprCtx.getTokens(MyJAVALexer.LBRACK);
        List<TerminalNode> rBrackTokens = this.leftHandExprCtx.getTokens(MyJAVALexer.RBRACK);

        return(lBrackTokens.size() > 0 && rBrackTokens.size() > 0);
    }

    private void handleArrayAssignment(String resultString) {
        TerminalNode identifierNode = this.leftHandExprCtx.expression(0).primary().Identifier();
        ExpressionContext arrayIndexExprCtx = this.leftHandExprCtx.expression(1);

        MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(identifierNode.getText());
        MyJAVAArray myJAVAArray = (MyJAVAArray) myJAVAValue.getValue();

        EvaluationCommand evaluationCommand = new EvaluationCommand(arrayIndexExprCtx);
        evaluationCommand.execute();

        //create a new array value to replace value at specified index
        MyJAVAValue newArrayValue = new MyJAVAValue(null, myJAVAArray.getPrimitiveType());
        newArrayValue.setValue(resultString);
        myJAVAArray.updateValueAt(newArrayValue, evaluationCommand.getResult().intValue());

        //Console.log("Index to access: " +evaluationCommand.getResult().intValue()+ " Updated with: " +resultString);
    }
}