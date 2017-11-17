package myjava.execution.commands.controlled;

import java.util.ArrayList;
import java.util.List;

import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor; 
import myjava.execution.ICommand;
import myjava.execution.commands.ConditionEvaluator;
import myjava.generatedexp.JavaParser.ParExpressionContext; 
import myjava.ide.console.Console; 
import myjava.ide.console.LogItemView.LogType; 
import myjava.semantics.mapping.ClassIdentifierMapper; 
import myjava.semantics.mapping.IValueMapper; 
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.utils.StringUtils;

import static myjava.ITextWriter.txtWriter;

/**
 * Representation of a while command
 * @author NeilDG
 *
 */
public class WhileCommand implements IControlledCommand {

    private final static String TAG = "MyJAVA_WhileCommand";

    protected List<ICommand> commandSequences; //the list of commands inside the WHILE statement

    protected ParExpressionContext conditionalExpr;
    protected String modifiedConditionExpr;

    public WhileCommand(ParExpressionContext conditionalExpr) {
        this.commandSequences = new ArrayList<ICommand>();
        this.conditionalExpr = conditionalExpr;
    }

    /*
     * Executes the command
     * (non-Javadoc)
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        this.identifyVariables();

        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();

        try {
            //evaluate the given condition
            while(ConditionEvaluator.evaluateCondition(this.conditionalExpr)) {
                for(ICommand command : this.commandSequences) {
                    executionMonitor.tryExecution();
                    command.execute();
                }

                this.identifyVariables(); //identify variables again to detect changes to such variables used.
            }

        } catch(InterruptedException e) {
            //Log.e(TAG, "Monitor block interrupted! " +e.getMessage());
            txtWriter.writeMessage(StringUtils.formatError(TAG + ": Monitor block interrupted! " + e.getMessage()));
        }
    }

    protected void identifyVariables() {
        IValueMapper identifierMapper = new IdentifierMapper(this.conditionalExpr.getText());
        identifierMapper.analyze(this.conditionalExpr);

        this.modifiedConditionExpr = identifierMapper.getModifiedExp();
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.WHILE_CONTROL;
    }

    @Override
    public void addCommand(ICommand command) {
        //Console.log(LogType.DEBUG, "		Added command to WHILE");
        txtWriter.writeMessage(StringUtils.formatDebug(" Added command to WHILE"));
        this.commandSequences.add(command);
    }

    public int getCommandCount() {
        return this.commandSequences.size();
    }

}
