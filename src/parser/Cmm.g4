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
    (defs+=definition)*? VOID main=MAIN LEFT_PAREN RIGHT_PAREN LEFT_BRACE varDefList? stmtList? RIGHT_BRACE EOF
    {
        List<Definition> defs = new ArrayList<>();
        if ($defs != null) $defs.forEach(s -> {if (s != null) defs.add(s.ast); });
        Type mainFuncType = new FunctionType($VOID.getLine(), $VOID.getCharPositionInLine()+1, new VoidType($VOID.getLine(), $VOID.getCharPositionInLine()+1), new ArrayList<>());
        FunctionDefinition mainFunction = new FunctionDefinition($VOID.getLine(), $VOID.getCharPositionInLine()+1, mainFuncType, new Id($main.getLine(), $main.getCharPositionInLine()+1, $main.getText()), $varDefList.ctx != null ? $varDefList.ast : new ArrayList<VariableDefinition>(), $stmtList.ctx != null ? $stmtList.ast : new ArrayList<Statement>());
        defs.add(mainFunction);
        $ast = new Program(defs);
    }
    ;

// statement
statement returns [Statement ast]:
    // 1: read
    read=READ assignableExpressionList SEMICOLON // Write and read statements could specify a list of (at least one) expressions.
    {
        $ast = new Read($read.getLine(), $read.getCharPositionInLine()+1, $assignableExpressionList.ast);
    }
    // 2: write
    | write=WRITE expressionList SEMICOLON // write: allow for procedure invoke in write as well
    {
        $ast = new Write($write.getLine(), $write.getCharPositionInLine()+1, $expressionList.ast);
    }
    // 3: return
    | return=RETURN expression SEMICOLON // return: the expression after the return keyword is mandatory; i.e., return; is not a valid statement in this language
    { $ast = new Return($return.getLine(), $return.getCharPositionInLine()+1, $expression.ast); }
    // 4: assignment
    | e1=assignableExpression ASSIGN e2=expression SEMICOLON // assignment
    { $ast = new Assignment($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
    // 5: if/else
    | if=IF LEFT_PAREN expression 
        RIGHT_PAREN thenSt=stmtBlock
        (ELSE elseSt=stmtBlock)? // if/else: allow for single statement or stmtBlock as body for if and else statements
    {
        $ast = new IfElse($if.getLine(), $if.getCharPositionInLine()+1, $expression.ast, $thenSt.ast, $elseSt.ctx != null ? $elseSt.ast : new ArrayList<>());
    }
    // 6: while
    | while=WHILE LEFT_PAREN expression RIGHT_PAREN stmtBlock // while: allow for single statement or stmtBlock as body
    {
        $ast = new While($while.getLine(), $while.getCharPositionInLine()+1, $expression.ast, $stmtBlock.ast);
    }
    // 7: procedure invoke
    | procedureInvocation SEMICOLON // procedure invoke
    { $ast = $procedureInvocation.ast; }
    ;

// allow for no parameters or multiple parameters
procedureInvocation returns [Statement ast]:
    ID LEFT_PAREN RIGHT_PAREN
    {
        $ast = new ProcedureInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Id($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), new ArrayList<>());
    }
    |
    ID LEFT_PAREN expressionList RIGHT_PAREN
    {
        $ast = new ProcedureInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Id($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), $expressionList.ast);
    }
    ;

// definition

definition returns [Definition ast]:
    // 1: variable definition
    varDefinition // variable definition
    { $ast = $varDefinition.ast; }
    // 2: function definition
    | functionDefinition // function definition
    { $ast = $functionDefinition.ast; }
    ;

// allow for optional array dimensions and optional initialization on declarations
// Variables with the same type could be declared in the same variable definition.
// Structs could be nested: a field of a record could be another record. They can also be combined with any other type, including arrays.
// The record (struct) type is provided by the language. Struct variables could be local and global. No typedef construction is provided.
varDefinition returns [VariableDefinition ast]:
    // 1: simple variable definition
    t=arrayableType ids+=ID (COMMA ids+=ID)*? SEMICOLON
    {
        List<Id> ids = new ArrayList<>();
        if ($ids != null) $ids.forEach(id -> {if (id != null) ids.add(new Id(id.getLine(), id.getCharPositionInLine()+1, id.getText())); });
        $ast = new VariableDefinition($t.start.getLine(), $t.start.getCharPositionInLine()+1, $t.ast, ids);
    }
    ;

varDefList returns [List<VariableDefinition> ast]:
    (varDefs+=varDefinition)+
    {
        List<VariableDefinition> varDefs = new ArrayList<>();
        if ($varDefs != null) $varDefs.forEach(vd -> {if (vd != null) varDefs.add(vd.ast); });
        $ast = varDefs;
    }
    ;

