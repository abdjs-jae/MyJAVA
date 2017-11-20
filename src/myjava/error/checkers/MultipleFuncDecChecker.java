package myjava.error.checkers;

import myjava.error.*;
import myjava.antlrgen.MyJAVAParser.MethodDeclarationContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.Token;

/**
 * Checks for duplicate function declarations
 *
 */
public class MultipleFuncDecChecker implements IErrorChecker {
	
	private MethodDeclarationContext methodDecCtx;
	private int lineNumber;
	
	public MultipleFuncDecChecker(MethodDeclarationContext methodDecCtx) {
		this.methodDecCtx = methodDecCtx;
		
		Token firstToken = methodDecCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}

	@Override
	public void verify() {
		this.verifyFunctionCall(this.methodDecCtx.Identifier().getText());
	}
	
	private void verifyFunctionCall(String identifierString) {

		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
				ParserHandler.getInstance().getCurrentClassName());
		MyJAVAFunction myJAVAFunction = classScope.searchFunction(identifierString);
		
		if(myJAVAFunction != null) {
			MyJAVAErrorStrategy.reportSemanticError(MyJAVAErrorStrategy.MULTIPLE_FUNCTION, identifierString, lineNumber);
		}
	}

}
