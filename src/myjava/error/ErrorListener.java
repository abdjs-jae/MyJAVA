package myjava.error;

import myjava.antlrgen.ITextWriter;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

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

        txtWriter.writeMessage(StringUtils.formatError("Line " + line + ": " + msg));
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

    // Gets the generated errors at the log.txt
    public DefaultListModel getConsoleListModel() {

        // Read log.txt
        // Add each line to consoleListModel
        String[] messages = txtReader.read();
        for(String m : messages){
            consoleListModel.addElement(m);
        }

        // Clear log.txt after getting the errors
        txtWriter.clear();

        return consoleListModel;
    }

    public ArrayList<Integer> getErrorPositionList() {
        return errorPositionList;
    }

}