// allow for no parameters or multiple parameters
// defined by specifying the return type, the function identifier, and a list of comma-separated parameters between ( and ). The return type and parameter types must be built-in
// (i.e., no arrays). The function body goes between { and }. The bodies of functions are sequences of local variable definitions, followed by sequences of statements.
// Both must end with the ";" character
functionDefinition returns [FunctionDefinition ast]:
    returnType=voidableType id=ID LEFT_PAREN paramsList? RIGHT_PAREN
    LEFT_BRACE varDefList? stmtList?  RIGHT_BRACE
    {
        FunctionType returnType = new FunctionType($returnType.start.getLine(), $returnType.start.getCharPositionInLine()+1, $returnType.ast, $paramsList.ctx != null ? $paramsList.ast : new ArrayList<>());
        $ast = new FunctionDefinition($returnType.start.getLine(), $returnType.start.getCharPositionInLine()+1, returnType, new Id($id.getLine(), $id.getCharPositionInLine()+1, $id.text), $varDefList.ctx != null ? $varDefList.ast : new ArrayList<>(), $stmtList.ctx != null ? $stmtList.ast : new ArrayList<>());
    }
    ;

paramsList returns [List<VariableDefinition> ast]:
    params+=paramDef (COMMA params+=paramDef)*?
    {
        List<VariableDefinition> params = new ArrayList<>();
        if ($params != null) $params.forEach(p -> {if (p != null) params.add(p.ast); });
        $ast = params;
    }
    ;

paramDef returns [VariableDefinition ast]:
    t=arrayableType id=ID
    {
        List<Id> ids = new ArrayList<>();
        ids.add(new Id($id.getLine(), $id.getCharPositionInLine()+1, $id.getText()));
        $ast = new VariableDefinition($t.start.getLine(), $t.start.getCharPositionInLine()+1, $t.ast, ids);
    }
    ;

recordFieldList returns [List<StructRecordField> ast]:
    field+=recordField SEMICOLON (field+=recordField SEMICOLON)*?
    {
        List<StructRecordField> fields = new ArrayList<>();
        if ($field != null) $field.forEach(f -> {if (f != null) fields.add(f.ast); });
        $ast = fields;
    }
    ;

recordField returns [StructRecordField ast]:
    type=arrayableType id+=ID (COMMA id+=ID)*?
    {
        List<Id> ids = new ArrayList<>();
        if ($id != null) $id.forEach(i -> {if (i != null) ids.add(new Id(i.getLine(), i.getCharPositionInLine()+1, i.getText())); });
        $ast = new StructRecordField($type.ast.getLine(), $type.ast.getColumn(), $type.ast, ids);
    }
    ;

// allow for multiple statements within the stmtBlock
stmtBlock returns [List<Statement> ast]:
    LEFT_BRACE stmtList? RIGHT_BRACE
    {
        $ast = $stmtList.ctx != null ? $stmtList.ast : new ArrayList<>();
    }
    | statement
    {
        List<Statement> stmts = new ArrayList<>();
        stmts.add($statement.ast);
        $ast = stmts;
    }
    ;

stmtList returns [List<Statement> ast]:
    (stmts+=statement)+
    {
        List<Statement> stmts = new ArrayList<>();
        if ($stmts != null) $stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
        $ast = stmts;
    }
    ;

// expression
expression returns [Expression ast]:
    logicalOrExpression
    { $ast = $logicalOrExpression.ast; }
    ;

logicalOrExpression returns [Expression ast]:
    e1=logicalAndExpression { $ast = $e1.ast; }
    (
        op=LOGICAL_OR e2=logicalAndExpression
        { $ast = new Logical($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $ast, $op.text, $e2.ast); }
    )*
    ;

logicalAndExpression returns [Expression ast]:
    e1=relationalExpression { $ast = $e1.ast; }
    (
        op=LOGICAL_AND e2=relationalExpression
        { $ast = new Logical($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $ast, $op.text, $e2.ast); }
    )*
    ;

relationalExpression returns [Expression ast]:
    e1=additiveExpression { $ast = $e1.ast; }
    (
        op=(RELATIONAL_EQUAL | RELATIONAL_NOT_EQUAL | RELATIONAL_LESS_THAN | RELATIONAL_LESS_EQUAL | RELATIONAL_GREATER_THAN | RELATIONAL_GREATER_EQUAL) e2=additiveExpression
        { $ast = new Relational($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $ast, $op.text, $e2.ast); }
    )*
    ;

additiveExpression returns [Expression ast]:
    e1=multiplicativeExpression { $ast = $e1.ast; }
    (
        op=(PLUS | MINUS) e2=multiplicativeExpression
        { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $ast, $op.text, $e2.ast); }
    )*
    ;

multiplicativeExpression returns [Expression ast]:
    e1=unaryExpression { $ast = $e1.ast; }
    (
        op=(MULTIPLY | DIVIDE | MODULO) e2=unaryExpression
        {
            if ($op.type == CmmParser.MODULO) {
                $ast = new Modulus($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $ast, $e2.ast);
            } else {
                $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $ast, $op.text, $e2.ast);
            }
        }
    )*
    ;

