// Generated from /Users/masters/Projects/C--Compiler/src/parser/Cmm.g4 by ANTLR 4.13.2
package parser;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmmParser extends Parser {
    public static final int
        WHITE_SPACES = 1, SINGLE_LINE_COMMENT = 2, MULTI_LINE_COMMENT = 3, SEMICOLON = 4,
        LEFT_PAREN = 5, RIGHT_PAREN = 6, LEFT_BRACE = 7, RIGHT_BRACE = 8, LEFT_BRACKET = 9,
        RIGHT_BRACKET = 10, DOT = 11, COMMA = 12, ASSIGN = 13, PLUS = 14, MINUS = 15, MULTIPLY = 16,
        DIVIDE = 17, MODULO = 18, RELATIONAL_EQUAL = 19, RELATIONAL_NOT_EQUAL = 20, RELATIONAL_LESS_THAN = 21,
        RELATIONAL_LESS_EQUAL = 22, RELATIONAL_GREATER_THAN = 23, RELATIONAL_GREATER_EQUAL = 24,
        LOGICAL_AND = 25, LOGICAL_OR = 26, LOGICAL_NOT = 27, READ = 28, WRITE = 29, RETURN = 30,
        IF = 31, ELSE = 32, WHILE = 33, STRUCT = 34, INT = 35, DOUBLE = 36, CHAR = 37, VOID = 38,
        MAIN = 39, ID = 40, INT_CONSTANT = 41, DOUBLE_CONSTANT = 42, CHAR_CONSTANT = 43;
    public static final int
        RULE_program = 0, RULE_statement = 1, RULE_procedureInvocation = 2, RULE_definition = 3,
        RULE_varDefinition = 4, RULE_varDefList = 5, RULE_functionDefinition = 6,
        RULE_paramsList = 7, RULE_paramDef = 8, RULE_recordFieldList = 9, RULE_recordField = 10,
        RULE_stmtBlock = 11, RULE_stmtList = 12, RULE_expression = 13, RULE_assignableExpression = 14,
        RULE_expressionList = 15, RULE_assignableExpressionList = 16, RULE_functionInvocation = 17,
        RULE_voidableType = 18, RULE_arrayableType = 19, RULE_builtInType = 20;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
        "\u0004\u0001+\u0172\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
            "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
            "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
            "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
            "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
            "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012" +
            "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0005\u0000" +
            ",\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
            "\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00007\b\u0000\u0001\u0000" +
            "\u0003\u0000:\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\\\b\u0001" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
            "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
            "\u0001\u0001\u0003\u0001k\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002" +
            "\u0003\u0002p\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003" +
            "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003" +
            "{\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004" +
            "\u0081\b\u0004\n\u0004\f\u0004\u0084\t\u0004\u0001\u0004\u0001\u0004\u0001" +
            "\u0004\u0001\u0005\u0004\u0005\u008a\b\u0005\u000b\u0005\f\u0005\u008b" +
            "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
            "\u0003\u0006\u0094\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006" +
            "\u0099\b\u0006\u0001\u0006\u0003\u0006\u009c\b\u0006\u0001\u0006\u0001" +
            "\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a4" +
            "\b\u0007\n\u0007\f\u0007\u00a7\t\u0007\u0001\u0007\u0001\u0007\u0001\b" +
            "\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005" +
            "\t\u00b4\b\t\n\t\f\t\u00b7\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n" +
            "\u0001\n\u0005\n\u00bf\b\n\n\n\f\n\u00c2\t\n\u0001\n\u0001\n\u0001\u000b" +
            "\u0001\u000b\u0003\u000b\u00c8\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
            "\u0001\u000b\u0001\u000b\u0003\u000b\u00cf\b\u000b\u0001\f\u0004\f\u00d2" +
            "\b\f\u000b\f\f\f\u00d3\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r" +
            "\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
            "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
            "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
            "\r\u0001\r\u0003\r\u00f8\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
            "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
            "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
            "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0118\b\r\n" +
            "\r\f\r\u011b\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0120" +
            "\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001" +
            "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u012c" +
            "\b\u000e\n\u000e\f\u000e\u012f\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f" +
            "\u0005\u000f\u0134\b\u000f\n\u000f\f\u000f\u0137\t\u000f\u0001\u000f\u0001" +
            "\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u013e\b\u0010\n" +
            "\u0010\f\u0010\u0141\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001" +
            "\u0011\u0001\u0011\u0003\u0011\u0148\b\u0011\u0001\u0011\u0001\u0011\u0001" +
            "\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003" +
            "\u0012\u0152\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001" +
            "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003" +
            "\u0013\u015e\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001" +
            "\u0013\u0005\u0013\u0165\b\u0013\n\u0013\f\u0013\u0168\t\u0013\u0001\u0014" +
            "\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014" +
            "\u0170\b\u0014\u0001\u0014\u0005-\u0082\u00a5\u00b5\u00c0\u0003\u001a" +
            "\u001c&\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016" +
            "\u0018\u001a\u001c\u001e \"$&(\u0000\u0005\u0001\u0000\u000e\u000f\u0001" +
            "\u0000\u0010\u0011\u0001\u0000\u0015\u0018\u0001\u0000\u0013\u0014\u0001" +
            "\u0000\u0019\u001a\u018c\u0000-\u0001\u0000\u0000\u0000\u0002j\u0001\u0000" +
            "\u0000\u0000\u0004l\u0001\u0000\u0000\u0000\u0006z\u0001\u0000\u0000\u0000" +
            "\b|\u0001\u0000\u0000\u0000\n\u0089\u0001\u0000\u0000\u0000\f\u008f\u0001" +
            "\u0000\u0000\u0000\u000e\u00a0\u0001\u0000\u0000\u0000\u0010\u00aa\u0001" +
            "\u0000\u0000\u0000\u0012\u00ae\u0001\u0000\u0000\u0000\u0014\u00ba\u0001" +
            "\u0000\u0000\u0000\u0016\u00ce\u0001\u0000\u0000\u0000\u0018\u00d1\u0001" +
            "\u0000\u0000\u0000\u001a\u00f7\u0001\u0000\u0000\u0000\u001c\u011f\u0001" +
            "\u0000\u0000\u0000\u001e\u0130\u0001\u0000\u0000\u0000 \u013a\u0001\u0000" +
            "\u0000\u0000\"\u0144\u0001\u0000\u0000\u0000$\u0151\u0001\u0000\u0000" +
            "\u0000&\u015d\u0001\u0000\u0000\u0000(\u016f\u0001\u0000\u0000\u0000*" +
            ",\u0003\u0006\u0003\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000" +
            "\u0000-.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.0\u0001\u0000" +
            "\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005&\u0000\u000012\u0005\'" +
            "\u0000\u000023\u0005\u0005\u0000\u000034\u0005\u0006\u0000\u000046\u0005" +
            "\u0007\u0000\u000057\u0003\n\u0005\u000065\u0001\u0000\u0000\u000067\u0001" +
            "\u0000\u0000\u000079\u0001\u0000\u0000\u00008:\u0003\u0018\f\u000098\u0001" +
            "\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000" +
            ";<\u0005\b\u0000\u0000<=\u0005\u0000\u0000\u0001=>\u0006\u0000\uffff\uffff" +
            "\u0000>\u0001\u0001\u0000\u0000\u0000?@\u0005\u001c\u0000\u0000@A\u0003" +
            " \u0010\u0000AB\u0005\u0004\u0000\u0000BC\u0006\u0001\uffff\uffff\u0000" +
            "Ck\u0001\u0000\u0000\u0000DE\u0005\u001d\u0000\u0000EF\u0003\u001e\u000f" +
            "\u0000FG\u0005\u0004\u0000\u0000GH\u0006\u0001\uffff\uffff\u0000Hk\u0001" +
            "\u0000\u0000\u0000IJ\u0005\u001e\u0000\u0000JK\u0003\u001a\r\u0000KL\u0005" +
            "\u0004\u0000\u0000LM\u0006\u0001\uffff\uffff\u0000Mk\u0001\u0000\u0000" +
            "\u0000NO\u0003\u001c\u000e\u0000OP\u0005\r\u0000\u0000PQ\u0003\u001a\r" +
            "\u0000QR\u0005\u0004\u0000\u0000RS\u0006\u0001\uffff\uffff\u0000Sk\u0001" +
            "\u0000\u0000\u0000TU\u0005\u001f\u0000\u0000UV\u0005\u0005\u0000\u0000" +
            "VW\u0003\u001a\r\u0000WX\u0005\u0006\u0000\u0000X[\u0003\u0016\u000b\u0000" +
            "YZ\u0005 \u0000\u0000Z\\\u0003\u0016\u000b\u0000[Y\u0001\u0000\u0000\u0000" +
            "[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0006\u0001\uffff" +
            "\uffff\u0000^k\u0001\u0000\u0000\u0000_`\u0005!\u0000\u0000`a\u0005\u0005" +
            "\u0000\u0000ab\u0003\u001a\r\u0000bc\u0005\u0006\u0000\u0000cd\u0003\u0016" +
            "\u000b\u0000de\u0006\u0001\uffff\uffff\u0000ek\u0001\u0000\u0000\u0000" +
            "fg\u0003\u0004\u0002\u0000gh\u0005\u0004\u0000\u0000hi\u0006\u0001\uffff" +
            "\uffff\u0000ik\u0001\u0000\u0000\u0000j?\u0001\u0000\u0000\u0000jD\u0001" +
            "\u0000\u0000\u0000jI\u0001\u0000\u0000\u0000jN\u0001\u0000\u0000\u0000" +
            "jT\u0001\u0000\u0000\u0000j_\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000" +
            "\u0000k\u0003\u0001\u0000\u0000\u0000lm\u0005(\u0000\u0000mo\u0005\u0005" +
            "\u0000\u0000np\u0003\u001e\u000f\u0000on\u0001\u0000\u0000\u0000op\u0001" +
            "\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0005\u0006\u0000\u0000" +
            "rs\u0006\u0002\uffff\uffff\u0000s\u0005\u0001\u0000\u0000\u0000tu\u0003" +
            "\b\u0004\u0000uv\u0006\u0003\uffff\uffff\u0000v{\u0001\u0000\u0000\u0000" +
            "wx\u0003\f\u0006\u0000xy\u0006\u0003\uffff\uffff\u0000y{\u0001\u0000\u0000" +
            "\u0000zt\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000{\u0007\u0001" +
            "\u0000\u0000\u0000|}\u0003&\u0013\u0000}\u0082\u0005(\u0000\u0000~\u007f" +
            "\u0005\f\u0000\u0000\u007f\u0081\u0005(\u0000\u0000\u0080~\u0001\u0000" +
            "\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000" +
            "\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000" +
            "\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0004" +
            "\u0000\u0000\u0086\u0087\u0006\u0004\uffff\uffff\u0000\u0087\t\u0001\u0000" +
            "\u0000\u0000\u0088\u008a\u0003\b\u0004\u0000\u0089\u0088\u0001\u0000\u0000" +
            "\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000" +
            "\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000" +
            "\u0000\u008d\u008e\u0006\u0005\uffff\uffff\u0000\u008e\u000b\u0001\u0000" +
            "\u0000\u0000\u008f\u0090\u0003$\u0012\u0000\u0090\u0091\u0005(\u0000\u0000" +
            "\u0091\u0093\u0005\u0005\u0000\u0000\u0092\u0094\u0003\u000e\u0007\u0000" +
            "\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000" +
            "\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0006\u0000\u0000" +
            "\u0096\u0098\u0005\u0007\u0000\u0000\u0097\u0099\u0003\n\u0005\u0000\u0098" +
            "\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099" +
            "\u009b\u0001\u0000\u0000\u0000\u009a\u009c\u0003\u0018\f\u0000\u009b\u009a" +
            "\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d" +
            "\u0001\u0000\u0000\u0000\u009d\u009e\u0005\b\u0000\u0000\u009e\u009f\u0006" +
            "\u0006\uffff\uffff\u0000\u009f\r\u0001\u0000\u0000\u0000\u00a0\u00a5\u0003" +
            "\u0010\b\u0000\u00a1\u00a2\u0005\f\u0000\u0000\u00a2\u00a4\u0003\u0010" +
            "\b\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000" +
            "\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000" +
            "\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000" +
            "\u0000\u00a8\u00a9\u0006\u0007\uffff\uffff\u0000\u00a9\u000f\u0001\u0000" +
            "\u0000\u0000\u00aa\u00ab\u0003&\u0013\u0000\u00ab\u00ac\u0005(\u0000\u0000" +
            "\u00ac\u00ad\u0006\b\uffff\uffff\u0000\u00ad\u0011\u0001\u0000\u0000\u0000" +
            "\u00ae\u00af\u0003\u0014\n\u0000\u00af\u00b5\u0005\u0004\u0000\u0000\u00b0" +
            "\u00b1\u0003\u0014\n\u0000\u00b1\u00b2\u0005\u0004\u0000\u0000\u00b2\u00b4" +
            "\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b7" +
            "\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b3" +
            "\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5" +
            "\u0001\u0000\u0000\u0000\u00b8\u00b9\u0006\t\uffff\uffff\u0000\u00b9\u0013" +
            "\u0001\u0000\u0000\u0000\u00ba\u00bb\u0003&\u0013\u0000\u00bb\u00c0\u0005" +
            "(\u0000\u0000\u00bc\u00bd\u0005\f\u0000\u0000\u00bd\u00bf\u0005(\u0000" +
            "\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000" +
            "\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000" +
            "\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000" +
            "\u0000\u00c3\u00c4\u0006\n\uffff\uffff\u0000\u00c4\u0015\u0001\u0000\u0000" +
            "\u0000\u00c5\u00c7\u0005\u0007\u0000\u0000\u00c6\u00c8\u0003\u0018\f\u0000" +
            "\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000" +
            "\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\b\u0000\u0000\u00ca" +
            "\u00cf\u0006\u000b\uffff\uffff\u0000\u00cb\u00cc\u0003\u0002\u0001\u0000" +
            "\u00cc\u00cd\u0006\u000b\uffff\uffff\u0000\u00cd\u00cf\u0001\u0000\u0000" +
            "\u0000\u00ce\u00c5\u0001\u0000\u0000\u0000\u00ce\u00cb\u0001\u0000\u0000" +
            "\u0000\u00cf\u0017\u0001\u0000\u0000\u0000\u00d0\u00d2\u0003\u0002\u0001" +
            "\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000" +
            "\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000" +
            "\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0006\f\uffff\uffff" +
            "\u0000\u00d6\u0019\u0001\u0000\u0000\u0000\u00d7\u00d8\u0006\r\uffff\uffff" +
            "\u0000\u00d8\u00d9\u0005\u0005\u0000\u0000\u00d9\u00da\u0003(\u0014\u0000" +
            "\u00da\u00db\u0005\u0006\u0000\u0000\u00db\u00dc\u0003\u001a\r\u000f\u00dc" +
            "\u00dd\u0006\r\uffff\uffff\u0000\u00dd\u00f8\u0001\u0000\u0000\u0000\u00de" +
            "\u00df\u0003\u001c\u000e\u0000\u00df\u00e0\u0006\r\uffff\uffff\u0000\u00e0" +
            "\u00f8\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\u000f\u0000\u0000\u00e2" +
            "\u00e3\u0003\u001a\r\r\u00e3\u00e4\u0006\r\uffff\uffff\u0000\u00e4\u00f8" +
            "\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\u001b\u0000\u0000\u00e6\u00e7" +
            "\u0003\u001a\r\f\u00e7\u00e8\u0006\r\uffff\uffff\u0000\u00e8\u00f8\u0001" +
            "\u0000\u0000\u0000\u00e9\u00ea\u0003\"\u0011\u0000\u00ea\u00eb\u0006\r" +
            "\uffff\uffff\u0000\u00eb\u00f8\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005" +
            "\u0005\u0000\u0000\u00ed\u00ee\u0003\u001a\r\u0000\u00ee\u00ef\u0005\u0006" +
            "\u0000\u0000\u00ef\u00f0\u0006\r\uffff\uffff\u0000\u00f0\u00f8\u0001\u0000" +
            "\u0000\u0000\u00f1\u00f2\u0005)\u0000\u0000\u00f2\u00f8\u0006\r\uffff" +
            "\uffff\u0000\u00f3\u00f4\u0005*\u0000\u0000\u00f4\u00f8\u0006\r\uffff" +
            "\uffff\u0000\u00f5\u00f6\u0005+\u0000\u0000\u00f6\u00f8\u0006\r\uffff" +
            "\uffff\u0000\u00f7\u00d7\u0001\u0000\u0000\u0000\u00f7\u00de\u0001\u0000" +
            "\u0000\u0000\u00f7\u00e1\u0001\u0000\u0000\u0000\u00f7\u00e5\u0001\u0000" +
            "\u0000\u0000\u00f7\u00e9\u0001\u0000\u0000\u0000\u00f7\u00ec\u0001\u0000" +
            "\u0000\u0000\u00f7\u00f1\u0001\u0000\u0000\u0000\u00f7\u00f3\u0001\u0000" +
            "\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u0119\u0001\u0000" +
            "\u0000\u0000\u00f9\u00fa\n\u000b\u0000\u0000\u00fa\u00fb\u0007\u0000\u0000" +
            "\u0000\u00fb\u00fc\u0003\u001a\r\f\u00fc\u00fd\u0006\r\uffff\uffff\u0000" +
            "\u00fd\u0118\u0001\u0000\u0000\u0000\u00fe\u00ff\n\n\u0000\u0000\u00ff" +
            "\u0100\u0007\u0001\u0000\u0000\u0100\u0101\u0003\u001a\r\u000b\u0101\u0102" +
            "\u0006\r\uffff\uffff\u0000\u0102\u0118\u0001\u0000\u0000\u0000\u0103\u0104" +
            "\n\t\u0000\u0000\u0104\u0105\u0005\u0012\u0000\u0000\u0105\u0106\u0003" +
            "\u001a\r\n\u0106\u0107\u0006\r\uffff\uffff\u0000\u0107\u0118\u0001\u0000" +
            "\u0000\u0000\u0108\u0109\n\b\u0000\u0000\u0109\u010a\u0007\u0002\u0000" +
            "\u0000\u010a\u010b\u0003\u001a\r\t\u010b\u010c\u0006\r\uffff\uffff\u0000" +
            "\u010c\u0118\u0001\u0000\u0000\u0000\u010d\u010e\n\u0007\u0000\u0000\u010e" +
            "\u010f\u0007\u0003\u0000\u0000\u010f\u0110\u0003\u001a\r\b\u0110\u0111" +
            "\u0006\r\uffff\uffff\u0000\u0111\u0118\u0001\u0000\u0000\u0000\u0112\u0113" +
            "\n\u0006\u0000\u0000\u0113\u0114\u0007\u0004\u0000\u0000\u0114\u0115\u0003" +
            "\u001a\r\u0007\u0115\u0116\u0006\r\uffff\uffff\u0000\u0116\u0118\u0001" +
            "\u0000\u0000\u0000\u0117\u00f9\u0001\u0000\u0000\u0000\u0117\u00fe\u0001" +
            "\u0000\u0000\u0000\u0117\u0103\u0001\u0000\u0000\u0000\u0117\u0108\u0001" +
            "\u0000\u0000\u0000\u0117\u010d\u0001\u0000\u0000\u0000\u0117\u0112\u0001" +
            "\u0000\u0000\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001" +
            "\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u001b\u0001" +
            "\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u0120\u0006" +
            "\u000e\uffff\uffff\u0000\u011d\u011e\u0005(\u0000\u0000\u011e\u0120\u0006" +
            "\u000e\uffff\uffff\u0000\u011f\u011c\u0001\u0000\u0000\u0000\u011f\u011d" +
            "\u0001\u0000\u0000\u0000\u0120\u012d\u0001\u0000\u0000\u0000\u0121\u0122" +
            "\n\u0003\u0000\u0000\u0122\u0123\u0005\t\u0000\u0000\u0123\u0124\u0003" +
            "\u001a\r\u0000\u0124\u0125\u0005\n\u0000\u0000\u0125\u0126\u0006\u000e" +
            "\uffff\uffff\u0000\u0126\u012c\u0001\u0000\u0000\u0000\u0127\u0128\n\u0002" +
            "\u0000\u0000\u0128\u0129\u0005\u000b\u0000\u0000\u0129\u012a\u0005(\u0000" +
            "\u0000\u012a\u012c\u0006\u000e\uffff\uffff\u0000\u012b\u0121\u0001\u0000" +
            "\u0000\u0000\u012b\u0127\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000" +
            "\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000" +
            "\u0000\u0000\u012e\u001d\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000" +
            "\u0000\u0000\u0130\u0135\u0003\u001a\r\u0000\u0131\u0132\u0005\f\u0000" +
            "\u0000\u0132\u0134\u0003\u001a\r\u0000\u0133\u0131\u0001\u0000\u0000\u0000" +
            "\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000" +
            "\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138\u0001\u0000\u0000\u0000" +
            "\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u0006\u000f\uffff\uffff" +
            "\u0000\u0139\u001f\u0001\u0000\u0000\u0000\u013a\u013f\u0003\u001c\u000e" +
            "\u0000\u013b\u013c\u0005\f\u0000\u0000\u013c\u013e\u0003\u001c\u000e\u0000" +
            "\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u0141\u0001\u0000\u0000\u0000" +
            "\u013f\u013d\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000" +
            "\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000" +
            "\u0142\u0143\u0006\u0010\uffff\uffff\u0000\u0143!\u0001\u0000\u0000\u0000" +
            "\u0144\u0145\u0005(\u0000\u0000\u0145\u0147\u0005\u0005\u0000\u0000\u0146" +
            "\u0148\u0003\u001e\u000f\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147" +
            "\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149" +
            "\u014a\u0005\u0006\u0000\u0000\u014a\u014b\u0006\u0011\uffff\uffff\u0000" +
            "\u014b#\u0001\u0000\u0000\u0000\u014c\u014d\u0003(\u0014\u0000\u014d\u014e" +
            "\u0006\u0012\uffff\uffff\u0000\u014e\u0152\u0001\u0000\u0000\u0000\u014f" +
            "\u0150\u0005&\u0000\u0000\u0150\u0152\u0006\u0012\uffff\uffff\u0000\u0151" +
            "\u014c\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152" +
            "%\u0001\u0000\u0000\u0000\u0153\u0154\u0006\u0013\uffff\uffff\u0000\u0154" +
            "\u0155\u0003(\u0014\u0000\u0155\u0156\u0006\u0013\uffff\uffff\u0000\u0156" +
            "\u015e\u0001\u0000\u0000\u0000\u0157\u0158\u0005\"\u0000\u0000\u0158\u0159" +
            "\u0005\u0007\u0000\u0000\u0159\u015a\u0003\u0012\t\u0000\u015a\u015b\u0005" +
            "\b\u0000\u0000\u015b\u015c\u0006\u0013\uffff\uffff\u0000\u015c\u015e\u0001" +
            "\u0000\u0000\u0000\u015d\u0153\u0001\u0000\u0000\u0000\u015d\u0157\u0001" +
            "\u0000\u0000\u0000\u015e\u0166\u0001\u0000\u0000\u0000\u015f\u0160\n\u0001" +
            "\u0000\u0000\u0160\u0161\u0005\t\u0000\u0000\u0161\u0162\u0005)\u0000" +
            "\u0000\u0162\u0163\u0005\n\u0000\u0000\u0163\u0165\u0006\u0013\uffff\uffff" +
            "\u0000\u0164\u015f\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000" +
            "\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000" +
            "\u0000\u0167\'\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000" +
            "\u0169\u016a\u0005#\u0000\u0000\u016a\u0170\u0006\u0014\uffff\uffff\u0000" +
            "\u016b\u016c\u0005$\u0000\u0000\u016c\u0170\u0006\u0014\uffff\uffff\u0000" +
            "\u016d\u016e\u0005%\u0000\u0000\u016e\u0170\u0006\u0014\uffff\uffff\u0000" +
            "\u016f\u0169\u0001\u0000\u0000\u0000\u016f\u016b\u0001\u0000\u0000\u0000" +
            "\u016f\u016d\u0001\u0000\u0000\u0000\u0170)\u0001\u0000\u0000\u0000\u001f" +
            "-69[joz\u0082\u008b\u0093\u0098\u009b\u00a5\u00b5\u00c0\u00c7\u00ce\u00d3" +
            "\u00f7\u0117\u0119\u011f\u012b\u012d\u0135\u013f\u0147\u0151\u015d\u0166" +
            "\u016f";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public CmmParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
            "program", "statement", "procedureInvocation", "definition", "varDefinition",
            "varDefList", "functionDefinition", "paramsList", "paramDef", "recordFieldList",
            "recordField", "stmtBlock", "stmtList", "expression", "assignableExpression",
            "expressionList", "assignableExpressionList", "functionInvocation", "voidableType",
            "arrayableType", "builtInType"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
            null, null, null, null, "';'", "'('", "')'", "'{'", "'}'", "'['", "']'",
            "'.'", "','", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='",
            "'<'", "'<='", "'>'", "'>='", "'&&'", "'||'", "'!'", "'read'", "'write'",
            "'return'", "'if'", "'else'", "'while'", "'struct'", "'int'", "'double'",
            "'char'", "'void'", "'main'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, "WHITE_SPACES", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "SEMICOLON",
            "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET",
            "RIGHT_BRACKET", "DOT", "COMMA", "ASSIGN", "PLUS", "MINUS", "MULTIPLY",
            "DIVIDE", "MODULO", "RELATIONAL_EQUAL", "RELATIONAL_NOT_EQUAL", "RELATIONAL_LESS_THAN",
            "RELATIONAL_LESS_EQUAL", "RELATIONAL_GREATER_THAN", "RELATIONAL_GREATER_EQUAL",
            "LOGICAL_AND", "LOGICAL_OR", "LOGICAL_NOT", "READ", "WRITE", "RETURN",
            "IF", "ELSE", "WHILE", "STRUCT", "INT", "DOUBLE", "CHAR", "VOID", "MAIN",
            "ID", "INT_CONSTANT", "DOUBLE_CONSTANT", "CHAR_CONSTANT"
        };
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Cmm.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(45);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(42);
                                ((ProgramContext) _localctx).definition = definition();
                                ((ProgramContext) _localctx).defs.add(((ProgramContext) _localctx).definition);
                            }
                        }
                    }
                    setState(47);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                }
                setState(48);
                ((ProgramContext) _localctx).VOID = match(VOID);
                setState(49);
                ((ProgramContext) _localctx).main = match(MAIN);
                setState(50);
                match(LEFT_PAREN);
                setState(51);
                match(RIGHT_PAREN);
                setState(52);
                match(LEFT_BRACE);
                setState(54);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                    case 1: {
                        setState(53);
                        ((ProgramContext) _localctx).varDefList = varDefList();
                    }
                    break;
                }
                setState(57);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(56);
                        ((ProgramContext) _localctx).stmtList = stmtList();
                    }
                    break;
                }
                setState(59);
                match(RIGHT_BRACE);
                setState(60);
                match(EOF);

                List<Definition> defs = new ArrayList<>();
                if (((ProgramContext) _localctx).defs != null) ((ProgramContext) _localctx).defs.forEach(s -> {
                    if (s != null) defs.add(s.ast);
                });
                Type mainFuncType = new FunctionType(((ProgramContext) _localctx).VOID.getLine(), ((ProgramContext) _localctx).VOID.getCharPositionInLine() + 1, new VoidType(((ProgramContext) _localctx).VOID.getLine(), ((ProgramContext) _localctx).VOID.getCharPositionInLine() + 1), new ArrayList<>());
                FunctionDefinition mainFunction = new FunctionDefinition(((ProgramContext) _localctx).VOID.getLine(), ((ProgramContext) _localctx).VOID.getCharPositionInLine() + 1, mainFuncType, new Id(((ProgramContext) _localctx).main.getLine(), ((ProgramContext) _localctx).main.getCharPositionInLine() + 1, ((ProgramContext) _localctx).main.getText()), ((ProgramContext) _localctx).varDefList != null ? ((ProgramContext) _localctx).varDefList.ast : new ArrayList<VariableDefinition>(), ((ProgramContext) _localctx).stmtList != null ? ((ProgramContext) _localctx).stmtList.ast : new ArrayList<Statement>());
                defs.add(mainFunction);
                ((ProgramContext) _localctx).ast = new Program(defs);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statement);
        try {
            setState(106);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(63);
                    ((StatementContext) _localctx).read = match(READ);
                    setState(64);
                    ((StatementContext) _localctx).assignableExpressionList = assignableExpressionList();
                    setState(65);
                    match(SEMICOLON);

                    ((StatementContext) _localctx).ast = new Read(((StatementContext) _localctx).read.getLine(), ((StatementContext) _localctx).read.getCharPositionInLine() + 1, ((StatementContext) _localctx).assignableExpressionList.ast);

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(68);
                    ((StatementContext) _localctx).write = match(WRITE);
                    setState(69);
                    ((StatementContext) _localctx).expressionList = expressionList();
                    setState(70);
                    match(SEMICOLON);

                    ((StatementContext) _localctx).ast = new Write(((StatementContext) _localctx).write.getLine(), ((StatementContext) _localctx).write.getCharPositionInLine() + 1, ((StatementContext) _localctx).expressionList.ast);

                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(73);
                    ((StatementContext) _localctx).return_ = match(RETURN);
                    setState(74);
                    ((StatementContext) _localctx).expression = expression(0);
                    setState(75);
                    match(SEMICOLON);
                    ((StatementContext) _localctx).ast = new Return(((StatementContext) _localctx).return_.getLine(), ((StatementContext) _localctx).return_.getCharPositionInLine() + 1, ((StatementContext) _localctx).expression.ast);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(78);
                    ((StatementContext) _localctx).e1 = assignableExpression(0);
                    setState(79);
                    match(ASSIGN);
                    setState(80);
                    ((StatementContext) _localctx).e2 = expression(0);
                    setState(81);
                    match(SEMICOLON);
                    ((StatementContext) _localctx).ast = new Assignment((((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getLine(), (((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e1.ast, ((StatementContext) _localctx).e2.ast);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(84);
                    ((StatementContext) _localctx).if_ = match(IF);
                    setState(85);
                    match(LEFT_PAREN);
                    setState(86);
                    ((StatementContext) _localctx).expression = expression(0);
                    setState(87);
                    match(RIGHT_PAREN);
                    setState(88);
                    ((StatementContext) _localctx).thenSt = stmtBlock();
                    setState(91);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                        case 1: {
                            setState(89);
                            match(ELSE);
                            setState(90);
                            ((StatementContext) _localctx).elseSt = stmtBlock();
                        }
                        break;
                    }

                    ((StatementContext) _localctx).ast = new IfElse(((StatementContext) _localctx).if_.getLine(), ((StatementContext) _localctx).if_.getCharPositionInLine() + 1, ((StatementContext) _localctx).expression.ast, ((StatementContext) _localctx).thenSt.ast, ((StatementContext) _localctx).elseSt != null ? ((StatementContext) _localctx).elseSt.ast : new ArrayList<>());

                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(95);
                    ((StatementContext) _localctx).while_ = match(WHILE);
                    setState(96);
                    match(LEFT_PAREN);
                    setState(97);
                    ((StatementContext) _localctx).expression = expression(0);
                    setState(98);
                    match(RIGHT_PAREN);
                    setState(99);
                    ((StatementContext) _localctx).stmtBlock = stmtBlock();

                    ((StatementContext) _localctx).ast = new While(((StatementContext) _localctx).while_.getLine(), ((StatementContext) _localctx).while_.getCharPositionInLine() + 1, ((StatementContext) _localctx).expression.ast, ((StatementContext) _localctx).stmtBlock.ast);

                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(102);
                    ((StatementContext) _localctx).procedureInvocation = procedureInvocation();
                    setState(103);
                    match(SEMICOLON);
                    ((StatementContext) _localctx).ast = ((StatementContext) _localctx).procedureInvocation.ast;
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ProcedureInvocationContext procedureInvocation() throws RecognitionException {
        ProcedureInvocationContext _localctx = new ProcedureInvocationContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_procedureInvocation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(108);
                ((ProcedureInvocationContext) _localctx).ID = match(ID);
                setState(109);
                match(LEFT_PAREN);
                setState(111);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                    case 1: {
                        setState(110);
                        ((ProcedureInvocationContext) _localctx).expressionList = expressionList();
                    }
                    break;
                }
                setState(113);
                match(RIGHT_PAREN);

                ((ProcedureInvocationContext) _localctx).ast = new ProcedureInvocation(((ProcedureInvocationContext) _localctx).ID.getLine(), ((ProcedureInvocationContext) _localctx).ID.getCharPositionInLine() + 1, new Id(((ProcedureInvocationContext) _localctx).ID.getLine(), ((ProcedureInvocationContext) _localctx).ID.getCharPositionInLine() + 1, (((ProcedureInvocationContext) _localctx).ID != null ? ((ProcedureInvocationContext) _localctx).ID.getText() : null)), ((ProcedureInvocationContext) _localctx).expressionList != null ? ((ProcedureInvocationContext) _localctx).expressionList.ast : new ArrayList<>());

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefinitionContext definition() throws RecognitionException {
        DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_definition);
        try {
            setState(122);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(116);
                    ((DefinitionContext) _localctx).varDefinition = varDefinition();
                    ((DefinitionContext) _localctx).ast = ((DefinitionContext) _localctx).varDefinition.ast;
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(119);
                    ((DefinitionContext) _localctx).functionDefinition = functionDefinition();
                    ((DefinitionContext) _localctx).ast = ((DefinitionContext) _localctx).functionDefinition.ast;
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VarDefinitionContext varDefinition() throws RecognitionException {
        VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_varDefinition);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(124);
                ((VarDefinitionContext) _localctx).t = arrayableType(0);
                setState(125);
                ((VarDefinitionContext) _localctx).ID = match(ID);
                ((VarDefinitionContext) _localctx).ids.add(((VarDefinitionContext) _localctx).ID);
                setState(130);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(126);
                                match(COMMA);
                                setState(127);
                                ((VarDefinitionContext) _localctx).ID = match(ID);
                                ((VarDefinitionContext) _localctx).ids.add(((VarDefinitionContext) _localctx).ID);
                            }
                        }
                    }
                    setState(132);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                }
                setState(133);
                match(SEMICOLON);

                List<Id> ids = new ArrayList<>();
                if (((VarDefinitionContext) _localctx).ids != null)
                    ((VarDefinitionContext) _localctx).ids.forEach(id -> {
                        if (id != null) ids.add(new Id(id.getLine(), id.getCharPositionInLine() + 1, id.getText()));
                    });
                ((VarDefinitionContext) _localctx).ast = new VariableDefinition((((VarDefinitionContext) _localctx).t != null ? (((VarDefinitionContext) _localctx).t.start) : null).getLine(), (((VarDefinitionContext) _localctx).t != null ? (((VarDefinitionContext) _localctx).t.start) : null).getCharPositionInLine() + 1, ((VarDefinitionContext) _localctx).t.ast, ids);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VarDefListContext varDefList() throws RecognitionException {
        VarDefListContext _localctx = new VarDefListContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_varDefList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(137);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(136);
                                ((VarDefListContext) _localctx).varDefinition = varDefinition();
                                ((VarDefListContext) _localctx).varDefs.add(((VarDefListContext) _localctx).varDefinition);
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(139);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);

                List<VariableDefinition> varDefs = new ArrayList<>();
                if (((VarDefListContext) _localctx).varDefs != null)
                    ((VarDefListContext) _localctx).varDefs.forEach(vd -> {
                        if (vd != null) varDefs.add(vd.ast);
                    });
                ((VarDefListContext) _localctx).ast = varDefs;

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
        FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_functionDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(143);
                ((FunctionDefinitionContext) _localctx).returnType = voidableType();
                setState(144);
                ((FunctionDefinitionContext) _localctx).id = match(ID);
                setState(145);
                match(LEFT_PAREN);
                setState(147);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 257698037760L) != 0)) {
                    {
                        setState(146);
                        ((FunctionDefinitionContext) _localctx).paramsList = paramsList();
                    }
                }

                setState(149);
                match(RIGHT_PAREN);
                setState(150);
                match(LEFT_BRACE);
                setState(152);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                    case 1: {
                        setState(151);
                        ((FunctionDefinitionContext) _localctx).varDefList = varDefList();
                    }
                    break;
                }
                setState(155);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
                    case 1: {
                        setState(154);
                        ((FunctionDefinitionContext) _localctx).stmtList = stmtList();
                    }
                    break;
                }
                setState(157);
                match(RIGHT_BRACE);

                FunctionType returnType = new FunctionType((((FunctionDefinitionContext) _localctx).returnType != null ? (((FunctionDefinitionContext) _localctx).returnType.start) : null).getLine(), (((FunctionDefinitionContext) _localctx).returnType != null ? (((FunctionDefinitionContext) _localctx).returnType.start) : null).getCharPositionInLine() + 1, ((FunctionDefinitionContext) _localctx).returnType.ast, ((FunctionDefinitionContext) _localctx).paramsList != null ? ((FunctionDefinitionContext) _localctx).paramsList.ast : new ArrayList<>());
                ((FunctionDefinitionContext) _localctx).ast = new FunctionDefinition((((FunctionDefinitionContext) _localctx).returnType != null ? (((FunctionDefinitionContext) _localctx).returnType.start) : null).getLine(), (((FunctionDefinitionContext) _localctx).returnType != null ? (((FunctionDefinitionContext) _localctx).returnType.start) : null).getCharPositionInLine() + 1, returnType, new Id(((FunctionDefinitionContext) _localctx).id.getLine(), ((FunctionDefinitionContext) _localctx).id.getCharPositionInLine() + 1, (((FunctionDefinitionContext) _localctx).id != null ? ((FunctionDefinitionContext) _localctx).id.getText() : null)), ((FunctionDefinitionContext) _localctx).varDefList != null ? ((FunctionDefinitionContext) _localctx).varDefList.ast : new ArrayList<>(), ((FunctionDefinitionContext) _localctx).stmtList != null ? ((FunctionDefinitionContext) _localctx).stmtList.ast : new ArrayList<>());

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParamsListContext paramsList() throws RecognitionException {
        ParamsListContext _localctx = new ParamsListContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_paramsList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(160);
                ((ParamsListContext) _localctx).paramDef = paramDef();
                ((ParamsListContext) _localctx).params.add(((ParamsListContext) _localctx).paramDef);
                setState(165);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(161);
                                match(COMMA);
                                setState(162);
                                ((ParamsListContext) _localctx).paramDef = paramDef();
                                ((ParamsListContext) _localctx).params.add(((ParamsListContext) _localctx).paramDef);
                            }
                        }
                    }
                    setState(167);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                }

                List<VariableDefinition> params = new ArrayList<>();
                if (((ParamsListContext) _localctx).params != null)
                    ((ParamsListContext) _localctx).params.forEach(p -> {
                        if (p != null) params.add(p.ast);
                    });
                ((ParamsListContext) _localctx).ast = params;

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParamDefContext paramDef() throws RecognitionException {
        ParamDefContext _localctx = new ParamDefContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_paramDef);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(170);
                ((ParamDefContext) _localctx).t = arrayableType(0);
                setState(171);
                ((ParamDefContext) _localctx).id = match(ID);

                List<Id> ids = new ArrayList<>();
                ids.add(new Id(((ParamDefContext) _localctx).id.getLine(), ((ParamDefContext) _localctx).id.getCharPositionInLine() + 1, ((ParamDefContext) _localctx).id.getText()));
                ((ParamDefContext) _localctx).ast = new VariableDefinition((((ParamDefContext) _localctx).t != null ? (((ParamDefContext) _localctx).t.start) : null).getLine(), (((ParamDefContext) _localctx).t != null ? (((ParamDefContext) _localctx).t.start) : null).getCharPositionInLine() + 1, ((ParamDefContext) _localctx).t.ast, ids);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RecordFieldListContext recordFieldList() throws RecognitionException {
        RecordFieldListContext _localctx = new RecordFieldListContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_recordFieldList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(174);
                ((RecordFieldListContext) _localctx).recordField = recordField();
                ((RecordFieldListContext) _localctx).field.add(((RecordFieldListContext) _localctx).recordField);
                setState(175);
                match(SEMICOLON);
                setState(181);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(176);
                                ((RecordFieldListContext) _localctx).recordField = recordField();
                                ((RecordFieldListContext) _localctx).field.add(((RecordFieldListContext) _localctx).recordField);
                                setState(177);
                                match(SEMICOLON);
                            }
                        }
                    }
                    setState(183);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                }

                List<StructRecordField> fields = new ArrayList<>();
                if (((RecordFieldListContext) _localctx).field != null)
                    ((RecordFieldListContext) _localctx).field.forEach(f -> {
                        if (f != null) fields.add(f.ast);
                    });
                ((RecordFieldListContext) _localctx).ast = fields;

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RecordFieldContext recordField() throws RecognitionException {
        RecordFieldContext _localctx = new RecordFieldContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_recordField);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(186);
                ((RecordFieldContext) _localctx).type = arrayableType(0);
                setState(187);
                ((RecordFieldContext) _localctx).ID = match(ID);
                ((RecordFieldContext) _localctx).id.add(((RecordFieldContext) _localctx).ID);
                setState(192);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(188);
                                match(COMMA);
                                setState(189);
                                ((RecordFieldContext) _localctx).ID = match(ID);
                                ((RecordFieldContext) _localctx).id.add(((RecordFieldContext) _localctx).ID);
                            }
                        }
                    }
                    setState(194);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                }

                List<Id> ids = new ArrayList<>();
                if (((RecordFieldContext) _localctx).id != null) ((RecordFieldContext) _localctx).id.forEach(i -> {
                    if (i != null) ids.add(new Id(i.getLine(), i.getCharPositionInLine() + 1, i.getText()));
                });
                ((RecordFieldContext) _localctx).ast = new StructRecordField(((RecordFieldContext) _localctx).type.ast.getLine(), ((RecordFieldContext) _localctx).type.ast.getColumn(), ((RecordFieldContext) _localctx).type.ast, ids);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StmtBlockContext stmtBlock() throws RecognitionException {
        StmtBlockContext _localctx = new StmtBlockContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_stmtBlock);
        try {
            setState(206);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(197);
                    match(LEFT_BRACE);
                    setState(199);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                        case 1: {
                            setState(198);
                            ((StmtBlockContext) _localctx).stmtList = stmtList();
                        }
                        break;
                    }
                    setState(201);
                    match(RIGHT_BRACE);

                    ((StmtBlockContext) _localctx).ast = ((StmtBlockContext) _localctx).stmtList != null ? ((StmtBlockContext) _localctx).stmtList.ast : new ArrayList<>();

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(203);
                    ((StmtBlockContext) _localctx).statement = statement();

                    List<Statement> stmts = new ArrayList<>();
                    stmts.add(((StmtBlockContext) _localctx).statement.ast);
                    ((StmtBlockContext) _localctx).ast = stmts;

                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StmtListContext stmtList() throws RecognitionException {
        StmtListContext _localctx = new StmtListContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_stmtList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(209);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(208);
                                ((StmtListContext) _localctx).statement = statement();
                                ((StmtListContext) _localctx).stmts.add(((StmtListContext) _localctx).statement);
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(211);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);

                List<Statement> stmts = new ArrayList<>();
                if (((StmtListContext) _localctx).stmts != null) ((StmtListContext) _localctx).stmts.forEach(s -> {
                    if (s != null) stmts.add(s.ast);
                });
                ((StmtListContext) _localctx).ast = stmts;

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        return expression(0);
    }

    private ExpressionContext expression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
        ExpressionContext _prevctx = _localctx;
        int _startState = 26;
        enterRecursionRule(_localctx, 26, RULE_expression, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(247);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
                    case 1: {
                        setState(216);
                        ((ExpressionContext) _localctx).lp = match(LEFT_PAREN);
                        setState(217);
                        ((ExpressionContext) _localctx).castType = builtInType();
                        setState(218);
                        match(RIGHT_PAREN);
                        setState(219);
                        ((ExpressionContext) _localctx).e = ((ExpressionContext) _localctx).expression = expression(15);
                        ((ExpressionContext) _localctx).ast = new Cast(((ExpressionContext) _localctx).lp.getLine(), ((ExpressionContext) _localctx).lp.getCharPositionInLine() + 1, ((ExpressionContext) _localctx).castType.ast, ((ExpressionContext) _localctx).e.ast);
                    }
                    break;
                    case 2: {
                        setState(222);
                        ((ExpressionContext) _localctx).assignableExpression = assignableExpression(0);
                        ((ExpressionContext) _localctx).ast = ((ExpressionContext) _localctx).assignableExpression.ast;
                    }
                    break;
                    case 3: {
                        setState(225);
                        ((ExpressionContext) _localctx).min = match(MINUS);
                        setState(226);
                        ((ExpressionContext) _localctx).expression = expression(13);
                        ((ExpressionContext) _localctx).ast = new UnaryMinus(((ExpressionContext) _localctx).min.getLine(), ((ExpressionContext) _localctx).min.getCharPositionInLine() + 1, ((ExpressionContext) _localctx).expression.ast);
                    }
                    break;
                    case 4: {
                        setState(229);
                        ((ExpressionContext) _localctx).logNot = match(LOGICAL_NOT);
                        setState(230);
                        ((ExpressionContext) _localctx).expression = expression(12);
                        ((ExpressionContext) _localctx).ast = new LogicalNot(((ExpressionContext) _localctx).logNot.getLine(), ((ExpressionContext) _localctx).logNot.getCharPositionInLine() + 1, ((ExpressionContext) _localctx).expression.ast);
                    }
                    break;
                    case 5: {
                        setState(233);
                        ((ExpressionContext) _localctx).functionInvocation = functionInvocation();
                        ((ExpressionContext) _localctx).ast = ((ExpressionContext) _localctx).functionInvocation.ast;
                    }
                    break;
                    case 6: {
                        setState(236);
                        ((ExpressionContext) _localctx).lp = match(LEFT_PAREN);
                        setState(237);
                        ((ExpressionContext) _localctx).expression = expression(0);
                        setState(238);
                        match(RIGHT_PAREN);
                        ((ExpressionContext) _localctx).ast = new Parenthesis(((ExpressionContext) _localctx).lp.getLine(), ((ExpressionContext) _localctx).lp.getCharPositionInLine() + 1, ((ExpressionContext) _localctx).expression.ast);
                    }
                    break;
                    case 7: {
                        setState(241);
                        ((ExpressionContext) _localctx).INT_CONSTANT = match(INT_CONSTANT);
                        ((ExpressionContext) _localctx).ast = new IntLiteral(((ExpressionContext) _localctx).INT_CONSTANT.getLine(), ((ExpressionContext) _localctx).INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((ExpressionContext) _localctx).INT_CONSTANT != null ? ((ExpressionContext) _localctx).INT_CONSTANT.getText() : null)));
                    }
                    break;
                    case 8: {
                        setState(243);
                        ((ExpressionContext) _localctx).DOUBLE_CONSTANT = match(DOUBLE_CONSTANT);
                        ((ExpressionContext) _localctx).ast = new DoubleLiteral(((ExpressionContext) _localctx).DOUBLE_CONSTANT.getLine(), ((ExpressionContext) _localctx).DOUBLE_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToDouble((((ExpressionContext) _localctx).DOUBLE_CONSTANT != null ? ((ExpressionContext) _localctx).DOUBLE_CONSTANT.getText() : null)));
                    }
                    break;
                    case 9: {
                        setState(245);
                        ((ExpressionContext) _localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
                        ((ExpressionContext) _localctx).ast = new CharLiteral(((ExpressionContext) _localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext) _localctx).CHAR_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToChar((((ExpressionContext) _localctx).CHAR_CONSTANT != null ? ((ExpressionContext) _localctx).CHAR_CONSTANT.getText() : null)));
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(281);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(279);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                                case 1: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(249);
                                    if (!(precpred(_ctx, 11)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(250);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == PLUS || _la == MINUS)) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(251);
                                    ((ExpressionContext) _localctx).e2 = ((ExpressionContext) _localctx).expression = expression(12);
                                    ((ExpressionContext) _localctx).ast = new Arithmetic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 2: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(254);
                                    if (!(precpred(_ctx, 10)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                                    setState(255);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == MULTIPLY || _la == DIVIDE)) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(256);
                                    ((ExpressionContext) _localctx).e2 = ((ExpressionContext) _localctx).expression = expression(11);
                                    ((ExpressionContext) _localctx).ast = new Arithmetic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 3: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(259);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(260);
                                    match(MODULO);
                                    setState(261);
                                    ((ExpressionContext) _localctx).e2 = ((ExpressionContext) _localctx).expression = expression(10);
                                    ((ExpressionContext) _localctx).ast = new Modulus((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 4: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(264);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(265);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0))) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(266);
                                    ((ExpressionContext) _localctx).e2 = ((ExpressionContext) _localctx).expression = expression(9);
                                    ((ExpressionContext) _localctx).ast = new Relational((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 5: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(269);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(270);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == RELATIONAL_EQUAL || _la == RELATIONAL_NOT_EQUAL)) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(271);
                                    ((ExpressionContext) _localctx).e2 = ((ExpressionContext) _localctx).expression = expression(8);
                                    ((ExpressionContext) _localctx).ast = new Relational((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 6: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(274);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(275);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == LOGICAL_AND || _la == LOGICAL_OR)) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(276);
                                    ((ExpressionContext) _localctx).e2 = ((ExpressionContext) _localctx).expression = expression(7);
                                    ((ExpressionContext) _localctx).ast = new Logical((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                            }
                        }
                    }
                    setState(283);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final AssignableExpressionContext assignableExpression() throws RecognitionException {
        return assignableExpression(0);
    }

    private AssignableExpressionContext assignableExpression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        AssignableExpressionContext _localctx = new AssignableExpressionContext(_ctx, _parentState);
        AssignableExpressionContext _prevctx = _localctx;
        int _startState = 28;
        enterRecursionRule(_localctx, 28, RULE_assignableExpression, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(287);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
                    case 1: {
                    }
                    break;
                    case 2: {
                        setState(285);
                        ((AssignableExpressionContext) _localctx).ID = match(ID);
                        ((AssignableExpressionContext) _localctx).ast = new Id(((AssignableExpressionContext) _localctx).ID.getLine(), ((AssignableExpressionContext) _localctx).ID.getCharPositionInLine() + 1, (((AssignableExpressionContext) _localctx).ID != null ? ((AssignableExpressionContext) _localctx).ID.getText() : null));
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(301);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(299);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
                                case 1: {
                                    _localctx = new AssignableExpressionContext(_parentctx, _parentState);
                                    _localctx.e = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_assignableExpression);
                                    setState(289);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(290);
                                    ((AssignableExpressionContext) _localctx).lb = match(LEFT_BRACKET);
                                    setState(291);
                                    ((AssignableExpressionContext) _localctx).ai = expression(0);
                                    setState(292);
                                    ((AssignableExpressionContext) _localctx).rb = match(RIGHT_BRACKET);
                                    ((AssignableExpressionContext) _localctx).ast = new ArrayAccess((((AssignableExpressionContext) _localctx).e != null ? (((AssignableExpressionContext) _localctx).e.start) : null).getLine(), (((AssignableExpressionContext) _localctx).e != null ? (((AssignableExpressionContext) _localctx).e.start) : null).getCharPositionInLine() + 1, ((AssignableExpressionContext) _localctx).e.ast, ((AssignableExpressionContext) _localctx).ai.ast);
                                }
                                break;
                                case 2: {
                                    _localctx = new AssignableExpressionContext(_parentctx, _parentState);
                                    _localctx.e = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_assignableExpression);
                                    setState(295);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(296);
                                    match(DOT);
                                    setState(297);
                                    ((AssignableExpressionContext) _localctx).ID = match(ID);
                                    ((AssignableExpressionContext) _localctx).ast = new StructAccess((((AssignableExpressionContext) _localctx).e != null ? (((AssignableExpressionContext) _localctx).e.start) : null).getLine(), (((AssignableExpressionContext) _localctx).e != null ? (((AssignableExpressionContext) _localctx).e.start) : null).getCharPositionInLine() + 1, ((AssignableExpressionContext) _localctx).e.ast, (((AssignableExpressionContext) _localctx).ID != null ? ((AssignableExpressionContext) _localctx).ID.getText() : null));
                                }
                                break;
                            }
                        }
                    }
                    setState(303);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final ExpressionListContext expressionList() throws RecognitionException {
        ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_expressionList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(304);
                ((ExpressionListContext) _localctx).expression = expression(0);
                ((ExpressionListContext) _localctx).exp.add(((ExpressionListContext) _localctx).expression);
                setState(309);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(305);
                            match(COMMA);
                            setState(306);
                            ((ExpressionListContext) _localctx).expression = expression(0);
                            ((ExpressionListContext) _localctx).exp.add(((ExpressionListContext) _localctx).expression);
                        }
                    }
                    setState(311);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }

                List<Expression> exp = new ArrayList<>();
                if (((ExpressionListContext) _localctx).exp != null)
                    ((ExpressionListContext) _localctx).exp.forEach(e -> {
                        if (e != null) exp.add(e.ast);
                    });
                ((ExpressionListContext) _localctx).ast = exp;

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignableExpressionListContext assignableExpressionList() throws RecognitionException {
        AssignableExpressionListContext _localctx = new AssignableExpressionListContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_assignableExpressionList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(314);
                ((AssignableExpressionListContext) _localctx).assignableExpression = assignableExpression(0);
                ((AssignableExpressionListContext) _localctx).exp.add(((AssignableExpressionListContext) _localctx).assignableExpression);
                setState(319);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(315);
                            match(COMMA);
                            setState(316);
                            ((AssignableExpressionListContext) _localctx).assignableExpression = assignableExpression(0);
                            ((AssignableExpressionListContext) _localctx).exp.add(((AssignableExpressionListContext) _localctx).assignableExpression);
                        }
                    }
                    setState(321);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }

                List<Expression> exp = new ArrayList<>();
                if (((AssignableExpressionListContext) _localctx).exp != null)
                    ((AssignableExpressionListContext) _localctx).exp.forEach(e -> {
                        if (e != null) exp.add(e.ast);
                    });
                ((AssignableExpressionListContext) _localctx).ast = exp;

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionInvocationContext functionInvocation() throws RecognitionException {
        FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_functionInvocation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(324);
                ((FunctionInvocationContext) _localctx).ID = match(ID);
                setState(325);
                match(LEFT_PAREN);
                setState(327);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
                    case 1: {
                        setState(326);
                        ((FunctionInvocationContext) _localctx).expressionList = expressionList();
                    }
                    break;
                }
                setState(329);
                match(RIGHT_PAREN);

                ((FunctionInvocationContext) _localctx).ast = new FunctionInvocation(((FunctionInvocationContext) _localctx).ID.getLine(), ((FunctionInvocationContext) _localctx).ID.getCharPositionInLine() + 1, new Id(((FunctionInvocationContext) _localctx).ID.getLine(), ((FunctionInvocationContext) _localctx).ID.getCharPositionInLine() + 1, (((FunctionInvocationContext) _localctx).ID != null ? ((FunctionInvocationContext) _localctx).ID.getText() : null)), ((FunctionInvocationContext) _localctx).expressionList != null ? ((FunctionInvocationContext) _localctx).expressionList.ast : new ArrayList<>());

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VoidableTypeContext voidableType() throws RecognitionException {
        VoidableTypeContext _localctx = new VoidableTypeContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_voidableType);
        try {
            setState(337);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                case DOUBLE:
                case CHAR:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(332);
                    ((VoidableTypeContext) _localctx).baseType = builtInType();
                    ((VoidableTypeContext) _localctx).ast = ((VoidableTypeContext) _localctx).baseType.ast;
                }
                break;
                case VOID:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(335);
                    ((VoidableTypeContext) _localctx).void_ = match(VOID);
                    ((VoidableTypeContext) _localctx).ast = new VoidType(((VoidableTypeContext) _localctx).void_.getLine(), ((VoidableTypeContext) _localctx).void_.getCharPositionInLine() + 1);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArrayableTypeContext arrayableType() throws RecognitionException {
        return arrayableType(0);
    }

    private ArrayableTypeContext arrayableType(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ArrayableTypeContext _localctx = new ArrayableTypeContext(_ctx, _parentState);
        ArrayableTypeContext _prevctx = _localctx;
        int _startState = 38;
        enterRecursionRule(_localctx, 38, RULE_arrayableType, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(349);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case INT:
                    case DOUBLE:
                    case CHAR: {
                        setState(340);
                        ((ArrayableTypeContext) _localctx).baseType = builtInType();
                        ((ArrayableTypeContext) _localctx).ast = ((ArrayableTypeContext) _localctx).baseType.ast;
                    }
                    break;
                    case STRUCT: {
                        setState(343);
                        ((ArrayableTypeContext) _localctx).struct = match(STRUCT);
                        setState(344);
                        match(LEFT_BRACE);
                        setState(345);
                        ((ArrayableTypeContext) _localctx).recordFieldList = recordFieldList();
                        setState(346);
                        match(RIGHT_BRACE);

                        int line = _localctx.getStart().getLine();
                        int col = _localctx.getStart().getCharPositionInLine() + 1;
                        ((ArrayableTypeContext) _localctx).ast = new StructType(line, col, ((ArrayableTypeContext) _localctx).recordFieldList.ast);

                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(358);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 29, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ArrayableTypeContext(_parentctx, _parentState);
                                _localctx.type = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_arrayableType);
                                setState(351);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(352);
                                match(LEFT_BRACKET);
                                setState(353);
                                ((ArrayableTypeContext) _localctx).INT_CONSTANT = match(INT_CONSTANT);
                                setState(354);
                                match(RIGHT_BRACKET);

                                int size = LexerHelper.lexemeToInt((((ArrayableTypeContext) _localctx).INT_CONSTANT != null ? ((ArrayableTypeContext) _localctx).INT_CONSTANT.getText() : null));
                                ((ArrayableTypeContext) _localctx).ast = new ArrayType(((ArrayableTypeContext) _localctx).type.ast.getLine(), ((ArrayableTypeContext) _localctx).type.ast.getColumn(), ((ArrayableTypeContext) _localctx).type.ast, size);

                            }
                        }
                    }
                    setState(360);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 29, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final BuiltInTypeContext builtInType() throws RecognitionException {
        BuiltInTypeContext _localctx = new BuiltInTypeContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_builtInType);
        try {
            setState(367);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(361);
                    ((BuiltInTypeContext) _localctx).int_ = match(INT);
                    ((BuiltInTypeContext) _localctx).ast = new IntType(((BuiltInTypeContext) _localctx).int_.getLine(), ((BuiltInTypeContext) _localctx).int_.getCharPositionInLine() + 1);
                }
                break;
                case DOUBLE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(363);
                    ((BuiltInTypeContext) _localctx).double_ = match(DOUBLE);
                    ((BuiltInTypeContext) _localctx).ast = new DoubleType(((BuiltInTypeContext) _localctx).double_.getLine(), ((BuiltInTypeContext) _localctx).double_.getCharPositionInLine() + 1);
                }
                break;
                case CHAR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(365);
                    ((BuiltInTypeContext) _localctx).char_ = match(CHAR);
                    ((BuiltInTypeContext) _localctx).ast = new CharType(((BuiltInTypeContext) _localctx).char_.getLine(), ((BuiltInTypeContext) _localctx).char_.getCharPositionInLine() + 1);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 13:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
            case 14:
                return assignableExpression_sempred((AssignableExpressionContext) _localctx, predIndex);
            case 19:
                return arrayableType_sempred((ArrayableTypeContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 11);
            case 1:
                return precpred(_ctx, 10);
            case 2:
                return precpred(_ctx, 9);
            case 3:
                return precpred(_ctx, 8);
            case 4:
                return precpred(_ctx, 7);
            case 5:
                return precpred(_ctx, 6);
        }
        return true;
    }

    private boolean assignableExpression_sempred(AssignableExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 6:
                return precpred(_ctx, 3);
            case 7:
                return precpred(_ctx, 2);
        }
        return true;
    }

    private boolean arrayableType_sempred(ArrayableTypeContext _localctx, int predIndex) {
        switch (predIndex) {
            case 8:
                return precpred(_ctx, 1);
        }
        return true;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ProgramContext extends ParserRuleContext {
        public Program ast;
        public DefinitionContext definition;
        public List<DefinitionContext> defs = new ArrayList<DefinitionContext>();
        public Token VOID;
        public Token main;
        public VarDefListContext varDefList;
        public StmtListContext stmtList;

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VOID() {
            return getToken(CmmParser.VOID, 0);
        }

        public TerminalNode LEFT_PAREN() {
            return getToken(CmmParser.LEFT_PAREN, 0);
        }

        public TerminalNode RIGHT_PAREN() {
            return getToken(CmmParser.RIGHT_PAREN, 0);
        }

        public TerminalNode LEFT_BRACE() {
            return getToken(CmmParser.LEFT_BRACE, 0);
        }

        public TerminalNode RIGHT_BRACE() {
            return getToken(CmmParser.RIGHT_BRACE, 0);
        }

        public TerminalNode EOF() {
            return getToken(CmmParser.EOF, 0);
        }

        public TerminalNode MAIN() {
            return getToken(CmmParser.MAIN, 0);
        }

        public VarDefListContext varDefList() {
            return getRuleContext(VarDefListContext.class, 0);
        }

        public StmtListContext stmtList() {
            return getRuleContext(StmtListContext.class, 0);
        }

        public List<DefinitionContext> definition() {
            return getRuleContexts(DefinitionContext.class);
        }

        public DefinitionContext definition(int i) {
            return getRuleContext(DefinitionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitProgram(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StatementContext extends ParserRuleContext {
        public Statement ast;
        public Token read;
        public AssignableExpressionListContext assignableExpressionList;
        public Token write;
        public ExpressionListContext expressionList;
        public Token return_;
        public ExpressionContext expression;
        public AssignableExpressionContext e1;
        public ExpressionContext e2;
        public Token if_;
        public StmtBlockContext thenSt;
        public StmtBlockContext elseSt;
        public Token while_;
        public StmtBlockContext stmtBlock;
        public ProcedureInvocationContext procedureInvocation;

        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public AssignableExpressionListContext assignableExpressionList() {
            return getRuleContext(AssignableExpressionListContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(CmmParser.SEMICOLON, 0);
        }

        public TerminalNode READ() {
            return getToken(CmmParser.READ, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        public TerminalNode WRITE() {
            return getToken(CmmParser.WRITE, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode RETURN() {
            return getToken(CmmParser.RETURN, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(CmmParser.ASSIGN, 0);
        }

        public AssignableExpressionContext assignableExpression() {
            return getRuleContext(AssignableExpressionContext.class, 0);
        }

        public TerminalNode LEFT_PAREN() {
            return getToken(CmmParser.LEFT_PAREN, 0);
        }

        public TerminalNode RIGHT_PAREN() {
            return getToken(CmmParser.RIGHT_PAREN, 0);
        }

        public TerminalNode IF() {
            return getToken(CmmParser.IF, 0);
        }

        public List<StmtBlockContext> stmtBlock() {
            return getRuleContexts(StmtBlockContext.class);
        }

        public StmtBlockContext stmtBlock(int i) {
            return getRuleContext(StmtBlockContext.class, i);
        }

        public TerminalNode ELSE() {
            return getToken(CmmParser.ELSE, 0);
        }

        public TerminalNode WHILE() {
            return getToken(CmmParser.WHILE, 0);
        }

        public ProcedureInvocationContext procedureInvocation() {
            return getRuleContext(ProcedureInvocationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ProcedureInvocationContext extends ParserRuleContext {
        public Statement ast;
        public Token ID;
        public ExpressionListContext expressionList;

        public ProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public TerminalNode LEFT_PAREN() {
            return getToken(CmmParser.LEFT_PAREN, 0);
        }

        public TerminalNode RIGHT_PAREN() {
            return getToken(CmmParser.RIGHT_PAREN, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_procedureInvocation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterProcedureInvocation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitProcedureInvocation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor)
                return ((CmmVisitor<? extends T>) visitor).visitProcedureInvocation(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DefinitionContext extends ParserRuleContext {
        public Definition ast;
        public VarDefinitionContext varDefinition;
        public FunctionDefinitionContext functionDefinition;

        public DefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VarDefinitionContext varDefinition() {
            return getRuleContext(VarDefinitionContext.class, 0);
        }

        public FunctionDefinitionContext functionDefinition() {
            return getRuleContext(FunctionDefinitionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitDefinition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitDefinition(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VarDefinitionContext extends ParserRuleContext {
        public VariableDefinition ast;
        public ArrayableTypeContext t;
        public Token ID;
        public List<Token> ids = new ArrayList<Token>();

        public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SEMICOLON() {
            return getToken(CmmParser.SEMICOLON, 0);
        }

        public ArrayableTypeContext arrayableType() {
            return getRuleContext(ArrayableTypeContext.class, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(CmmParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(CmmParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterVarDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitVarDefinition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitVarDefinition(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VarDefListContext extends ParserRuleContext {
        public List<VariableDefinition> ast;
        public VarDefinitionContext varDefinition;
        public List<VarDefinitionContext> varDefs = new ArrayList<VarDefinitionContext>();

        public VarDefListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<VarDefinitionContext> varDefinition() {
            return getRuleContexts(VarDefinitionContext.class);
        }

        public VarDefinitionContext varDefinition(int i) {
            return getRuleContext(VarDefinitionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varDefList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterVarDefList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitVarDefList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitVarDefList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionDefinitionContext extends ParserRuleContext {
        public FunctionDefinition ast;
        public VoidableTypeContext returnType;
        public Token id;
        public ParamsListContext paramsList;
        public VarDefListContext varDefList;
        public StmtListContext stmtList;

        public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LEFT_PAREN() {
            return getToken(CmmParser.LEFT_PAREN, 0);
        }

        public TerminalNode RIGHT_PAREN() {
            return getToken(CmmParser.RIGHT_PAREN, 0);
        }

        public TerminalNode LEFT_BRACE() {
            return getToken(CmmParser.LEFT_BRACE, 0);
        }

        public TerminalNode RIGHT_BRACE() {
            return getToken(CmmParser.RIGHT_BRACE, 0);
        }

        public VoidableTypeContext voidableType() {
            return getRuleContext(VoidableTypeContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public ParamsListContext paramsList() {
            return getRuleContext(ParamsListContext.class, 0);
        }

        public VarDefListContext varDefList() {
            return getRuleContext(VarDefListContext.class, 0);
        }

        public StmtListContext stmtList() {
            return getRuleContext(StmtListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterFunctionDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitFunctionDefinition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitFunctionDefinition(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ParamsListContext extends ParserRuleContext {
        public List<VariableDefinition> ast;
        public ParamDefContext paramDef;
        public List<ParamDefContext> params = new ArrayList<ParamDefContext>();

        public ParamsListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ParamDefContext> paramDef() {
            return getRuleContexts(ParamDefContext.class);
        }

        public ParamDefContext paramDef(int i) {
            return getRuleContext(ParamDefContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(CmmParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_paramsList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterParamsList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitParamsList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitParamsList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ParamDefContext extends ParserRuleContext {
        public VariableDefinition ast;
        public ArrayableTypeContext t;
        public Token id;

        public ParamDefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ArrayableTypeContext arrayableType() {
            return getRuleContext(ArrayableTypeContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_paramDef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterParamDef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitParamDef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitParamDef(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RecordFieldListContext extends ParserRuleContext {
        public List<StructRecordField> ast;
        public RecordFieldContext recordField;
        public List<RecordFieldContext> field = new ArrayList<RecordFieldContext>();

        public RecordFieldListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(CmmParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(CmmParser.SEMICOLON, i);
        }

        public List<RecordFieldContext> recordField() {
            return getRuleContexts(RecordFieldContext.class);
        }

        public RecordFieldContext recordField(int i) {
            return getRuleContext(RecordFieldContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_recordFieldList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterRecordFieldList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitRecordFieldList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitRecordFieldList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RecordFieldContext extends ParserRuleContext {
        public StructRecordField ast;
        public ArrayableTypeContext type;
        public Token ID;
        public List<Token> id = new ArrayList<Token>();

        public RecordFieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ArrayableTypeContext arrayableType() {
            return getRuleContext(ArrayableTypeContext.class, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(CmmParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(CmmParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_recordField;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterRecordField(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitRecordField(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitRecordField(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StmtBlockContext extends ParserRuleContext {
        public List<Statement> ast;
        public StmtListContext stmtList;
        public StatementContext statement;

        public StmtBlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LEFT_BRACE() {
            return getToken(CmmParser.LEFT_BRACE, 0);
        }

        public TerminalNode RIGHT_BRACE() {
            return getToken(CmmParser.RIGHT_BRACE, 0);
        }

        public StmtListContext stmtList() {
            return getRuleContext(StmtListContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmtBlock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterStmtBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitStmtBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitStmtBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StmtListContext extends ParserRuleContext {
        public List<Statement> ast;
        public StatementContext statement;
        public List<StatementContext> stmts = new ArrayList<StatementContext>();

        public StmtListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmtList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterStmtList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitStmtList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitStmtList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExpressionContext extends ParserRuleContext {
        public Expression ast;
        public ExpressionContext e1;
        public Token lp;
        public BuiltInTypeContext castType;
        public ExpressionContext e;
        public ExpressionContext expression;
        public AssignableExpressionContext assignableExpression;
        public Token min;
        public Token logNot;
        public FunctionInvocationContext functionInvocation;
        public Token INT_CONSTANT;
        public Token DOUBLE_CONSTANT;
        public Token CHAR_CONSTANT;
        public Token op;
        public ExpressionContext e2;

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RIGHT_PAREN() {
            return getToken(CmmParser.RIGHT_PAREN, 0);
        }

        public TerminalNode LEFT_PAREN() {
            return getToken(CmmParser.LEFT_PAREN, 0);
        }

        public BuiltInTypeContext builtInType() {
            return getRuleContext(BuiltInTypeContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public AssignableExpressionContext assignableExpression() {
            return getRuleContext(AssignableExpressionContext.class, 0);
        }

        public TerminalNode MINUS() {
            return getToken(CmmParser.MINUS, 0);
        }

        public TerminalNode LOGICAL_NOT() {
            return getToken(CmmParser.LOGICAL_NOT, 0);
        }

        public FunctionInvocationContext functionInvocation() {
            return getRuleContext(FunctionInvocationContext.class, 0);
        }

        public TerminalNode INT_CONSTANT() {
            return getToken(CmmParser.INT_CONSTANT, 0);
        }

        public TerminalNode DOUBLE_CONSTANT() {
            return getToken(CmmParser.DOUBLE_CONSTANT, 0);
        }

        public TerminalNode CHAR_CONSTANT() {
            return getToken(CmmParser.CHAR_CONSTANT, 0);
        }

        public TerminalNode PLUS() {
            return getToken(CmmParser.PLUS, 0);
        }

        public TerminalNode MULTIPLY() {
            return getToken(CmmParser.MULTIPLY, 0);
        }

        public TerminalNode DIVIDE() {
            return getToken(CmmParser.DIVIDE, 0);
        }

        public TerminalNode MODULO() {
            return getToken(CmmParser.MODULO, 0);
        }

        public TerminalNode RELATIONAL_LESS_THAN() {
            return getToken(CmmParser.RELATIONAL_LESS_THAN, 0);
        }

        public TerminalNode RELATIONAL_LESS_EQUAL() {
            return getToken(CmmParser.RELATIONAL_LESS_EQUAL, 0);
        }

        public TerminalNode RELATIONAL_GREATER_THAN() {
            return getToken(CmmParser.RELATIONAL_GREATER_THAN, 0);
        }

        public TerminalNode RELATIONAL_GREATER_EQUAL() {
            return getToken(CmmParser.RELATIONAL_GREATER_EQUAL, 0);
        }

        public TerminalNode RELATIONAL_EQUAL() {
            return getToken(CmmParser.RELATIONAL_EQUAL, 0);
        }

        public TerminalNode RELATIONAL_NOT_EQUAL() {
            return getToken(CmmParser.RELATIONAL_NOT_EQUAL, 0);
        }

        public TerminalNode LOGICAL_AND() {
            return getToken(CmmParser.LOGICAL_AND, 0);
        }

        public TerminalNode LOGICAL_OR() {
            return getToken(CmmParser.LOGICAL_OR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignableExpressionContext extends ParserRuleContext {
        public Expression ast;
        public AssignableExpressionContext e;
        public Token ID;
        public Token lb;
        public ExpressionContext ai;
        public Token rb;

        public AssignableExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public AssignableExpressionContext assignableExpression() {
            return getRuleContext(AssignableExpressionContext.class, 0);
        }

        public TerminalNode LEFT_BRACKET() {
            return getToken(CmmParser.LEFT_BRACKET, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode RIGHT_BRACKET() {
            return getToken(CmmParser.RIGHT_BRACKET, 0);
        }

        public TerminalNode DOT() {
            return getToken(CmmParser.DOT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignableExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterAssignableExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitAssignableExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor)
                return ((CmmVisitor<? extends T>) visitor).visitAssignableExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExpressionListContext extends ParserRuleContext {
        public List<Expression> ast;
        public ExpressionContext expression;
        public List<ExpressionContext> exp = new ArrayList<ExpressionContext>();

        public ExpressionListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(CmmParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressionList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterExpressionList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitExpressionList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitExpressionList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignableExpressionListContext extends ParserRuleContext {
        public List<Expression> ast;
        public AssignableExpressionContext assignableExpression;
        public List<AssignableExpressionContext> exp = new ArrayList<AssignableExpressionContext>();

        public AssignableExpressionListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<AssignableExpressionContext> assignableExpression() {
            return getRuleContexts(AssignableExpressionContext.class);
        }

        public AssignableExpressionContext assignableExpression(int i) {
            return getRuleContext(AssignableExpressionContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(CmmParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignableExpressionList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterAssignableExpressionList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitAssignableExpressionList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor)
                return ((CmmVisitor<? extends T>) visitor).visitAssignableExpressionList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionInvocationContext extends ParserRuleContext {
        public Expression ast;
        public Token ID;
        public ExpressionListContext expressionList;

        public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public TerminalNode LEFT_PAREN() {
            return getToken(CmmParser.LEFT_PAREN, 0);
        }

        public TerminalNode RIGHT_PAREN() {
            return getToken(CmmParser.RIGHT_PAREN, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionInvocation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterFunctionInvocation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitFunctionInvocation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitFunctionInvocation(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VoidableTypeContext extends ParserRuleContext {
        public Type ast;
        public BuiltInTypeContext baseType;
        public Token void_;

        public VoidableTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BuiltInTypeContext builtInType() {
            return getRuleContext(BuiltInTypeContext.class, 0);
        }

        public TerminalNode VOID() {
            return getToken(CmmParser.VOID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_voidableType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterVoidableType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitVoidableType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitVoidableType(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArrayableTypeContext extends ParserRuleContext {
        public Type ast;
        public ArrayableTypeContext type;
        public BuiltInTypeContext baseType;
        public Token struct;
        public RecordFieldListContext recordFieldList;
        public Token INT_CONSTANT;

        public ArrayableTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BuiltInTypeContext builtInType() {
            return getRuleContext(BuiltInTypeContext.class, 0);
        }

        public TerminalNode LEFT_BRACE() {
            return getToken(CmmParser.LEFT_BRACE, 0);
        }

        public RecordFieldListContext recordFieldList() {
            return getRuleContext(RecordFieldListContext.class, 0);
        }

        public TerminalNode RIGHT_BRACE() {
            return getToken(CmmParser.RIGHT_BRACE, 0);
        }

        public TerminalNode STRUCT() {
            return getToken(CmmParser.STRUCT, 0);
        }

        public TerminalNode LEFT_BRACKET() {
            return getToken(CmmParser.LEFT_BRACKET, 0);
        }

        public TerminalNode INT_CONSTANT() {
            return getToken(CmmParser.INT_CONSTANT, 0);
        }

        public TerminalNode RIGHT_BRACKET() {
            return getToken(CmmParser.RIGHT_BRACKET, 0);
        }

        public ArrayableTypeContext arrayableType() {
            return getRuleContext(ArrayableTypeContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayableType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterArrayableType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitArrayableType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitArrayableType(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BuiltInTypeContext extends ParserRuleContext {
        public Type ast;
        public Token int_;
        public Token double_;
        public Token char_;

        public BuiltInTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(CmmParser.INT, 0);
        }

        public TerminalNode DOUBLE() {
            return getToken(CmmParser.DOUBLE, 0);
        }

        public TerminalNode CHAR() {
            return getToken(CmmParser.CHAR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_builtInType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).enterBuiltInType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CmmListener) ((CmmListener) listener).exitBuiltInType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CmmVisitor) return ((CmmVisitor<? extends T>) visitor).visitBuiltInType(this);
            else return visitor.visitChildren(this);
        }
    }
}