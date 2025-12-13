package visitor;

import ast.definitions.AbstractDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.util.List;

import static utils.TypeMismatchErrorUtils.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

	// STATEMENTS

	@Override
	public Void visit(VariableDefinition varDef, Void param) {
		varDef.getType().accept(this, param);
		varDef.getNames().forEach(name -> {
			name.setDefinition(varDef);
			name.accept(this, param);
		});
		if (varDef.getType() instanceof StructType structType) {
			structType.setStructDefinition(varDef);
			structType.accept(this, param);
		}
		return null;
	}

	@Override
	public Void visit(Assignment assignment, Void param) {
		assignment.getTarget().accept(this, null);
		assignment.getValue().accept(this, null);

		Type targetType = assignment.getTarget().getType();
		Type valueType = assignment.getValue().getType();

		if (targetType instanceof ErrorType) {
			assignment.setType(targetType);
			return null;
		}

		if (valueType instanceof ErrorType) {
			assignment.setType(valueType);
			return null;
		}

		if (!(assignment.getTarget() instanceof Id) && !(assignment.getTarget() instanceof ArrayAccess) && !(assignment.getTarget() instanceof StructAccess)) {
			assignment.setType(getNonAssignableTypeError(targetType, assignment.getTarget()));
			return null;
		}

		if (targetType instanceof ArrayType && !(valueType instanceof ArrayType)) {
			assignment.setType(new ErrorType(
				"Error: Cannot assign non-array type " + getPrettyTypeName(valueType) + " to array type " + getPrettyTypeName(targetType) + " in assignment",
				assignment
			));
			return null;
		}

		if (targetType instanceof ArrayType arrayType) {
			targetType = arrayType.getElementType();
		}

		assignment.setType(targetType);

		if (targetType instanceof StructType && valueType instanceof StructType) {
			assignment.setType(getStructAssignmentError(assignment));
			return null;
		}

		if (targetType.getClass() != valueType.getClass()) {
			ErrorType typeError = getTypeMismatchError(targetType, valueType, assignment);
			assignment.setType(typeError);
		}


		return null;
	}

	@Override
	public Void visit(Return _return, Void param) {
		_return.getExpression().accept(this, null);

		_return.setType(_return.getExpression().getType());

		if (_return.getFuncDef() == null) {
			ErrorType newError = new ErrorType("Error: Return statement not within a function", _return);
			_return.setType(newError);
			return null;
		}

		Type expectedType = ((FunctionType) _return.getFuncDef().getType()).getReturnType();
		Type returnType = _return.getType();

		if (expectedType instanceof ErrorType) {
			_return.setType(expectedType);
			return null;
		}

		if (returnType instanceof ErrorType) {
			_return.setType(returnType);
			return null;
		}

		if (expectedType.getClass() != returnType.getClass()) {
			ErrorType typeError = getTypeMismatchError(expectedType, returnType, _return);
			_return.setType(typeError);
		}

		return null;
	}

	@Override
	public Void visit(Read read, Void param) {
		Type currentType = null;
		for (Expression expr : read.getExpressions()) {
			expr.accept(this, null);
			if (currentType == null)
				currentType = expr.getType();

			// If one of the types is an error, propagate it
			if (currentType instanceof ErrorType) {
				expr.setType(currentType);
				continue;
			}

			if (!(expr instanceof Id) && !(expr instanceof ArrayAccess) && !(expr instanceof StructAccess)) {
				ErrorType typeError = getNonAssignableTypeError(expr.getType(), expr);
				expr.setType(typeError);
				read.setType(typeError);
				continue;
			}

			// If types are incompatible, report an error
			if (currentType != expr.getType()) {
				ErrorType typeError = new ErrorType("Error: Incompatible types in read statement", read);
				expr.setType(typeError);
				read.setType(typeError);
				currentType = typeError;
			}
		}

		read.setType(currentType);
		return null;
	}

	@Override
	public Void visit(Write write, Void param) {
		Type currentType = null;
		for (Expression expr : write.getExpressions()) {
			expr.accept(this, null);
			if (currentType == null)
				currentType = expr.getType();

			// If one of the types is an error, propagate it
			if (currentType instanceof ErrorType) {
				expr.setType(currentType);
				continue;
			}

			// If types are incompatible, report an error
			if (currentType != expr.getType()) {
				ErrorType typeError = new ErrorType("Error: Incompatible types in write statement", write);
				expr.setType(typeError);
				write.setType(typeError);
				currentType = typeError;
			}
		}

		write.setType(currentType);
		return null;
	}

	@Override
	public Void visit(While _while, Void param) {
		_while.getCondition().accept(this, null);
		_while.getThenStatements().forEach(t -> t.accept(this, null));

		if (_while.getCondition().getType() instanceof ErrorType) {
			_while.setType(_while.getCondition().getType());
			return null;
		}

		if (!(_while.getCondition().getType() instanceof IntType)) {
			ErrorType typeError = getConditionTypeError(_while.getCondition().getType(), _while.getCondition());
			_while.getCondition().setType(typeError);
		}

		_while.setType(_while.getCondition().getType());
		return null;
	}

	@Override
	public Void visit(IfElse _ifElse, Void param) {
		_ifElse.getCondition().accept(this, null);
		_ifElse.getThenStatements().forEach(t -> t.accept(this, null));
		_ifElse.getElseStatements().forEach(e -> e.accept(this, null));

		if (_ifElse.getCondition().getType() instanceof ErrorType) {
			_ifElse.setType(_ifElse.getCondition().getType());
			return null;
		}

		if (!(_ifElse.getCondition().getType() instanceof IntType)) {
			ErrorType typeError = getConditionTypeError(_ifElse.getCondition().getType(), _ifElse.getCondition());
			_ifElse.getCondition().setType(typeError);
		}

		_ifElse.setType(_ifElse.getCondition().getType());
		return null;
	}

	// EXPRESSIONS

	@Override
	public Void visit(Arithmetic arithmetic, Void param) {
		arithmetic.getLeft().accept(this, null);
		arithmetic.getRight().accept(this, null);

		if (arithmetic.getLeft().getType() != null && arithmetic.getRight().getType() != null) {
			arithmetic.setType(
				arithmetic.getLeft().getType().arithmetic(arithmetic.getRight().getType(), arithmetic)
			);
		}
		return null;
	}

	@Override
	public Void visit(ArrayAccess arrayAccess, Void param) {
		arrayAccess.getArray().accept(this, null);
		arrayAccess.getIndex().accept(this, null);

		Type arrayType = arrayAccess.getArray().getType();

		if (arrayType instanceof ErrorType) {
			arrayAccess.setType(arrayType);
			return null;
		}

		if (!(arrayType instanceof ArrayType)) {
			ErrorType typeError = getNonArrayTypeError(arrayType, arrayAccess);
			arrayAccess.setType(typeError);
			return null;
		}

		if (!(arrayAccess.getIndex().getType() instanceof IntType)) {
			ErrorType typeError = getIndexTypeError(arrayAccess.getIndex().getType(), arrayAccess);
			arrayAccess.getIndex().setType(typeError);
			arrayAccess.setType(typeError);
			return null;
		}

		arrayAccess.setType(((ArrayType) arrayType).getElementType());

		return null;
	}

	@Override
	public Void visit(Cast cast, Void param) {
		cast.getExpression().accept(this, null);
		return null;
	}

	@Override
	public Void visit(Logical logical, Void param) {
		logical.getLeft().accept(this, null);
		logical.getRight().accept(this, null);
		logical.setType(
			logical.getLeft().getType().logical(logical.getRight().getType(),
				logical));
		return null;
	}

	@Override
	public Void visit(LogicalNot logicalNot, Void param) {
		logicalNot.getExpression().accept(this, null);

		if (logicalNot.getExpression().getType() instanceof ErrorType) {
			logicalNot.setType(logicalNot.getExpression().getType());
			return null;
		}

		if (!(logicalNot.getExpression().getType() instanceof IntType)) {
			ErrorType typeError = getTypeMismatchError(new IntType(logicalNot.getLine(), logicalNot.getColumn()), logicalNot.getExpression().getType(), logicalNot);
			logicalNot.getExpression().setType(typeError);
		}

		logicalNot.setType(logicalNot.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(Parenthesis parenthesis, Void param) {
		parenthesis.getExpression().accept(this, null);
		parenthesis.setType(parenthesis.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(Relational relational, Void param) {
		relational.getLeft().accept(this, null);
		relational.getRight().accept(this, null);
		relational.setType(
			relational.getLeft().getType().relational(relational.getRight().getType(),
				relational));
		return null;
	}

	@Override
	public Void visit(StructAccess structAccess, Void param) {
		structAccess.getStructExpression().accept(this, null);

		Type structType = structAccess.getStructExpression().getType();

		if (structType instanceof ErrorType) {
			structAccess.setType(structType);
			return null;
		}

		if (!(structType instanceof StructType)) {
			ErrorType typeError = getNonStructTypeError(structType, structAccess);
			structAccess.setType(typeError);
			return null;
		}

		StructType sType = (StructType) structType;
		StructRecordField fieldDef = sType.getField(structAccess.getFieldName());

		if (fieldDef == null) {
			ErrorType typeError = new ErrorType(
				"Error: Struct type " + getPrettyTypeName(structType) + " has no field named \"" + structAccess.getFieldName() + "\".",
				structAccess
			);
			structAccess.setType(typeError);
			return null;
		}

		structAccess.setType(fieldDef.getType());
		return null;
	}

	@Override
	public Void visit(UnaryMinus unaryMinus, Void param) {
		unaryMinus.getExpression().accept(this, null);
		unaryMinus.setType(unaryMinus.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(IntLiteral intLiteral, Void param) {
		intLiteral.setType(new IntType(intLiteral.getLine(), intLiteral.getColumn()));
		return null;
	}

	@Override
	public Void visit(CharLiteral charLiteral, Void param) {
		charLiteral.setType(new ast.types.CharType(charLiteral.getLine(), charLiteral.getColumn()));
		return null;
	}

	@Override
	public Void visit(DoubleLiteral doubleLiteral, Void param) {
		doubleLiteral.setType(new ast.types.DoubleType(doubleLiteral.getLine(), doubleLiteral.getColumn()));
		return null;
	}

	@Override
	public Void visit(FunctionInvocation funcInvocation, Void param) {
		funcInvocation.getFunctionId().accept(this, null);
		for (Expression arg : funcInvocation.getParameters()) {
			arg.accept(this, null);
		}

		Type funcType = funcInvocation.getFunctionId().getType();

		if (funcType instanceof ErrorType) {
			funcInvocation.setType(funcType);
			return null;
		}

		if (!(funcType instanceof FunctionType)) {
			funcInvocation.setType(new ErrorType("Error: " + funcInvocation.getFunctionId().getName() + " is not a function.", funcInvocation));
			return null;
		}

		FunctionType functionType = (FunctionType) funcType;
		funcInvocation.setType(functionType.getReturnType());

		List<VariableDefinition> expectedParams = functionType.getParams();
		List<Expression> actualArgs = funcInvocation.getParameters();

		if (expectedParams.size() != actualArgs.size()) {
			String errorMessage = "Error: Incorrect number of arguments in function call: expected " +
				expectedParams.size() + " but got " + actualArgs.size() + ".";
			funcInvocation.setType(new ErrorType(errorMessage, funcInvocation));
			return null;
		}

		for (int i = 0; i < expectedParams.size(); i++) {
			Type expectedType = expectedParams.get(i).getType();
			Type actualType = actualArgs.get(i).getType();

			if (expectedType instanceof ErrorType) {
				funcInvocation.setType(expectedType);
				return null;
			}

			if (actualType instanceof ErrorType) {
				funcInvocation.setType(actualType);
				return null;
			}

			if (expectedType.getClass() != actualType.getClass()) {
				ErrorType typeError = getTypeMismatchError(expectedType, actualType, funcInvocation);
				funcInvocation.setType(typeError);
				return null;
			}
		}

		return null;
	}

	@Override
	public Void visit(ProcedureInvocation procedureInvocation, Void param) {
		procedureInvocation.getProcedureId().accept(this, null);
		if (procedureInvocation.getParameters() != null) {
			procedureInvocation.getParameters().forEach(p -> p.accept(this, null));
		}
		procedureInvocation.setType(procedureInvocation.getProcedureId().getType());

		Type procType = procedureInvocation.getProcedureId().getType();

		if (procType instanceof ErrorType) {
			procedureInvocation.setType(procType);
			return null;
		}

		if (!(procType instanceof FunctionType)) {
			procedureInvocation.setType(new ErrorType(
				"Error: " + procedureInvocation.getProcedureId().getName() + " is not a procedure.",
				procedureInvocation
			));
			return null;
		}

		List<Type> expectedTypes = ((FunctionType) procType).getParams() != null
			? ((FunctionType) procType).getParams().stream().map(AbstractDefinition::getType).toList()
			: List.of();
		List<Type> actualTypes;
		if (procedureInvocation.getParameters() == null)
			actualTypes = List.of();
		else
			actualTypes = procedureInvocation.getParameters().stream().map(Expression::getType).toList();

		if (expectedTypes.size() != actualTypes.size()) {
			String errorMessage = "Error: Incorrect number of arguments in procedure invocation: expected " +
				expectedTypes.size() + " but got " + actualTypes.size() + ".";
			ErrorType typeError = new ErrorType(errorMessage, procedureInvocation);
			procedureInvocation.setType(typeError);
			return null;
		}

		for (int i = 0; i < expectedTypes.size(); i++) {
			Type expectedType = expectedTypes.get(i);
			Type actualType = actualTypes.get(i);

			if (expectedType instanceof ErrorType) {
				procedureInvocation.setType(expectedType);
				return null;
			}

			if (actualType instanceof ErrorType) {
				procedureInvocation.setType(actualType);
				return null;
			}

			if (expectedType.getClass() != actualType.getClass()) {
				ErrorType typeError = getTypeMismatchError(expectedType, actualType, procedureInvocation);
				procedureInvocation.setType(typeError);
			}
		}

		return null;
	}

	@Override
	public Void visit(Id id, Void param) {
		if (id.getType() instanceof ErrorType) {
			return null;
		}

		if (id.getDefinition() == null) {
			ErrorType newError = new ErrorType("Error: Identifier \"" + id.getName() + "\" not defined", id);
			id.setType(newError);
			return null;
		}
		id.setType(id.getDefinition().getType());
		return null;
	}

	@Override
	public Void visit(Modulus modulus, Void param) {
		modulus.getLeft().accept(this, null);
		modulus.getRight().accept(this, null);
		if (modulus.getLeft().getType() != null && modulus.getRight().getType() != null) {
			modulus.setType(
				modulus.getLeft().getType().arithmetic(modulus.getRight().getType(), modulus)
			);
		}
		return null;
	}

	// TYPES

	@Override
	public Void visit(ArrayType arrayType, Void param) {
		arrayType.getElementType().accept(this, null);
		if (arrayType.getElementType().getType() != null)
			arrayType.setType(arrayType.getElementType().getType());

		return null;
	}

	@Override
	public Void visit(StructType structType, Void param) {
		return null;
	}

	@Override
	public Void visit(DoubleType doubleType, Void param) {
		doubleType.setType(doubleType);
		return null;
	}

	@Override
	public Void visit(IntType intType, Void param) {
		intType.setType(intType);
		return null;
	}

	@Override
	public Void visit(CharType charType, Void param) {
		charType.setType(charType);
		return null;
	}

}
