package myjava.execution.commands.controlled;

import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.controlled.IControlledCommand.ControlTypeEnum;
import myjava.execution.commands.utils.ConditionEvaluator;
import myjava.generatedexp.JavaParser.ParExpressionContext;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of a conditional statement
 *
 */
public class IfCommand implements IConditionalCommand {
	
	private List<ICommand> positiveCommands; //list of commands to execute if the condition holds true
	private List<ICommand> negativeCommands; //list of commands to execute if the condition holds false
	
	private ParExpressionContext conditionalExpr;
	private String modifiedConditionExpr;
	
	public IfCommand(ParExpressionContext conditionalExpr) {
		positiveCommands = new ArrayList<>();
		negativeCommands = new ArrayList<>();
		
		this.conditionalExpr = conditionalExpr;
	}

	@Override
	public void execute() {
		this.identifyVariables();
		
		ExecutionMonitor executionMonitor = ExecutionManager.getExecutionManager().getExecutionMonitor();
		
		try {
			//execute the positive commands
			if(ConditionEvaluator.evaluateCondition(conditionalExpr)) {
				for(ICommand command : positiveCommands) {
					executionMonitor.tryExecution();
					command.execute();
				}
			}
			//execute the negative commands
			else {
				for(ICommand command : negativeCommands) {
					executionMonitor.tryExecution();
					command.execute();
				}
			}
		} catch(InterruptedException e) {
			System.err.println("IfCommand: Monitor block interrupted! " +e.getMessage());
		}
		
	}
	
	private void identifyVariables() {
		IValueMapper identifierMapper = new IdentifierMapper(conditionalExpr.getText());
		identifierMapper.analyze(conditionalExpr);
		
		modifiedConditionExpr = identifierMapper.getModifiedExp();
	}

	@Override
	public ControlTypeEnum getControlType() {
		return ControlTypeEnum.CONDITIONAL_IF;
	}
	
	@Override
	public void addPositiveCommand(ICommand command) {
		positiveCommands.add(command);
	}
	
	@Override
	public void addNegativeCommand(ICommand command) {
		negativeCommands.add(command);
	}
	
	public void clearAllCommands() {
		positiveCommands.clear();
		negativeCommands.clear();
	}
	
	public int getPositiveCommandsCount() {
		return positiveCommands.size();
	}
	
	public int getNegativeCommandsCount() {
		return negativeCommands.size();
	}

}
