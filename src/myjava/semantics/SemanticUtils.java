package myjava.semantics;

import myjava.execution.ExecutionManager;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IConditionalCommand;
import myjava.execution.commands.controlled.IControlledCommand;

/**
 * Created by jasonsapdos on 19/11/2017.
 */
public class SemanticUtils {
    public static void addToConditionalCommand(ICommand command){
        StatementControlOverseer statementControl = StatementControlOverseer.getInstance();

        if(statementControl.isInConditionalCommand()) {
            IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();

            if(statementControl.isInPositiveRule()) {
                conditionalCommand.addPositiveCommand(command);
            }
            else {
                conditionalCommand.addNegativeCommand(command);
            }
        }

        else if(statementControl.isInControlledCommand()) {
            IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
            controlledCommand.addCommand(command);
        }
        else {
            ExecutionManager.getExecutionManager().addCommand(command);
        }
    }
}
