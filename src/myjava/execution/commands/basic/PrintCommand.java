package myjava.execution.commands.basic;

import myjava.ITextWriter;
import myjava.MyJAVAParser.*;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.*;
import myjava.semantics.representations.MyJAVAValueSearcher;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class PrintCommand implements ICommand, ITextWriter, ParseTreeListener{

    private ExpressionContext exprContext;

    private String printStatement = "";
    private boolean complexExpr = false;
    private boolean arrayAccess = false;

    public PrintCommand(ExpressionContext exprContext) {
        this.exprContext = exprContext;
    }

    public String getPrintStatement() {
        return this.printStatement;
    }

    @Override
    public void execute() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.exprContext);

        //Console.log(LogType.VERBOSE, this.statementToPrint);
        txtWriter.writeMessage(StringUtils.formatProgram(printStatement));
        this.printStatement = "";
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        if(parserRuleContext instanceof LiteralContext) {
            LiteralContext literalContext = (LiteralContext) parserRuleContext;

            if(literalContext.StringLiteral() != null) {
                String quotedString = literalContext.StringLiteral().getText();

                this.printStatement += StringUtils.removeQuotes(quotedString);
            }
        }
        else if(parserRuleContext instanceof PrimaryContext) {
            PrimaryContext primaryContext = (PrimaryContext) parserRuleContext;

            if(primaryContext.expression() != null) {
                ExpressionContext exprContext = primaryContext.expression();
                this.complexExpr = true;

                // Console.log(LogType.DEBUG, "Complex expression detected: " +exprCtx.getText());
                txtWriter.writeMessage(StringUtils.formatDebug("Complex expression detected: "
                                                                        + exprContext.getText()));

                EvaluationCommand evaluationCommand = new EvaluationCommand(exprContext);
                evaluationCommand.execute();

                // TODO
                // this.printStatement += evaluationCommand.getResult().toEngineeringString();
            }

            else if(primaryContext.Identifier() != null && this.complexExpr == false) {
                String identifier = primaryContext.getText();

                MyJAVAValue value = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
                if(value.getPrimitiveType() == PrimitiveType.ARRAY) {
                    this.arrayAccess = true;
                    // TODO
                    // this.evaluateArrayPrint(value, primaryContext);
                }
                else if(!this.arrayAccess) {
                    this.printStatement += value.getValue();
                }


            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
