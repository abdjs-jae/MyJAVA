package myjava.semantics.analyzers;

import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.execution.ExecutionManager; 
import myjava.execution.commands.evaluate.ArrayInitializeCommand;
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.symboltable.scopes.LocalScope; 
import myjava.semantics.utils.IdentifiedTokens;

import static myjava.ITextWriter.txtWriter;

/**
 * Analyzes a given array declaration. Only accepts primitive declaration
 * @author NeilDG
 *
 */
public class ArrayAnalyzer implements ParseTreeListener{

    private final static String ARRAY_PRIMITIVE_KEY = "ARRAY_PRIMITIVE_KEY";
    private final static String ARRAY_IDENTIFIER_KEY = "ARRAY_IDENTIFIER_KEY";

    private IdentifiedTokens identifiedTokens;
    private LocalScope localScope;
    private MyJAVAArray declaredArray;

    public ArrayAnalyzer( IdentifiedTokens identifiedTokens, LocalScope localScope) {
        this.identifiedTokens = identifiedTokens;
        this.localScope = localScope;
    }

    public void analyze(ParserRuleContext ctx) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof PrimitiveTypeContext) {
            PrimitiveTypeContext primitiveCtx = (PrimitiveTypeContext) ctx;
            this.identifiedTokens.addToken(ARRAY_PRIMITIVE_KEY, primitiveCtx.getText());
        }
        else if(ctx instanceof VariableDeclaratorIdContext) {
            VariableDeclaratorIdContext varDecIdCtx = (VariableDeclaratorIdContext) ctx;
            this.identifiedTokens.addToken(ARRAY_IDENTIFIER_KEY, varDecIdCtx.getText());

            this.analyzeArray();
        }
        else if(ctx instanceof CreatedNameContext) {
            CreatedNameContext createdNameCtx = (CreatedNameContext) ctx;
            //Console.log(LogType.DEBUG, "Array created name: " +createdNameCtx.getText());
            txtWriter.writeMessage(StringUtils.formatDebug("Array created name: " +createdNameCtx.getText()));
        }

        else if(ctx instanceof ArrayCreatorRestContext) {
            ArrayCreatorRestContext arrayCreatorCtx = (ArrayCreatorRestContext) ctx;
            this.createInitializeCommand(arrayCreatorCtx);
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }

    private void analyzeArray() {
        if(this.localScope != null) {
            if(this.identifiedTokens.containsTokens(ARRAY_PRIMITIVE_KEY, ARRAY_IDENTIFIER_KEY)) {
                String arrayTypeString = this.identifiedTokens.getToken(ARRAY_PRIMITIVE_KEY);
                String arrayIdentifierString = this.identifiedTokens.getToken(ARRAY_IDENTIFIER_KEY);

                //initialize an array mobivalue
                this.declaredArray = MyJAVAArray.createArray(arrayTypeString, arrayIdentifierString);
                MyJAVAValue myJAVAValue = new MyJAVAValue(this.declaredArray, PrimitiveType.ARRAY);

                this.localScope.addMyJAVAValue(arrayIdentifierString, myJAVAValue);
                //Console.log(LogType.DEBUG, "Creating array with type " +arrayTypeString+ " variable " +arrayIdentifierString);
                txtWriter.writeMessage(StringUtils.formatDebug("Creating array with type " +arrayTypeString+ " variable " +arrayIdentifierString));
                this.identifiedTokens.clearTokens();
            }
        }

    }

    private void createInitializeCommand(ArrayCreatorRestContext arrayCreatorCtx) {
        ArrayInitializeCommand arrayInitializeCommand = new ArrayInitializeCommand(this.declaredArray, arrayCreatorCtx);
        ExecutionManager.getExecutionManager().addCommand(arrayInitializeCommand);
    }
}