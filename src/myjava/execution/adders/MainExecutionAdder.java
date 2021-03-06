/**
 * 
 */
package myjava.execution.adders;

import myjava.execution.commands.ICommand;

import java.util.ArrayList;

/**
 * Handles adding of execution to the main control flow.
 *
 */
public class MainExecutionAdder implements IExecutionAdder {

	private ArrayList<ICommand> mainExecutionList;
	
	public MainExecutionAdder(ArrayList<ICommand> mainExecutionList) {
		this.mainExecutionList = mainExecutionList;
	}
	
	@Override
	public void addCommand(ICommand command) {
		this.mainExecutionList.add(command);
	}

}
