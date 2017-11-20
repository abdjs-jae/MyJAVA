package myjava.semantics.analyzers;

import myjava.error.ParserHandler;
import myjava.error.checkers.ParameterMismatchChecker;
import myjava.execution.commands.evaluation.EvaluationCommand;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.representations.MobiFunction;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.ClassScope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FunctionCallVerifier implements ParseTreeListener {

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
			if(ctx instanceof ExpressionContext) {
				ExpressionContext exprCtx = (ExpressionContext) ctx;
				if (EvaluationCommand.isFunctionCall(exprCtx)) {
					if(exprCtx.expression(0).Identifier() == null)
						return;
					
					String functionName = exprCtx.expression(0).Identifier().getText();

					ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
							ParserHandler.getInstance().getCurrentClassName());
					MobiFunction mobiFunction = classScope.searchFunction(functionName);
					
					if (exprCtx.arguments() != null) {
						ParameterMismatchChecker paramsMismatchChecker = new ParameterMismatchChecker(mobiFunction, exprCtx.arguments());
						paramsMismatchChecker.verify();
					}
				}
			}
		}

		@Override
		public void exitEveryRule(ParserRuleContext ctx) {
			// TODO Auto-generated method stub
			
		}
		
	}