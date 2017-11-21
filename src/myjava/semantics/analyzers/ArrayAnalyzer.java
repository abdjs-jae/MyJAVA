package myjava.semantics.analyzers;

import myjava.antlrgen.ITextWriter;
import myjava.error.checkers.MultipleVarDecChecker;
import myjava.execution.ExecutionManager;
import myjava.execution.commands.evaluation.ArrayInitializeCommand;
import myjava.antlrgen.MyJAVAParser.ArrayCreatorRestContext;
import myjava.antlrgen.MyJAVAParser.CreatedNameContext;
import myjava.antlrgen.MyJAVAParser.PrimitiveTypeContext;
import myjava.antlrgen.MyJAVAParser.VariableDeclaratorIdContext;
import myjava.semantics.representations.MyJAVAArray;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.utils.IdentifiedTokens;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Analyzes a given array declaration. Only accepts primitive declaration
 *
 */
public class ArrayAnalyzer implements ITextWriter, ParseTreeListener{
	
	private final static String ARRAY_PRIMITIVE_KEY = "ARRAY_PRIMITIVE_KEY";
	private final static String ARRAY_IDENTIFIER_KEY = "ARRAY_IDENTIFIER_KEY";
	
	private IdentifiedTokens identifiedTokens;
	private ClassScope declaredClassScope;
	private LocalScope localScope;
	private MyJAVAArray declaredArray;
	
	public ArrayAnalyzer( IdentifiedTokens identifiedTokens, ClassScope declaredClassScope) {
		this.identifiedTokens = identifiedTokens;
		this.declaredClassScope = declaredClassScope;
	}
	
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
			identifiedTokens.addToken(ARRAY_PRIMITIVE_KEY, primitiveCtx.getText());
		}
		else if(ctx instanceof VariableDeclaratorIdContext) {
			VariableDeclaratorIdContext varDecIdCtx = (VariableDeclaratorIdContext) ctx;
			identifiedTokens.addToken(ARRAY_IDENTIFIER_KEY, varDecIdCtx.getText());

			MultipleVarDecChecker multipleDeclaredChecker = new MultipleVarDecChecker(varDecIdCtx);
			multipleDeclaredChecker.verify();

			analyzeArray();
		}
		else if(ctx instanceof CreatedNameContext) {
			CreatedNameContext createdNameCtx = (CreatedNameContext) ctx;
			txtWriter.writeMessage(StringUtils.formatDebug("Array created name: " +createdNameCtx.getText()));
		}
		
		else if(ctx instanceof ArrayCreatorRestContext) {
			ArrayCreatorRestContext arrayCreatorCtx = (ArrayCreatorRestContext) ctx;
			createInitializeCommand(arrayCreatorCtx);
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
	
	}
	
	private void analyzeArray() {
		
		if(declaredClassScope != null) {
			if(identifiedTokens.containsTokens(ClassAnalyzer.ACCESS_CONTROL_KEY, ARRAY_PRIMITIVE_KEY, ARRAY_IDENTIFIER_KEY)) {
				String accessControlString = identifiedTokens.getToken(ClassAnalyzer.ACCESS_CONTROL_KEY);
				String arrayTypeString = identifiedTokens.getToken(ARRAY_PRIMITIVE_KEY);
				String arrayIdentifierString = identifiedTokens.getToken(ARRAY_IDENTIFIER_KEY);
				
				//initialize an array myJAVAvalue
				declaredArray = MyJAVAArray.createArray(arrayTypeString, arrayIdentifierString);
				MyJAVAValue myJAVAValue = new MyJAVAValue(declaredArray, PrimitiveType.ARRAY);
				
				declaredClassScope.addMyJAVAValue(accessControlString, arrayIdentifierString, myJAVAValue);
				txtWriter.writeMessage(StringUtils.formatDebug("Creating array with type " +
						arrayTypeString+ " variable " +arrayIdentifierString));
				
				identifiedTokens.clearTokens();
			}
		}
		else if(localScope != null) {
			if(identifiedTokens.containsTokens(ARRAY_PRIMITIVE_KEY, ARRAY_IDENTIFIER_KEY)) {
				String arrayTypeString = identifiedTokens.getToken(ARRAY_PRIMITIVE_KEY);
				String arrayIdentifierString = identifiedTokens.getToken(ARRAY_IDENTIFIER_KEY);
				
				//initialize an array myJAVAvalue
				declaredArray = MyJAVAArray.createArray(arrayTypeString, arrayIdentifierString);
				MyJAVAValue myJAVAValue = new MyJAVAValue(declaredArray, PrimitiveType.ARRAY);
				
				localScope.addMyJAVAValue(arrayIdentifierString, myJAVAValue);
				txtWriter.writeMessage(StringUtils.formatDebug("Creating array with type " +
						arrayTypeString+ " variable " +arrayIdentifierString));
				
				identifiedTokens.clearTokens();
			}
		}
		
	}
	
	private void createInitializeCommand(ArrayCreatorRestContext arrayCreatorCtx) {
		ArrayInitializeCommand arrayInitializeCommand = new ArrayInitializeCommand(declaredArray, arrayCreatorCtx);
		ExecutionManager.getExecutionManager().addCommand(arrayInitializeCommand);
	}
}
