package myjava.execution.commands.basic;

import myjava.ITextWriter;
import myjava.MyJAVAParser.*;
import myjava.MyJAVAParser.ExpressionContext;
import myjava.execution.commands.ICommand;
import myjava.execution.commands.evaluate.EvaluationCommand;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.*;
import myjava.semantics.representations.MyJAVAValueSearcher;
import myjava.semantics.utils.StringHelper;
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

        txtWriter.writeMessage(StringHelper.formatProgram(printStatement));
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

                this.printStatement += StringHelper.removeQuotes(quotedString);
            }
        }
        else if(parserRuleContext instanceof PrimaryContext) {
            PrimaryContext primaryContext = (PrimaryContext) parserRuleContext;

            if(primaryContext.expression() != null) {
                ExpressionContext exprContext = primaryContext.expression();
                this.complexExpr = true;

                txtWriter.writeMessage(StringHelper.formatDebug("Complex expression found: "
                                                                        + exprContext.getText()));

                EvaluationCommand evaluationCommand = new EvaluationCommand(exprContext);
                evaluationCommand.execute();

                this.printStatement += evaluationCommand.getResult().toEngineeringString();
            }

            else if(primaryContext.Identifier() != null && this.complexExpr == false) {
                String identifier = primaryContext.getText();

                MyJAVAValue value = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
                if(value.getPrimitiveType() == PrimitiveType.ARRAY) {
                    this.arrayAccess = true;
                    this.evaluateArrayPrint(value, primaryContext);

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

    public void evaluateArrayPrint(MyJAVAValue javaRiceValue, PrimaryContext primaryContext) {

        // move up and determine expression contexts
        ExpressionContext parentExpressionContext = (ExpressionContext) primaryContext.getParent().getParent();
        ExpressionContext arrayIndexExpressionContext = parentExpressionContext.expression(1);

        EvaluationCommand evaluationCommand = new EvaluationCommand(arrayIndexExpressionContext);
        evaluationCommand.execute();

        MyJAVAArray javaRiceArray = (MyJAVAArray) javaRiceValue.getValue();
        MyJAVAValue arrayJavaRiceValue = javaRiceArray.getValueAt(evaluationCommand.getResult().intValue());

        this.printStatement += arrayJavaRiceValue.getValue().toString();
    }
}
