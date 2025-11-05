import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.Cast;
import ast.expressions.DoubleLiteral;
import ast.expressions.Id;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Statement;
import ast.statements.Write;
import ast.types.DoubleType;
import ast.types.FunctionType;
import ast.types.IntType;
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
     * void main() {
     * int a;
     * double b;
     * read a;
     * b = (double)a + b*2.2;
     * write b;
     * }
     */
    private static Program createAST() {
        // * Line 2
        VariableDefinition varDef1 = new VariableDefinition(2, 3, new IntType(2, 3), List.of(new Id(2, 8, "a")));
        // * Line 3
        VariableDefinition varDef2 = new VariableDefinition(3, 3, new DoubleType(3, 3), List.of(new Id(3, 7, "b")));
        // * Line 4
        Read read = new Read(4, 3, List.of(new Id(4, 8, "a")));
        // * Line 5
        Assignment assignment = new Assignment(5, 3,
            new Id(5, 3, "b"),
            new Arithmetic(5, 3, new Cast(5, 7, new DoubleType(5, 7), new Id(5, 15, "a")),
                "+",
                new Arithmetic(5, 19, new Id(5, 19, "b"),
                    "*",
                    new DoubleLiteral(5, 21, 2.2))
            )
        );
        // * Line 6
        Write write = new Write(6, 3, List.of(new Id(6, 9, "b")));
        // * We build and return the AST
        List<VariableDefinition> localVars = new ArrayList<>(Arrays.asList(varDef1, varDef2));
        List<Statement> stmtsBlock = new ArrayList<>(Arrays.asList(read, assignment, write));
        FunctionDefinition functionDefinition = new FunctionDefinition(1, 1, new FunctionType(1, 1, new VoidType(1, 1), List.of()), new Id(1, 6, "main"), localVars, stmtsBlock);
        return new Program(List.of(functionDefinition));
    }

    public static void main(String[] args) {
        IntrospectorModel model = new IntrospectorModel("Program", createAST());
        new IntrospectorView("Introspector", model);
    }
}
