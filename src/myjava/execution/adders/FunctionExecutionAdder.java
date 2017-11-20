/**
 * 
 */
package myjava.execution.adders;

import myjava.execution.commands.ICommand;
import myjava.semantics.representations.MobiFunction;

/**
 * Handles adding of commands to a certain function
 * @author NeilDG
 *
 */
public class FunctionExecutionAdder implements IExecutionAdder {

	private MobiFunction assignedMobiFunction;
	
	public FunctionExecutionAdder(MobiFunction mobiFunction) {
		this.assignedMobiFunction = mobiFunction;
	}
	
	/* (non-Javadoc)
	 * @see myjava.execution.adders.IExecutionAdder#addCommand(myjava.execution.commands.ICommand)
	 */
	@Override
	public void addCommand(ICommand command) {
		this.assignedMobiFunction.addCommand(command);
	}
	
	public MobiFunction getAssignedFunction() {
		return this.assignedMobiFunction;
	}

}
