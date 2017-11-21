package myjava.antlrgen;

import myjava.semantics.analyzers.ClassAnalyzer;
import myjava.semantics.analyzers.MainAnalyzer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyJAVATraveller extends MyJAVABaseListener {

    @Override
    public void enterCompilationUnit(MyJAVAParser.CompilationUnitContext ctx) {

    }

    @Override
    public void exitCompilationUnit(MyJAVAParser.CompilationUnitContext ctx) {

    }

    @Override
    public void enterVariableModifier(MyJAVAParser.VariableModifierContext ctx) {

    }

    @Override
    public void exitVariableModifier(MyJAVAParser.VariableModifierContext ctx) {

    }

    @Override
    public void enterClassOrInterfaceModifier(MyJAVAParser.ClassOrInterfaceModifierContext ctx) {

    }

    @Override
    public void exitClassOrInterfaceModifier(MyJAVAParser.ClassOrInterfaceModifierContext ctx) {

    }

    @Override
    public void enterTypeParameters(MyJAVAParser.TypeParametersContext ctx) {

    }

    @Override
    public void exitTypeParameters(MyJAVAParser.TypeParametersContext ctx) {

    }

    @Override
    public void enterClassDeclaration(MyJAVAParser.ClassDeclarationContext ctx) {
        ClassAnalyzer classAnalyzer = new ClassAnalyzer();
        classAnalyzer.analyze(ctx);
    }

    @Override
    public void exitClassDeclaration(MyJAVAParser.ClassDeclarationContext ctx) {

    }

    @Override
    public void enterTypeList(MyJAVAParser.TypeListContext ctx) {

    }

    @Override
    public void exitTypeList(MyJAVAParser.TypeListContext ctx) {

    }

    @Override
    public void enterClassBody(MyJAVAParser.ClassBodyContext ctx) {

    }

    @Override
    public void exitClassBody(MyJAVAParser.ClassBodyContext ctx) {

    }

    @Override
    public void enterClassBodyDeclaration(MyJAVAParser.ClassBodyDeclarationContext ctx) {

    }

    @Override
    public void exitClassBodyDeclaration(MyJAVAParser.ClassBodyDeclarationContext ctx) {

    }

    @Override
    public void enterMemberDeclaration(MyJAVAParser.MemberDeclarationContext ctx) {

    }

    @Override
    public void exitMemberDeclaration(MyJAVAParser.MemberDeclarationContext ctx) {

    }

    @Override
    public void enterMethodDeclaration(MyJAVAParser.MethodDeclarationContext ctx) {

    }

    @Override
    public void exitMethodDeclaration(MyJAVAParser.MethodDeclarationContext ctx) {

    }

    @Override
    public void enterMainDeclaration(MyJAVAParser.MainDeclarationContext ctx) {
        MainAnalyzer mainAnalyzer = new MainAnalyzer();
        mainAnalyzer.analyze(ctx);
    }

    @Override
    public void exitMainDeclaration(MyJAVAParser.MainDeclarationContext ctx) {

    }

    @Override
    public void enterFieldDeclaration(MyJAVAParser.FieldDeclarationContext ctx) {

    }

    @Override
    public void exitFieldDeclaration(MyJAVAParser.FieldDeclarationContext ctx) {

    }

    @Override
    public void enterConstDeclaration(MyJAVAParser.ConstDeclarationContext ctx) {

    }

    @Override
    public void exitConstDeclaration(MyJAVAParser.ConstDeclarationContext ctx) {

    }

    @Override
    public void enterConstantDeclarator(MyJAVAParser.ConstantDeclaratorContext ctx) {

    }

    @Override
    public void exitConstantDeclarator(MyJAVAParser.ConstantDeclaratorContext ctx) {

    }

    @Override
    public void enterVariableDeclarators(MyJAVAParser.VariableDeclaratorsContext ctx) {

    }

    @Override
    public void exitVariableDeclarators(MyJAVAParser.VariableDeclaratorsContext ctx) {

    }

    @Override
    public void enterVariableDeclarator(MyJAVAParser.VariableDeclaratorContext ctx) {

    }

    @Override
    public void exitVariableDeclarator(MyJAVAParser.VariableDeclaratorContext ctx) {

    }

    @Override
    public void enterVariableDeclaratorId(MyJAVAParser.VariableDeclaratorIdContext ctx) {

    }

    @Override
    public void exitVariableDeclaratorId(MyJAVAParser.VariableDeclaratorIdContext ctx) {

    }

    @Override
    public void enterVariableInitializer(MyJAVAParser.VariableInitializerContext ctx) {

    }

    @Override
    public void exitVariableInitializer(MyJAVAParser.VariableInitializerContext ctx) {

    }

    @Override
    public void enterArrayInitializer(MyJAVAParser.ArrayInitializerContext ctx) {

    }

    @Override
    public void exitArrayInitializer(MyJAVAParser.ArrayInitializerContext ctx) {

    }

    @Override
    public void enterTypeType(MyJAVAParser.TypeTypeContext ctx) {

    }

    @Override
    public void exitTypeType(MyJAVAParser.TypeTypeContext ctx) {

    }

    @Override
    public void enterClassOrInterfaceType(MyJAVAParser.ClassOrInterfaceTypeContext ctx) {

    }

    @Override
    public void exitClassOrInterfaceType(MyJAVAParser.ClassOrInterfaceTypeContext ctx) {

    }

    @Override
    public void enterPrimitiveType(MyJAVAParser.PrimitiveTypeContext ctx) {

    }

    @Override
    public void exitPrimitiveType(MyJAVAParser.PrimitiveTypeContext ctx) {

    }

    @Override
    public void enterTypeArguments(MyJAVAParser.TypeArgumentsContext ctx) {

    }

    @Override
    public void exitTypeArguments(MyJAVAParser.TypeArgumentsContext ctx) {

    }

    @Override
    public void enterTypeArgument(MyJAVAParser.TypeArgumentContext ctx) {

    }

    @Override
    public void exitTypeArgument(MyJAVAParser.TypeArgumentContext ctx) {

    }

    @Override
    public void enterQualifiedNameList(MyJAVAParser.QualifiedNameListContext ctx) {

    }

    @Override
    public void exitQualifiedNameList(MyJAVAParser.QualifiedNameListContext ctx) {

    }

    @Override
    public void enterFormalParameters(MyJAVAParser.FormalParametersContext ctx) {

    }

    @Override
    public void exitFormalParameters(MyJAVAParser.FormalParametersContext ctx) {

    }

    @Override
    public void enterFormalParameterList(MyJAVAParser.FormalParameterListContext ctx) {

    }

    @Override
    public void exitFormalParameterList(MyJAVAParser.FormalParameterListContext ctx) {

    }

    @Override
    public void enterFormalParameter(MyJAVAParser.FormalParameterContext ctx) {

    }

    @Override
    public void exitFormalParameter(MyJAVAParser.FormalParameterContext ctx) {

    }

    @Override
    public void enterLastFormalParameter(MyJAVAParser.LastFormalParameterContext ctx) {

    }

    @Override
    public void exitLastFormalParameter(MyJAVAParser.LastFormalParameterContext ctx) {

    }

    @Override
    public void enterMethodBody(MyJAVAParser.MethodBodyContext ctx) {

    }

    @Override
    public void exitMethodBody(MyJAVAParser.MethodBodyContext ctx) {

    }

    @Override
    public void enterQualifiedName(MyJAVAParser.QualifiedNameContext ctx) {

    }

    @Override
    public void exitQualifiedName(MyJAVAParser.QualifiedNameContext ctx) {

    }

    @Override
    public void enterLiteral(MyJAVAParser.LiteralContext ctx) {

    }

    @Override
    public void exitLiteral(MyJAVAParser.LiteralContext ctx) {

    }

    @Override
    public void enterBlock(MyJAVAParser.BlockContext ctx) {

    }

    @Override
    public void exitBlock(MyJAVAParser.BlockContext ctx) {

    }

    @Override
    public void enterBlockStatement(MyJAVAParser.BlockStatementContext ctx) {

    }

    @Override
    public void exitBlockStatement(MyJAVAParser.BlockStatementContext ctx) {

    }

    @Override
    public void enterLocalVariableDeclarationStatement(MyJAVAParser.LocalVariableDeclarationStatementContext ctx) {

    }

    @Override
    public void exitLocalVariableDeclarationStatement(MyJAVAParser.LocalVariableDeclarationStatementContext ctx) {

    }

    @Override
    public void enterLocalVariableDeclaration(MyJAVAParser.LocalVariableDeclarationContext ctx) {

    }

    @Override
    public void exitLocalVariableDeclaration(MyJAVAParser.LocalVariableDeclarationContext ctx) {

    }

    @Override
    public void enterStatement(MyJAVAParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(MyJAVAParser.StatementContext ctx) {

    }

    @Override
    public void enterCatchClause(MyJAVAParser.CatchClauseContext ctx) {

    }

    @Override
    public void exitCatchClause(MyJAVAParser.CatchClauseContext ctx) {

    }

    @Override
    public void enterCatchType(MyJAVAParser.CatchTypeContext ctx) {

    }

    @Override
    public void exitCatchType(MyJAVAParser.CatchTypeContext ctx) {

    }

    @Override
    public void enterFinallyBlock(MyJAVAParser.FinallyBlockContext ctx) {

    }

    @Override
    public void exitFinallyBlock(MyJAVAParser.FinallyBlockContext ctx) {

    }

    @Override
    public void enterResourceSpecification(MyJAVAParser.ResourceSpecificationContext ctx) {

    }

    @Override
    public void exitResourceSpecification(MyJAVAParser.ResourceSpecificationContext ctx) {

    }

    @Override
    public void enterResources(MyJAVAParser.ResourcesContext ctx) {

    }

    @Override
    public void exitResources(MyJAVAParser.ResourcesContext ctx) {

    }

    @Override
    public void enterResource(MyJAVAParser.ResourceContext ctx) {

    }

    @Override
    public void exitResource(MyJAVAParser.ResourceContext ctx) {

    }

    @Override
    public void enterSwitchBlockStatementGroup(MyJAVAParser.SwitchBlockStatementGroupContext ctx) {

    }

    @Override
    public void exitSwitchBlockStatementGroup(MyJAVAParser.SwitchBlockStatementGroupContext ctx) {

    }

    @Override
    public void enterSwitchLabel(MyJAVAParser.SwitchLabelContext ctx) {

    }

    @Override
    public void exitSwitchLabel(MyJAVAParser.SwitchLabelContext ctx) {

    }

    @Override
    public void enterForControl(MyJAVAParser.ForControlContext ctx) {

    }

    @Override
    public void exitForControl(MyJAVAParser.ForControlContext ctx) {

    }

    @Override
    public void enterForInit(MyJAVAParser.ForInitContext ctx) {

    }

    @Override
    public void exitForInit(MyJAVAParser.ForInitContext ctx) {

    }

    @Override
    public void enterEnhancedForControl(MyJAVAParser.EnhancedForControlContext ctx) {

    }

    @Override
    public void exitEnhancedForControl(MyJAVAParser.EnhancedForControlContext ctx) {

    }

    @Override
    public void enterForUpdate(MyJAVAParser.ForUpdateContext ctx) {

    }

    @Override
    public void exitForUpdate(MyJAVAParser.ForUpdateContext ctx) {

    }

    @Override
    public void enterParExpression(MyJAVAParser.ParExpressionContext ctx) {

    }

    @Override
    public void exitParExpression(MyJAVAParser.ParExpressionContext ctx) {

    }

    @Override
    public void enterExpressionList(MyJAVAParser.ExpressionListContext ctx) {

    }

    @Override
    public void exitExpressionList(MyJAVAParser.ExpressionListContext ctx) {

    }

    @Override
    public void enterStatementExpression(MyJAVAParser.StatementExpressionContext ctx) {

    }

    @Override
    public void exitStatementExpression(MyJAVAParser.StatementExpressionContext ctx) {

    }

    @Override
    public void enterConstantExpression(MyJAVAParser.ConstantExpressionContext ctx) {

    }

    @Override
    public void exitConstantExpression(MyJAVAParser.ConstantExpressionContext ctx) {

    }

    @Override
    public void enterExpression(MyJAVAParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(MyJAVAParser.ExpressionContext ctx) {

    }

    @Override
    public void enterPrimary(MyJAVAParser.PrimaryContext ctx) {

    }

    @Override
    public void exitPrimary(MyJAVAParser.PrimaryContext ctx) {

    }

    @Override
    public void enterCreator(MyJAVAParser.CreatorContext ctx) {

    }

    @Override
    public void exitCreator(MyJAVAParser.CreatorContext ctx) {

    }

    @Override
    public void enterCreatedName(MyJAVAParser.CreatedNameContext ctx) {

    }

    @Override
    public void exitCreatedName(MyJAVAParser.CreatedNameContext ctx) {

    }

    @Override
    public void enterArrayCreatorRest(MyJAVAParser.ArrayCreatorRestContext ctx) {

    }

    @Override
    public void exitArrayCreatorRest(MyJAVAParser.ArrayCreatorRestContext ctx) {

    }

    @Override
    public void enterClassCreatorRest(MyJAVAParser.ClassCreatorRestContext ctx) {

    }

    @Override
    public void exitClassCreatorRest(MyJAVAParser.ClassCreatorRestContext ctx) {

    }

    @Override
    public void enterNonWildcardTypeArguments(MyJAVAParser.NonWildcardTypeArgumentsContext ctx) {

    }

    @Override
    public void exitNonWildcardTypeArguments(MyJAVAParser.NonWildcardTypeArgumentsContext ctx) {

    }

    @Override
    public void enterTypeArgumentsOrDiamond(MyJAVAParser.TypeArgumentsOrDiamondContext ctx) {

    }

    @Override
    public void exitTypeArgumentsOrDiamond(MyJAVAParser.TypeArgumentsOrDiamondContext ctx) {

    }

    @Override
    public void enterArguments(MyJAVAParser.ArgumentsContext ctx) {

    }

    @Override
    public void exitArguments(MyJAVAParser.ArgumentsContext ctx) {

    }

    @Override
    public void enterPrintStatement(MyJAVAParser.PrintStatementContext ctx) {

    }

    @Override
    public void exitPrintStatement(MyJAVAParser.PrintStatementContext ctx) {

    }

    @Override
    public void enterScanStatement(MyJAVAParser.ScanStatementContext ctx) {

    }

    @Override
    public void exitScanStatement(MyJAVAParser.ScanStatementContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
