/**
 * 
 */
package myjava.error;

/**
 * Manages all parsing from different saved files
 * @author Patrick
 *
 */
public class ParserHandler {
/*
	private final static String TAG = "MobiProg_ParserHandler";
	private static ParserHandler sharedInstance = null;
	
	public static ParserHandler getInstance() {
		if(sharedInstance == null) {
			sharedInstance = new ParserHandler();
		}
		
		return sharedInstance;
	}
	
	private JavaLexer sharedLexer;
	private JavaParser sharedParser;
	
	private String currentClassName; //the current class being parsed
	
	private ParserHandler() {
		
	}
	
	public void parseText(String className, String textToParse) {
		this.currentClassName = className.replace(".mobi", "");
		this.sharedLexer = new JavaLexer(new ANTLRInputStream(textToParse));
		CommonTokenStream tokens = new CommonTokenStream(this.sharedLexer);
		this.sharedParser = new JavaParser(tokens);
		this.sharedParser.removeErrorListeners();
		this.sharedParser.addErrorListener(BuildChecker.getInstance());
		
		ParserRuleContext parserRuleContext = this.sharedParser.compilationUnit();
		Console.log(LogType.DEBUG, parserRuleContext.toStringTree(this.sharedParser));
		
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(new JavaBaseImplementor(), parserRuleContext);

		Console.log(LogType.VERBOSE, "Finished parsing. Compiled executables. Click RUN to execute");
	}
	
	/*
	 * Returns the class name being parsed

	public String getCurrentClassName() {
		return this.currentClassName;
	}*/

}
