package myjava.semantics.analyzers;

import myjava.semantics.symboltable.scopes.LocalScope;
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

    private LocalScope declaredLocalScope;
    private IdentifiedTokens identifiedTokens;
    private MyJAVAFunction declaredMyJAVAFunction;

    public MethodAnalyzer(IdentifiedTokens identifiedTokens, LocalScope declaredLocalScope) {
        this.identifiedTokens = identifiedTokens;
        this.declaredLocalScope = declaredLocalScope;
        this.declaredMyJAVAFunction = new MyJAVAFunction();
    }

    public void analyze(MethodDeclarationContext context) {
        ExecutionManager.getExecutionManager().openFunctionExecution(this.declaredMyJAVAFunction);

        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, context);
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
    public void enterEveryRule(ParserRuleContext context) {
        if(context instanceof MethodDeclarationContext) {
            MethodDeclarationContext methodDecContext = (MethodDeclarationContext) context;
            MultipleFunctionChecker funcDecChecker = new MultipleFunctionChecker(methodDecContext);
            funcDecChecker.check();

            this.analyzeIdentifier(methodDecContext.Identifier()); //get the function identifier
        }
        else {
            this.analyzeMethod(context);
        }

    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {
        if(context instanceof MethodDeclarationContext) {
            ExecutionManager.getExecutionManager().closeFunctionExecution();
        }
    }

    private void analyzeMethod(ParserRuleContext context) {

        if(context instanceof TypeTypeContext) {
            TypeTypeContext typeContext = (TypeTypeContext) context;

            //return type is a primitive type
            if(typeContext.primitiveType() != null) {
                PrimitiveTypeContext primitiveTypeContext = typeContext.primitiveType();
                this.declaredMyJAVAFunction.setReturnType(MyJAVAFunction.identifyFunctionType(primitiveTypeContext.getText()));
            }
            //return type is a string type
            else {
                ClassOrInterfaceTypeContext classOrInterfaceTypeContext = typeContext.classOrInterfaceType();
                if(classOrInterfaceTypeContext.getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
                    this.declaredMyJAVAFunction.setReturnType(FunctionType.STRING_TYPE);
                }
            }
        }

        else if(context instanceof FormalParametersContext) {
            FormalParametersContext formalParamsContext = (FormalParametersContext) context;
            this.analyzeParameters(formalParamsContext);
            this.storeMyJAVAFunction();
        }

        else if(context instanceof MethodBodyContext) {

            BlockContext blockContext = ((MethodBodyContext) context).block();

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            this.declaredMyJAVAFunction.setParentLocalScope(LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope());
            blockAnalyzer.analyze(blockContext);

        }

    }

    private void analyzeIdentifier(TerminalNode identifier) {
        this.declaredMyJAVAFunction.setFunctionName(identifier.getText());
    }

    private void analyzeParameters(FormalParametersContext formalParamsContext) {
        if(formalParamsContext.formalParameterList() != null) {
            ParameterAnalyzer parameterAnalyzer = new ParameterAnalyzer(this.declaredMyJAVAFunction);
            parameterAnalyzer.analyze(formalParamsContext.formalParameterList());
        }
    }

    /*
     * Stores the created function in its corresponding class scope
     */
    private void storeMyJAVAFunction() {
        declaredLocalScope.addMyJAVAFunction(declaredMyJAVAFunction.getFunctionName(), declaredMyJAVAFunction);
        this.identifiedTokens.clearTokens(); //clear tokens for reuse
    }

}