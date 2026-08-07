// This is a generated file. Not intended for manual editing.
package cn.xiaoheiban.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static cn.xiaoheiban.psi.ApiTypes.*;
import static cn.xiaoheiban.psi.impl.ApiParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ApiParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return api(b, l + 1);
  }

  /* ********************************************************** */
  // '*' IDENT tag?
  static boolean anonField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonField")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STAR, IDENT);
    r = r && anonField_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tag?
  private static boolean anonField_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonField_2")) return false;
    tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'interface{}'
  public static boolean anyType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyType")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANY);
    exit_section_(b, m, ANY_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // syntaxLit? (importStatement | infoStatement | typeStatement | serviceStatement)* <<eof>>
  static boolean api(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "api")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = api_0(b, l + 1);
    r = r && api_1(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // syntaxLit?
  private static boolean api_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "api_0")) return false;
    syntaxLit(b, l + 1);
    return true;
  }

  // (importStatement | infoStatement | typeStatement | serviceStatement)*
  private static boolean api_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "api_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!api_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "api_1", c)) break;
    }
    return true;
  }

  // importStatement | infoStatement | typeStatement | serviceStatement
  private static boolean api_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "api_1_0")) return false;
    boolean r;
    r = importStatement(b, l + 1);
    if (!r) r = infoStatement(b, l + 1);
    if (!r) r = typeStatement(b, l + 1);
    if (!r) r = serviceStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '[' (INT | '...') ']' dataType
  public static boolean arrayDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDataType")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && arrayDataType_1(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, ARRAY_DATA_TYPE, r);
    return r;
  }

  // INT | '...'
  private static boolean arrayDataType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDataType_1")) return false;
    boolean r;
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, ELLIPSIS);
    return r;
  }

  /* ********************************************************** */
  // '@doc' (STRING | ('(' kvPair* ')'))
  public static boolean atDocClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atDocClause")) return false;
    if (!nextTokenIs(b, ATDOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATDOC);
    r = r && atDocClause_1(b, l + 1);
    exit_section_(b, m, AT_DOC_CLAUSE, r);
    return r;
  }

  // STRING | ('(' kvPair* ')')
  private static boolean atDocClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atDocClause_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    if (!r) r = atDocClause_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' kvPair* ')'
  private static boolean atDocClause_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atDocClause_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && atDocClause_1_1_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // kvPair*
  private static boolean atDocClause_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atDocClause_1_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!kvPair(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atDocClause_1_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '@handler' IDENT
  public static boolean atHandlerClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atHandlerClause")) return false;
    if (!nextTokenIs(b, ATHANDLER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ATHANDLER, IDENT);
    exit_section_(b, m, AT_HANDLER_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // '@server' '(' atServerKvPair* ')'
  public static boolean atServerBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerBlock")) return false;
    if (!nextTokenIs(b, ATSERVER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ATSERVER, LPAREN);
    r = r && atServerBlock_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, AT_SERVER_BLOCK, r);
    return r;
  }

  // atServerKvPair*
  private static boolean atServerBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atServerKvPair(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atServerBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENT ':' atServerValue
  public static boolean atServerKvPair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerKvPair")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && atServerValue(b, l + 1);
    exit_section_(b, m, AT_SERVER_KV_PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // '/' IDENT ('-' IDENT)* ('/' IDENT ('-' IDENT)*)*
  public static boolean atServerPathValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue")) return false;
    if (!nextTokenIs(b, QUO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, QUO, IDENT);
    r = r && atServerPathValue_2(b, l + 1);
    r = r && atServerPathValue_3(b, l + 1);
    exit_section_(b, m, AT_SERVER_PATH_VALUE, r);
    return r;
  }

  // ('-' IDENT)*
  private static boolean atServerPathValue_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atServerPathValue_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atServerPathValue_2", c)) break;
    }
    return true;
  }

  // '-' IDENT
  private static boolean atServerPathValue_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MINUS, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('/' IDENT ('-' IDENT)*)*
  private static boolean atServerPathValue_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atServerPathValue_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atServerPathValue_3", c)) break;
    }
    return true;
  }

  // '/' IDENT ('-' IDENT)*
  private static boolean atServerPathValue_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, QUO, IDENT);
    r = r && atServerPathValue_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('-' IDENT)*
  private static boolean atServerPathValue_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue_3_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atServerPathValue_3_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atServerPathValue_3_0_2", c)) break;
    }
    return true;
  }

  // '-' IDENT
  private static boolean atServerPathValue_3_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerPathValue_3_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MINUS, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atServerPathValue
  //                 | DURATION
  //                 | INT
  //                 | STRING
  //                 | IDENT ((',' | '-') IDENT)*
  public static boolean atServerValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AT_SERVER_VALUE, "<at server value>");
    r = atServerPathValue(b, l + 1);
    if (!r) r = consumeToken(b, DURATION);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = atServerValue_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENT ((',' | '-') IDENT)*
  private static boolean atServerValue_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerValue_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && atServerValue_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((',' | '-') IDENT)*
  private static boolean atServerValue_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerValue_4_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atServerValue_4_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atServerValue_4_1", c)) break;
    }
    return true;
  }

  // (',' | '-') IDENT
  private static boolean atServerValue_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerValue_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atServerValue_4_1_0_0(b, l + 1);
    r = r && consumeToken(b, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' | '-'
  private static boolean atServerValue_4_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atServerValue_4_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // IDENT ('.' IDENT)?
  public static boolean baseDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baseDataType")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && baseDataType_1(b, l + 1);
    exit_section_(b, m, BASE_DATA_TYPE, r);
    return r;
  }

  // ('.' IDENT)?
  private static boolean baseDataType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baseDataType_1")) return false;
    baseDataType_1_0(b, l + 1);
    return true;
  }

  // '.' IDENT
  private static boolean baseDataType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baseDataType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' bodyExpr? ')'
  public static boolean bodyClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyClause")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && bodyClause_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, BODY_CLAUSE, r);
    return r;
  }

  // bodyExpr?
  private static boolean bodyClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyClause_1")) return false;
    bodyExpr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('[' ']')? '*'? IDENT
  public static boolean bodyExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_EXPR, "<body expr>");
    r = bodyExpr_0(b, l + 1);
    r = r && bodyExpr_1(b, l + 1);
    r = r && consumeToken(b, IDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('[' ']')?
  private static boolean bodyExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyExpr_0")) return false;
    bodyExpr_0_0(b, l + 1);
    return true;
  }

  // '[' ']'
  private static boolean bodyExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyExpr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACK, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // '*'?
  private static boolean bodyExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyExpr_1")) return false;
    consumeToken(b, STAR);
    return true;
  }

  /* ********************************************************** */
  // anyType
  //            | structDataType
  //            | mapDataType
  //            | arrayDataType
  //            | sliceDataType
  //            | pointerDataType
  //            | baseDataType
  public static boolean dataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_TYPE, "<data type>");
    r = anyType(b, l + 1);
    if (!r) r = structDataType(b, l + 1);
    if (!r) r = mapDataType(b, l + 1);
    if (!r) r = arrayDataType(b, l + 1);
    if (!r) r = sliceDataType(b, l + 1);
    if (!r) r = pointerDataType(b, l + 1);
    if (!r) r = baseDataType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // anonField | namedField
  public static boolean elemExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elemExpr")) return false;
    if (!nextTokenIs(b, "<elem expr>", IDENT, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEM_EXPR, "<elem expr>");
    r = anonField(b, l + 1);
    if (!r) r = namedField(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'get' | 'head' | 'post' | 'put' | 'patch' | 'delete' | 'connect' | 'options' | 'trace'
  public static boolean httpMethod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpMethod")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTTP_METHOD, "<http method>");
    r = consumeToken(b, GET);
    if (!r) r = consumeToken(b, HEAD);
    if (!r) r = consumeToken(b, POST);
    if (!r) r = consumeToken(b, PUT);
    if (!r) r = consumeToken(b, PATCH);
    if (!r) r = consumeToken(b, DELETE);
    if (!r) r = consumeToken(b, CONNECT);
    if (!r) r = consumeToken(b, OPTIONS);
    if (!r) r = consumeToken(b, TRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'import' '(' importValue* ')'
  public static boolean importGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importGroup")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, LPAREN);
    r = r && importGroup_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, IMPORT_GROUP, r);
    return r;
  }

  // importValue*
  private static boolean importGroup_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importGroup_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!importValue(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "importGroup_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'import' importValue
  public static boolean importLit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importLit")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && importValue(b, l + 1);
    exit_section_(b, m, IMPORT_LIT, r);
    return r;
  }

  /* ********************************************************** */
  // importLit | importGroup
  public static boolean importStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importStatement")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = importLit(b, l + 1);
    if (!r) r = importGroup(b, l + 1);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // STRING ('as' IDENT)?
  public static boolean importValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importValue")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && importValue_1(b, l + 1);
    exit_section_(b, m, IMPORT_VALUE, r);
    return r;
  }

  // ('as' IDENT)?
  private static boolean importValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importValue_1")) return false;
    importValue_1_0(b, l + 1);
    return true;
  }

  // 'as' IDENT
  private static boolean importValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'info' '(' kvPair* ')'
  public static boolean infoStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infoStatement")) return false;
    if (!nextTokenIs(b, INFO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INFO, LPAREN);
    r = r && infoStatement_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, INFO_STATEMENT, r);
    return r;
  }

  // kvPair*
  private static boolean infoStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infoStatement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!kvPair(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infoStatement_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENT ':' (STRING | RAW_STRING | IDENT)?
  public static boolean kvPair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kvPair")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && kvPair_2(b, l + 1);
    exit_section_(b, m, KV_PAIR, r);
    return r;
  }

  // (STRING | RAW_STRING | IDENT)?
  private static boolean kvPair_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kvPair_2")) return false;
    kvPair_2_0(b, l + 1);
    return true;
  }

  // STRING | RAW_STRING | IDENT
  private static boolean kvPair_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kvPair_2_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, RAW_STRING);
    if (!r) r = consumeToken(b, IDENT);
    return r;
  }

  /* ********************************************************** */
  // 'map' '[' dataType ']' dataType
  public static boolean mapDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapDataType")) return false;
    if (!nextTokenIs(b, MAP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MAP, LBRACK);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, MAP_DATA_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT (',' IDENT)* dataType tag?
  static boolean namedField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedField")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && namedField_1(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && namedField_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENT)*
  private static boolean namedField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedField_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namedField_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namedField_1", c)) break;
    }
    return true;
  }

  // ',' IDENT
  private static boolean namedField_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedField_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // tag?
  private static boolean namedField_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedField_3")) return false;
    tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // pathSegment+
  public static boolean pathExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathExpr")) return false;
    if (!nextTokenIs(b, QUO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pathSegment(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!pathSegment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pathExpr", c)) break;
    }
    exit_section_(b, m, PATH_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT ('-' IDENT)* | INT
  static boolean pathItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathItem")) return false;
    if (!nextTokenIs(b, "", IDENT, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pathItem_0(b, l + 1);
    if (!r) r = consumeToken(b, INT);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENT ('-' IDENT)*
  private static boolean pathItem_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathItem_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && pathItem_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('-' IDENT)*
  private static boolean pathItem_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathItem_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pathItem_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pathItem_0_1", c)) break;
    }
    return true;
  }

  // '-' IDENT
  private static boolean pathItem_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathItem_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MINUS, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '/' (':')? pathItem?
  static boolean pathSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathSegment")) return false;
    if (!nextTokenIs(b, QUO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUO);
    r = r && pathSegment_1(b, l + 1);
    r = r && pathSegment_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':')?
  private static boolean pathSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathSegment_1")) return false;
    consumeToken(b, COLON);
    return true;
  }

  // pathItem?
  private static boolean pathSegment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathSegment_2")) return false;
    pathItem(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '*' dataType
  public static boolean pointerDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pointerDataType")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STAR);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, POINTER_DATA_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // httpMethod pathExpr bodyClause? (RETURNS bodyClause)? ';'?
  public static boolean routeStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routeStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ROUTE_STMT, "<route stmt>");
    r = httpMethod(b, l + 1);
    r = r && pathExpr(b, l + 1);
    r = r && routeStmt_2(b, l + 1);
    r = r && routeStmt_3(b, l + 1);
    r = r && routeStmt_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bodyClause?
  private static boolean routeStmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routeStmt_2")) return false;
    bodyClause(b, l + 1);
    return true;
  }

  // (RETURNS bodyClause)?
  private static boolean routeStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routeStmt_3")) return false;
    routeStmt_3_0(b, l + 1);
    return true;
  }

  // RETURNS bodyClause
  private static boolean routeStmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routeStmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURNS);
    r = r && bodyClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean routeStmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routeStmt_4")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // atDocClause? atHandlerClause routeStmt
  public static boolean serviceBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceBody")) return false;
    if (!nextTokenIs(b, "<service body>", ATDOC, ATHANDLER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SERVICE_BODY, "<service body>");
    r = serviceBody_0(b, l + 1);
    r = r && atHandlerClause(b, l + 1);
    r = r && routeStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // atDocClause?
  private static boolean serviceBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceBody_0")) return false;
    atDocClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENT ('-' IDENT)*
  public static boolean serviceName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceName")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && serviceName_1(b, l + 1);
    exit_section_(b, m, SERVICE_NAME, r);
    return r;
  }

  // ('-' IDENT)*
  private static boolean serviceName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!serviceName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "serviceName_1", c)) break;
    }
    return true;
  }

  // '-' IDENT
  private static boolean serviceName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MINUS, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'service' serviceName '{' serviceBody* '}'
  public static boolean serviceSpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceSpec")) return false;
    if (!nextTokenIs(b, SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SERVICE);
    r = r && serviceName(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && serviceSpec_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, SERVICE_SPEC, r);
    return r;
  }

  // serviceBody*
  private static boolean serviceSpec_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceSpec_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!serviceBody(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "serviceSpec_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // atServerBlock? serviceSpec
  public static boolean serviceStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceStatement")) return false;
    if (!nextTokenIs(b, "<service statement>", ATSERVER, SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SERVICE_STATEMENT, "<service statement>");
    r = serviceStatement_0(b, l + 1);
    r = r && serviceSpec(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // atServerBlock?
  private static boolean serviceStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceStatement_0")) return false;
    atServerBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' ']' dataType
  public static boolean sliceDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sliceDataType")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACK, RBRACK);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, SLICE_DATA_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // '{' elemExpr* '}'
  public static boolean structDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDataType")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && structDataType_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, STRUCT_DATA_TYPE, r);
    return r;
  }

  // elemExpr*
  private static boolean structDataType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDataType_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elemExpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structDataType_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'syntax' '=' STRING
  public static boolean syntaxLit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "syntaxLit")) return false;
    if (!nextTokenIs(b, SYNTAX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SYNTAX, ASSIGN, STRING);
    exit_section_(b, m, SYNTAX_LIT, r);
    return r;
  }

  /* ********************************************************** */
  // RAW_STRING
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, RAW_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RAW_STRING);
    exit_section_(b, m, TAG, r);
    return r;
  }

  /* ********************************************************** */
  // typeGroupBody | typeLiteralExpr
  public static boolean typeBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeBody")) return false;
    if (!nextTokenIs(b, "<type body>", IDENT, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_BODY, "<type body>");
    r = typeGroupBody(b, l + 1);
    if (!r) r = typeLiteralExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' typeLiteralExpr* ')'
  public static boolean typeGroupBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGroupBody")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && typeGroupBody_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TYPE_GROUP_BODY, r);
    return r;
  }

  // typeLiteralExpr*
  private static boolean typeGroupBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGroupBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeLiteralExpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeGroupBody_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENT '='? dataType
  public static boolean typeLiteralExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLiteralExpr")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && typeLiteralExpr_1(b, l + 1);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, TYPE_LITERAL_EXPR, r);
    return r;
  }

  // '='?
  private static boolean typeLiteralExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLiteralExpr_1")) return false;
    consumeToken(b, ASSIGN);
    return true;
  }

  /* ********************************************************** */
  // 'type' typeBody
  public static boolean typeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeStatement")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && typeBody(b, l + 1);
    exit_section_(b, m, TYPE_STATEMENT, r);
    return r;
  }

}
