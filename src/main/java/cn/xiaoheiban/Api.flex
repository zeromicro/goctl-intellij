package cn.xiaoheiban;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.psi.TokenType;

%%

%class ApiLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%state AFTER_HTTP_METHOD

// ---- Whitespace ----
LINE_TERMINATOR = \r|\n|\r\n
WHITE_SPACE     = [ \t\f]+

// ---- Comments ----
LINE_COMMENT    = "//" [^\r\n]*
BLOCK_COMMENT   = "/*" [^*]* ("*"+ [^*/] [^*]*)* "*"+ "/"

// ---- Numbers & Duration ----
DIGIT    = [0-9]
INT      = {DIGIT}+
DURATION = {INT} ("ns"|"us"|"µs"|"ms"|"s"|"m"|"h")

// ---- Identifiers ----
ALPHA       = [a-zA-Z]
UNDERSCORE  = "_"
IDENT       = ({ALPHA}|{UNDERSCORE})({ALPHA}|{DIGIT}|{UNDERSCORE})*

// ---- Strings ----
STRING     = \" [^\"\r\n]* \"
RAW_STRING = "`" [^`]* "`"

// ---- Path (only matched in AFTER_HTTP_METHOD state) ----
PATH_IDENT   = ({ALPHA}|{UNDERSCORE}|{DIGIT}|"-")+
PATH_SEGMENT = "/" (":"?) {PATH_IDENT}?
PATH         = {PATH_SEGMENT}+

%%

// ==============================================================
// YYINITIAL: normal context
// ==============================================================
<YYINITIAL> {

  // ---- @-keywords (must be before IDENT) ----
  "@server"       { return ApiTypes.ATSERVER; }
  "@doc"          { return ApiTypes.ATDOC; }
  "@handler"      { return ApiTypes.ATHANDLER; }

  // ---- Special composite token ----
  "interface{}"   { return ApiTypes.ANY; }

  // ---- Keywords ----
  "syntax"        { return ApiTypes.SYNTAX; }
  "info"          { return ApiTypes.INFO; }
  "map"           { return ApiTypes.MAP; }
  "struct"        { return ApiTypes.STRUCT; }
  "interface"     { return ApiTypes.INTERFACE; }
  "type"          { return ApiTypes.TYPE; }
  "returns"       { return ApiTypes.RETURNS; }
  "import"        { return ApiTypes.IMPORT; }
  "as"            { return ApiTypes.AS; }
  "service"       { return ApiTypes.SERVICE; }
  "..."           { return ApiTypes.ELLIPSIS; }

  // ---- HTTP methods → switch to PATH state ----
  "get"           { yybegin(AFTER_HTTP_METHOD); return ApiTypes.GET; }
  "head"          { yybegin(AFTER_HTTP_METHOD); return ApiTypes.HEAD; }
  "post"          { yybegin(AFTER_HTTP_METHOD); return ApiTypes.POST; }
  "put"           { yybegin(AFTER_HTTP_METHOD); return ApiTypes.PUT; }
  "patch"         { yybegin(AFTER_HTTP_METHOD); return ApiTypes.PATCH; }
  "delete"        { yybegin(AFTER_HTTP_METHOD); return ApiTypes.DELETE; }
  "connect"       { yybegin(AFTER_HTTP_METHOD); return ApiTypes.CONNECT; }
  "options"       { yybegin(AFTER_HTTP_METHOD); return ApiTypes.OPTIONS; }
  "trace"         { yybegin(AFTER_HTTP_METHOD); return ApiTypes.TRACE; }

  // ---- Symbols ----
  "("             { return ApiTypes.LPAREN; }
  ")"             { return ApiTypes.RPAREN; }
  "{"             { return ApiTypes.LBRACE; }
  "}"             { return ApiTypes.RBRACE; }
  "["             { return ApiTypes.LBRACK; }
  "]"             { return ApiTypes.RBRACK; }
  "."             { return ApiTypes.DOT; }
  ";"             { return ApiTypes.SEMICOLON; }
  ","             { return ApiTypes.COMMA; }
  "*"             { return ApiTypes.STAR; }
  "="             { return ApiTypes.ASSIGN; }
  ":"             { return ApiTypes.COLON; }
  "/"             { return ApiTypes.QUO; }
  "-"             { return ApiTypes.MINUS; }

  // ---- Composite (must be before INT and IDENT) ----
  {DURATION}      { return ApiTypes.DURATION; }
  {INT}           { return ApiTypes.INT; }
  {STRING}        { return ApiTypes.STRING; }
  {RAW_STRING}    { return ApiTypes.RAW_STRING; }
  {IDENT}         { return ApiTypes.IDENT; }

  // ---- Comments ----
  {LINE_COMMENT}  { return ApiTypes.LINE_COMMENT; }
  {BLOCK_COMMENT} { return ApiTypes.BLOCK_COMMENT; }

  // ---- Whitespace ----
  {WHITE_SPACE}       { return TokenType.WHITE_SPACE; }
  {LINE_TERMINATOR}   { return TokenType.WHITE_SPACE; }

  [^]             { return TokenType.BAD_CHARACTER; }
}

// ==============================================================
// AFTER_HTTP_METHOD: parse path tokens (/  :  IDENT  INT  -)
// Returns to YYINITIAL when non-path token encountered.
// IMPORTANT: stop-keywords must appear BEFORE {PATH_IDENT} so
// that "returns"/" @handler" etc. are not consumed as path idents.
// JFlex: equal-length match → first rule wins.
// ==============================================================
<AFTER_HTTP_METHOD> {

  {WHITE_SPACE}       { return TokenType.WHITE_SPACE; }
  {LINE_TERMINATOR}   { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

  "/"             { return ApiTypes.QUO; }
  ":"             { return ApiTypes.COLON; }
  "-"             { return ApiTypes.MINUS; }
  {INT}           { return ApiTypes.INT; }

  // ---- Stop-keywords: switch back to YYINITIAL and return correct token ----
  "returns"       { yybegin(YYINITIAL); return ApiTypes.RETURNS; }
  "@server"       { yybegin(YYINITIAL); return ApiTypes.ATSERVER; }
  "@doc"          { yybegin(YYINITIAL); return ApiTypes.ATDOC; }
  "@handler"      { yybegin(YYINITIAL); return ApiTypes.ATHANDLER; }

  // ---- Path ident (must be after stop-keywords) ----
  {PATH_IDENT}    { return ApiTypes.IDENT; }

  // anything else: push back and let YYINITIAL handle it
  [^]             { yypushback(1); yybegin(YYINITIAL); }
}
