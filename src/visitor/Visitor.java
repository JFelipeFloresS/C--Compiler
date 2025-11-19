package visitor;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP, TR> {

	// STATEMENTS

	TR visit(FunctionDefinition funcDef, TP param);

	TR visit(VariableDefinition varDef, TP param);

	TR visit(Assignment assignment, TP param);

	TR visit(IfElse ifElse, TP param);

	TR visit(ProcedureInvocation invocation, TP param);

	TR visit(Read read, TP param);

	TR visit(Return _return, TP param);

	TR visit(While write, TP param);

	TR visit(Write write, TP param);

	// EXPRESSIONS

	TR visit(Arithmetic arithmetic, TP param);

	TR visit(ArrayAccess arrayAccess, TP param);

	TR visit(Cast cast, TP param);

	TR visit(CharLiteral charLiteral, TP param);

	TR visit(DoubleLiteral doubleLiteral, TP param);

	TR visit(FunctionInvocation functionInvocation, TP param);

	TR visit(Id id, TP param);

	TR visit(IntLiteral intLiteral, TP param);

	TR visit(Logical logical, TP param);

	TR visit(LogicalNot logicalNot, TP param);

	TR visit(Modulus modulus, TP param);

	TR visit(Parenthesis parenthesis, TP param);

	TR visit(Relational relational, TP param);

	TR visit(StructAccess structAccess, TP param);

	TR visit(UnaryMinus unaryMinus, TP param);

	// TYPES

	TR visit(StructRecordField recordField, TP param);

	TR visit(CharType charType, TP param);

	TR visit(DoubleType doubleType, TP param);

	TR visit(IntType intType, TP param);

	TR visit(ArrayType arrayType, TP param);

	TR visit(StructType structType, TP param);

	TR visit(VoidType voidType, TP param);

	TR visit(FunctionType functionType, TP param);

	TR visit(ErrorType errorType, TP param);

	// PROGRAM

	TR visit(Program program, TP param);
}
