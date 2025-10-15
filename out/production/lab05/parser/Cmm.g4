grammar Cmm;

@header {
	import ast.*;
	import ast.definitions.*;
	import ast.expressions.*;
	import ast.locatable.*;
	import ast.statements.*;
	import ast.types.*;
}

/************************** Parser rules **************************/

// sequence of variable and function definitions
// last and mandatory function is the "main" function, which returns void and receives no parameters
program returns [Program ast]:
    (stmts+=statement)+ VOID MAIN LEFT_PAREN RIGHT_PAREN block EOF
    {
        List<Statement> stmts = new ArrayList<>();
        if ($stmts != null) $stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
        $ast = new Program(stmts, $block.ast);
    }
    ;

// statement
statement returns [Statement ast]:
    // 1: read
    read=READ exprs+=expression (COMMA exprs+=expression)*? SEMICOLON // Write and read statements could specify a list of (at least one) expressions.
    {
        List<Expression> exprs = new ArrayList<>();
        if ($exprs != null) $exprs.forEach(e -> {if (e != null) exprs.add(e.ast); });
        $ast = new Read($read.getLine(), $read.getCharPositionInLine()+1, exprs);
    }
    // 2: write
    | write=WRITE exprs+=expression (COMMA exprs+=expression)*? SEMICOLON // write: allow for procedure invoke in write as well
    {
        List<Expression> exprs = new ArrayList<>();
        if ($exprs != null) $exprs.forEach(e -> {if (e != null) exprs.add(e.ast); });
        $ast = new Write($write.getLine(), $write.getCharPositionInLine()+1, exprs);
    }
    // 3: return
    | return=RETURN expression SEMICOLON // return: the expression after the return keyword is mandatory; i.e., return; is not a valid statement in this language
    { $ast = new Return($return.getLine(), $return.getCharPositionInLine()+1, $expression.ast); }
    // 4: assignment
    | e1=expression ASSIGN e2=expression SEMICOLON // assignment
    { $ast = new Assignment($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
    // 5: if/else
    | if=IF LEFT_PAREN expression 
        RIGHT_PAREN (thenSt+=statement | LEFT_BRACE thenSt+=statement* RIGHT_BRACE) 
        (ELSE (elseSt+=statement | LEFT_BRACE elseSt+=statement* RIGHT_BRACE))? // if/else: allow for single statement or block as body for if and else statements
    {
        List<Statement> elseStmts = new ArrayList<>();
        if ($elseSt != null) $elseSt.forEach(s -> {if (s != null) elseStmts.add(s.ast); });
        List<Statement> thenStmts = new ArrayList<>();
        if ($thenSt != null) $thenSt.forEach(s -> {if (s != null) thenStmts.add(s.ast); });
        $ast = new IfElse($if.getLine(), $if.getCharPositionInLine()+1, $expression.ast, thenStmts, elseStmts);
    }
    // 6: while
    | while=WHILE LEFT_PAREN expression 
        RIGHT_PAREN (stmt=statement | LEFT_BRACE stmts+=statement* RIGHT_BRACE) // while: allow for single statement or block as body
    {
        List<Statement> stmts = new ArrayList<>();
        if ($stmts != null) $stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
        else stmts.add($stmt.ast);
        $ast = new While($while.getLine(), $while.getCharPositionInLine()+1, $expression.ast, stmts);
    }
    // 7: procedure invoke
    | procedureInvocation SEMICOLON // procedure invoke
    { $ast = $procedureInvocation.ast; }
    // 8: variable definition
    | varDefinition // variable definition
    { $ast = $varDefinition.ast; }
    // 9: function definition
    | functionDefinition // function definition
    { $ast = $functionDefinition.ast; }
    ;

// allow for no parameters or multiple parameters
procedureInvocation returns [Statement ast]:
    ID LEFT_PAREN (exp+=expression (COMMA exp+=expression)*)? RIGHT_PAREN
    {
        List<Expression> exp = new ArrayList<>();
        if ($exp != null) $exp.forEach(e -> {if (e != null) exp.add(e.ast); });
        $ast = new ProcedureInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, exp);
    }
    ;

// definition

// allow for optional array dimensions and optional initialization on declarations
// Variables with the same type could be declared in the same variable definition.
// Structs could be nested: a field of a record could be another record. They can also be combined with any other type, including arrays.
// The record (struct) type is provided by the language. Struct variables could be local and global. No typedef construction is provided.
varDefinition returns [VariableDefinition ast]:
    // 1: simple variable definition
    t=type ids+=ID (COMMA ids+=ID)*? SEMICOLON
    {
        List<String> ids = new ArrayList<>();
        if ($ids != null) $ids.forEach(id -> {if (id != null) ids.add(id.getText()); });
        $ast = new VariableDefinition($t.start.getLine(), $t.start.getCharPositionInLine()+1, $t.ast, ids);
    }
    // 2: struct variable definition
    | struct=STRUCT LEFT_BRACE (varDef+=varDefinition)* RIGHT_BRACE arrayIndex? ID SEMICOLON
    {
        int line = _localctx.getStart().getLine();
        int col = _localctx.getStart().getCharPositionInLine()+1;
        Type type;
        if ($arrayIndex.ctx != null) type = new StructType(line, col, $arrayIndex.ast);
        else type = new StructType(line, col, null);
        List<VariableDefinition> varDefs = new ArrayList<>();
        if ($varDef != null) $varDef.forEach(vd -> {if (vd != null) varDefs.add(vd.ast); });
        $ast = new StructDefinition(line, col, type, List.of($ID.text), varDefs);
    }
    ;

arrayIndex returns [Expression ast]:
    lb=LEFT_BRACKET expression RIGHT_BRACKET ai=arrayIndex?
    { $ast = new ArrayIndex($lb.getLine(), $lb.getCharPositionInLine()+1, $expression.ast, ($ai.ctx != null) ? $ai.ast : null); }
    ;

// allow for no parameters or multiple parameters
// defined by specifying the return type, the function identifier, and a list of comma-separated parameters between ( and ). The return type and parameter types must be built-in
// (i.e., no arrays). The function body goes between { and }. The bodies of functions are sequences of local variable definitions, followed by sequences of statements.
// Both must end with the ";" character
functionDefinition returns [FunctionDefinition ast]:
    funcType=type id=ID LEFT_PAREN ((paramType+=type) paramId+=ID (COMMA (paramType+=type) paramId+=ID)+)? RIGHT_PAREN block
    {
        List<VariableDefinition> paramType = new ArrayList<>();
        if ($paramType != null) {
            for (int i = 0; i < $paramType.size(); i++) {
                paramType.add(new VariableDefinition($paramType.get(i).start.getLine(), $paramType.get(i).start.getCharPositionInLine()+1, $paramType.get(i).ast, List.of($paramId.get(i).getText())));
            }
        }
        $ast = new FunctionDefinition($funcType.start.getLine(), $funcType.start.getCharPositionInLine()+1, $funcType.ast, $id.text, paramType, $block.ast);
    }
    ;

// allow for multiple statements within the block
block returns [List<Statement> ast]:
    LEFT_BRACE (stmts+=statement)* RIGHT_BRACE
    {
        List<Statement> stmts = new ArrayList<>();
        if ($stmts != null) $stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
        $ast = stmts;
    }
    ;

// expression
expression returns [Expression ast]:
    // 1: cast
    lp=LEFT_PAREN castType=type RIGHT_PAREN e=expression
    { $ast = new Cast($lp.getLine(), $lp.getCharPositionInLine()+1, $castType.ast, $e.ast); }
    // 2: array access
    | e=expression ai=arrayIndex
    { $ast = new ArrayAccess($e.start.getLine(), $e.start.getCharPositionInLine()+1, $e.ast, $ai.ast); }
    // 3: unary minus
    | min=MINUS expression
    { $ast = new UnaryMinus($min.getLine(), $min.getCharPositionInLine()+1, $expression.ast); }
    // 4: logical not
    | logNot=LOGICAL_NOT expression
    { $ast = new LogicalNot($logNot.getLine(), $logNot.getCharPositionInLine()+1, $expression.ast); }
    // 5: arithmetic additive
    | e1=expression op=(PLUS | MINUS) e2=expression
    { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    // 6: arithemtic multiplicative
    | e1=expression op=(MULTIPLY | DIVIDE | MODULO) e2=expression
    { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    // 7: relational comparison
    | e1=expression op=(RELATIONAL_LESS_THAN | RELATIONAL_LESS_EQUAL | RELATIONAL_GREATER_THAN | RELATIONAL_GREATER_EQUAL) e2=expression
    { $ast = new Relational($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    // 8: relational equality
    | e1=expression op=(RELATIONAL_EQUAL | RELATIONAL_NOT_EQUAL) e2=expression
    { $ast = new Relational($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    // 9: logical
    | e1=expression op=(LOGICAL_AND | LOGICAL_OR) e2=expression
    { $ast = new Logical($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    // 10: procedure invoke without assignment
    | functionInvocation
    { $ast = $functionInvocation.ast; }
    // 11: parentheses
    | lp=LEFT_PAREN expression RIGHT_PAREN
    { $ast = new Parenthesis($lp.getLine(), $lp.getCharPositionInLine()+1, $expression.ast); }
    // 12: struct access
    | e=expression DOT ID // Fields in structs can be obtained with the “.” operator.
    { $ast = new StructAccess($e.start.getLine(), $e.start.getCharPositionInLine()+1, $e.ast, $ID.text); }
    // 13: identifier
    | ID
    { $ast = new Id($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
    // 14: int literal
    | INT_CONSTANT
    { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
    // 15: double literal
    | DOUBLE_CONSTANT
    { $ast = new DoubleLiteral($DOUBLE_CONSTANT.getLine(), $DOUBLE_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToDouble($DOUBLE_CONSTANT.text)); }
    // 16: char literal
    | CHAR_CONSTANT
    { $ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
    ;

// allow for no parameters or multiple parameters
functionInvocation returns [Expression ast]:
    ID LEFT_PAREN (exp+=expression (COMMA exp+=expression)*)? RIGHT_PAREN
    {
        List<Expression> exp = new ArrayList<>();
        if ($exp != null) $exp.forEach(e -> {if (e != null) exp.add(e.ast); });
        $ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, exp);
    }
    ;

// types

type returns [Type ast]:
    // 1: int array
    int=INT arrayIndex?
    { $ast = new IntType($int.getLine(), $int.getCharPositionInLine()+1, $arrayIndex.ctx != null ? $arrayIndex.ast : null); }
    // 2: double array
    | double=DOUBLE arrayIndex?
    { $ast = new DoubleType($double.getLine(), $double.getCharPositionInLine()+1, $arrayIndex.ctx != null ? $arrayIndex.ast : null); }
    // 3: char array
    | char=CHAR arrayIndex?
    { $ast = new CharType($char.getLine(), $char.getCharPositionInLine()+1, $arrayIndex.ctx != null ? $arrayIndex.ast : null); }
    // 4: struct array
    | struct=STRUCT arrayIndex?
    { $ast = new StructType($struct.getLine(), $struct.getCharPositionInLine()+1, $arrayIndex.ctx != null ? $arrayIndex.ast : null); }
    // 5: void type (only for function return types)
    | void=VOID
    { $ast = new VoidType($void.getLine(), $void.getCharPositionInLine()+1); }
    ;


/************************** Lexer rules **************************/

// fragments
fragment
DIGIT:
    [0-9]
    ;

fragment
NEW_LINE:
    '\n'
    | '\r\n'
    ;

fragment
TAB:
    '\t'
    ;

fragment
LETTER:
    [a-zA-Z]
    ;

// e or E followed by optional sign then by an integer
fragment
EXPONENT_CONSTANT:
    [eE][+-]?INT_CONSTANT
    ;

// special escaped characters: \t, \n, \r, \', \", \\
fragment
ESCAPED_SPECIALS:
    '\\' [tnr"'\\]
    ;


// ascii codes from \0 to \255
fragment
ASCII_CODE:
    '\\' DIGIT DIGIT?
    | '\\' '1' DIGIT DIGIT
    | '\\' '2' [0-4] DIGIT
    | '\\' '25' [0-5]
    ;

// skips
WHITE_SPACES:
    (' ' | TAB | NEW_LINE)+ -> skip
    ;

SINGLE_LINE_COMMENT:
    '//' .*? (NEW_LINE | EOF) -> skip
    ;

MULTI_LINE_COMMENT:
    '/*' .*? '*/' -> skip
    ;

// lexers

SEMICOLON: ';';

LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';

DOT: '.';
COMMA: ',';
ASSIGN: '=';

PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
MODULO: '%';

RELATIONAL_EQUAL: '==';
RELATIONAL_NOT_EQUAL: '!=';
RELATIONAL_LESS_THAN: '<';
RELATIONAL_LESS_EQUAL: '<=';
RELATIONAL_GREATER_THAN: '>';
RELATIONAL_GREATER_EQUAL: '>=';

LOGICAL_AND: '&&';
LOGICAL_OR: '||';
LOGICAL_NOT: '!';

// keywords
READ: 'read';
WRITE: 'write';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
STRUCT: 'struct';
INT: 'int';
DOUBLE: 'double';
CHAR: 'char';
VOID: 'void';
MAIN: 'main';

// allow for any combination of "_" and letters + an optional any combination of _, letters and digits
ID:
    ('_' | LETTER) ('_' | LETTER | DIGIT)*
    ;

// allow for 0 OR any int > 0
INT_CONSTANT:
    '0'
    | [1-9] DIGIT*
    ;

// allow for "int.int", ".int" and "int." with an optional exponent
// exponent is also allowed with int exponent
DOUBLE_CONSTANT:
    INT_CONSTANT? DOT INT_CONSTANT EXPONENT_CONSTANT?
    | INT_CONSTANT DOT INT_CONSTANT? EXPONENT_CONSTANT?
    | INT_CONSTANT EXPONENT_CONSTANT
    ;

// allow for a single character, an escaped special character or an ascii code between ''
CHAR_CONSTANT:
    '\''
        (
            ESCAPED_SPECIALS
            | ASCII_CODE
            | NEW_LINE
            | TAB
            | ~[']
        )
    '\''
    ;