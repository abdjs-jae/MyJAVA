/**
 * 
 */
package myjava.execution.commands.evaluation;

import myjava.error.checkers.ConstChecker;
import myjava.error.checkers.TypeChecker;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.ICommand;
import myjava.generatedexp.JavaLexer;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.analyzers.FunctionCallVerifier;
import myjava.semantics.representations.MobiArray;
import myjava.semantics.representations.MobiValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.utils.AssignmentUtils;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * A new assignment command that walks a given expression and replaces values to it
 * before being passed to Eval-Ex library.
 *
 * 
 */
public class AssignmentCommand implements ICommand{

	private final static String TAG = "MobiProg_NewAssignmentCommand";

	private ExpressionContext leftHandExprCtx;
	private ExpressionContext rightHandExprCtx;

	public AssignmentCommand(ExpressionContext leftHandExprCtx,
			ExpressionContext rightHandExprCtx) {
		this.leftHandExprCtx = leftHandExprCtx;
		this.rightHandExprCtx = rightHandExprCtx;
		
		UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.leftHandExprCtx);
		undeclaredChecker.verify();
		
		ConstChecker constChecker = new ConstChecker(this.leftHandExprCtx);
		constChecker.verify();
		
		undeclaredChecker = new UndeclaredChecker(this.rightHandExprCtx);
		undeclaredChecker.verify();
		
		ParseTreeWalker functionWalker = new ParseTreeWalker();
		functionWalker.walk(new FunctionCallVerifier(), this.rightHandExprCtx);
		
		//type check the mobivalue
		MobiValue mobiValue;
		if(ExecutionManager.getInstance().isInFunctionExecution()) {
			mobiValue = VariableSearcher.searchVariableInFunction(ExecutionManager.getInstance().getCurrentFunction(), this.leftHandExprCtx.getText());
		}
		else {
			mobiValue = VariableSearcher.searchVariable(this.leftHandExprCtx.getText());
		}
		
		TypeChecker typeChecker = new TypeChecker(mobiValue, this.rightHandExprCtx);
		typeChecker.verify();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see myjava.execution.commands.ICommand#execute()
	 */
	@Override
	public void execute() {
		EvaluationCommand evaluationCommand = new EvaluationCommand(this.rightHandExprCtx);
		evaluationCommand.execute();
		
		if(this.isLeftHandArrayAccessor()) {
			this.handleArrayAssignment(evaluationCommand.getResult().toEngineeringString());
		}
		else {
			MobiValue mobiValue = VariableSearcher.searchVariable(this.leftHandExprCtx.getText());
			AssignmentUtils.assignAppropriateValue(mobiValue, evaluationCommand.getResult());
		}
	}
	
	private boolean isLeftHandArrayAccessor() {
		List<TerminalNode> lBrackTokens = this.leftHandExprCtx.getTokens(JavaLexer.LBRACK);
		List<TerminalNode> rBrackTokens = this.leftHandExprCtx.getTokens(JavaLexer.RBRACK);
		
		return(lBrackTokens.size() > 0 && rBrackTokens.size() > 0);
	}
	
	private void handleArrayAssignment(String resultString) {
		TerminalNode identifierNode = this.leftHandExprCtx.expression(0).primary().Identifier();
		ExpressionContext arrayIndexExprCtx = this.leftHandExprCtx.expression(1);
		
		MobiValue mobiValue = VariableSearcher.searchVariable(identifierNode.getText());
		MobiArray mobiArray = (MobiArray) mobiValue.getValue();
		
		EvaluationCommand evaluationCommand = new EvaluationCommand(arrayIndexExprCtx);
		evaluationCommand.execute();
		
		//create a new array value to replace value at specified index
		MobiValue newArrayValue = new MobiValue(null, mobiArray.getPrimitiveType());
		newArrayValue.setValue(resultString);
		mobiArray.updateValueAt(newArrayValue, evaluationCommand.getResult().intValue());
		
		//Console.log("Index to access: " +evaluationCommand.getResult().intValue()+ " Updated with: " +resultString);
	}
}
