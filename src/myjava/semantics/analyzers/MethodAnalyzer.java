package myjava.semantics.analyzers;

import myjava.antlrgen.ITextWriter;
import myjava.antlrgen.MyJAVAParser.*;
import myjava.error.checkers.MultipleFuncDecChecker;
import myjava.execution.ExecutionManager;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAFunction.FunctionType;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Analyzes method declarations and properly stores them in the symbol table
 *
 */
public class MethodAnalyzer implements ITextWriter, ParseTreeListener {
	
	private ClassScope declaredClassScope;
	private IdentifiedTokens identifiedTokens;
	private MyJAVAFunction declaredMyJAVAFunction;
	
	public MethodAnalyzer(IdentifiedTokens identifiedTokens, ClassScope declaredClassScope) {
		this.identifiedTokens = identifiedTokens;
		this.declaredClassScope = declaredClassScope;
		declaredMyJAVAFunction = new MyJAVAFunction();
	}
	
	public void analyze(MethodDeclarationContext ctx) {
		ExecutionManager.getExecutionManager().openFunctionExecution(declaredMyJAVAFunction);
		
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
			
			analyzeIdentifier(methodDecCtx.Identifier()); //get the function identifier
		}
		else {
			analyzeMethod(ctx);
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
				declaredMyJAVAFunction.setReturnType(MyJAVAFunction.identifyFunctionType(primitiveTypeCtx.getText()));
			}
			//return type is a string or a class type
			else {
				analyzeClassOrInterfaceType(typeCtx.classOrInterfaceType());
			}
		}
		
		else if(ctx instanceof FormalParametersContext) {
			FormalParametersContext formalParamsCtx = (FormalParametersContext) ctx;
			analyzeParameters(formalParamsCtx);
			storeMyJAVAFunction();
		}
		
		else if(ctx instanceof MethodBodyContext) {
			
			BlockContext blockCtx = ((MethodBodyContext) ctx).block();
			
			BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
			declaredMyJAVAFunction.setParentLocalScope(LocalScopeCreator.getInstance().getActiveLocalScope());
			blockAnalyzer.analyze(blockCtx);
			
		}
		
	}
	
	private void analyzeClassOrInterfaceType(ClassOrInterfaceTypeContext classOrInterfaceCtx) {
		//a string identified
		if(classOrInterfaceCtx.getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
			declaredMyJAVAFunction.setReturnType(FunctionType.STRING_TYPE);
		}
		//a class identified
		else {
			txtWriter.writeMessage(StringUtils.formatDebug("Class identified: " + classOrInterfaceCtx.getText()));
		}
	}
	
	private void analyzeIdentifier(TerminalNode identifier) {
		this.declaredMyJAVAFunction.setFunctionName(identifier.getText());
	}
	
	private void analyzeParameters(FormalParametersContext formalParamsCtx) {
		if(formalParamsCtx.formalParameterList() != null) {
			ParameterAnalyzer parameterAnalyzer = new ParameterAnalyzer(declaredMyJAVAFunction);
			parameterAnalyzer.analyze(formalParamsCtx.formalParameterList());
		}
	}
	
	/*
	 * Stores the created function in its corresponding class scope
	 */
	private void storeMyJAVAFunction() {
		if(this.identifiedTokens.containsTokens(ClassAnalyzer.ACCESS_CONTROL_KEY)) {
			String accessToken = identifiedTokens.getToken(ClassAnalyzer.ACCESS_CONTROL_KEY);
			
			if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, accessToken)) {
				declaredClassScope.addPrivateMyJAVAFunction(declaredMyJAVAFunction.getFunctionName(), declaredMyJAVAFunction);
			}
			else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PUBLIC, accessToken)) {
				declaredClassScope.addPublicMyJAVAFunction(declaredMyJAVAFunction.getFunctionName(), declaredMyJAVAFunction);
			}
			
			identifiedTokens.clearTokens(); //clear tokens for reuse
		}
	}

}
