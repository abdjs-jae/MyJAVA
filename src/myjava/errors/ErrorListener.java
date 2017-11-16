package myjava.errors;

import myjava.ITextWriter;
import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.util.ArrayList;

public class ErrorListener extends BaseErrorListener implements ITextWriter{

    TXTReader txtReader = new TXTReader();
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
        String[] messages = txtReader.read();
        for(String m : messages){
            consoleListModel.addElement(m);
        }

        return consoleListModel;
    }

    public ArrayList<Integer> getErrorPositionList() {
        return errorPositionList;
    }

}