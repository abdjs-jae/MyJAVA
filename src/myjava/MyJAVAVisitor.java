// Generated from /Users/jasonsapdos/Documents/workspace/MyJAVA/src/MyJAVA.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link MyJAVAParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(MyJAVAParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(MyJAVAParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(MyJAVAParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(MyJAVAParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceModifier(MyJAVAParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(MyJAVAParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MyJAVAParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(MyJAVAParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(MyJAVAParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(MyJAVAParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(MyJAVAParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#enumConstants}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstants(MyJAVAParser.EnumConstantsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(MyJAVAParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(MyJAVAParser.EnumBodyDeclarationsContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericMethodDeclaration(MyJAVAParser.GenericMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(MyJAVAParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericConstructorDeclaration(MyJAVAParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(MyJAVAParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBodyDeclaration(MyJAVAParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(MyJAVAParser.InterfaceMemberDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(MyJAVAParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericInterfaceMethodDeclaration(MyJAVAParser.GenericInterfaceMethodDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(MyJAVAParser.EnumConstantNameContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(MyJAVAParser.ConstructorBodyContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(MyJAVAParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationName(MyJAVAParser.AnnotationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#elementValuePairs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairs(MyJAVAParser.ElementValuePairsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(MyJAVAParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(MyJAVAParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(MyJAVAParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(MyJAVAParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(MyJAVAParser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(MyJAVAParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementRest(MyJAVAParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodOrConstantRest(MyJAVAParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodRest(MyJAVAParser.AnnotationMethodRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationConstantRest(MyJAVAParser.AnnotationConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(MyJAVAParser.DefaultValueContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#innerCreator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerCreator(MyJAVAParser.InnerCreatorContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocation(MyJAVAParser.ExplicitGenericInvocationContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArgumentsOrDiamond(MyJAVAParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#superSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperSuffix(MyJAVAParser.SuperSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocationSuffix(MyJAVAParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MyJAVAParser.ArgumentsContext ctx);
}