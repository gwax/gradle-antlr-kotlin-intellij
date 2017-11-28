lexer grammar Arith;

@header {
package com.gwax.lang;
}

// Whitespace
WS          : [\t\r\n ]+ -> skip ;

// Numbers
NUMBER      : '0'|[1-9][0-9]* ('.' [0-9]+)? ;

// Operators
ADDITION    : '+' ;
SUBTRACTION : '-';