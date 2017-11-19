package myjava.semantics.analyzing;

import myjava.semantics.utils.StringUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.execution.ExecutionManager; 
import myjava.MyJAVAParser.*;
import myjava.semantics.scoping.LocalScope;
import myjava.semantics.scoping.LocalScopeCreator;

import static myjava.ITextWriter.txtWriter;

/**
 * The entry point for the program. Only one main is allowed.
 * @author NeilDG
 *
 */
public class MainAnalyzer implements ParseTreeListener {

    public MainAnalyzer() {

    }

    public void analyze(MethodDeclarationContext ctx) {
        if(!ExecutionManager.getExecutionManager().hasFoundEntryPoint()) {
            ExecutionManager.getExecutionManager().reportFoundEntryPoint("LocalScope");

            //automatically create a local scope for main()
            LocalScope localScope = LocalScopeCreator.getLocalScopeCreator().getActiveLocalScope();
            LocalScope parentScope = LocalScopeCreator.getLocalScopeCreator().openLocalScope();
            localScope.setParent(parentScope);

            ParseTreeWalker treeWalker = new ParseTreeWalker();
            treeWalker.walk(this, ctx);


        }
        else {
            txtWriter.writeMessage(StringUtils.formatDebug("Already found main in " +ExecutionManager.getExecutionManager().getEntryClassName()));
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