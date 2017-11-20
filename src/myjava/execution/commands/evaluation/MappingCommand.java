package myjava.execution.commands.evaluation;

import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.analyzers.FunctionCallVerifier;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.utils.AssignmentUtils;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * A mapping command that evaluates a given expression context then maps
 * its corresponding value. Has an identifier string that assigns the value to it.
 * This is different from assignment command. This one is used for any variable initialization.
 *
 */
public class MappingCommand implements ICommand {
	
	private String identifierString;
	private ExpressionContext parentExprCtx;
	
	private String modifiedExp;
	
	public MappingCommand(String identifierString, ExpressionContext exprCtx) {
		this.identifierString = identifierString;
		parentExprCtx = exprCtx;
		
		UndeclaredChecker undeclaredChecker = new UndeclaredChecker(parentExprCtx);
		undeclaredChecker.verify();
		
		ParseTreeWalker functionWalker = new ParseTreeWalker();
		functionWalker.walk(new FunctionCallVerifier(), parentExprCtx);
		
	}

	@Override
	public void execute() {
		modifiedExp = parentExprCtx.getText();
		
		EvaluationCommand evaluationCommand = new EvaluationCommand(parentExprCtx);
		evaluationCommand.execute();
		
		MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(identifierString);
		AssignmentUtils.assignAppropriateValue(myJAVAValue, evaluationCommand.getResult());
	}
	
	/*
	 * Returns the modified exp, with mapped values.
	 */
	public String getModifiedExp() {
		return modifiedExp;
	}
}
