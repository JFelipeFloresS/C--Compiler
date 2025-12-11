package test;

import ast.Program;
import cg.CG;
import error_handler.ErrorHandler;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;
import visitor.IdentificationVisitor;
import visitor.TypeCheckingVisitor;
import visitor.cg.ExecuteCGVisitor;

import java.nio.file.Path;

public class BasicCodeGeneratorTest {
	public static void main(String... args) throws Exception {
		args = new String[]{"./src/test/assets/basic_cg_test_input.txt", "./src/test/assets/basic_cg_test_output.txt", "./src/test/assets/basic_cg_test_expected_output.txt"};

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
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
			ErrorHandler.getErrorHandler().showErrors(System.err);
			System.err.println("Program with semantic errors. No code was generated.");
			System.exit(1);
		} else {
			ast.accept(new visitor.OffsetVisitor(), null);
			ast.accept(new ExecuteCGVisitor(new CG(args[1], args[0])), null);
		}

		assertCorrectOutput(args[1], args[2]);
	}

	private static void assertCorrectOutput(String outputFilePath, String expectedOutputFilePath) {
		Path outputPath = java.nio.file.Paths.get(outputFilePath);
		Path expectedOutputPath = java.nio.file.Paths.get(expectedOutputFilePath);

		// compare line by line ignoring trailing spaces, empty lines, and comments (in the form of "' * comment")
		try {
			java.util.List<String> outputLines = java.nio.file.Files.readAllLines(outputPath);
			java.util.List<String> expectedOutputLines = java.nio.file.Files.readAllLines(expectedOutputPath);

			int outputIndex = 0;
			int expectedIndex = 0;

			while (outputIndex < outputLines.size() && expectedIndex < expectedOutputLines.size()) {
				String outputLine = outputLines.get(outputIndex).replaceAll("' \\*.*", "").trim();
				String expectedLine = expectedOutputLines.get(expectedIndex).replaceAll("' \\*.*", "").trim();

				if (outputLine.isEmpty()) {
					outputIndex++;
					continue;
				}
				if (expectedLine.isEmpty()) {
					expectedIndex++;
					continue;
				}

				if (!outputLine.equals(expectedLine)) {
					throw new AssertionError("Output does not match expected output.\nOutput: " + outputLine + "\nExpected: " + expectedLine);
				}

				System.out.println("Line " + (outputIndex + 1) + " matches: " + outputLine);

				outputIndex++;
				expectedIndex++;
			}

			while (outputIndex < outputLines.size()) {
				if (!outputLines.get(outputIndex).replaceAll("//.*", "").trim().isEmpty()) {
					throw new AssertionError("Output has extra lines.");
				}
				outputIndex++;
			}

			while (expectedIndex < expectedOutputLines.size()) {
				if (!expectedOutputLines.get(expectedIndex).replaceAll("//.*", "").trim().isEmpty()) {
					throw new AssertionError("Expected output has extra lines.");
				}
				expectedIndex++;
			}

			System.out.println("Output matches expected output.");

		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}
