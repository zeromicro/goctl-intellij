// Generated from /Users/sh00414ml/java_workspace/goctl-intellij/src/main/java/cn/xiaoheiban/antlr4/ApiParser.g4 by ANTLR 4.13.1
package cn.xiaoheiban.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ApiParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SYNTAX=1, INFO=2, MAP=3, STRUCT=4, INTERFACE=5, TYPE=6, ATSERVER=7, ATDOC=8, 
		ATHANDLER=9, SERVICE=10, RETURNS=11, IMPORT=12, AS=13, HTTPMETHOD=14, 
		GET=15, HEAD=16, POST=17, PUT=18, PATCH=19, DELETE=20, CONNECT=21, OPTIONS=22, 
		TRACE=23, GOTYPE=24, BOOL=25, UINT8=26, UINT16=27, UINT32=28, UINT64=29, 
		INT8=30, INT16=31, INT32=32, INT64=33, FLOAT32=34, FLOAT64=35, COMPLEX64=36, 
		COMPLEX128=37, STRING=38, INT=39, UINT=40, UINTPTR=41, BYTE=42, RUNE=43, 
		TIME=44, PATH=45, DURATION=46, LPAREN=47, RPAREN=48, LBRACE=49, RBRACE=50, 
		LBRACK=51, RBRACK=52, DOT=53, SMICOLON=54, COMMA=55, STAR=56, BAR=57, 
		ASSIGN=58, COLON=59, SLASH=60, NUMBER=61, HOSTVALUE=62, IDENT=63, WS=64, 
		VALUE=65, RAW_STRING=66, COMMENT=67, DOC_COMMENT=68, ERRCHAR=69;
	public static final int
		RULE_api = 0, RULE_syntaxLit = 1, RULE_apiBody = 2, RULE_importStatement = 3, 
		RULE_importSpec = 4, RULE_importLit = 5, RULE_importGroup = 6, RULE_infoStatement = 7, 
		RULE_typeStatement = 8, RULE_typeGroupSpec = 9, RULE_typeGroupBody = 10, 
		RULE_typeGroupAlias = 11, RULE_typeSingleSpec = 12, RULE_typeStruct = 13, 
		RULE_typeAlias = 14, RULE_typeFiled = 15, RULE_normalField = 16, RULE_fieldType = 17, 
		RULE_anonymousField = 18, RULE_normalFieldType = 19, RULE_starFieldType = 20, 
		RULE_mapFieldType = 21, RULE_arrayOrSliceType = 22, RULE_structType = 23, 
		RULE_structNameId = 24, RULE_fieldName = 25, RULE_referenceId = 26, RULE_pkg = 27, 
		RULE_tag = 28, RULE_serviceStatement = 29, RULE_serviceServerSpec = 30, 
		RULE_serviceSpec = 31, RULE_serviceName = 32, RULE_serviceBody = 33, RULE_serviceDoc = 34, 
		RULE_serviceDocNew = 35, RULE_serviceHandler = 36, RULE_serviceHandlerNew = 37, 
		RULE_serviceRoute = 38, RULE_httpRoute = 39, RULE_identPair = 40, RULE_handlerPair = 41, 
		RULE_identValue = 42, RULE_handlerValue = 43, RULE_importValue = 44, RULE_docValue = 45, 
		RULE_pair = 46, RULE_key = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"api", "syntaxLit", "apiBody", "importStatement", "importSpec", "importLit", 
			"importGroup", "infoStatement", "typeStatement", "typeGroupSpec", "typeGroupBody", 
			"typeGroupAlias", "typeSingleSpec", "typeStruct", "typeAlias", "typeFiled", 
			"normalField", "fieldType", "anonymousField", "normalFieldType", "starFieldType", 
			"mapFieldType", "arrayOrSliceType", "structType", "structNameId", "fieldName", 
			"referenceId", "pkg", "tag", "serviceStatement", "serviceServerSpec", 
			"serviceSpec", "serviceName", "serviceBody", "serviceDoc", "serviceDocNew", 
			"serviceHandler", "serviceHandlerNew", "serviceRoute", "httpRoute", "identPair", 
			"handlerPair", "identValue", "handlerValue", "importValue", "docValue", 
			"pair", "key"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'syntax'", "'info'", "'map'", "'struct'", "'interface'", "'type'", 
			"'@server'", "'@doc'", "'@handler'", "'service'", "'returns'", "'import'", 
			"'as'", null, "'get'", "'head'", "'post'", "'put'", "'patch'", "'delete'", 
			"'connect'", "'options'", "'trace'", null, "'bool'", "'uint8'", "'uint16'", 
			"'uint32'", "'uint64'", "'int8'", "'int16'", "'int32'", "'int64'", "'float32'", 
			"'float64'", "'complex64'", "'complex128'", "'string'", "'int'", "'uint'", 
			"'uintptr'", "'byte'", "'rune'", "'time.Time'", null, null, "'('", "')'", 
			"'{'", "'}'", "'['", "']'", "'.'", "';'", "','", "'*'", "'-'", "'='", 
			"':'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SYNTAX", "INFO", "MAP", "STRUCT", "INTERFACE", "TYPE", "ATSERVER", 
			"ATDOC", "ATHANDLER", "SERVICE", "RETURNS", "IMPORT", "AS", "HTTPMETHOD", 
			"GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "CONNECT", "OPTIONS", 
			"TRACE", "GOTYPE", "BOOL", "UINT8", "UINT16", "UINT32", "UINT64", "INT8", 
			"INT16", "INT32", "INT64", "FLOAT32", "FLOAT64", "COMPLEX64", "COMPLEX128", 
			"STRING", "INT", "UINT", "UINTPTR", "BYTE", "RUNE", "TIME", "PATH", "DURATION", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "DOT", "SMICOLON", 
			"COMMA", "STAR", "BAR", "ASSIGN", "COLON", "SLASH", "NUMBER", "HOSTVALUE", 
			"IDENT", "WS", "VALUE", "RAW_STRING", "COMMENT", "DOC_COMMENT", "ERRCHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "ApiParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ApiParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApiContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ApiParser.EOF, 0); }
		public SyntaxLitContext syntaxLit() {
			return getRuleContext(SyntaxLitContext.class,0);
		}
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<InfoStatementContext> infoStatement() {
			return getRuleContexts(InfoStatementContext.class);
		}
		public InfoStatementContext infoStatement(int i) {
			return getRuleContext(InfoStatementContext.class,i);
		}
		public List<ApiBodyContext> apiBody() {
			return getRuleContexts(ApiBodyContext.class);
		}
		public ApiBodyContext apiBody(int i) {
			return getRuleContext(ApiBodyContext.class,i);
		}
		public ApiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_api; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitApi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApiContext api() throws RecognitionException {
		ApiContext _localctx = new ApiContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_api);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYNTAX) {
				{
				setState(96);
				syntaxLit();
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5316L) != 0)) {
				{
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IMPORT:
					{
					setState(99);
					importStatement();
					}
					break;
				case INFO:
					{
					setState(100);
					infoStatement();
					}
					break;
				case TYPE:
				case ATSERVER:
				case SERVICE:
					{
					setState(101);
					apiBody();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SyntaxLitContext extends ParserRuleContext {
		public TerminalNode SYNTAX() { return getToken(ApiParser.SYNTAX, 0); }
		public TerminalNode ASSIGN() { return getToken(ApiParser.ASSIGN, 0); }
		public TerminalNode VALUE() { return getToken(ApiParser.VALUE, 0); }
		public SyntaxLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntaxLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitSyntaxLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntaxLitContext syntaxLit() throws RecognitionException {
		SyntaxLitContext _localctx = new SyntaxLitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_syntaxLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(SYNTAX);
			setState(110);
			match(ASSIGN);
			setState(111);
			match(VALUE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ApiBodyContext extends ParserRuleContext {
		public TypeStatementContext typeStatement() {
			return getRuleContext(TypeStatementContext.class,0);
		}
		public ServiceStatementContext serviceStatement() {
			return getRuleContext(ServiceStatementContext.class,0);
		}
		public ApiBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apiBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitApiBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApiBodyContext apiBody() throws RecognitionException {
		ApiBodyContext _localctx = new ApiBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_apiBody);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				typeStatement();
				}
				break;
			case ATSERVER:
			case SERVICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				serviceStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public List<ImportSpecContext> importSpec() {
			return getRuleContexts(ImportSpecContext.class);
		}
		public ImportSpecContext importSpec(int i) {
			return getRuleContext(ImportSpecContext.class,i);
		}
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(117);
					importSpec();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(120); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSpecContext extends ParserRuleContext {
		public ImportLitContext importLit() {
			return getRuleContext(ImportLitContext.class,0);
		}
		public ImportGroupContext importGroup() {
			return getRuleContext(ImportGroupContext.class,0);
		}
		public ImportSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitImportSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportSpecContext importSpec() throws RecognitionException {
		ImportSpecContext _localctx = new ImportSpecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importSpec);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				importLit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				importGroup();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportLitContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ApiParser.IMPORT, 0); }
		public ImportValueContext importValue() {
			return getRuleContext(ImportValueContext.class,0);
		}
		public ImportLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitImportLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportLitContext importLit() throws RecognitionException {
		ImportLitContext _localctx = new ImportLitContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(IMPORT);
			setState(127);
			importValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportGroupContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ApiParser.IMPORT, 0); }
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public List<ImportValueContext> importValue() {
			return getRuleContexts(ImportValueContext.class);
		}
		public ImportValueContext importValue(int i) {
			return getRuleContext(ImportValueContext.class,i);
		}
		public ImportGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importGroup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitImportGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportGroupContext importGroup() throws RecognitionException {
		ImportGroupContext _localctx = new ImportGroupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_importGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(IMPORT);
			setState(130);
			match(LPAREN);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VALUE) {
				{
				{
				setState(131);
				importValue();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InfoStatementContext extends ParserRuleContext {
		public TerminalNode INFO() { return getToken(ApiParser.INFO, 0); }
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public PairContext pair() {
			return getRuleContext(PairContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public InfoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infoStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitInfoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoStatementContext infoStatement() throws RecognitionException {
		InfoStatementContext _localctx = new InfoStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_infoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(INFO);
			setState(140);
			match(LPAREN);
			setState(141);
			pair();
			setState(142);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeStatementContext extends ParserRuleContext {
		public TypeSingleSpecContext typeSingleSpec() {
			return getRuleContext(TypeSingleSpecContext.class,0);
		}
		public TypeGroupSpecContext typeGroupSpec() {
			return getRuleContext(TypeGroupSpecContext.class,0);
		}
		public TypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeStatementContext typeStatement() throws RecognitionException {
		TypeStatementContext _localctx = new TypeStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(144);
				typeSingleSpec();
				}
				break;
			case 2:
				{
				setState(145);
				typeGroupSpec();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeGroupSpecContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ApiParser.TYPE, 0); }
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public TypeGroupBodyContext typeGroupBody() {
			return getRuleContext(TypeGroupBodyContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public TypeGroupSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeGroupSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeGroupSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeGroupSpecContext typeGroupSpec() throws RecognitionException {
		TypeGroupSpecContext _localctx = new TypeGroupSpecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeGroupSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(TYPE);
			setState(149);
			match(LPAREN);
			setState(150);
			typeGroupBody();
			setState(151);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeGroupBodyContext extends ParserRuleContext {
		public List<TypeGroupAliasContext> typeGroupAlias() {
			return getRuleContexts(TypeGroupAliasContext.class);
		}
		public TypeGroupAliasContext typeGroupAlias(int i) {
			return getRuleContext(TypeGroupAliasContext.class,i);
		}
		public List<StructTypeContext> structType() {
			return getRuleContexts(StructTypeContext.class);
		}
		public StructTypeContext structType(int i) {
			return getRuleContext(StructTypeContext.class,i);
		}
		public TypeGroupBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeGroupBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeGroupBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeGroupBodyContext typeGroupBody() throws RecognitionException {
		TypeGroupBodyContext _localctx = new TypeGroupBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeGroupBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(153);
					typeGroupAlias();
					}
					break;
				case 2:
					{
					setState(154);
					structType();
					}
					break;
				}
				}
				setState(159);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeGroupAliasContext extends ParserRuleContext {
		public StructNameIdContext structNameId() {
			return getRuleContext(StructNameIdContext.class,0);
		}
		public NormalFieldTypeContext normalFieldType() {
			return getRuleContext(NormalFieldTypeContext.class,0);
		}
		public TypeGroupAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeGroupAlias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeGroupAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeGroupAliasContext typeGroupAlias() throws RecognitionException {
		TypeGroupAliasContext _localctx = new TypeGroupAliasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeGroupAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			structNameId();
			setState(161);
			normalFieldType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSingleSpecContext extends ParserRuleContext {
		public TypeAliasContext typeAlias() {
			return getRuleContext(TypeAliasContext.class,0);
		}
		public TypeStructContext typeStruct() {
			return getRuleContext(TypeStructContext.class,0);
		}
		public TypeSingleSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSingleSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeSingleSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSingleSpecContext typeSingleSpec() throws RecognitionException {
		TypeSingleSpecContext _localctx = new TypeSingleSpecContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeSingleSpec);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				typeAlias();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				typeStruct();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeStructContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ApiParser.TYPE, 0); }
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public TypeStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeStruct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeStructContext typeStruct() throws RecognitionException {
		TypeStructContext _localctx = new TypeStructContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(TYPE);
			setState(168);
			structType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeAliasContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ApiParser.TYPE, 0); }
		public StructNameIdContext structNameId() {
			return getRuleContext(StructNameIdContext.class,0);
		}
		public NormalFieldTypeContext normalFieldType() {
			return getRuleContext(NormalFieldTypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ApiParser.ASSIGN, 0); }
		public TypeAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAlias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeAliasContext typeAlias() throws RecognitionException {
		TypeAliasContext _localctx = new TypeAliasContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(TYPE);
			setState(171);
			structNameId();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(172);
				match(ASSIGN);
				}
			}

			setState(175);
			normalFieldType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeFiledContext extends ParserRuleContext {
		public AnonymousFieldContext anonymousField() {
			return getRuleContext(AnonymousFieldContext.class,0);
		}
		public NormalFieldContext normalField() {
			return getRuleContext(NormalFieldContext.class,0);
		}
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public TypeFiledContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeFiled; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTypeFiled(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeFiledContext typeFiled() throws RecognitionException {
		TypeFiledContext _localctx = new TypeFiledContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeFiled);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				anonymousField();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				normalField();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				structType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NormalFieldContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public NormalFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitNormalField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalFieldContext normalField() throws RecognitionException {
		NormalFieldContext _localctx = new NormalFieldContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_normalField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			fieldName();
			setState(183);
			fieldType();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_STRING) {
				{
				setState(184);
				tag();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldTypeContext extends ParserRuleContext {
		public NormalFieldTypeContext normalFieldType() {
			return getRuleContext(NormalFieldTypeContext.class,0);
		}
		public StarFieldTypeContext starFieldType() {
			return getRuleContext(StarFieldTypeContext.class,0);
		}
		public MapFieldTypeContext mapFieldType() {
			return getRuleContext(MapFieldTypeContext.class,0);
		}
		public ArrayOrSliceTypeContext arrayOrSliceType() {
			return getRuleContext(ArrayOrSliceTypeContext.class,0);
		}
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fieldType);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				normalFieldType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				starFieldType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				mapFieldType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				arrayOrSliceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousFieldContext extends ParserRuleContext {
		public ReferenceIdContext referenceId() {
			return getRuleContext(ReferenceIdContext.class,0);
		}
		public TerminalNode STAR() { return getToken(ApiParser.STAR, 0); }
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public AnonymousFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitAnonymousField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousFieldContext anonymousField() throws RecognitionException {
		AnonymousFieldContext _localctx = new AnonymousFieldContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_anonymousField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(193);
				match(STAR);
				}
				break;
			}
			setState(196);
			referenceId();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_STRING) {
				{
				setState(197);
				tag();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NormalFieldTypeContext extends ParserRuleContext {
		public TerminalNode GOTYPE() { return getToken(ApiParser.GOTYPE, 0); }
		public ReferenceIdContext referenceId() {
			return getRuleContext(ReferenceIdContext.class,0);
		}
		public TerminalNode INTERFACE() { return getToken(ApiParser.INTERFACE, 0); }
		public TerminalNode LBRACE() { return getToken(ApiParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ApiParser.RBRACE, 0); }
		public NormalFieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalFieldType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitNormalFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalFieldTypeContext normalFieldType() throws RecognitionException {
		NormalFieldTypeContext _localctx = new NormalFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_normalFieldType);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(GOTYPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				referenceId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(202);
				match(INTERFACE);
				setState(203);
				match(LBRACE);
				setState(204);
				match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StarFieldTypeContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(ApiParser.STAR, 0); }
		public NormalFieldTypeContext normalFieldType() {
			return getRuleContext(NormalFieldTypeContext.class,0);
		}
		public StarFieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starFieldType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitStarFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StarFieldTypeContext starFieldType() throws RecognitionException {
		StarFieldTypeContext _localctx = new StarFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_starFieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(STAR);
			setState(208);
			normalFieldType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MapFieldTypeContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(ApiParser.MAP, 0); }
		public TerminalNode LBRACK() { return getToken(ApiParser.LBRACK, 0); }
		public List<FieldTypeContext> fieldType() {
			return getRuleContexts(FieldTypeContext.class);
		}
		public FieldTypeContext fieldType(int i) {
			return getRuleContext(FieldTypeContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(ApiParser.RBRACK, 0); }
		public MapFieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapFieldType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitMapFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapFieldTypeContext mapFieldType() throws RecognitionException {
		MapFieldTypeContext _localctx = new MapFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mapFieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(MAP);
			setState(211);
			match(LBRACK);
			setState(212);
			fieldType();
			setState(213);
			match(RBRACK);
			setState(214);
			fieldType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayOrSliceTypeContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ApiParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ApiParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ApiParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ApiParser.RBRACK, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ApiParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ApiParser.NUMBER, i);
		}
		public ArrayOrSliceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayOrSliceType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitArrayOrSliceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayOrSliceTypeContext arrayOrSliceType() throws RecognitionException {
		ArrayOrSliceTypeContext _localctx = new ArrayOrSliceTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayOrSliceType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(216);
					match(LBRACK);
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUMBER) {
						{
						setState(217);
						match(NUMBER);
						}
					}

					setState(220);
					match(RBRACK);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(223); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(225);
			fieldType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructTypeContext extends ParserRuleContext {
		public StructNameIdContext structNameId() {
			return getRuleContext(StructNameIdContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ApiParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ApiParser.RBRACE, 0); }
		public TerminalNode STRUCT() { return getToken(ApiParser.STRUCT, 0); }
		public List<TypeFiledContext> typeFiled() {
			return getRuleContexts(TypeFiledContext.class);
		}
		public TypeFiledContext typeFiled(int i) {
			return getRuleContext(TypeFiledContext.class,i);
		}
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_structType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			structNameId();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCT) {
				{
				setState(228);
				match(STRUCT);
				}
			}

			setState(231);
			match(LBRACE);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9149062642986385408L) != 0)) {
				{
				{
				setState(232);
				typeFiled();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructNameIdContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public StructNameIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structNameId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitStructNameId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructNameIdContext structNameId() throws RecognitionException {
		StructNameIdContext _localctx = new StructNameIdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_structNameId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceIdContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public TerminalNode GOTYPE() { return getToken(ApiParser.GOTYPE, 0); }
		public PkgContext pkg() {
			return getRuleContext(PkgContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(ApiParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ApiParser.RBRACK, 0); }
		public TerminalNode STAR() { return getToken(ApiParser.STAR, 0); }
		public ReferenceIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitReferenceId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceIdContext referenceId() throws RecognitionException {
		ReferenceIdContext _localctx = new ReferenceIdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_referenceId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(244);
				pkg();
				}
				break;
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(247);
				match(LBRACK);
				setState(248);
				match(RBRACK);
				}
			}

			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(251);
				match(STAR);
				}
			}

			setState(254);
			_la = _input.LA(1);
			if ( !(_la==GOTYPE || _la==IDENT) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class PkgContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public TerminalNode DOT() { return getToken(ApiParser.DOT, 0); }
		public PkgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitPkg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PkgContext pkg() throws RecognitionException {
		PkgContext _localctx = new PkgContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pkg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(IDENT);
			setState(257);
			match(DOT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TagContext extends ParserRuleContext {
		public TerminalNode RAW_STRING() { return getToken(ApiParser.RAW_STRING, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(RAW_STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceStatementContext extends ParserRuleContext {
		public ServiceSpecContext serviceSpec() {
			return getRuleContext(ServiceSpecContext.class,0);
		}
		public ServiceServerSpecContext serviceServerSpec() {
			return getRuleContext(ServiceServerSpecContext.class,0);
		}
		public ServiceStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceStatementContext serviceStatement() throws RecognitionException {
		ServiceStatementContext _localctx = new ServiceStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_serviceStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATSERVER) {
				{
				setState(261);
				serviceServerSpec();
				}
			}

			setState(264);
			serviceSpec();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceServerSpecContext extends ParserRuleContext {
		public TerminalNode ATSERVER() { return getToken(ApiParser.ATSERVER, 0); }
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public IdentPairContext identPair() {
			return getRuleContext(IdentPairContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public ServiceServerSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceServerSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceServerSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceServerSpecContext serviceServerSpec() throws RecognitionException {
		ServiceServerSpecContext _localctx = new ServiceServerSpecContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_serviceServerSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(ATSERVER);
			setState(267);
			match(LPAREN);
			setState(268);
			identPair();
			setState(269);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceSpecContext extends ParserRuleContext {
		public TerminalNode SERVICE() { return getToken(ApiParser.SERVICE, 0); }
		public ServiceNameContext serviceName() {
			return getRuleContext(ServiceNameContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ApiParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ApiParser.RBRACE, 0); }
		public List<ServiceBodyContext> serviceBody() {
			return getRuleContexts(ServiceBodyContext.class);
		}
		public ServiceBodyContext serviceBody(int i) {
			return getRuleContext(ServiceBodyContext.class,i);
		}
		public ServiceSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceSpecContext serviceSpec() throws RecognitionException {
		ServiceSpecContext _localctx = new ServiceSpecContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_serviceSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(SERVICE);
			setState(272);
			serviceName();
			setState(273);
			match(LBRACE);
			setState(275); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(274);
				serviceBody();
				}
				}
				setState(277); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0) );
			setState(279);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceNameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public ServiceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceNameContext serviceName() throws RecognitionException {
		ServiceNameContext _localctx = new ServiceNameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_serviceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceBodyContext extends ParserRuleContext {
		public ServiceRouteContext serviceRoute() {
			return getRuleContext(ServiceRouteContext.class,0);
		}
		public ServiceHandlerContext serviceHandler() {
			return getRuleContext(ServiceHandlerContext.class,0);
		}
		public ServiceHandlerNewContext serviceHandlerNew() {
			return getRuleContext(ServiceHandlerNewContext.class,0);
		}
		public ServiceDocContext serviceDoc() {
			return getRuleContext(ServiceDocContext.class,0);
		}
		public ServiceDocNewContext serviceDocNew() {
			return getRuleContext(ServiceDocNewContext.class,0);
		}
		public ServiceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceBodyContext serviceBody() throws RecognitionException {
		ServiceBodyContext _localctx = new ServiceBodyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_serviceBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(283);
				serviceDoc();
				}
				break;
			case 2:
				{
				setState(284);
				serviceDocNew();
				}
				break;
			}
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATSERVER:
				{
				setState(287);
				serviceHandler();
				}
				break;
			case ATHANDLER:
				{
				setState(288);
				serviceHandlerNew();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(291);
			serviceRoute();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceDocContext extends ParserRuleContext {
		public TerminalNode ATDOC() { return getToken(ApiParser.ATDOC, 0); }
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public PairContext pair() {
			return getRuleContext(PairContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public ServiceDocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceDoc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceDocContext serviceDoc() throws RecognitionException {
		ServiceDocContext _localctx = new ServiceDocContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_serviceDoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(ATDOC);
			setState(294);
			match(LPAREN);
			setState(295);
			pair();
			setState(296);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceDocNewContext extends ParserRuleContext {
		public TerminalNode ATDOC() { return getToken(ApiParser.ATDOC, 0); }
		public DocValueContext docValue() {
			return getRuleContext(DocValueContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public ServiceDocNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceDocNew; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceDocNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceDocNewContext serviceDocNew() throws RecognitionException {
		ServiceDocNewContext _localctx = new ServiceDocNewContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_serviceDocNew);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(ATDOC);
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				{
				setState(299);
				docValue();
				}
				break;
			case LPAREN:
				{
				{
				setState(300);
				match(LPAREN);
				setState(301);
				docValue();
				setState(302);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceHandlerContext extends ParserRuleContext {
		public TerminalNode ATSERVER() { return getToken(ApiParser.ATSERVER, 0); }
		public TerminalNode LPAREN() { return getToken(ApiParser.LPAREN, 0); }
		public HandlerPairContext handlerPair() {
			return getRuleContext(HandlerPairContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ApiParser.RPAREN, 0); }
		public ServiceHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceHandler; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceHandlerContext serviceHandler() throws RecognitionException {
		ServiceHandlerContext _localctx = new ServiceHandlerContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_serviceHandler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ATSERVER);
			setState(307);
			match(LPAREN);
			setState(308);
			handlerPair();
			setState(309);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceHandlerNewContext extends ParserRuleContext {
		public TerminalNode ATHANDLER() { return getToken(ApiParser.ATHANDLER, 0); }
		public HandlerValueContext handlerValue() {
			return getRuleContext(HandlerValueContext.class,0);
		}
		public ServiceHandlerNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceHandlerNew; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceHandlerNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceHandlerNewContext serviceHandlerNew() throws RecognitionException {
		ServiceHandlerNewContext _localctx = new ServiceHandlerNewContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_serviceHandlerNew);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(ATHANDLER);
			setState(312);
			handlerValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ServiceRouteContext extends ParserRuleContext {
		public HttpRouteContext httpRoute() {
			return getRuleContext(HttpRouteContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(ApiParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ApiParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ApiParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ApiParser.RPAREN, i);
		}
		public TerminalNode RETURNS() { return getToken(ApiParser.RETURNS, 0); }
		public TerminalNode SMICOLON() { return getToken(ApiParser.SMICOLON, 0); }
		public List<ReferenceIdContext> referenceId() {
			return getRuleContexts(ReferenceIdContext.class);
		}
		public ReferenceIdContext referenceId(int i) {
			return getRuleContext(ReferenceIdContext.class,i);
		}
		public ServiceRouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceRoute; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitServiceRoute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceRouteContext serviceRoute() throws RecognitionException {
		ServiceRouteContext _localctx = new ServiceRouteContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_serviceRoute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			httpRoute();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(315);
				match(LPAREN);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9149062642986385408L) != 0)) {
					{
					setState(316);
					referenceId();
					}
				}

				setState(319);
				match(RPAREN);
				}
			}

			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(322);
				match(RETURNS);
				setState(323);
				match(LPAREN);
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9149062642986385408L) != 0)) {
					{
					setState(324);
					referenceId();
					}
				}

				setState(327);
				match(RPAREN);
				}
			}

			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SMICOLON) {
				{
				setState(330);
				match(SMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HttpRouteContext extends ParserRuleContext {
		public TerminalNode HTTPMETHOD() { return getToken(ApiParser.HTTPMETHOD, 0); }
		public TerminalNode PATH() { return getToken(ApiParser.PATH, 0); }
		public HttpRouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_httpRoute; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitHttpRoute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HttpRouteContext httpRoute() throws RecognitionException {
		HttpRouteContext _localctx = new HttpRouteContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_httpRoute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(HTTPMETHOD);
			setState(334);
			match(PATH);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentPairContext extends ParserRuleContext {
		public List<KeyContext> key() {
			return getRuleContexts(KeyContext.class);
		}
		public KeyContext key(int i) {
			return getRuleContext(KeyContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ApiParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ApiParser.COLON, i);
		}
		public List<TerminalNode> DURATION() { return getTokens(ApiParser.DURATION); }
		public TerminalNode DURATION(int i) {
			return getToken(ApiParser.DURATION, i);
		}
		public List<IdentValueContext> identValue() {
			return getRuleContexts(IdentValueContext.class);
		}
		public IdentValueContext identValue(int i) {
			return getRuleContext(IdentValueContext.class,i);
		}
		public List<TerminalNode> PATH() { return getTokens(ApiParser.PATH); }
		public TerminalNode PATH(int i) {
			return getToken(ApiParser.PATH, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ApiParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ApiParser.NUMBER, i);
		}
		public IdentPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitIdentPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentPairContext identPair() throws RecognitionException {
		IdentPairContext _localctx = new IdentPairContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_identPair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(336);
				key();
				setState(337);
				match(COLON);
				setState(342);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DURATION:
					{
					setState(338);
					match(DURATION);
					}
					break;
				case IDENT:
					{
					setState(339);
					identValue();
					}
					break;
				case PATH:
					{
					setState(340);
					match(PATH);
					}
					break;
				case NUMBER:
					{
					setState(341);
					match(NUMBER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(348);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HandlerPairContext extends ParserRuleContext {
		public List<KeyContext> key() {
			return getRuleContexts(KeyContext.class);
		}
		public KeyContext key(int i) {
			return getRuleContext(KeyContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ApiParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ApiParser.COLON, i);
		}
		public List<HandlerValueContext> handlerValue() {
			return getRuleContexts(HandlerValueContext.class);
		}
		public HandlerValueContext handlerValue(int i) {
			return getRuleContext(HandlerValueContext.class,i);
		}
		public HandlerPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handlerPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitHandlerPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HandlerPairContext handlerPair() throws RecognitionException {
		HandlerPairContext _localctx = new HandlerPairContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_handlerPair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(349);
				key();
				setState(350);
				match(COLON);
				setState(351);
				handlerValue();
				}
				}
				setState(355); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentValueContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(ApiParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ApiParser.IDENT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ApiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ApiParser.COMMA, i);
		}
		public IdentValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitIdentValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentValueContext identValue() throws RecognitionException {
		IdentValueContext _localctx = new IdentValueContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_identValue);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(361); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(357);
					match(IDENT);
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(358);
						match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(363); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class HandlerValueContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public HandlerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handlerValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitHandlerValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HandlerValueContext handlerValue() throws RecognitionException {
		HandlerValueContext _localctx = new HandlerValueContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_handlerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportValueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(ApiParser.VALUE, 0); }
		public TerminalNode AS() { return getToken(ApiParser.AS, 0); }
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public ImportValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitImportValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportValueContext importValue() throws RecognitionException {
		ImportValueContext _localctx = new ImportValueContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_importValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(VALUE);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(368);
				match(AS);
				setState(369);
				match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DocValueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(ApiParser.VALUE, 0); }
		public DocValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_docValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitDocValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocValueContext docValue() throws RecognitionException {
		DocValueContext _localctx = new DocValueContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_docValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(VALUE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PairContext extends ParserRuleContext {
		public List<KeyContext> key() {
			return getRuleContexts(KeyContext.class);
		}
		public KeyContext key(int i) {
			return getRuleContext(KeyContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ApiParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ApiParser.COLON, i);
		}
		public List<TerminalNode> VALUE() { return getTokens(ApiParser.VALUE); }
		public TerminalNode VALUE(int i) {
			return getToken(ApiParser.VALUE, i);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(374);
				key();
				setState(375);
				match(COLON);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VALUE) {
					{
					setState(376);
					match(VALUE);
					}
				}

				}
				}
				setState(383);
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApiParserVisitor ) return ((ApiParserVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(IDENT);
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

	public static final String _serializedATN =
		"\u0004\u0001E\u0183\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000\u0003\u0000b\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000g\b\u0000\n\u0000\f\u0000"+
		"j\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002t\b\u0002\u0001\u0003"+
		"\u0004\u0003w\b\u0003\u000b\u0003\f\u0003x\u0001\u0004\u0001\u0004\u0003"+
		"\u0004}\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u0085\b\u0006\n\u0006\f\u0006\u0088\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0003\b\u0093\b\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n\u009c\b\n\n\n\f\n\u009f\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u00a6\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ae"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00b5\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ba"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00c0"+
		"\b\u0011\u0001\u0012\u0003\u0012\u00c3\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00c7\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00ce\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00db\b\u0016\u0001\u0016\u0004\u0016"+
		"\u00de\b\u0016\u000b\u0016\f\u0016\u00df\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u00e6\b\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u00ea\b\u0017\n\u0017\f\u0017\u00ed\t\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0003\u001a"+
		"\u00f6\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00fa\b\u001a\u0001"+
		"\u001a\u0003\u001a\u00fd\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0003\u001d\u0107"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0004"+
		"\u001f\u0114\b\u001f\u000b\u001f\f\u001f\u0115\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0003!\u011e\b!\u0001!\u0001!\u0003!\u0122"+
		"\b!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0003#\u0131\b#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0003&\u013e\b&\u0001"+
		"&\u0003&\u0141\b&\u0001&\u0001&\u0001&\u0003&\u0146\b&\u0001&\u0003&\u0149"+
		"\b&\u0001&\u0003&\u014c\b&\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0003(\u0157\b(\u0005(\u0159\b(\n(\f(\u015c\t("+
		"\u0001)\u0001)\u0001)\u0001)\u0004)\u0162\b)\u000b)\f)\u0163\u0001*\u0001"+
		"*\u0003*\u0168\b*\u0004*\u016a\b*\u000b*\f*\u016b\u0001+\u0001+\u0001"+
		",\u0001,\u0001,\u0003,\u0173\b,\u0001-\u0001-\u0001.\u0001.\u0001.\u0003"+
		".\u017a\b.\u0005.\u017c\b.\n.\f.\u017f\t.\u0001/\u0001/\u0001/\u0000\u0000"+
		"0\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0001\u0002\u0000"+
		"\u0018\u0018??\u0185\u0000a\u0001\u0000\u0000\u0000\u0002m\u0001\u0000"+
		"\u0000\u0000\u0004s\u0001\u0000\u0000\u0000\u0006v\u0001\u0000\u0000\u0000"+
		"\b|\u0001\u0000\u0000\u0000\n~\u0001\u0000\u0000\u0000\f\u0081\u0001\u0000"+
		"\u0000\u0000\u000e\u008b\u0001\u0000\u0000\u0000\u0010\u0092\u0001\u0000"+
		"\u0000\u0000\u0012\u0094\u0001\u0000\u0000\u0000\u0014\u009d\u0001\u0000"+
		"\u0000\u0000\u0016\u00a0\u0001\u0000\u0000\u0000\u0018\u00a5\u0001\u0000"+
		"\u0000\u0000\u001a\u00a7\u0001\u0000\u0000\u0000\u001c\u00aa\u0001\u0000"+
		"\u0000\u0000\u001e\u00b4\u0001\u0000\u0000\u0000 \u00b6\u0001\u0000\u0000"+
		"\u0000\"\u00bf\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000\u0000\u0000"+
		"&\u00cd\u0001\u0000\u0000\u0000(\u00cf\u0001\u0000\u0000\u0000*\u00d2"+
		"\u0001\u0000\u0000\u0000,\u00dd\u0001\u0000\u0000\u0000.\u00e3\u0001\u0000"+
		"\u0000\u00000\u00f0\u0001\u0000\u0000\u00002\u00f2\u0001\u0000\u0000\u0000"+
		"4\u00f5\u0001\u0000\u0000\u00006\u0100\u0001\u0000\u0000\u00008\u0103"+
		"\u0001\u0000\u0000\u0000:\u0106\u0001\u0000\u0000\u0000<\u010a\u0001\u0000"+
		"\u0000\u0000>\u010f\u0001\u0000\u0000\u0000@\u0119\u0001\u0000\u0000\u0000"+
		"B\u011d\u0001\u0000\u0000\u0000D\u0125\u0001\u0000\u0000\u0000F\u012a"+
		"\u0001\u0000\u0000\u0000H\u0132\u0001\u0000\u0000\u0000J\u0137\u0001\u0000"+
		"\u0000\u0000L\u013a\u0001\u0000\u0000\u0000N\u014d\u0001\u0000\u0000\u0000"+
		"P\u015a\u0001\u0000\u0000\u0000R\u0161\u0001\u0000\u0000\u0000T\u0169"+
		"\u0001\u0000\u0000\u0000V\u016d\u0001\u0000\u0000\u0000X\u016f\u0001\u0000"+
		"\u0000\u0000Z\u0174\u0001\u0000\u0000\u0000\\\u017d\u0001\u0000\u0000"+
		"\u0000^\u0180\u0001\u0000\u0000\u0000`b\u0003\u0002\u0001\u0000a`\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bh\u0001\u0000\u0000\u0000"+
		"cg\u0003\u0006\u0003\u0000dg\u0003\u000e\u0007\u0000eg\u0003\u0004\u0002"+
		"\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"kl\u0005\u0000\u0000\u0001l\u0001\u0001\u0000\u0000\u0000mn\u0005\u0001"+
		"\u0000\u0000no\u0005:\u0000\u0000op\u0005A\u0000\u0000p\u0003\u0001\u0000"+
		"\u0000\u0000qt\u0003\u0010\b\u0000rt\u0003:\u001d\u0000sq\u0001\u0000"+
		"\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0005\u0001\u0000\u0000\u0000"+
		"uw\u0003\b\u0004\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0007\u0001\u0000"+
		"\u0000\u0000z}\u0003\n\u0005\u0000{}\u0003\f\u0006\u0000|z\u0001\u0000"+
		"\u0000\u0000|{\u0001\u0000\u0000\u0000}\t\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005\f\u0000\u0000\u007f\u0080\u0003X,\u0000\u0080\u000b\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\f\u0000\u0000\u0082\u0086\u0005/\u0000"+
		"\u0000\u0083\u0085\u0003X,\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u00050\u0000\u0000\u008a\r"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0002\u0000\u0000\u008c\u008d"+
		"\u0005/\u0000\u0000\u008d\u008e\u0003\\.\u0000\u008e\u008f\u00050\u0000"+
		"\u0000\u008f\u000f\u0001\u0000\u0000\u0000\u0090\u0093\u0003\u0018\f\u0000"+
		"\u0091\u0093\u0003\u0012\t\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0011\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\u0006\u0000\u0000\u0095\u0096\u0005/\u0000\u0000\u0096\u0097"+
		"\u0003\u0014\n\u0000\u0097\u0098\u00050\u0000\u0000\u0098\u0013\u0001"+
		"\u0000\u0000\u0000\u0099\u009c\u0003\u0016\u000b\u0000\u009a\u009c\u0003"+
		".\u0017\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u0015\u0001\u0000"+
		"\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a1\u00030\u0018"+
		"\u0000\u00a1\u00a2\u0003&\u0013\u0000\u00a2\u0017\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a6\u0003\u001c\u000e\u0000\u00a4\u00a6\u0003\u001a\r\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6"+
		"\u0019\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0006\u0000\u0000\u00a8"+
		"\u00a9\u0003.\u0017\u0000\u00a9\u001b\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0005\u0006\u0000\u0000\u00ab\u00ad\u00030\u0018\u0000\u00ac\u00ae\u0005"+
		":\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0003&\u0013"+
		"\u0000\u00b0\u001d\u0001\u0000\u0000\u0000\u00b1\u00b5\u0003$\u0012\u0000"+
		"\u00b2\u00b5\u0003 \u0010\u0000\u00b3\u00b5\u0003.\u0017\u0000\u00b4\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5\u001f\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u00032\u0019\u0000\u00b7\u00b9\u0003\"\u0011\u0000\u00b8\u00ba\u0003"+
		"8\u001c\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba!\u0001\u0000\u0000\u0000\u00bb\u00c0\u0003&\u0013\u0000"+
		"\u00bc\u00c0\u0003(\u0014\u0000\u00bd\u00c0\u0003*\u0015\u0000\u00be\u00c0"+
		"\u0003,\u0016\u0000\u00bf\u00bb\u0001\u0000\u0000\u0000\u00bf\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00be\u0001"+
		"\u0000\u0000\u0000\u00c0#\u0001\u0000\u0000\u0000\u00c1\u00c3\u00058\u0000"+
		"\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6\u00034\u001a\u0000"+
		"\u00c5\u00c7\u00038\u001c\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7%\u0001\u0000\u0000\u0000\u00c8\u00ce"+
		"\u0005\u0018\u0000\u0000\u00c9\u00ce\u00034\u001a\u0000\u00ca\u00cb\u0005"+
		"\u0005\u0000\u0000\u00cb\u00cc\u00051\u0000\u0000\u00cc\u00ce\u00052\u0000"+
		"\u0000\u00cd\u00c8\u0001\u0000\u0000\u0000\u00cd\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00ce\'\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u00058\u0000\u0000\u00d0\u00d1\u0003&\u0013\u0000\u00d1)"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0003\u0000\u0000\u00d3\u00d4"+
		"\u00053\u0000\u0000\u00d4\u00d5\u0003\"\u0011\u0000\u00d5\u00d6\u0005"+
		"4\u0000\u0000\u00d6\u00d7\u0003\"\u0011\u0000\u00d7+\u0001\u0000\u0000"+
		"\u0000\u00d8\u00da\u00053\u0000\u0000\u00d9\u00db\u0005=\u0000\u0000\u00da"+
		"\u00d9\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0001\u0000\u0000\u0000\u00dc\u00de\u00054\u0000\u0000\u00dd\u00d8"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0003\"\u0011\u0000\u00e2-\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e5\u00030\u0018\u0000\u00e4\u00e6\u0005\u0004"+
		"\u0000\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00eb\u00051\u0000"+
		"\u0000\u00e8\u00ea\u0003\u001e\u000f\u0000\u00e9\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u00052\u0000\u0000"+
		"\u00ef/\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005?\u0000\u0000\u00f11"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005?\u0000\u0000\u00f33\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f6\u00036\u001b\u0000\u00f5\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u00053\u0000\u0000\u00f8\u00fa\u00054\u0000\u0000\u00f9"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fb\u00fd\u00058\u0000\u0000\u00fc\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0007\u0000\u0000\u0000\u00ff5\u0001"+
		"\u0000\u0000\u0000\u0100\u0101\u0005?\u0000\u0000\u0101\u0102\u00055\u0000"+
		"\u0000\u01027\u0001\u0000\u0000\u0000\u0103\u0104\u0005B\u0000\u0000\u0104"+
		"9\u0001\u0000\u0000\u0000\u0105\u0107\u0003<\u001e\u0000\u0106\u0105\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0003>\u001f\u0000\u0109;\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0005\u0007\u0000\u0000\u010b\u010c\u0005/\u0000\u0000"+
		"\u010c\u010d\u0003P(\u0000\u010d\u010e\u00050\u0000\u0000\u010e=\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0005\n\u0000\u0000\u0110\u0111\u0003@"+
		" \u0000\u0111\u0113\u00051\u0000\u0000\u0112\u0114\u0003B!\u0000\u0113"+
		"\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115"+
		"\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u00052\u0000\u0000\u0118?\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0005?\u0000\u0000\u011aA\u0001\u0000\u0000"+
		"\u0000\u011b\u011e\u0003D\"\u0000\u011c\u011e\u0003F#\u0000\u011d\u011b"+
		"\u0001\u0000\u0000\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000\u0000\u011f\u0122"+
		"\u0003H$\u0000\u0120\u0122\u0003J%\u0000\u0121\u011f\u0001\u0000\u0000"+
		"\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000"+
		"\u0000\u0123\u0124\u0003L&\u0000\u0124C\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0005\b\u0000\u0000\u0126\u0127\u0005/\u0000\u0000\u0127\u0128"+
		"\u0003\\.\u0000\u0128\u0129\u00050\u0000\u0000\u0129E\u0001\u0000\u0000"+
		"\u0000\u012a\u0130\u0005\b\u0000\u0000\u012b\u0131\u0003Z-\u0000\u012c"+
		"\u012d\u0005/\u0000\u0000\u012d\u012e\u0003Z-\u0000\u012e\u012f\u0005"+
		"0\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u012b\u0001\u0000"+
		"\u0000\u0000\u0130\u012c\u0001\u0000\u0000\u0000\u0131G\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u0005\u0007\u0000\u0000\u0133\u0134\u0005/\u0000\u0000"+
		"\u0134\u0135\u0003R)\u0000\u0135\u0136\u00050\u0000\u0000\u0136I\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0005\t\u0000\u0000\u0138\u0139\u0003V"+
		"+\u0000\u0139K\u0001\u0000\u0000\u0000\u013a\u0140\u0003N\'\u0000\u013b"+
		"\u013d\u0005/\u0000\u0000\u013c\u013e\u00034\u001a\u0000\u013d\u013c\u0001"+
		"\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u013f\u0001"+
		"\u0000\u0000\u0000\u013f\u0141\u00050\u0000\u0000\u0140\u013b\u0001\u0000"+
		"\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0148\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0005\u000b\u0000\u0000\u0143\u0145\u0005/\u0000"+
		"\u0000\u0144\u0146\u00034\u001a\u0000\u0145\u0144\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000"+
		"\u0147\u0149\u00050\u0000\u0000\u0148\u0142\u0001\u0000\u0000\u0000\u0148"+
		"\u0149\u0001\u0000\u0000\u0000\u0149\u014b\u0001\u0000\u0000\u0000\u014a"+
		"\u014c\u00056\u0000\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014b\u014c"+
		"\u0001\u0000\u0000\u0000\u014cM\u0001\u0000\u0000\u0000\u014d\u014e\u0005"+
		"\u000e\u0000\u0000\u014e\u014f\u0005-\u0000\u0000\u014fO\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0003^/\u0000\u0151\u0156\u0005;\u0000\u0000\u0152"+
		"\u0157\u0005.\u0000\u0000\u0153\u0157\u0003T*\u0000\u0154\u0157\u0005"+
		"-\u0000\u0000\u0155\u0157\u0005=\u0000\u0000\u0156\u0152\u0001\u0000\u0000"+
		"\u0000\u0156\u0153\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000"+
		"\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u0159\u0001\u0000\u0000"+
		"\u0000\u0158\u0150\u0001\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000"+
		"\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000"+
		"\u0000\u015bQ\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000"+
		"\u015d\u015e\u0003^/\u0000\u015e\u015f\u0005;\u0000\u0000\u015f\u0160"+
		"\u0003V+\u0000\u0160\u0162\u0001\u0000\u0000\u0000\u0161\u015d\u0001\u0000"+
		"\u0000\u0000\u0162\u0163\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164S\u0001\u0000\u0000"+
		"\u0000\u0165\u0167\u0005?\u0000\u0000\u0166\u0168\u00057\u0000\u0000\u0167"+
		"\u0166\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168"+
		"\u016a\u0001\u0000\u0000\u0000\u0169\u0165\u0001\u0000\u0000\u0000\u016a"+
		"\u016b\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b"+
		"\u016c\u0001\u0000\u0000\u0000\u016cU\u0001\u0000\u0000\u0000\u016d\u016e"+
		"\u0005?\u0000\u0000\u016eW\u0001\u0000\u0000\u0000\u016f\u0172\u0005A"+
		"\u0000\u0000\u0170\u0171\u0005\r\u0000\u0000\u0171\u0173\u0005?\u0000"+
		"\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000"+
		"\u0000\u0173Y\u0001\u0000\u0000\u0000\u0174\u0175\u0005A\u0000\u0000\u0175"+
		"[\u0001\u0000\u0000\u0000\u0176\u0177\u0003^/\u0000\u0177\u0179\u0005"+
		";\u0000\u0000\u0178\u017a\u0005A\u0000\u0000\u0179\u0178\u0001\u0000\u0000"+
		"\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017c\u0001\u0000\u0000"+
		"\u0000\u017b\u0176\u0001\u0000\u0000\u0000\u017c\u017f\u0001\u0000\u0000"+
		"\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000"+
		"\u0000\u017e]\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\u0005?\u0000\u0000\u0181_\u0001\u0000\u0000\u0000+afhsx|"+
		"\u0086\u0092\u009b\u009d\u00a5\u00ad\u00b4\u00b9\u00bf\u00c2\u00c6\u00cd"+
		"\u00da\u00df\u00e5\u00eb\u00f5\u00f9\u00fc\u0106\u0115\u011d\u0121\u0130"+
		"\u013d\u0140\u0145\u0148\u014b\u0156\u015a\u0163\u0167\u016b\u0172\u0179"+
		"\u017d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}