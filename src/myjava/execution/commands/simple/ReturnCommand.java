package myjava.execution.commands.simple;

import myjava.error.checkers.TypeChecker;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.utils.AssignmentUtils;

/**
 * Represents a return command which is specially used by a function.
 *
 */
public class ReturnCommand implements ICommand {
	
	private ExpressionContext expressionCtx;
	private MyJAVAFunction assignedMyJAVAFunction;
	
	public ReturnCommand(ExpressionContext expressionCtx, MyJAVAFunction myJAVAFunction) {
		this.expressionCtx = expressionCtx;
		assignedMyJAVAFunction = myJAVAFunction;
		
		UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.expressionCtx);
		undeclaredChecker.verify();
		
		MyJAVAValue myJAVAValue = assignedMyJAVAFunction.getReturnValue();
		TypeChecker typeChecker = new TypeChecker(myJAVAValue, this.expressionCtx);
		typeChecker.verify();
	}

	@Override
	public void execute() {
		EvaluationCommand evaluationCommand = new EvaluationCommand(expressionCtx);
		evaluationCommand.execute();
		
		AssignmentUtils.assignAppropriateValue(assignedMyJAVAFunction.getReturnValue(), evaluationCommand.getResult());
		//Console.log(LogType.DEBUG,"Return value is: " +evaluationCommand.getResult().toEngineeringString());
	}

}
