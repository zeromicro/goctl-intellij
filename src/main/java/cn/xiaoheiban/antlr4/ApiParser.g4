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

importSpec: IMPORT importValue;
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
mapFieldType: MAP LBRACK GOTYPE RBRACK objType;
arrayOrSliceType: (LBRACK RBRACK)+ objType;
structType: structNameId STRUCT? LBRACE (typeFiled)* RBRACE;
objType: normalFieldType|starFieldType;
structNameId:IDENT;
fieldName:IDENT;
referenceId:IDENT;
tag: RAW_STRING;

// service
serviceStatement: (serviceServerSpec? serviceSpec);
serviceServerSpec: ATSERVER LPAREN identPair RPAREN;


serviceSpec: SERVICE serviceName LBRACE serviceBody+ RBRACE;
serviceName:IDENT;
serviceBody:(serviceDoc|serviceDocNew)? (serviceHandler|serviceHandlerNew) serviceRoute;
serviceDoc: ATDOC LPAREN pair RPAREN;
serviceDocNew: ATDOC docValue;
serviceHandler: ATSERVER LPAREN handlerPair RPAREN;
serviceHandlerNew: ATHANDLER handlerValue;
serviceRoute:httpRoute (LPAREN referenceId? RPAREN)? (RETURNS LPAREN referenceId? RPAREN)? SMICOLON?;
httpRoute:HTTPMETHOD PATH;
identPair:(key COLON identValue|PATH)*;
handlerPair:(key COLON handlerValue)+;
identValue:(IDENT ','?)+;
handlerValue:IDENT;
importValue:VALUE;
docValue:VALUE;
pair:(key COLON VALUE?)*;
key:IDENT;