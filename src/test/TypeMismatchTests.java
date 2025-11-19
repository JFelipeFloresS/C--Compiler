package test;

import ast.Program;
import ast.types.ErrorType;
import ast.types.IntType;
import error_handler.ErrorHandler;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;
import visitor.IdentificationVisitor;
import visitor.TypeCheckingVisitor;

import java.io.IOException;
import java.util.List;

import static test.Assertions.assertEquals;

public class TypeMismatchTests {

	public static void main(String[] args) throws IOException {
		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName("./src/test/assets/type-mismatch-test.txt");
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);
		Program ast = parser.program().ast;

		if (parser.getNumberOfSyntaxErrors() > 0) {
			System.err.println("Program with syntax errors. No code was generated.");

			// print parser errors
			parser.getErrorListeners().forEach(listener -> {
				if (listener instanceof BaseErrorListener) {
					listener.syntaxError(parser, null, -1, -1, "See above", null);
				}
			});

			System.exit(1);
		}

		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new TypeCheckingVisitor(), null);

		if (ErrorHandler.getErrorHandler().anyError()) {
			List<ErrorType> errors = ErrorHandler.getErrorHandler().getErrors();
			validateErrors(errors);
		}
	}

	private static void validateErrors(List<ErrorType> errors) {
		assertEquals(47, errors.size());

		errors.sort((ErrorType e1, ErrorType e2) -> {
			if (e1.getLine() != e2.getLine()) {
				return Integer.compare(e1.getLine(), e2.getLine());
			} else {
				return Integer.compare(e1.getColumn(), e2.getColumn());
			}
		});

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).", 9, 5),
			errors.get(0));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).", 17, 5),
			errors.get(1));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to char. Try casting (char).", 18, 5),
			errors.get(2));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 19, 5),
			errors.get(3));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 21, 5),
			errors.get(4));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 22, 5),
			errors.get(5));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).", 24, 5),
			errors.get(6));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to char. Try casting (char).", 25, 5),
			errors.get(7));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 37, 9),
			errors.get(8));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 38, 9),
			errors.get(9));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 39, 9),
			errors.get(10));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 40, 9),
			errors.get(11));

		assertEquals(testErrorType("Error: Condition expression must be of type Int, but found double", 41, 12),
			errors.get(12));

		assertEquals(testErrorType("Error: Condition expression must be of type Int, but found char", 42, 12),
			errors.get(13));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 43, 9),
			errors.get(14));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 44, 9),
			errors.get(15));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 46, 11),
			errors.get(16));

		assertEquals(testErrorType("Error: Variable \"absent\" not defined in function logical_relation_arithmetic_test", 47, 11),
			errors.get(17));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 48, 11),
			errors.get(18));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to double. Try casting (double).", 49, 11),
			errors.get(19));

		assertEquals(testErrorType("Error: Condition expression must be of type Int, but found double", 50, 12),
			errors.get(20));

		assertEquals(testErrorType("Error: Condition expression must be of type Int, but found char", 51, 9),
			errors.get(21));

		assertEquals(testErrorType("Error: type function does not match type int", 52, 15),
			errors.get(22));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 68, 5),
			errors.get(23));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 69, 5),
			errors.get(24));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 70, 5),
			errors.get(25));

		assertEquals(testErrorType("Error: Incorrect number of arguments in procedure invocation: expected 1 but got 0.", 72, 5),
			errors.get(26));

		assertEquals(testErrorType("Error: Incorrect number of arguments in procedure invocation: expected 2 but got 1.", 73, 5),
			errors.get(27));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).", 74, 5),
			errors.get(28));

		assertEquals(testErrorType("Error: Not expecting void type here - int expected", 75, 5),
			errors.get(29));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 88, 5),
			errors.get(30));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from int to char. Try casting (char).", 89, 5),
			errors.get(31));

		assertEquals(testErrorType("Error: Field e not found in struct.", 90, 5),
			errors.get(32));

		assertEquals(testErrorType("Error: Field c not found in struct.", 91, 5),
			errors.get(33));

		assertEquals(testErrorType("Error: type int does not match type struct", 92, 5),
			errors.get(34));

		assertEquals(testErrorType("Error: structs cannot be assigned directly.", 93, 5),
			errors.get(35));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 94, 5),
			errors.get(36));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from int to char. Try casting (char).", 95, 5),
			errors.get(37));

		assertEquals(testErrorType("Error: structs cannot be assigned directly.", 96, 5),
			errors.get(38));

		assertEquals(testErrorType("Error: type char does not match type struct", 97, 5),
			errors.get(39));

		assertEquals(testErrorType("Error: Trying to access index of non-array type int", 104, 11),
			errors.get(40));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).", 105, 5),
			errors.get(41));

		assertEquals(testErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).", 106, 5),
			errors.get(42));

		assertEquals(testErrorType("Error: Trying to access index of non-array type int", 107, 11),
			errors.get(43));

		assertEquals(testErrorType("Error: Cannot assign non-array type int to array type int[] in assignment", 108, 5),
			errors.get(44));

		assertEquals(testErrorType("Error: type int[] does not match type int", 109, 5),
			errors.get(45));

		assertEquals(testErrorType("Error: Array index must be of type Int, but found char", 110, 11),
			errors.get(46));
	}

	/**
	 * Helper method to create a dummy ErrorType for testing purposes.
	 * It uses IntType to store line and column information because ErrorType needs a Locatable and IntType is a simple implementation of Locatable.
	 *
	 * @param errorMessage - the error message
	 * @param line         - line number
	 * @param column       - column number
	 * @return a new ErrorType instance
	 */
	private static ErrorType testErrorType(String errorMessage, int line, int column) {
		return new ErrorType(errorMessage, new IntType(line, column));
	}

}
