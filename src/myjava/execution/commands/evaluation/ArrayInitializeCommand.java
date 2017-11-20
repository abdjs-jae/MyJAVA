package myjava.execution.commands.evaluation;

import myjava.execution.commands.ICommand;
import myjava.generatedexp.JavaParser.ArrayCreatorRestContext;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAArray;

/**
 * Represents an initialization of an array using new int[x] for example.
 *
 */
public class ArrayInitializeCommand implements ICommand {
	
	private MyJAVAArray assignedMyJAVAArray;
	private ArrayCreatorRestContext arrayCreatorCtx;
	
	public ArrayInitializeCommand(MyJAVAArray myJAVAArray, ArrayCreatorRestContext arrayCreatorCtx) {
		assignedMyJAVAArray = myJAVAArray;
		this.arrayCreatorCtx = arrayCreatorCtx;
	}
	@Override
	public void execute() {
		ExpressionContext exprCtx = arrayCreatorCtx.expression(0);
		
		if(exprCtx != null) {
			EvaluationCommand evaluationCommand = new EvaluationCommand(exprCtx);
			evaluationCommand.execute();
			
			assignedMyJAVAArray.initializeSize(evaluationCommand.getResult().intValue());
		}
		
	}

}
