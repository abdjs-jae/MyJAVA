package myjava.execution.commands.controlled;

import java.util.ArrayList;
import java.util.List;

import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor; 
import myjava.execution.commands.ICommand;
import myjava.execution.commands.utils.ConditionEvaluator;
import myjava.MyJAVAParser.ParExpressionContext;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.utils.StringHelper;

import static myjava.ITextWriter.txtWriter;

/**
 * Representation of a while command
 * @author NeilDG
 *
 */
public class WhileCommand implements IControlledCommand {

    protected List<ICommand> commandSequences; //the list of commands inside the WHILE statement

    protected ParExpressionContext conditionalExpr;
    protected String modifiedConditionExpr;

    public WhileCommand(ParExpressionContext conditionalExpr) {
        this.commandSequences = new ArrayList<>();
        this.conditionalExpr = conditionalExpr;
    }

    /*
     * Executes the command
     */
    @Override
    public void execute() {
        this.identifyVariables();

        ExecutionMonitor executionMonitor = ExecutionManager.getExecutionManager().getExecutionMonitor();

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
            System.err.println("WhileCommand: Monitor block interrupted! " + e.getMessage());
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
        txtWriter.writeMessage(StringHelper.formatDebug("New command was added to while loop."));
        this.commandSequences.add(command);
    }

    public int getCommandCount() {
        return this.commandSequences.size();
    }

}
