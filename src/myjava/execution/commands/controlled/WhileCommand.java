package myjava.execution.commands.controlled;

import myjava.antlrgen.ITextWriter;
import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.utils.ConditionEvaluator;
import myjava.generatedexp.JavaParser.ParExpressionContext;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a while command
 *
 */
public class WhileCommand implements IControlledCommand, ITextWriter{
	
	protected List<ICommand> commandSequences; //the list of commands inside the WHILE statement
	
	protected ParExpressionContext conditionalExpr;
	protected String modifiedConditionExpr;
	
	public WhileCommand(ParExpressionContext conditionalExpr) {
		commandSequences = new ArrayList<>();
		this.conditionalExpr = conditionalExpr;
	}

	@Override
	public void execute() {
		identifyVariables();
		
		ExecutionMonitor executionMonitor = ExecutionManager.getExecutionManager().getExecutionMonitor();
		
		try {
			//evaluate the given condition
			while(ConditionEvaluator.evaluateCondition(conditionalExpr)) {
				for(ICommand command : commandSequences) {
					executionMonitor.tryExecution();
					command.execute();
				}
				
				identifyVariables(); //identify variables again to detect changes to such variables used.
			}
			
		} catch(InterruptedException e) {
			System.err.println("WhileCommand: Monitor block interrupted! " +e.getMessage());
		}
	}
	
	protected void identifyVariables() {
		IValueMapper identifierMapper = new IdentifierMapper(conditionalExpr.getText());
		identifierMapper.analyze(conditionalExpr);
		
		modifiedConditionExpr = identifierMapper.getModifiedExp();
	}

	@Override
	public ControlTypeEnum getControlType() {
		return ControlTypeEnum.WHILE_CONTROL;
	}
	
	@Override
	public void addCommand(ICommand command) {

		txtWriter.writeMessage(StringUtils.formatDebug("Added command to WHILE"));
		commandSequences.add(command);
	}
	
	public int getCommandCount() {
		return commandSequences.size();
	}

}
