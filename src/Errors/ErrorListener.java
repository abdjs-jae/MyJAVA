package errors;

import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        consoleListModel.addElement("[HELPE] Error is near here: " + errorLine);
        // String message = "";
        for (int i=0; i<charPositionInLine; i++){
            System.err.print(" ");
            // message += " ";
        }
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if ( start>=0 && stop>=0 ) {
            for (int i=start; i<=stop; i++){
                System.err.print("^");
                // message += "^";
            }
        }
        System.err.println();
        // consoleListModel.addElement(message);

        // Add line, start, and stop positions to array
        errorPositionList.add(line-1);
        System.out.println(line-1);
        errorPositionList.add(start);
        System.out.println(start);
        errorPositionList.add(stop);
        System.out.println(stop);
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