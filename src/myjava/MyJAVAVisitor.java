// Generated from /Users/jasonsapdos/Documents/workspace/myJAVA/src/MyJAVA.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link MyJAVAParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(MyJAVAParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(MyJAVAParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#caseKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseKeyword(MyJAVAParser.CaseKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstKeyword(MyJAVAParser.ConstKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#defaultKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultKeyword(MyJAVAParser.DefaultKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#doKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoKeyword(MyJAVAParser.DoKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#elseKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseKeyword(MyJAVAParser.ElseKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#forKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForKeyword(MyJAVAParser.ForKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#ifKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfKeyword(MyJAVAParser.IfKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#importKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportKeyword(MyJAVAParser.ImportKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#printKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintKeyword(MyJAVAParser.PrintKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#returnKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnKeyword(MyJAVAParser.ReturnKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#scanKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanKeyword(MyJAVAParser.ScanKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#switchKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchKeyword(MyJAVAParser.SwitchKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#voidKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidKeyword(MyJAVAParser.VoidKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#whileKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileKeyword(MyJAVAParser.WhileKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#filename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilename(MyJAVAParser.FilenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(MyJAVAParser.ExtensionContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(MyJAVAParser.InterfaceDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(MyJAVAParser.InterfaceBodyContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#constDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecList(MyJAVAParser.ConstDecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstStatement(MyJAVAParser.ConstStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstName(MyJAVAParser.ConstNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstValue(MyJAVAParser.ConstValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(MyJAVAParser.ConstDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#varDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecList(MyJAVAParser.VarDecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(MyJAVAParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#varNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarNameList(MyJAVAParser.VarNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(MyJAVAParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(MyJAVAParser.IndexContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(MyJAVAParser.DataTypeContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#funcDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecList(MyJAVAParser.FuncDecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#funcDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDec(MyJAVAParser.FuncDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#functionReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturn(MyJAVAParser.FunctionReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#functionVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionVoid(MyJAVAParser.FunctionVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(MyJAVAParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(MyJAVAParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MyJAVAParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(MyJAVAParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#mainFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunction(MyJAVAParser.MainFunctionContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(MyJAVAParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#condStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondStatement(MyJAVAParser.CondStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(MyJAVAParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MyJAVAParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MyJAVAParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(MyJAVAParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolStatement(MyJAVAParser.BoolStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#caseList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseList(MyJAVAParser.CaseListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#defaultStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStatement(MyJAVAParser.DefaultStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#doWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileLoop(MyJAVAParser.DoWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(MyJAVAParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(MyJAVAParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(MyJAVAParser.StatementListContext ctx);
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
	 * Visit a parse tree produced by {@link MyJAVAParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MyJAVAParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#stringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(MyJAVAParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#numExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpression(MyJAVAParser.NumExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#boolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(MyJAVAParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(MyJAVAParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#boolLogical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLogical(MyJAVAParser.BoolLogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#boolTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTerm(MyJAVAParser.BoolTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFactor(MyJAVAParser.BoolFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#boolIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolIdentifier(MyJAVAParser.BoolIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#numTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumTerm(MyJAVAParser.NumTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#numFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumFactor(MyJAVAParser.NumFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#numIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumIdentifier(MyJAVAParser.NumIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#stringIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringIdentifier(MyJAVAParser.StringIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#charValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharValue(MyJAVAParser.CharValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyJAVAParser#asciiChar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsciiChar(MyJAVAParser.AsciiCharContext ctx);
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