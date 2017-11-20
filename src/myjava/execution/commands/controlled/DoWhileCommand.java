package myjava.execution.commands.controlled;

import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.commands.ICommand;
import myjava.antlrgen.MyJAVAParser.ParExpressionContext;

/**
 * Represents a do while command which is essentially a modified while command
 *
 */
public class DoWhileCommand extends WhileCommand {
	
	public DoWhileCommand(ParExpressionContext parExprCtr) {
		super(parExprCtr);
	}

	@Override
	public void execute() {
		executeFirstCommandSequence();
		super.execute();
	}
	
	/*
	 * Executes the first command sequence before actually executing the behavior for the while command
	 */
	private void executeFirstCommandSequence() {
		identifyVariables();
		
		ExecutionMonitor executionMonitor = ExecutionManager.getExecutionManager().getExecutionMonitor();
		
		try {
			for(ICommand command : commandSequences) {
				executionMonitor.tryExecution();
				command.execute();
			}
			
		} catch(InterruptedException e) {
			System.err.println("DoWhileCommand: Monitor block interrupted! " +e.getMessage());
		}
	}

	@Override
	public ControlTypeEnum getControlType() {
		return ControlTypeEnum.DO_WHILE_CONTROL;
	}
}
