lexer grammar ApiLexer;

// TOKEN
INFO:       'info';
MAP:        'map';
STRUCT:     'struct';
INTERFACE:  'interface';
TYPE:       'type';
ATSERVER:   '@server';
ATDOC:      '@doc';
ATHANDLER:  '@handler';
SERVICE:    'service';
RETURNS:    'returns';
IMPORT:     'import';


// HTTP METHOD
HTTPMETHOD:GET|HEAD|POST|PUT|PATCH|DELETE|CONNECT|OPTIONS|TRACE;
GET    :    'get';
HEAD   :    'head';
POST:       'post';
PUT:        'put';
PATCH  :    'patch';
DELETE :    'delete';
CONNECT:    'connect';
OPTIONS:    'options';
TRACE  :    'trace';

// DATA TYPE
GOTYPE:     BOOL|UINT8|UINT16|UINT32|UINT64|INT8|INT16|INT32|INT64|FLOAT32|FLOAT32|FLOAT64|COMPLEX64|COMPLEX128|STRING|INT|UINT|UINTPTR|BYTE|RUNE|TIME;
BOOL:       'bool';
UINT8:      'uint8';
UINT16:     'uint16';
UINT32:     'uint32';
UINT64:     'uint64';
INT8:       'int8';
INT16:      'int16';
INT32:      'int32';
INT64:      'int64';
FLOAT32:    'float32';
FLOAT64:    'float64';
COMPLEX64:  'complex64';
COMPLEX128: 'complex128';
STRING:     'string';
INT:        'int';
UINT:       'uint';
UINTPTR:    'uintptr';
BYTE:       'byte';
RUNE:       'rune';
TIME:       'time.Time';

// HTTP PATH
PATH:       (('/'|'/:'|'-') IDENT)+;

// MAKER
LPAREN:     '(';
RPAREN:     ')';
LBRACE:     '{';
RBRACE:     '}';
LBRACK:     '[';
RBRACK:     ']';
DOT:        '.';
SMICOLON:   ';';
COMMA:      ',';
STAR:       '*';
BAR:        '-';
ASSIGN:     '=';
COLON:      ':';
NUMBER:      DIGIT+;
HOSTVALUE:        DIGIT+ '.' DIGIT+ '.' DIGIT+ '.' DIGIT+;

// IDTIFIER
IDENT:       (ALPHA|UNDERSCORE)(ALPHA|DIGIT|UNDERSCORE|'-')*;



// WHITE SPACE
WS:         [ \t\r\n]+ -> channel(HIDDEN) ;



VALUE:      STRING_F     ~('\r'|'\n'|':')*  STRING_F;

RAW_STRING: RAW_STRING_F ~('`'|'\r'|'\n')* RAW_STRING_F;

// COMMENT
COMMENT:    COMMENT_FLAG ~('\n')*  -> channel(HIDDEN);

fragment COMMENT_FLAG:   '//';

fragment RAW_STRING_F: '`';

fragment STRING_F: '"';

fragment DIGIT: [0-9];

fragment UNDERSCORE: '_';

fragment ALPHA: [a-zA-Z];

//ERRCHAR:        . -> channel(HIDDEN);

fragment HEX_DIGIT
    : [0-9a-fA-F]
    ;
fragment OCT_DIGIT
    : [0-7]
    ;
fragment ESC_SEQ
    :   '\\' ('a'|'v'|'b'|'t'|'n'|'f'|'r'|'?'|'"'|'\''|'\\')
    |   '\\' ('x'|'X') HEX_DIGIT HEX_DIGIT
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;
fragment OCTAL_ESC
    :   '\\' [0-3] OCT_DIGIT OCT_DIGIT
    |   '\\' OCT_DIGIT OCT_DIGIT
    |   '\\' OCT_DIGIT
    ;
fragment UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

ERRCHAR
	:	.	-> channel(HIDDEN)
	;
