/**
 * 
 */
package myjava.execution.commands.controlled;

import android.util.Log;
import myjava.execution.ExecutionManager;
import myjava.execution.ExecutionMonitor;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.utils.ConditionEvaluator;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.LocalVariableDeclarationContext;
import myjava.ide.console.Console;
import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.analyzers.LocalVariableAnalyzer;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the for command
 * @author NeilDG
 *
 */
public class ForCommand implements IControlledCommand {

	private final static String TAG = "MobiProg_ForCommand";
	
	private List<ICommand> commandSequences;
	
	private LocalVariableDeclarationContext localVarDecCtx; //a local variable ctx that is evaluated at the start of the for loop
	private ExpressionContext conditionalExpr; //the condition to satisfy
	private ICommand updateCommand; //the update command aftery ever iteration
	
	private String modifiedConditionExpr;
	
	public ForCommand(LocalVariableDeclarationContext localVarDecCtx, ExpressionContext conditionalExpr, ICommand updateCommand) {
		this.localVarDecCtx = localVarDecCtx;
		this.conditionalExpr = conditionalExpr;
		this.updateCommand = updateCommand;
		
		this.commandSequences = new ArrayList<ICommand>();
	}
	
	/* (non-Javadoc)
	 * @see myjava.execution.commands.ICommand#execute()
	 */
	@Override
	public void execute() {
		this.evaluateLocalVariable();
		this.identifyVariables();
		
		ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();
		
		try {
			//evaluate the given condition
			while(ConditionEvaluator.evaluateCondition(this.conditionalExpr)) {
				for(ICommand command : this.commandSequences) {
					executionMonitor.tryExecution();
					command.execute();
				}
				
				this.updateCommand.execute(); //execute the update command
				this.identifyVariables(); //identify variables again to detect changes to such variables used.
			}
			
		} catch(InterruptedException e) {
			Log.e(TAG, "Monitor block interrupted! " +e.getMessage());
		}
	}
	
	private void evaluateLocalVariable() {
		if(this.localVarDecCtx != null) {
			LocalVariableAnalyzer localVarAnalyzer = new LocalVariableAnalyzer();
			localVarAnalyzer.markImmediateExecution();
			localVarAnalyzer.analyze(this.localVarDecCtx);
		}
	}
	
	private void identifyVariables() {
		IValueMapper identifierMapper = new IdentifierMapper(this.conditionalExpr.getText());
		identifierMapper.analyze(this.conditionalExpr);
		
		this.modifiedConditionExpr = identifierMapper.getModifiedExp();
	}

	/* (non-Javadoc)
	 * @see myjava.execution.commands.controlled.IControlledCommand#getControlType()
	 */
	@Override
	public ControlTypeEnum getControlType() {
		return ControlTypeEnum.FOR_CONTROL;
	}

	/* (non-Javadoc)
	 * @see myjava.execution.commands.controlled.IControlledCommand#addCommand(myjava.execution.commands.ICommand)
	 */
	@Override
	public void addCommand(ICommand command) {
		
		Console.log(LogType.DEBUG, "		Added command to FOR");
		this.commandSequences.add(command);
	}
	
	public int getCommandCount() {
		return this.commandSequences.size();
	}

}
