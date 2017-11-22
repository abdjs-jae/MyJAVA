package myjava.semantics.analyzers;

import myjava.antlrgen.ITextWriter;
import myjava.antlrgen.MyJAVALexer;
import myjava.error.checkers.MultipleVarDecChecker;
import myjava.error.checkers.TypeChecker;
import myjava.execution.ExecutionManager;
import myjava.antlrgen.MyJAVAParser.*;
import myjava.execution.commands.evaluation.MappingCommand;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.scopes.LocalScope;
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
 * Analyzes a local variable declaration
 *
 */
public class LocalVariableAnalyzer implements ITextWriter, ParseTreeListener {

	private final static String PRIMITIVE_TYPE_KEY = "PRIMITIVE_TYPE_KEY";
	private final static String IDENTIFIER_KEY = "IDENTIFIER_KEY";
	private final static String IDENTIFIER_VALUE_KEY = "IDENTIFIER_VALUE_KEY";

	private IdentifiedTokens identifiedTokens;
	private boolean executeMappingImmediate = false;
	private boolean hasPassedArrayDeclaration = false;

	public static boolean currentlyConst = false;

	public LocalVariableAnalyzer() {

	}

	public void analyze(LocalVariableDeclarationContext localVarDecCtx) {
		this.identifiedTokens = new IdentifiedTokens();

		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, localVarDecCtx);

	}

	public void constDone() { currentlyConst = false; }

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
		analyzeVariables(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	private void analyzeVariables(ParserRuleContext ctx) {
		if(ctx instanceof TypeTypeContext) {
			TypeTypeContext typeCtx = (TypeTypeContext) ctx;
			//clear tokens for reuse
			identifiedTokens.clearTokens();

			if(ClassAnalyzer.isPrimitiveDeclaration(typeCtx)) {
				PrimitiveTypeContext primitiveTypeCtx = typeCtx.primitiveType();
				identifiedTokens.addToken(PRIMITIVE_TYPE_KEY, primitiveTypeCtx.getText());
			}

			//check if its array declaration
			else if(ClassAnalyzer.isPrimitiveArrayDeclaration(typeCtx)) {
				txtWriter.writeMessage(StringUtils.formatDebug("Primitive array declaration: " +typeCtx.getText()));
				ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(identifiedTokens, LocalScopeCreator.getInstance().getActiveLocalScope());
				arrayAnalyzer.analyze(typeCtx.getParent());
				hasPassedArrayDeclaration = true;
			}

			//this is for class type ctx
			else {
				//a string identified
				if(typeCtx.classOrInterfaceType().getText().contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
					ClassOrInterfaceTypeContext classInterfaceCtx = typeCtx.classOrInterfaceType();
					identifiedTokens.addToken(PRIMITIVE_TYPE_KEY, classInterfaceCtx.getText());
				}
			}
		}
		else if (ctx instanceof VariableModifierContext){
			VariableModifierContext varModCtx = (VariableModifierContext) ctx;
			if(varModCtx.getTokens(MyJAVALexer.FINAL).size() > 0){
				txtWriter.writeMessage(StringUtils.formatDebug("Detected const / final: " + varModCtx.getText()));
				currentlyConst = true;
			}
		}
		else if(ctx instanceof VariableDeclaratorContext) {

			VariableDeclaratorContext varCtx = (VariableDeclaratorContext) ctx;

			if(hasPassedArrayDeclaration) {
				return;
			}

			//check for duplicate declarations
			if(!executeMappingImmediate) {
				MultipleVarDecChecker multipleDeclaredChecker = new MultipleVarDecChecker(varCtx.variableDeclaratorId());
				multipleDeclaredChecker.verify();
			}

			identifiedTokens.addToken(IDENTIFIER_KEY, varCtx.variableDeclaratorId().getText());
			createMyJAVAValue();

			if(varCtx.variableInitializer() != null) {

				//we do not evaluate strings.
				if(identifiedTokens.containsTokens(PRIMITIVE_TYPE_KEY)) {
					String primitiveTypeString = identifiedTokens.getToken(PRIMITIVE_TYPE_KEY);
					if(primitiveTypeString.contains(RecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
						identifiedTokens.addToken(IDENTIFIER_VALUE_KEY, varCtx.variableInitializer().getText());
					}
				}

				this.processMapping(varCtx);

				LocalScope localScope = LocalScopeCreator.getInstance().getActiveLocalScope();
				MyJAVAValue declaredMyJAVAValue = localScope.searchVariableIncludingLocal(varCtx.variableDeclaratorId().getText());

				//type check the myJAVAvalue
				TypeChecker typeChecker = new TypeChecker(declaredMyJAVAValue, varCtx.variableInitializer().expression());
				typeChecker.verify();
			}

		}

	}

	/*
	 * Local variable analyzer is also used for loops. Whenever there is a loop,
	 * mapping command should be executed immediately to update the value in the symbol table.
	 * Otherwise, it proceeds normally.
	 */
	private void processMapping(VariableDeclaratorContext varCtx) {
		if(this.executeMappingImmediate) {
			MappingCommand mappingCommand = new MappingCommand(varCtx.variableDeclaratorId().getText(), varCtx.variableInitializer().expression());
			mappingCommand.execute();
		}
		else {
			MappingCommand mappingCommand = new MappingCommand(varCtx.variableDeclaratorId().getText(), varCtx.variableInitializer().expression());
			ExecutionManager.getExecutionManager().addCommand(mappingCommand);
		}
	}

	public void markImmediateExecution() {
		executeMappingImmediate = true;
	}

	/*
	 * Attempts to create an intermediate representation of the variable once a sufficient amount of info has been retrieved.
	 */
	private void createMyJAVAValue() {

		if(identifiedTokens.containsTokens(PRIMITIVE_TYPE_KEY, IDENTIFIER_KEY)) {

			String primitiveTypeString = identifiedTokens.getToken(PRIMITIVE_TYPE_KEY);
			String identifierString = identifiedTokens.getToken(IDENTIFIER_KEY);
			String identifierValueString;

			LocalScope localScope = LocalScopeCreator.getInstance().getActiveLocalScope();

			if(identifiedTokens.containsTokens(IDENTIFIER_VALUE_KEY)) {
				identifierValueString = identifiedTokens.getToken(IDENTIFIER_VALUE_KEY);
				localScope.addInitializedVariableFromKeywords(primitiveTypeString, identifierString, identifierValueString);
			}
			else {
				localScope.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
			}

			//remove the following tokens
			identifiedTokens.removeToken(IDENTIFIER_KEY);
			identifiedTokens.removeToken(IDENTIFIER_VALUE_KEY);

		}
	}
}