package myjava.execution.commands.evaluation;

import myjava.error.ParserHandler;
import myjava.execution.commands.ICommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.searching.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.utils.Expression;
import myjava.semantics.utils.RecognizedKeywords;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
import java.util.List;

/**
 * A command that evaluates a given expression at runtime.
 *
 */
public class EvaluationCommand implements ICommand, ParseTreeListener {
	
	private ExpressionContext parentExprCtx;
	private String modifiedExp;
	private BigDecimal resultValue;
	
	public EvaluationCommand(ExpressionContext exprCtx) {
		parentExprCtx = exprCtx;
	}

	@Override
	public void execute() {
		modifiedExp = parentExprCtx.getText();

		//catch rules if the value has direct boolean flags
		if(modifiedExp.contains(RecognizedKeywords.BOOLEAN_TRUE)) {
			resultValue = new BigDecimal(1);
		}
		else if(modifiedExp.contains(RecognizedKeywords.BOOLEAN_FALSE)) {
			resultValue = new BigDecimal(0);
		}
		else {
			ParseTreeWalker treeWalker = new ParseTreeWalker();
			treeWalker.walk(this, parentExprCtx);
			
			Expression evalEx = new Expression(modifiedExp);
			//Log.i(TAG,"Modified exp to eval: " +this.modifiedExp);
			resultValue = evalEx.eval();
		}
		
	}

	@Override
	public void visitTerminal(TerminalNode node) {

	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if (ctx instanceof ExpressionContext) {
			ExpressionContext exprCtx = (ExpressionContext) ctx;
			if (EvaluationCommand.isFunctionCall(exprCtx)) {
				evaluateFunctionCall(exprCtx);
			}

			else if (EvaluationCommand.isVariableOrConst(exprCtx)) {
				evaluateVariable(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {

	}

	public static boolean isFunctionCall(ExpressionContext exprCtx) {
        return exprCtx.arguments() != null;
	}

	public static boolean isVariableOrConst(ExpressionContext exprCtx) {
        return VariableSearcher.searchVariable(exprCtx.getText()) != null;
	}

	private void evaluateFunctionCall(ExpressionContext exprCtx) {
		String functionName = exprCtx.expression(0).Identifier().getText();

		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
				ParserHandler.getInstance().getCurrentClassName());
		MyJAVAFunction myJAVAFunction = classScope.searchFunction(functionName);

		if (exprCtx.arguments().expressionList() != null) {
			List<ExpressionContext> exprCtxList = exprCtx.arguments()
					.expressionList().expression();

			for (int i = 0; i < exprCtxList.size(); i++) {
				ExpressionContext parameterExprCtx = exprCtxList.get(i);

				EvaluationCommand evaluationCommand = new EvaluationCommand(parameterExprCtx);
				evaluationCommand.execute();

				myJAVAFunction.mapParameterByValueAt(evaluationCommand.getResult().toEngineeringString(), i);
			}
		}

		myJAVAFunction.execute();

		System.out.println("EvaluationCommand: Before modified EXP function call: " + modifiedExp);
		modifiedExp = modifiedExp.replace(exprCtx.getText(),
				myJAVAFunction.getReturnValue().getValue().toString());
		System.out.println("EvaluationCommand: After modified EXP function call: " + modifiedExp);

	}

	private void evaluateVariable(ExpressionContext exprCtx) {
		MyJAVAValue myJAVAValue = VariableSearcher
				.searchVariable(exprCtx.getText());

		modifiedExp = modifiedExp.replaceFirst(exprCtx.getText(),
				myJAVAValue.getValue().toString());
	}

	/*
	 * Returns the result
	 */
	public BigDecimal getResult() {
		return resultValue;
	}
}
