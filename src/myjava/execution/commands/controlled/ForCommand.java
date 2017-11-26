package myjava.execution.commands.controlled;

import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.utils.ConditionEvaluator;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.LocalVariableDeclarationContext;
import myjava.semantics.analyzers.LocalVariableAnalyzer;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the for command
 *
 */
public class ForCommand implements IControlledCommand{
	
	private List<ICommand> commandSequences;
	
	private LocalVariableDeclarationContext localVarDecCtx; //a local variable ctx that is evaluated at the start of the for loop
	private ExpressionContext conditionalExpr; //the condition to satisfy
	private ICommand updateCommand; //the update command aftery ever iteration

	private String modifiedConditionExpr;

	public ForCommand(LocalVariableDeclarationContext localVarDecCtx, ExpressionContext conditionalExpr, ICommand updateCommand) {
		this.localVarDecCtx = localVarDecCtx;
		this.conditionalExpr = conditionalExpr;
		this.updateCommand = updateCommand;
		
		commandSequences = new ArrayList<>();
	}

	@Override
	public void execute() {
		evaluateLocalVariable();
		identifyVariables();
		
		ExecutionMonitor executionMonitor = ExecutionManager.getExecutionManager().getExecutionMonitor();
		
		try {
			//evaluate the given condition
			while(ConditionEvaluator.evaluateCondition(conditionalExpr)) {
				for(ICommand command : commandSequences) {
					executionMonitor.tryExecution();
					command.execute();
				}
				
				updateCommand.execute(); //execute the update command
				identifyVariables(); //identify variables again to detect changes to such variables used.
			}
			
		} catch(InterruptedException e) {
			System.err.println("ForCommand: Monitor block interrupted! " +e.getMessage());
		}
	}
	
	private void evaluateLocalVariable() {
		if(localVarDecCtx != null) {
			LocalVariableAnalyzer localVarAnalyzer = new LocalVariableAnalyzer();
			localVarAnalyzer.markImmediateExecution();
			localVarAnalyzer.analyze(localVarDecCtx);
		}
	}
	
	private void identifyVariables() {
		IValueMapper identifierMapper = new IdentifierMapper(conditionalExpr.getText());
		identifierMapper.analyze(conditionalExpr);

		modifiedConditionExpr = identifierMapper.getModifiedExp();
	}

	@Override
	public ControlTypeEnum getControlType() {
		return ControlTypeEnum.FOR_CONTROL;
	}

	@Override
	public void addCommand(ICommand command) {
		ExecutionManager.getExecutionManager().consoleListModel.addElement(StringUtils.formatDebug("Added command to FOR"));
		commandSequences.add(command);
	}
	
	public int getCommandCount() {
		return commandSequences.size();
	}

}
