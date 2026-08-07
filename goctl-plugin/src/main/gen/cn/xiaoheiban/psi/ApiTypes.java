// This is a generated file. Not intended for manual editing.
package cn.xiaoheiban.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import cn.xiaoheiban.psi.impl.*;

public interface ApiTypes {

  IElementType ANY_TYPE = new ApiElementType("ANY_TYPE");
  IElementType ARRAY_DATA_TYPE = new ApiElementType("ARRAY_DATA_TYPE");
  IElementType AT_DOC_CLAUSE = new ApiElementType("AT_DOC_CLAUSE");
  IElementType AT_HANDLER_CLAUSE = new ApiElementType("AT_HANDLER_CLAUSE");
  IElementType AT_SERVER_BLOCK = new ApiElementType("AT_SERVER_BLOCK");
  IElementType AT_SERVER_KV_PAIR = new ApiElementType("AT_SERVER_KV_PAIR");
  IElementType AT_SERVER_PATH_VALUE = new ApiElementType("AT_SERVER_PATH_VALUE");
  IElementType AT_SERVER_VALUE = new ApiElementType("AT_SERVER_VALUE");
  IElementType BASE_DATA_TYPE = new ApiElementType("BASE_DATA_TYPE");
  IElementType BODY_CLAUSE = new ApiElementType("BODY_CLAUSE");
  IElementType BODY_EXPR = new ApiElementType("BODY_EXPR");
  IElementType DATA_TYPE = new ApiElementType("DATA_TYPE");
  IElementType ELEM_EXPR = new ApiElementType("ELEM_EXPR");
  IElementType HTTP_METHOD = new ApiElementType("HTTP_METHOD");
  IElementType IMPORT_GROUP = new ApiElementType("IMPORT_GROUP");
  IElementType IMPORT_LIT = new ApiElementType("IMPORT_LIT");
  IElementType IMPORT_STATEMENT = new ApiElementType("IMPORT_STATEMENT");
  IElementType IMPORT_VALUE = new ApiElementType("IMPORT_VALUE");
  IElementType INFO_STATEMENT = new ApiElementType("INFO_STATEMENT");
  IElementType KV_PAIR = new ApiElementType("KV_PAIR");
  IElementType MAP_DATA_TYPE = new ApiElementType("MAP_DATA_TYPE");
  IElementType PATH_EXPR = new ApiElementType("PATH_EXPR");
  IElementType POINTER_DATA_TYPE = new ApiElementType("POINTER_DATA_TYPE");
  IElementType ROUTE_STMT = new ApiElementType("ROUTE_STMT");
  IElementType SERVICE_BODY = new ApiElementType("SERVICE_BODY");
  IElementType SERVICE_NAME = new ApiElementType("SERVICE_NAME");
  IElementType SERVICE_SPEC = new ApiElementType("SERVICE_SPEC");
  IElementType SERVICE_STATEMENT = new ApiElementType("SERVICE_STATEMENT");
  IElementType SLICE_DATA_TYPE = new ApiElementType("SLICE_DATA_TYPE");
  IElementType STRUCT_DATA_TYPE = new ApiElementType("STRUCT_DATA_TYPE");
  IElementType SYNTAX_LIT = new ApiElementType("SYNTAX_LIT");
  IElementType TAG = new ApiElementType("TAG");
  IElementType TYPE_BODY = new ApiElementType("TYPE_BODY");
  IElementType TYPE_GROUP_BODY = new ApiElementType("TYPE_GROUP_BODY");
  IElementType TYPE_LITERAL_EXPR = new ApiElementType("TYPE_LITERAL_EXPR");
  IElementType TYPE_STATEMENT = new ApiElementType("TYPE_STATEMENT");

