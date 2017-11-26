package myjava.execution.commands.evaluation;

import myjava.error.MyJAVAErrorStrategy;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.ICommand;
import myjava.antlrgen.MyJAVAParser.ArrayCreatorRestContext;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.utils.StringUtils;

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
        System.out.println("another one");

		if(exprCtx != null) {
			EvaluationCommand evaluationCommand = new EvaluationCommand(exprCtx);
			System.out.println("ahhhhh");
			evaluationCommand.arrayExecute();
			//if(evaluationCommand.checkFloatArray(exprCtx.getText())) {
                assignedMyJAVAArray.initializeSize(evaluationCommand.getResult().intValue());
            //}

		}

	}

}
