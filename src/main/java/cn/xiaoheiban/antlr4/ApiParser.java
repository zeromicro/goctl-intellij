// Generated from /Users/anqiansong/workspace/java/goctl-intellij/src/main/java/cn/xiaoheiban/antlr4/ApiParser.g4 by ANTLR 4.8
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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INFO=1, MAP=2, STRUCT=3, INTERFACE=4, TYPE=5, ATSERVER=6, ATDOC=7, ATHANDLER=8, 
		SERVICE=9, RETURNS=10, IMPORT=11, HTTPMETHOD=12, GET=13, HEAD=14, POST=15, 
		PUT=16, PATCH=17, DELETE=18, CONNECT=19, OPTIONS=20, TRACE=21, GOTYPE=22, 
		BOOL=23, UINT8=24, UINT16=25, UINT32=26, UINT64=27, INT8=28, INT16=29, 
		INT32=30, INT64=31, FLOAT32=32, FLOAT64=33, COMPLEX64=34, COMPLEX128=35, 
		STRING=36, INT=37, UINT=38, UINTPTR=39, BYTE=40, RUNE=41, TIME=42, PATH=43, 
		LPAREN=44, RPAREN=45, LBRACE=46, RBRACE=47, LBRACK=48, RBRACK=49, DOT=50, 
		SMICOLON=51, COMMA=52, STAR=53, BAR=54, ASSIGN=55, COLON=56, NUMBER=57, 
		HOSTVALUE=58, IDENT=59, WS=60, VALUE=61, RAW_STRING=62, COMMENT=63, ERRCHAR=64;
	public static final int
		RULE_api = 0, RULE_apiBody = 1, RULE_importStatement = 2, RULE_importSpec = 3, 
		RULE_infoStatement = 4, RULE_typeStatement = 5, RULE_typeGroupSpec = 6, 
		RULE_typeGroupBody = 7, RULE_typeGroupAlias = 8, RULE_typeSingleSpec = 9, 
		RULE_typeStruct = 10, RULE_typeAlias = 11, RULE_typeFiled = 12, RULE_normalField = 13, 
		RULE_fieldType = 14, RULE_anonymousField = 15, RULE_normalFieldType = 16, 
		RULE_starFieldType = 17, RULE_mapFieldType = 18, RULE_arrayOrSliceType = 19, 
		RULE_structType = 20, RULE_objType = 21, RULE_structNameId = 22, RULE_fieldName = 23, 
		RULE_referenceId = 24, RULE_tag = 25, RULE_serviceStatement = 26, RULE_serviceServerSpec = 27, 
		RULE_serviceSpec = 28, RULE_serviceName = 29, RULE_serviceBody = 30, RULE_serviceDoc = 31, 
		RULE_serviceDocNew = 32, RULE_serviceHandler = 33, RULE_serviceHandlerNew = 34, 
		RULE_serviceRoute = 35, RULE_httpRoute = 36, RULE_identPair = 37, RULE_handlerPair = 38, 
		RULE_identValue = 39, RULE_handlerValue = 40, RULE_importValue = 41, RULE_docValue = 42, 
		RULE_pair = 43, RULE_key = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"api", "apiBody", "importStatement", "importSpec", "infoStatement", "typeStatement", 
			"typeGroupSpec", "typeGroupBody", "typeGroupAlias", "typeSingleSpec", 
			"typeStruct", "typeAlias", "typeFiled", "normalField", "fieldType", "anonymousField", 
			"normalFieldType", "starFieldType", "mapFieldType", "arrayOrSliceType", 
			"structType", "objType", "structNameId", "fieldName", "referenceId", 
			"tag", "serviceStatement", "serviceServerSpec", "serviceSpec", "serviceName", 
			"serviceBody", "serviceDoc", "serviceDocNew", "serviceHandler", "serviceHandlerNew", 
			"serviceRoute", "httpRoute", "identPair", "handlerPair", "identValue", 
			"handlerValue", "importValue", "docValue", "pair", "key"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'info'", "'map'", "'struct'", "'interface'", "'type'", "'@server'", 
			"'@doc'", "'@handler'", "'service'", "'returns'", "'import'", null, "'get'", 
			"'head'", "'post'", "'put'", "'patch'", "'delete'", "'connect'", "'options'", 
			"'trace'", null, "'bool'", "'uint8'", "'uint16'", "'uint32'", "'uint64'", 
			"'int8'", "'int16'", "'int32'", "'int64'", "'float32'", "'float64'", 
			"'complex64'", "'complex128'", "'string'", "'int'", "'uint'", "'uintptr'", 
			"'byte'", "'rune'", "'time.Time'", null, "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "'.'", "';'", "','", "'*'", "'-'", "'='", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INFO", "MAP", "STRUCT", "INTERFACE", "TYPE", "ATSERVER", "ATDOC", 
			"ATHANDLER", "SERVICE", "RETURNS", "IMPORT", "HTTPMETHOD", "GET", "HEAD", 
			"POST", "PUT", "PATCH", "DELETE", "CONNECT", "OPTIONS", "TRACE", "GOTYPE", 
			"BOOL", "UINT8", "UINT16", "UINT32", "UINT64", "INT8", "INT16", "INT32", 
			"INT64", "FLOAT32", "FLOAT64", "COMPLEX64", "COMPLEX128", "STRING", "INT", 
			"UINT", "UINTPTR", "BYTE", "RUNE", "TIME", "PATH", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "DOT", "SMICOLON", "COMMA", "STAR", 
			"BAR", "ASSIGN", "COLON", "NUMBER", "HOSTVALUE", "IDENT", "WS", "VALUE", 
			"RAW_STRING", "COMMENT", "ERRCHAR"
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
	}

	public final ApiContext api() throws RecognitionException {
		ApiContext _localctx = new ApiContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_api);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INFO) | (1L << TYPE) | (1L << ATSERVER) | (1L << SERVICE) | (1L << IMPORT))) != 0)) {
				{
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IMPORT:
					{
					setState(90);
					importStatement();
					}
					break;
				case INFO:
					{
					setState(91);
					infoStatement();
					}
					break;
				case TYPE:
				case ATSERVER:
				case SERVICE:
					{
					setState(92);
					apiBody();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
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
	}

	public final ApiBodyContext apiBody() throws RecognitionException {
		ApiBodyContext _localctx = new ApiBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_apiBody);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				typeStatement();
				}
				break;
			case ATSERVER:
			case SERVICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
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
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(104);
					importSpec();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(107); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public TerminalNode IMPORT() { return getToken(ApiParser.IMPORT, 0); }
		public ImportValueContext importValue() {
			return getRuleContext(ImportValueContext.class,0);
		}
		public ImportSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpec; }
	}

	public final ImportSpecContext importSpec() throws RecognitionException {
		ImportSpecContext _localctx = new ImportSpecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(IMPORT);
			setState(110);
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
	}

	public final InfoStatementContext infoStatement() throws RecognitionException {
		InfoStatementContext _localctx = new InfoStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_infoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(INFO);
			setState(113);
			match(LPAREN);
			setState(114);
			pair();
			setState(115);
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
	}

	public final TypeStatementContext typeStatement() throws RecognitionException {
		TypeStatementContext _localctx = new TypeStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(117);
				typeSingleSpec();
				}
				break;
			case 2:
				{
				setState(118);
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
	}

	public final TypeGroupSpecContext typeGroupSpec() throws RecognitionException {
		TypeGroupSpecContext _localctx = new TypeGroupSpecContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeGroupSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TYPE);
			setState(122);
			match(LPAREN);
			setState(123);
			typeGroupBody();
			setState(124);
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
	}

	public final TypeGroupBodyContext typeGroupBody() throws RecognitionException {
		TypeGroupBodyContext _localctx = new TypeGroupBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeGroupBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				setState(128);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(126);
					typeGroupAlias();
					}
					break;
				case 2:
					{
					setState(127);
					structType();
					}
					break;
				}
				}
				setState(132);
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
	}

	public final TypeGroupAliasContext typeGroupAlias() throws RecognitionException {
		TypeGroupAliasContext _localctx = new TypeGroupAliasContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeGroupAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			structNameId();
			setState(134);
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
	}

	public final TypeSingleSpecContext typeSingleSpec() throws RecognitionException {
		TypeSingleSpecContext _localctx = new TypeSingleSpecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeSingleSpec);
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				typeAlias();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
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
	}

	public final TypeStructContext typeStruct() throws RecognitionException {
		TypeStructContext _localctx = new TypeStructContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(TYPE);
			setState(141);
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
	}

	public final TypeAliasContext typeAlias() throws RecognitionException {
		TypeAliasContext _localctx = new TypeAliasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(TYPE);
			setState(144);
			structNameId();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(145);
				match(ASSIGN);
				}
			}

			setState(148);
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
	}

	public final TypeFiledContext typeFiled() throws RecognitionException {
		TypeFiledContext _localctx = new TypeFiledContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeFiled);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				anonymousField();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				normalField();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
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
	}

	public final NormalFieldContext normalField() throws RecognitionException {
		NormalFieldContext _localctx = new NormalFieldContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_normalField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			fieldName();
			setState(156);
			fieldType();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_STRING) {
				{
				setState(157);
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
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fieldType);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTERFACE:
			case GOTYPE:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				normalFieldType();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				starFieldType();
				}
				break;
			case MAP:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				mapFieldType();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
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
	}

	public final AnonymousFieldContext anonymousField() throws RecognitionException {
		AnonymousFieldContext _localctx = new AnonymousFieldContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_anonymousField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(166);
				match(STAR);
				}
			}

			setState(169);
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
	}

	public final NormalFieldTypeContext normalFieldType() throws RecognitionException {
		NormalFieldTypeContext _localctx = new NormalFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_normalFieldType);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(GOTYPE);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				referenceId();
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(173);
				match(INTERFACE);
				setState(174);
				match(LBRACE);
				setState(175);
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
	}

	public final StarFieldTypeContext starFieldType() throws RecognitionException {
		StarFieldTypeContext _localctx = new StarFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_starFieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(STAR);
			setState(179);
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
		public TerminalNode GOTYPE() { return getToken(ApiParser.GOTYPE, 0); }
		public TerminalNode RBRACK() { return getToken(ApiParser.RBRACK, 0); }
		public ObjTypeContext objType() {
			return getRuleContext(ObjTypeContext.class,0);
		}
		public MapFieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapFieldType; }
	}

	public final MapFieldTypeContext mapFieldType() throws RecognitionException {
		MapFieldTypeContext _localctx = new MapFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mapFieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(MAP);
			setState(182);
			match(LBRACK);
			setState(183);
			match(GOTYPE);
			setState(184);
			match(RBRACK);
			setState(185);
			objType();
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
		public ObjTypeContext objType() {
			return getRuleContext(ObjTypeContext.class,0);
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
	}

	public final ArrayOrSliceTypeContext arrayOrSliceType() throws RecognitionException {
		ArrayOrSliceTypeContext _localctx = new ArrayOrSliceTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arrayOrSliceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(187);
				match(LBRACK);
				setState(188);
				match(RBRACK);
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACK );
			setState(193);
			objType();
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
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_structType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			structNameId();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCT) {
				{
				setState(196);
				match(STRUCT);
				}
			}

			setState(199);
			match(LBRACE);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR || _la==IDENT) {
				{
				{
				setState(200);
				typeFiled();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
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

	public static class ObjTypeContext extends ParserRuleContext {
		public NormalFieldTypeContext normalFieldType() {
			return getRuleContext(NormalFieldTypeContext.class,0);
		}
		public StarFieldTypeContext starFieldType() {
			return getRuleContext(StarFieldTypeContext.class,0);
		}
		public ObjTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objType; }
	}

	public final ObjTypeContext objType() throws RecognitionException {
		ObjTypeContext _localctx = new ObjTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_objType);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTERFACE:
			case GOTYPE:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				normalFieldType();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				starFieldType();
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

	public static class StructNameIdContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public StructNameIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structNameId; }
	}

	public final StructNameIdContext structNameId() throws RecognitionException {
		StructNameIdContext _localctx = new StructNameIdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_structNameId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		public ReferenceIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceId; }
	}

	public final ReferenceIdContext referenceId() throws RecognitionException {
		ReferenceIdContext _localctx = new ReferenceIdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_referenceId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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

	public static class TagContext extends ParserRuleContext {
		public TerminalNode RAW_STRING() { return getToken(ApiParser.RAW_STRING, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
	}

	public final ServiceStatementContext serviceStatement() throws RecognitionException {
		ServiceStatementContext _localctx = new ServiceStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_serviceStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATSERVER) {
				{
				setState(220);
				serviceServerSpec();
				}
			}

			setState(223);
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
	}

	public final ServiceServerSpecContext serviceServerSpec() throws RecognitionException {
		ServiceServerSpecContext _localctx = new ServiceServerSpecContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_serviceServerSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ATSERVER);
			setState(226);
			match(LPAREN);
			setState(227);
			identPair();
			setState(228);
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
	}

	public final ServiceSpecContext serviceSpec() throws RecognitionException {
		ServiceSpecContext _localctx = new ServiceSpecContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_serviceSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(SERVICE);
			setState(231);
			serviceName();
			setState(232);
			match(LBRACE);
			setState(234); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(233);
				serviceBody();
				}
				}
				setState(236); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATSERVER) | (1L << ATDOC) | (1L << ATHANDLER))) != 0) );
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

	public static class ServiceNameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ApiParser.IDENT, 0); }
		public ServiceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceName; }
	}

	public final ServiceNameContext serviceName() throws RecognitionException {
		ServiceNameContext _localctx = new ServiceNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_serviceName);
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
	}

	public final ServiceBodyContext serviceBody() throws RecognitionException {
		ServiceBodyContext _localctx = new ServiceBodyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_serviceBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(242);
				serviceDoc();
				}
				break;
			case 2:
				{
				setState(243);
				serviceDocNew();
				}
				break;
			}
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATSERVER:
				{
				setState(246);
				serviceHandler();
				}
				break;
			case ATHANDLER:
				{
				setState(247);
				serviceHandlerNew();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(250);
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
	}

	public final ServiceDocContext serviceDoc() throws RecognitionException {
		ServiceDocContext _localctx = new ServiceDocContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_serviceDoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(ATDOC);
			setState(253);
			match(LPAREN);
			setState(254);
			pair();
			setState(255);
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
		public ServiceDocNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceDocNew; }
	}

	public final ServiceDocNewContext serviceDocNew() throws RecognitionException {
		ServiceDocNewContext _localctx = new ServiceDocNewContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_serviceDocNew);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(ATDOC);
			setState(258);
			docValue();
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
	}

	public final ServiceHandlerContext serviceHandler() throws RecognitionException {
		ServiceHandlerContext _localctx = new ServiceHandlerContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_serviceHandler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(ATSERVER);
			setState(261);
			match(LPAREN);
			setState(262);
			handlerPair();
			setState(263);
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
	}

	public final ServiceHandlerNewContext serviceHandlerNew() throws RecognitionException {
		ServiceHandlerNewContext _localctx = new ServiceHandlerNewContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_serviceHandlerNew);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(ATHANDLER);
			setState(266);
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
	}

	public final ServiceRouteContext serviceRoute() throws RecognitionException {
		ServiceRouteContext _localctx = new ServiceRouteContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_serviceRoute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			httpRoute();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(269);
				match(LPAREN);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(270);
					referenceId();
					}
				}

				setState(273);
				match(RPAREN);
				}
			}

			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(276);
				match(RETURNS);
				setState(277);
				match(LPAREN);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(278);
					referenceId();
					}
				}

				setState(281);
				match(RPAREN);
				}
			}

			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SMICOLON) {
				{
				setState(284);
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
	}

	public final HttpRouteContext httpRoute() throws RecognitionException {
		HttpRouteContext _localctx = new HttpRouteContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_httpRoute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(HTTPMETHOD);
			setState(288);
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
		public List<IdentValueContext> identValue() {
			return getRuleContexts(IdentValueContext.class);
		}
		public IdentValueContext identValue(int i) {
			return getRuleContext(IdentValueContext.class,i);
		}
		public IdentPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identPair; }
	}

	public final IdentPairContext identPair() throws RecognitionException {
		IdentPairContext _localctx = new IdentPairContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_identPair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(290);
				key();
				setState(291);
				match(COLON);
				setState(292);
				identValue();
				}
				}
				setState(298);
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
	}

	public final HandlerPairContext handlerPair() throws RecognitionException {
		HandlerPairContext _localctx = new HandlerPairContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_handlerPair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(299);
				key();
				setState(300);
				match(COLON);
				setState(301);
				handlerValue();
				}
				}
				setState(305); 
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
	}

	public final IdentValueContext identValue() throws RecognitionException {
		IdentValueContext _localctx = new IdentValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_identValue);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(307);
					match(IDENT);
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(308);
						match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(313); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
	}

	public final HandlerValueContext handlerValue() throws RecognitionException {
		HandlerValueContext _localctx = new HandlerValueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_handlerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
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
		public ImportValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importValue; }
	}

	public final ImportValueContext importValue() throws RecognitionException {
		ImportValueContext _localctx = new ImportValueContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_importValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
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

	public static class DocValueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(ApiParser.VALUE, 0); }
		public DocValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_docValue; }
	}

	public final DocValueContext docValue() throws RecognitionException {
		DocValueContext _localctx = new DocValueContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_docValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
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
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(321);
				key();
				setState(322);
				match(COLON);
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VALUE) {
					{
					setState(323);
					match(VALUE);
					}
				}

				}
				}
				setState(330);
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
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u0150\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\3\2\3\3\3\3\5"+
		"\3i\n\3\3\4\6\4l\n\4\r\4\16\4m\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\5\7z\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\t\u0083\n\t\f\t\16\t\u0086\13"+
		"\t\3\n\3\n\3\n\3\13\3\13\5\13\u008d\n\13\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u0095"+
		"\n\r\3\r\3\r\3\16\3\16\3\16\5\16\u009c\n\16\3\17\3\17\3\17\5\17\u00a1"+
		"\n\17\3\20\3\20\3\20\3\20\5\20\u00a7\n\20\3\21\5\21\u00aa\n\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\5\22\u00b3\n\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\6\25\u00c0\n\25\r\25\16\25\u00c1\3\25\3"+
		"\25\3\26\3\26\5\26\u00c8\n\26\3\26\3\26\7\26\u00cc\n\26\f\26\16\26\u00cf"+
		"\13\26\3\26\3\26\3\27\3\27\5\27\u00d5\n\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\5\34\u00e0\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\6\36\u00ed\n\36\r\36\16\36\u00ee\3\36\3\36\3\37\3"+
		"\37\3 \3 \5 \u00f7\n \3 \3 \5 \u00fb\n \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\5%\u0112\n%\3%\5%\u0115\n%\3%\3%\3"+
		"%\5%\u011a\n%\3%\5%\u011d\n%\3%\5%\u0120\n%\3&\3&\3&\3\'\3\'\3\'\3\'\7"+
		"\'\u0129\n\'\f\'\16\'\u012c\13\'\3(\3(\3(\3(\6(\u0132\n(\r(\16(\u0133"+
		"\3)\3)\5)\u0138\n)\6)\u013a\n)\r)\16)\u013b\3*\3*\3+\3+\3,\3,\3-\3-\3"+
		"-\5-\u0147\n-\7-\u0149\n-\f-\16-\u014c\13-\3.\3.\3.\2\2/\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2\2\2"+
		"\u0149\2a\3\2\2\2\4h\3\2\2\2\6k\3\2\2\2\bo\3\2\2\2\nr\3\2\2\2\fy\3\2\2"+
		"\2\16{\3\2\2\2\20\u0084\3\2\2\2\22\u0087\3\2\2\2\24\u008c\3\2\2\2\26\u008e"+
		"\3\2\2\2\30\u0091\3\2\2\2\32\u009b\3\2\2\2\34\u009d\3\2\2\2\36\u00a6\3"+
		"\2\2\2 \u00a9\3\2\2\2\"\u00b2\3\2\2\2$\u00b4\3\2\2\2&\u00b7\3\2\2\2(\u00bf"+
		"\3\2\2\2*\u00c5\3\2\2\2,\u00d4\3\2\2\2.\u00d6\3\2\2\2\60\u00d8\3\2\2\2"+
		"\62\u00da\3\2\2\2\64\u00dc\3\2\2\2\66\u00df\3\2\2\28\u00e3\3\2\2\2:\u00e8"+
		"\3\2\2\2<\u00f2\3\2\2\2>\u00f6\3\2\2\2@\u00fe\3\2\2\2B\u0103\3\2\2\2D"+
		"\u0106\3\2\2\2F\u010b\3\2\2\2H\u010e\3\2\2\2J\u0121\3\2\2\2L\u012a\3\2"+
		"\2\2N\u0131\3\2\2\2P\u0139\3\2\2\2R\u013d\3\2\2\2T\u013f\3\2\2\2V\u0141"+
		"\3\2\2\2X\u014a\3\2\2\2Z\u014d\3\2\2\2\\`\5\6\4\2]`\5\n\6\2^`\5\4\3\2"+
		"_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2"+
		"\2ca\3\2\2\2de\7\2\2\3e\3\3\2\2\2fi\5\f\7\2gi\5\66\34\2hf\3\2\2\2hg\3"+
		"\2\2\2i\5\3\2\2\2jl\5\b\5\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\7"+
		"\3\2\2\2op\7\r\2\2pq\5T+\2q\t\3\2\2\2rs\7\3\2\2st\7.\2\2tu\5X-\2uv\7/"+
		"\2\2v\13\3\2\2\2wz\5\24\13\2xz\5\16\b\2yw\3\2\2\2yx\3\2\2\2z\r\3\2\2\2"+
		"{|\7\7\2\2|}\7.\2\2}~\5\20\t\2~\177\7/\2\2\177\17\3\2\2\2\u0080\u0083"+
		"\5\22\n\2\u0081\u0083\5*\26\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2"+
		"\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\21"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\5.\30\2\u0088\u0089\5\"\22\2"+
		"\u0089\23\3\2\2\2\u008a\u008d\5\30\r\2\u008b\u008d\5\26\f\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008b\3\2\2\2\u008d\25\3\2\2\2\u008e\u008f\7\7\2\2\u008f"+
		"\u0090\5*\26\2\u0090\27\3\2\2\2\u0091\u0092\7\7\2\2\u0092\u0094\5.\30"+
		"\2\u0093\u0095\79\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0097\5\"\22\2\u0097\31\3\2\2\2\u0098\u009c\5 \21\2\u0099"+
		"\u009c\5\34\17\2\u009a\u009c\5*\26\2\u009b\u0098\3\2\2\2\u009b\u0099\3"+
		"\2\2\2\u009b\u009a\3\2\2\2\u009c\33\3\2\2\2\u009d\u009e\5\60\31\2\u009e"+
		"\u00a0\5\36\20\2\u009f\u00a1\5\64\33\2\u00a0\u009f\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a7\5\"\22\2\u00a3\u00a7\5$\23\2\u00a4"+
		"\u00a7\5&\24\2\u00a5\u00a7\5(\25\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\37\3\2\2\2\u00a8\u00aa"+
		"\7\67\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2"+
		"\u00ab\u00ac\5\62\32\2\u00ac!\3\2\2\2\u00ad\u00b3\7\30\2\2\u00ae\u00b3"+
		"\5\62\32\2\u00af\u00b0\7\6\2\2\u00b0\u00b1\7\60\2\2\u00b1\u00b3\7\61\2"+
		"\2\u00b2\u00ad\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3#"+
		"\3\2\2\2\u00b4\u00b5\7\67\2\2\u00b5\u00b6\5\"\22\2\u00b6%\3\2\2\2\u00b7"+
		"\u00b8\7\4\2\2\u00b8\u00b9\7\62\2\2\u00b9\u00ba\7\30\2\2\u00ba\u00bb\7"+
		"\63\2\2\u00bb\u00bc\5,\27\2\u00bc\'\3\2\2\2\u00bd\u00be\7\62\2\2\u00be"+
		"\u00c0\7\63\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\5,\27\2\u00c4"+
		")\3\2\2\2\u00c5\u00c7\5.\30\2\u00c6\u00c8\7\5\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cd\7\60\2\2\u00ca\u00cc"+
		"\5\32\16\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2"+
		"\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1"+
		"\7\61\2\2\u00d1+\3\2\2\2\u00d2\u00d5\5\"\22\2\u00d3\u00d5\5$\23\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5-\3\2\2\2\u00d6\u00d7\7=\2\2\u00d7"+
		"/\3\2\2\2\u00d8\u00d9\7=\2\2\u00d9\61\3\2\2\2\u00da\u00db\7=\2\2\u00db"+
		"\63\3\2\2\2\u00dc\u00dd\7@\2\2\u00dd\65\3\2\2\2\u00de\u00e0\58\35\2\u00df"+
		"\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\5:"+
		"\36\2\u00e2\67\3\2\2\2\u00e3\u00e4\7\b\2\2\u00e4\u00e5\7.\2\2\u00e5\u00e6"+
		"\5L\'\2\u00e6\u00e7\7/\2\2\u00e79\3\2\2\2\u00e8\u00e9\7\13\2\2\u00e9\u00ea"+
		"\5<\37\2\u00ea\u00ec\7\60\2\2\u00eb\u00ed\5> \2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f1\7\61\2\2\u00f1;\3\2\2\2\u00f2\u00f3\7=\2\2\u00f3=\3\2"+
		"\2\2\u00f4\u00f7\5@!\2\u00f5\u00f7\5B\"\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00fb\5D#\2\u00f9"+
		"\u00fb\5F$\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2"+
		"\2\u00fc\u00fd\5H%\2\u00fd?\3\2\2\2\u00fe\u00ff\7\t\2\2\u00ff\u0100\7"+
		".\2\2\u0100\u0101\5X-\2\u0101\u0102\7/\2\2\u0102A\3\2\2\2\u0103\u0104"+
		"\7\t\2\2\u0104\u0105\5V,\2\u0105C\3\2\2\2\u0106\u0107\7\b\2\2\u0107\u0108"+
		"\7.\2\2\u0108\u0109\5N(\2\u0109\u010a\7/\2\2\u010aE\3\2\2\2\u010b\u010c"+
		"\7\n\2\2\u010c\u010d\5R*\2\u010dG\3\2\2\2\u010e\u0114\5J&\2\u010f\u0111"+
		"\7.\2\2\u0110\u0112\5\62\32\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2"+
		"\u0112\u0113\3\2\2\2\u0113\u0115\7/\2\2\u0114\u010f\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u011c\3\2\2\2\u0116\u0117\7\f\2\2\u0117\u0119\7.\2\2\u0118"+
		"\u011a\5\62\32\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3"+
		"\2\2\2\u011b\u011d\7/\2\2\u011c\u0116\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011f\3\2\2\2\u011e\u0120\7\65\2\2\u011f\u011e\3\2\2\2\u011f\u0120\3"+
		"\2\2\2\u0120I\3\2\2\2\u0121\u0122\7\16\2\2\u0122\u0123\7-\2\2\u0123K\3"+
		"\2\2\2\u0124\u0125\5Z.\2\u0125\u0126\7:\2\2\u0126\u0127\5P)\2\u0127\u0129"+
		"\3\2\2\2\u0128\u0124\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012bM\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\5Z.\2\u012e"+
		"\u012f\7:\2\2\u012f\u0130\5R*\2\u0130\u0132\3\2\2\2\u0131\u012d\3\2\2"+
		"\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134O"+
		"\3\2\2\2\u0135\u0137\7=\2\2\u0136\u0138\7\66\2\2\u0137\u0136\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0135\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013cQ\3\2\2\2\u013d\u013e"+
		"\7=\2\2\u013eS\3\2\2\2\u013f\u0140\7?\2\2\u0140U\3\2\2\2\u0141\u0142\7"+
		"?\2\2\u0142W\3\2\2\2\u0143\u0144\5Z.\2\u0144\u0146\7:\2\2\u0145\u0147"+
		"\7?\2\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u0143\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014bY\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7=\2\2\u014e[\3\2"+
		"\2\2#_ahmy\u0082\u0084\u008c\u0094\u009b\u00a0\u00a6\u00a9\u00b2\u00c1"+
		"\u00c7\u00cd\u00d4\u00df\u00ee\u00f6\u00fa\u0111\u0114\u0119\u011c\u011f"+
		"\u012a\u0133\u0137\u013b\u0146\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}