package myjava.execution.commands.controlled;

import myjava.execution.ICommand;
import myjava.execution.commands.controlled.IControlledCommand.ControlTypeEnum;


public interface IConditionalCommand extends ICommand {

    public abstract ControlTypeEnum getControlType();
    public abstract void addPositiveCommand(ICommand command);
    public abstract void addNegativeCommand(ICommand command);
}