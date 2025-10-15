// Generated from /Users/masters/Projects/lab05/src/parser/Cmm.g4 by ANTLR 4.13.2
package parser;

	import ast.*;
	import ast.definitions.*;
	import ast.expressions.*;
	import ast.locatable.*;
	import ast.statements.*;
	import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITE_SPACES=1, SINGLE_LINE_COMMENT=2, MULTI_LINE_COMMENT=3, SEMICOLON=4, 
		LEFT_PAREN=5, RIGHT_PAREN=6, LEFT_BRACE=7, RIGHT_BRACE=8, LEFT_BRACKET=9, 
		RIGHT_BRACKET=10, DOT=11, COMMA=12, ASSIGN=13, PLUS=14, MINUS=15, MULTIPLY=16, 
		DIVIDE=17, MODULO=18, RELATIONAL_EQUAL=19, RELATIONAL_NOT_EQUAL=20, RELATIONAL_LESS_THAN=21, 
		RELATIONAL_LESS_EQUAL=22, RELATIONAL_GREATER_THAN=23, RELATIONAL_GREATER_EQUAL=24, 
		LOGICAL_AND=25, LOGICAL_OR=26, LOGICAL_NOT=27, READ=28, WRITE=29, RETURN=30, 
		IF=31, ELSE=32, WHILE=33, STRUCT=34, INT=35, DOUBLE=36, CHAR=37, VOID=38, 
		MAIN=39, ID=40, INT_CONSTANT=41, DOUBLE_CONSTANT=42, CHAR_CONSTANT=43;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_procedureInvocation = 2, RULE_varDefinition = 3, 
		RULE_arrayIndex = 4, RULE_functionDefinition = 5, RULE_block = 6, RULE_expression = 7, 
		RULE_functionInvocation = 8, RULE_type = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "procedureInvocation", "varDefinition", "arrayIndex", 
			"functionDefinition", "block", "expression", "functionInvocation", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'.'", "','", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", 
			"'<'", "'<='", "'>'", "'>='", "'&&'", "'||'", "'!'", "'read'", "'write'", 
			"'return'", "'if'", "'else'", "'while'", "'struct'", "'int'", "'double'", 
			"'char'", "'void'", "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public BlockContext block;
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(CmmParser.MAIN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(20);
					((ProgramContext)_localctx).statement = statement();
					((ProgramContext)_localctx).stmts.add(((ProgramContext)_localctx).statement);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(23); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(25);
			match(VOID);
			setState(26);
			match(MAIN);
			setState(27);
			match(LEFT_PAREN);
			setState(28);
			match(RIGHT_PAREN);
			setState(29);
			((ProgramContext)_localctx).block = block();
			setState(30);
			match(EOF);

			        List<Statement> stmts = new ArrayList<>();
			        if (((ProgramContext)_localctx).stmts != null) ((ProgramContext)_localctx).stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
			        ((ProgramContext)_localctx).ast =  new Program(stmts, ((ProgramContext)_localctx).block.ast);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public Token read;
		public ExpressionContext expression;
		public List<ExpressionContext> exprs = new ArrayList<ExpressionContext>();
		public Token write;
		public Token return_;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Token if_;
		public StatementContext statement;
		public List<StatementContext> thenSt = new ArrayList<StatementContext>();
		public List<StatementContext> elseSt = new ArrayList<StatementContext>();
		public Token while_;
		public StatementContext stmt;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public ProcedureInvocationContext procedureInvocation;
		public VarDefinitionContext varDefinition;
		public FunctionDefinitionContext functionDefinition;
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public TerminalNode READ() { return getToken(CmmParser.READ, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public TerminalNode WRITE() { return getToken(CmmParser.WRITE, 0); }
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public List<TerminalNode> LEFT_BRACE() { return getTokens(CmmParser.LEFT_BRACE); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(CmmParser.LEFT_BRACE, i);
		}
		public List<TerminalNode> RIGHT_BRACE() { return getTokens(CmmParser.RIGHT_BRACE); }
		public TerminalNode RIGHT_BRACE(int i) {
			return getToken(CmmParser.RIGHT_BRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ProcedureInvocationContext procedureInvocation() {
			return getRuleContext(ProcedureInvocationContext.class,0);
		}
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				((StatementContext)_localctx).read = match(READ);
				setState(34);
				((StatementContext)_localctx).expression = expression(0);
				((StatementContext)_localctx).exprs.add(((StatementContext)_localctx).expression);
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(35);
						match(COMMA);
						setState(36);
						((StatementContext)_localctx).expression = expression(0);
						((StatementContext)_localctx).exprs.add(((StatementContext)_localctx).expression);
						}
						} 
					}
					setState(41);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(42);
				match(SEMICOLON);

				        List<Expression> exprs = new ArrayList<>();
				        if (((StatementContext)_localctx).exprs != null) ((StatementContext)_localctx).exprs.forEach(e -> {if (e != null) exprs.add(e.ast); });
				        ((StatementContext)_localctx).ast =  new Read(((StatementContext)_localctx).read.getLine(), ((StatementContext)_localctx).read.getCharPositionInLine()+1, exprs);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((StatementContext)_localctx).write = match(WRITE);
				setState(46);
				((StatementContext)_localctx).expression = expression(0);
				((StatementContext)_localctx).exprs.add(((StatementContext)_localctx).expression);
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(47);
						match(COMMA);
						setState(48);
						((StatementContext)_localctx).expression = expression(0);
						((StatementContext)_localctx).exprs.add(((StatementContext)_localctx).expression);
						}
						} 
					}
					setState(53);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(54);
				match(SEMICOLON);

				        List<Expression> exprs = new ArrayList<>();
				        if (((StatementContext)_localctx).exprs != null) ((StatementContext)_localctx).exprs.forEach(e -> {if (e != null) exprs.add(e.ast); });
				        ((StatementContext)_localctx).ast =  new Write(((StatementContext)_localctx).write.getLine(), ((StatementContext)_localctx).write.getCharPositionInLine()+1, exprs);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				((StatementContext)_localctx).return_ = match(RETURN);
				setState(58);
				((StatementContext)_localctx).expression = expression(0);
				setState(59);
				match(SEMICOLON);
				 ((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).return_.getLine(), ((StatementContext)_localctx).return_.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				((StatementContext)_localctx).e1 = expression(0);
				setState(63);
				match(ASSIGN);
				setState(64);
				((StatementContext)_localctx).e2 = expression(0);
				setState(65);
				match(SEMICOLON);
				 ((StatementContext)_localctx).ast =  new Assignment((((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getLine(), (((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				((StatementContext)_localctx).if_ = match(IF);
				setState(69);
				match(LEFT_PAREN);
				setState(70);
				((StatementContext)_localctx).expression = expression(0);
				setState(71);
				match(RIGHT_PAREN);
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_PAREN:
				case MINUS:
				case LOGICAL_NOT:
				case READ:
				case WRITE:
				case RETURN:
				case IF:
				case WHILE:
				case STRUCT:
				case INT:
				case DOUBLE:
				case CHAR:
				case VOID:
				case ID:
				case INT_CONSTANT:
				case DOUBLE_CONSTANT:
				case CHAR_CONSTANT:
					{
					setState(72);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).thenSt.add(((StatementContext)_localctx).statement);
					}
					break;
				case LEFT_BRACE:
					{
					setState(73);
					match(LEFT_BRACE);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17038001078304L) != 0)) {
						{
						{
						setState(74);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).thenSt.add(((StatementContext)_localctx).statement);
						}
						}
						setState(79);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(80);
					match(RIGHT_BRACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(83);
					match(ELSE);
					setState(93);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LEFT_PAREN:
					case MINUS:
					case LOGICAL_NOT:
					case READ:
					case WRITE:
					case RETURN:
					case IF:
					case WHILE:
					case STRUCT:
					case INT:
					case DOUBLE:
					case CHAR:
					case VOID:
					case ID:
					case INT_CONSTANT:
					case DOUBLE_CONSTANT:
					case CHAR_CONSTANT:
						{
						setState(84);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).elseSt.add(((StatementContext)_localctx).statement);
						}
						break;
					case LEFT_BRACE:
						{
						setState(85);
						match(LEFT_BRACE);
						setState(89);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17038001078304L) != 0)) {
							{
							{
							setState(86);
							((StatementContext)_localctx).statement = statement();
							((StatementContext)_localctx).elseSt.add(((StatementContext)_localctx).statement);
							}
							}
							setState(91);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(92);
						match(RIGHT_BRACE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}

				        List<Statement> elseStmts = new ArrayList<>();
				        if (((StatementContext)_localctx).elseSt != null) ((StatementContext)_localctx).elseSt.forEach(s -> {if (s != null) elseStmts.add(s.ast); });
				        List<Statement> thenStmts = new ArrayList<>();
				        if (((StatementContext)_localctx).thenSt != null) ((StatementContext)_localctx).thenSt.forEach(s -> {if (s != null) thenStmts.add(s.ast); });
				        ((StatementContext)_localctx).ast =  new IfElse(((StatementContext)_localctx).if_.getLine(), ((StatementContext)_localctx).if_.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast, thenStmts, elseStmts);
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				((StatementContext)_localctx).while_ = match(WHILE);
				setState(100);
				match(LEFT_PAREN);
				setState(101);
				((StatementContext)_localctx).expression = expression(0);
				setState(102);
				match(RIGHT_PAREN);
				setState(112);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_PAREN:
				case MINUS:
				case LOGICAL_NOT:
				case READ:
				case WRITE:
				case RETURN:
				case IF:
				case WHILE:
				case STRUCT:
				case INT:
				case DOUBLE:
				case CHAR:
				case VOID:
				case ID:
				case INT_CONSTANT:
				case DOUBLE_CONSTANT:
				case CHAR_CONSTANT:
					{
					setState(103);
					((StatementContext)_localctx).stmt = statement();
					}
					break;
				case LEFT_BRACE:
					{
					setState(104);
					match(LEFT_BRACE);
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17038001078304L) != 0)) {
						{
						{
						setState(105);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).stmts.add(((StatementContext)_localctx).statement);
						}
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(111);
					match(RIGHT_BRACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

				        List<Statement> stmts = new ArrayList<>();
				        if (((StatementContext)_localctx).stmts != null) ((StatementContext)_localctx).stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
				        else stmts.add(((StatementContext)_localctx).stmt.ast);
				        ((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).while_.getLine(), ((StatementContext)_localctx).while_.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast, stmts);
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116);
				((StatementContext)_localctx).procedureInvocation = procedureInvocation();
				setState(117);
				match(SEMICOLON);
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).procedureInvocation.ast; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(120);
				((StatementContext)_localctx).varDefinition = varDefinition();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).varDefinition.ast; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(123);
				((StatementContext)_localctx).functionDefinition = functionDefinition();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).functionDefinition.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureInvocationContext extends ParserRuleContext {
		public Statement ast;
		public Token ID;
		public ExpressionContext expression;
		public List<ExpressionContext> exp = new ArrayList<ExpressionContext>();
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public ProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProcedureInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProcedureInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProcedureInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureInvocationContext procedureInvocation() throws RecognitionException {
		ProcedureInvocationContext _localctx = new ProcedureInvocationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_procedureInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((ProcedureInvocationContext)_localctx).ID = match(ID);
			setState(129);
			match(LEFT_PAREN);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492808667168L) != 0)) {
				{
				setState(130);
				((ProcedureInvocationContext)_localctx).expression = expression(0);
				((ProcedureInvocationContext)_localctx).exp.add(((ProcedureInvocationContext)_localctx).expression);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(131);
					match(COMMA);
					setState(132);
					((ProcedureInvocationContext)_localctx).expression = expression(0);
					((ProcedureInvocationContext)_localctx).exp.add(((ProcedureInvocationContext)_localctx).expression);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(140);
			match(RIGHT_PAREN);

			        List<Expression> exp = new ArrayList<>();
			        if (((ProcedureInvocationContext)_localctx).exp != null) ((ProcedureInvocationContext)_localctx).exp.forEach(e -> {if (e != null) exp.add(e.ast); });
			        ((ProcedureInvocationContext)_localctx).ast =  new ProcedureInvocation(((ProcedureInvocationContext)_localctx).ID.getLine(), ((ProcedureInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((ProcedureInvocationContext)_localctx).ID!=null?((ProcedureInvocationContext)_localctx).ID.getText():null), exp);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public VariableDefinition ast;
		public TypeContext t;
		public Token ID;
		public List<Token> ids = new ArrayList<Token>();
		public Token struct;
		public VarDefinitionContext varDefinition;
		public List<VarDefinitionContext> varDef = new ArrayList<VarDefinitionContext>();
		public ArrayIndexContext arrayIndex;
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(CmmParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CmmParser.RIGHT_BRACE, 0); }
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public ArrayIndexContext arrayIndex() {
			return getRuleContext(ArrayIndexContext.class,0);
		}
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVarDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVarDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVarDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDefinition);
		int _la;
		try {
			int _alt;
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				((VarDefinitionContext)_localctx).t = type();
				setState(144);
				((VarDefinitionContext)_localctx).ID = match(ID);
				((VarDefinitionContext)_localctx).ids.add(((VarDefinitionContext)_localctx).ID);
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(145);
						match(COMMA);
						setState(146);
						((VarDefinitionContext)_localctx).ID = match(ID);
						((VarDefinitionContext)_localctx).ids.add(((VarDefinitionContext)_localctx).ID);
						}
						} 
					}
					setState(151);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(152);
				match(SEMICOLON);

				        List<String> ids = new ArrayList<>();
				        if (((VarDefinitionContext)_localctx).ids != null) ((VarDefinitionContext)_localctx).ids.forEach(id -> {if (id != null) ids.add(id.getText()); });
				        ((VarDefinitionContext)_localctx).ast =  new VariableDefinition((((VarDefinitionContext)_localctx).t!=null?(((VarDefinitionContext)_localctx).t.start):null).getLine(), (((VarDefinitionContext)_localctx).t!=null?(((VarDefinitionContext)_localctx).t.start):null).getCharPositionInLine()+1, ((VarDefinitionContext)_localctx).t.ast, ids);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((VarDefinitionContext)_localctx).struct = match(STRUCT);
				setState(156);
				match(LEFT_BRACE);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 532575944704L) != 0)) {
					{
					{
					setState(157);
					((VarDefinitionContext)_localctx).varDefinition = varDefinition();
					((VarDefinitionContext)_localctx).varDef.add(((VarDefinitionContext)_localctx).varDefinition);
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(163);
				match(RIGHT_BRACE);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACKET) {
					{
					setState(164);
					((VarDefinitionContext)_localctx).arrayIndex = arrayIndex();
					}
				}

				setState(167);
				((VarDefinitionContext)_localctx).ID = match(ID);
				setState(168);
				match(SEMICOLON);

				        int line = _localctx.getStart().getLine();
				        int col = _localctx.getStart().getCharPositionInLine()+1;
				        Type type;
				        if (((VarDefinitionContext)_localctx).arrayIndex != null) type = new StructType(line, col, ((VarDefinitionContext)_localctx).arrayIndex.ast);
				        else type = new StructType(line, col, null);
				        List<VariableDefinition> varDefs = new ArrayList<>();
				        if (((VarDefinitionContext)_localctx).varDef != null) ((VarDefinitionContext)_localctx).varDef.forEach(vd -> {if (vd != null) varDefs.add(vd.ast); });
				        ((VarDefinitionContext)_localctx).ast =  new StructDefinition(line, col, type, List.of((((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null)), varDefs);
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayIndexContext extends ParserRuleContext {
		public Expression ast;
		public Token lb;
		public ExpressionContext expression;
		public ArrayIndexContext ai;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CmmParser.RIGHT_BRACKET, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(CmmParser.LEFT_BRACKET, 0); }
		public ArrayIndexContext arrayIndex() {
			return getRuleContext(ArrayIndexContext.class,0);
		}
		public ArrayIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterArrayIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitArrayIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitArrayIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayIndexContext arrayIndex() throws RecognitionException {
		ArrayIndexContext _localctx = new ArrayIndexContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((ArrayIndexContext)_localctx).lb = match(LEFT_BRACKET);
			setState(173);
			((ArrayIndexContext)_localctx).expression = expression(0);
			setState(174);
			match(RIGHT_BRACKET);
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(175);
				((ArrayIndexContext)_localctx).ai = arrayIndex();
				}
				break;
			}
			 ((ArrayIndexContext)_localctx).ast =  new ArrayIndex(((ArrayIndexContext)_localctx).lb.getLine(), ((ArrayIndexContext)_localctx).lb.getCharPositionInLine()+1, ((ArrayIndexContext)_localctx).expression.ast, (((ArrayIndexContext)_localctx).ai != null) ? ((ArrayIndexContext)_localctx).ai.ast : null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public TypeContext funcType;
		public Token id;
		public TypeContext type;
		public List<TypeContext> paramType = new ArrayList<TypeContext>();
		public Token ID;
		public List<Token> paramId = new ArrayList<Token>();
		public BlockContext block;
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((FunctionDefinitionContext)_localctx).funcType = type();
			setState(181);
			((FunctionDefinitionContext)_localctx).id = match(ID);
			setState(182);
			match(LEFT_PAREN);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 532575944704L) != 0)) {
				{
				{
				setState(183);
				((FunctionDefinitionContext)_localctx).type = type();
				((FunctionDefinitionContext)_localctx).paramType.add(((FunctionDefinitionContext)_localctx).type);
				}
				setState(184);
				((FunctionDefinitionContext)_localctx).ID = match(ID);
				((FunctionDefinitionContext)_localctx).paramId.add(((FunctionDefinitionContext)_localctx).ID);
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(185);
					match(COMMA);
					{
					setState(186);
					((FunctionDefinitionContext)_localctx).type = type();
					((FunctionDefinitionContext)_localctx).paramType.add(((FunctionDefinitionContext)_localctx).type);
					}
					setState(187);
					((FunctionDefinitionContext)_localctx).ID = match(ID);
					((FunctionDefinitionContext)_localctx).paramId.add(((FunctionDefinitionContext)_localctx).ID);
					}
					}
					setState(191); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
			}

			setState(195);
			match(RIGHT_PAREN);
			setState(196);
			((FunctionDefinitionContext)_localctx).block = block();

			        List<VariableDefinition> paramType = new ArrayList<>();
			        if (((FunctionDefinitionContext)_localctx).paramType != null) {
			            for (int i = 0; i < ((FunctionDefinitionContext)_localctx).paramType.size(); i++) {
			                paramType.add(new VariableDefinition(((FunctionDefinitionContext)_localctx).paramType.get(i).start.getLine(), ((FunctionDefinitionContext)_localctx).paramType.get(i).start.getCharPositionInLine()+1, ((FunctionDefinitionContext)_localctx).paramType.get(i).ast, List.of(((FunctionDefinitionContext)_localctx).paramId.get(i).getText())));
			            }
			        }
			        ((FunctionDefinitionContext)_localctx).ast =  new FunctionDefinition((((FunctionDefinitionContext)_localctx).funcType!=null?(((FunctionDefinitionContext)_localctx).funcType.start):null).getLine(), (((FunctionDefinitionContext)_localctx).funcType!=null?(((FunctionDefinitionContext)_localctx).funcType.start):null).getCharPositionInLine()+1, ((FunctionDefinitionContext)_localctx).funcType.ast, (((FunctionDefinitionContext)_localctx).id!=null?((FunctionDefinitionContext)_localctx).id.getText():null), paramType, ((FunctionDefinitionContext)_localctx).block.ast);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public TerminalNode LEFT_BRACE() { return getToken(CmmParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CmmParser.RIGHT_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(LEFT_BRACE);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17038001078304L) != 0)) {
				{
				{
				setState(200);
				((BlockContext)_localctx).statement = statement();
				((BlockContext)_localctx).stmts.add(((BlockContext)_localctx).statement);
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(RIGHT_BRACE);

			        List<Statement> stmts = new ArrayList<>();
			        if (((BlockContext)_localctx).stmts != null) ((BlockContext)_localctx).stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
			        ((BlockContext)_localctx).ast =  stmts;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e;
		public ExpressionContext e1;
		public Token lp;
		public TypeContext castType;
		public ExpressionContext expression;
		public Token min;
		public Token logNot;
		public FunctionInvocationContext functionInvocation;
		public Token ID;
		public Token INT_CONSTANT;
		public Token DOUBLE_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token op;
		public ExpressionContext e2;
		public ArrayIndexContext ai;
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public TerminalNode LOGICAL_NOT() { return getToken(CmmParser.LOGICAL_NOT, 0); }
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode DOUBLE_CONSTANT() { return getToken(CmmParser.DOUBLE_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode PLUS() { return getToken(CmmParser.PLUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(CmmParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(CmmParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(CmmParser.MODULO, 0); }
		public TerminalNode RELATIONAL_LESS_THAN() { return getToken(CmmParser.RELATIONAL_LESS_THAN, 0); }
		public TerminalNode RELATIONAL_LESS_EQUAL() { return getToken(CmmParser.RELATIONAL_LESS_EQUAL, 0); }
		public TerminalNode RELATIONAL_GREATER_THAN() { return getToken(CmmParser.RELATIONAL_GREATER_THAN, 0); }
		public TerminalNode RELATIONAL_GREATER_EQUAL() { return getToken(CmmParser.RELATIONAL_GREATER_EQUAL, 0); }
		public TerminalNode RELATIONAL_EQUAL() { return getToken(CmmParser.RELATIONAL_EQUAL, 0); }
		public TerminalNode RELATIONAL_NOT_EQUAL() { return getToken(CmmParser.RELATIONAL_NOT_EQUAL, 0); }
		public TerminalNode LOGICAL_AND() { return getToken(CmmParser.LOGICAL_AND, 0); }
		public TerminalNode LOGICAL_OR() { return getToken(CmmParser.LOGICAL_OR, 0); }
		public ArrayIndexContext arrayIndex() {
			return getRuleContext(ArrayIndexContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(210);
				((ExpressionContext)_localctx).lp = match(LEFT_PAREN);
				setState(211);
				((ExpressionContext)_localctx).castType = type();
				setState(212);
				match(RIGHT_PAREN);
				setState(213);
				((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(16);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).lp.getLine(), ((ExpressionContext)_localctx).lp.getCharPositionInLine()+1, ((ExpressionContext)_localctx).castType.ast, ((ExpressionContext)_localctx).e.ast); 
				}
				break;
			case 2:
				{
				setState(216);
				((ExpressionContext)_localctx).min = match(MINUS);
				setState(217);
				((ExpressionContext)_localctx).expression = expression(14);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).min.getLine(), ((ExpressionContext)_localctx).min.getCharPositionInLine()+1, ((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 3:
				{
				setState(220);
				((ExpressionContext)_localctx).logNot = match(LOGICAL_NOT);
				setState(221);
				((ExpressionContext)_localctx).expression = expression(13);
				 ((ExpressionContext)_localctx).ast =  new LogicalNot(((ExpressionContext)_localctx).logNot.getLine(), ((ExpressionContext)_localctx).logNot.getCharPositionInLine()+1, ((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 4:
				{
				setState(224);
				((ExpressionContext)_localctx).functionInvocation = functionInvocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).functionInvocation.ast; 
				}
				break;
			case 5:
				{
				setState(227);
				((ExpressionContext)_localctx).lp = match(LEFT_PAREN);
				setState(228);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(229);
				match(RIGHT_PAREN);
				 ((ExpressionContext)_localctx).ast =  new Parenthesis(((ExpressionContext)_localctx).lp.getLine(), ((ExpressionContext)_localctx).lp.getCharPositionInLine()+1, ((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 6:
				{
				setState(232);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Id(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 7:
				{
				setState(234);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null))); 
				}
				break;
			case 8:
				{
				setState(236);
				((ExpressionContext)_localctx).DOUBLE_CONSTANT = match(DOUBLE_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).DOUBLE_CONSTANT.getLine(), ((ExpressionContext)_localctx).DOUBLE_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToDouble((((ExpressionContext)_localctx).DOUBLE_CONSTANT!=null?((ExpressionContext)_localctx).DOUBLE_CONSTANT.getText():null))); 
				}
				break;
			case 9:
				{
				setState(238);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null))); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(275);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(243);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(13);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(248);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(12);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(253);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(11);
						 ((ExpressionContext)_localctx).ast =  new Relational((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(258);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==RELATIONAL_EQUAL || _la==RELATIONAL_NOT_EQUAL) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(10);
						 ((ExpressionContext)_localctx).ast =  new Relational((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(263);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LOGICAL_AND || _la==LOGICAL_OR) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Logical((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(268);
						((ExpressionContext)_localctx).ai = arrayIndex();
						 ((ExpressionContext)_localctx).ast =  new ArrayAccess((((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getLine(), (((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast, ((ExpressionContext)_localctx).ai.ast); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(272);
						match(DOT);
						setState(273);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new StructAccess((((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getLine(), (((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionInvocationContext extends ParserRuleContext {
		public Expression ast;
		public Token ID;
		public ExpressionContext expression;
		public List<ExpressionContext> exp = new ArrayList<ExpressionContext>();
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			((FunctionInvocationContext)_localctx).ID = match(ID);
			setState(281);
			match(LEFT_PAREN);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492808667168L) != 0)) {
				{
				setState(282);
				((FunctionInvocationContext)_localctx).expression = expression(0);
				((FunctionInvocationContext)_localctx).exp.add(((FunctionInvocationContext)_localctx).expression);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(283);
					match(COMMA);
					setState(284);
					((FunctionInvocationContext)_localctx).expression = expression(0);
					((FunctionInvocationContext)_localctx).exp.add(((FunctionInvocationContext)_localctx).expression);
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(292);
			match(RIGHT_PAREN);

			        List<Expression> exp = new ArrayList<>();
			        if (((FunctionInvocationContext)_localctx).exp != null) ((FunctionInvocationContext)_localctx).exp.forEach(e -> {if (e != null) exp.add(e.ast); });
			        ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null), exp);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token int_;
		public ArrayIndexContext arrayIndex;
		public Token double_;
		public Token char_;
		public Token struct;
		public Token void_;
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public ArrayIndexContext arrayIndex() {
			return getRuleContext(ArrayIndexContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(CmmParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(CmmParser.CHAR, 0); }
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				((TypeContext)_localctx).int_ = match(INT);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACKET) {
					{
					setState(296);
					((TypeContext)_localctx).arrayIndex = arrayIndex();
					}
				}

				 ((TypeContext)_localctx).ast =  new IntType(((TypeContext)_localctx).int_.getLine(), ((TypeContext)_localctx).int_.getCharPositionInLine()+1, ((TypeContext)_localctx).arrayIndex != null ? ((TypeContext)_localctx).arrayIndex.ast : null); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				((TypeContext)_localctx).double_ = match(DOUBLE);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACKET) {
					{
					setState(301);
					((TypeContext)_localctx).arrayIndex = arrayIndex();
					}
				}

				 ((TypeContext)_localctx).ast =  new DoubleType(((TypeContext)_localctx).double_.getLine(), ((TypeContext)_localctx).double_.getCharPositionInLine()+1, ((TypeContext)_localctx).arrayIndex != null ? ((TypeContext)_localctx).arrayIndex.ast : null); 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				((TypeContext)_localctx).char_ = match(CHAR);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACKET) {
					{
					setState(306);
					((TypeContext)_localctx).arrayIndex = arrayIndex();
					}
				}

				 ((TypeContext)_localctx).ast =  new CharType(((TypeContext)_localctx).char_.getLine(), ((TypeContext)_localctx).char_.getCharPositionInLine()+1, ((TypeContext)_localctx).arrayIndex != null ? ((TypeContext)_localctx).arrayIndex.ast : null); 
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(310);
				((TypeContext)_localctx).struct = match(STRUCT);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACKET) {
					{
					setState(311);
					((TypeContext)_localctx).arrayIndex = arrayIndex();
					}
				}

				 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).struct.getLine(), ((TypeContext)_localctx).struct.getCharPositionInLine()+1, ((TypeContext)_localctx).arrayIndex != null ? ((TypeContext)_localctx).arrayIndex.ast : null); 
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(315);
				((TypeContext)_localctx).void_ = match(VOID);
				 ((TypeContext)_localctx).ast =  new VoidType(((TypeContext)_localctx).void_.getLine(), ((TypeContext)_localctx).void_.getCharPositionInLine()+1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0140\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001&\b\u0001\n\u0001\f\u0001)\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001L\b\u0001\n\u0001\f\u0001O\t\u0001\u0001"+
		"\u0001\u0003\u0001R\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001X\b\u0001\n\u0001\f\u0001[\t\u0001\u0001\u0001\u0003"+
		"\u0001^\b\u0001\u0003\u0001`\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001k\b\u0001\n\u0001\f\u0001n\t\u0001\u0001\u0001\u0003\u0001"+
		"q\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u007f\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u0086\b\u0002\n\u0002\f\u0002\u0089"+
		"\t\u0002\u0003\u0002\u008b\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0094\b\u0003"+
		"\n\u0003\f\u0003\u0097\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u009f\b\u0003\n\u0003\f\u0003"+
		"\u00a2\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a6\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00ab\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b1\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00be\b\u0005\u000b"+
		"\u0005\f\u0005\u00bf\u0003\u0005\u00c2\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u0006\u00ca\b\u0006"+
		"\n\u0006\f\u0006\u00cd\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00f1\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0114\b\u0007\n\u0007\f\u0007\u0117\t\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u011e\b\b\n\b\f\b\u0121\t\b\u0003\b\u0123\b"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u012a\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u012f\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u0134\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u0139\b\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u013e\b\t\u0001\t\u0003\'3\u0095\u0001\u000e\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0005\u0001\u0000\u000e\u000f\u0001\u0000"+
		"\u0010\u0012\u0001\u0000\u0015\u0018\u0001\u0000\u0013\u0014\u0001\u0000"+
		"\u0019\u001a\u016a\u0000\u0015\u0001\u0000\u0000\u0000\u0002~\u0001\u0000"+
		"\u0000\u0000\u0004\u0080\u0001\u0000\u0000\u0000\u0006\u00aa\u0001\u0000"+
		"\u0000\u0000\b\u00ac\u0001\u0000\u0000\u0000\n\u00b4\u0001\u0000\u0000"+
		"\u0000\f\u00c7\u0001\u0000\u0000\u0000\u000e\u00f0\u0001\u0000\u0000\u0000"+
		"\u0010\u0118\u0001\u0000\u0000\u0000\u0012\u013d\u0001\u0000\u0000\u0000"+
		"\u0014\u0016\u0003\u0002\u0001\u0000\u0015\u0014\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0005&\u0000\u0000\u001a\u001b\u0005\'\u0000\u0000\u001b"+
		"\u001c\u0005\u0005\u0000\u0000\u001c\u001d\u0005\u0006\u0000\u0000\u001d"+
		"\u001e\u0003\f\u0006\u0000\u001e\u001f\u0005\u0000\u0000\u0001\u001f "+
		"\u0006\u0000\uffff\uffff\u0000 \u0001\u0001\u0000\u0000\u0000!\"\u0005"+
		"\u001c\u0000\u0000\"\'\u0003\u000e\u0007\u0000#$\u0005\f\u0000\u0000$"+
		"&\u0003\u000e\u0007\u0000%#\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(*\u0001\u0000"+
		"\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005\u0004\u0000\u0000+,\u0006"+
		"\u0001\uffff\uffff\u0000,\u007f\u0001\u0000\u0000\u0000-.\u0005\u001d"+
		"\u0000\u0000.3\u0003\u000e\u0007\u0000/0\u0005\f\u0000\u000002\u0003\u000e"+
		"\u0007\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000034\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000067\u0005\u0004\u0000\u000078\u0006\u0001\uffff"+
		"\uffff\u00008\u007f\u0001\u0000\u0000\u00009:\u0005\u001e\u0000\u0000"+
		":;\u0003\u000e\u0007\u0000;<\u0005\u0004\u0000\u0000<=\u0006\u0001\uffff"+
		"\uffff\u0000=\u007f\u0001\u0000\u0000\u0000>?\u0003\u000e\u0007\u0000"+
		"?@\u0005\r\u0000\u0000@A\u0003\u000e\u0007\u0000AB\u0005\u0004\u0000\u0000"+
		"BC\u0006\u0001\uffff\uffff\u0000C\u007f\u0001\u0000\u0000\u0000DE\u0005"+
		"\u001f\u0000\u0000EF\u0005\u0005\u0000\u0000FG\u0003\u000e\u0007\u0000"+
		"GQ\u0005\u0006\u0000\u0000HR\u0003\u0002\u0001\u0000IM\u0005\u0007\u0000"+
		"\u0000JL\u0003\u0002\u0001\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001"+
		"\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PR\u0005\b\u0000\u0000QH\u0001"+
		"\u0000\u0000\u0000QI\u0001\u0000\u0000\u0000R_\u0001\u0000\u0000\u0000"+
		"S]\u0005 \u0000\u0000T^\u0003\u0002\u0001\u0000UY\u0005\u0007\u0000\u0000"+
		"VX\u0003\u0002\u0001\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000\\^\u0005\b\u0000\u0000]T\u0001"+
		"\u0000\u0000\u0000]U\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000"+
		"_S\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ab\u0006\u0001\uffff\uffff\u0000b\u007f\u0001\u0000\u0000\u0000"+
		"cd\u0005!\u0000\u0000de\u0005\u0005\u0000\u0000ef\u0003\u000e\u0007\u0000"+
		"fp\u0005\u0006\u0000\u0000gq\u0003\u0002\u0001\u0000hl\u0005\u0007\u0000"+
		"\u0000ik\u0003\u0002\u0001\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000"+
		"\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000oq\u0005\b\u0000\u0000pg\u0001"+
		"\u0000\u0000\u0000ph\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"rs\u0006\u0001\uffff\uffff\u0000s\u007f\u0001\u0000\u0000\u0000tu\u0003"+
		"\u0004\u0002\u0000uv\u0005\u0004\u0000\u0000vw\u0006\u0001\uffff\uffff"+
		"\u0000w\u007f\u0001\u0000\u0000\u0000xy\u0003\u0006\u0003\u0000yz\u0006"+
		"\u0001\uffff\uffff\u0000z\u007f\u0001\u0000\u0000\u0000{|\u0003\n\u0005"+
		"\u0000|}\u0006\u0001\uffff\uffff\u0000}\u007f\u0001\u0000\u0000\u0000"+
		"~!\u0001\u0000\u0000\u0000~-\u0001\u0000\u0000\u0000~9\u0001\u0000\u0000"+
		"\u0000~>\u0001\u0000\u0000\u0000~D\u0001\u0000\u0000\u0000~c\u0001\u0000"+
		"\u0000\u0000~t\u0001\u0000\u0000\u0000~x\u0001\u0000\u0000\u0000~{\u0001"+
		"\u0000\u0000\u0000\u007f\u0003\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		"(\u0000\u0000\u0081\u008a\u0005\u0005\u0000\u0000\u0082\u0087\u0003\u000e"+
		"\u0007\u0000\u0083\u0084\u0005\f\u0000\u0000\u0084\u0086\u0003\u000e\u0007"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u008a\u0082\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0006\u0000"+
		"\u0000\u008d\u008e\u0006\u0002\uffff\uffff\u0000\u008e\u0005\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0003\u0012\t\u0000\u0090\u0095\u0005(\u0000"+
		"\u0000\u0091\u0092\u0005\f\u0000\u0000\u0092\u0094\u0005(\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u0004\u0000\u0000\u0099\u009a\u0006\u0003\uffff\uffff"+
		"\u0000\u009a\u00ab\u0001\u0000\u0000\u0000\u009b\u009c\u0005\"\u0000\u0000"+
		"\u009c\u00a0\u0005\u0007\u0000\u0000\u009d\u009f\u0003\u0006\u0003\u0000"+
		"\u009e\u009d\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a5\u0005\b\u0000\u0000\u00a4\u00a6\u0003\b\u0004\u0000\u00a5"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005(\u0000\u0000\u00a8\u00a9"+
		"\u0005\u0004\u0000\u0000\u00a9\u00ab\u0006\u0003\uffff\uffff\u0000\u00aa"+
		"\u008f\u0001\u0000\u0000\u0000\u00aa\u009b\u0001\u0000\u0000\u0000\u00ab"+
		"\u0007\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\t\u0000\u0000\u00ad\u00ae"+
		"\u0003\u000e\u0007\u0000\u00ae\u00b0\u0005\n\u0000\u0000\u00af\u00b1\u0003"+
		"\b\u0004\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u0004"+
		"\uffff\uffff\u0000\u00b3\t\u0001\u0000\u0000\u0000\u00b4\u00b5\u0003\u0012"+
		"\t\u0000\u00b5\u00b6\u0005(\u0000\u0000\u00b6\u00c1\u0005\u0005\u0000"+
		"\u0000\u00b7\u00b8\u0003\u0012\t\u0000\u00b8\u00bd\u0005(\u0000\u0000"+
		"\u00b9\u00ba\u0005\f\u0000\u0000\u00ba\u00bb\u0003\u0012\t\u0000\u00bb"+
		"\u00bc\u0005(\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00b9"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c1\u00b7\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0005\u0006\u0000\u0000\u00c4\u00c5\u0003\f\u0006\u0000\u00c5\u00c6\u0006"+
		"\u0005\uffff\uffff\u0000\u00c6\u000b\u0001\u0000\u0000\u0000\u00c7\u00cb"+
		"\u0005\u0007\u0000\u0000\u00c8\u00ca\u0003\u0002\u0001\u0000\u00c9\u00c8"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0005\b\u0000\u0000\u00cf\u00d0\u0006\u0006\uffff\uffff\u0000\u00d0\r"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0006\u0007\uffff\uffff\u0000\u00d2"+
		"\u00d3\u0005\u0005\u0000\u0000\u00d3\u00d4\u0003\u0012\t\u0000\u00d4\u00d5"+
		"\u0005\u0006\u0000\u0000\u00d5\u00d6\u0003\u000e\u0007\u0010\u00d6\u00d7"+
		"\u0006\u0007\uffff\uffff\u0000\u00d7\u00f1\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0005\u000f\u0000\u0000\u00d9\u00da\u0003\u000e\u0007\u000e\u00da"+
		"\u00db\u0006\u0007\uffff\uffff\u0000\u00db\u00f1\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0005\u001b\u0000\u0000\u00dd\u00de\u0003\u000e\u0007\r\u00de"+
		"\u00df\u0006\u0007\uffff\uffff\u0000\u00df\u00f1\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e1\u0003\u0010\b\u0000\u00e1\u00e2\u0006\u0007\uffff\uffff\u0000"+
		"\u00e2\u00f1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0005\u0000\u0000"+
		"\u00e4\u00e5\u0003\u000e\u0007\u0000\u00e5\u00e6\u0005\u0006\u0000\u0000"+
		"\u00e6\u00e7\u0006\u0007\uffff\uffff\u0000\u00e7\u00f1\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0005(\u0000\u0000\u00e9\u00f1\u0006\u0007\uffff\uffff"+
		"\u0000\u00ea\u00eb\u0005)\u0000\u0000\u00eb\u00f1\u0006\u0007\uffff\uffff"+
		"\u0000\u00ec\u00ed\u0005*\u0000\u0000\u00ed\u00f1\u0006\u0007\uffff\uffff"+
		"\u0000\u00ee\u00ef\u0005+\u0000\u0000\u00ef\u00f1\u0006\u0007\uffff\uffff"+
		"\u0000\u00f0\u00d1\u0001\u0000\u0000\u0000\u00f0\u00d8\u0001\u0000\u0000"+
		"\u0000\u00f0\u00dc\u0001\u0000\u0000\u0000\u00f0\u00e0\u0001\u0000\u0000"+
		"\u0000\u00f0\u00e3\u0001\u0000\u0000\u0000\u00f0\u00e8\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ea\u0001\u0000\u0000\u0000\u00f0\u00ec\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u0115\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\n\f\u0000\u0000\u00f3\u00f4\u0007\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0003\u000e\u0007\r\u00f5\u00f6\u0006\u0007\uffff\uffff\u0000"+
		"\u00f6\u0114\u0001\u0000\u0000\u0000\u00f7\u00f8\n\u000b\u0000\u0000\u00f8"+
		"\u00f9\u0007\u0001\u0000\u0000\u00f9\u00fa\u0003\u000e\u0007\f\u00fa\u00fb"+
		"\u0006\u0007\uffff\uffff\u0000\u00fb\u0114\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\n\n\u0000\u0000\u00fd\u00fe\u0007\u0002\u0000\u0000\u00fe\u00ff"+
		"\u0003\u000e\u0007\u000b\u00ff\u0100\u0006\u0007\uffff\uffff\u0000\u0100"+
		"\u0114\u0001\u0000\u0000\u0000\u0101\u0102\n\t\u0000\u0000\u0102\u0103"+
		"\u0007\u0003\u0000\u0000\u0103\u0104\u0003\u000e\u0007\n\u0104\u0105\u0006"+
		"\u0007\uffff\uffff\u0000\u0105\u0114\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\n\b\u0000\u0000\u0107\u0108\u0007\u0004\u0000\u0000\u0108\u0109\u0003"+
		"\u000e\u0007\t\u0109\u010a\u0006\u0007\uffff\uffff\u0000\u010a\u0114\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\n\u000f\u0000\u0000\u010c\u010d\u0003\b"+
		"\u0004\u0000\u010d\u010e\u0006\u0007\uffff\uffff\u0000\u010e\u0114\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\n\u0005\u0000\u0000\u0110\u0111\u0005\u000b"+
		"\u0000\u0000\u0111\u0112\u0005(\u0000\u0000\u0112\u0114\u0006\u0007\uffff"+
		"\uffff\u0000\u0113\u00f2\u0001\u0000\u0000\u0000\u0113\u00f7\u0001\u0000"+
		"\u0000\u0000\u0113\u00fc\u0001\u0000\u0000\u0000\u0113\u0101\u0001\u0000"+
		"\u0000\u0000\u0113\u0106\u0001\u0000\u0000\u0000\u0113\u010b\u0001\u0000"+
		"\u0000\u0000\u0113\u010f\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000"+
		"\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u000f\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0118\u0119\u0005(\u0000\u0000\u0119\u0122\u0005\u0005\u0000"+
		"\u0000\u011a\u011f\u0003\u000e\u0007\u0000\u011b\u011c\u0005\f\u0000\u0000"+
		"\u011c\u011e\u0003\u000e\u0007\u0000\u011d\u011b\u0001\u0000\u0000\u0000"+
		"\u011e\u0121\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000"+
		"\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000\u0000"+
		"\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u011a\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0005\u0006\u0000\u0000\u0125\u0126\u0006\b\uffff\uffff\u0000"+
		"\u0126\u0011\u0001\u0000\u0000\u0000\u0127\u0129\u0005#\u0000\u0000\u0128"+
		"\u012a\u0003\b\u0004\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u0129\u012a"+
		"\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u013e"+
		"\u0006\t\uffff\uffff\u0000\u012c\u012e\u0005$\u0000\u0000\u012d\u012f"+
		"\u0003\b\u0004\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u013e\u0006"+
		"\t\uffff\uffff\u0000\u0131\u0133\u0005%\u0000\u0000\u0132\u0134\u0003"+
		"\b\u0004\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u013e\u0006\t\uffff"+
		"\uffff\u0000\u0136\u0138\u0005\"\u0000\u0000\u0137\u0139\u0003\b\u0004"+
		"\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013e\u0006\t\uffff\uffff"+
		"\u0000\u013b\u013c\u0005&\u0000\u0000\u013c\u013e\u0006\t\uffff\uffff"+
		"\u0000\u013d\u0127\u0001\u0000\u0000\u0000\u013d\u012c\u0001\u0000\u0000"+
		"\u0000\u013d\u0131\u0001\u0000\u0000\u0000\u013d\u0136\u0001\u0000\u0000"+
		"\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u0013\u0001\u0000\u0000"+
		"\u0000\u001f\u0017\'3MQY]_lp~\u0087\u008a\u0095\u00a0\u00a5\u00aa\u00b0"+
		"\u00bf\u00c1\u00cb\u00f0\u0113\u0115\u011f\u0122\u0129\u012e\u0133\u0138"+
		"\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}