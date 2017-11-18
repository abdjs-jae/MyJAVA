package myjava.semantics.analyzers;

import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.errors.checkers.MultipleFunctionChecker;
import myjava.execution.ExecutionManager; 
import myjava.MyJAVAParser.*;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAFunction.FunctionType;
import myjava.semantics.symboltable.scopes.ClassScope; 
import myjava.semantics.symboltable.scopes.LocalScopeCreator; 
import myjava.semantics.utils.IdentifiedTokens; 
import myjava.semantics.utils.RecognizedKeywords;

import static myjava.ITextWriter.txtWriter;

/**
 * Analyzes method declarations and properly stores them in the symbol table
 * @author NeilDG
 *
 */
public class MethodAnalyzer implements ParseTreeListener {
    private final static String TAG = "MyJAVA_MethodAnalyzer";

    private ClassScope declaredClassScope;
    private IdentifiedTokens identifiedTokens;
    private MyJAVAFunction declaredMyJAVAFunction;

    public MethodAnalyzer(IdentifiedTokens identifiedTokens, ClassScope declaredClassScope) {
        this.identifiedTokens = identifiedTokens;
        this.declaredClassScope = declaredClassScope;
        this.declaredMyJAVAFunction = new MyJAVAFunction();
    }

    public void analyze(MethodDeclarationContext ctx) {
        ExecutionManager.getExecutionManager().openFunctionExecution(this.declaredMyJAVAFunction);

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
        if(ctx instanceof MethodDeclarationContext) {
            MethodDeclarationContext methodDecCtx = (MethodDeclarationContext) ctx;
            MultipleFunctionChecker funcDecChecker = new MultipleFunctionChecker(methodDecCtx);
            funcDecChecker.check();

            this.analyzeIdentifier(methodDecCtx.Identifier()); //get the function identifier
        }
        else {
            this.analyzeMethod(ctx);
        }

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof MethodDeclarationContext) {
            ExecutionManager.getExecutionManager().closeFunctionExecution();
        }
    }

    private void analyzeMethod(ParserRuleContext ctx) {

        if(ctx instanceof TypeTypeContext) {
            TypeTypeContext typeCtx = (TypeTypeContext) ctx;

            //return type is a primitive type
            if(typeCtx.primitiveType() != null) {
                PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
                this.declaredMyJAVAFunction.setReturnType(MyJAVAFunction.identifyFunctionType(primitiveTypeCtx.getText()));
            }
            //return type is a string or a class type
            else {
                this.analyzeClassOrInterfaceType(typeCtx.classOrInterfaceType());
            }
        }

        else if(ctx instanceof FormalParametersContext) {
            FormalParametersContext formalParamsCtx = (FormalParametersContext) ctx;
            this.analyzeParameters(formalParamsCtx);
            this.storeMyJAVAFunction();
        }

        else if(ctx instanceof MethodBodyContext) {

            BlockContext blockCtx = ((MethodBodyContext) ctx).block();

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            this.declaredMyJAVAFunction.setParentLocalScope(LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope());
            blockAnalyzer.analyze(blockCtx);

        }

    }

    private void analyzeClassOrInterfaceType(ClassOrInterfaceTypeContext classOrInterfaceCtx) {
        //a string identified
        if(classOrInterfaceCtx.getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
            this.declaredMyJAVAFunction.setReturnType(FunctionType.STRING_TYPE);
        }
        //a class identified
        else {
            //Console.log(LogType.DEBUG, "Class identified: " + classOrInterfaceCtx.getText());
            txtWriter.writeMessage(StringUtils.formatDebug("Class identified: " +classOrInterfaceCtx.getText()));
        }
    }

    private void analyzeIdentifier(TerminalNode identifier) {
        this.declaredMyJAVAFunction.setFunctionName(identifier.getText());
    }

    private void analyzeParameters(FormalParametersContext formalParamsCtx) {
        if(formalParamsCtx.formalParameterList() != null) {
            ParameterAnalyzer parameterAnalyzer = new ParameterAnalyzer(this.declaredMyJAVAFunction);
            parameterAnalyzer.analyze(formalParamsCtx.formalParameterList());
        }
    }

    /*
     * Stores the created function in its corresponding class scope
     */
    private void storeMyJAVAFunction() {
        /*
        if(this.identifiedTokens.containsTokens(ClassAnalyzer.ACCESS_CONTROL_KEY)) {
            String accessToken = this.identifiedTokens.getToken(ClassAnalyzer.ACCESS_CONTROL_KEY);

            if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, accessToken)) {
                this.declaredClassScope.addPrivateMobiFunction(this.declaredMobiFunction.getFunctionName(), this.declaredMobiFunction);
            }
            else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PUBLIC, accessToken)) {
                this.declaredClassScope.addPublicMobiFunction(this.declaredMobiFunction.getFunctionName(), this.declaredMobiFunction);
            }

            this.identifiedTokens.clearTokens(); //clear tokens for reuse
        }
        */
    }

}