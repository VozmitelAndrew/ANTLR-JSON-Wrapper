grammar Java;

compilationUnit
    : (typeDeclaration | packageDeclaration | importDeclaration)* EOF
    ;

packageDeclaration
    : 'package' qualifiedName ';'
    ;

importDeclaration
    : 'import' qualifiedName ('.' '*')? ';'
    ;

typeDeclaration
    : modifiers? (classDeclaration | interfaceDeclaration)
    ;

classDeclaration
    : 'class' IDENTIFIER '{' (classBodyDeclaration)* '}'
    ;

interfaceDeclaration
    : 'interface' IDENTIFIER '{' (interfaceBodyDeclaration)* '}'
    ;


classBodyDeclaration
    : methodDeclaration
    | fieldDeclaration
    | constructorDeclaration
    ;

interfaceBodyDeclaration
    : methodDeclaration
    ;

methodDeclaration
    : modifiers? typeTypeOrVoid IDENTIFIER '(' (formalParameters)? ')' '{' (statement)* '}'
    ;

modifiers
    : ('public' | 'private' | 'protected' | 'static')*
    ;

formalParameters
    : formalParameter (',' formalParameter)*
    ;

formalParameter
    : typeType IDENTIFIER
    ;

fieldDeclaration
    : modifiers? typeType variableDeclarators ';'
    ;

constructorDeclaration
    : modifiers? IDENTIFIER '(' (formalParameters)? ')' block
    ;

typeTypeOrVoid
    : typeType
    | 'void'
    ;

typeType
    : primitiveType
    | IDENTIFIER
    ;

primitiveType
    : 'int'
    | 'float'
    | 'double'
    | 'boolean'
    | 'char'
    | 'byte'
    | 'short'
    | 'long'
    ;

variableDeclarators
    : variableDeclarator (',' variableDeclarator)*
    ;

variableDeclarator
    : IDENTIFIER ('=' expression)?
    ;

block
    : '{' (statement)* '}'
    ;

statement
    : block
    | expressionStatement
    | 'return' expression? ';'
    | ';'
    ;

expressionStatement
    : expression ';'
    ;

expression
    : methodCall
    | IDENTIFIER
    | literal
    ;

methodCall
    : qualifiedName '(' argumentList? ')'
    ;


argumentList
    : expression (',' expression)*
    ;


literal
    : INTEGER_LITERAL
    | FLOAT_LITERAL
    | BOOLEAN_LITERAL
    | CHAR_LITERAL
    | STRING_LITERAL
    ;

qualifiedName
    : IDENTIFIER ('.' IDENTIFIER)*
    ;

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

INTEGER_LITERAL
    : [0-9]+
    ;

FLOAT_LITERAL
    : [0-9]+ '.' [0-9]*
    ;

BOOLEAN_LITERAL
    : 'true'
    | 'false'
    ;

CHAR_LITERAL
    : '\'' . '\''
    ;

STRING_LITERAL
    : '"' (~["\\] | '\\' .)* '"'
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

LINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;
