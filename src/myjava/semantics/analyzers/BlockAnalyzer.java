/**
 * 
 */
package myjava.semantics.analyzers;

import myjava.generatedexp.JavaParser.BlockContext;
import myjava.generatedexp.JavaParser.BlockStatementContext;
import myjava.generatedexp.JavaParser.LocalVariableDeclarationStatementContext;
import myjava.generatedexp.JavaParser.StatementContext;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;

import java.util.List;

/**
 * Analyzes a statement block
 *
 *
 */
public class BlockAnalyzer {

	public BlockAnalyzer() {
		LocalScopeCreator.getInstance().openLocalScope();
	}
	
	public void analyze(BlockContext ctx) {
		
		List<BlockStatementContext> blockListCtx = ctx.blockStatement();
		
		for(BlockStatementContext blockStatementCtx : blockListCtx) {
			if(blockStatementCtx.statement() != null) {
				StatementContext statementCtx = blockStatementCtx.statement();
				StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
				statementAnalyzer.analyze(statementCtx);
			}
			else if(blockStatementCtx.localVariableDeclarationStatement() != null) {
				LocalVariableDeclarationStatementContext localVarDecStatementCtx = blockStatementCtx.localVariableDeclarationStatement();
				
				LocalVariableAnalyzer localVarAnalyzer = new LocalVariableAnalyzer();
				localVarAnalyzer.analyze(localVarDecStatementCtx.localVariableDeclaration());
			}
		}
		
		LocalScopeCreator.getInstance().closeLocalScope();
	}
}
