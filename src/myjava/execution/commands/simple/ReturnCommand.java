/**
 * 
 */
package myjava.execution.commands.simple;

import myjava.error.checkers.TypeChecker;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.representations.MobiFunction;
import myjava.semantics.representations.MobiValue;
import myjava.semantics.utils.AssignmentUtils;

/**
 * Represents a return command which is specially used by a function.
 * @author NeilDG
 *
 */
public class ReturnCommand implements ICommand {
	private final static String TAG = "MobiProg_ReturnCommand";
	
	private ExpressionContext expressionCtx;
	private MobiFunction assignedMobiFunction;
	
	public ReturnCommand(ExpressionContext expressionCtx, MobiFunction mobiFunction) {
		this.expressionCtx = expressionCtx;
		this.assignedMobiFunction = mobiFunction;
		
		UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.expressionCtx);
		undeclaredChecker.verify();
		
		MobiValue mobiValue = this.assignedMobiFunction.getReturnValue();
		TypeChecker typeChecker = new TypeChecker(mobiValue, this.expressionCtx);
		typeChecker.verify();
	}
	
	/* (non-Javadoc)
	 * @see myjava.execution.commands.ICommand#execute()
	 */
	@Override
	public void execute() {
		EvaluationCommand evaluationCommand = new EvaluationCommand(this.expressionCtx);
		evaluationCommand.execute();
		
		MobiValue mobiValue = this.assignedMobiFunction.getReturnValue();
		
		AssignmentUtils.assignAppropriateValue(mobiValue, evaluationCommand.getResult());
		//Console.log(LogType.DEBUG,"Return value is: " +evaluationCommand.getResult().toEngineeringString());
	}

}
