package myjava.execution.commands.basic;

import myjava.builder.ParserHandler; 
import myjava.builder.errorcheckers.UndeclaredChecker; 
import myjava.execution.ExecutionManager; 
import myjava.execution.commands.ICommand;
import myjava.ide.console.Console; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.representations.MyJAVAValueSearcher; 
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.ClassScope; 
import myjava.semantics.utils.StringUtils; 
import myjava.ui.handlers.ScanUIHandler; 
import myjava.utils.notifications.NotificationCenter; 
import myjava.utils.notifications.NotificationListener; 
import myjava.utils.notifications.Notifications; 
import myjava.utils.notifications.Parameters;

/**
 * Represents a scan command that requires an input for the user.
 * @author NeilDG
 *
 */
public class ScanCommand implements ICommand, NotificationListener{

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
        NotificationCenter.getInstance().addObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //add an observer to listen to when the dialog has been dismissed

        Parameters params = new Parameters();
        params.putExtra(MESSAGE_DISPLAY_KEY, this.messageToDisplay);

        ExecutionManager.getInstance().blockExecution();
        NotificationCenter.getInstance().postNotification(Notifications.ON_FOUND_SCAN_STATEMENT, params);
    }

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

}
