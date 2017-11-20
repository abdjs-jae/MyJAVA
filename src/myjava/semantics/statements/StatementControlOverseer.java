package myjava.semantics.statements;

import myjava.antlrgen.ITextWriter;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IConditionalCommand;
import myjava.execution.commands.controlled.IControlledCommand;
import myjava.semantics.utils.StringUtils;

import java.util.Stack;

/**
 * A singleton class that detects if a certain statement is inside a controlled statement
 * Contains utility functions to add certain commands into the active controlled command.
 * This class makes nested statements possible.
 *
 */
public class StatementControlOverseer implements ITextWriter{
	
	private static StatementControlOverseer scOverseer = null;
	
	public static StatementControlOverseer getInstance() {
		return scOverseer;
	}
	
	private Stack<ICommand> procedureCallStack;
	private ICommand activeControlledCommand = null;
	
	private boolean isInPositive = true; //used for conditional statements to indicate if the series of commands should go to the positive command list.
	
	private StatementControlOverseer() {
		procedureCallStack = new Stack<>();
		
		System.err.println("StatementControlOverseer: Stack initialized!");
	}
	
	public static void initialize() {
		scOverseer = new StatementControlOverseer();
	}
	
	public static void reset() {
		scOverseer.procedureCallStack.clear();
		scOverseer.activeControlledCommand = null;
	}
	
	public void openConditionalCommand(IConditionalCommand command) {
		if(procedureCallStack.isEmpty()) {
			procedureCallStack.push(command);
			activeControlledCommand = command;
		}
		else {
			processAdditionOfCommand(command);
		}
		
		isInPositive = true;
		
	}
	
	/*
	 * Opens a new controlled command
	 */
	public void openControlledCommand(IControlledCommand command) {
		procedureCallStack.push(command);
		activeControlledCommand = command;
	}
	
	public boolean isInPositiveRule() {
		return isInPositive;
	}
	
	public void reportExitPositiveRule() {
		isInPositive = false;
	}
	
	/*
	 * Processes the proper addition of commands.
	 */
	private void processAdditionOfCommand(ICommand command) {
		
		//if the current active controlled command is that of a conditional command,
		//we either add the newly opened command as either positive or a negative command
		if(isInConditionalCommand()) {
			IConditionalCommand conditionalCommand = (IConditionalCommand) activeControlledCommand;
			
			if(isInPositiveRule()) {
				conditionalCommand.addPositiveCommand(command);
			}
			else {
				conditionalCommand.addNegativeCommand(command);
			}
			
			procedureCallStack.push(command);
			activeControlledCommand = command;
		}
		//just add the newly opened command as a command under the last active controlled command.
		else {
			
			IControlledCommand controlledCommand = (IControlledCommand) activeControlledCommand;
			controlledCommand.addCommand(command);

			txtWriter.writeMessage(StringUtils.formatDebug("Adding command to " + controlledCommand.getControlType()));
			
			procedureCallStack.push(command);
			activeControlledCommand = command;
		}
	}
	
	
	/*
	 * Closes the current active controlled command and adds the root controlled command to the execution manager.
	 * The active controlled command is set to null.
	 */
	public void compileControlledCommand() {
		
		//we arrived at the root node, therefore we add this now to the execution manager
		if(procedureCallStack.size() == 1) {
			ICommand rootCommand = procedureCallStack.pop();
			ExecutionManager.getExecutionManager().addCommand(rootCommand);
			
			activeControlledCommand = null;
		}
		//we pop then add it to the next root node
		else if(procedureCallStack.size() > 1) {
			ICommand childCommand = procedureCallStack.pop();
			ICommand parentCommand = procedureCallStack.peek();
			activeControlledCommand = parentCommand;
			
			if(parentCommand instanceof IControlledCommand) {
				IControlledCommand controlledCommand = (IControlledCommand) parentCommand;
				controlledCommand.addCommand(childCommand);

			}
		}
		else {
			System.out.println("StatementControlOverseer: Procedure call stack is now empty.");
		}
	}
	
	public boolean isInConditionalCommand() {
		return (activeControlledCommand != null && activeControlledCommand instanceof IConditionalCommand);
	}
	
	public boolean isInControlledCommand() {
		return (activeControlledCommand!= null && activeControlledCommand instanceof IControlledCommand);
	}
	
	public ICommand getActiveControlledCommand() {
		return activeControlledCommand;
	}
}
