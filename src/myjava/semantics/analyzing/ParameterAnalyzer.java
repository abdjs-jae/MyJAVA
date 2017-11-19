package myjava.semantics.analyzing;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.RecognizedKeywords;

/**
 * An analyzer for method parameters
 * @author NeilDG
 *
 */
public class ParameterAnalyzer implements ParseTreeListener {

    private final static String PARAMETER_TYPE_KEY = "PARAMETER_TYPE_KEY";
    private final static String PARAMETER_IDENTIFIER_KEY = "PARAMETER_IDENTIFIER_KEY";
    private final static String IS_ARRAY_KEY = "IS_ARRAY_KEY";

    private IdentifiedTokens identifiedTokens;
    private MyJAVAFunction declaredMyJAVAFunction;

    public ParameterAnalyzer(MyJAVAFunction declaredMyJAVAFunction) {
        this.declaredMyJAVAFunction = declaredMyJAVAFunction;
    }

    public void analyze(FormalParameterListContext ctx) {
        this.identifiedTokens = new IdentifiedTokens();

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
        if(ctx instanceof FormalParameterContext) {
            FormalParameterContext formalParamCtx = (FormalParameterContext) ctx;
            this.analyzeParameter(formalParamCtx);
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void analyzeParameter(FormalParameterContext formalParamCtx) {
        if(formalParamCtx.typeType() != null) {
            TypeTypeContext typeCtx = formalParamCtx.typeType();

            //return type is a primitive type
            if(typeCtx.primitiveType() != null) {
                PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
                this.identifiedTokens.addToken(PARAMETER_TYPE_KEY, primitiveTypeCtx.getText());
            }
            //check if its array declaration
            else if(formalParamCtx.variableDeclaratorId() != null) {
                PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
                this.identifiedTokens.addToken(PARAMETER_TYPE_KEY, primitiveTypeCtx.getText());
                this.identifiedTokens.addToken(IS_ARRAY_KEY, IS_ARRAY_KEY);
            }

            //return type is a string or a class type
            else {
                //a string type
                if(typeCtx.classOrInterfaceType().getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
                    this.identifiedTokens.addToken(PARAMETER_TYPE_KEY, typeCtx.classOrInterfaceType().getText());
                }
            }
        }

        if(formalParamCtx.variableDeclaratorId() != null) {
            TerminalNode identifier = formalParamCtx.variableDeclaratorId().Identifier();
            this.identifiedTokens.addToken(PARAMETER_IDENTIFIER_KEY, identifier.getText());

            this.createMyJAVAValue();
        }

    }

    private void createMyJAVAValue() {
        if(this.identifiedTokens.containsTokens(IS_ARRAY_KEY, PARAMETER_TYPE_KEY, PARAMETER_IDENTIFIER_KEY)) {
            String typeString = this.identifiedTokens.getToken(PARAMETER_TYPE_KEY);
            String identifierString = this.identifiedTokens.getToken(PARAMETER_IDENTIFIER_KEY);

            //initialize an array myJAVAvalue
            MyJAVAArray declaredArray = MyJAVAArray.createArray(typeString, identifierString);
            MyJAVAValue myJAVAValue = new MyJAVAValue(declaredArray, PrimitiveType.ARRAY);
            this.declaredMyJAVAFunction.addParameter(identifierString, myJAVAValue);

            //Console.log(LogType.DEBUG, "Created array parameter for " +this.declaredMobiFunction.getFunctionName());
        }
        else if(this.identifiedTokens.containsTokens(PARAMETER_TYPE_KEY, PARAMETER_IDENTIFIER_KEY)) {
            String typeString = this.identifiedTokens.getToken(PARAMETER_TYPE_KEY);
            String identifierString = this.identifiedTokens.getToken(PARAMETER_IDENTIFIER_KEY);

            MyJAVAValue myJAVAValue = MyJAVAValue.createEmptyVariableFromKeywords(typeString);
            this.declaredMyJAVAFunction.addParameter(identifierString, myJAVAValue);
        }

        this.identifiedTokens.clearTokens();
    }

}