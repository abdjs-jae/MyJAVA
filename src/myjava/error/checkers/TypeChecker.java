/**
 * 
 */
package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.generatedexp.JavaParser.LiteralContext;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Handles all the type checking

 *
 */
public class TypeChecker implements IErrorChecker, ParseTreeListener {
	private final static String TAG = "MyJAVAProg_TypeChecker";

	private MyJAVAValue myJAVAValue;
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public TypeChecker(MyJAVAValue assignmentMyJAVAValue, ExpressionContext exprCtx) {
		this.myJAVAValue = assignmentMyJAVAValue;
		this.exprCtx = exprCtx;
		
		Token firstToken = exprCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	@Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.exprCtx);
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
			if(this.myJAVAValue == null) {
				return;
			}
			LiteralContext literalCtx = (LiteralContext) ctx;
			String expressionString = literalCtx.getText();
			
			if(this.myJAVAValue.getPrimitiveType() == PrimitiveType.ARRAY) {
				
			}
			else if(this.myJAVAValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
				if(literalCtx.BooleanLiteral() == null) {
					String additionalMessage = "Expected boolean.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.myJAVAValue.getPrimitiveType() == PrimitiveType.INT) {
				if(literalCtx.IntegerLiteral() == null) {
					String additionalMessage = "Expected int.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.myJAVAValue.getPrimitiveType() == PrimitiveType.FLOAT || this.myJAVAValue.getPrimitiveType() == PrimitiveType.DOUBLE) {
				if(literalCtx.FloatingPointLiteral() == null) {
					String additionalMessage = "Expected floating point or double.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			
			else if(this.myJAVAValue.getPrimitiveType() == PrimitiveType.STRING) {
				if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
					String additionalMessage = "Expected string.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
				
				else if(literalCtx.StringLiteral() == null) {
					String additionalMessage = "Expected string.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
