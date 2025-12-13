package test.utils;

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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CodeGeneratorTestUtils {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private CodeGeneratorTestUtils() {
	}

	public static void runCGTest(String inputFilePath, String outputFilePath, String expectedOutputFilePath) throws IOException {
		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(inputFilePath);
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
			ast.accept(new ExecuteCGVisitor(new CG(inputFilePath, outputFilePath)), null);
		}

		assertCorrectOutput(outputFilePath, expectedOutputFilePath);
	}

	private static void assertCorrectOutput(String outputFilePath, String expectedOutputFilePath) {
		Path outputPath = Paths.get(outputFilePath);
		Path expectedOutputPath = Paths.get(expectedOutputFilePath);

		// compare line by line ignoring trailing spaces, empty lines, and comments (in the form of "' * comment")
		try {
			List<String> outputLines = Files.readAllLines(outputPath);
			List<String> expectedOutputLines = Files.readAllLines(expectedOutputPath);

			HashMap<String, ArrayList<Integer[]>> errors = outputComparison(outputLines, expectedOutputLines);

			if (!errors.isEmpty()) {
				handleErrors(errors);
			}

			System.out.println("Output matches expected output.");

		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private static HashMap<String, ArrayList<Integer[]>> outputComparison(List<String> outputLines, List<String> expectedOutputLines) {
		HashMap<String, ArrayList<Integer[]>> errors = new HashMap<>();

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
				String message = "Output: " + outputLine + "\nExpected: " + expectedLine;
				if (!errors.containsKey(message)) {
					errors.put(message, new ArrayList<>());
				}
				errors.get(message).add(new Integer[]{outputIndex + 1, expectedIndex + 1});
			} else {
				System.out.println("Line " + (outputIndex + 1) + " matches: " + outputLine);
			}

			outputIndex++;
			expectedIndex++;
		}

		return errors;
	}

	private static void handleErrors(HashMap<String, ArrayList<Integer[]>> errors) {
		errors.forEach((msg, lines) -> {
			String linesStr = lines.stream()
				.map(pair -> Objects.equals(pair[0], pair[1]) ? ("Line: " + pair[0]) : ("Line: output " + pair[0] + " | expected " + pair[1]))
				.reduce((a, b) -> a + "\n" + b)
				.orElse("");
			System.err.println("Output does not match expected output in\n" + linesStr + ":\n" + msg + "\n");
		});
		throw new AssertionError("Output does not match expected output.");
	}
}
