package myjava.errors;

import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.util.ArrayList;

public class ErrorListener extends BaseErrorListener {

    TXTWriter txtWriter = new TXTWriter();
    private DefaultListModel consoleListModel = new DefaultListModel();
    private ArrayList<Integer> errorPositionList = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {

        txtWriter.writeMessage("[ERROR] Line " + line + ": " + msg);
        // consoleListModel.addElement("[ERROR] Line " + line + ": " + msg);
        underlineError(recognizer, (Token)offendingSymbol, line, charPositionInLine);

    }

    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {

        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();

        // Add line, start, and stop positions to array
        errorPositionList.add(line-1);
        errorPositionList.add(start);
        errorPositionList.add(stop);

    }

    public DefaultListModel getConsoleListModel() {

        // Read log.txt
        // Add each line to consoleListModel

        return consoleListModel;
    }

    public ArrayList<Integer> getErrorPositionList() {
        return errorPositionList;
    }

}