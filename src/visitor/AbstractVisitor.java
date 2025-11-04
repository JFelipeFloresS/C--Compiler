package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

  // STATEMENTS

  @Override
  public TR visit(FunctionDefinition funcDef, TP param) {
    funcDef.getType().accept(this, param);

    for (VariableDefinition varDef : funcDef.getLocalVars()) {
      varDef.accept(this, param);
    }

    for (Statement stmt : funcDef.getStmtsBlock()) {
      stmt.accept(this, param);
    }

    funcDef.getType().accept(this, param);

    return null;
  }

  @Override
  public TR visit(VariableDefinition varDef, TP param) {
    varDef.getType().accept(this, param);
    return null;
  }

  @Override
  public TR visit(Assignment assignment, TP param) {
    assignment.getTarget().accept(this, param);
    assignment.getValue().accept(this, param);

    // First check if target type exists
    Type targetType = assignment.getTarget().getType();
    if (targetType == null) {
      // Handle the case where target type is null
      // You might want to create an ErrorType or take other appropriate action
      assignment.setType(new ErrorType("Target has no type", assignment));
      return null;
    }

    // Now safely use the target type for assignment checking
    assignment.setType(targetType.assignment(assignment.getValue().getType(), assignment));
    return null;
  }

  @Override
  public TR visit(IfElse ifElse, TP param) {
    for (Statement stmt : ifElse.getThenStatements()) {
      stmt.accept(this, param);
    }
    for (Statement stmt : ifElse.getElseStatements()) {
      stmt.accept(this, param);
    }
    return null;
  }

  @Override
  public TR visit(ProcedureInvocation invocation, TP param) {
    invocation.getProcedureId().accept(this, param);
    return null;
  }

  @Override
  public TR visit(Read read, TP param) {
    for (Expression expr : read.getExpressions()) {
      expr.accept(this, param);
    }
    return null;
  }

  @Override
  public TR visit(Return _return, TP param) {
    _return.getExpression().accept(this, param);
    return null;
  }

  @Override
  public TR visit(While write, TP param) {
    for (Statement stmt : write.getThenStatements()) {
      stmt.accept(this, param);
    }
    return null;
  }

  @Override
  public TR visit(Write write, TP param) {
    for (Expression expr : write.getExpressions()) {
      expr.accept(this, param);
    }
    return null;
  }

  // EXPRESSIONS

  @Override
  public TR visit(Arithmetic arithmetic, TP param) {
    arithmetic.getLeft().accept(this, param);
    arithmetic.getRight().accept(this, param);
    return null;
  }

  @Override
  public TR visit(ArrayAccess arrayAccess, TP param) {
    arrayAccess.getArray().accept(this, param);
    arrayAccess.getIndex().accept(this, param);
    arrayAccess.setType(arrayAccess.getArray().getType());
    return null;
  }

  @Override
  public TR visit(Cast cast, TP param) {
    cast.getExpression().accept(this, param);
    return null;
  }

  @Override
  public TR visit(CharLiteral charLiteral, TP param) {
    return null;
  }

  @Override
  public TR visit(DoubleLiteral doubleLiteral, TP param) {
    return null;
  }

  @Override
  public TR visit(FunctionInvocation functionInvocation, TP param) {
    functionInvocation.getFunctionId().accept(this, param);
    return null;
  }

  @Override
  public TR visit(Id id, TP param) {
    if ( id.getDefinition() != null )
      id.getDefinition().accept(this, param);
    return null;
  }

  @Override
  public TR visit(IntLiteral intLiteral, TP param) {
    return null;
  }

  @Override
  public TR visit(Logical logical, TP param) {
    logical.getLeft().accept(this, param);
    logical.getRight().accept(this, param);
    return null;
  }

  @Override
  public TR visit(LogicalNot logicalNot, TP param) {
    logicalNot.getExpression().accept(this, param);
    return null;
  }

  @Override
  public TR visit(Parenthesis parenthesis, TP param) {
    parenthesis.getExpression().accept(this, param);
    return null;
  }

  @Override
  public TR visit(Relational relational, TP param) {
    relational.getLeft().accept(this, param);
    relational.getRight().accept(this, param);
    return null;
  }

  @Override
  public TR visit(StructAccess structAccess, TP param) {
    structAccess.getStructExpression().accept(this, param);
    return null;
  }

  @Override
  public TR visit(UnaryMinus unaryMinus, TP param) {
    unaryMinus.getExpression().accept(this, param);
    return null;
  }

  // TYPES

  @Override
  public TR visit(CharType charType, TP param) {
    return null;
  }

  @Override
  public TR visit(DoubleType doubleType, TP param) {
    return null;
  }

  @Override
  public TR visit(IntType intType, TP param) {
    return null;
  }

  @Override
  public TR visit(StructType structType, TP param) {
    return null;
  }

  @Override
  public TR visit(VoidType voidType, TP param) {
    return null;
  }

  @Override
  public TR visit(FunctionType functionType, TP param) {
    for (VariableDefinition varDef : functionType.getParams()) {
      varDef.accept(this, param);
    }
    functionType.getReturnType().accept(this, param);
    return null;
  }

  @Override
  public TR visit(ErrorType errorType, TP param) {
    return null;
  }

  @Override
  public TR visit(ArrayType arrayType, TP param) {
    arrayType.getBuiltInType().accept(this, param);
    return null;
  }

  // PROGRAM

  @Override
  public TR visit(Program program, TP param) {

    for (Definition def : program.getDefinitions()) {
      if (def != null) {
        def.accept(this, param);
      }
    }

    return null;
  }
}
