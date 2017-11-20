/**
 * 
 */
package myjava.execution.commands.simple;

import myjava.error.checkers.TypeChecker;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.utils.AssignmentUtils;

/**
 * Represents a return command which is specially used by a function.

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
