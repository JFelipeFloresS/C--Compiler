package visitor;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.StructDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP, TR> {

  // STATEMENTS

  public TR visit (FunctionDefinition funcDef, TP param);
  public TR visit (StructDefinition structDef, TP param);
  public TR visit (VariableDefinition varDef, TP param);
  public TR visit (Assignment assignment, TP param);
  public TR visit (IfElse ifElse, TP param);
  public TR visit (ProcedureInvocation invocation, TP param);
  public TR visit (Read read, TP param);
  public TR visit (Return _return, TP param);
  public TR visit (While write, TP param);
  public TR visit (Write write, TP param);

  // EXPRESSIONS

  public TR visit (Arithmetic arithmetic, TP param);
  public TR visit (ArrayAccess arrayAccess, TP param);
  public TR visit (ArrayIndex arrayIndex, TP param);
  public TR visit (Cast cast, TP param);
  public TR visit (CharLiteral charLiteral, TP param);
  public TR visit (DoubleLiteral doubleLiteral, TP param);
  public TR visit (FunctionInvocation functionInvocation, TP param);
  public TR visit (Id id, TP param);
  public TR visit (IntLiteral intLiteral, TP param);
  public TR visit (Logical logical, TP param);
  public TR visit (LogicalNot logicalNot, TP param);
  public TR visit (Parenthesis parenthesis, TP param);
  public TR visit (Relational relational, TP param);
  public TR visit (StructAccess structAccess, TP param);
  public TR visit (UnaryMinus unaryMinus, TP param);

  // TYPES

  public TR visit (CharType charType, TP param);
  public TR visit (DoubleType doubleType, TP param);
  public TR visit (IntType intType, TP param);
  public TR visit (StructType structType, TP param);
  public TR visit (VoidType voidType, TP param);
  public TR visit (FunctionType functionType, TP param);
  public TR visit (ErrorType errorType, TP param);

  // PROGRAM

  public TR visit (Program program, TP param);
}
