/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** A Java 1.7 grammar for ANTLR v4 derived from ANTLR v3 Java grammar.
 *  Uses ANTLR v4's left-recursive expression notation.
 *  It parses ECJ, Netbeans, JDK etc...
 *
 *  Sam Harwell cleaned this up significantly and updated to 1.7!
 *
 *  You can test with
 *
 *  $ antlr4 Java.g4
 *  $ javac *.java
 *  $ grun Java compilationUnit *.java
 */
grammar MyJAVA;

// starting point for parsing a java file
// missing rule for program here

importList
    :   importStatement importList?
    ;

importStatement
    :   importKeyword filename ';'
    ;

importKeyword
    :   'import'
    |   'IMPORT'
    ;

filename
    :   Letter+ '.' extension
    ;

extension
    :   '.myj'
    ;

constDeclist
    :   constStatement constDeclist
    ;

constStatement
    :   constKeyword constName '=' constValue
    ;

constKeyword
    :   'constant'
    |   'CONSTANT'
    ;

constName
    :   Letter Alphanum*
    ;

constValue
    :   integer
    |   float
    |   char
    |   string
    ;

integer
    :   sign Digits
    ;

sign
    :   '+'
    |   '-'
    ;

float
    :   Digits '.' Digits
    |   '.' Digits
    ;

char
    :   '\'' charValue '\''
    ;

string
    :   '"' charValue+ '"'
    ;

varDecList
    :   varDec ';' varDecList
    |   varDec ';'
    ;

varDec
    :   dataType varNameList
    ;

dataType
    :   'int'
    |   'float'
    |   'double'
    |   'char'
    |   'string'
    |   'INT'
    |   'FLOAT'
    |   'DOUBLE'
    |   'CHAR'
    |   'STRING'
    ;

varNameList
    :   varName ',' varNameList
    |   varName
    ;

varName
    :   Letter Alphanum* index*
    ;

index
    :   '[' integer ']'
    ;

// function declarations
funcDecList
    :   funcDec funcDecList
    ;

funcDec
    :   functionReturn '|' functionVoid
    ;

functionReturn
    :   dataType functionName '(' paramList ')' functionBody
    ;

functionVoid
    :   voidKeyword functionName '(' paramList ')' functionBody
    ;

voidKeyword
    :   'void'
    |   'VOID'
    ;

functionName
    :   Letter+
    ;

paramList
    :   parameter
    ;

parameter
    :   varDec ',' parameter
    ;

functionBody
    :   '{' varDecList statementList '}'
    ;

mainFunction
    :   voidKeyword mainKeyword '()' functionBody
    ;

mainKeyword
    :   'main'
    |   'MAIN'
    ;

// statement declarations
statement
    :   assignStatement
    //|   io_statement
    |   condStatement
    |   loopStatement
    ;

assignStatement
    :   Identifier '->' expression
    ;

condStatement
    :   ifStatement
    |   switchStatement
    |   boolStatement
    ;

ifStatement
    :   ifKeyword '(' expression ')' statement elseKeyword statement
    |   ifKeyword '(' expression ')' statement
    ;

ifKeyword
    :   'if'
    |   'IF'
    ;

elseKeyword
    :   'else'
    |   'ELSE'
    ;

boolStatement
    :   'true'
    |   'false'
    |   'TRUE'
    |   'FALSE'
    ;

loopStatement
    :   doWhileLoop
    |   whileLoop
    |   forLoop
    ;

returnStatement
    :   returnKeyword expression ';'
    ;

returnKeyword
    :   'return'
    |   'RETURN'
    ;

switchStatement
    :   switchKeyword '(' expression ')' '{' caseList defaultStatement '}'
    ;

switchKeyword
    :   'switch'
    |   'SWITCH'
    ;

caseList
    :   caseKeyword expression ':' statementList caseList
    ;

caseKeyword
    :   'case'
    |   'CASE'
    ;

doWhileLoop
    :   doKeyword statement whileKeyword '(' condStatement ')'
    ;

doKeyword
    :   'do'
    |   'DO'
    ;

whileLoop
    :   whileKeyword '(' condStatement ')' statement
    ;

whileKeyword
    :   'while'
    |   'WHILE'
    ;

forLoop
    :   forKeyword '(' assignStatement ';' condStatement ';' assignStatement ')' statement
    ;

forKeyword
    :   'for'
    |   'FOR'
    ;

defaultStatement
    :   defaultKeywords ':' statementList
    ;

defaultKeywords
    :   'default'
    |   'DEFAULT'
    ;

statementList
    :   statement statementList
    ;

// expression declarations
expression
    :   stringExpression
    |   numExpression
    |   boolExpression
    |   functionName '(' paramList ');'
    ;

stringExpression
    :   stringIdentifier '+' stringExpression
    |   string '+' stringExpression
    |   stringIdentifier
    |   string
    |   '!' stringExpression
    |   '-' stringExpression
    ;

stringIdentifier
    :   Identifier
    ;

numExpression
    :   numTerm '+' numExpression
    |   numTerm '-' numExpression
    |   numTerm
    ;

numTerm
    :   numFactor '*' numTerm
    |   numFactor '/' numTerm
    |   numFactor '%' numTerm
    |   numFactor
    ;

numFactor
    :   '(' numExpression ')'
    |   char
    |   integer
    //|   floatingPoint
    |   Identifier
    ;

numIdentifier
    :   Identifier
    ;

boolExpression
    :   numExpression relOp numExpression
    |   stringExpression '==' stringExpression
    |   stringExpression '!=' stringExpression
    |   boolLogical '==' boolExpression
    |   boolLogical '!=' boolExpression
    |   boolLogical
    ;

