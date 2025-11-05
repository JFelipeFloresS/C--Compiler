/**
 * Example mini compiler for a Programming Language Design and Implementation course.
 * Entry point of the compiler, showing the AST with the introspector tool.
 *
 * @author Francisco Ortin
 */

import ast.Program;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;

import static file_utils.FileUtils.getInputAndOutputFilePathFromFileChooser;


public class MainIntrospector {

    public static void main(String... args) throws Exception {
        if (args.length < 1) {
            args = getInputAndOutputFilePathFromFileChooser();
        }

        // * Creates one lexer that feeds off of input CharStream
        CharStream input = CharStreams.fromFileName(args[0]);
        CmmLexer lexer = new CmmLexer(input);

        // Creates one parser that feeds off the tokens buffer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CmmParser parser = new CmmParser(tokens);
        Program ast = parser.program().ast;

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Program with syntax errors. No code was generated.");
            return;
        }

        // * The AST is shown
        IntrospectorModel model = new IntrospectorModel("Program", ast);
        new IntrospectorView("Introspector", model);
    }


}
