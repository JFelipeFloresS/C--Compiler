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
        assertEquals(37, errors.size());

        errors.sort((ErrorType e1, ErrorType e2) -> {
            if (e1.getLine() != e2.getLine()) {
                return Integer.compare(e1.getLine(), e2.getLine());
            } else {
                return Integer.compare(e1.getColumn(), e2.getColumn());
            }
        });

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).",
                new IntType(9, 5)),
            errors.get(0));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).",
                new IntType(17, 5)),
            errors.get(1));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to char. Try casting (char).",
                new IntType(18, 5)),
            errors.get(2));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(19, 5)),
            errors.get(3));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(21, 5)),
            errors.get(4));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(22, 5)),
            errors.get(5));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).",
                new IntType(24, 5)),
            errors.get(6));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to char. Try casting (char).",
                new IntType(25, 5)),
            errors.get(7));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(37, 9)),
            errors.get(8));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(38, 9)),
            errors.get(9));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(39, 9)),
            errors.get(10));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(40, 9)),
            errors.get(11));

        assertEquals(new ErrorType("Error: Condition expression must be of type Int, but found double",
                new IntType(41, 12)),
            errors.get(12));

        assertEquals(new ErrorType("Error: Condition expression must be of type Int, but found char",
                new IntType(42, 12)),
            errors.get(13));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(43, 9)),
            errors.get(14));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(44, 9)),
            errors.get(15));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(46, 11)),
            errors.get(16));

        assertEquals(new ErrorType("Error: Variable \"absent\" not defined in function logical_relation_arithmetic_test",
                new IntType(47, 11)),
            errors.get(17));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(48, 11)),
            errors.get(18));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to double. Try casting (double).",
                new IntType(49, 11)),
            errors.get(19));

        assertEquals(new ErrorType("Error: Condition expression must be of type Int, but found double",
                new IntType(50, 12)),
            errors.get(20));

        assertEquals(new ErrorType("Error: Condition expression must be of type Int, but found char",
                new IntType(51, 9)),
            errors.get(21));

        assertEquals(new ErrorType("Error: type function does not match type int",
                new IntType(52, 15)),
            errors.get(22));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(68, 5)),
            errors.get(23));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(69, 5)),
            errors.get(24));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(70, 5)),
            errors.get(25));

        assertEquals(new ErrorType("Error: Incorrect number of arguments in procedure invocation: expected 1 but got 0.",
                new IntType(72, 5)),
            errors.get(26));

        assertEquals(new ErrorType("Error: Incorrect number of arguments in procedure invocation: expected 2 but got 1.",
                new IntType(73, 5)),
            errors.get(27));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from int to double. Try casting (double).",
                new IntType(74, 5)),
            errors.get(28));

        assertEquals(new ErrorType("Error: Not expecting void type here - int expected",
                new IntType(75, 5)),
            errors.get(29));

        assertEquals(new ErrorType("Error: Trying to access index of non-array type int",
                new IntType(80, 11)),
            errors.get(30));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from double to int. Try casting (int).",
                new IntType(81, 5)),
            errors.get(31));

        assertEquals(new ErrorType("Error: Incompatible types: cannot implicitly convert from char to int. Try casting (int).",
                new IntType(82, 5)),
            errors.get(32));

        assertEquals(new ErrorType("Error: Trying to access index of non-array type int",
                new IntType(83, 11)),
            errors.get(33));

        assertEquals(new ErrorType("Error: Cannot assign non-array type int to array type int[] in assignment",
                new IntType(84, 5)),
            errors.get(34));

        assertEquals(new ErrorType("Error: type int[] does not match type int",
                new IntType(85, 5)),
            errors.get(35));

        assertEquals(new ErrorType("Error: Array index must be of type Int, but found char",
                new IntType(86, 11)),
            errors.get(36));
    }

}
