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
	 * Enter a parse tree produced by {@link MyJAVAParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(MyJAVAParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(MyJAVAParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(MyJAVAParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(MyJAVAParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(MyJAVAParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(MyJAVAParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#caseKeyword}.
	 * @param ctx the parse tree
	 */
	void enterCaseKeyword(MyJAVAParser.CaseKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#caseKeyword}.
	 * @param ctx the parse tree
	 */
	void exitCaseKeyword(MyJAVAParser.CaseKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constKeyword}.
	 * @param ctx the parse tree
	 */
	void enterConstKeyword(MyJAVAParser.ConstKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constKeyword}.
	 * @param ctx the parse tree
	 */
	void exitConstKeyword(MyJAVAParser.ConstKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#defaultKeyword}.
	 * @param ctx the parse tree
	 */
	void enterDefaultKeyword(MyJAVAParser.DefaultKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#defaultKeyword}.
	 * @param ctx the parse tree
	 */
	void exitDefaultKeyword(MyJAVAParser.DefaultKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#doKeyword}.
	 * @param ctx the parse tree
	 */
	void enterDoKeyword(MyJAVAParser.DoKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#doKeyword}.
	 * @param ctx the parse tree
	 */
	void exitDoKeyword(MyJAVAParser.DoKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#elseKeyword}.
	 * @param ctx the parse tree
	 */
	void enterElseKeyword(MyJAVAParser.ElseKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#elseKeyword}.
	 * @param ctx the parse tree
	 */
	void exitElseKeyword(MyJAVAParser.ElseKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#forKeyword}.
	 * @param ctx the parse tree
	 */
	void enterForKeyword(MyJAVAParser.ForKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#forKeyword}.
	 * @param ctx the parse tree
	 */
	void exitForKeyword(MyJAVAParser.ForKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#ifKeyword}.
	 * @param ctx the parse tree
	 */
	void enterIfKeyword(MyJAVAParser.IfKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#ifKeyword}.
	 * @param ctx the parse tree
	 */
	void exitIfKeyword(MyJAVAParser.IfKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#importKeyword}.
	 * @param ctx the parse tree
	 */
	void enterImportKeyword(MyJAVAParser.ImportKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#importKeyword}.
	 * @param ctx the parse tree
	 */
	void exitImportKeyword(MyJAVAParser.ImportKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#printKeyword}.
	 * @param ctx the parse tree
	 */
	void enterPrintKeyword(MyJAVAParser.PrintKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#printKeyword}.
	 * @param ctx the parse tree
	 */
	void exitPrintKeyword(MyJAVAParser.PrintKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#returnKeyword}.
	 * @param ctx the parse tree
	 */
	void enterReturnKeyword(MyJAVAParser.ReturnKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#returnKeyword}.
	 * @param ctx the parse tree
	 */
	void exitReturnKeyword(MyJAVAParser.ReturnKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#scanKeyword}.
	 * @param ctx the parse tree
	 */
	void enterScanKeyword(MyJAVAParser.ScanKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#scanKeyword}.
	 * @param ctx the parse tree
	 */
	void exitScanKeyword(MyJAVAParser.ScanKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#switchKeyword}.
	 * @param ctx the parse tree
	 */
	void enterSwitchKeyword(MyJAVAParser.SwitchKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#switchKeyword}.
	 * @param ctx the parse tree
	 */
	void exitSwitchKeyword(MyJAVAParser.SwitchKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#voidKeyword}.
	 * @param ctx the parse tree
	 */
	void enterVoidKeyword(MyJAVAParser.VoidKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#voidKeyword}.
	 * @param ctx the parse tree
	 */
	void exitVoidKeyword(MyJAVAParser.VoidKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#whileKeyword}.
	 * @param ctx the parse tree
	 */
	void enterWhileKeyword(MyJAVAParser.WhileKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#whileKeyword}.
	 * @param ctx the parse tree
	 */
	void exitWhileKeyword(MyJAVAParser.WhileKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(MyJAVAParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(MyJAVAParser.FilenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(MyJAVAParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(MyJAVAParser.ExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(MyJAVAParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(MyJAVAParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(MyJAVAParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(MyJAVAParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(MyJAVAParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(MyJAVAParser.ClassOrInterfaceModifierContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MyJAVAParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MyJAVAParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(MyJAVAParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(MyJAVAParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(MyJAVAParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(MyJAVAParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(MyJAVAParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(MyJAVAParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(MyJAVAParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(MyJAVAParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(MyJAVAParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(MyJAVAParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(MyJAVAParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(MyJAVAParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(MyJAVAParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(MyJAVAParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(MyJAVAParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(MyJAVAParser.InterfaceDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(MyJAVAParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(MyJAVAParser.InterfaceBodyContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(MyJAVAParser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(MyJAVAParser.GenericMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(MyJAVAParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(MyJAVAParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(MyJAVAParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(MyJAVAParser.GenericConstructorDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(MyJAVAParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(MyJAVAParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(MyJAVAParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(MyJAVAParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constDecList}.
	 * @param ctx the parse tree
	 */
	void enterConstDecList(MyJAVAParser.ConstDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constDecList}.
	 * @param ctx the parse tree
	 */
	void exitConstDecList(MyJAVAParser.ConstDecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constStatement}.
	 * @param ctx the parse tree
	 */
	void enterConstStatement(MyJAVAParser.ConstStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constStatement}.
	 * @param ctx the parse tree
	 */
	void exitConstStatement(MyJAVAParser.ConstStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constName}.
	 * @param ctx the parse tree
	 */
	void enterConstName(MyJAVAParser.ConstNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constName}.
	 * @param ctx the parse tree
	 */
	void exitConstName(MyJAVAParser.ConstNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#constValue}.
	 * @param ctx the parse tree
	 */
	void enterConstValue(MyJAVAParser.ConstValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constValue}.
	 * @param ctx the parse tree
	 */
	void exitConstValue(MyJAVAParser.ConstValueContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(MyJAVAParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(MyJAVAParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(MyJAVAParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(MyJAVAParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#varDecList}.
	 * @param ctx the parse tree
	 */
	void enterVarDecList(MyJAVAParser.VarDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#varDecList}.
	 * @param ctx the parse tree
	 */
	void exitVarDecList(MyJAVAParser.VarDecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(MyJAVAParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(MyJAVAParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#varNameList}.
	 * @param ctx the parse tree
	 */
	void enterVarNameList(MyJAVAParser.VarNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#varNameList}.
	 * @param ctx the parse tree
	 */
	void exitVarNameList(MyJAVAParser.VarNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(MyJAVAParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(MyJAVAParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(MyJAVAParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(MyJAVAParser.IndexContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(MyJAVAParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(MyJAVAParser.DataTypeContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#funcDecList}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecList(MyJAVAParser.FuncDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#funcDecList}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecList(MyJAVAParser.FuncDecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#funcDec}.
	 * @param ctx the parse tree
	 */
	void enterFuncDec(MyJAVAParser.FuncDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#funcDec}.
	 * @param ctx the parse tree
	 */
	void exitFuncDec(MyJAVAParser.FuncDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturn(MyJAVAParser.FunctionReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturn(MyJAVAParser.FunctionReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#functionVoid}.
	 * @param ctx the parse tree
	 */
	void enterFunctionVoid(MyJAVAParser.FunctionVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#functionVoid}.
	 * @param ctx the parse tree
	 */
	void exitFunctionVoid(MyJAVAParser.FunctionVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(MyJAVAParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(MyJAVAParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(MyJAVAParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(MyJAVAParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MyJAVAParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MyJAVAParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(MyJAVAParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(MyJAVAParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(MyJAVAParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(MyJAVAParser.MainFunctionContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(MyJAVAParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(MyJAVAParser.ConstructorBodyContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(MyJAVAParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(MyJAVAParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(MyJAVAParser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(MyJAVAParser.AnnotationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(MyJAVAParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(MyJAVAParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(MyJAVAParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(MyJAVAParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(MyJAVAParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(MyJAVAParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(MyJAVAParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(MyJAVAParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(MyJAVAParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(MyJAVAParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(MyJAVAParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(MyJAVAParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(MyJAVAParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(MyJAVAParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(MyJAVAParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(MyJAVAParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(MyJAVAParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(MyJAVAParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(MyJAVAParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(MyJAVAParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(MyJAVAParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(MyJAVAParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(MyJAVAParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(MyJAVAParser.DefaultValueContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(MyJAVAParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(MyJAVAParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#condStatement}.
	 * @param ctx the parse tree
	 */
	void enterCondStatement(MyJAVAParser.CondStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#condStatement}.
	 * @param ctx the parse tree
	 */
	void exitCondStatement(MyJAVAParser.CondStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(MyJAVAParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(MyJAVAParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MyJAVAParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MyJAVAParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MyJAVAParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MyJAVAParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(MyJAVAParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(MyJAVAParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterBoolStatement(MyJAVAParser.BoolStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitBoolStatement(MyJAVAParser.BoolStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#caseList}.
	 * @param ctx the parse tree
	 */
	void enterCaseList(MyJAVAParser.CaseListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#caseList}.
	 * @param ctx the parse tree
	 */
	void exitCaseList(MyJAVAParser.CaseListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#defaultStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStatement(MyJAVAParser.DefaultStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#defaultStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStatement(MyJAVAParser.DefaultStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#doWhileLoop}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileLoop(MyJAVAParser.DoWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#doWhileLoop}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileLoop(MyJAVAParser.DoWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(MyJAVAParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(MyJAVAParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(MyJAVAParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(MyJAVAParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(MyJAVAParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(MyJAVAParser.StatementListContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(MyJAVAParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(MyJAVAParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#numExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumExpression(MyJAVAParser.NumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#numExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumExpression(MyJAVAParser.NumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(MyJAVAParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(MyJAVAParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(MyJAVAParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(MyJAVAParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#boolLogical}.
	 * @param ctx the parse tree
	 */
	void enterBoolLogical(MyJAVAParser.BoolLogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#boolLogical}.
	 * @param ctx the parse tree
	 */
	void exitBoolLogical(MyJAVAParser.BoolLogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void enterBoolTerm(MyJAVAParser.BoolTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void exitBoolTerm(MyJAVAParser.BoolTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactor(MyJAVAParser.BoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactor(MyJAVAParser.BoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#boolIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterBoolIdentifier(MyJAVAParser.BoolIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#boolIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitBoolIdentifier(MyJAVAParser.BoolIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#numTerm}.
	 * @param ctx the parse tree
	 */
	void enterNumTerm(MyJAVAParser.NumTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#numTerm}.
	 * @param ctx the parse tree
	 */
	void exitNumTerm(MyJAVAParser.NumTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#numFactor}.
	 * @param ctx the parse tree
	 */
	void enterNumFactor(MyJAVAParser.NumFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#numFactor}.
	 * @param ctx the parse tree
	 */
	void exitNumFactor(MyJAVAParser.NumFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#numIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterNumIdentifier(MyJAVAParser.NumIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#numIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitNumIdentifier(MyJAVAParser.NumIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#stringIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterStringIdentifier(MyJAVAParser.StringIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#stringIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitStringIdentifier(MyJAVAParser.StringIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#charValue}.
	 * @param ctx the parse tree
	 */
	void enterCharValue(MyJAVAParser.CharValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#charValue}.
	 * @param ctx the parse tree
	 */
	void exitCharValue(MyJAVAParser.CharValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#asciiChar}.
	 * @param ctx the parse tree
	 */
	void enterAsciiChar(MyJAVAParser.AsciiCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#asciiChar}.
	 * @param ctx the parse tree
	 */
	void exitAsciiChar(MyJAVAParser.AsciiCharContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(MyJAVAParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(MyJAVAParser.InnerCreatorContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(MyJAVAParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(MyJAVAParser.ExplicitGenericInvocationContext ctx);
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
	 * Enter a parse tree produced by {@link MyJAVAParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(MyJAVAParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(MyJAVAParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(MyJAVAParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(MyJAVAParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyJAVAParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(MyJAVAParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyJAVAParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(MyJAVAParser.ExplicitGenericInvocationSuffixContext ctx);
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
}