package test;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.StructDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static test.Assertions.*;

public class ParserTest {

    public static void main(String[] args)
            throws IOException {

        CharStream input = CharStreams.fromFileName("./src/test/test.txt");
        CmmLexer lexer = new CmmLexer(input);

        // create a parser that feeds off the tokens buffer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CmmParser parser = new CmmParser(tokens);
        Program ast = parser.program().ast;

        if (parser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("Program parsed correctly.");
        } else {
            System.err.println("Program with syntax errors.");
        }

        assertDefinitions(ast);

        System.out.println("All assertions passed.");
    }

    private static void assertDefinitions(Program ast) {
        assertEquals(13, ast.getDefinitions().size());

        // variable definitions
        assertEquals(
            new VariableDefinition(3, 1, new IntType(3, 1, null), List.of("a")),
            ast.getDefinitions().get(0));

        assertEquals(
            new VariableDefinition(4, 1, new IntType(4, 1, null), List.of("b")),
            ast.getDefinitions().get(1));

        assertEquals(
            new VariableDefinition(5, 1, new IntType(5, 1, null), List.of("c")),
            ast.getDefinitions().get(2));

        assertEquals(
            new VariableDefinition(6, 1, new DoubleType(6, 1, null), List.of("realNumber")),
            ast.getDefinitions().get(3));

        // function/procedure definitions
        assertEquals(
            new FunctionDefinition(9, 1,
                new FunctionType(9, 1,
                    new IntType(9, 1, null),
                    List.of(
                        new VariableDefinition(9, 9, new IntType(9, 9, null), List.of("a")),
                        new VariableDefinition(9, 16, new IntType(9, 16, null), List.of("b"))
                    )
                ),
                "add",
                List.of(
                    new VariableDefinition(10, 1, new IntType(10, 1, null), List.of("temp"))
                ),
                List.of(
                    new Assignment(11, 1, new Id(11, 1, "temp"),
                        new Arithmetic(11, 8, new Id(11, 8, "a"),
                            "+",
                            new Id(11, 12, "b"))),
                    new Return(12, 1, new Id(12, 8, "temp"))
                )
            ),
        ast.getDefinitions().get(4)
        );

        assertEquals(
            new VariableDefinition(16, 1,
                new IntType(16, 1,
                    new ArrayIndex(16, 4,
                        new IntLiteral(16, 5, 10),
                    null)
                ),
                List.of("v")
            ),
            ast.getDefinitions().get(5));

        assertEquals(
            new VariableDefinition(17, 1,
                new DoubleType(17, 1,
                    new ArrayIndex(17, 7,
                        new IntLiteral(17, 8, 5),
                        new ArrayIndex(17, 10,
                            new IntLiteral(17, 11, 10),
                        null)
                    )
                ),
                List.of("w")
            ),
            ast.getDefinitions().get(6));

        assertEquals(
          new FunctionDefinition(19, 1,
              new FunctionType(19, 1,
                  new VoidType(19, 1),
                  new ArrayList<>()
              ),
              "readWriteIfElseWhileCast",
              new ArrayList<>(),
              List.of(
                  new Read(20, 1,
                      List.of(
                          new ArrayAccess(20, 6,
                              new Id(20, 6, "v"),
                              new ArrayIndex(20, 7, new Id(20, 8, "i"), null)))
                  ),
                  new Write(21, 1,
                      List.of(
                          new ArrayAccess(21, 7,
                              new Id(21, 7, "w"),
                              new ArrayIndex(21, 8,
                                  new Id(21, 9, "i"),
                                  new ArrayIndex(21, 11,
                                      new Arithmetic(
                                          21, 12,
                                          new Id(21, 12, "a"),
                                          "+",
                                          new Id(21, 14, "b")
                                      ), null))
                          )
                      )),
                  new IfElse(24, 1,
                      new Relational(24, 5,
                          new Id(24, 5, "a"),
                          "<",
                          new Id(24, 9, "b")),
                      List.of(new Write(25, 5, List.of(new Id(25, 11, "a")))),
                      List.of(new Write(27, 5, List.of(new Id(27, 11, "b"))))),
                  new IfElse(30, 1,
                      new Id(30, 5, "a"),
                      List.of(new Write(31, 5, List.of(new Id(31, 11, "a")))),
                      List.of(new Write(33, 5, List.of(new Id(33, 11, "b"))))),
                  new IfElse(35, 1,
                      new Id(35, 5, "b"),
                      List.of(new Write(36, 5, List.of(new Id(36, 11, "b")))),
                      List.of()),
                  new IfElse(38, 1,
                      new Id(38, 5, "c"),
                      List.of(new Write(39, 5, List.of(new Id(39, 11, "c")))),
                      List.of()),
                  new While(43, 1,
                      new Relational(43, 8,
                          new Id(43, 8, "a"),
                          "<",
                          new IntLiteral(43, 12, 10)),
                      List.of(
                          new Assignment(44, 5,
                              new Id(44, 5, "a"),
                              new Arithmetic(44, 9,
                                  new Id(44, 9, "a"),
                                  "+",
                                  new IntLiteral(44, 13, 1)))
                      )
                  ),
                  new Assignment(48, 1, new Id(48, 1, "a"),
                      new Cast(48, 5,
                          new IntType(48, 6, null),
                          new Id(48, 10, "realNumber"))),
                  new Assignment(49, 1, new Id(49, 1, "realNumber"),
                      new Cast(49, 14,
                          new DoubleType(49, 15, null),
                          new Id(49, 22, "a")))
              )
          ),
            ast.getDefinitions().get(7));



        assertEquals(
            new FunctionDefinition(51, 1,
                new FunctionType(51, 1,
                    new VoidType(51, 1),
                    new ArrayList<>()
                ),
                "invokeExpressions",
                List.of(
                    new VariableDefinition(52, 1, new IntType(52, 1, null), List.of("result"))
                ),
                List.of(
                    new Assignment(53, 1, new Id(53, 1, "result"),
                        new FunctionInvocation(53, 10,
                            new Id(53, 10, "add"),
                            List.of(
                                new IntLiteral(53, 14, 1),
                                new IntLiteral(53, 17, 2)
                            ))),
                    new ProcedureInvocation(54, 1,
                        new Id(54, 1, "add"),
                        List.of(
                            new Id(54, 5, "result"),
                            new IntLiteral(54, 13, 1)
                        )),
                    new Assignment(57, 1, new Id(57, 1, "a"),
                        new Arithmetic(57, 5,
                            new Arithmetic(57, 5,
                                new Arithmetic(57, 5,
                                    new IntLiteral(57, 5, 1),
                                    "+",
                                    new IntLiteral(57, 9, 2)),
                                "*",
                                new Arithmetic(57, 13,
                                    new IntLiteral(57, 13, 3),
                                    "-",
                                    new IntLiteral(57, 17, 4))
                            ),
                            "/",
                            new IntLiteral(57, 21, 5)
                        )),
                    new Assignment(58, 1, new Id(58, 1, "a"),
                        new Arithmetic(58, 5,
                            new Arithmetic(58, 5,
                                new Parenthesis(58, 5,
                                    new Arithmetic(58, 6,
                                        new IntLiteral(58, 6, 1),
                                        "+",
                                        new IntLiteral(58, 10, 2)
                                    )
                                ),
                                "*",
                                new Parenthesis(58, 15,
                                    new Arithmetic(58, 16,
                                        new IntLiteral(58, 16, 3),
                                        "-",
                                        new IntLiteral(58, 20, 4)
                                    )
                                )
                            ),
                            "%",
                            new IntLiteral(58, 25, 5)
                        )
                    ),
                    new Assignment(59, 1,
                        new Id(59, 1, "a"),
                        new UnaryMinus(59, 5, new Id(59, 6, "a"))
                    ),
                    new Assignment(60, 1,
                        new Id(60, 1, "a"),
                        new LogicalNot(60, 5, new Id(60, 6, "a"))
                    ),
                    new IfElse(61, 1,
                        new Relational(61, 5,
                            new Id(61, 5, "a"),
                            "<",
                            new Id(61, 9, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(62, 1,
                        new Relational(62, 5,
                            new Id(62, 5, "a"),
                            "<=",
                            new Id(62, 10, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(63, 1,
                        new Relational(63, 5,
                            new Id(63, 5, "a"),
                            ">",
                            new Id(63, 9, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(64, 1,
                        new Relational(64, 5,
                            new Id(64, 5, "a"),
                            ">=",
                            new Id(64, 10, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(65, 1,
                        new Logical(65, 5,
                            new Id(65, 5, "a"),
                            "==",
                            new Id(65, 10, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(66, 1,
                        new Logical(66, 5,
                            new Id(66, 5, "a"),
                            "!=",
                            new Id(66, 10, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(67, 1,
                        new Logical(67, 5,
                            new Id(67, 5, "a"),
                            "&&",
                            new Id(67, 10, "b")),
                        List.of(),
                        List.of()),
                    new IfElse(68, 1,
                        new Logical(68, 5,
                            new Id(68, 5, "a"),
                            "||",
                            new Id(68, 10, "b")),
                        List.of(),
                        List.of())
                )
            ),
            ast.getDefinitions().get(8)
        );

        assertEquals(
            new FunctionDefinition(70, 1,
                new FunctionType(70, 1,
                    new VoidType(70, 1),
                    new ArrayList<>()
                ),
                "multipleTest",
                List.of(
                    new VariableDefinition(71, 1, new IntType(71, 1, null), List.of("a", "b", "c")),
                    new VariableDefinition(72, 1,
                        new DoubleType(72, 1,
                            new ArrayIndex(72, 7, new IntLiteral(72, 8, 10), null)
                        ), List.of("realVector", "anotherOne"))
                ),
                List.of(
                    new Write(75, 1,
                        List.of(
                            new Arithmetic(75, 7,
                                new Id(75, 7, "a"),
                                "+",
                                new Id(75, 9, "b")
                            ),
                            new ArrayAccess(75, 12,
                                new Id(75, 12, "v"),
                                new ArrayIndex(75, 13,
                                    new Arithmetic(75, 14,
                                        new IntLiteral(75, 14, 45),
                                        "+",
                                        new Id(75, 17, "c")
                                    ),null
                                )
                            )
                        )
                    ),
                    new Read(76, 1,
                        List.of(
                            new Id(76, 6, "realNumber"),
                            new ArrayAccess(76, 18,
                                new Id(76, 18, "w"),
                                new ArrayIndex(76, 19,
                                    new IntLiteral(76, 20, 6),
                                    new ArrayIndex(76, 22,
                                        new Id(76, 23, "t"),
                                        null
                                    )
                                )
                            )
                        )
                    )
                )
            ),
            ast.getDefinitions().get(9)
        );

        assertEquals(
            new FunctionDefinition(78, 1,
                new FunctionType(78, 1,
                    new VoidType(78, 1),
                    new ArrayList<>()),
                "structWithinStruct",
                List.of(
                    new StructDefinition(79, 1,
                        new StructType(79, 1,
                            new ArrayIndex(83, 3, new IntLiteral(83, 4, 20), null),
                            "students"
                        ),
                        List.of("students"),
                        List.of(
                            new VariableDefinition(80, 1,
                                new IntType(80, 1, null),
                                List.of("age")
                            ),
                            new StructDefinition(81, 1,
                                new StructType(81, 1, null, "dateOfBirth"),
                                List.of("dateOfBirth"),
                                List.of(
                                    new VariableDefinition(81, 10,
                                        new IntType(81, 10, null),
                                        List.of("day", "month")
                                    ),
                                    new VariableDefinition(81, 26,
                                        new IntType(81, 26, null),
                                        List.of("year")
                                    )
                                )
                            ),
                            new VariableDefinition(82, 1,
                                new CharType(82, 1,
                                    new ArrayIndex(82, 5, new IntLiteral(82, 6, 256),
                                        null
                                    )),
                                List.of("name", "surname")
                            )
                        )
                    )
                ),
                List.of(
                    new Assignment(84, 1,
                        new StructAccess(84, 1,
                            new StructAccess(84, 1,
                                new ArrayAccess(84, 1,
                                    new Id(84, 1, "students"),
                                    new ArrayIndex(84, 9,
                                        new IntLiteral(84, 10, 0),
                                        null
                                    )
                                ),
                                "dateOfBirth"
                            ),
                            "day"
                        ),
                        new IntLiteral(84, 31, 10)
                    )
                )
            ),
            ast.getDefinitions().get(10)
        );

        assertEquals(
            new FunctionDefinition(86, 1,
                new FunctionType(86, 1,
                    new VoidType(86, 1),
                    new ArrayList<>()),
                "simpleStruct",
                List.of(
                    new StructDefinition(86, 23,
                        new StructType(86, 23, null, "product"),
                        List.of("product"),
                        List.of(
                            new VariableDefinition(87, 1,
                                new IntType(87, 1,null),
                                List.of("id")
                            ),
                            new VariableDefinition(88, 1,
                                new CharType(88, 1,
                                    new ArrayIndex(88, 5,
                                        new IntLiteral(88, 6, 30),
                                        null)
                                ),
                                List.of("name")
                            ),
                            new VariableDefinition(89, 1,
                                new DoubleType(89, 1, null),
                                List.of("price")
                            )
                        )
                    )
                ),
                List.of(
                    new Assignment(91, 1,
                        new StructAccess(91, 1,
                            new Id(91, 1, "product"),
                            "id"
                        ),
                        new IntLiteral(91, 14, 1)
                    )
                )
            ),
            ast.getDefinitions().get(11)
        );

        assertEquals(
            new FunctionDefinition(94, 1,
                new FunctionType(94, 1,
                    new VoidType(94, 1),
                    new ArrayList<>()
                ),
                "main",
                List.of(
                    new VariableDefinition(95, 5,
                        new IntType(95, 5, null),
                        List.of("result")
                    )
                ),
                List.of(
                    new Assignment(96, 5,
                        new Id(96, 5,
                            "result"
                        ),
                        new FunctionInvocation(96, 14,
                            new Id(96, 14, "add"),
                            List.of(
                                new IntLiteral(96, 18, 1),
                                new IntLiteral(96, 21, 2)
                            )
                        )
                    ),
                    new ProcedureInvocation(97, 5,
                        new Id(97, 5, "add"),
                        List.of(
                            new Id(97, 9, "result"),
                            new IntLiteral(97, 17, 1)
                        )
                    )
                )
            ),
            ast.getDefinitions().get(12)
        );

    }
}
