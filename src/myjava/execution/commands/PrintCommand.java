package myjava.execution.commands;

import myjava.MyJAVAParser.ExpressionContext;
import myjava.execution.ICommand;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class PrintCommand implements ICommand, ParseTreeListener{

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

        // Console.log(LogType.VERBOSE, this.statementToPrint);
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

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
