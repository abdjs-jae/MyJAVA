package myjava.semantics.mapping;

import myjava.error.ParserHandler;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.ParExpressionContext;
import myjava.antlrgen.MyJAVAParser.PrimaryContext;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Maps an identifier to a given value found in the symbol table manager in the class level.

 *
 */
public class ClassIdentifierMapper implements ParseTreeListener, IValueMapper {
	
	private MyJAVAValue myJAVAValue;
	private String originalExp = null;
	private String modifiedExp = null;
	
	public ClassIdentifierMapper(String originalExp) {
		this.originalExp = originalExp;
		this.modifiedExp = originalExp;
	}

	@Override
	public void analyze(ExpressionContext exprCtx) {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, exprCtx);
	}

	@Override
	public void analyze(ParExpressionContext exprCtx) {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, exprCtx);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof PrimaryContext) {
			PrimaryContext primaryCtx = (PrimaryContext) ctx;
			
			if(primaryCtx.Identifier() != null) {
				String variableKey = primaryCtx.getText();
				ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
				
				myJAVAValue = classScope.searchVariableIncludingLocal(variableKey);
				modifiedExp = modifiedExp.replace(variableKey, myJAVAValue.getValue().toString());
			}
		}
	}
	
	@Override
	public MyJAVAValue getMyJAVAValue() {
		return myJAVAValue;
	}

	@Override
	public String getOriginalExp() {
		return originalExp;
	}

	@Override
	public String getModifiedExp() {
		return modifiedExp;
	}

}
