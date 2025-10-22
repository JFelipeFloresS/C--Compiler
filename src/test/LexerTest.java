package test;

import parser.*;

import org.antlr.v4.runtime.*;

public class LexerTest {

	public static void main(String... args) throws Exception {

		// creates a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName("./src/test/test.txt");

		// creates a buffer of tokens pulled from the lexer
		CmmLexer lexer = new CmmLexer(input);

		// tests the lexer for the given input file
		Token token;
		int i = 0;
		while ((token = lexer.nextToken()).getType() != CmmLexer.EOF) {
			// We get the semantic value of the token
			Object semanticValue = switch (token.getType()) {
                case CmmLexer.CHAR_CONSTANT -> LexerHelper.lexemeToChar(token.getText());
                case CmmLexer.INT_CONSTANT -> LexerHelper.lexemeToInt(token.getText());
                case CmmLexer.DOUBLE_CONSTANT -> LexerHelper.lexemeToDouble(token.getText());
                default -> token.getText();
            };
			System.out.printf("%s: %s%n",
					new LexicalInfo(token.getLine(), token.getCharPositionInLine()+1, token.getText(), token.getType(), semanticValue),
					expectedTokens[i]);
            // We test the token
			expectedTokens[i].assertLexicalEquals(token.getLine(), token.getCharPositionInLine() + 1,
							token.getText(), token.getType(), semanticValue);
			i++;
		}
	}

