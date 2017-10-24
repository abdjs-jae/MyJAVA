
import Errors.ErrorListener;
import myjava.MyJAVABaseListener;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import uicomp.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by jasonsapdos on 06/10/2017.
 */
public class UI {

    // UI ELEMENTS

    private JPanel mainPane;
    private JTextArea txtArCode;
    private JPanel actionPane;
    private JScrollPane codePane;
    private JScrollPane consolePane;
    private JButton btnRun;
    private JButton btnClear;
    private JList consoleList;
    private JPanel consoleCasePane;
    private JPanel codeCasePane;
    private DefaultListModel consoleListModel;

    // INPUT ELEMENTS
    String code;
    int lineNum;

    public UI() {

        // Highlights the line currently beign typed on
        LinePainter painter = new LinePainter(txtArCode);
        // Adds the line numbers on the side of the textarea
        TextLineNumber tln = new TextLineNumber(txtArCode);
        tln.setFont(new Font("Mono", Font.PLAIN, 12));
        codePane.setRowHeaderView( tln );
        addListeners();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJAVA Interpreter");
        frame.setContentPane(new UI().mainPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addListeners(){
        btnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Run button clicked!");
                code = txtArCode.getText();

                MyJAVALexer lex = new MyJAVALexer(CharStreams.fromString(code));
                CommonTokenStream tokens = new CommonTokenStream(lex);
                MyJAVAParser parser = new MyJAVAParser(tokens);
                ErrorListener errorListener = new ErrorListener();
                parser.removeErrorListeners();
                parser.addErrorListener(errorListener);

                ParseTree tree = parser.mainFunction();
                ParseTreeWalker walker = new ParseTreeWalker();
                MyJAVABaseListener myJAVA = new MyJAVABaseListener();
                walker.walk(new MyJAVABaseListener(), tree);
                tokens.fill();

                consoleListModel = new DefaultListModel();
                consoleListModel = errorListener.getConsoleListModel();

                // Function for adding of message to console
                // consoleListModel.addElement(<input message here>);

                // For example, this below is for tokens :)

                /*
                    for (Token t : tokens.getTokens()){
                        consoleListModel.addElement("[TOKEN] Token " + (t.getTokenIndex() + 1) + ": "
                           + t.getText() + " | Type: " + MyJAVALexer.VOCABULARY.getSymbolicName(t.getType()));
                    }
                */

                consoleList.setModel(consoleListModel);
                consolePane.setViewportView(consoleList);
                consoleList.setLayoutOrientation(JList.VERTICAL);

                consoleList.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            String selectedMessage = consoleList.getSelectedValue().toString();
                            if(selectedMessage.charAt(1) != 'T') { // token message
                                // Get the line number of the selected message!
                                lineNum = extractLineNumber(selectedMessage);
                                // Moves the highlight text to the line + 1
                                txtArCode.setCaretPosition(txtArCode.getDocument()
                                        .getDefaultRootElement().getElement(lineNum - 1)
                                        .getStartOffset());
                            }
                        }
                    }
                });

                //ParseTree t = parser.compilationUnit();
                // txtConsole.setText("\n Parse tree: " + t.toStringTree(parser) );

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code = "";
                txtArCode.setText("");
                consolePane.getViewport().removeAll();
                consolePane.revalidate();
                consolePane.repaint();
            }
        });

    }

    // Gets the line number from a message!
    private int extractLineNumber(String s){
        // [ERROR] Line 1:2
        String colonSplit = s.split("\\:")[0];
        // [ERROR] Line 1
        String smallESplit = colonSplit.substring(13, colonSplit.length());
        return Integer.parseInt(smallESplit);
    }

}

