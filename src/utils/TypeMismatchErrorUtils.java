package utils;

import ast.locatable.Locatable;
import ast.types.*;

public class TypeMismatchErrorUtils {

	private TypeMismatchErrorUtils() {
	}

	public static ErrorType getTypeMismatchError(Type expectedType,
												 Type actualType,
												 Locatable locatable) {
		return getTypeMismatchError(expectedType, actualType, locatable, false);
	}

	public static ErrorType getTypeMismatchError(Type expectedType,
												 Type actualType,
												 Locatable locatable,
												 boolean isSimplestPriority) {
		String expectedTypeName = getPrettyTypeName(expectedType);
		String actualTypeName = getPrettyTypeName(actualType);
		String errorMessage;

		if (expectedType instanceof VoidType) {
			errorMessage = "Error: Void type not allowed here";
		} else if (actualType instanceof VoidType) {
			errorMessage = "Error: Not expecting void type here - " + expectedTypeName + " expected";
		} else if (expectedType.isBuiltInType() && actualType.isBuiltInType() && isSimplestPriority) {
			errorMessage = getTypeMismatchErrorMessageSimplestPriority(expectedType, actualType);
		} else if (expectedType.isBuiltInType() && actualType.isBuiltInType()) {
			errorMessage = "Error: Incompatible types: cannot implicitly convert from " +
				actualTypeName + " to " + expectedTypeName + ". Try casting (" + expectedTypeName + ").";
		} else {
			errorMessage = "Error: type " + actualTypeName +
				" does not match type " + expectedTypeName;
		}

		return new ErrorType(errorMessage, locatable);
	}

	/**
	 * Simplest priority: int > char > double
	 *
	 * @param expectedType the expected type
	 * @param actualType   the actual type
	 * @return the error message
	 */
	private static String getTypeMismatchErrorMessageSimplestPriority(Type expectedType,
																	  Type actualType) {
		String priority1;
		String priority2;
		if (expectedType instanceof IntType || actualType instanceof IntType) {
			priority1 = "int";
			if (expectedType instanceof CharType || actualType instanceof CharType) {
				priority2 = "char";
			} else {
				priority2 = "double";
			}
		} else {
			priority1 = "double";
			priority2 = "char";
		}
		return "Error: Incompatible types: cannot implicitly convert from " +
			priority2 + " to " + priority1 + ". Try casting (" + priority1 + ").";
	}

	public static ErrorType getConditionTypeError(Type actualType, Locatable node) {
		String errorMessage = "Error: Condition expression must be of type Int, but found " + getPrettyTypeName(actualType);
		return new ErrorType(errorMessage, node);
	}

	public static ErrorType getIndexTypeError(Type actualType, Locatable node) {
		String errorMessage = "Error: Array index must be of type Int, but found " + getPrettyTypeName(actualType);
		return new ErrorType(errorMessage, node);
	}

	public static ErrorType getNonArrayTypeError(Type actualType, Locatable node) {
		String errorMessage = "Error: Trying to access index of non-array type " + getPrettyTypeName(actualType);
		return new ErrorType(errorMessage, node);
	}

	public static ErrorType getNonStructTypeError(Type actualType, Locatable node) {
		String errorMessage = "Error: Trying to access field of non-struct type " + getPrettyTypeName(actualType);
		return new ErrorType(errorMessage, node);
	}

	public static ErrorType getFieldNotFoundError(String fieldName, Locatable node) {
		return new ErrorType("Error: Field " + fieldName + " not found in struct.", node);
	}

	public static ErrorType getNonStructTypeError(Locatable node) {
		return new ErrorType("Error: Expression is not a struct.", node);
	}

	public static ErrorType getStructAssignmentError(Locatable node) {
		String errorMessage = "Error: structs cannot be assigned directly.";
		return new ErrorType(errorMessage, node);
	}

	public static ErrorType getNonAssignableTypeError(Type targetType, Locatable node) {
		String errorMessage = "Error: Trying to assign value to non-assignable type " + getPrettyTypeName(targetType);
		return new ErrorType(errorMessage, node);
	}

	public static String getPrettyTypeName(Type type) {
		String prettyName = type.getClass().getSimpleName().replace("Type", "").toLowerCase();

		if (type instanceof ArrayType arrayType) {
			prettyName = getPrettyTypeName(arrayType.getElementType()) + "[]";
		}

		return prettyName;
	}
}