  IElementType ANY = new ApiTokenType("interface{}");
  IElementType AS = new ApiTokenType("as");
  IElementType ASSIGN = new ApiTokenType("=");
  IElementType ATDOC = new ApiTokenType("@doc");
  IElementType ATHANDLER = new ApiTokenType("@handler");
  IElementType ATSERVER = new ApiTokenType("@server");
  IElementType BLOCK_COMMENT = new ApiTokenType("BLOCK_COMMENT");
  IElementType COLON = new ApiTokenType(":");
  IElementType COMMA = new ApiTokenType(",");
  IElementType CONNECT = new ApiTokenType("connect");
  IElementType DELETE = new ApiTokenType("delete");
  IElementType DOT = new ApiTokenType(".");
  IElementType DURATION = new ApiTokenType("DURATION");
  IElementType ELLIPSIS = new ApiTokenType("...");
  IElementType GET = new ApiTokenType("get");
  IElementType HEAD = new ApiTokenType("head");
  IElementType IDENT = new ApiTokenType("IDENT");
  IElementType IMPORT = new ApiTokenType("import");
  IElementType INFO = new ApiTokenType("info");
  IElementType INT = new ApiTokenType("INT");
  IElementType INTERFACE = new ApiTokenType("interface");
  IElementType LBRACE = new ApiTokenType("{");
  IElementType LBRACK = new ApiTokenType("[");
  IElementType LINE_COMMENT = new ApiTokenType("LINE_COMMENT");
  IElementType LPAREN = new ApiTokenType("(");
  IElementType MAP = new ApiTokenType("map");
  IElementType MINUS = new ApiTokenType("-");
  IElementType OPTIONS = new ApiTokenType("options");
  IElementType PATCH = new ApiTokenType("patch");
  IElementType POST = new ApiTokenType("post");
  IElementType PUT = new ApiTokenType("put");
  IElementType QUO = new ApiTokenType("/");
  IElementType RAW_STRING = new ApiTokenType("RAW_STRING");
  IElementType RBRACE = new ApiTokenType("}");
  IElementType RBRACK = new ApiTokenType("]");
  IElementType RETURNS = new ApiTokenType("returns");
  IElementType RPAREN = new ApiTokenType(")");
  IElementType SEMICOLON = new ApiTokenType(";");
  IElementType SERVICE = new ApiTokenType("service");
  IElementType STAR = new ApiTokenType("*");
  IElementType STRING = new ApiTokenType("STRING");
  IElementType STRUCT = new ApiTokenType("struct");
  IElementType SYNTAX = new ApiTokenType("syntax");
  IElementType TRACE = new ApiTokenType("trace");
  IElementType TYPE = new ApiTokenType("type");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANY_TYPE) {
        return new ApiAnyTypeImpl(node);
      }
      else if (type == ARRAY_DATA_TYPE) {
        return new ApiArrayDataTypeImpl(node);
      }
      else if (type == AT_DOC_CLAUSE) {
        return new ApiAtDocClauseImpl(node);
      }
      else if (type == AT_HANDLER_CLAUSE) {
        return new ApiAtHandlerClauseImpl(node);
      }
      else if (type == AT_SERVER_BLOCK) {
        return new ApiAtServerBlockImpl(node);
      }
      else if (type == AT_SERVER_KV_PAIR) {
        return new ApiAtServerKvPairImpl(node);
      }
      else if (type == AT_SERVER_PATH_VALUE) {
        return new ApiAtServerPathValueImpl(node);
      }
      else if (type == AT_SERVER_VALUE) {
        return new ApiAtServerValueImpl(node);
      }
      else if (type == BASE_DATA_TYPE) {
        return new ApiBaseDataTypeImpl(node);
      }
      else if (type == BODY_CLAUSE) {
        return new ApiBodyClauseImpl(node);
      }
      else if (type == BODY_EXPR) {
        return new ApiBodyExprImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new ApiDataTypeImpl(node);
      }
      else if (type == ELEM_EXPR) {
        return new ApiElemExprImpl(node);
      }
      else if (type == HTTP_METHOD) {
        return new ApiHttpMethodImpl(node);
      }
      else if (type == IMPORT_GROUP) {
        return new ApiImportGroupImpl(node);
      }
      else if (type == IMPORT_LIT) {
        return new ApiImportLitImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ApiImportStatementImpl(node);
      }
      else if (type == IMPORT_VALUE) {
        return new ApiImportValueImpl(node);
      }
      else if (type == INFO_STATEMENT) {
        return new ApiInfoStatementImpl(node);
      }
      else if (type == KV_PAIR) {
        return new ApiKvPairImpl(node);
      }
      else if (type == MAP_DATA_TYPE) {
        return new ApiMapDataTypeImpl(node);
      }
      else if (type == PATH_EXPR) {
        return new ApiPathExprImpl(node);
      }
      else if (type == POINTER_DATA_TYPE) {
        return new ApiPointerDataTypeImpl(node);
      }
      else if (type == ROUTE_STMT) {
        return new ApiRouteStmtImpl(node);
      }
      else if (type == SERVICE_BODY) {
        return new ApiServiceBodyImpl(node);
      }
      else if (type == SERVICE_NAME) {
        return new ApiServiceNameImpl(node);
      }
      else if (type == SERVICE_SPEC) {
        return new ApiServiceSpecImpl(node);
      }
      else if (type == SERVICE_STATEMENT) {
        return new ApiServiceStatementImpl(node);
      }
      else if (type == SLICE_DATA_TYPE) {
        return new ApiSliceDataTypeImpl(node);
      }
      else if (type == STRUCT_DATA_TYPE) {
        return new ApiStructDataTypeImpl(node);
      }
      else if (type == SYNTAX_LIT) {
        return new ApiSyntaxLitImpl(node);
      }
      else if (type == TAG) {
        return new ApiTagImpl(node);
      }
      else if (type == TYPE_BODY) {
        return new ApiTypeBodyImpl(node);
      }
      else if (type == TYPE_GROUP_BODY) {
        return new ApiTypeGroupBodyImpl(node);
      }
      else if (type == TYPE_LITERAL_EXPR) {
        return new ApiTypeLiteralExprImpl(node);
      }
      else if (type == TYPE_STATEMENT) {
        return new ApiTypeStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
