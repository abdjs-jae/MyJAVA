import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArCode.setText("");
            }
        });
    }
}
