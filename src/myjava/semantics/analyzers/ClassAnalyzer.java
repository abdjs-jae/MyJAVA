/**
 * 
 */
package myjava.semantics.analyzers;

import myjava.generatedexp.JavaLexer;
import myjava.generatedexp.JavaParser.*;
import myjava.ide.console.Console;
import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.RecognizedKeywords;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * A bridge for analyzing creation of a class

 *
 */
public class ClassAnalyzer implements ParseTreeListener {
	private final static String TAG = "MyJAVAProg_ClassAnalyzer";
	
	private ClassScope declaredClassScope;
	private IdentifiedTokens identifiedTokens;
	
	public final static String ACCESS_CONTROL_KEY = "ACCESS_CONTROL_KEY";
	public final static String CONST_CONTROL_KEY = "CONST_CONSTROL_KEY";
	public final static String STATIC_CONTROL_KEY = "STATIC_CONTROL_KEY";
	public final static String PRIMITIVE_TYPE_KEY = "PRIMITIVE_TYPE_KEY";
	public final static String IDENTIFIER_KEY = "IDENTIFIER_KEY";
	public final static String IDENTIFIER_VALUE_KEY = "IDENTIFIER_VALUE_KEY";
	
	public ClassAnalyzer() {
		
	}
	
	public void analyze(ClassDeclarationContext ctx) {
		String className = ctx.Identifier().getText();
		
		Console.log(LogType.DEBUG, "Class name is " +className);
		ClassNameChecker classNameChecker = new ClassNameChecker(className);
		classNameChecker.verify();
		
		this.declaredClassScope = new ClassScope(classNameChecker.correctClassName());
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
		if(ctx instanceof ClassDeclarationContext) {
			SymbolTableManager.getInstance().addClassScope(this.declaredClassScope.getClassName(), this.declaredClassScope);
		}
		
		this.analyzeClassMembers(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		
	}
	
	private void analyzeClassMembers(ParserRuleContext ctx) {
		if(ctx instanceof ClassOrInterfaceModifierContext) {
			ClassOrInterfaceModifierContext classModifierCtx = (ClassOrInterfaceModifierContext) ctx;
			
			this.analyzeModifier(classModifierCtx);
		}
		
		else if(ctx instanceof FieldDeclarationContext) {
			FieldDeclarationContext fieldCtx = (FieldDeclarationContext) ctx;
			
			if(fieldCtx.type() != null) {
				TypeContext typeCtx = fieldCtx.type();
				
				//check if its a primitive type
				if(ClassAnalyzer.isPrimitiveDeclaration(typeCtx)) {
					PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
					this.identifiedTokens.addToken(PRIMITIVE_TYPE_KEY, primitiveTypeCtx.getText());
					
					//create a field analyzer to walk through declarations
					FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(this.identifiedTokens, this.declaredClassScope);
					fieldAnalyzer.analyze(fieldCtx.variableDeclarators());
					
					//clear tokens for reause
					this.identifiedTokens.clearTokens();	
				}
				
				//check if its array declaration
				else if(ClassAnalyzer.isPrimitiveArrayDeclaration(typeCtx)) {
					Console.log(LogType.DEBUG, "Primitive array declaration: " +fieldCtx.getText());
					ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(this.identifiedTokens, this.declaredClassScope);
					arrayAnalyzer.analyze(fieldCtx);
				}
				
				//this is for class type ctx
				else {
					
					//a string identified
					if(typeCtx.classOrInterfaceType().getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
						ClassOrInterfaceTypeContext classInterfaceCtx = typeCtx.classOrInterfaceType();
						this.identifiedTokens.addToken(PRIMITIVE_TYPE_KEY, classInterfaceCtx.getText());
					}
					
					//create a field analyzer to walk through declarations
					FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(this.identifiedTokens, this.declaredClassScope);
					fieldAnalyzer.analyze(fieldCtx.variableDeclarators());
					
					//clear tokens for reause
					this.identifiedTokens.clearTokens();
				}
			}
		}
		
		else if(ctx instanceof MethodDeclarationContext) {
			MethodDeclarationContext methodDecCtx = (MethodDeclarationContext) ctx;
			MethodAnalyzer methodAnalyzer = new MethodAnalyzer(this.identifiedTokens, this.declaredClassScope);
			methodAnalyzer.analyze(methodDecCtx);
			
			//reuse tokens
			this.identifiedTokens.clearTokens();
		}
	}
	
	public static boolean isPrimitiveDeclaration(TypeContext typeCtx) {
		if(typeCtx.primitiveType() != null) {
			List<TerminalNode> lBrackToken = typeCtx.getTokens(JavaLexer.LBRACK);
			List<TerminalNode> rBrackToken = typeCtx.getTokens(JavaLexer.RBRACK);
			
			return (lBrackToken.size() == 0 && rBrackToken.size() == 0);
		}
		
		return false;
	}
	
	public static boolean isPrimitiveArrayDeclaration(TypeContext typeCtx) {
		if(typeCtx.primitiveType() != null) {
			List<TerminalNode> lBrackToken = typeCtx.getTokens(JavaLexer.LBRACK);
			List<TerminalNode> rBrackToken = typeCtx.getTokens(JavaLexer.RBRACK);
			
			return (lBrackToken.size() > 0 && rBrackToken.size() > 0);
		}
		
		return false;
	}
	
	private void analyzeModifier(ClassOrInterfaceModifierContext ctx) {
		if(ctx.getTokens(JavaLexer.PUBLIC).size() > 0 || ctx.getTokens(JavaLexer.PRIVATE).size() > 0
				|| ctx.getTokens(JavaLexer.PROTECTED).size() > 0) {
			Console.log(LogType.DEBUG, "Detected accessor: " +ctx.getText());
			this.identifiedTokens.addToken(ACCESS_CONTROL_KEY, ctx.getText());
		}
		else if(ctx.getTokens(JavaLexer.FINAL).size() > 0) {
			Console.log(LogType.DEBUG, "Detected const: " +ctx.getText());
			this.identifiedTokens.addToken(CONST_CONTROL_KEY, ctx.getText());
		}
		else if(ctx.getTokens(JavaLexer.STATIC).size() > 0) {
			Console.log(LogType.DEBUG, "Detected static: " +ctx.getText());
			this.identifiedTokens.addToken(STATIC_CONTROL_KEY, ctx.getText());
		}
	}
	
}
