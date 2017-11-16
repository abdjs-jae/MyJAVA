package myjava.execution;

import java.util.Stack;
import myjava.semantics.representations.MyJAVAFunction;


/**
 * Holds the current function that the control flow is in.
 * @author NeilDG
 *
 */
public class FunctionTracker {

    private static FunctionTracker functionTracker = null;

    private Stack<MyJAVAFunction> callStack;

    private FunctionTracker() {
        this.callStack = new Stack<>();
    }

    public static FunctionTracker getFunctionTracker() {
        return functionTracker;
    }

    public static void initialize() {
        functionTracker = new FunctionTracker();
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