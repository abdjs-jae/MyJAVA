// Generated from C:/Users/Nikolai/Desktop/MyJAVA-master/src\MyJAVA.g4 by ANTLR 4.7
package myjava.antlrgen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyJAVAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, BOOLEAN=34, BREAK=35, BYTE=36, CASE=37, CATCH=38, 
		CHAR=39, CLASS=40, CONST=41, CONTINUE=42, DEFAULT=43, DO=44, DOUBLE=45, 
		ELSE=46, EXTENDS=47, FINAL=48, FINALLY=49, FLOAT=50, FOR=51, IF=52, INSTANCEOF=53, 
		INT=54, LONG=55, NEW=56, PACKAGE=57, PRINT=58, PRIVATE=59, PROTECTED=60, 
		PUBLIC=61, RETURN=62, SCAN=63, SHORT=64, STATIC=65, SUPER=66, SWITCH=67, 
		THIS=68, THROW=69, THROWS=70, TRY=71, VOID=72, WHILE=73, IntegerLiteral=74, 
		FloatingPointLiteral=75, BooleanLiteral=76, CharacterLiteral=77, StringLiteral=78, 
		NullLiteral=79, LPAREN=80, RPAREN=81, LBRACE=82, RBRACE=83, LBRACK=84, 
		RBRACK=85, SEMI=86, COMMA=87, DOT=88, ASSIGN=89, GT=90, LT=91, BANG=92, 
		TILDE=93, QUESTION=94, COLON=95, EQUAL=96, LE=97, GE=98, NOTEQUAL=99, 
		AND=100, OR=101, INC=102, DEC=103, ADD=104, SUB=105, MUL=106, DIV=107, 
		BITAND=108, BITOR=109, CARET=110, MOD=111, ADD_ASSIGN=112, SUB_ASSIGN=113, 
		MUL_ASSIGN=114, DIV_ASSIGN=115, AND_ASSIGN=116, OR_ASSIGN=117, XOR_ASSIGN=118, 
		MOD_ASSIGN=119, LSHIFT_ASSIGN=120, RSHIFT_ASSIGN=121, URSHIFT_ASSIGN=122, 
		Identifier=123, AT=124, ELLIPSIS=125, WS=126, COMMENT=127, LINE_COMMENT=128;
	public static final int
		RULE_compilationUnit = 0, RULE_variableModifier = 1, RULE_classOrInterfaceModifier = 2, 
		RULE_typeParameters = 3, RULE_classDeclaration = 4, RULE_typeList = 5, 
		RULE_classBody = 6, RULE_classBodyDeclaration = 7, RULE_memberDeclaration = 8, 
		RULE_methodDeclaration = 9, RULE_mainDeclaration = 10, RULE_fieldDeclaration = 11, 
		RULE_constDeclaration = 12, RULE_constantDeclarator = 13, RULE_variableDeclarators = 14, 
		RULE_variableDeclarator = 15, RULE_variableDeclaratorId = 16, RULE_variableInitializer = 17, 
		RULE_arrayInitializer = 18, RULE_typeType = 19, RULE_classOrInterfaceType = 20, 
		RULE_primitiveType = 21, RULE_typeArguments = 22, RULE_typeArgument = 23, 
		RULE_qualifiedNameList = 24, RULE_formalParameters = 25, RULE_formalParameterList = 26, 
		RULE_formalParameter = 27, RULE_lastFormalParameter = 28, RULE_methodBody = 29, 
		RULE_qualifiedName = 30, RULE_literal = 31, RULE_block = 32, RULE_blockStatement = 33, 
		RULE_localVariableDeclarationStatement = 34, RULE_localVariableDeclaration = 35, 
		RULE_statement = 36, RULE_catchClause = 37, RULE_catchType = 38, RULE_finallyBlock = 39, 
		RULE_resourceSpecification = 40, RULE_resources = 41, RULE_resource = 42, 
		RULE_switchBlockStatementGroup = 43, RULE_switchLabel = 44, RULE_forControl = 45, 
		RULE_forInit = 46, RULE_enhancedForControl = 47, RULE_forUpdate = 48, 
		RULE_parExpression = 49, RULE_expressionList = 50, RULE_statementExpression = 51, 
		RULE_constantExpression = 52, RULE_expression = 53, RULE_primary = 54, 
		RULE_creator = 55, RULE_createdName = 56, RULE_arrayCreatorRest = 57, 
		RULE_classCreatorRest = 58, RULE_nonWildcardTypeArguments = 59, RULE_typeArgumentsOrDiamond = 60, 
		RULE_arguments = 61, RULE_printStatement = 62, RULE_scanStatement = 63;
	public static final String[] ruleNames = {
		"compilationUnit", "variableModifier", "classOrInterfaceModifier", "typeParameters", 
		"classDeclaration", "typeList", "classBody", "classBodyDeclaration", "memberDeclaration", 
		"methodDeclaration", "mainDeclaration", "fieldDeclaration", "constDeclaration", 
		"constantDeclarator", "variableDeclarators", "variableDeclarator", "variableDeclaratorId", 
		"variableInitializer", "arrayInitializer", "typeType", "classOrInterfaceType", 
		"primitiveType", "typeArguments", "typeArgument", "qualifiedNameList", 
		"formalParameters", "formalParameterList", "formalParameter", "lastFormalParameter", 
		"methodBody", "qualifiedName", "literal", "block", "blockStatement", "localVariableDeclarationStatement", 
		"localVariableDeclaration", "statement", "catchClause", "catchType", "finallyBlock", 
		"resourceSpecification", "resources", "resource", "switchBlockStatementGroup", 
		"switchLabel", "forControl", "forInit", "enhancedForControl", "forUpdate", 
		"parExpression", "expressionList", "statementExpression", "constantExpression", 
		"expression", "primary", "creator", "createdName", "arrayCreatorRest", 
		"classCreatorRest", "nonWildcardTypeArguments", "typeArgumentsOrDiamond", 
		"arguments", "printStatement", "scanStatement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'abstract'", "'main'", "'String'", "'BOOLEAN'", "'CHAR'", "'BYTE'", 
		"'SHORT'", "'INT'", "'LONG'", "'FLOAT'", "'DOUBLE'", "'STRING'", "'null'", 
		"'ELSE'", "'IF'", "'FOR'", "'WHILE'", "'DO'", "'TRY'", "'SWITCH'", "'RETURN'", 
		"'THROW'", "'BREAK'", "'CONTINUE'", "'CATCH'", "'FINALLY'", "'CASE'", 
		"'DEFAULT'", "'NEW'", "'CLASS'", "'VOID'", "'PRINT'", "'SCAN'", "'boolean'", 
		"'break'", "'byte'", "'case'", "'catch'", "'char'", "'class'", "'const'", 
		"'continue'", "'default'", "'do'", "'double'", "'else'", "'extends'", 
		"'final'", "'finally'", "'float'", "'for'", "'if'", "'instanceof'", "'int'", 
		"'long'", "'new'", "'package'", "'print'", "'private'", "'protected'", 
		"'public'", "'return'", "'scan'", "'short'", "'static'", "'super'", "'switch'", 
		"'this'", "'throw'", "'throws'", "'try'", "'void'", "'while'", null, null, 
		null, null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
		"','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", 
		"'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", 
		"'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", 
		"'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", 
		"'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "BOOLEAN", 
		"BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", 
		"DEFAULT", "DO", "DOUBLE", "ELSE", "EXTENDS", "FINAL", "FINALLY", "FLOAT", 
		"FOR", "IF", "INSTANCEOF", "INT", "LONG", "NEW", "PACKAGE", "PRINT", "PRIVATE", 
		"PROTECTED", "PUBLIC", "RETURN", "SCAN", "SHORT", "STATIC", "SUPER", "SWITCH", 
		"THIS", "THROW", "THROWS", "TRY", "VOID", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
		"DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
		"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", 
		"LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", "AT", 
		"ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MyJAVA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyJAVAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MyJAVAParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public List<MemberDeclarationContext> memberDeclaration() {
			return getRuleContexts(MemberDeclarationContext.class);
		}
		public MemberDeclarationContext memberDeclaration(int i) {
			return getRuleContext(MemberDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					classDeclaration();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (STATIC - 64)) | (1L << (VOID - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(134);
				memberDeclaration();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitVariableModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitVariableModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variableModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(FINAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceModifierContext extends ParserRuleContext {
		public ClassOrInterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterClassOrInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitClassOrInterfaceModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitClassOrInterfaceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classOrInterfaceModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0) || _la==STATIC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MyJAVAParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MyJAVAParser.Identifier, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(LT);
			setState(147);
			match(Identifier);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(148);
				match(COMMA);
				setState(149);
				match(Identifier);
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier() {
			return getRuleContext(ClassOrInterfaceModifierContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0) || _la==STATIC) {
				{
				setState(157);
				classOrInterfaceModifier();
				}
			}

			setState(160);
			match(CLASS);
			setState(161);
			match(Identifier);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(162);
				typeParameters();
				}
			}

			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(165);
				match(EXTENDS);
				setState(166);
				typeType();
				}
			}

			setState(169);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeListContext extends ParserRuleContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			typeType();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(172);
				match(COMMA);
				setState(173);
				typeType();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(LBRACE);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (STATIC - 64)) | (1L << (VOID - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(180);
				classBodyDeclaration();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classBodyDeclaration);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(189);
					match(STATIC);
					}
				}

				setState(192);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				memberDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public MainDeclarationContext mainDeclaration() {
			return getRuleContext(MainDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_memberDeclaration);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				mainDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				fieldDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				classDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(202);
				typeType();
				}
				break;
			case VOID:
				{
				setState(203);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(206);
			match(Identifier);
			setState(207);
			formalParameters();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(208);
				match(LBRACK);
				setState(209);
				match(RBRACK);
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(215);
				match(THROWS);
				setState(216);
				qualifiedNameList();
				}
			}

			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(219);
				methodBody();
				}
				break;
			case SEMI:
				{
				setState(220);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainDeclarationContext extends ParserRuleContext {
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MainDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterMainDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitMainDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitMainDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDeclarationContext mainDeclaration() throws RecognitionException {
		MainDeclarationContext _localctx = new MainDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mainDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(VOID);
			setState(224);
			match(T__1);
			setState(225);
			formalParameters();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(226);
				match(LBRACK);
				setState(227);
				match(RBRACK);
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(233);
				match(THROWS);
				setState(234);
				qualifiedNameList();
				}
			}

			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(237);
				methodBody();
				}
				break;
			case SEMI:
				{
				setState(238);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			typeType();
			setState(242);
			variableDeclarators();
			setState(243);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitConstDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			typeType();
			setState(246);
			constantDeclarator();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(247);
				match(COMMA);
				setState(248);
				constantDeclarator();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitConstantDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitConstantDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constantDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(Identifier);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(257);
				match(LBRACK);
				setState(258);
				match(RBRACK);
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			match(ASSIGN);
			setState(265);
			variableInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitVariableDeclarators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitVariableDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			variableDeclarator();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(268);
				match(COMMA);
				setState(269);
				variableDeclarator();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			variableDeclaratorId();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(276);
				match(ASSIGN);
				setState(277);
				variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public List<TerminalNode> IntegerLiteral() { return getTokens(MyJAVAParser.IntegerLiteral); }
		public TerminalNode IntegerLiteral(int i) {
			return getToken(MyJAVAParser.IntegerLiteral, i);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variableDeclaratorId);
		int _la;
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(Identifier);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(281);
					match(LBRACK);
					setState(282);
					match(RBRACK);
					}
					}
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(Identifier);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(289);
					match(LBRACK);
					setState(290);
					match(IntegerLiteral);
					setState(291);
					match(RBRACK);
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableInitializer);
		try {
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				arrayInitializer();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__28:
			case T__30:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(LBRACE);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(304);
				variableInitializer();
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(305);
						match(COMMA);
						setState(306);
						variableInitializer();
						}
						} 
					}
					setState(311);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(312);
					match(COMMA);
					}
				}

				}
			}

			setState(317);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeType);
		try {
			int _alt;
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				classOrInterfaceType();
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(320);
						match(LBRACK);
						setState(321);
						match(RBRACK);
						}
						} 
					}
					setState(326);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				primitiveType();
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(328);
						match(LBRACK);
						setState(329);
						match(RBRACK);
						}
						} 
					}
					setState(334);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MyJAVAParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MyJAVAParser.Identifier, i);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(Identifier);
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(338);
				typeArguments();
				}
				break;
			}
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(341);
					match(DOT);
					setState(342);
					match(Identifier);
					setState(344);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(343);
						typeArguments();
						}
						break;
					}
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !(((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & ((1L << (T__2 - 3)) | (1L << (T__3 - 3)) | (1L << (T__4 - 3)) | (1L << (T__5 - 3)) | (1L << (T__6 - 3)) | (1L << (T__7 - 3)) | (1L << (T__8 - 3)) | (1L << (T__9 - 3)) | (1L << (T__10 - 3)) | (1L << (T__11 - 3)) | (1L << (BOOLEAN - 3)) | (1L << (BYTE - 3)) | (1L << (CHAR - 3)) | (1L << (DOUBLE - 3)) | (1L << (FLOAT - 3)) | (1L << (INT - 3)) | (1L << (LONG - 3)) | (1L << (SHORT - 3)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(LT);
			setState(354);
			typeArgument();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(355);
				match(COMMA);
				setState(356);
				typeArgument();
				}
				}
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(362);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeArgument);
		int _la;
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				typeType();
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(QUESTION);
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(366);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(367);
					typeType();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameListContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitQualifiedNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitQualifiedNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			qualifiedName();
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(373);
				match(COMMA);
				setState(374);
				qualifiedName();
				}
				}
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(LPAREN);
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG))) != 0) || _la==SHORT || _la==Identifier) {
				{
				setState(381);
				formalParameterList();
				}
			}

			setState(384);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				formalParameter();
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(387);
						match(COMMA);
						setState(388);
						formalParameter();
						}
						} 
					}
					setState(393);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(394);
					match(COMMA);
					setState(395);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL) {
				{
				{
				setState(401);
				variableModifier();
				}
				}
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(407);
			typeType();
			setState(408);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LastFormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitLastFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitLastFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_lastFormalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL) {
				{
				{
				setState(410);
				variableModifier();
				}
				}
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(416);
			typeType();
			setState(417);
			match(ELLIPSIS);
			setState(418);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MyJAVAParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MyJAVAParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(Identifier);
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(423);
				match(DOT);
				setState(424);
				match(Identifier);
				}
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(MyJAVAParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(MyJAVAParser.FloatingPointLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(MyJAVAParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(MyJAVAParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(MyJAVAParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if ( !(_la==T__12 || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (IntegerLiteral - 74)) | (1L << (FloatingPointLiteral - 74)) | (1L << (BooleanLiteral - 74)) | (1L << (CharacterLiteral - 74)) | (1L << (StringLiteral - 74)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(LBRACE);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRINT) | (1L << RETURN) | (1L << SCAN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (SWITCH - 64)) | (1L << (THROW - 64)) | (1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(433);
				blockStatement();
				}
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(439);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_blockStatement);
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			localVariableDeclaration();
			setState(446);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL) {
				{
				{
				setState(448);
				variableModifier();
				}
				}
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(454);
			typeType();
			setState(455);
			variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ScanStatementContext scanStatement() {
			return getRuleContext(ScanStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				match(IF);
				setState(459);
				parExpression();
				setState(460);
				statement();
				setState(463);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(461);
					match(ELSE);
					setState(462);
					statement();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(465);
				match(IF);
				setState(466);
				parExpression();
				setState(467);
				statement();
				setState(470);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(468);
					match(T__13);
					setState(469);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(472);
				match(T__14);
				setState(473);
				parExpression();
				setState(474);
				statement();
				setState(477);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(475);
					match(ELSE);
					setState(476);
					statement();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(479);
				match(T__14);
				setState(480);
				parExpression();
				setState(481);
				statement();
				setState(484);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(482);
					match(T__13);
					setState(483);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(486);
				match(FOR);
				setState(487);
				match(LPAREN);
				setState(488);
				forControl();
				setState(489);
				match(RPAREN);
				setState(490);
				statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(492);
				match(T__15);
				setState(493);
				match(LPAREN);
				setState(494);
				forControl();
				setState(495);
				match(RPAREN);
				setState(496);
				statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(498);
				match(WHILE);
				setState(499);
				parExpression();
				setState(500);
				statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(502);
				match(T__16);
				setState(503);
				parExpression();
				setState(504);
				statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(506);
				match(DO);
				setState(507);
				statement();
				setState(508);
				match(WHILE);
				setState(509);
				parExpression();
				setState(510);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(512);
				match(DO);
				setState(513);
				statement();
				setState(514);
				match(T__16);
				setState(515);
				parExpression();
				setState(516);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(518);
				match(T__17);
				setState(519);
				statement();
				setState(520);
				match(WHILE);
				setState(521);
				parExpression();
				setState(522);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(524);
				match(T__17);
				setState(525);
				statement();
				setState(526);
				match(T__16);
				setState(527);
				parExpression();
				setState(528);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(530);
				match(TRY);
				setState(531);
				block();
				setState(541);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__24:
				case CATCH:
					{
					setState(533); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(532);
						catchClause();
						}
						}
						setState(535); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__24 || _la==CATCH );
					setState(538);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__25 || _la==FINALLY) {
						{
						setState(537);
						finallyBlock();
						}
					}

					}
					break;
				case T__25:
				case FINALLY:
					{
					setState(540);
					finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(543);
				match(TRY);
				setState(544);
				resourceSpecification();
				setState(545);
				block();
				setState(549);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24 || _la==CATCH) {
					{
					{
					setState(546);
					catchClause();
					}
					}
					setState(551);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==FINALLY) {
					{
					setState(552);
					finallyBlock();
					}
				}

				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(555);
				match(T__18);
				setState(556);
				block();
				setState(566);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__24:
				case CATCH:
					{
					setState(558); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(557);
						catchClause();
						}
						}
						setState(560); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__24 || _la==CATCH );
					setState(563);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__25 || _la==FINALLY) {
						{
						setState(562);
						finallyBlock();
						}
					}

					}
					break;
				case T__25:
				case FINALLY:
					{
					setState(565);
					finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(568);
				match(T__18);
				setState(569);
				resourceSpecification();
				setState(570);
				block();
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24 || _la==CATCH) {
					{
					{
					setState(571);
					catchClause();
					}
					}
					setState(576);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25 || _la==FINALLY) {
					{
					setState(577);
					finallyBlock();
					}
				}

				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(580);
				match(SWITCH);
				setState(581);
				parExpression();
				setState(582);
				match(LBRACE);
				setState(586);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(583);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(588);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				}
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << CASE) | (1L << DEFAULT))) != 0)) {
					{
					{
					setState(589);
					switchLabel();
					}
					}
					setState(594);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(595);
				match(RBRACE);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(597);
				match(T__19);
				setState(598);
				parExpression();
				setState(599);
				match(LBRACE);
				setState(603);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(600);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(605);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				}
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << CASE) | (1L << DEFAULT))) != 0)) {
					{
					{
					setState(606);
					switchLabel();
					}
					}
					setState(611);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(612);
				match(RBRACE);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(614);
				match(RETURN);
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(615);
					expression(0);
					}
				}

				setState(618);
				match(SEMI);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(619);
				match(T__20);
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(620);
					expression(0);
					}
				}

				setState(623);
				match(SEMI);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(624);
				match(THROW);
				setState(625);
				expression(0);
				setState(626);
				match(SEMI);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(628);
				match(T__21);
				setState(629);
				expression(0);
				setState(630);
				match(SEMI);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(632);
				match(BREAK);
				setState(634);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(633);
					match(Identifier);
					}
				}

				setState(636);
				match(SEMI);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(637);
				match(T__22);
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(638);
					match(Identifier);
					}
				}

				setState(641);
				match(SEMI);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(642);
				match(CONTINUE);
				setState(644);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(643);
					match(Identifier);
					}
				}

				setState(646);
				match(SEMI);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(647);
				match(T__23);
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(648);
					match(Identifier);
					}
				}

				setState(651);
				match(SEMI);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(652);
				match(SEMI);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(653);
				statementExpression();
				setState(654);
				match(SEMI);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(656);
				match(Identifier);
				setState(657);
				match(COLON);
				setState(658);
				statement();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(659);
				printStatement();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(660);
				scanStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchClauseContext extends ParserRuleContext {
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_catchClause);
		int _la;
		try {
			setState(689);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CATCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(663);
				match(CATCH);
				setState(664);
				match(LPAREN);
				setState(668);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FINAL) {
					{
					{
					setState(665);
					variableModifier();
					}
					}
					setState(670);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(671);
				catchType();
				setState(672);
				match(Identifier);
				setState(673);
				match(RPAREN);
				setState(674);
				block();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				match(T__24);
				setState(677);
				match(LPAREN);
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FINAL) {
					{
					{
					setState(678);
					variableModifier();
					}
					}
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(684);
				catchType();
				setState(685);
				match(Identifier);
				setState(686);
				match(RPAREN);
				setState(687);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchTypeContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitCatchType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitCatchType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			qualifiedName();
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(692);
				match(BITOR);
				setState(693);
				qualifiedName();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinallyBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterFinallyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitFinallyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitFinallyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_finallyBlock);
		try {
			setState(703);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINALLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(699);
				match(FINALLY);
				setState(700);
				block();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(701);
				match(T__25);
				setState(702);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceSpecificationContext extends ParserRuleContext {
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitResourceSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitResourceSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			match(LPAREN);
			setState(706);
			resources();
			setState(708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(707);
				match(SEMI);
				}
			}

			setState(710);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourcesContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterResources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitResources(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitResources(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_resources);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			resource();
			setState(717);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(713);
					match(SEMI);
					setState(714);
					resource();
					}
					} 
				}
				setState(719);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL) {
				{
				{
				setState(720);
				variableModifier();
				}
				}
				setState(725);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(726);
			classOrInterfaceType();
			setState(727);
			variableDeclaratorId();
			setState(728);
			match(ASSIGN);
			setState(729);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(731);
				switchLabel();
				}
				}
				setState(734); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << CASE) | (1L << DEFAULT))) != 0) );
			setState(737); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(736);
				blockStatement();
				}
				}
				setState(739); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << PRINT) | (1L << RETURN) | (1L << SCAN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (SWITCH - 64)) | (1L << (THROW - 64)) | (1L << (TRY - 64)) | (1L << (VOID - 64)) | (1L << (WHILE - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitSwitchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_switchLabel);
		try {
			setState(753);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(741);
				match(CASE);
				setState(742);
				constantExpression();
				setState(743);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(745);
				match(DEFAULT);
				setState(746);
				match(COLON);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(747);
				match(T__26);
				setState(748);
				constantExpression();
				setState(749);
				match(COLON);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 4);
				{
				setState(751);
				match(T__27);
				setState(752);
				match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForControlContext extends ParserRuleContext {
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_forControl);
		int _la;
		try {
			setState(767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(755);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(756);
					forInit();
					}
				}

				setState(759);
				match(SEMI);
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(760);
					expression(0);
					}
				}

				setState(763);
				match(SEMI);
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(764);
					forUpdate();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_forInit);
		try {
			setState(775);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(769);
				primitiveType();
				setState(770);
				variableDeclaratorId();
				   notifyErrorListeners("Counter variable needs to be initialized.");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(773);
				localVariableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(774);
				expressionList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForControlContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitEnhancedForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitEnhancedForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_enhancedForControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL) {
				{
				{
				setState(777);
				variableModifier();
				}
				}
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(783);
			typeType();
			setState(784);
			variableDeclaratorId();
			setState(785);
			match(COLON);
			setState(786);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MyJAVAParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MyJAVAParser.Identifier, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parExpression);
		int _la;
		try {
			setState(810);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(790);
				match(LPAREN);
				setState(791);
				match(Identifier);
				setState(792);
				match(ASSIGN);
				setState(793);
				expression(0);
				setState(794);
				match(RPAREN);
				notifyErrorListeners("Assignment of variable is not allowed.");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(797);
				match(LPAREN);
				setState(798);
				match(Identifier);
				setState(800); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(799);
					match(Identifier);
					}
					}
					setState(802); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
				setState(804);
				match(RPAREN);
				notifyErrorListeners("Too many parameters in one function.");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(806);
				match(LPAREN);
				setState(807);
				expression(0);
				setState(808);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
			expression(0);
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(813);
				match(COMMA);
				setState(814);
				expression(0);
				}
				}
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitConstantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 106;
		enterRecursionRule(_localctx, 106, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(825);
				primary();
				}
				break;
			case 2:
				{
				setState(826);
				match(NEW);
				setState(827);
				creator();
				}
				break;
			case 3:
				{
				setState(828);
				match(T__28);
				setState(829);
				creator();
				}
				break;
			case 4:
				{
				setState(830);
				match(LPAREN);
				setState(831);
				typeType();
				setState(832);
				match(RPAREN);
				setState(833);
				expression(17);
				}
				break;
			case 5:
				{
				setState(835);
				_la = _input.LA(1);
				if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (INC - 102)) | (1L << (DEC - 102)) | (1L << (ADD - 102)) | (1L << (SUB - 102)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(836);
				expression(15);
				}
				break;
			case 6:
				{
				setState(837);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(838);
				expression(14);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(911);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(909);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(841);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(842);
						_la = _input.LA(1);
						if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (MUL - 106)) | (1L << (DIV - 106)) | (1L << (MOD - 106)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(843);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(844);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(845);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(846);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(847);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(855);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
						case 1:
							{
							setState(848);
							match(LT);
							setState(849);
							match(LT);
							}
							break;
						case 2:
							{
							setState(850);
							match(GT);
							setState(851);
							match(GT);
							setState(852);
							match(GT);
							}
							break;
						case 3:
							{
							setState(853);
							match(GT);
							setState(854);
							match(GT);
							}
							break;
						}
						setState(857);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(858);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(859);
						_la = _input.LA(1);
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (GT - 90)) | (1L << (LT - 90)) | (1L << (LE - 90)) | (1L << (GE - 90)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(860);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(861);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(862);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(863);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(864);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(865);
						match(BITAND);
						setState(866);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(867);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(868);
						match(CARET);
						setState(869);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(870);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(871);
						match(BITOR);
						setState(872);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(873);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(874);
						match(AND);
						setState(875);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(876);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(877);
						match(OR);
						setState(878);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(879);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(880);
						match(QUESTION);
						setState(881);
						expression(0);
						setState(882);
						match(COLON);
						setState(883);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(885);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(886);
						_la = _input.LA(1);
						if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (ASSIGN - 89)) | (1L << (ADD_ASSIGN - 89)) | (1L << (SUB_ASSIGN - 89)) | (1L << (MUL_ASSIGN - 89)) | (1L << (DIV_ASSIGN - 89)) | (1L << (AND_ASSIGN - 89)) | (1L << (OR_ASSIGN - 89)) | (1L << (XOR_ASSIGN - 89)) | (1L << (MOD_ASSIGN - 89)) | (1L << (LSHIFT_ASSIGN - 89)) | (1L << (RSHIFT_ASSIGN - 89)) | (1L << (URSHIFT_ASSIGN - 89)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(887);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(888);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(889);
						match(DOT);
						setState(890);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(891);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(892);
						match(LBRACK);
						setState(893);
						expression(0);
						setState(894);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(896);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(897);
						arguments();
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(898);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(899);
						match(LPAREN);
						setState(901);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
							{
							setState(900);
							expressionList();
							}
						}

						setState(903);
						match(RPAREN);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(904);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(905);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(906);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(907);
						match(INSTANCEOF);
						setState(908);
						typeType();
						}
						break;
					}
					} 
				}
				setState(913);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MyJAVAParser.Identifier, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_primary);
		try {
			setState(940);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(914);
				match(LPAREN);
				setState(915);
				expression(0);
				setState(916);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(918);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(919);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(920);
				typeType();
				setState(921);
				match(DOT);
				setState(922);
				match(CLASS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(924);
				typeType();
				setState(925);
				match(DOT);
				setState(926);
				match(T__29);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(928);
				match(VOID);
				setState(929);
				match(DOT);
				setState(930);
				match(CLASS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(931);
				match(VOID);
				setState(932);
				match(DOT);
				setState(933);
				match(T__29);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(934);
				match(T__30);
				setState(935);
				match(DOT);
				setState(936);
				match(CLASS);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(937);
				match(T__30);
				setState(938);
				match(DOT);
				setState(939);
				match(T__29);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_creator);
		try {
			setState(951);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(942);
				nonWildcardTypeArguments();
				setState(943);
				createdName();
				setState(944);
				classCreatorRest();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(946);
				createdName();
				setState(949);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(947);
					arrayCreatorRest();
					}
					break;
				case LPAREN:
					{
					setState(948);
					classCreatorRest();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MyJAVAParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MyJAVAParser.Identifier, i);
		}
		public List<TypeArgumentsOrDiamondContext> typeArgumentsOrDiamond() {
			return getRuleContexts(TypeArgumentsOrDiamondContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond(int i) {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitCreatedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitCreatedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_createdName);
		int _la;
		try {
			setState(968);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(953);
				match(Identifier);
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(954);
					typeArgumentsOrDiamond();
					}
				}

				setState(964);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(957);
					match(DOT);
					setState(958);
					match(Identifier);
					setState(960);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(959);
						typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(966);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(967);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitArrayCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitArrayCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			match(LBRACK);
			setState(998);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RBRACK:
				{
				setState(971);
				match(RBRACK);
				setState(976);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(972);
					match(LBRACK);
					setState(973);
					match(RBRACK);
					}
					}
					setState(978);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(979);
				arrayInitializer();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__28:
			case T__30:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				{
				setState(980);
				expression(0);
				setState(981);
				match(RBRACK);
				setState(988);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(982);
						match(LBRACK);
						setState(983);
						expression(0);
						setState(984);
						match(RBRACK);
						}
						} 
					}
					setState(990);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				setState(995);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(991);
						match(LBRACK);
						setState(992);
						match(RBRACK);
						}
						} 
					}
					setState(997);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitClassCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitClassCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1000);
			arguments();
			setState(1002);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(1001);
				classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext {
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitNonWildcardTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitNonWildcardTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			match(LT);
			setState(1005);
			typeList();
			setState(1006);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitTypeArgumentsOrDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitTypeArgumentsOrDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_typeArgumentsOrDiamond);
		try {
			setState(1011);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1008);
				match(LT);
				setState(1009);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1010);
				typeArguments();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013);
			match(LPAREN);
			setState(1015);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__28) | (1L << T__30) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SHORT - 64)) | (1L << (VOID - 64)) | (1L << (IntegerLiteral - 64)) | (1L << (FloatingPointLiteral - 64)) | (1L << (BooleanLiteral - 64)) | (1L << (CharacterLiteral - 64)) | (1L << (StringLiteral - 64)) | (1L << (LPAREN - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(1014);
				expressionList();
				}
			}

			setState(1017);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_printStatement);
		try {
			setState(1027);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1019);
				match(PRINT);
				setState(1020);
				parExpression();
				setState(1021);
				match(SEMI);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(1023);
				match(T__31);
				setState(1024);
				parExpression();
				setState(1025);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScanStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ScanStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).enterScanStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyJAVAListener ) ((MyJAVAListener)listener).exitScanStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyJAVAVisitor ) return ((MyJAVAVisitor<? extends T>)visitor).visitScanStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanStatementContext scanStatement() throws RecognitionException {
		ScanStatementContext _localctx = new ScanStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_scanStatement);
		try {
			setState(1045);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SCAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1029);
				match(SCAN);
				setState(1030);
				match(LPAREN);
				setState(1031);
				expression(0);
				setState(1032);
				match(COMMA);
				setState(1033);
				variableDeclaratorId();
				setState(1034);
				match(RPAREN);
				setState(1035);
				match(SEMI);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(1037);
				match(T__32);
				setState(1038);
				match(LPAREN);
				setState(1039);
				expression(0);
				setState(1040);
				match(COMMA);
				setState(1041);
				variableDeclaratorId();
				setState(1042);
				match(RPAREN);
				setState(1043);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 53:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 23);
		case 13:
			return precpred(_ctx, 22);
		case 14:
			return precpred(_ctx, 21);
		case 15:
			return precpred(_ctx, 20);
		case 16:
			return precpred(_ctx, 16);
		case 17:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0082\u041a\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\7\2\u0084\n\2\f\2\16\2\u0087\13\2\3\2\7\2"+
		"\u008a\n\2\f\2\16\2\u008d\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\7\5\u0099\n\5\f\5\16\5\u009c\13\5\3\5\3\5\3\6\5\6\u00a1\n\6\3\6\3\6\3"+
		"\6\5\6\u00a6\n\6\3\6\3\6\5\6\u00aa\n\6\3\6\3\6\3\7\3\7\3\7\7\7\u00b1\n"+
		"\7\f\7\16\7\u00b4\13\7\3\b\3\b\7\b\u00b8\n\b\f\b\16\b\u00bb\13\b\3\b\3"+
		"\b\3\t\3\t\5\t\u00c1\n\t\3\t\3\t\5\t\u00c5\n\t\3\n\3\n\3\n\3\n\5\n\u00cb"+
		"\n\n\3\13\3\13\5\13\u00cf\n\13\3\13\3\13\3\13\3\13\7\13\u00d5\n\13\f\13"+
		"\16\13\u00d8\13\13\3\13\3\13\5\13\u00dc\n\13\3\13\3\13\5\13\u00e0\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u00e7\n\f\f\f\16\f\u00ea\13\f\3\f\3\f\5\f\u00ee"+
		"\n\f\3\f\3\f\5\f\u00f2\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00fc"+
		"\n\16\f\16\16\16\u00ff\13\16\3\16\3\16\3\17\3\17\3\17\7\17\u0106\n\17"+
		"\f\17\16\17\u0109\13\17\3\17\3\17\3\17\3\20\3\20\3\20\7\20\u0111\n\20"+
		"\f\20\16\20\u0114\13\20\3\21\3\21\3\21\5\21\u0119\n\21\3\22\3\22\3\22"+
		"\7\22\u011e\n\22\f\22\16\22\u0121\13\22\3\22\3\22\3\22\3\22\7\22\u0127"+
		"\n\22\f\22\16\22\u012a\13\22\5\22\u012c\n\22\3\23\3\23\5\23\u0130\n\23"+
		"\3\24\3\24\3\24\3\24\7\24\u0136\n\24\f\24\16\24\u0139\13\24\3\24\5\24"+
		"\u013c\n\24\5\24\u013e\n\24\3\24\3\24\3\25\3\25\3\25\7\25\u0145\n\25\f"+
		"\25\16\25\u0148\13\25\3\25\3\25\3\25\7\25\u014d\n\25\f\25\16\25\u0150"+
		"\13\25\5\25\u0152\n\25\3\26\3\26\5\26\u0156\n\26\3\26\3\26\3\26\5\26\u015b"+
		"\n\26\7\26\u015d\n\26\f\26\16\26\u0160\13\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\7\30\u0168\n\30\f\30\16\30\u016b\13\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\5\31\u0173\n\31\5\31\u0175\n\31\3\32\3\32\3\32\7\32\u017a\n\32\f"+
		"\32\16\32\u017d\13\32\3\33\3\33\5\33\u0181\n\33\3\33\3\33\3\34\3\34\3"+
		"\34\7\34\u0188\n\34\f\34\16\34\u018b\13\34\3\34\3\34\5\34\u018f\n\34\3"+
		"\34\5\34\u0192\n\34\3\35\7\35\u0195\n\35\f\35\16\35\u0198\13\35\3\35\3"+
		"\35\3\35\3\36\7\36\u019e\n\36\f\36\16\36\u01a1\13\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3 \3 \3 \7 \u01ac\n \f \16 \u01af\13 \3!\3!\3\"\3\"\7\""+
		"\u01b5\n\"\f\"\16\"\u01b8\13\"\3\"\3\"\3#\3#\5#\u01be\n#\3$\3$\3$\3%\7"+
		"%\u01c4\n%\f%\16%\u01c7\13%\3%\3%\3%\3&\3&\3&\3&\3&\3&\5&\u01d2\n&\3&"+
		"\3&\3&\3&\3&\5&\u01d9\n&\3&\3&\3&\3&\3&\5&\u01e0\n&\3&\3&\3&\3&\3&\5&"+
		"\u01e7\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\6&\u0218\n&\r&\16&\u0219\3&\5&\u021d\n&\3&\5&\u0220\n&\3"+
		"&\3&\3&\3&\7&\u0226\n&\f&\16&\u0229\13&\3&\5&\u022c\n&\3&\3&\3&\6&\u0231"+
		"\n&\r&\16&\u0232\3&\5&\u0236\n&\3&\5&\u0239\n&\3&\3&\3&\3&\7&\u023f\n"+
		"&\f&\16&\u0242\13&\3&\5&\u0245\n&\3&\3&\3&\3&\7&\u024b\n&\f&\16&\u024e"+
		"\13&\3&\7&\u0251\n&\f&\16&\u0254\13&\3&\3&\3&\3&\3&\3&\7&\u025c\n&\f&"+
		"\16&\u025f\13&\3&\7&\u0262\n&\f&\16&\u0265\13&\3&\3&\3&\3&\5&\u026b\n"+
		"&\3&\3&\3&\5&\u0270\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u027d\n&\3"+
		"&\3&\3&\5&\u0282\n&\3&\3&\3&\5&\u0287\n&\3&\3&\3&\5&\u028c\n&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\5&\u0298\n&\3\'\3\'\3\'\7\'\u029d\n\'\f\'\16\'"+
		"\u02a0\13\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u02aa\n\'\f\'\16\'\u02ad"+
		"\13\'\3\'\3\'\3\'\3\'\3\'\5\'\u02b4\n\'\3(\3(\3(\7(\u02b9\n(\f(\16(\u02bc"+
		"\13(\3)\3)\3)\3)\5)\u02c2\n)\3*\3*\3*\5*\u02c7\n*\3*\3*\3+\3+\3+\7+\u02ce"+
		"\n+\f+\16+\u02d1\13+\3,\7,\u02d4\n,\f,\16,\u02d7\13,\3,\3,\3,\3,\3,\3"+
		"-\6-\u02df\n-\r-\16-\u02e0\3-\6-\u02e4\n-\r-\16-\u02e5\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\5.\u02f4\n.\3/\3/\5/\u02f8\n/\3/\3/\5/\u02fc\n/"+
		"\3/\3/\5/\u0300\n/\5/\u0302\n/\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u030a"+
		"\n\60\3\61\7\61\u030d\n\61\f\61\16\61\u0310\13\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\6\63"+
		"\u0323\n\63\r\63\16\63\u0324\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u032d"+
		"\n\63\3\64\3\64\3\64\7\64\u0332\n\64\f\64\16\64\u0335\13\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\5\67\u034a\n\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u035a\n\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u0388\n\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\7\67\u0390\n\67\f\67\16\67\u0393\13\67"+
		"\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38"+
		"\38\38\38\58\u03af\n8\39\39\39\39\39\39\39\59\u03b8\n9\59\u03ba\n9\3:"+
		"\3:\5:\u03be\n:\3:\3:\3:\5:\u03c3\n:\7:\u03c5\n:\f:\16:\u03c8\13:\3:\5"+
		":\u03cb\n:\3;\3;\3;\3;\7;\u03d1\n;\f;\16;\u03d4\13;\3;\3;\3;\3;\3;\3;"+
		"\3;\7;\u03dd\n;\f;\16;\u03e0\13;\3;\3;\7;\u03e4\n;\f;\16;\u03e7\13;\5"+
		";\u03e9\n;\3<\3<\5<\u03ed\n<\3=\3=\3=\3=\3>\3>\3>\5>\u03f6\n>\3?\3?\5"+
		"?\u03fa\n?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\5@\u0406\n@\3A\3A\3A\3A\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u0418\nA\3A\2\3lB\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj"+
		"lnprtvxz|~\u0080\2\16\6\2\3\3\62\62=?CC\n\2\5\16$$&&))//\64\6489BB\4\2"+
		"\61\61DD\4\2\17\17LP\3\2hk\3\2^_\4\2lmqq\3\2jk\4\2\\]cd\4\2bbee\4\2[["+
		"r|\3\2hi\2\u048d\2\u0085\3\2\2\2\4\u0090\3\2\2\2\6\u0092\3\2\2\2\b\u0094"+
		"\3\2\2\2\n\u00a0\3\2\2\2\f\u00ad\3\2\2\2\16\u00b5\3\2\2\2\20\u00c4\3\2"+
		"\2\2\22\u00ca\3\2\2\2\24\u00ce\3\2\2\2\26\u00e1\3\2\2\2\30\u00f3\3\2\2"+
		"\2\32\u00f7\3\2\2\2\34\u0102\3\2\2\2\36\u010d\3\2\2\2 \u0115\3\2\2\2\""+
		"\u012b\3\2\2\2$\u012f\3\2\2\2&\u0131\3\2\2\2(\u0151\3\2\2\2*\u0153\3\2"+
		"\2\2,\u0161\3\2\2\2.\u0163\3\2\2\2\60\u0174\3\2\2\2\62\u0176\3\2\2\2\64"+
		"\u017e\3\2\2\2\66\u0191\3\2\2\28\u0196\3\2\2\2:\u019f\3\2\2\2<\u01a6\3"+
		"\2\2\2>\u01a8\3\2\2\2@\u01b0\3\2\2\2B\u01b2\3\2\2\2D\u01bd\3\2\2\2F\u01bf"+
		"\3\2\2\2H\u01c5\3\2\2\2J\u0297\3\2\2\2L\u02b3\3\2\2\2N\u02b5\3\2\2\2P"+
		"\u02c1\3\2\2\2R\u02c3\3\2\2\2T\u02ca\3\2\2\2V\u02d5\3\2\2\2X\u02de\3\2"+
		"\2\2Z\u02f3\3\2\2\2\\\u0301\3\2\2\2^\u0309\3\2\2\2`\u030e\3\2\2\2b\u0316"+
		"\3\2\2\2d\u032c\3\2\2\2f\u032e\3\2\2\2h\u0336\3\2\2\2j\u0338\3\2\2\2l"+
		"\u0349\3\2\2\2n\u03ae\3\2\2\2p\u03b9\3\2\2\2r\u03ca\3\2\2\2t\u03cc\3\2"+
		"\2\2v\u03ea\3\2\2\2x\u03ee\3\2\2\2z\u03f5\3\2\2\2|\u03f7\3\2\2\2~\u0405"+
		"\3\2\2\2\u0080\u0417\3\2\2\2\u0082\u0084\5\n\6\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008b\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u008a\5\22\n\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7\2\2\3\u008f\3\3\2\2\2\u0090\u0091"+
		"\7\62\2\2\u0091\5\3\2\2\2\u0092\u0093\t\2\2\2\u0093\7\3\2\2\2\u0094\u0095"+
		"\7]\2\2\u0095\u009a\7}\2\2\u0096\u0097\7Y\2\2\u0097\u0099\7}\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7\\\2\2\u009e"+
		"\t\3\2\2\2\u009f\u00a1\5\6\4\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3\u00a5\7}\2\2\u00a4\u00a6"+
		"\5\b\5\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a8\7\61\2\2\u00a8\u00aa\5(\25\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\5\16\b\2\u00ac\13\3\2\2\2\u00ad"+
		"\u00b2\5(\25\2\u00ae\u00af\7Y\2\2\u00af\u00b1\5(\25\2\u00b0\u00ae\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\r\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b9\7T\2\2\u00b6\u00b8\5\20\t\2"+
		"\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7U\2\2\u00bd"+
		"\17\3\2\2\2\u00be\u00c5\7X\2\2\u00bf\u00c1\7C\2\2\u00c0\u00bf\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\5B\"\2\u00c3\u00c5"+
		"\5\22\n\2\u00c4\u00be\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c3\3\2\2\2"+
		"\u00c5\21\3\2\2\2\u00c6\u00cb\5\24\13\2\u00c7\u00cb\5\26\f\2\u00c8\u00cb"+
		"\5\30\r\2\u00c9\u00cb\5\n\6\2\u00ca\u00c6\3\2\2\2\u00ca\u00c7\3\2\2\2"+
		"\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\23\3\2\2\2\u00cc\u00cf"+
		"\5(\25\2\u00cd\u00cf\7J\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d1\7}\2\2\u00d1\u00d6\5\64\33\2\u00d2\u00d3\7"+
		"V\2\2\u00d3\u00d5\7W\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00db\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00da\7H\2\2\u00da\u00dc\5\62\32\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00e0\5<\37\2\u00de\u00e0\7X"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\25\3\2\2\2\u00e1\u00e2"+
		"\7J\2\2\u00e2\u00e3\7\4\2\2\u00e3\u00e8\5\64\33\2\u00e4\u00e5\7V\2\2\u00e5"+
		"\u00e7\7W\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ed\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\7H\2\2\u00ec\u00ee\5\62\32\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3"+
		"\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00f2\5<\37\2\u00f0\u00f2\7X\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\27\3\2\2\2\u00f3\u00f4\5(\25"+
		"\2\u00f4\u00f5\5\36\20\2\u00f5\u00f6\7X\2\2\u00f6\31\3\2\2\2\u00f7\u00f8"+
		"\5(\25\2\u00f8\u00fd\5\34\17\2\u00f9\u00fa\7Y\2\2\u00fa\u00fc\5\34\17"+
		"\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7X\2\2\u0101"+
		"\33\3\2\2\2\u0102\u0107\7}\2\2\u0103\u0104\7V\2\2\u0104\u0106\7W\2\2\u0105"+
		"\u0103\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7[\2\2\u010b"+
		"\u010c\5$\23\2\u010c\35\3\2\2\2\u010d\u0112\5 \21\2\u010e\u010f\7Y\2\2"+
		"\u010f\u0111\5 \21\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\37\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u0118\5\"\22\2\u0116\u0117\7[\2\2\u0117\u0119\5$\23\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119!\3\2\2\2\u011a\u011f\7}\2\2\u011b\u011c"+
		"\7V\2\2\u011c\u011e\7W\2\2\u011d\u011b\3\2\2\2\u011e\u0121\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u012c\3\2\2\2\u0121\u011f\3\2"+
		"\2\2\u0122\u0128\7}\2\2\u0123\u0124\7V\2\2\u0124\u0125\7L\2\2\u0125\u0127"+
		"\7W\2\2\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u011a\3\2"+
		"\2\2\u012b\u0122\3\2\2\2\u012c#\3\2\2\2\u012d\u0130\5&\24\2\u012e\u0130"+
		"\5l\67\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130%\3\2\2\2\u0131"+
		"\u013d\7T\2\2\u0132\u0137\5$\23\2\u0133\u0134\7Y\2\2\u0134\u0136\5$\23"+
		"\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\7Y\2\2\u013b"+
		"\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0132\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7U\2\2\u0140"+
		"\'\3\2\2\2\u0141\u0146\5*\26\2\u0142\u0143\7V\2\2\u0143\u0145\7W\2\2\u0144"+
		"\u0142\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2"+
		"\2\2\u0147\u0152\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014e\5,\27\2\u014a"+
		"\u014b\7V\2\2\u014b\u014d\7W\2\2\u014c\u014a\3\2\2\2\u014d\u0150\3\2\2"+
		"\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0151\u0141\3\2\2\2\u0151\u0149\3\2\2\2\u0152)\3\2\2\2\u0153"+
		"\u0155\7}\2\2\u0154\u0156\5.\30\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u015e\3\2\2\2\u0157\u0158\7Z\2\2\u0158\u015a\7}\2\2\u0159\u015b"+
		"\5.\30\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c"+
		"\u0157\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f+\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\t\3\2\2\u0162-\3\2"+
		"\2\2\u0163\u0164\7]\2\2\u0164\u0169\5\60\31\2\u0165\u0166\7Y\2\2\u0166"+
		"\u0168\5\60\31\2\u0167\u0165\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3"+
		"\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c"+
		"\u016d\7\\\2\2\u016d/\3\2\2\2\u016e\u0175\5(\25\2\u016f\u0172\7`\2\2\u0170"+
		"\u0171\t\4\2\2\u0171\u0173\5(\25\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173\u0175\3\2\2\2\u0174\u016e\3\2\2\2\u0174\u016f\3\2\2\2\u0175"+
		"\61\3\2\2\2\u0176\u017b\5> \2\u0177\u0178\7Y\2\2\u0178\u017a\5> \2\u0179"+
		"\u0177\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2"+
		"\2\2\u017c\63\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0180\7R\2\2\u017f\u0181"+
		"\5\66\34\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\3\2\2\2"+
		"\u0182\u0183\7S\2\2\u0183\65\3\2\2\2\u0184\u0189\58\35\2\u0185\u0186\7"+
		"Y\2\2\u0186\u0188\58\35\2\u0187\u0185\3\2\2\2\u0188\u018b\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018e\3\2\2\2\u018b\u0189\3\2"+
		"\2\2\u018c\u018d\7Y\2\2\u018d\u018f\5:\36\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u0192\5:\36\2\u0191\u0184\3\2"+
		"\2\2\u0191\u0190\3\2\2\2\u0192\67\3\2\2\2\u0193\u0195\5\4\3\2\u0194\u0193"+
		"\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0199\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019a\5(\25\2\u019a\u019b\5\""+
		"\22\2\u019b9\3\2\2\2\u019c\u019e\5\4\3\2\u019d\u019c\3\2\2\2\u019e\u01a1"+
		"\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a2\u01a3\5(\25\2\u01a3\u01a4\7\177\2\2\u01a4\u01a5\5"+
		"\"\22\2\u01a5;\3\2\2\2\u01a6\u01a7\5B\"\2\u01a7=\3\2\2\2\u01a8\u01ad\7"+
		"}\2\2\u01a9\u01aa\7Z\2\2\u01aa\u01ac\7}\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae?\3\2\2\2"+
		"\u01af\u01ad\3\2\2\2\u01b0\u01b1\t\5\2\2\u01b1A\3\2\2\2\u01b2\u01b6\7"+
		"T\2\2\u01b3\u01b5\5D#\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b9\u01ba\7U\2\2\u01baC\3\2\2\2\u01bb\u01be\5F$\2\u01bc\u01be\5"+
		"J&\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01beE\3\2\2\2\u01bf\u01c0"+
		"\5H%\2\u01c0\u01c1\7X\2\2\u01c1G\3\2\2\2\u01c2\u01c4\5\4\3\2\u01c3\u01c2"+
		"\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01c8\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01c9\5(\25\2\u01c9\u01ca\5\36"+
		"\20\2\u01caI\3\2\2\2\u01cb\u0298\5B\"\2\u01cc\u01cd\7\66\2\2\u01cd\u01ce"+
		"\5d\63\2\u01ce\u01d1\5J&\2\u01cf\u01d0\7\60\2\2\u01d0\u01d2\5J&\2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u0298\3\2\2\2\u01d3\u01d4\7\66"+
		"\2\2\u01d4\u01d5\5d\63\2\u01d5\u01d8\5J&\2\u01d6\u01d7\7\20\2\2\u01d7"+
		"\u01d9\5J&\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u0298\3\2\2"+
		"\2\u01da\u01db\7\21\2\2\u01db\u01dc\5d\63\2\u01dc\u01df\5J&\2\u01dd\u01de"+
		"\7\60\2\2\u01de\u01e0\5J&\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u0298\3\2\2\2\u01e1\u01e2\7\21\2\2\u01e2\u01e3\5d\63\2\u01e3\u01e6\5"+
		"J&\2\u01e4\u01e5\7\20\2\2\u01e5\u01e7\5J&\2\u01e6\u01e4\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7\u0298\3\2\2\2\u01e8\u01e9\7\65\2\2\u01e9\u01ea\7"+
		"R\2\2\u01ea\u01eb\5\\/\2\u01eb\u01ec\7S\2\2\u01ec\u01ed\5J&\2\u01ed\u0298"+
		"\3\2\2\2\u01ee\u01ef\7\22\2\2\u01ef\u01f0\7R\2\2\u01f0\u01f1\5\\/\2\u01f1"+
		"\u01f2\7S\2\2\u01f2\u01f3\5J&\2\u01f3\u0298\3\2\2\2\u01f4\u01f5\7K\2\2"+
		"\u01f5\u01f6\5d\63\2\u01f6\u01f7\5J&\2\u01f7\u0298\3\2\2\2\u01f8\u01f9"+
		"\7\23\2\2\u01f9\u01fa\5d\63\2\u01fa\u01fb\5J&\2\u01fb\u0298\3\2\2\2\u01fc"+
		"\u01fd\7.\2\2\u01fd\u01fe\5J&\2\u01fe\u01ff\7K\2\2\u01ff\u0200\5d\63\2"+
		"\u0200\u0201\7X\2\2\u0201\u0298\3\2\2\2\u0202\u0203\7.\2\2\u0203\u0204"+
		"\5J&\2\u0204\u0205\7\23\2\2\u0205\u0206\5d\63\2\u0206\u0207\7X\2\2\u0207"+
		"\u0298\3\2\2\2\u0208\u0209\7\24\2\2\u0209\u020a\5J&\2\u020a\u020b\7K\2"+
		"\2\u020b\u020c\5d\63\2\u020c\u020d\7X\2\2\u020d\u0298\3\2\2\2\u020e\u020f"+
		"\7\24\2\2\u020f\u0210\5J&\2\u0210\u0211\7\23\2\2\u0211\u0212\5d\63\2\u0212"+
		"\u0213\7X\2\2\u0213\u0298\3\2\2\2\u0214\u0215\7I\2\2\u0215\u021f\5B\""+
		"\2\u0216\u0218\5L\'\2\u0217\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u0217"+
		"\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u021d\5P)\2\u021c"+
		"\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0220\3\2\2\2\u021e\u0220\5P"+
		")\2\u021f\u0217\3\2\2\2\u021f\u021e\3\2\2\2\u0220\u0298\3\2\2\2\u0221"+
		"\u0222\7I\2\2\u0222\u0223\5R*\2\u0223\u0227\5B\"\2\u0224\u0226\5L\'\2"+
		"\u0225\u0224\3\2\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228"+
		"\3\2\2\2\u0228\u022b\3\2\2\2\u0229\u0227\3\2\2\2\u022a\u022c\5P)\2\u022b"+
		"\u022a\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u0298\3\2\2\2\u022d\u022e\7\25"+
		"\2\2\u022e\u0238\5B\"\2\u022f\u0231\5L\'\2\u0230\u022f\3\2\2\2\u0231\u0232"+
		"\3\2\2\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235\3\2\2\2\u0234"+
		"\u0236\5P)\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0239\3\2\2"+
		"\2\u0237\u0239\5P)\2\u0238\u0230\3\2\2\2\u0238\u0237\3\2\2\2\u0239\u0298"+
		"\3\2\2\2\u023a\u023b\7\25\2\2\u023b\u023c\5R*\2\u023c\u0240\5B\"\2\u023d"+
		"\u023f\5L\'\2\u023e\u023d\3\2\2\2\u023f\u0242\3\2\2\2\u0240\u023e\3\2"+
		"\2\2\u0240\u0241\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2\2\2\u0243"+
		"\u0245\5P)\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0298\3\2\2"+
		"\2\u0246\u0247\7E\2\2\u0247\u0248\5d\63\2\u0248\u024c\7T\2\2\u0249\u024b"+
		"\5X-\2\u024a\u0249\3\2\2\2\u024b\u024e\3\2\2\2\u024c\u024a\3\2\2\2\u024c"+
		"\u024d\3\2\2\2\u024d\u0252\3\2\2\2\u024e\u024c\3\2\2\2\u024f\u0251\5Z"+
		".\2\u0250\u024f\3\2\2\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252"+
		"\u0253\3\2\2\2\u0253\u0255\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u0256\7U"+
		"\2\2\u0256\u0298\3\2\2\2\u0257\u0258\7\26\2\2\u0258\u0259\5d\63\2\u0259"+
		"\u025d\7T\2\2\u025a\u025c\5X-\2\u025b\u025a\3\2\2\2\u025c\u025f\3\2\2"+
		"\2\u025d\u025b\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u0263\3\2\2\2\u025f\u025d"+
		"\3\2\2\2\u0260\u0262\5Z.\2\u0261\u0260\3\2\2\2\u0262\u0265\3\2\2\2\u0263"+
		"\u0261\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2"+
		"\2\2\u0266\u0267\7U\2\2\u0267\u0298\3\2\2\2\u0268\u026a\7@\2\2\u0269\u026b"+
		"\5l\67\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c"+
		"\u0298\7X\2\2\u026d\u026f\7\27\2\2\u026e\u0270\5l\67\2\u026f\u026e\3\2"+
		"\2\2\u026f\u0270\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0298\7X\2\2\u0272"+
		"\u0273\7G\2\2\u0273\u0274\5l\67\2\u0274\u0275\7X\2\2\u0275\u0298\3\2\2"+
		"\2\u0276\u0277\7\30\2\2\u0277\u0278\5l\67\2\u0278\u0279\7X\2\2\u0279\u0298"+
		"\3\2\2\2\u027a\u027c\7%\2\2\u027b\u027d\7}\2\2\u027c\u027b\3\2\2\2\u027c"+
		"\u027d\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u0298\7X\2\2\u027f\u0281\7\31"+
		"\2\2\u0280\u0282\7}\2\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282"+
		"\u0283\3\2\2\2\u0283\u0298\7X\2\2\u0284\u0286\7,\2\2\u0285\u0287\7}\2"+
		"\2\u0286\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0298"+
		"\7X\2\2\u0289\u028b\7\32\2\2\u028a\u028c\7}\2\2\u028b\u028a\3\2\2\2\u028b"+
		"\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0298\7X\2\2\u028e\u0298\7X\2"+
		"\2\u028f\u0290\5h\65\2\u0290\u0291\7X\2\2\u0291\u0298\3\2\2\2\u0292\u0293"+
		"\7}\2\2\u0293\u0294\7a\2\2\u0294\u0298\5J&\2\u0295\u0298\5~@\2\u0296\u0298"+
		"\5\u0080A\2\u0297\u01cb\3\2\2\2\u0297\u01cc\3\2\2\2\u0297\u01d3\3\2\2"+
		"\2\u0297\u01da\3\2\2\2\u0297\u01e1\3\2\2\2\u0297\u01e8\3\2\2\2\u0297\u01ee"+
		"\3\2\2\2\u0297\u01f4\3\2\2\2\u0297\u01f8\3\2\2\2\u0297\u01fc\3\2\2\2\u0297"+
		"\u0202\3\2\2\2\u0297\u0208\3\2\2\2\u0297\u020e\3\2\2\2\u0297\u0214\3\2"+
		"\2\2\u0297\u0221\3\2\2\2\u0297\u022d\3\2\2\2\u0297\u023a\3\2\2\2\u0297"+
		"\u0246\3\2\2\2\u0297\u0257\3\2\2\2\u0297\u0268\3\2\2\2\u0297\u026d\3\2"+
		"\2\2\u0297\u0272\3\2\2\2\u0297\u0276\3\2\2\2\u0297\u027a\3\2\2\2\u0297"+
		"\u027f\3\2\2\2\u0297\u0284\3\2\2\2\u0297\u0289\3\2\2\2\u0297\u028e\3\2"+
		"\2\2\u0297\u028f\3\2\2\2\u0297\u0292\3\2\2\2\u0297\u0295\3\2\2\2\u0297"+
		"\u0296\3\2\2\2\u0298K\3\2\2\2\u0299\u029a\7(\2\2\u029a\u029e\7R\2\2\u029b"+
		"\u029d\5\4\3\2\u029c\u029b\3\2\2\2\u029d\u02a0\3\2\2\2\u029e\u029c\3\2"+
		"\2\2\u029e\u029f\3\2\2\2\u029f\u02a1\3\2\2\2\u02a0\u029e\3\2\2\2\u02a1"+
		"\u02a2\5N(\2\u02a2\u02a3\7}\2\2\u02a3\u02a4\7S\2\2\u02a4\u02a5\5B\"\2"+
		"\u02a5\u02b4\3\2\2\2\u02a6\u02a7\7\33\2\2\u02a7\u02ab\7R\2\2\u02a8\u02aa"+
		"\5\4\3\2\u02a9\u02a8\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab"+
		"\u02ac\3\2\2\2\u02ac\u02ae\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02af\5N"+
		"(\2\u02af\u02b0\7}\2\2\u02b0\u02b1\7S\2\2\u02b1\u02b2\5B\"\2\u02b2\u02b4"+
		"\3\2\2\2\u02b3\u0299\3\2\2\2\u02b3\u02a6\3\2\2\2\u02b4M\3\2\2\2\u02b5"+
		"\u02ba\5> \2\u02b6\u02b7\7o\2\2\u02b7\u02b9\5> \2\u02b8\u02b6\3\2\2\2"+
		"\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bbO\3"+
		"\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\7\63\2\2\u02be\u02c2\5B\"\2\u02bf"+
		"\u02c0\7\34\2\2\u02c0\u02c2\5B\"\2\u02c1\u02bd\3\2\2\2\u02c1\u02bf\3\2"+
		"\2\2\u02c2Q\3\2\2\2\u02c3\u02c4\7R\2\2\u02c4\u02c6\5T+\2\u02c5\u02c7\7"+
		"X\2\2\u02c6\u02c5\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8"+
		"\u02c9\7S\2\2\u02c9S\3\2\2\2\u02ca\u02cf\5V,\2\u02cb\u02cc\7X\2\2\u02cc"+
		"\u02ce\5V,\2\u02cd\u02cb\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3\2\2"+
		"\2\u02cf\u02d0\3\2\2\2\u02d0U\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2\u02d4"+
		"\5\4\3\2\u02d3\u02d2\3\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02d8\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8\u02d9\5*"+
		"\26\2\u02d9\u02da\5\"\22\2\u02da\u02db\7[\2\2\u02db\u02dc\5l\67\2\u02dc"+
		"W\3\2\2\2\u02dd\u02df\5Z.\2\u02de\u02dd\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0"+
		"\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e3\3\2\2\2\u02e2\u02e4\5D"+
		"#\2\u02e3\u02e2\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5"+
		"\u02e6\3\2\2\2\u02e6Y\3\2\2\2\u02e7\u02e8\7\'\2\2\u02e8\u02e9\5j\66\2"+
		"\u02e9\u02ea\7a\2\2\u02ea\u02f4\3\2\2\2\u02eb\u02ec\7-\2\2\u02ec\u02f4"+
		"\7a\2\2\u02ed\u02ee\7\35\2\2\u02ee\u02ef\5j\66\2\u02ef\u02f0\7a\2\2\u02f0"+
		"\u02f4\3\2\2\2\u02f1\u02f2\7\36\2\2\u02f2\u02f4\7a\2\2\u02f3\u02e7\3\2"+
		"\2\2\u02f3\u02eb\3\2\2\2\u02f3\u02ed\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f4"+
		"[\3\2\2\2\u02f5\u0302\5`\61\2\u02f6\u02f8\5^\60\2\u02f7\u02f6\3\2\2\2"+
		"\u02f7\u02f8\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fb\7X\2\2\u02fa\u02fc"+
		"\5l\67\2\u02fb\u02fa\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd"+
		"\u02ff\7X\2\2\u02fe\u0300\5b\62\2\u02ff\u02fe\3\2\2\2\u02ff\u0300\3\2"+
		"\2\2\u0300\u0302\3\2\2\2\u0301\u02f5\3\2\2\2\u0301\u02f7\3\2\2\2\u0302"+
		"]\3\2\2\2\u0303\u0304\5,\27\2\u0304\u0305\5\"\22\2\u0305\u0306\b\60\1"+
		"\2\u0306\u030a\3\2\2\2\u0307\u030a\5H%\2\u0308\u030a\5f\64\2\u0309\u0303"+
		"\3\2\2\2\u0309\u0307\3\2\2\2\u0309\u0308\3\2\2\2\u030a_\3\2\2\2\u030b"+
		"\u030d\5\4\3\2\u030c\u030b\3\2\2\2\u030d\u0310\3\2\2\2\u030e\u030c\3\2"+
		"\2\2\u030e\u030f\3\2\2\2\u030f\u0311\3\2\2\2\u0310\u030e\3\2\2\2\u0311"+
		"\u0312\5(\25\2\u0312\u0313\5\"\22\2\u0313\u0314\7a\2\2\u0314\u0315\5l"+
		"\67\2\u0315a\3\2\2\2\u0316\u0317\5f\64\2\u0317c\3\2\2\2\u0318\u0319\7"+
		"R\2\2\u0319\u031a\7}\2\2\u031a\u031b\7[\2\2\u031b\u031c\5l\67\2\u031c"+
		"\u031d\7S\2\2\u031d\u031e\b\63\1\2\u031e\u032d\3\2\2\2\u031f\u0320\7R"+
		"\2\2\u0320\u0322\7}\2\2\u0321\u0323\7}\2\2\u0322\u0321\3\2\2\2\u0323\u0324"+
		"\3\2\2\2\u0324\u0322\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\3\2\2\2\u0326"+
		"\u0327\7S\2\2\u0327\u032d\b\63\1\2\u0328\u0329\7R\2\2\u0329\u032a\5l\67"+
		"\2\u032a\u032b\7S\2\2\u032b\u032d\3\2\2\2\u032c\u0318\3\2\2\2\u032c\u031f"+
		"\3\2\2\2\u032c\u0328\3\2\2\2\u032de\3\2\2\2\u032e\u0333\5l\67\2\u032f"+
		"\u0330\7Y\2\2\u0330\u0332\5l\67\2\u0331\u032f\3\2\2\2\u0332\u0335\3\2"+
		"\2\2\u0333\u0331\3\2\2\2\u0333\u0334\3\2\2\2\u0334g\3\2\2\2\u0335\u0333"+
		"\3\2\2\2\u0336\u0337\5l\67\2\u0337i\3\2\2\2\u0338\u0339\5l\67\2\u0339"+
		"k\3\2\2\2\u033a\u033b\b\67\1\2\u033b\u034a\5n8\2\u033c\u033d\7:\2\2\u033d"+
		"\u034a\5p9\2\u033e\u033f\7\37\2\2\u033f\u034a\5p9\2\u0340\u0341\7R\2\2"+
		"\u0341\u0342\5(\25\2\u0342\u0343\7S\2\2\u0343\u0344\5l\67\23\u0344\u034a"+
		"\3\2\2\2\u0345\u0346\t\6\2\2\u0346\u034a\5l\67\21\u0347\u0348\t\7\2\2"+
		"\u0348\u034a\5l\67\20\u0349\u033a\3\2\2\2\u0349\u033c\3\2\2\2\u0349\u033e"+
		"\3\2\2\2\u0349\u0340\3\2\2\2\u0349\u0345\3\2\2\2\u0349\u0347\3\2\2\2\u034a"+
		"\u0391\3\2\2\2\u034b\u034c\f\17\2\2\u034c\u034d\t\b\2\2\u034d\u0390\5"+
		"l\67\20\u034e\u034f\f\16\2\2\u034f\u0350\t\t\2\2\u0350\u0390\5l\67\17"+
		"\u0351\u0359\f\r\2\2\u0352\u0353\7]\2\2\u0353\u035a\7]\2\2\u0354\u0355"+
		"\7\\\2\2\u0355\u0356\7\\\2\2\u0356\u035a\7\\\2\2\u0357\u0358\7\\\2\2\u0358"+
		"\u035a\7\\\2\2\u0359\u0352\3\2\2\2\u0359\u0354\3\2\2\2\u0359\u0357\3\2"+
		"\2\2\u035a\u035b\3\2\2\2\u035b\u0390\5l\67\16\u035c\u035d\f\f\2\2\u035d"+
		"\u035e\t\n\2\2\u035e\u0390\5l\67\r\u035f\u0360\f\n\2\2\u0360\u0361\t\13"+
		"\2\2\u0361\u0390\5l\67\13\u0362\u0363\f\t\2\2\u0363\u0364\7n\2\2\u0364"+
		"\u0390\5l\67\n\u0365\u0366\f\b\2\2\u0366\u0367\7p\2\2\u0367\u0390\5l\67"+
		"\t\u0368\u0369\f\7\2\2\u0369\u036a\7o\2\2\u036a\u0390\5l\67\b\u036b\u036c"+
		"\f\6\2\2\u036c\u036d\7f\2\2\u036d\u0390\5l\67\7\u036e\u036f\f\5\2\2\u036f"+
		"\u0370\7g\2\2\u0370\u0390\5l\67\6\u0371\u0372\f\4\2\2\u0372\u0373\7`\2"+
		"\2\u0373\u0374\5l\67\2\u0374\u0375\7a\2\2\u0375\u0376\5l\67\5\u0376\u0390"+
		"\3\2\2\2\u0377\u0378\f\3\2\2\u0378\u0379\t\f\2\2\u0379\u0390\5l\67\3\u037a"+
		"\u037b\f\31\2\2\u037b\u037c\7Z\2\2\u037c\u0390\7}\2\2\u037d\u037e\f\30"+
		"\2\2\u037e\u037f\7V\2\2\u037f\u0380\5l\67\2\u0380\u0381\7W\2\2\u0381\u0390"+
		"\3\2\2\2\u0382\u0383\f\27\2\2\u0383\u0390\5|?\2\u0384\u0385\f\26\2\2\u0385"+
		"\u0387\7R\2\2\u0386\u0388\5f\64\2\u0387\u0386\3\2\2\2\u0387\u0388\3\2"+
		"\2\2\u0388\u0389\3\2\2\2\u0389\u0390\7S\2\2\u038a\u038b\f\22\2\2\u038b"+
		"\u0390\t\r\2\2\u038c\u038d\f\13\2\2\u038d\u038e\7\67\2\2\u038e\u0390\5"+
		"(\25\2\u038f\u034b\3\2\2\2\u038f\u034e\3\2\2\2\u038f\u0351\3\2\2\2\u038f"+
		"\u035c\3\2\2\2\u038f\u035f\3\2\2\2\u038f\u0362\3\2\2\2\u038f\u0365\3\2"+
		"\2\2\u038f\u0368\3\2\2\2\u038f\u036b\3\2\2\2\u038f\u036e\3\2\2\2\u038f"+
		"\u0371\3\2\2\2\u038f\u0377\3\2\2\2\u038f\u037a\3\2\2\2\u038f\u037d\3\2"+
		"\2\2\u038f\u0382\3\2\2\2\u038f\u0384\3\2\2\2\u038f\u038a\3\2\2\2\u038f"+
		"\u038c\3\2\2\2\u0390\u0393\3\2\2\2\u0391\u038f\3\2\2\2\u0391\u0392\3\2"+
		"\2\2\u0392m\3\2\2\2\u0393\u0391\3\2\2\2\u0394\u0395\7R\2\2\u0395\u0396"+
		"\5l\67\2\u0396\u0397\7S\2\2\u0397\u03af\3\2\2\2\u0398\u03af\5@!\2\u0399"+
		"\u03af\7}\2\2\u039a\u039b\5(\25\2\u039b\u039c\7Z\2\2\u039c\u039d\7*\2"+
		"\2\u039d\u03af\3\2\2\2\u039e\u039f\5(\25\2\u039f\u03a0\7Z\2\2\u03a0\u03a1"+
		"\7 \2\2\u03a1\u03af\3\2\2\2\u03a2\u03a3\7J\2\2\u03a3\u03a4\7Z\2\2\u03a4"+
		"\u03af\7*\2\2\u03a5\u03a6\7J\2\2\u03a6\u03a7\7Z\2\2\u03a7\u03af\7 \2\2"+
		"\u03a8\u03a9\7!\2\2\u03a9\u03aa\7Z\2\2\u03aa\u03af\7*\2\2\u03ab\u03ac"+
		"\7!\2\2\u03ac\u03ad\7Z\2\2\u03ad\u03af\7 \2\2\u03ae\u0394\3\2\2\2\u03ae"+
		"\u0398\3\2\2\2\u03ae\u0399\3\2\2\2\u03ae\u039a\3\2\2\2\u03ae\u039e\3\2"+
		"\2\2\u03ae\u03a2\3\2\2\2\u03ae\u03a5\3\2\2\2\u03ae\u03a8\3\2\2\2\u03ae"+
		"\u03ab\3\2\2\2\u03afo\3\2\2\2\u03b0\u03b1\5x=\2\u03b1\u03b2\5r:\2\u03b2"+
		"\u03b3\5v<\2\u03b3\u03ba\3\2\2\2\u03b4\u03b7\5r:\2\u03b5\u03b8\5t;\2\u03b6"+
		"\u03b8\5v<\2\u03b7\u03b5\3\2\2\2\u03b7\u03b6\3\2\2\2\u03b8\u03ba\3\2\2"+
		"\2\u03b9\u03b0\3\2\2\2\u03b9\u03b4\3\2\2\2\u03baq\3\2\2\2\u03bb\u03bd"+
		"\7}\2\2\u03bc\u03be\5z>\2\u03bd\u03bc\3\2\2\2\u03bd\u03be\3\2\2\2\u03be"+
		"\u03c6\3\2\2\2\u03bf\u03c0\7Z\2\2\u03c0\u03c2\7}\2\2\u03c1\u03c3\5z>\2"+
		"\u03c2\u03c1\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c5\3\2\2\2\u03c4\u03bf"+
		"\3\2\2\2\u03c5\u03c8\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7"+
		"\u03cb\3\2\2\2\u03c8\u03c6\3\2\2\2\u03c9\u03cb\5,\27\2\u03ca\u03bb\3\2"+
		"\2\2\u03ca\u03c9\3\2\2\2\u03cbs\3\2\2\2\u03cc\u03e8\7V\2\2\u03cd\u03d2"+
		"\7W\2\2\u03ce\u03cf\7V\2\2\u03cf\u03d1\7W\2\2\u03d0\u03ce\3\2\2\2\u03d1"+
		"\u03d4\3\2\2\2\u03d2\u03d0\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d5\3\2"+
		"\2\2\u03d4\u03d2\3\2\2\2\u03d5\u03e9\5&\24\2\u03d6\u03d7\5l\67\2\u03d7"+
		"\u03de\7W\2\2\u03d8\u03d9\7V\2\2\u03d9\u03da\5l\67\2\u03da\u03db\7W\2"+
		"\2\u03db\u03dd\3\2\2\2\u03dc\u03d8\3\2\2\2\u03dd\u03e0\3\2\2\2\u03de\u03dc"+
		"\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e5\3\2\2\2\u03e0\u03de\3\2\2\2\u03e1"+
		"\u03e2\7V\2\2\u03e2\u03e4\7W\2\2\u03e3\u03e1\3\2\2\2\u03e4\u03e7\3\2\2"+
		"\2\u03e5\u03e3\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6\u03e9\3\2\2\2\u03e7\u03e5"+
		"\3\2\2\2\u03e8\u03cd\3\2\2\2\u03e8\u03d6\3\2\2\2\u03e9u\3\2\2\2\u03ea"+
		"\u03ec\5|?\2\u03eb\u03ed\5\16\b\2\u03ec\u03eb\3\2\2\2\u03ec\u03ed\3\2"+
		"\2\2\u03edw\3\2\2\2\u03ee\u03ef\7]\2\2\u03ef\u03f0\5\f\7\2\u03f0\u03f1"+
		"\7\\\2\2\u03f1y\3\2\2\2\u03f2\u03f3\7]\2\2\u03f3\u03f6\7\\\2\2\u03f4\u03f6"+
		"\5.\30\2\u03f5\u03f2\3\2\2\2\u03f5\u03f4\3\2\2\2\u03f6{\3\2\2\2\u03f7"+
		"\u03f9\7R\2\2\u03f8\u03fa\5f\64\2\u03f9\u03f8\3\2\2\2\u03f9\u03fa\3\2"+
		"\2\2\u03fa\u03fb\3\2\2\2\u03fb\u03fc\7S\2\2\u03fc}\3\2\2\2\u03fd\u03fe"+
		"\7<\2\2\u03fe\u03ff\5d\63\2\u03ff\u0400\7X\2\2\u0400\u0406\3\2\2\2\u0401"+
		"\u0402\7\"\2\2\u0402\u0403\5d\63\2\u0403\u0404\7X\2\2\u0404\u0406\3\2"+
		"\2\2\u0405\u03fd\3\2\2\2\u0405\u0401\3\2\2\2\u0406\177\3\2\2\2\u0407\u0408"+
		"\7A\2\2\u0408\u0409\7R\2\2\u0409\u040a\5l\67\2\u040a\u040b\7Y\2\2\u040b"+
		"\u040c\5\"\22\2\u040c\u040d\7S\2\2\u040d\u040e\7X\2\2\u040e\u0418\3\2"+
		"\2\2\u040f\u0410\7#\2\2\u0410\u0411\7R\2\2\u0411\u0412\5l\67\2\u0412\u0413"+
		"\7Y\2\2\u0413\u0414\5\"\22\2\u0414\u0415\7S\2\2\u0415\u0416\7X\2\2\u0416"+
		"\u0418\3\2\2\2\u0417\u0407\3\2\2\2\u0417\u040f\3\2\2\2\u0418\u0081\3\2"+
		"\2\2u\u0085\u008b\u009a\u00a0\u00a5\u00a9\u00b2\u00b9\u00c0\u00c4\u00ca"+
		"\u00ce\u00d6\u00db\u00df\u00e8\u00ed\u00f1\u00fd\u0107\u0112\u0118\u011f"+
		"\u0128\u012b\u012f\u0137\u013b\u013d\u0146\u014e\u0151\u0155\u015a\u015e"+
		"\u0169\u0172\u0174\u017b\u0180\u0189\u018e\u0191\u0196\u019f\u01ad\u01b6"+
		"\u01bd\u01c5\u01d1\u01d8\u01df\u01e6\u0219\u021c\u021f\u0227\u022b\u0232"+
		"\u0235\u0238\u0240\u0244\u024c\u0252\u025d\u0263\u026a\u026f\u027c\u0281"+
		"\u0286\u028b\u0297\u029e\u02ab\u02b3\u02ba\u02c1\u02c6\u02cf\u02d5\u02e0"+
		"\u02e5\u02f3\u02f7\u02fb\u02ff\u0301\u0309\u030e\u0324\u032c\u0333\u0349"+
		"\u0359\u0387\u038f\u0391\u03ae\u03b7\u03b9\u03bd\u03c2\u03c6\u03ca\u03d2"+
		"\u03de\u03e5\u03e8\u03ec\u03f5\u03f9\u0405\u0417";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}