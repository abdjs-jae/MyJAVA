package myjava.execution.commands.evaluation;

import myjava.antlrgen.MyJAVALexer;
import myjava.error.checkers.ConstChecker;
import myjava.error.checkers.TypeChecker;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.ICommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.analyzers.FunctionCallVerifier;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.utils.AssignmentUtils;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * A new assignment command that walks a given expression and replaces values to it
 * before being passed to Eval-Ex library.
 * 
 */
public class AssignmentCommand implements ICommand{

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
		
		//type check the myJAVAvalue
		MyJAVAValue myJAVAValue;
		if(ExecutionManager.getExecutionManager().isInFunctionExecution()) {
			myJAVAValue = VariableSearcher.searchVariableInFunction(ExecutionManager.getExecutionManager().getCurrentFunction(), this.leftHandExprCtx.getText());
		}
		else {
			myJAVAValue = VariableSearcher.searchVariable(this.leftHandExprCtx.getText());
		}
		
		TypeChecker typeChecker = new TypeChecker(myJAVAValue, this.rightHandExprCtx);
		typeChecker.verify();
	}

	@Override
	public void execute() {
		EvaluationCommand evaluationCommand = new EvaluationCommand(rightHandExprCtx);
		evaluationCommand.execute();
		
		if(isLeftHandArrayAccessor()) {
			handleArrayAssignment(evaluationCommand.getResult().toEngineeringString());
		}
		else {
			MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(leftHandExprCtx.getText());
			AssignmentUtils.assignAppropriateValue(myJAVAValue, evaluationCommand.getResult());
		}
	}
	
	private boolean isLeftHandArrayAccessor() {
		List<TerminalNode> lBrackTokens = leftHandExprCtx.getTokens(MyJAVALexer.LBRACK);
		List<TerminalNode> rBrackTokens = leftHandExprCtx.getTokens(MyJAVALexer.RBRACK);
		
		return(lBrackTokens.size() > 0 && rBrackTokens.size() > 0);
	}
	
	private void handleArrayAssignment(String resultString) {
		TerminalNode identifierNode = leftHandExprCtx.expression(0).primary().Identifier();
		ExpressionContext arrayIndexExprCtx = leftHandExprCtx.expression(1);
		
		MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(identifierNode.getText());
		MyJAVAArray myJAVAArray = (MyJAVAArray) myJAVAValue.getValue();
		
		EvaluationCommand evaluationCommand = new EvaluationCommand(arrayIndexExprCtx);
		evaluationCommand.execute();
		
		//create a new array value to replace value at specified index
		MyJAVAValue newArrayValue = new MyJAVAValue(null, myJAVAArray.getPrimitiveType());
		newArrayValue.setValue(resultString);
		myJAVAArray.updateValueAt(newArrayValue, evaluationCommand.getResult().intValue());
		
		//Console.log("Index to access: " +evaluationCommand.getResult().intValue()+ " Updated with: " +resultString);
	}
}
