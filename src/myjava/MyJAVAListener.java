// Generated from /Users/jasonsapdos/Documents/workspace/myJAVA/src/MyJAVA.g4 by ANTLR 4.7
package myjava;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyJAVAParser}.
 */
public interface MyJAVAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(MyJAVAParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(MyJAVAParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(MyJAVAParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(MyJAVAParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(MyJAVAParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(MyJAVAParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(MyJAVAParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(MyJAVAParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(MyJAVAParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(MyJAVAParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(MyJAVAParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(MyJAVAParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MyJAVAParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MyJAVAParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(MyJAVAParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(MyJAVAParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(MyJAVAParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(MyJAVAParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(MyJAVAParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(MyJAVAParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(MyJAVAParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(MyJAVAParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(MyJAVAParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(MyJAVAParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(MyJAVAParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(MyJAVAParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(MyJAVAParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(MyJAVAParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(MyJAVAParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(MyJAVAParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(MyJAVAParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(MyJAVAParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(MyJAVAParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(MyJAVAParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(MyJAVAParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(MyJAVAParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(MyJAVAParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(MyJAVAParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(MyJAVAParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(MyJAVAParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(MyJAVAParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(MyJAVAParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(MyJAVAParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(MyJAVAParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(MyJAVAParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(MyJAVAParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(MyJAVAParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(MyJAVAParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(MyJAVAParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(MyJAVAParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(MyJAVAParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(MyJAVAParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(MyJAVAParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(MyJAVAParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MyJAVAParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MyJAVAParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MyJAVAParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MyJAVAParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MyJAVAParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MyJAVAParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(MyJAVAParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(MyJAVAParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(MyJAVAParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(MyJAVAParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MyJAVAParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MyJAVAParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(MyJAVAParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(MyJAVAParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(MyJAVAParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(MyJAVAParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(MyJAVAParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(MyJAVAParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(MyJAVAParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(MyJAVAParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(MyJAVAParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(MyJAVAParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(MyJAVAParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(MyJAVAParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(MyJAVAParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(MyJAVAParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(MyJAVAParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(MyJAVAParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(MyJAVAParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(MyJAVAParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MyJAVAParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MyJAVAParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(MyJAVAParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(MyJAVAParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(MyJAVAParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(MyJAVAParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(MyJAVAParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(MyJAVAParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MyJAVAParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MyJAVAParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(MyJAVAParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(MyJAVAParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(MyJAVAParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(MyJAVAParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MyJAVAParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MyJAVAParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MyJAVAParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MyJAVAParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(MyJAVAParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(MyJAVAParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(MyJAVAParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(MyJAVAParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(MyJAVAParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(MyJAVAParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(MyJAVAParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(MyJAVAParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(MyJAVAParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(MyJAVAParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(MyJAVAParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(MyJAVAParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(MyJAVAParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(MyJAVAParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MyJAVAParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MyJAVAParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#scanStatement}.
	 * @param ctx the parse tree
	 */
	void enterScanStatement(MyJAVAParser.ScanStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#scanStatement}.
	 * @param ctx the parse tree
	 */
	void exitScanStatement(MyJAVAParser.ScanStatementContext ctx);
}