package myjava.execution.commands.simple;

import myjava.antlrgen.ITextWriter;
import myjava.error.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.LiteralContext;
import myjava.antlrgen.MyJAVAParser.PrimaryContext;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.representations.MyJAVAValueSearcher;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Populates and handles the print command execution
 *
 */
public class PrintCommand implements ICommand, ITextWriter, ParseTreeListener {

	private ExpressionContext expressionCtx;
	
	private String statementToPrint = "";
	private boolean complexExpr = false;
	private boolean arrayAccess = false;
	
	public PrintCommand(ExpressionContext expressionCtx) {
		this.expressionCtx = expressionCtx;
		
		//UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.expressionCtx);
		//undeclaredChecker.verify();
	}
	
	@Override
	public void execute() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, expressionCtx);

		txtWriter.writeMessage(StringUtils.formatProgram(statementToPrint));
		statementToPrint = ""; //reset statement to print afterwards
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof LiteralContext) {
			LiteralContext literalCtx = (LiteralContext) ctx;
			
			if(literalCtx.StringLiteral() != null) {
				String quotedString = literalCtx.StringLiteral().getText(); 
				statementToPrint += StringUtils.removeQuotes(quotedString);
			}
			/*else if(literalCtx.IntegerLiteral() != null) {
				int value = Integer.parseInt(literalCtx.IntegerLiteral().getText());
				this.statementToPrint += value;
			}
			
			else if(literalCtx.FloatingPointLiteral() != null) {
				float value = Float.parseFloat(literalCtx.FloatingPointLiteral().getText());
				this.statementToPrint += value;
			}
			
			else if(literalCtx.BooleanLiteral() != null) {
				this.statementToPrint += literalCtx.BooleanLiteral().getText();
			}
			
			else if(literalCtx.CharacterLiteral() != null) {
				this.statementToPrint += literalCtx.CharacterLiteral().getText();
			}*/
		}
		
		else if(ctx instanceof PrimaryContext) {
			PrimaryContext primaryCtx = (PrimaryContext) ctx;
			
			if(primaryCtx.expression() != null) {
				ExpressionContext exprCtx = primaryCtx.expression();
				complexExpr = true;
				txtWriter.writeMessage(StringUtils.formatDebug("Complex expression detected: " + exprCtx.getText()));

				EvaluationCommand evaluationCommand = new EvaluationCommand(exprCtx);
				evaluationCommand.execute();
				
				statementToPrint += evaluationCommand.getResult().toEngineeringString();
			}
			
			else if(primaryCtx.Identifier() != null && !complexExpr) {
				String identifier = primaryCtx.getText();
				
				MyJAVAValue value = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
				if(value.getPrimitiveType() == PrimitiveType.ARRAY) {
					arrayAccess = true;
					evaluateArrayPrint(value, primaryCtx);
				}
				else if(!arrayAccess) {
					statementToPrint += value.getValue();
				}
				
				
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		
	}
	
	public String getStatementToPrint() {
		return statementToPrint;
	}
	
	private void evaluateArrayPrint(MyJAVAValue myJAVAValue, PrimaryContext primaryCtx) {
		
		//move up and determine expression contexts
		ExpressionContext parentExprCtx = (ExpressionContext) primaryCtx.getParent().getParent();
		ExpressionContext arrayIndexExprCtx = parentExprCtx.expression(1);
		
		EvaluationCommand evaluationCommand = new EvaluationCommand(arrayIndexExprCtx);
		evaluationCommand.execute();
		
		MyJAVAArray myJAVAArray = (MyJAVAArray) myJAVAValue.getValue();
		MyJAVAValue arrayMyJAVAValue = myJAVAArray.getValueAt(evaluationCommand.getResult().intValue());
		
		statementToPrint += arrayMyJAVAValue.getValue().toString();
	}
	
	

}
