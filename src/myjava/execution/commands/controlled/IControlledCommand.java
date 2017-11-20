package myjava.execution.commands.controlled;

import myjava.execution.commands.ICommand;

/*
 * An interface for controlled command
 * @author NeilDG
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
	/*public void setParent(IControlledCommand command);
	public IControlledCommand getParent();
	public boolean hasParent();*/
}
