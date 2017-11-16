
import myjava.errors.*;
import myjava.MyJAVABaseListener;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import uicomp.LinePainter;
import uicomp.SquigglePainter;
import uicomp.TextLineNumber;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
    private JPanel codeCasePane;
    private JTabbedPane consoleTabPane;
    private JPanel allTab;
    private JPanel verboseTab;
    private JPanel errorTab;
    private JPanel debugTab;
    private DefaultListModel consoleListModel;

    // INPUT ELEMENTS
    private String code;
    private int lineNum;
    private ArrayList<Integer> errorPositionList;
    private int selectedTabIndex = 0;

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

                MyJAVALexer lex = new MyJAVALexer(new ANTLRInputStream(code));
                CommonTokenStream tokens = new CommonTokenStream(lex);
                MyJAVAParser parser = new MyJAVAParser(tokens);
                ErrorListener errorListener = new ErrorListener();
                parser.setErrorHandler(new MyJAVAErrorStrategy());
                parser.removeErrorListeners();
                parser.addErrorListener(errorListener);
                parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

                ParseTree parserRuleContext = parser.compilationUnit();
                ParseTreeWalker treeWalker = new ParseTreeWalker();
                treeWalker.walk(new MyJAVABaseListener(), parserRuleContext);

                consoleListModel = new DefaultListModel();
                consoleList.setSelectedIndex(0);
                consoleListModel = errorListener.getConsoleListModel();
                errorPositionList = errorListener.getErrorPositionList();
                underlineErrors(errorPositionList);

                if(consoleListModel.getSize() == 0){
                    consoleListModel.addElement("[DEBUG] No syntax errors were detected.");
                }

                consoleList.setModel(consoleListModel);
                consolePane.setViewportView(consoleList);
                consoleList.setLayoutOrientation(JList.VERTICAL);
            }
        });
        consoleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                    if(consoleList.getSelectedIndex() != -1) {
                        System.out.println(consoleList.getSelectedIndex());
                        String selectedMessage = consoleList.getSelectedValue().toString();

                        // Checks if message has a keyword
                        if (selectedMessage.charAt(1) == 'E') {
                            // Get the line number of the selected message!
                            lineNum = extractLineNumber(selectedMessage);
                            // Moves the highlight text to the line + 1
                            txtArCode.setCaretPosition(txtArCode.getDocument()
                                    .getDefaultRootElement().getElement(lineNum - 1)
                                    .getStartOffset());
                        }
                    }
                }
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
        consoleTabPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Current tab: " + consoleTabPane.getSelectedIndex());
                JScrollPane newPane = consolePane;
                JList newList = (JList)newPane.getViewport().getView();

                // Clear the consolePane of the last selected tab
                ((JPanel)consoleTabPane.getComponentAt(selectedTabIndex)).removeAll();

                switch(consoleTabPane.getSelectedIndex()){
                    case 0: { // ALL
                        consoleList.setModel(consoleListModel);
                        allTab.add(consolePane);
                    } break;
                    case 1: { // Verbose
                        consoleList.setModel(generateDListModel(consoleListModel, 'V'));
                        verboseTab.add(newPane);
                    } break;
                    case 2: { // Error
                        consoleList.setModel(generateDListModel(consoleListModel, 'E'));
                        errorTab.add(newPane);
                    } break;
                    case 3: { // Debug
                        consoleList.setModel(generateDListModel(consoleListModel, 'D'));
                        debugTab.add(newPane);
                    } break;
                }
                selectedTabIndex = consoleTabPane.getSelectedIndex();

            }
        });
    }

    private DefaultListModel generateDListModel(DefaultListModel defaultListModel, char messageType){

        DefaultListModel newModel = new DefaultListModel();

        for(int i = 0; i < defaultListModel.getSize(); i++){
            // if message does not contain the required type
            if(defaultListModel.get(i).toString().charAt(1) == messageType)
                newModel.addElement(defaultListModel.get(i));
        }

        System.out.println("newModel size: " + newModel.getSize());

        if(newModel.getSize() == 0)
            newModel.addElement("No messages of this type.");

        return newModel;
    }

    // Gets the line number from a message!
    private int extractLineNumber(String s){
        // [ERROR] Line 1:2
        String colonSplit = s.split("\\:")[0];
        // [ERROR] Line 1
        String smallESplit = colonSplit.substring(13, colonSplit.length());
        return Integer.parseInt(smallESplit);
    }

    private void underlineErrors(ArrayList<Integer> errorPositionList){
        SquigglePainter red = new SquigglePainter( Color.RED );

        for(int i = 0; i < errorPositionList.size(); i+=3){

            try {
                txtArCode.getHighlighter().addHighlight(errorPositionList.get(i+1),
                                                    errorPositionList.get(i+2)+1,
                                                        red);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

}

