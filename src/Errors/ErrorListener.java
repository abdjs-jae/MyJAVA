package Errors;

import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class ErrorListener extends BaseErrorListener {

    private DefaultListModel consoleListModel;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {

        consoleListModel = new DefaultListModel();

        System.err.println("[ERROR] line " +line+":"+charPositionInLine+" at " + offendingSymbol+": " +msg);
        consoleListModel.addElement("[ERROR] line " +line+":"+charPositionInLine+" at " + offendingSymbol+": " +msg);
        underlineError(recognizer,(Token)offendingSymbol, line, charPositionInLine);

    }

    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {
        CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        System.err.println(errorLine);
        // consoleListModel.addElement(errorLine);
        for (int i=0; i<charPositionInLine; i++){
            System.err.print(" ");
            consoleListModel.addElement(" ");
        }
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if ( start>=0 && stop>=0 ) {
            for (int i=start; i<=stop; i++){
                System.err.print("^");
                consoleListModel.addElement("^");
            }
        }
        System.err.println();
        consoleListModel.addElement("\n");
    }

    public DefaultListModel getConsoleListModel() {
        return consoleListModel;
    }
}