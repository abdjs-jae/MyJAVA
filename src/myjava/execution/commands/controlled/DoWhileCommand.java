package myjava.execution.commands.controlled;

import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.ICommand;
import myjava.semantics.utils.StringHelper;

import static myjava.ITextWriter.txtWriter;
//import myjava.generatedexp.JavaParser.ParExpressionContext;

/**
 * Represents a do while command which is essentially a modified while command
 * @author NeilDG
 *
 */
public class DoWhileCommand extends WhileCommand {

    private final static String TAG = "MyJAVA_DoWhileCommand";

    public DoWhileCommand(ParExpressionContext parExprCtr) {
        super(parExprCtr);
    }

    /* (non-Javadoc)
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        this.executeFirstCommandSequence();
        super.execute();
    }

    /*
     * Executes the first command sequence before actually executing the behavior for the while command
     */
    private void executeFirstCommandSequence() {
        this.identifyVariables();

        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();

        try {
            for(ICommand command : this.commandSequences) {
                executionMonitor.tryExecution();
                command.execute();
            }

        } catch(InterruptedException e) {
            //Log.e(TAG, "Monitor block interrupted! " +e.getMessage());
            txtWriter.writeMessage(StringHelper.formatError(TAG + ": Monitor block interrupted! " + e.getMessage()));
        }
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.DO_WHILE_CONTROL;
    }
}