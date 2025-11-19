import ast.Program;
import error_handler.ErrorHandler;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;
import visitor.IdentificationVisitor;
import visitor.TypeCheckingVisitor;

import static utils.FileUtils.getInputAndOutputFilePathFromFileChooser;

public class Main {

	public static void main(String... args) throws Exception {
		if (args.length < 1) {
			args = getInputAndOutputFilePathFromFileChooser();
		}

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
		}

		System.out.println(ast);
	}


}
