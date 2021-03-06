package myjava.execution.commands.controlled;

import myjava.execution.commands.ICommand;

/*
 * An interface for controlled command
 */
public interface IControlledCommand extends ICommand {
	enum ControlTypeEnum {
		CONDITIONAL_IF,
		DO_WHILE_CONTROL,
		WHILE_CONTROL,
		FOR_CONTROL,
		FUNCTION_TYPE
	}
	
	ControlTypeEnum getControlType();
	void addCommand(ICommand command);
}
