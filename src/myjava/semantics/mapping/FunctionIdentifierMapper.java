package myjava.semantics.mapping;

import myjava.error.ParserHandler;
import myjava.antlrgen.MyJAVAParser.ExpressionContext;
import myjava.antlrgen.MyJAVAParser.ParExpressionContext;
import myjava.antlrgen.MyJAVAParser.PrimaryContext;
import myjava.semantics.representations.MyJAVAFunction;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import myjava.semantics.symboltable.scopes.LocalScope;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Maps an identifier to a given value found in the function level. First, we search the mapped parameters if a variable already exists.
 * Then we search its parent local scope using depth-first search.
 *
 */
public class FunctionIdentifierMapper implements ParseTreeListener, IValueMapper {
	
	private String originalExp = null;
	private String modifiedExp = null;
	
	private MyJAVAFunction assignedFunction;
	private MyJAVAValue myJAVAValue;
	private LocalScope functionLocalScope;
	
	public FunctionIdentifierMapper(String originalExp, MyJAVAFunction assignedFunction) {
		this.originalExp = originalExp;
		this.modifiedExp = originalExp;
		this.assignedFunction = assignedFunction;
		functionLocalScope = assignedFunction.getParentLocalScope();
	}
	
	public void analyze(ExpressionContext exprCtx) {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, exprCtx);
	}
	
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
				searchVariable(variableKey);
			}
		}
	}
	
	private void searchVariable(String identifierString) {
		if(assignedFunction.hasParameter(identifierString)) {
			modifiedExp = modifiedExp.replace(identifierString, assignedFunction.getParameter(identifierString).getValue().toString());
		}
		else {
			myJAVAValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, functionLocalScope);
			
			if(myJAVAValue != null) {
				modifiedExp = modifiedExp.replace(identifierString, myJAVAValue.getValue().toString());
			}
			else {
				ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
				myJAVAValue = classScope.searchVariableIncludingLocal(identifierString);

				modifiedExp = modifiedExp.replace(identifierString, myJAVAValue.getValue().toString());
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
