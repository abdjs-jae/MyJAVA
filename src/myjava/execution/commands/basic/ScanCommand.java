package myjava.execution.commands.basic;

import myjava.errors.checkers.UndeclaredChecker;
import myjava.execution.ExecutionManager; 
import myjava.execution.commands.ICommand;
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.representations.MyJAVAValueSearcher;
import myjava.semantics.utils.StringUtils;

/**
 * Represents a scan command that requires an input for the user.
 * @author NeilDG
 *
 */
public class ScanCommand implements ICommand{

    public final static String MESSAGE_DISPLAY_KEY = "MESSAGE_DISPLAY_KEY";

    private final static String TAG = "MyJAVAProg_ScanCommand";

    private String messageToDisplay;
    private String identifier;

    public ScanCommand(String messageToDisplay, String identifier) {
        this.messageToDisplay = StringUtils.removeQuotes(messageToDisplay);
        this.identifier = identifier;

    }
    @Override
    public void execute() {
        /*
        // ANDROID STUFF, NO NEED
        NotificationCenter.getInstance().addObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //add an observer to listen to when the dialog has been dismissed

        // Note that I think we don't need to have the Parameters class...

        Parameters params = new Parameters();
        params.putExtra(MESSAGE_DISPLAY_KEY, this.messageToDisplay);

        // Launch the function
        acquireInputFromUser(params);

        // Maybe stopping the execution from running??
        ExecutionManager.getInstance().blockExecution();

        // Content ni acquireInputFromUser

        // Launches UI dialog to get the inputted value
        String valueEntered = params.getStringExtra(ScanUIHandler.VALUE_ENTERED_KEY, "");

        // Saves the value to identifier
        MyJAVAValue myJAVAValue = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
        myJAVAValue.setValue(valueEntered);

        // ANDROID STUFF
        NotificationCenter.getInstance().removeObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using

        // Continue executing the whole program
        ExecutionManager.getInstance().resumeExecution(); //resume execution of thread.

        // ANDROID STUFF, NO NEED
        NotificationCenter.getInstance().postNotification(Notifications.ON_FOUND_SCAN_STATEMENT, params);
        */
    }

    /*
    private void acquireInputFromUser(Parameters params) {
        String valueEntered = params.getStringExtra(ScanUIHandler.VALUE_ENTERED_KEY, "");

        MyJAVAValue myJAVAValue = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
        myJAVAValue.setValue(valueEntered);

        NotificationCenter.getInstance().removeObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using
        ExecutionManager.getInstance().resumeExecution(); //resume execution of thread.
    }

    @Override
    public void onNotify(String notificationString, Parameters params) {
        if(notificationString == Notifications.ON_SCAN_DIALOG_DISMISSED) {
            this.acquireInputFromUser(params);
        }
    }
    */
}
