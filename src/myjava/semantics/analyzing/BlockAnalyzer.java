package myjava.semantics.analyzing;

import java.util.List;

import myjava.MyJAVAParser.*;
import myjava.semantics.scoping.LocalScopeCreator;

/**
 * Analyzes a statement block
 * @author NeilDG
 *
 */
public class BlockAnalyzer {

    public BlockAnalyzer() {
        LocalScopeCreator.getLocalScopeCreator().openLocalScope();
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

        LocalScopeCreator.getLocalScopeCreator().closeLocalScope();
    }
}