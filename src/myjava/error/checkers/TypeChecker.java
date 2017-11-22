package myjava.error.checkers;

import myjava.error.MyJAVAErrorStrategy;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.LiteralContext;
import myjava.semantics.representations.MyJAVAValue;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Handles all the type checking
 *
 */
public class TypeChecker implements IErrorChecker, ParseTreeListener {

	private MyJAVAValue myJAVAValue;
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public TypeChecker(MyJAVAValue assignmentMyJAVAValue, ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;
		myJAVAValue = assignmentMyJAVAValue;
		lineNumber = exprCtx.getStart().getLine();
	}
	
	@Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, exprCtx);
	}
	
	public static boolean isNumeric(String str) {
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
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
		if(ctx instanceof LiteralContext) {
			if(myJAVAValue == null) {
				return;
			}
			LiteralContext literalCtx = (LiteralContext) ctx;
			String expressionString = literalCtx.getText();

			switch (myJAVAValue.getPrimitiveType()) {
				case ARRAY:

					break;
				case BOOLEAN:
					if (literalCtx.BooleanLiteral() == null) {
						String additionalMessage = "Expected boolean.";
						MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.TYPE_MISMATCH, additionalMessage, lineNumber);
					}
					break;
				case INT:
					if (literalCtx.IntegerLiteral() == null) {
						String additionalMessage = "Expected int.";
						MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.TYPE_MISMATCH, additionalMessage, lineNumber);
					}
					break;
				case FLOAT:
				case DOUBLE:
					if (literalCtx.FloatingPointLiteral() == null) {
						String additionalMessage = "Expected floating point or double.";
						MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.TYPE_MISMATCH, additionalMessage, lineNumber);
					}
					break;
				case STRING:
					if (expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
						String additionalMessage = "Expected string.";
						MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.TYPE_MISMATCH, additionalMessage, this.lineNumber);
					} else if (literalCtx.StringLiteral() == null) {
						String additionalMessage = "Expected string.";
						MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.TYPE_MISMATCH, additionalMessage, this.lineNumber);
					}
					break;
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
