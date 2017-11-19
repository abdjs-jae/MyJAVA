package myjava.execution.commands.basic;

import myjava.errors.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager; 
import myjava.execution.commands.ICommand;
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.representations.MyJAVAValueSearcher;
import myjava.semantics.utils.StringUtils;

import javax.swing.*;

/**
 * Represents a scan command that requires an input for the user.
 * @author NeilDG
 *
 */
public class ScanCommand implements ICommand{

    private String messageToDisplay;
    private String identifier;

    public ScanCommand(String messageToDisplay, String identifier) {
        this.messageToDisplay = StringUtils.removeQuotes(messageToDisplay);
        this.identifier = identifier;

    }

    @Override
    public void execute() {

        // Stop thread execution while getting input.
        ExecutionManager.getExecutionManager().blockExecution();

        // Get the input through a JDialog.
        JFrame frame = new JFrame("InputDialog");
        String valueEntered = "";
        String[] options = {"OK"};
        JPanel panel = new JPanel();
        JTextField txtInput = new JTextField();
        panel.add(new JLabel(messageToDisplay));
        panel.add(txtInput);

        while(valueEntered.equals("")) {
            int selectedOption = loadInputDialog(frame, panel, options);
            if (selectedOption == 0) {
                valueEntered = txtInput.getText();
            }
        }

        // Saves the value to identifier
        MyJAVAValue myJAVAValue = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
        myJAVAValue.setValue(valueEntered);

        // Continue executing the thread
        ExecutionManager.getExecutionManager().resumeExecution();
    }

    private int loadInputDialog(JFrame frame, JPanel panel, String[] options){
        return JOptionPane.showOptionDialog(frame, panel,
                "Scan Command", JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
}