unaryExpression returns [Expression ast]:
    // 1: cast
    lp=LEFT_PAREN castType=builtInType RIGHT_PAREN e=unaryExpression
    { $ast = new Cast($lp.getLine(), $lp.getCharPositionInLine()+1, $castType.ast, $e.ast); }
    // 2: unary minus
    | min=MINUS e=unaryExpression
    { $ast = new UnaryMinus($min.getLine(), $min.getCharPositionInLine()+1, $e.ast); }
    // 3: logical not
    | logNot=LOGICAL_NOT e=unaryExpression
    { $ast = new LogicalNot($logNot.getLine(), $logNot.getCharPositionInLine()+1, $e.ast); }
    // 4: primary expression
    | primaryExpression
    { $ast = $primaryExpression.ast; }
    ;

primaryExpression returns [Expression ast]:
    // 1: parentheses
    lp=LEFT_PAREN expression RIGHT_PAREN
    { $ast = new Parenthesis($lp.getLine(), $lp.getCharPositionInLine()+1, $expression.ast); }
    // 2: int literal
    | INT_CONSTANT
    { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
    // 3: double literal
    | DOUBLE_CONSTANT
    { $ast = new DoubleLiteral($DOUBLE_CONSTANT.getLine(), $DOUBLE_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToDouble($DOUBLE_CONSTANT.text)); }
    // 4: char literal
    | CHAR_CONSTANT
    { $ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
    // 5: function invocation
    | functionInvocation
    { $ast = $functionInvocation.ast; }
    // 6: assignable expression
    | assignableExpression
    { $ast = $assignableExpression.ast; }
    ;

assignableExpression returns [Expression ast]:
    // 1: array access
    | e=assignableExpression lb=LEFT_BRACKET ai=expression rb=RIGHT_BRACKET
    { $ast = new ArrayAccess($e.start.getLine(), $e.start.getCharPositionInLine()+1, $e.ast, $ai.ast); }
    // 2: struct access
    | e=assignableExpression DOT ID // Fields in structs can be obtained with the “.” operator.
    { $ast = new StructAccess($e.start.getLine(), $e.start.getCharPositionInLine()+1, $e.ast, $ID.text); }
    // 3: identifier
    | ID
    { $ast = new Id($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
    ;

expressionList returns [List<Expression> ast]:
    exp+=expression (COMMA exp+=expression)*
    {
        List<Expression> exp = new ArrayList<>();
        if ($exp != null) $exp.forEach(e -> {if (e.ast != null) exp.add(e.ast); });
        $ast = exp;
    }
    ;

assignableExpressionList returns [List<Expression> ast]:
    exp+=assignableExpression (COMMA exp+=assignableExpression)*
    {
        List<Expression> exp = new ArrayList<>();
        if ($exp != null) $exp.forEach(e -> {if (e.ast != null) exp.add(e.ast); });
        $ast = exp;
    }
    ;

// allow for no parameters or multiple parameters
functionInvocation returns [Expression ast]:
    ID LEFT_PAREN RIGHT_PAREN
    {
        $ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Id($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), new ArrayList<>());
    }
    |
    ID LEFT_PAREN expressionList RIGHT_PAREN
    {
        $ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Id($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), $expressionList.ast);
    }
    ;

// types

voidableType returns [Type ast]:
    // 1: built in types (int, double, char)
    baseType=builtInType
    { $ast = $baseType.ast; }
    // 2: void type
    | void=VOID
    { $ast = new VoidType($void.getLine(), $void.getCharPositionInLine()+1); }
    ;

arrayableType returns [Type ast]:
    // 1: built in types (int, double, char)
    baseType=builtInType
    { $ast = $baseType.ast; }
    // 2: struct variable definition
    | struct=STRUCT LEFT_BRACE recordFieldList RIGHT_BRACE
    {
        int line = _localctx.getStart().getLine();
        int col = _localctx.getStart().getCharPositionInLine()+1;
        $ast = new StructType(line, col, $recordFieldList.ast);
    }
    // 3: array type
    | type=arrayableType '[' INT_CONSTANT ']'
    {
        int size = LexerHelper.lexemeToInt($INT_CONSTANT.text);
        $ast = new ArrayType($type.ast.getLine(), $type.ast.getColumn(), $type.ast, size);
    }
    ;

builtInType returns [Type ast]:
    // 1: int type
    int=INT
    { $ast = new IntType($int.getLine(), $int.getCharPositionInLine()+1); }
    // 2: double type
    | double=DOUBLE
    { $ast = new DoubleType($double.getLine(), $double.getCharPositionInLine()+1); }
    // 3: char type
    | char=CHAR
    { $ast = new CharType($char.getLine(), $char.getCharPositionInLine()+1); }
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

// special escaped characters: \', \", \\
fragment
ESCAPED_SPECIALS:
    '\\' ["'\\nrt]
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
            | ~['\r\n\t]
        )
    '\''
    ;