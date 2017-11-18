package myjava.execution.commands.basic;

import myjava.builder.errorcheckers.TypeChecker; 
import myjava.builder.errorcheckers.UndeclaredChecker; 
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluate.EvaluationCommand; 
import myjava.generatedexp.JavaParser.ExpressionContext; 
import myjava.ide.console.Console; 
import myjava.ide.console.LogItemView.LogType; 
import myjava.semantics.representations.MyJAVAFunction; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.utils.AssignmentUtils;

/**
 * Represents a return command which is specially used by a function.
 * @author NeilDG
 *
 */
public class ReturnCommand implements ICommand {
    private final static String TAG = "MyJAVAProg_ReturnCommand";

    private ExpressionContext expressionCtx;
    private MyJAVAFunction assignedMyJAVAFunction;

    public ReturnCommand(ExpressionContext expressionCtx, MyJAVAFunction myJAVAFunction) {
        this.expressionCtx = expressionCtx;
        this.assignedMyJAVAFunction = myJAVAFunction;

        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.expressionCtx);
        undeclaredChecker.verify();

        MyJAVAValue myJAVAValue = this.assignedMyJAVAFunction.getReturnValue();
        TypeChecker typeChecker = new TypeChecker(myJAVAValue, this.expressionCtx);
        typeChecker.verify();
    }

    /* (non-Javadoc)
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        EvaluationCommand evaluationCommand = new EvaluationCommand(this.expressionCtx);
        evaluationCommand.execute();

        MyJAVAValue myJAVAValue = this.assignedMyJAVAFunction.getReturnValue();

        AssignmentUtils.assignAppropriateValue(myJAVAValue, evaluationCommand.getResult());
        //Console.log(LogType.DEBUG,"Return value is: " +evaluationCommand.getResult().toEngineeringString());
    }

}