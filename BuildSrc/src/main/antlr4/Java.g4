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
    : classDeclaration
    | interfaceDeclaration
    ;

typeTypeOrVoid
    : typeType
    | 'void'
    ;

classDeclaration
    : modifiers 'class' IDENTIFIER '{' (classBodyDeclaration)* '}'
    ;

interfaceDeclaration
    : 'interface' IDENTIFIER '{' (interfaceBodyDeclaration)* '}'
    ;

classBodyDeclaration
    : methodDeclaration
    | fieldDeclaration
    | constructorDeclaration
    | classDeclaration
    | interfaceDeclaration
    ;

interfaceBodyDeclaration
    : methodDeclaration
    ;

methodDeclaration
    : modifiers typeTypeOrVoid IDENTIFIER '(' formalParameters? ')' block
    | modifiers IDENTIFIER '(' formalParameters? ')' block
    ;

modifiers
    : ('public' | 'private' | 'protected' | 'static' | 'final' | 'abstract')*
    ;

formalParameters
    : formalParameter (',' formalParameter)*
    ;

formalParameter
    : typeType IDENTIFIER
    ;

fieldDeclaration
    : modifiers typeType variableDeclarators ';'
    ;

constructorDeclaration
    : modifiers IDENTIFIER '(' formalParameters? ')' block
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
    | variableDeclarator
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

SQUARE_BRACKETS
    : '[' .*? ']' -> skip
    ;

