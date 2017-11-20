/**
 * 
 */
package myjava.error.checkers;

import myjava.error.BuildChecker;
import myjava.error.ErrorRepository;
import myjava.error.ParserHandler;
import myjava.generatedexp.JavaParser.MethodDeclarationContext;
import myjava.semantics.representations.MobiFunction;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.Token;

/**
 * Checks for duplicate function declarations
 * @author NeilDG
 *
 */
public class MultipleFuncDecChecker implements IErrorChecker {
	private final static String TAG = "MobiProg_MultipleFuncDecChecker";
	
	private MethodDeclarationContext methodDecCtx;
	private int lineNumber;
	
	public MultipleFuncDecChecker(MethodDeclarationContext methodDecCtx) {
		this.methodDecCtx = methodDecCtx;
		
		Token firstToken = methodDecCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	/* (non-Javadoc)
	 * @see myjava.error.checkers.IErrorChecker#verify()
	 */
	@Override
	public void verify() {
		this.verifyFunctionCall(this.methodDecCtx.Identifier().getText());
	}
	
	private void verifyFunctionCall(String identifierString) {

		ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
				ParserHandler.getInstance().getCurrentClassName());
		MobiFunction mobiFunction = classScope.searchFunction(identifierString);
		
		if(mobiFunction != null) {
			BuildChecker.reportCustomError(ErrorRepository.MULTIPLE_FUNCTION, "", identifierString, this.lineNumber);
		}
	}

}
