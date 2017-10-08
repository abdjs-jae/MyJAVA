
import myjava.MyJAVALexer;
import myjava.MyJAVAParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


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
    private JTextArea txtConsole;

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
                code = txtArCode.getText();

                MyJAVALexer lex = new MyJAVALexer(CharStreams.fromString(code));
                CommonTokenStream tokens = new CommonTokenStream(lex);
                MyJAVAParser parser = new MyJAVAParser(tokens);
                ParseTree t = parser.compilationUnit();

                txtConsole.setText("\n Parse tree " + t.toStringTree(parser) );

                /*
                 * get the input file as an InputStream
                 */
                //InputStream inputStream = Main.class.getResourceAsStream();
         /*
          * make Lexer
          */
                //Lexer lexer = new arithmeticLexer(CharStreams.fromStream(inputStream));
             //   Lexer lexer = new MyJAVALexer(CharStreams.fromString(code));
         /*
          * get a TokenStream on the Lexer
          */
                //TokenStream tokenStream = new CommonTokenStream(lexer);
         /*
          * make a Parser on the token stream
          */
             //   MyJAVAParser parser = new MyJAVAParser(tokenStream);
         /*
          * get the top node of the AST. This corresponds to the topmost rule of equation.q4, "equation"
          */



            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArCode.setText("");
                txtConsole.setText("");
            }
        });
    }
}
