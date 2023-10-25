parser grammar ApiParser;

options {
    tokenVocab = ApiLexer;
}

api:
    syntaxLit?
    (
    importStatement
    |infoStatement
    |apiBody
    )*
    EOF;

syntaxLit: 'syntax' '=' VALUE;
apiBody:
    typeStatement
    |serviceStatement;

importStatement:importSpec+;

importSpec: importLit|importGroup;
importLit:IMPORT importValue;
importGroup: IMPORT LPAREN importValue* RPAREN;

// info
infoStatement: INFO LPAREN pair RPAREN;

// types
typeStatement: (typeSingleSpec|typeGroupSpec);

// eg: type (...)
typeGroupSpec:TYPE LPAREN typeGroupBody RPAREN;
typeGroupBody:(typeGroupAlias|structType)*;
typeGroupAlias:structNameId normalFieldType;

// eg: type xx struct {...}
typeSingleSpec: typeAlias|typeStruct;
typeStruct:TYPE structType;
// eg: type Integer int
typeAlias:TYPE structNameId '='? normalFieldType;
typeFiled:anonymousField|normalField |structType;
normalField:fieldName fieldType  tag?;
fieldType:normalFieldType|starFieldType|mapFieldType|arrayOrSliceType;
anonymousField: STAR? referenceId;
normalFieldType: GOTYPE|referenceId|(INTERFACE LBRACE RBRACE);
starFieldType: STAR normalFieldType;
mapFieldType: MAP LBRACK fieldType RBRACK fieldType;
arrayOrSliceType: (LBRACK NUMBER? RBRACK)+ fieldType;
structType: structNameId STRUCT? LBRACE (typeFiled)* RBRACE;
structNameId:IDENT;
fieldName:IDENT;
referenceId:pkg? IDENT;
pkg: IDENT DOT;
tag: RAW_STRING;
body: (LBRACK RBRACK)? STAR? (IDENT|GOTYPE);
// service
serviceStatement: (serviceServerSpec? serviceSpec);
serviceServerSpec: ATSERVER LPAREN identPair RPAREN;


serviceSpec: SERVICE serviceName LBRACE serviceBody+ RBRACE;
serviceName:IDENT;
serviceBody:(serviceDoc|serviceDocNew)? (serviceHandler|serviceHandlerNew) serviceRoute;
serviceDoc: ATDOC LPAREN pair RPAREN;
serviceDocNew: ATDOC (docValue|(LPAREN docValue RPAREN));
serviceHandler: ATSERVER LPAREN handlerPair RPAREN;
serviceHandlerNew: ATHANDLER handlerValue;
serviceRoute:httpRoute (LPAREN body? RPAREN)? (RETURNS LPAREN body? RPAREN)? SMICOLON?;
httpRoute:HTTPMETHOD PATH;
identPair:(key COLON (DURATION|identValue|PATH|NUMBER))*;
handlerPair:(key COLON handlerValue)+;
identValue:(IDENT ','?)+;
handlerValue:IDENT;
importValue:VALUE (AS IDENT)?;
docValue:VALUE;
pair:(key COLON VALUE?)*;
key:IDENT;