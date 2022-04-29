package cn.xiaoheiban.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ApiParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INFO) | (1L << TYPE) | (1L << ATSERVER) | (1L << SERVICE) | (1L << IMPORT))) != 0)) {
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
			switch (_input.LA(1)) {
			case INTERFACE:
			case GOTYPE:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				normalFieldType();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				starFieldType();
				}
				break;
			case MAP:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				mapFieldType();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				arrayOrSliceType();
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

	public static class AnonymousFieldContext extends ParserRuleContext {
		public ReferenceIdContext referenceId() {
			return getRuleContext(ReferenceIdContext.class,0);
		}
		public TerminalNode STAR() { return getToken(ApiParser.STAR, 0); }
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
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(193);
				match(STAR);
				}
			}

			setState(196);
			referenceId();
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
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(GOTYPE);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				referenceId();
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(200);
				match(INTERFACE);
				setState(201);
				match(LBRACE);
				setState(202);
				match(RBRACE);
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
			setState(205);
			match(STAR);
			setState(206);
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
			setState(208);
			match(MAP);
			setState(209);
			match(LBRACK);
			setState(210);
			fieldType();
			setState(211);
			match(RBRACK);
			setState(212);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(214);
					match(LBRACK);
					setState(215);
					match(RBRACK);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(218); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(220);
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
			setState(222);
			structNameId();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCT) {
				{
				setState(223);
				match(STRUCT);
				}
			}

			setState(226);
			match(LBRACE);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR || _la==IDENT) {
				{
				{
				setState(227);
				typeFiled();
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
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
			setState(235);
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
			setState(237);
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

	public static class ReferenceIdContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public PkgContext pkg() {
			return getRuleContext(PkgContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(239);
				pkg();
				}
				break;
			}
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
			setState(244);
			match(IDENT);
			setState(245);
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
			setState(247);
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
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATSERVER) {
				{
				setState(249);
				serviceServerSpec();
				}
			}

			setState(252);
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
			setState(254);
			match(ATSERVER);
			setState(255);
			match(LPAREN);
			setState(256);
			identPair();
			setState(257);
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
			setState(259);
			match(SERVICE);
			setState(260);
			serviceName();
			setState(261);
			match(LBRACE);
			setState(263); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(262);
				serviceBody();
				}
				}
				setState(265); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATSERVER) | (1L << ATDOC) | (1L << ATHANDLER))) != 0) );
			setState(267);
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
			setState(269);
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
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(271);
				serviceDoc();
				}
				break;
			case 2:
				{
				setState(272);
				serviceDocNew();
				}
				break;
			}
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATSERVER:
				{
				setState(275);
				serviceHandler();
				}
				break;
			case ATHANDLER:
				{
				setState(276);
				serviceHandlerNew();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(279);
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
			setState(281);
			match(ATDOC);
			setState(282);
			match(LPAREN);
			setState(283);
			pair();
			setState(284);
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
			setState(286);
			match(ATDOC);
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				{
				setState(287);
				docValue();
				}
				break;
			case LPAREN:
				{
				{
				setState(288);
				match(LPAREN);
				setState(289);
				docValue();
				setState(290);
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
			setState(294);
			match(ATSERVER);
			setState(295);
			match(LPAREN);
			setState(296);
			handlerPair();
			setState(297);
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
			setState(299);
			match(ATHANDLER);
			setState(300);
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
			setState(302);
			httpRoute();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(303);
				match(LPAREN);
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(304);
					referenceId();
					}
				}

				setState(307);
				match(RPAREN);
				}
			}

			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(310);
				match(RETURNS);
				setState(311);
				match(LPAREN);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(312);
					referenceId();
					}
				}

				setState(315);
				match(RPAREN);
				}
			}

			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SMICOLON) {
				{
				setState(318);
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
			setState(321);
			match(HTTPMETHOD);
			setState(322);
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
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(324);
				key();
				setState(325);
				match(COLON);
				setState(329);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DURATION:
					{
					setState(326);
					match(DURATION);
					}
					break;
				case IDENT:
					{
					setState(327);
					identValue();
					}
					break;
				case PATH:
					{
					setState(328);
					match(PATH);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(335);
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
			setState(340); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(336);
				key();
				setState(337);
				match(COLON);
				setState(338);
				handlerValue();
				}
				}
				setState(342); 
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
			setState(348); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(344);
					match(IDENT);
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(345);
						match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(350); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
			setState(352);
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
			setState(354);
			match(VALUE);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(355);
				match(AS);
				setState(356);
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
			setState(359);
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
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(361);
				key();
				setState(362);
				match(COLON);
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VALUE) {
					{
					setState(363);
					match(VALUE);
					}
				}

				}
				}
				setState(370);
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
			setState(371);
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
		"\u0004\u0001E\u0176\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00cc\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0004\u0016\u00d9\b\u0016\u000b\u0016\f\u0016\u00da\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u00e1\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u00e5\b\u0017\n\u0017\f\u0017\u00e8\t\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0003\u001a\u00f1\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0003\u001d\u00fb\b\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0004\u001f"+
		"\u0108\b\u001f\u000b\u001f\f\u001f\u0109\u0001\u001f\u0001\u001f\u0001"+
		" \u0001 \u0001!\u0001!\u0003!\u0112\b!\u0001!\u0001!\u0003!\u0116\b!\u0001"+
		"!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#"+
		"\u0001#\u0001#\u0001#\u0003#\u0125\b#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0003&\u0132\b&\u0001&\u0003"+
		"&\u0135\b&\u0001&\u0001&\u0001&\u0003&\u013a\b&\u0001&\u0003&\u013d\b"+
		"&\u0001&\u0003&\u0140\b&\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001("+
		"\u0001(\u0001(\u0003(\u014a\b(\u0005(\u014c\b(\n(\f(\u014f\t(\u0001)\u0001"+
		")\u0001)\u0001)\u0004)\u0155\b)\u000b)\f)\u0156\u0001*\u0001*\u0003*\u015b"+
		"\b*\u0004*\u015d\b*\u000b*\f*\u015e\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0003,\u0166\b,\u0001-\u0001-\u0001.\u0001.\u0001.\u0003.\u016d\b.\u0005"+
		".\u016f\b.\n.\f.\u0172\t.\u0001/\u0001/\u0001/\u0000\u00000\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0000\u0173\u0000a\u0001\u0000"+
		"\u0000\u0000\u0002m\u0001\u0000\u0000\u0000\u0004s\u0001\u0000\u0000\u0000"+
		"\u0006v\u0001\u0000\u0000\u0000\b|\u0001\u0000\u0000\u0000\n~\u0001\u0000"+
		"\u0000\u0000\f\u0081\u0001\u0000\u0000\u0000\u000e\u008b\u0001\u0000\u0000"+
		"\u0000\u0010\u0092\u0001\u0000\u0000\u0000\u0012\u0094\u0001\u0000\u0000"+
		"\u0000\u0014\u009d\u0001\u0000\u0000\u0000\u0016\u00a0\u0001\u0000\u0000"+
		"\u0000\u0018\u00a5\u0001\u0000\u0000\u0000\u001a\u00a7\u0001\u0000\u0000"+
		"\u0000\u001c\u00aa\u0001\u0000\u0000\u0000\u001e\u00b4\u0001\u0000\u0000"+
		"\u0000 \u00b6\u0001\u0000\u0000\u0000\"\u00bf\u0001\u0000\u0000\u0000"+
		"$\u00c2\u0001\u0000\u0000\u0000&\u00cb\u0001\u0000\u0000\u0000(\u00cd"+
		"\u0001\u0000\u0000\u0000*\u00d0\u0001\u0000\u0000\u0000,\u00d8\u0001\u0000"+
		"\u0000\u0000.\u00de\u0001\u0000\u0000\u00000\u00eb\u0001\u0000\u0000\u0000"+
		"2\u00ed\u0001\u0000\u0000\u00004\u00f0\u0001\u0000\u0000\u00006\u00f4"+
		"\u0001\u0000\u0000\u00008\u00f7\u0001\u0000\u0000\u0000:\u00fa\u0001\u0000"+
		"\u0000\u0000<\u00fe\u0001\u0000\u0000\u0000>\u0103\u0001\u0000\u0000\u0000"+
		"@\u010d\u0001\u0000\u0000\u0000B\u0111\u0001\u0000\u0000\u0000D\u0119"+
		"\u0001\u0000\u0000\u0000F\u011e\u0001\u0000\u0000\u0000H\u0126\u0001\u0000"+
		"\u0000\u0000J\u012b\u0001\u0000\u0000\u0000L\u012e\u0001\u0000\u0000\u0000"+
		"N\u0141\u0001\u0000\u0000\u0000P\u014d\u0001\u0000\u0000\u0000R\u0154"+
		"\u0001\u0000\u0000\u0000T\u015c\u0001\u0000\u0000\u0000V\u0160\u0001\u0000"+
		"\u0000\u0000X\u0162\u0001\u0000\u0000\u0000Z\u0167\u0001\u0000\u0000\u0000"+
		"\\\u0170\u0001\u0000\u0000\u0000^\u0173\u0001\u0000\u0000\u0000`b\u0003"+
		"\u0002\u0001\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bh\u0001\u0000\u0000\u0000cg\u0003\u0006\u0003\u0000dg\u0003\u000e\u0007"+
		"\u0000eg\u0003\u0004\u0002\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000kl\u0005\u0000\u0000\u0001l\u0001\u0001\u0000"+
		"\u0000\u0000mn\u0005\u0001\u0000\u0000no\u0005:\u0000\u0000op\u0005A\u0000"+
		"\u0000p\u0003\u0001\u0000\u0000\u0000qt\u0003\u0010\b\u0000rt\u0003:\u001d"+
		"\u0000sq\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0005\u0001"+
		"\u0000\u0000\u0000uw\u0003\b\u0004\u0000vu\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y\u0007\u0001\u0000\u0000\u0000z}\u0003\n\u0005\u0000{}\u0003\f\u0006"+
		"\u0000|z\u0001\u0000\u0000\u0000|{\u0001\u0000\u0000\u0000}\t\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\f\u0000\u0000\u007f\u0080\u0003X,\u0000\u0080"+
		"\u000b\u0001\u0000\u0000\u0000\u0081\u0082\u0005\f\u0000\u0000\u0082\u0086"+
		"\u0005/\u0000\u0000\u0083\u0085\u0003X,\u0000\u0084\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u00050\u0000"+
		"\u0000\u008a\r\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0002\u0000\u0000"+
		"\u008c\u008d\u0005/\u0000\u0000\u008d\u008e\u0003\\.\u0000\u008e\u008f"+
		"\u00050\u0000\u0000\u008f\u000f\u0001\u0000\u0000\u0000\u0090\u0093\u0003"+
		"\u0018\f\u0000\u0091\u0093\u0003\u0012\t\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0011\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0005\u0006\u0000\u0000\u0095\u0096\u0005/\u0000"+
		"\u0000\u0096\u0097\u0003\u0014\n\u0000\u0097\u0098\u00050\u0000\u0000"+
		"\u0098\u0013\u0001\u0000\u0000\u0000\u0099\u009c\u0003\u0016\u000b\u0000"+
		"\u009a\u009c\u0003.\u0017\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d"+
		"\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e"+
		"\u0015\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u00030\u0018\u0000\u00a1\u00a2\u0003&\u0013\u0000\u00a2\u0017\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a6\u0003\u001c\u000e\u0000\u00a4\u00a6\u0003"+
		"\u001a\r\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u0019\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0006"+
		"\u0000\u0000\u00a8\u00a9\u0003.\u0017\u0000\u00a9\u001b\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0005\u0006\u0000\u0000\u00ab\u00ad\u00030\u0018\u0000"+
		"\u00ac\u00ae\u0005:\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0003&\u0013\u0000\u00b0\u001d\u0001\u0000\u0000\u0000\u00b1\u00b5"+
		"\u0003$\u0012\u0000\u00b2\u00b5\u0003 \u0010\u0000\u00b3\u00b5\u0003."+
		"\u0017\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u001f\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u00032\u0019\u0000\u00b7\u00b9\u0003\"\u0011"+
		"\u0000\u00b8\u00ba\u00038\u001c\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba!\u0001\u0000\u0000\u0000\u00bb"+
		"\u00c0\u0003&\u0013\u0000\u00bc\u00c0\u0003(\u0014\u0000\u00bd\u00c0\u0003"+
		"*\u0015\u0000\u00be\u00c0\u0003,\u0016\u0000\u00bf\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bc\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0#\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c3\u00058\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u00034\u001a\u0000\u00c5%\u0001\u0000\u0000\u0000\u00c6\u00cc\u0005"+
		"\u0018\u0000\u0000\u00c7\u00cc\u00034\u001a\u0000\u00c8\u00c9\u0005\u0005"+
		"\u0000\u0000\u00c9\u00ca\u00051\u0000\u0000\u00ca\u00cc\u00052\u0000\u0000"+
		"\u00cb\u00c6\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c8\u0001\u0000\u0000\u0000\u00cc\'\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u00058\u0000\u0000\u00ce\u00cf\u0003&\u0013\u0000\u00cf)\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0005\u0003\u0000\u0000\u00d1\u00d2\u0005"+
		"3\u0000\u0000\u00d2\u00d3\u0003\"\u0011\u0000\u00d3\u00d4\u00054\u0000"+
		"\u0000\u00d4\u00d5\u0003\"\u0011\u0000\u00d5+\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\u00053\u0000\u0000\u00d7\u00d9\u00054\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00d8"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0003\"\u0011\u0000\u00dd-\u0001"+
		"\u0000\u0000\u0000\u00de\u00e0\u00030\u0018\u0000\u00df\u00e1\u0005\u0004"+
		"\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e6\u00051\u0000"+
		"\u0000\u00e3\u00e5\u0003\u001e\u000f\u0000\u00e4\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ea\u00052\u0000\u0000"+
		"\u00ea/\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005?\u0000\u0000\u00ec1"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005?\u0000\u0000\u00ee3\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f1\u00036\u001b\u0000\u00f0\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005?\u0000\u0000\u00f35\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0005?\u0000\u0000\u00f5\u00f6\u00055\u0000\u0000\u00f67\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005B\u0000\u0000\u00f89\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fb\u0003<\u001e\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0003>\u001f\u0000\u00fd;\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0005\u0007\u0000\u0000\u00ff\u0100\u0005/\u0000\u0000\u0100\u0101\u0003"+
		"P(\u0000\u0101\u0102\u00050\u0000\u0000\u0102=\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0005\n\u0000\u0000\u0104\u0105\u0003@ \u0000\u0105\u0107"+
		"\u00051\u0000\u0000\u0106\u0108\u0003B!\u0000\u0107\u0106\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u00052\u0000\u0000\u010c?\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0005?\u0000\u0000\u010eA\u0001\u0000\u0000\u0000\u010f\u0112"+
		"\u0003D\"\u0000\u0110\u0112\u0003F#\u0000\u0111\u010f\u0001\u0000\u0000"+
		"\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000"+
		"\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0116\u0003H$\u0000\u0114"+
		"\u0116\u0003J%\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0114\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0003"+
		"L&\u0000\u0118C\u0001\u0000\u0000\u0000\u0119\u011a\u0005\b\u0000\u0000"+
		"\u011a\u011b\u0005/\u0000\u0000\u011b\u011c\u0003\\.\u0000\u011c\u011d"+
		"\u00050\u0000\u0000\u011dE\u0001\u0000\u0000\u0000\u011e\u0124\u0005\b"+
		"\u0000\u0000\u011f\u0125\u0003Z-\u0000\u0120\u0121\u0005/\u0000\u0000"+
		"\u0121\u0122\u0003Z-\u0000\u0122\u0123\u00050\u0000\u0000\u0123\u0125"+
		"\u0001\u0000\u0000\u0000\u0124\u011f\u0001\u0000\u0000\u0000\u0124\u0120"+
		"\u0001\u0000\u0000\u0000\u0125G\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"\u0007\u0000\u0000\u0127\u0128\u0005/\u0000\u0000\u0128\u0129\u0003R)"+
		"\u0000\u0129\u012a\u00050\u0000\u0000\u012aI\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0005\t\u0000\u0000\u012c\u012d\u0003V+\u0000\u012dK\u0001\u0000"+
		"\u0000\u0000\u012e\u0134\u0003N\'\u0000\u012f\u0131\u0005/\u0000\u0000"+
		"\u0130\u0132\u00034\u001a\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133"+
		"\u0135\u00050\u0000\u0000\u0134\u012f\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0001\u0000\u0000\u0000\u0135\u013c\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0005\u000b\u0000\u0000\u0137\u0139\u0005/\u0000\u0000\u0138\u013a\u0003"+
		"4\u001a\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013d\u00050\u0000"+
		"\u0000\u013c\u0136\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u013f\u0001\u0000\u0000\u0000\u013e\u0140\u00056\u0000\u0000"+
		"\u013f\u013e\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000"+
		"\u0140M\u0001\u0000\u0000\u0000\u0141\u0142\u0005\u000e\u0000\u0000\u0142"+
		"\u0143\u0005-\u0000\u0000\u0143O\u0001\u0000\u0000\u0000\u0144\u0145\u0003"+
		"^/\u0000\u0145\u0149\u0005;\u0000\u0000\u0146\u014a\u0005.\u0000\u0000"+
		"\u0147\u014a\u0003T*\u0000\u0148\u014a\u0005-\u0000\u0000\u0149\u0146"+
		"\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u0148"+
		"\u0001\u0000\u0000\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0144"+
		"\u0001\u0000\u0000\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014b"+
		"\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014eQ\u0001"+
		"\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0151\u0003"+
		"^/\u0000\u0151\u0152\u0005;\u0000\u0000\u0152\u0153\u0003V+\u0000\u0153"+
		"\u0155\u0001\u0000\u0000\u0000\u0154\u0150\u0001\u0000\u0000\u0000\u0155"+
		"\u0156\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0001\u0000\u0000\u0000\u0157S\u0001\u0000\u0000\u0000\u0158\u015a"+
		"\u0005?\u0000\u0000\u0159\u015b\u00057\u0000\u0000\u015a\u0159\u0001\u0000"+
		"\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015d\u0001\u0000"+
		"\u0000\u0000\u015c\u0158\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000"+
		"\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000"+
		"\u0000\u0000\u015fU\u0001\u0000\u0000\u0000\u0160\u0161\u0005?\u0000\u0000"+
		"\u0161W\u0001\u0000\u0000\u0000\u0162\u0165\u0005A\u0000\u0000\u0163\u0164"+
		"\u0005\r\u0000\u0000\u0164\u0166\u0005?\u0000\u0000\u0165\u0163\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166Y\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0005A\u0000\u0000\u0168[\u0001\u0000\u0000\u0000"+
		"\u0169\u016a\u0003^/\u0000\u016a\u016c\u0005;\u0000\u0000\u016b\u016d"+
		"\u0005A\u0000\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016c\u016d\u0001"+
		"\u0000\u0000\u0000\u016d\u016f\u0001\u0000\u0000\u0000\u016e\u0169\u0001"+
		"\u0000\u0000\u0000\u016f\u0172\u0001\u0000\u0000\u0000\u0170\u016e\u0001"+
		"\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171]\u0001\u0000"+
		"\u0000\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0173\u0174\u0005?\u0000"+
		"\u0000\u0174_\u0001\u0000\u0000\u0000\'afhsx|\u0086\u0092\u009b\u009d"+
		"\u00a5\u00ad\u00b4\u00b9\u00bf\u00c2\u00cb\u00da\u00e0\u00e6\u00f0\u00fa"+
		"\u0109\u0111\u0115\u0124\u0131\u0134\u0139\u013c\u013f\u0149\u014d\u0156"+
		"\u015a\u015e\u0165\u016c\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}