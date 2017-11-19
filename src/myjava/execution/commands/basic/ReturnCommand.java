package myjava.execution.commands.basic;

import myjava.errors.checkers.TypeChecker;
import myjava.errors.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluate.EvaluationCommand;
import myjava.MyJAVAParser.ExpressionContext;
//import myjava.generatedexp.JavaParser.ExpressionContext;
//import myjava.ide.console.Console;
//import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.representations.MyJAVAFunction; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.utils.AssignmentUtils;

/**
 * Represents a return command which is specially used by a function.
 * @author NeilDG
 *
 */
public class ReturnCommand implements ICommand {

    private ExpressionContext expressionContext;
    private MyJAVAFunction assignedMyJAVAFunction;

    public ReturnCommand(ExpressionContext expressionContext, MyJAVAFunction myJAVAFunction) {
        this.expressionContext = expressionContext;
        this.assignedMyJAVAFunction = myJAVAFunction;

        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.expressionContext);
        undeclaredChecker.check();

        MyJAVAValue myJAVAValue = this.assignedMyJAVAFunction.getReturnValue();
        TypeChecker typeChecker = new TypeChecker(myJAVAValue, this.expressionContext);
        typeChecker.check();
    }
    
    @Override
    public void execute() {
        EvaluationCommand evaluationCommand = new EvaluationCommand(this.expressionContext);
        evaluationCommand.execute();

        MyJAVAValue myJAVAValue = this.assignedMyJAVAFunction.getReturnValue();

        AssignmentUtils.assignAppropriateValue(myJAVAValue, evaluationCommand.getResult());
        //Console.log(LogType.DEBUG,"Return value is: " +evaluationCommand.getResult().toEngineeringString());
    }

}