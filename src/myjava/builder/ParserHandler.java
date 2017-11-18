package myjava.builder;

import myjava.MyJAVABaseListener;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream; 
import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import static myjava.ITextWriter.txtWriter;

/**
 * Manages all parsing from different saved files
 * @author Patrick
 *
 */
public class ParserHandler {

    private final static String TAG = "MyJAVAProg_ParserHandler";
    private static ParserHandler sharedInstance = null;

    public static ParserHandler getInstance() {
        if(sharedInstance == null) {
            sharedInstance = new ParserHandler();
        }

        return sharedInstance;
    }

    private MyJAVALexer sharedLexer;
    private MyJAVAParser sharedParser;

    private String currentClassName; //the current class being parsed

    private ParserHandler() {

    }

    public void parseText(String className, String textToParse) {
        this.currentClassName = className.replace(".myJAVA", "");
        this.sharedLexer = new MyJAVALexer(new ANTLRInputStream(textToParse));
        CommonTokenStream tokens = new CommonTokenStream(this.sharedLexer);
        this.sharedParser = new MyJAVAParser(tokens);
        this.sharedParser.removeErrorListeners();
        this.sharedParser.addErrorListener(BuildChecker.getInstance());

        ParserRuleContext parserRuleContext = this.sharedParser.compilationUnit();
        //Console.log(LogType.DEBUG, parserRuleContext.toStringTree(this.sharedParser));
        txtWriter.writeMessage(StringUtils.formatDebug(parserRuleContext.toStringTree(this.sharedParser)));

        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(new MyJAVABaseListener(), parserRuleContext);

        //Console.log(LogType.VERBOSE, "Finished parsing. Compiled executables. Click RUN to execute");
        txtWriter.writeMessage(StringUtils.formatProgram("Finished parsing. Compiled executables. Click RUN to execute"));
    }

    /*
     * Returns the class name being parsed
     */
    public String getCurrentClassName() {
        return this.currentClassName;
    }
}