relOp
    :   '=='
    |   '!='
    |   '<='
    |   '>='
    |   '<'
    |   '>'
    ;

boolLogical
    :   boolTerm '||' boolLogical
    |   boolTerm
    ;

boolTerm
    :   boolFactor '&&' boolTerm
    |   boolFactor
    ;

boolFactor
    :   '(' boolLogical ')'
    |   '!' boolLogical
    |   boolIdentifier
    ;

boolIdentifier
    :   Identifier
    ;

// other declarations
charValue
    :   asciiChar asciiChar+
    |   asciiChar
    |   '\n'
    |   '\\'
    ;

asciiChar
    :   Letter
    |   Digit
    |   '$'
    |   '&'
    |   '+'
    |   ','
    |   ':'
    |   ';'
    |   '='
    |   '?'
    |   '@'
    |   '#'
    |   '|'
    |   '\''
    |   '<'
    |   '>'
    |   '.'
    |   '^'
    |   '*'
    |   '('
    |   ')'
    |   '%'
    |   '!'
    |   '-'
    ;

// LEXER

// §3.9 Keywords

ABSTRACT      : 'abstract';
ASSERT        : 'assert';
BOOLEAN       : 'boolean';
BREAK         : 'break';
BYTE          : 'byte';
CASE          : 'case';
CATCH         : 'catch';
CHAR          : 'char';
CLASS         : 'class';
CONST         : 'const';
CONTINUE      : 'continue';
DEFAULT       : 'default';
DO            : 'do';
DOUBLE        : 'double';
ELSE          : 'else';
ENUM          : 'enum';
EXTENDS       : 'extends';
FINAL         : 'final';
FINALLY       : 'finally';
FLOAT         : 'float';
FOR           : 'for';
IF            : 'if';
GOTO          : 'goto';
IMPLEMENTS    : 'implements';
IMPORT        : 'import';
INSTANCEOF    : 'instanceof';
INT           : 'int';
INTERFACE     : 'interface';
LONG          : 'long';
NATIVE        : 'native';
NEW           : 'new';
PACKAGE       : 'package';
PRIVATE       : 'private';
PROTECTED     : 'protected';
PUBLIC        : 'public';
RETURN        : 'return';
SHORT         : 'short';
STATIC        : 'static';
STRICTFP      : 'strictfp';
STRING        : 'String';
SUPER         : 'super';
SWITCH        : 'switch';
SYNCHRONIZED  : 'synchronized';
THIS          : 'this';
THROW         : 'throw';
THROWS        : 'throws';
TRANSIENT     : 'transient';
TRY           : 'try';
VOID          : 'void';
VOLATILE      : 'volatile';
WHILE         : 'while';

// §3.10.1 Integer Literals

IntegerLiteral
    :   DecimalIntegerLiteral
    |   HexIntegerLiteral
    |   OctalIntegerLiteral
    |   BinaryIntegerLiteral
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;

fragment
HexIntegerLiteral
    :   HexNumeral IntegerTypeSuffix?
    ;

fragment
OctalIntegerLiteral
    :   OctalNumeral IntegerTypeSuffix?
    ;

fragment
BinaryIntegerLiteral
    :   BinaryNumeral IntegerTypeSuffix?
    ;

fragment
IntegerTypeSuffix
    :   [lL]
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;

fragment
HexDigits
    :   HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;

fragment
OctalNumeral
    :   '0' Underscores? OctalDigits
    ;

fragment
OctalDigits
    :   OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;

fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;

fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;

fragment
BinaryDigit
    :   [01]
    ;

fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    |   HexadecimalFloatingPointLiteral
    ;

fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
    |   '.' Digits ExponentPart? FloatTypeSuffix?
    |   Digits ExponentPart FloatTypeSuffix?
    |   Digits FloatTypeSuffix
    ;

fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;

fragment
ExponentIndicator
    :   [eE]
    ;

fragment
SignedInteger
    :   Sign? Digits
    ;

fragment
Sign
    :   [+-]
    ;

fragment
FloatTypeSuffix
    :   [fFdD]
    ;

fragment
HexadecimalFloatingPointLiteral
    :   HexSignificand BinaryExponent FloatTypeSuffix?
    ;

fragment
HexSignificand
    :   HexNumeral '.'?
    |   '0' [xX] HexDigits? '.' HexDigits
    ;

fragment
BinaryExponent
    :   BinaryExponentIndicator SignedInteger
    ;

fragment
BinaryExponentIndicator
    :   [pP]
    ;

// §3.10.3 Boolean Literals

BooleanLiteral
    :   'true'
    |   'false'
    |   'TRUE'
    |   'FALSE'
    ;

// §3.10.4 Character Literals

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;

fragment
SingleCharacter
    :   ~['\\\r\n]
    ;

// §3.10.5 String Literals

StringLiteral
    :   '"' StringCharacters? '"'
    ;

fragment
StringCharacters
    :   StringCharacter+
    ;

fragment
StringCharacter
    :   ~["\\]
    |   EscapeSequence
    ;

// §3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape
    ;

fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
ZeroToThree
    :   [0-3]
    ;

// §3.10.7 The Null Literal

NullLiteral
    :   'null'
    |   'NULL'
    ;

// §3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// §3.12 Operators

ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
TILDE           : '~';
QUESTION        : '?';
COLON           : ':';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';
MOD             : '%';

ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
AND_ASSIGN      : '&=';
OR_ASSIGN       : '|=';
XOR_ASSIGN      : '^=';
MOD_ASSIGN      : '%=';
LSHIFT_ASSIGN   : '<<=';
RSHIFT_ASSIGN   : '>>=';
URSHIFT_ASSIGN  : '>>>=';

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   Letter Alphanum*
    ;

fragment
Letter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

fragment
Alphanum
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;
