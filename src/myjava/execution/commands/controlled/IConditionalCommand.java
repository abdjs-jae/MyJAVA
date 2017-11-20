/**
 * 
 */
package myjava.execution.commands.controlled;

import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IControlledCommand.ControlTypeEnum;

/**
 * An interface conditional command to represent IF-ELSE statements
 * @author NeilDG
 *
 */
public interface IConditionalCommand extends ICommand {
	
	ControlTypeEnum getControlType();
	void addPositiveCommand(ICommand command);
	void addNegativeCommand(ICommand command);
}
