/**
 * 
 */
package myjava.execution.adders;

import myjava.execution.commands.ICommand;
import myjava.semantics.representations.MyJAVAFunction;

/**
 * Handles adding of commands to a certain function

 *
 */
public class FunctionExecutionAdder implements IExecutionAdder {

	private MyJAVAFunction assignedMyJAVAFunction;
	
	public FunctionExecutionAdder(MyJAVAFunction myJAVAFunction) {
		this.assignedMyJAVAFunction = myJAVAFunction;
	}
	
	/* (non-Javadoc)
	 * @see myjava.execution.adders.IExecutionAdder#addCommand(myjava.execution.commands.ICommand)
	 */
	@Override
	public void addCommand(ICommand command) {
		this.assignedMyJAVAFunction.addCommand(command);
	}
	
	public MyJAVAFunction getAssignedFunction() {
		return this.assignedMyJAVAFunction;
	}

}
