package myjava.semantics.analyzers;

import myjava.antlrgen.ITextWriter;
import myjava.error.ParserHandler;
import myjava.execution.ExecutionManager;
import myjava.antlrgen.MyJAVAParser.BlockContext;
import myjava.antlrgen.MyJAVAParser.MethodBodyContext;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * The entry point for the program. Only one main is allowed.
 *
 */
public class MainAnalyzer implements ITextWriter, ParseTreeListener {

	public MainAnalyzer() {
		
	}
	
	public void analyze(MainFunctionContext ctx) {
		if(!ExecutionManager.getExecutionManager().hasFoundEntryPoint()) {
			ExecutionManager.getExecutionManager().reportFoundEntryPoint(ParserHandler.getInstance().getCurrentClassName());
			
			//automatically create a local scope for main() whose parent is the class scope
			ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			LocalScope localScope = LocalScopeCreator.getInstance().openLocalScope();
			localScope.setParent(classScope);
			classScope.setParentLocalScope(localScope);
			
			ParseTreeWalker treeWalker = new ParseTreeWalker();
			treeWalker.walk(this, ctx);
			
			
		}
		else {
			txtWriter.writeMessage(StringUtils.formatDebug("Already found main in " +ExecutionManager.getExecutionManager().getEntryClassName());
		}
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
		if(ctx instanceof MethodBodyContext) {
			BlockContext blockCtx = ((MethodBodyContext) ctx).block();
			
			BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
			blockAnalyzer.analyze(blockCtx);
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
