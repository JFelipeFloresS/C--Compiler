package test;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.types.FunctionType;
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

public class VariableOffsetTest {

	public static void main(String[] args)
		throws IOException {

		CharStream input = CharStreams.fromFileName("./src/test/assets/offset-test.txt");
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
		}

		assertOffsets(ast);
	}

	private static void assertOffsets(Program ast) {
		List<Definition> programDefs = ast.definitions();
		assertEquals(7, programDefs.size());
		// int gi;
		assertEquals(0, ((VariableDefinition) programDefs.get(0)).getOffset());

		// double gd;
		assertEquals(2, ((VariableDefinition) programDefs.get(1)).getOffset());

		// char gc;
		assertEquals(6, ((VariableDefinition) programDefs.get(2)).getOffset());

		// int[10] arr, arr2;
		assertEquals(7, ((VariableDefinition) programDefs.get(3)).getOffset());

		/*
		 * struct {
		 *   int a;
		 *   double b;
		 *   char c;
		 * } gStruct, anotherStruct;
		 */
		assertEquals(47, ((VariableDefinition) programDefs.get(4)).getOffset());

		// int f(int pi, double pd, char pc)
		FunctionDefinition fFuncDef = (FunctionDefinition) programDefs.get(5);
		List<VariableDefinition> fParams = ((FunctionType)fFuncDef.getType()).getParams();
		assertEquals(3, fParams.size());

		// int pi;
		assertEquals(9, fParams.get(0).getOffset());

		// double pd;
		assertEquals(5, fParams.get(1).getOffset());

		// char pc;
		assertEquals(4, fParams.get(2).getOffset());

		List<VariableDefinition> fLocalVars = fFuncDef.getLocalVars();
		assertEquals(3, fLocalVars.size());

		// double ld;
		assertEquals(-4, fLocalVars.get(0).getOffset());

		// int li;
		assertEquals(-6, fLocalVars.get(1).getOffset());

		// char lc;
		assertEquals(-7, fLocalVars.get(2).getOffset());

		FunctionDefinition mainFuncDef = (FunctionDefinition) programDefs.get(6);
		List<VariableDefinition> mainLocalVars = mainFuncDef.getLocalVars();
		assertEquals(3, mainLocalVars.size());

		// double ld;
		assertEquals(-4, mainLocalVars.get(0).getOffset());

		// int li;
		assertEquals(-6, mainLocalVars.get(1).getOffset());

		// char lc;
		assertEquals(-7, mainLocalVars.get(2).getOffset());
	}

}
