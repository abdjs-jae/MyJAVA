/**
 * 
 */
package myjava.semantics.analyzers;

import myjava.error.checkers.MultipleFuncDecChecker;
import myjava.execution.ExecutionManager;
import myjava.generatedexp.JavaParser.*;
import myjava.ide.console.Console;
import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAFunction.FunctionType;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.RecognizedKeywords;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Analyzes method declarations and properly stores them in the symbol table

 *
 */
public class MethodAnalyzer implements ParseTreeListener {
	private final static String TAG = "MyJAVAProg_MethodAnalyzer";
	
	private ClassScope declaredClassScope;
	private IdentifiedTokens identifiedTokens;
	private MyJAVAFunction declaredMyJAVAFunction;
	
	public MethodAnalyzer(IdentifiedTokens identifiedTokens, ClassScope declaredClassScope) {
		this.identifiedTokens = identifiedTokens;
		this.declaredClassScope = declaredClassScope;
		this.declaredMyJAVAFunction = new MyJAVAFunction();
	}
	
	public void analyze(MethodDeclarationContext ctx) {
		ExecutionManager.getInstance().openFunctionExecution(this.declaredMyJAVAFunction);
		
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
			MultipleFuncDecChecker funcDecChecker = new MultipleFuncDecChecker(methodDecCtx);
			funcDecChecker.verify();
			
			this.analyzeIdentifier(methodDecCtx.Identifier()); //get the function identifier
		}
		else {
			this.analyzeMethod(ctx);
		}
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof MethodDeclarationContext) {
			ExecutionManager.getInstance().closeFunctionExecution();
		}
	}
	
	private void analyzeMethod(ParserRuleContext ctx) {
		
		if(ctx instanceof TypeContext) {
			TypeContext typeCtx = (TypeContext) ctx;
			
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
			this.declaredMyJAVAFunction.setParentLocalScope(LocalScopeCreator.getInstance().getActiveLocalScope());
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
			Console.log(LogType.DEBUG, "Class identified: " + classOrInterfaceCtx.getText());
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
		if(this.identifiedTokens.containsTokens(ClassAnalyzer.ACCESS_CONTROL_KEY)) {
			String accessToken = this.identifiedTokens.getToken(ClassAnalyzer.ACCESS_CONTROL_KEY);
			
			if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, accessToken)) {
				this.declaredClassScope.addPrivateMyJAVAFunction(this.declaredMyJAVAFunction.getFunctionName(), this.declaredMyJAVAFunction);
			}
			else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PUBLIC, accessToken)) {
				this.declaredClassScope.addPublicMyJAVAFunction(this.declaredMyJAVAFunction.getFunctionName(), this.declaredMyJAVAFunction);
			}
			
			this.identifiedTokens.clearTokens(); //clear tokens for reuse
		}
	}

}
