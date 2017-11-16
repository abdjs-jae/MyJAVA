package errors;

import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.util.ArrayList;

public class ErrorListener extends BaseErrorListener {

    private DefaultListModel consoleListModel = new DefaultListModel();
    private ArrayList<Integer> errorPositionList = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {

        // Change the error messages!!!
        consoleListModel.addElement("[ERROR] Line " + line + ":" + charPositionInLine + ": " + msg);
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
        if(consoleListModel == null){
            consoleListModel = new DefaultListModel();
            consoleListModel.addElement("[PARSE] No syntax errors were detected.");
        }

        return consoleListModel;
    }
    public ArrayList<Integer> getErrorPositionList() {
        return errorPositionList;
    }
}