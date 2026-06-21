grammar translator;

// Parser

program
    : packageClause topLevelDecl* EOF
    ;

packageClause
    : 'package' IDENTIFIER
    ;

topLevelDecl
    : functionDecl
    ;

functionDecl
    : 'func' IDENTIFIER '(' parameterList? ')' returnSignature? block
    ;

parameterList
    : parameter (',' parameter)*
    ;

parameter
    : IDENTIFIER type_
    ;

// Go return signatures: none, single type, or a parenthesised list of types
returnSignature
    : type_                                  # singleReturn
    | '(' type_ (',' type_)* ')'             # multiReturn
    ;

block
    : '{' statement* '}'
    ;

statement
    : varDecl                                # varDeclStmt
    | shortVarDecl                           # shortVarDeclStmt
    | assignment                             # assignStmt
    | ifStmt                                 # ifStatement
    | forStmt                                # forStatement
    | returnStmt                             # returnStatement
    | printStmt                              # printStatement
    | expression                            # exprStmt
    ;

// var x int = 5    |    var x int
varDecl
    : 'var' IDENTIFIER type_ ('=' expression)?
    ;

// x := 5    |    a, b := f()
shortVarDecl
    : IDENTIFIER (',' IDENTIFIER)* ':=' expression (',' expression)*
    ;

// x = 5    |    a, b = b, a
assignment
    : IDENTIFIER (',' IDENTIFIER)* '=' expression (',' expression)*
    ;

ifStmt
    : 'if' expression block ('else' (ifStmt | block))?
    ;

forStmt
    : 'for' forClause? block
    ;

forClause
    : forInit? ';' expression? ';' forPost?    # threePartFor
    | expression                               # conditionFor
    ;

forInit
    : shortVarDecl
    | assignment
    ;

forPost
    : assignment
    | incDecStmt
    ;

incDecStmt
    : IDENTIFIER ('++' | '--')
    ;

returnStmt
    : 'return' (expression (',' expression)*)?
    ;

// fmt.Println(...) / fmt.Printf(...) / fmt.Print(...)
printStmt
    : 'fmt' '.' ('Println' | 'Printf' | 'Print') '(' argumentList? ')'
    ;

argumentList
    : expression (',' expression)*
    ;

// Expression grammar with precedence
expression
    : '(' expression ')'                          # parenExpr
    | IDENTIFIER '(' argumentList? ')'            # callExpr
    | ('-' | '!') expression                      # unaryExpr
    | expression ('*' | '/' | '%') expression     # mulExpr
    | expression ('+' | '-') expression           # addExpr
    | expression ('<' | '<=' | '>' | '>=') expression  # relExpr
    | expression ('==' | '!=') expression         # eqExpr
    | expression '&&' expression                  # andExpr
    | expression '||' expression                  # orExpr
    | IDENTIFIER                                   # idExpr
    | INT_LIT                                      # intExpr
    | FLOAT_LIT                                    # floatExpr
    | STRING_LIT                                   # stringExpr
    | ('true' | 'false')                          # boolExpr
    ;

type_
    : 'int'
    | 'float64'
    | 'string'
    | 'bool'
    ;

// Lexer

// FLOAT_LIT must come before INT_LIT so '2.26' is not split
FLOAT_LIT  : [0-9]+ '.' [0-9]+ ;
INT_LIT    : [0-9]+ ;
STRING_LIT : '"' (~["\\\r\n] | '\\' .)* '"' ;

IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]* ;

LINE_COMMENT  : '//' ~[\r\n]*    -> skip ;
BLOCK_COMMENT : '/*' .*? '*/'    -> skip ;
WS            : [ \t\r\n]+       -> skip ;
