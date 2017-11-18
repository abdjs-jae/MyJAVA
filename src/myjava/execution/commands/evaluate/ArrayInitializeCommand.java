package myjava.execution.commands.evaluate;
 
import myjava.execution.commands.ICommand;
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAArray;
import myjava.execution.commands.evaluate.EvaluationCommand;

/**
 * Represents an initialization of an array using new int[x] for example.
 * @author NeilDG
 *
 */
public class ArrayInitializeCommand implements ICommand {
    private final static String TAG = "ArrayInitializeCommand";

    private MyJAVAArray assignedMyJAVAArray;
    private ArrayCreatorRestContext arrayCreatorCtx;

    public ArrayInitializeCommand(MyJAVAArray myJAVAArray, ArrayCreatorRestContext arrayCreatorCtx) {
        this.assignedMyJAVAArray = myJAVAArray;
        this.arrayCreatorCtx = arrayCreatorCtx;
    }

    /* (non-Javadoc)
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        ExpressionContext exprCtx = this.arrayCreatorCtx.expression(0);

        if(exprCtx != null) {
            EvaluationCommand evaluationCommand = new EvaluationCommand(exprCtx);
            evaluationCommand.execute();

            this.assignedMyJAVAArray.initializeSize(evaluationCommand.getResult().intValue());
        }

    }

}