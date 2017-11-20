/**
 * 
 */
package myjava.semantics.analyzers;

import myjava.generatedexp.JavaParser.FormalParameterContext;
import myjava.generatedexp.JavaParser.FormalParameterListContext;
import myjava.generatedexp.JavaParser.PrimitiveTypeContext;
import myjava.generatedexp.JavaParser.TypeContext;
import myjava.ide.console.Console;
import myjava.ide.console.LogItemView.LogType;
import myjava.semantics.representations.MobiArray;
import myjava.semantics.representations.MobiFunction;
import myjava.semantics.representations.MobiValue;
import myjava.semantics.representations.MobiValue.PrimitiveType;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.RecognizedKeywords;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * An analyzer for method parameters
 *
 *
 */
public class ParameterAnalyzer implements ParseTreeListener {
	private final static String TAG = "MobiProg_ParameterAnalyzer";
	
	private final static String PARAMETER_TYPE_KEY = "PARAMETER_TYPE_KEY";
	private final static String PARAMETER_IDENTIFIER_KEY = "PARAMETER_IDENTIFIER_KEY";
	private final static String IS_ARRAY_KEY = "IS_ARRAY_KEY";
	
	
	private IdentifiedTokens identifiedTokens;
	private MobiFunction declaredMobiFunction;
	
	public ParameterAnalyzer(MobiFunction declaredMobiFunction) {
		this.declaredMobiFunction = declaredMobiFunction;
	}
	
	public void analyze(FormalParameterListContext ctx) {
		this.identifiedTokens = new IdentifiedTokens();
		
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, ctx);
	}
	
	/* (non-Javadoc)
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#visitTerminal(org.antlr.v4.runtime.tree.TerminalNode)
	 */
	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#visitErrorNode(org.antlr.v4.runtime.tree.ErrorNode)
	 */
	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#enterEveryRule(org.antlr.v4.runtime.ParserRuleContext)
	 */
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof FormalParameterContext) {
			FormalParameterContext formalParamCtx = (FormalParameterContext) ctx;
			this.analyzeParameter(formalParamCtx);
		}
	}

	/* (non-Javadoc)
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#exitEveryRule(org.antlr.v4.runtime.ParserRuleContext)
	 */
	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}
	
	private void analyzeParameter(FormalParameterContext formalParamCtx) {
		if(formalParamCtx.type() != null) {
			TypeContext typeCtx = formalParamCtx.type();
			
			//return type is a primitive type
			if(ClassAnalyzer.isPrimitiveDeclaration(typeCtx)) {
				PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
				this.identifiedTokens.addToken(PARAMETER_TYPE_KEY, primitiveTypeCtx.getText());
			}
			//check if its array declaration
			else if(ClassAnalyzer.isPrimitiveArrayDeclaration(typeCtx)) {
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
			
			this.createMobiValue();
		}
		
	}
	
	private void createMobiValue() {
		if(this.identifiedTokens.containsTokens(IS_ARRAY_KEY, PARAMETER_TYPE_KEY, PARAMETER_IDENTIFIER_KEY)) {
			String typeString = this.identifiedTokens.getToken(PARAMETER_TYPE_KEY);
			String identifierString = this.identifiedTokens.getToken(PARAMETER_IDENTIFIER_KEY);
			
			//initialize an array mobivalue
			MobiArray declaredArray = MobiArray.createArray(typeString, identifierString);
			MobiValue mobiValue = new MobiValue(declaredArray, PrimitiveType.ARRAY);
			this.declaredMobiFunction.addParameter(identifierString, mobiValue);
			
			Console.log(LogType.DEBUG, "Created array parameter for " +this.declaredMobiFunction.getFunctionName());
		}
		else if(this.identifiedTokens.containsTokens(PARAMETER_TYPE_KEY, PARAMETER_IDENTIFIER_KEY)) {
			String typeString = this.identifiedTokens.getToken(PARAMETER_TYPE_KEY);
			String identifierString = this.identifiedTokens.getToken(PARAMETER_IDENTIFIER_KEY);
			
			MobiValue mobiValue = MobiValue.createEmptyVariableFromKeywords(typeString);
			this.declaredMobiFunction.addParameter(identifierString, mobiValue);
		}
		
		this.identifiedTokens.clearTokens();
	}

}
