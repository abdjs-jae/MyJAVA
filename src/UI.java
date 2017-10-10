
import myjava.MyJAVALexer;
import myjava.MyJAVAParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


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
    private DefaultListModel tokenListModel;

    // INPUT ELEMENTS
    String code;

    public UI() {

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
                tokens.fill();

                tokenListModel = new DefaultListModel();

                for (Token t : tokens.getTokens()){
                    System.out.println("Token #" + t.getTokenIndex() + "!");
                    System.out.println("[TOKEN] Token #" + (t.getTokenIndex()+1) + " found: "
                            + t.getText() + " | Type: "  + MyJAVALexer.VOCABULARY.getSymbolicName(t.getType()));
                    tokenListModel.addElement("[TOKEN] Token #" + (t.getTokenIndex()+1) + " found: "
                            + t.getText() + " | Type: "  + MyJAVALexer.VOCABULARY.getSymbolicName(t.getType()));
                    System.out.println("Token #" + t.getTokenIndex() + "!");
                }

                consoleList.setModel(tokenListModel);
                consolePane.setViewportView(consoleList);
                consoleList.setLayoutOrientation(JList.VERTICAL);

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
}
