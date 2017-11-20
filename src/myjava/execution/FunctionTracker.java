package myjava.execution;

import myjava.semantics.representations.MyJAVAFunction;

import java.util.Stack;


/**
 * Holds the current function that the control flow is in.
 *
 */
public class FunctionTracker {
	
	private static FunctionTracker functionTracker = null;
	
	private Stack<MyJAVAFunction> callStack;
	
	public static FunctionTracker getInstance() {
		return functionTracker;
	}
	
	private FunctionTracker() {
		callStack = new Stack<>();
	}
	
	public static void initialize() {
		functionTracker = new FunctionTracker();
	}
	
	public static void reset() {

	}
	
	public void reportEnterFunction(MyJAVAFunction myJAVAFunction) {
		callStack.push(myJAVAFunction);
	}
	
	public void reportExitFunction() {
		callStack.pop();
	}
	
	public MyJAVAFunction getLatestFunction() {
		return callStack.peek();
	}
	
	/*
	 * Returns true if the control flow is currently inside a function
	 */
	public boolean isInsideFunction() {
		return (callStack.size() != 0);
	}
	
}
