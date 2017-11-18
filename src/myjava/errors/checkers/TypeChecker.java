package myjava.errors.checkers;

import myjava.ITextWriter;
import myjava.MyJAVAParser.*;
import myjava.errors.MyJAVAErrorStrategy;
import myjava.semantics.representations.MyJAVAValue;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeChecker implements IChecker, ParseTreeListener {

    private MyJAVAValue myJAVAValue;
    private ExpressionContext exprContext;
    private int lineNum;

    public TypeChecker(MyJAVAValue assignmentMyJAVAValue, ExpressionContext exprContext) {
        this.myJAVAValue = assignmentMyJAVAValue;
        this.exprContext = exprContext;

        lineNum = exprContext.getStart().getLine();
    }

    @Override
    public void check() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exprContext);
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
    public void enterEveryRule(ParserRuleContext context) {
        if(context instanceof LiteralContext) {

            if(myJAVAValue == null) return;

            LiteralContext literalContext = (LiteralContext) context;
            String expressionString = literalContext.getText();
            String additionalMessage = null;

            switch(myJAVAValue.getPrimitiveType()){
                case ARRAY: break;
                case BOOLEAN:
                    if(literalContext.BooleanLiteral() == null) {
                        additionalMessage = "Expected boolean.";
                    } break;
                case CHAR:
                    if(literalContext.CharacterLiteral() == null) {
                        additionalMessage = "Expected char.";
                    } break;
                case INT:
                    if(literalContext.IntegerLiteral() == null) {
                        additionalMessage = "Expected int.";
                    } break;
                case FLOAT:
                case DOUBLE:
                    if(literalContext.FloatingPointLiteral() == null) {
                        additionalMessage = "Expected floating point or double.";
                    } break;
                case STRING:
                    if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
                        additionalMessage = "Expected string.";
                    }
                    else if(literalContext.StringLiteral() == null) {
                        additionalMessage = "Expected string.";
                    } break;
            }

            if(additionalMessage != null)
                MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.TYPE_MISMATCH, additionalMessage, lineNum);

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {
        // TODO Auto-generated method stub

    }
}
