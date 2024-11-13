grammar Kotlin;

CLASS : 'class';
INTERFACE : 'interface';
FUN : 'fun';


ID : [a-zA-Z_] [a-zA-Z_0-9]*;
WS : [ \t\r\n]+ -> skip;
LBRACE : '{';
RBRACE : '}';
LPAREN : '(';
RPAREN : ')';
COMMA : ',';
COLON : ':';
SEMICOLON : ';';
DOT : '.';
EQ : '=';

// Лексемы для строк и комментариев
STRING : '"' ( ~["\\] | '\\' . )* '"' -> skip;
MULTILINE_STRING : '\'\'\'' .*? '\'\'\'' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
