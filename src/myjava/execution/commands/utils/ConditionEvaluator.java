package myjava.execution.commands.utils;

import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.ParExpressionContext;

/**
 * Utility class for execution that evaluates a condition.
 * This is used for IF, WHILE, DO-WHILE and FOR control statements.
 *
 */
public class ConditionEvaluator {
	
	/*
	 * Evaluates the modified conditional expression via Eval-Ex
	 */
	/*public static boolean evaluateCondition(String modifiedConditionExpr) {
		
		//catch rules if the if value has direct boolean flags
		if(modifiedConditionExpr.contains("(true)")) {
			return true;
		}
		else if(modifiedConditionExpr.contains("(false)")) {
			return false;
		}
		
		Expression expr = new Expression(modifiedConditionExpr);
		int result = expr.eval().intValue();
		
		//Console.log("Evaluating " +modifiedConditionExpr+ ". result is " +result);
		
		if(result == 1) {
			return true;	
		}
		else {
			return false;
		}
	}*/
	
	public static boolean evaluateCondition(ParExpressionContext parExprCtx) {
		
		ExpressionContext conditionExprCtx = parExprCtx.expression();
		
		//catch rules if the if value has direct boolean flags
		if(conditionExprCtx.getText().contains("(true)")) {
			return true;
		}
		else if(conditionExprCtx.getText().contains("(false)")) {
			return false;
		}
		
		EvaluationCommand evaluationCommand = new EvaluationCommand(conditionExprCtx);
		evaluationCommand.execute();
		
		int result = evaluationCommand.getResult().intValue();
		
		//Console.log("Evaluating: " +conditionExprCtx.getText() + " Result: " +result);
		
		return (result == 1);
	}
	
	public static boolean evaluateCondition(ExpressionContext conditionExprCtx) {
		
		//catch rules if the if value has direct boolean flags
		if(conditionExprCtx.getText().contains("(true)")) {
			return true;
		}
		else if(conditionExprCtx.getText().contains("(false)")) {
			return false;
		}
		
		EvaluationCommand evaluationCommand = new EvaluationCommand(conditionExprCtx);
		evaluationCommand.execute();
		
		int result = evaluationCommand.getResult().intValue();
		
		return (result == 1);
	}
}
