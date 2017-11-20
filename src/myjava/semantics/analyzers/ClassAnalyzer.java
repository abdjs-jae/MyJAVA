package myjava.semantics.analyzers;

import myjava.antlrgen.ITextWriter;
import myjava.antlrgen.MyJAVALexer;
import myjava.antlrgen.MyJAVAParser.*;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringUtils;
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
public class ClassAnalyzer implements ITextWriter, ParseTreeListener {
	
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
		
		this.declaredClassScope = new ClassScope(className);
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
			SymbolTableManager.getInstance().addClassScope(declaredClassScope.getClassName(), declaredClassScope);
		}
		
		this.analyzeClassMembers(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		
	}
	
	private void analyzeClassMembers(ParserRuleContext ctx) {
		if(ctx instanceof ClassOrInterfaceModifierContext) {
			ClassOrInterfaceTypeContext classModifierCtx = (ClassOrInterfaceTypeContext) ctx;
			
			analyzeModifier(classModifierCtx);
		}
		
		else if(ctx instanceof FieldDeclarationContext) {
			FieldDeclarationContext fieldCtx = (FieldDeclarationContext) ctx;
			
			if(fieldCtx.typeType() != null) {
				TypeTypeContext typeCtx = fieldCtx.typeType();
				
				//check if its a primitive type
				if(ClassAnalyzer.isPrimitiveDeclaration(typeCtx)) {
					PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
					identifiedTokens.addToken(PRIMITIVE_TYPE_KEY, primitiveTypeCtx.getText());
					
					//create a field analyzer to walk through declarations
					FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(identifiedTokens, declaredClassScope);
					fieldAnalyzer.analyze(fieldCtx.variableDeclarators());
					
					//clear tokens for reause
					identifiedTokens.clearTokens();
				}
				
				//check if its array declaration
				else if(ClassAnalyzer.isPrimitiveArrayDeclaration(typeCtx)) {
					txtWriter.writeMessage(StringUtils.formatDebug("Primitive array declaration: " +fieldCtx.getText()));
					ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(identifiedTokens, declaredClassScope);
					arrayAnalyzer.analyze(fieldCtx);
				}
				
				//this is for class type ctx
				else {
					
					//a string identified
					if(typeCtx.classOrInterfaceType().getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
						ClassOrInterfaceTypeContext classInterfaceCtx = typeCtx.classOrInterfaceType();
						identifiedTokens.addToken(PRIMITIVE_TYPE_KEY, classInterfaceCtx.getText());
					}
					
					//create a field analyzer to walk through declarations
					FieldAnalyzer fieldAnalyzer = new FieldAnalyzer(identifiedTokens, declaredClassScope);
					fieldAnalyzer.analyze(fieldCtx.variableDeclarators());
					
					//clear tokens for reause
					identifiedTokens.clearTokens();
				}
			}
		}
		
		else if(ctx instanceof MethodDeclarationContext) {
			MethodDeclarationContext methodDecCtx = (MethodDeclarationContext) ctx;
			MethodAnalyzer methodAnalyzer = new MethodAnalyzer(identifiedTokens, declaredClassScope);
			methodAnalyzer.analyze(methodDecCtx);
			
			//reuse tokens
			identifiedTokens.clearTokens();
		}
	}
	
	public static boolean isPrimitiveDeclaration(TypeTypeContext typeCtx) {
		if(typeCtx.primitiveType() != null) {
			List<TerminalNode> lBrackToken = typeCtx.getTokens(MyJAVALexer.LBRACK);
			List<TerminalNode> rBrackToken = typeCtx.getTokens(MyJAVALexer.RBRACK);
			
			return (lBrackToken.size() == 0 && rBrackToken.size() == 0);
		}
		
		return false;
	}
	
	public static boolean isPrimitiveArrayDeclaration(TypeTypeContext typeCtx) {
		if(typeCtx.primitiveType() != null) {
			List<TerminalNode> lBrackToken = typeCtx.getTokens(MyJAVALexer.LBRACK);
			List<TerminalNode> rBrackToken = typeCtx.getTokens(MyJAVALexer.RBRACK);
			
			return (lBrackToken.size() > 0 && rBrackToken.size() > 0);
		}
		
		return false;
	}
	
	private void analyzeModifier(ClassOrInterfaceTypeContext ctx) {
		if(ctx.getTokens(MyJAVALexer.PUBLIC).size() > 0 || ctx.getTokens(MyJAVALexer.PRIVATE).size() > 0
				|| ctx.getTokens(MyJAVALexer.PROTECTED).size() > 0) {
			txtWriter.writeMessage(StringUtils.formatDebug("Detected accessor: " +ctx.getText()));
			this.identifiedTokens.addToken(ACCESS_CONTROL_KEY, ctx.getText());
		}
		else if(ctx.getTokens(MyJAVALexer.FINAL).size() > 0) {
			txtWriter.writeMessage(StringUtils.formatDebug("Detected const: " +ctx.getText()));
			this.identifiedTokens.addToken(CONST_CONTROL_KEY, ctx.getText());
		}
		else if(ctx.getTokens(MyJAVALexer.STATIC).size() > 0) {
			txtWriter.writeMessage(StringUtils.formatDebug("Detected static: " +ctx.getText()));
			this.identifiedTokens.addToken(STATIC_CONTROL_KEY, ctx.getText());
		}
	}
	
}
