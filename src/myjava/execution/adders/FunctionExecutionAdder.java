package myjava.execution.adders;

import myjava.execution.commands.ICommand;
import myjava.semantics.representations.MyJAVAFunction;

/**
 * Handles adding of commands to a certain function
 * @author NeilDG
 *
 */
public class FunctionExecutionAdder implements IExecutionAdder {

    private MyJAVAFunction assignedMyJAVAFunction;

    public FunctionExecutionAdder(MyJAVAFunction myJAVAFunction) {
        assignedMyJAVAFunction = myJAVAFunction;
    }

    @Override
    public void addCommand(ICommand command) {
        assignedMyJAVAFunction.addCommand(command);
    }

    public MyJAVAFunction getAssignedMyJAVAFunction() {
        return assignedMyJAVAFunction;
    }
}