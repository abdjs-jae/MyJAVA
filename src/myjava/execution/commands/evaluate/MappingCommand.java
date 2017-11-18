package myjava.execution.commands.evaluate;

import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext; 
import org.antlr.v4.runtime.tree.ErrorNode; 
import org.antlr.v4.runtime.tree.ParseTreeListener; 
import org.antlr.v4.runtime.tree.ParseTreeWalker; 
import org.antlr.v4.runtime.tree.TerminalNode;

import myjava.errors.checkers.UndeclaredChecker;
import myjava.execution.commands.ICommand;
import myjava.MyJAVALexer;
import myjava.MyJAVAParser.*;
import myjava.semantics.analyzers.FunctionCallVerifier; 
import myjava.semantics.mapping.IValueMapper; 
import myjava.semantics.mapping.IdentifierMapper; 
import myjava.semantics.representations.MyJAVAFunction; 
import myjava.semantics.representations.MyJAVAValue; 
import myjava.semantics.searcher.VariableSearcher;
import myjava.semantics.symboltable.SymbolTableManager; 
import myjava.semantics.symboltable.scopes.ClassScope; 
import myjava.semantics.utils.AssignmentUtils; 
import myjava.semantics.utils.Expression; 
import myjava.semantics.utils.RecognizedKeywords;

/**
 * A mapping command that evaluates a given expression context then maps
 * its corresponding value. Has an identifier string that assigns the value to it.
 * This is different from assignment command. This one is used for any variable initialization.
 *
 * @author Patrick
 *
 */
public class MappingCommand implements ICommand {
    private final static String TAG = "MyJAVA_MappingCommand";

    private String identifierString;
    private ExpressionContext parentExprCtx;

    private String modifiedExp;

    public MappingCommand(String identifierString, ExpressionContext exprCtx) {
        this.identifierString = identifierString;
        this.parentExprCtx = exprCtx;

        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.parentExprCtx);
        undeclaredChecker.check();

        ParseTreeWalker functionWalker = new ParseTreeWalker();
        functionWalker.walk(new FunctionCallVerifier(), this.parentExprCtx);

    }


    /* (non-Javadoc)
     * @see myjava.execution.commands.ICommand#execute()
     */
    @Override
    public void execute() {
        this.modifiedExp = this.parentExprCtx.getText();

        EvaluationCommand evaluationCommand = new EvaluationCommand(this.parentExprCtx);
        evaluationCommand.execute();

        MyJAVAValue myJAVAValue = VariableSearcher.searchVariable(this.identifierString);
        AssignmentUtils.assignAppropriateValue(myJAVAValue, evaluationCommand.getResult());
    }

    /*
     * Returns the modified exp, with mapped values.
     */
    public String getModifiedExp() {
        return this.modifiedExp;
    }
}