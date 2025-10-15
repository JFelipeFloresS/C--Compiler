import ast.definitions.FunctionDefinition;
import ast.Program;
import ast.definitions.VariableDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.Cast;
import ast.expressions.DoubleLiteral;
import ast.expressions.Id;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Statement;
import ast.statements.Write;
import ast.types.IntType;
import ast.types.DoubleType;
import ast.types.VoidType;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ASTTest {

	/**
	 * Builds an AST and shows it with the Introspector tool.
	 * The input program is:
	 *   void main() { 
	 *     int a;
	 *     double b;
	 *     read a; 
	 *     b = (double)a + b*2.2; 
	 *     write b;
	 *   }
	 */
	private static Program createAST() {
		// * Line 2
		VariableDefinition varDef1 = new VariableDefinition(2, 3, new IntType(2,3,null), List.of("a"));
		// * Line 3
		VariableDefinition varDef2 = new VariableDefinition(3, 3, new DoubleType(3,3,null), List.of("b"));
		// * Line 4
		Read read = new Read(4, 3, List.of(new Id(4, 8, "a")));
		// * Line 5
		Assignment assignment = new Assignment(5, 3,
				new Id(5, 3, "b"),
				new Arithmetic(5, 3, new Cast(5, 7, new DoubleType(5,7,null), new Id(5, 15, "a")),
						"+",
						new Arithmetic(5, 19, new Id(5, 19, "b"),
								"*",
								new DoubleLiteral(5, 21, 2.2))
						)
				);
		// * Line 6
		Write write = new Write(6, 3, List.of(new Id(6, 9, "b")));
		// * We build and return the AST
		List<Statement> mainBody = new ArrayList<Statement>(Arrays.asList(varDef1, varDef2, read, assignment, write));
		FunctionDefinition functionDefinition = new FunctionDefinition(1, 1, new VoidType(1,1), "main", List.of(), mainBody);
		return new Program(List.of(), new ArrayList<>(List.of(functionDefinition)));
	}

	public static void main(String[] args) {
		IntrospectorModel model = new IntrospectorModel("Program", createAST());
		new IntrospectorView("Introspector", model);
	}
}
