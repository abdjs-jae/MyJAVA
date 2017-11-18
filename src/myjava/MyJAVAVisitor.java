// Generated from C:/Users/JJ/Documents/Repository/MyJAVA/src\MyJAVA.g4 by ANTLR 4.7
package myjava;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyJAVAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyJAVAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(MyJAVAParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(MyJAVAParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(MyJAVAParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MyJAVAParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(MyJAVAParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(MyJAVAParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MyJAVAParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(MyJAVAParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(MyJAVAParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constantDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclarator(MyJAVAParser.ConstantDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(MyJAVAParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(MyJAVAParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(MyJAVAParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(MyJAVAParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(MyJAVAParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(MyJAVAParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(MyJAVAParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MyJAVAParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(MyJAVAParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(MyJAVAParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedNameList(MyJAVAParser.QualifiedNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(MyJAVAParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(MyJAVAParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(MyJAVAParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(MyJAVAParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(MyJAVAParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(MyJAVAParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MyJAVAParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MyJAVAParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MyJAVAParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(MyJAVAParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(MyJAVAParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MyJAVAParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(MyJAVAParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(MyJAVAParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(MyJAVAParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(MyJAVAParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#resources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResources(MyJAVAParser.ResourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(MyJAVAParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(MyJAVAParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(MyJAVAParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(MyJAVAParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MyJAVAParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#enhancedForControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForControl(MyJAVAParser.EnhancedForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(MyJAVAParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(MyJAVAParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MyJAVAParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(MyJAVAParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(MyJAVAParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MyJAVAParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MyJAVAParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(MyJAVAParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedName(MyJAVAParser.CreatedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(MyJAVAParser.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(MyJAVAParser.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArguments(MyJAVAParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(MyJAVAParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MyJAVAParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MyJAVAParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#scanStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanStatement(MyJAVAParser.ScanStatementContext ctx);
}