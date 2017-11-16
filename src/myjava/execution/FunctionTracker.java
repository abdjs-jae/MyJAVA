package myjava.execution;

import java.util.Stack;
import myjava.semantics.representations.MyJAVAFunction;


/**
 * Holds the current function that the control flow is in.
 * @author NeilDG
 *
 */
public class FunctionTracker {
    private final static String TAG = "MyJAVA CallGraphManager";

    private static FunctionTracker sharedInstance = null;

    private Stack<MyJAVAFunction> callStack;

    public static FunctionTracker getInstance() {
        return sharedInstance;
    }

    private FunctionTracker() {
        this.callStack = new Stack<MyJAVAFunction>();
    }

    public static void initialize() {
        sharedInstance = new FunctionTracker();
    }

    public static void reset() {

    }

    public void reportEnterFunction(MyJAVAFunction myJAVAFunction) {
        this.callStack.push(myJAVAFunction);
    }

    public void reportExitFunction() {
        this.callStack.pop();
    }

    public MyJAVAFunction getLatestFunction() {
        return this.callStack.peek();
    }

    /*
     * Returns true if the control flow is currently inside a function
     */
    public boolean isInsideFunction() {
        return (this.callStack.size() != 0);
    }

}