	private static final LexicalInfo[] expectedTokens = new LexicalInfo[] {
			// int a;
			new LexicalInfo(3, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(3, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(3, 6, ";", CmmLexer.SEMICOLON, ";"),

			// int b;
			new LexicalInfo(4, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(4, 5, "b", CmmLexer.ID, "b"),
			new LexicalInfo(4, 6, ";", CmmLexer.SEMICOLON, ";"),

			// int c;
			new LexicalInfo(5, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(5, 5, "c", CmmLexer.ID, "c"),
			new LexicalInfo(5, 6, ";", CmmLexer.SEMICOLON, ";"),

			// double realNumber;
			new LexicalInfo(6, 1, "double", CmmLexer.DOUBLE, "double"),
			new LexicalInfo(6, 8, "realNumber", CmmLexer.ID, "realNumber"),
			new LexicalInfo(6, 18, ";", CmmLexer.SEMICOLON, ";"),

			// int add(int a, int b) {
			new LexicalInfo(9, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(9, 5, "add", CmmLexer.ID, "add"),
			new LexicalInfo(9, 8, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(9, 9, "int", CmmLexer.INT, "int"),
			new LexicalInfo(9, 13, "a", CmmLexer.ID, "a"),
			new LexicalInfo(9, 14, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(9, 16, "int", CmmLexer.INT, "int"),
			new LexicalInfo(9, 20, "b", CmmLexer.ID, "b"),
			new LexicalInfo(9, 21, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(9, 23, "{", CmmLexer.LEFT_BRACE, "{"),

			// int temp;
			new LexicalInfo(10, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(10, 5, "temp", CmmLexer.ID, "temp"),
			new LexicalInfo(10, 9, ";", CmmLexer.SEMICOLON, ";"),

			// temp = a + b;
			new LexicalInfo(11, 1, "temp", CmmLexer.ID, "temp"),
			new LexicalInfo(11, 6, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(11, 8, "a", CmmLexer.ID, "a"),
			new LexicalInfo(11, 10, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(11, 12, "b", CmmLexer.ID, "b"),
			new LexicalInfo(11, 13, ";", CmmLexer.SEMICOLON, ";"),

			// return temp;
			new LexicalInfo(12, 1, "return", CmmLexer.RETURN, "return"),
			new LexicalInfo(12, 8, "temp", CmmLexer.ID, "temp"),
			new LexicalInfo(12, 12, ";", CmmLexer.SEMICOLON, ";"),

			// }
			new LexicalInfo(13, 1, "}", CmmLexer.RIGHT_BRACE, "}"),

			// int[10] v;
			new LexicalInfo(16, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(16, 4, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(16, 5, "10", CmmLexer.INT_CONSTANT, 10),
			new LexicalInfo(16, 7, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(16, 9, "v", CmmLexer.ID, "v"),
			new LexicalInfo(16, 10, ";", CmmLexer.SEMICOLON, ";"),

			// double[5][10] w;
			new LexicalInfo(17, 1, "double", CmmLexer.DOUBLE, "double"),
			new LexicalInfo(17, 7, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(17, 8, "5", CmmLexer.INT_CONSTANT, 5),
			new LexicalInfo(17, 9, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(17, 10, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(17, 11, "10", CmmLexer.INT_CONSTANT, 10),
			new LexicalInfo(17, 13, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(17, 15, "w", CmmLexer.ID, "w"),
			new LexicalInfo(17, 16, ";", CmmLexer.SEMICOLON, ";"),

      // void readWriteIfElseWhileCast() {
      new LexicalInfo(19, 1, "void", CmmLexer.VOID, "void"),
      new LexicalInfo(19, 6, "readWriteIfElseWhileCast", CmmLexer.ID, "readWriteIfElseWhileCast"),
      new LexicalInfo(19, 30, "(", CmmLexer.LEFT_PAREN, "("),
      new LexicalInfo(19, 31, ")", CmmLexer.RIGHT_PAREN, ")"),
      new LexicalInfo(19, 33, "{", CmmLexer.LEFT_BRACE, "{"),

			// read v[i];
			new LexicalInfo(20, 1, "read", CmmLexer.READ, "read"),
			new LexicalInfo(20, 6, "v", CmmLexer.ID, "v"),
			new LexicalInfo(20, 7, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(20, 8, "i", CmmLexer.ID, "i"),
			new LexicalInfo(20, 9, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(20, 10, ";", CmmLexer.SEMICOLON, ";"),

			// write w[i][a+b];
			new LexicalInfo(21, 1, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(21, 7, "w", CmmLexer.ID, "w"),
			new LexicalInfo(21, 8, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(21, 9, "i", CmmLexer.ID, "i"),
			new LexicalInfo(21, 10, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(21, 11, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(21, 12, "a", CmmLexer.ID, "a"),
			new LexicalInfo(21, 13, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(21, 14, "b", CmmLexer.ID, "b"),
			new LexicalInfo(21, 15, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(21, 16, ";", CmmLexer.SEMICOLON, ";"),

			// if (a < b) {
			new LexicalInfo(24, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(24, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(24, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(24, 7, "<", CmmLexer.RELATIONAL_LESS_THAN, "<"),
			new LexicalInfo(24, 9, "b", CmmLexer.ID, "b"),
			new LexicalInfo(24, 10, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(24, 12, "{", CmmLexer.LEFT_BRACE, "{"),

			// write a;
			new LexicalInfo(25, 5, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(25, 11, "a", CmmLexer.ID, "a"),
			new LexicalInfo(25, 12, ";", CmmLexer.SEMICOLON, ";"),

			// } else {
			new LexicalInfo(26, 1, "}", CmmLexer.RIGHT_BRACE, "}"),
			new LexicalInfo(26, 3, "else", CmmLexer.ELSE, "else"),
			new LexicalInfo(26, 8, "{", CmmLexer.LEFT_BRACE, "{"),

			// write b;
			new LexicalInfo(27, 5, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(27, 11, "b", CmmLexer.ID, "b"),
			new LexicalInfo(27, 12, ";", CmmLexer.SEMICOLON, ";"),

			// }
			new LexicalInfo(28, 1, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a)
			new LexicalInfo(30, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(30, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(30, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(30, 6, ")", CmmLexer.RIGHT_PAREN, ")"),

			// write a;
			new LexicalInfo(31, 5, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(31, 11, "a", CmmLexer.ID, "a"),
			new LexicalInfo(31, 12, ";", CmmLexer.SEMICOLON, ";"),

			// else
			new LexicalInfo(32, 1, "else", CmmLexer.ELSE, "else"),

			// write b;
			new LexicalInfo(33, 5, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(33, 11, "b", CmmLexer.ID, "b"),
			new LexicalInfo(33, 12, ";", CmmLexer.SEMICOLON, ";"),

			// if (b)
			new LexicalInfo(35, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(35, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(35, 5, "b", CmmLexer.ID, "b"),
			new LexicalInfo(35, 6, ")", CmmLexer.RIGHT_PAREN, ")"),

			// write b;
			new LexicalInfo(36, 5, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(36, 11, "b", CmmLexer.ID, "b"),
			new LexicalInfo(36, 12, ";", CmmLexer.SEMICOLON, ";"),

			// if (c) {
			new LexicalInfo(38, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(38, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(38, 5, "c", CmmLexer.ID, "c"),
			new LexicalInfo(38, 6, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(38, 8, "{", CmmLexer.LEFT_BRACE, "{"),

			// write c;
			new LexicalInfo(39, 5, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(39, 11, "c", CmmLexer.ID, "c"),
			new LexicalInfo(39, 12, ";", CmmLexer.SEMICOLON, ";"),

			// }
			new LexicalInfo(40, 1, "}", CmmLexer.RIGHT_BRACE, "}"),

			// while (a < 10) {
			new LexicalInfo(43, 1, "while", CmmLexer.WHILE, "while"),
			new LexicalInfo(43, 7, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(43, 8, "a", CmmLexer.ID, "a"),
			new LexicalInfo(43, 10, "<", CmmLexer.RELATIONAL_LESS_THAN, "<"),
			new LexicalInfo(43, 12, "10", CmmLexer.INT_CONSTANT, 10),
			new LexicalInfo(43, 14, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(43, 16, "{", CmmLexer.LEFT_BRACE, "{"),

			// a = a + 1;
			new LexicalInfo(44, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(44, 7, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(44, 9, "a", CmmLexer.ID, "a"),
			new LexicalInfo(44, 11, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(44, 13, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(44, 14, ";", CmmLexer.SEMICOLON, ";"),

			// }
			new LexicalInfo(45, 1, "}", CmmLexer.RIGHT_BRACE, "}"),

			// a = (int)realNumber;
			new LexicalInfo(48, 1, "a", CmmLexer.ID, "a"),
			new LexicalInfo(48, 3, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(48, 5, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(48, 6, "int", CmmLexer.INT, "int"),
			new LexicalInfo(48, 9, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(48, 10, "realNumber", CmmLexer.ID, "realNumber"),
			new LexicalInfo(48, 20, ";", CmmLexer.SEMICOLON, ";"),

			// realNumber = (double)a; }
			new LexicalInfo(49, 1, "realNumber", CmmLexer.ID, "realNumber"),
			new LexicalInfo(49, 12, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(49, 14, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(49, 15, "double", CmmLexer.DOUBLE, "double"),
			new LexicalInfo(49, 21, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(49, 22, "a", CmmLexer.ID, "a"),
			new LexicalInfo(49, 23, ";", CmmLexer.SEMICOLON, ";"),
      new LexicalInfo(49, 25, "}", CmmLexer.RIGHT_BRACE, "}"),

      // void invokeExpressions() {
      new LexicalInfo(51, 1, "void", CmmLexer.VOID, "void"),
      new LexicalInfo(51, 6, "invokeExpressions", CmmLexer.ID, "invokeExpressions"),
      new LexicalInfo(51, 23, "(", CmmLexer.LEFT_PAREN, "("),
      new LexicalInfo(51, 24, ")", CmmLexer.RIGHT_PAREN, ")"),
      new LexicalInfo(51, 26, "{", CmmLexer.LEFT_BRACE, "{"),

			// int result;
			new LexicalInfo(52, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(52, 5, "result", CmmLexer.ID, "result"),
			new LexicalInfo(52, 11, ";", CmmLexer.SEMICOLON, ";"),

			// result = add(1, 2);
			new LexicalInfo(53, 1, "result", CmmLexer.ID, "result"),
			new LexicalInfo(53, 8, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(53, 10, "add", CmmLexer.ID, "add"),
			new LexicalInfo(53, 13, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(53, 14, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(53, 15, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(53, 17, "2", CmmLexer.INT_CONSTANT, 2),
			new LexicalInfo(53, 18, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(53, 19, ";", CmmLexer.SEMICOLON, ";"),

			// add(result, 1);
			new LexicalInfo(54, 1, "add", CmmLexer.ID, "add"),
			new LexicalInfo(54, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(54, 5, "result", CmmLexer.ID, "result"),
			new LexicalInfo(54, 11, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(54, 13, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(54, 14, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(54, 15, ";", CmmLexer.SEMICOLON, ";"),

			// a = 1 + 2 * 3 - 4 / 5;
			new LexicalInfo(57, 1, "a", CmmLexer.ID, "a"),
			new LexicalInfo(57, 3, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(57, 5, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(57, 7, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(57, 9, "2", CmmLexer.INT_CONSTANT, 2),
			new LexicalInfo(57, 11, "*", CmmLexer.MULTIPLY, "*"),
			new LexicalInfo(57, 13, "3", CmmLexer.INT_CONSTANT, 3),
			new LexicalInfo(57, 15, "-", CmmLexer.MINUS, "-"),
			new LexicalInfo(57, 17, "4", CmmLexer.INT_CONSTANT, 4),
			new LexicalInfo(57, 19, "/", CmmLexer.DIVIDE, "/"),
			new LexicalInfo(57, 21, "5", CmmLexer.INT_CONSTANT, 5),
			new LexicalInfo(57, 22, ";", CmmLexer.SEMICOLON, ";"),

			// a = (1 + 2) * (3 - 4) % 5;
			new LexicalInfo(58, 1, "a", CmmLexer.ID, "a"),
			new LexicalInfo(58, 3, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(58, 5, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(58, 6, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(58, 8, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(58, 10, "2", CmmLexer.INT_CONSTANT, 2),
			new LexicalInfo(58, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(58, 13, "*", CmmLexer.MULTIPLY, "*"),
			new LexicalInfo(58, 15, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(58, 16, "3", CmmLexer.INT_CONSTANT, 3),
			new LexicalInfo(58, 18, "-", CmmLexer.MINUS, "-"),
			new LexicalInfo(58, 20, "4", CmmLexer.INT_CONSTANT, 4),
			new LexicalInfo(58, 21, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(58, 23, "%", CmmLexer.MODULO, "%"),
			new LexicalInfo(58, 25, "5", CmmLexer.INT_CONSTANT, 5),
			new LexicalInfo(58, 26, ";", CmmLexer.SEMICOLON, ";"),

			// a = -a;
			new LexicalInfo(59, 1, "a", CmmLexer.ID, "a"),
			new LexicalInfo(59, 3, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(59, 5, "-", CmmLexer.MINUS, "-"),
			new LexicalInfo(59, 6, "a", CmmLexer.ID, "a"),
			new LexicalInfo(59, 7, ";", CmmLexer.SEMICOLON, ";"),

			// a = !a;
			new LexicalInfo(60, 1, "a", CmmLexer.ID, "a"),
			new LexicalInfo(60, 3, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(60, 5, "!", CmmLexer.LOGICAL_NOT, "!"),
			new LexicalInfo(60, 6, "a", CmmLexer.ID, "a"),
			new LexicalInfo(60, 7, ";", CmmLexer.SEMICOLON, ";"),

			// if (a < b) {}
			new LexicalInfo(61, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(61, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(61, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(61, 7, "<", CmmLexer.RELATIONAL_LESS_THAN, "<"),
			new LexicalInfo(61, 9, "b", CmmLexer.ID, "b"),
			new LexicalInfo(61, 10, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(61, 12, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(61, 13, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a <= b) {}
			new LexicalInfo(62, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(62, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(62, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(62, 7, "<=", CmmLexer.RELATIONAL_LESS_EQUAL, "<="),
			new LexicalInfo(62, 10, "b", CmmLexer.ID, "b"),
			new LexicalInfo(62, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(62, 13, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(62, 14, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a > b) {}
			new LexicalInfo(63, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(63, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(63, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(63, 7, ">", CmmLexer.RELATIONAL_GREATER_THAN, ">"),
			new LexicalInfo(63, 9, "b", CmmLexer.ID, "b"),
			new LexicalInfo(63, 10, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(63, 12, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(63, 13, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a >= b) {}
			new LexicalInfo(64, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(64, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(64, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(64, 7, ">=", CmmLexer.RELATIONAL_GREATER_EQUAL, ">="),
			new LexicalInfo(64, 10, "b", CmmLexer.ID, "b"),
			new LexicalInfo(64, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(64, 13, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(64, 14, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a == b) {}
			new LexicalInfo(65, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(65, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(65, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(65, 7, "==", CmmLexer.RELATIONAL_EQUAL, "=="),
			new LexicalInfo(65, 10, "b", CmmLexer.ID, "b"),
			new LexicalInfo(65, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(65, 13, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(65, 14, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a != b) {}
			new LexicalInfo(66, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(66, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(66, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(66, 7, "!=", CmmLexer.RELATIONAL_NOT_EQUAL, "!="),
			new LexicalInfo(66, 10, "b", CmmLexer.ID, "b"),
			new LexicalInfo(66, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(66, 13, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(66, 14, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a && b) {}
			new LexicalInfo(67, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(67, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(67, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(67, 7, "&&", CmmLexer.LOGICAL_AND, "&&"),
			new LexicalInfo(67, 10, "b", CmmLexer.ID, "b"),
			new LexicalInfo(67, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(67, 13, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(67, 14, "}", CmmLexer.RIGHT_BRACE, "}"),

			// if (a || b) {} }
			new LexicalInfo(68, 1, "if", CmmLexer.IF, "if"),
			new LexicalInfo(68, 4, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(68, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(68, 7, "||", CmmLexer.LOGICAL_OR, "||"),
			new LexicalInfo(68, 10, "b", CmmLexer.ID, "b"),
			new LexicalInfo(68, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(68, 13, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(68, 14, "}", CmmLexer.RIGHT_BRACE, "}"),
      new LexicalInfo(68, 16, "}", CmmLexer.RIGHT_BRACE, "}"),

      // void multipleTest() {
      new LexicalInfo(70, 1, "void", CmmLexer.VOID, "void"),
      new LexicalInfo(70, 6, "multipleTest", CmmLexer.ID, "multipleTest"),
      new LexicalInfo(70, 18, "(", CmmLexer.LEFT_PAREN, "("),
      new LexicalInfo(70, 19, ")", CmmLexer.RIGHT_PAREN, ")"),
      new LexicalInfo(70, 21, "{", CmmLexer.LEFT_BRACE, "{"),

			// int a, b, c;
			new LexicalInfo(71, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(71, 5, "a", CmmLexer.ID, "a"),
			new LexicalInfo(71, 6, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(71, 8, "b", CmmLexer.ID, "b"),
			new LexicalInfo(71, 9, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(71, 11, "c", CmmLexer.ID, "c"),
			new LexicalInfo(71, 12, ";", CmmLexer.SEMICOLON, ";"),

			// double[10] realVector, anotherOne;
			new LexicalInfo(72, 1, "double", CmmLexer.DOUBLE, "double"),
			new LexicalInfo(72, 7, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(72, 8, "10", CmmLexer.INT_CONSTANT, 10),
			new LexicalInfo(72, 10, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(72, 12, "realVector", CmmLexer.ID, "realVector"),
			new LexicalInfo(72, 22, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(72, 24, "anotherOne", CmmLexer.ID, "anotherOne"),
			new LexicalInfo(72, 34, ";", CmmLexer.SEMICOLON, ";"),

			// write a+b, v[45+c];
			new LexicalInfo(75, 1, "write", CmmLexer.WRITE, "write"),
			new LexicalInfo(75, 7, "a", CmmLexer.ID, "a"),
			new LexicalInfo(75, 8, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(75, 9, "b", CmmLexer.ID, "b"),
			new LexicalInfo(75, 10, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(75, 12, "v", CmmLexer.ID, "v"),
			new LexicalInfo(75, 13, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(75, 14, "45", CmmLexer.INT_CONSTANT, 45),
			new LexicalInfo(75, 16, "+", CmmLexer.PLUS, "+"),
			new LexicalInfo(75, 17, "c", CmmLexer.ID, "c"),
			new LexicalInfo(75, 18, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(75, 19, ";", CmmLexer.SEMICOLON, ";"),

			// read realNumber, w[6][t]; }
			new LexicalInfo(76, 1, "read", CmmLexer.READ, "read"),
			new LexicalInfo(76, 6, "realNumber", CmmLexer.ID, "realNumber"),
			new LexicalInfo(76, 16, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(76, 18, "w", CmmLexer.ID, "w"),
			new LexicalInfo(76, 19, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(76, 20, "6", CmmLexer.INT_CONSTANT, 6),
			new LexicalInfo(76, 21, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(76, 22, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(76, 23, "t", CmmLexer.ID, "t"),
			new LexicalInfo(76, 24, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(76, 25, ";", CmmLexer.SEMICOLON, ";"),
      new LexicalInfo(76, 27, "}", CmmLexer.RIGHT_BRACE, "}"),

      // void structWithinStruct() {
      new LexicalInfo(78, 1, "void", CmmLexer.VOID, "void"),
      new LexicalInfo(78, 6, "structWithinStruct", CmmLexer.ID, "structWithinStruct"),
      new LexicalInfo(78, 24, "(", CmmLexer.LEFT_PAREN, "("),
      new LexicalInfo(78, 25, ")", CmmLexer.RIGHT_PAREN, ")"),
      new LexicalInfo(78, 27, "{", CmmLexer.LEFT_BRACE, "{"),

			// struct {
			new LexicalInfo(79, 1, "struct", CmmLexer.STRUCT, "struct"),
			new LexicalInfo(79, 8, "{", CmmLexer.LEFT_BRACE, "{"),

			// int age;
			new LexicalInfo(80, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(80, 5, "age", CmmLexer.ID, "age"),
			new LexicalInfo(80, 8, ";", CmmLexer.SEMICOLON, ";"),

			// struct { int day, month; int year; } dateOfBirth;
			new LexicalInfo(81, 1, "struct", CmmLexer.STRUCT, "struct"),
			new LexicalInfo(81, 8, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(81, 10, "int", CmmLexer.INT, "int"),
			new LexicalInfo(81, 14, "day", CmmLexer.ID, "day"),
			new LexicalInfo(81, 17, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(81, 19, "month", CmmLexer.ID, "month"),
			new LexicalInfo(81, 24, ";", CmmLexer.SEMICOLON, ";"),
			new LexicalInfo(81, 26, "int", CmmLexer.INT, "int"),
			new LexicalInfo(81, 30, "year", CmmLexer.ID, "year"),
			new LexicalInfo(81, 34, ";", CmmLexer.SEMICOLON, ";"),
			new LexicalInfo(81, 36, "}", CmmLexer.RIGHT_BRACE, "}"),
			new LexicalInfo(81, 38, "dateOfBirth", CmmLexer.ID, "dateOfBirth"),
			new LexicalInfo(81, 49, ";", CmmLexer.SEMICOLON, ";"),

			// char[256] name, surname;
			new LexicalInfo(82, 1, "char", CmmLexer.CHAR, "char"),
			new LexicalInfo(82, 5, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(82, 6, "256", CmmLexer.INT_CONSTANT, 256),
			new LexicalInfo(82, 9, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(82, 11, "name", CmmLexer.ID, "name"),
			new LexicalInfo(82, 15, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(82, 17, "surname", CmmLexer.ID, "surname"),
			new LexicalInfo(82, 24, ";", CmmLexer.SEMICOLON, ";"),

			// } [20] students;
			new LexicalInfo(83, 1, "}", CmmLexer.RIGHT_BRACE, "}"),
			new LexicalInfo(83, 3, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(83, 4, "20", CmmLexer.INT_CONSTANT, 20),
			new LexicalInfo(83, 6, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(83, 8, "students", CmmLexer.ID, "students"),
			new LexicalInfo(83, 16, ";", CmmLexer.SEMICOLON, ";"),

			// students[0].dateOfBirth.day = 10; }
			new LexicalInfo(84, 1, "students", CmmLexer.ID, "students"),
			new LexicalInfo(84, 9, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(84, 10, "0", CmmLexer.INT_CONSTANT, 0),
			new LexicalInfo(84, 11, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(84, 12, ".", CmmLexer.DOT, "."),
			new LexicalInfo(84, 13, "dateOfBirth", CmmLexer.ID, "dateOfBirth"),
			new LexicalInfo(84, 24, ".", CmmLexer.DOT, "."),
			new LexicalInfo(84, 25, "day", CmmLexer.ID, "day"),
			new LexicalInfo(84, 29, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(84, 31, "10", CmmLexer.INT_CONSTANT, 10),
			new LexicalInfo(84, 33, ";", CmmLexer.SEMICOLON, ";"),
      new LexicalInfo(84, 35, "}", CmmLexer.RIGHT_BRACE, "}"),

			// void simpleStruct() { struct {
      new LexicalInfo(86, 1, "void", CmmLexer.VOID, "void"),
      new LexicalInfo(86, 6, "simpleStruct", CmmLexer.ID, "simpleStruct"),
      new LexicalInfo(86, 18, "(", CmmLexer.LEFT_PAREN, "("),
      new LexicalInfo(86, 19, ")", CmmLexer.RIGHT_PAREN, ")"),
      new LexicalInfo(86, 21, "{", CmmLexer.LEFT_BRACE, "{"),
			new LexicalInfo(86, 23, "struct", CmmLexer.STRUCT, "struct"),
			new LexicalInfo(86, 30, "{", CmmLexer.LEFT_BRACE, "{"),

			// int id;
			new LexicalInfo(87, 1, "int", CmmLexer.INT, "int"),
			new LexicalInfo(87, 5, "id", CmmLexer.ID, "id"),
			new LexicalInfo(87, 7, ";", CmmLexer.SEMICOLON, ";"),

			// char[30] name;
			new LexicalInfo(88, 1, "char", CmmLexer.CHAR, "char"),
			new LexicalInfo(88, 5, "[", CmmLexer.LEFT_BRACKET, "["),
			new LexicalInfo(88, 6, "30", CmmLexer.INT_CONSTANT, 30),
			new LexicalInfo(88, 8, "]", CmmLexer.RIGHT_BRACKET, "]"),
			new LexicalInfo(88, 10, "name", CmmLexer.ID, "name"),
			new LexicalInfo(88, 14, ";", CmmLexer.SEMICOLON, ";"),

			// double price;
			new LexicalInfo(89, 1, "double", CmmLexer.DOUBLE, "double"),
			new LexicalInfo(89, 8, "price", CmmLexer.ID, "price"),
			new LexicalInfo(89, 13, ";", CmmLexer.SEMICOLON, ";"),

			// } product;
			new LexicalInfo(90, 1, "}", CmmLexer.RIGHT_BRACE, "}"),
			new LexicalInfo(90, 3, "product", CmmLexer.ID, "product"),
			new LexicalInfo(90, 10, ";", CmmLexer.SEMICOLON, ";"),

			// product.id = 1; }
			new LexicalInfo(91, 1, "product", CmmLexer.ID, "product"),
			new LexicalInfo(91, 8, ".", CmmLexer.DOT, "."),
			new LexicalInfo(91, 9, "id", CmmLexer.ID, "id"),
			new LexicalInfo(91, 12, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(91, 14, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(91, 15, ";", CmmLexer.SEMICOLON, ";"),
      new LexicalInfo(91, 17, "}", CmmLexer.RIGHT_BRACE, "}"),

			// void main() {
			new LexicalInfo(94, 1, "void", CmmLexer.VOID, "void"),
			new LexicalInfo(94, 6, "main", CmmLexer.MAIN, "main"),
			new LexicalInfo(94, 10, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(94, 11, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(94, 13, "{", CmmLexer.LEFT_BRACE, "{"),

			// int result;
			new LexicalInfo(95, 5, "int", CmmLexer.INT, "int"),
			new LexicalInfo(95, 9, "result", CmmLexer.ID, "result"),
			new LexicalInfo(95, 15, ";", CmmLexer.SEMICOLON, ";"),

			// result = add(1, 2);
			new LexicalInfo(96, 5, "result", CmmLexer.ID, "result"),
			new LexicalInfo(96, 12, "=", CmmLexer.ASSIGN, "="),
			new LexicalInfo(96, 14, "add", CmmLexer.ID, "add"),
			new LexicalInfo(96, 17, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(96, 18, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(96, 19, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(96, 21, "2", CmmLexer.INT_CONSTANT, 2),
			new LexicalInfo(96, 22, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(96, 23, ";", CmmLexer.SEMICOLON, ";"),

			// add(result, 1);
			new LexicalInfo(97, 5, "add", CmmLexer.ID, "add"),
			new LexicalInfo(97, 8, "(", CmmLexer.LEFT_PAREN, "("),
			new LexicalInfo(97, 9, "result", CmmLexer.ID, "result"),
			new LexicalInfo(97, 15, ",", CmmLexer.COMMA, ","),
			new LexicalInfo(97, 17, "1", CmmLexer.INT_CONSTANT, 1),
			new LexicalInfo(97, 18, ")", CmmLexer.RIGHT_PAREN, ")"),
			new LexicalInfo(97, 19, ";", CmmLexer.SEMICOLON, ";"),

			// }
			new LexicalInfo(98, 1, "}", CmmLexer.RIGHT_BRACE, "}"),

			// end of file
			new LexicalInfo(99, 0, "", CmmLexer.EOF, "<EOF>")
	};
}
