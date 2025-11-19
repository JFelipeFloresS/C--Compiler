// Generated from src/parser/Cmm.g4 by ANTLR 4.13.2
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
		RULE_program = 0, RULE_statement = 1, RULE_procedureInvocation = 2, RULE_definition = 3, 
		RULE_varDefinition = 4, RULE_varDefList = 5, RULE_functionDefinition = 6, 
		RULE_paramsList = 7, RULE_paramDef = 8, RULE_recordFieldList = 9, RULE_recordField = 10, 
		RULE_stmtBlock = 11, RULE_stmtList = 12, RULE_expression = 13, RULE_logicalOrExpression = 14, 
		RULE_logicalAndExpression = 15, RULE_relationalExpression = 16, RULE_additiveExpression = 17, 
		RULE_multiplicativeExpression = 18, RULE_unaryExpression = 19, RULE_primaryExpression = 20, 
		RULE_assignableExpression = 21, RULE_expressionList = 22, RULE_assignableExpressionList = 23, 
		RULE_functionInvocation = 24, RULE_voidableType = 25, RULE_arrayableType = 26, 
		RULE_builtInType = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "procedureInvocation", "definition", "varDefinition", 
			"varDefList", "functionDefinition", "paramsList", "paramDef", "recordFieldList", 
			"recordField", "stmtBlock", "stmtList", "expression", "logicalOrExpression", 
			"logicalAndExpression", "relationalExpression", "additiveExpression", 
			"multiplicativeExpression", "unaryExpression", "primaryExpression", "assignableExpression", 
			"expressionList", "assignableExpressionList", "functionInvocation", "voidableType", 
			"arrayableType", "builtInType"
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
		public DefinitionContext definition;
		public List<DefinitionContext> defs = new ArrayList<DefinitionContext>();
		public Token VOID;
		public Token main;
		public VarDefListContext varDefList;
		public StmtListContext stmtList;
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(CmmParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CmmParser.RIGHT_BRACE, 0); }
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public TerminalNode MAIN() { return getToken(CmmParser.MAIN, 0); }
		public VarDefListContext varDefList() {
			return getRuleContext(VarDefListContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(56);
					((ProgramContext)_localctx).definition = definition();
					((ProgramContext)_localctx).defs.add(((ProgramContext)_localctx).definition);
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(62);
			((ProgramContext)_localctx).VOID = match(VOID);
			setState(63);
			((ProgramContext)_localctx).main = match(MAIN);
			setState(64);
			match(LEFT_PAREN);
			setState(65);
			match(RIGHT_PAREN);
			setState(66);
			match(LEFT_BRACE);
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(67);
				((ProgramContext)_localctx).varDefList = varDefList();
				}
				break;
			}
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(70);
				((ProgramContext)_localctx).stmtList = stmtList();
				}
				break;
			}
			setState(73);
			match(RIGHT_BRACE);
			setState(74);
			match(EOF);

			        List<Definition> defs = new ArrayList<>();
			        if (((ProgramContext)_localctx).defs != null) ((ProgramContext)_localctx).defs.forEach(s -> {if (s != null) defs.add(s.ast); });
			        Type mainFuncType = new FunctionType(((ProgramContext)_localctx).VOID.getLine(), ((ProgramContext)_localctx).VOID.getCharPositionInLine()+1, new VoidType(((ProgramContext)_localctx).VOID.getLine(), ((ProgramContext)_localctx).VOID.getCharPositionInLine()+1), new ArrayList<>());
			        FunctionDefinition mainFunction = new FunctionDefinition(((ProgramContext)_localctx).VOID.getLine(), ((ProgramContext)_localctx).VOID.getCharPositionInLine()+1, mainFuncType, new Id(((ProgramContext)_localctx).main.getLine(), ((ProgramContext)_localctx).main.getCharPositionInLine()+1, ((ProgramContext)_localctx).main.getText()), ((ProgramContext)_localctx).varDefList != null ? ((ProgramContext)_localctx).varDefList.ast : new ArrayList<VariableDefinition>(), ((ProgramContext)_localctx).stmtList != null ? ((ProgramContext)_localctx).stmtList.ast : new ArrayList<Statement>());
			        defs.add(mainFunction);
			        ((ProgramContext)_localctx).ast =  new Program(defs);
			    
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
		public AssignableExpressionListContext assignableExpressionList() {
			return getRuleContext(AssignableExpressionListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public TerminalNode READ() { return getToken(CmmParser.READ, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode WRITE() { return getToken(CmmParser.WRITE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public AssignableExpressionContext assignableExpression() {
			return getRuleContext(AssignableExpressionContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public List<StmtBlockContext> stmtBlock() {
			return getRuleContexts(StmtBlockContext.class);
		}
		public StmtBlockContext stmtBlock(int i) {
			return getRuleContext(StmtBlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ProcedureInvocationContext procedureInvocation() {
			return getRuleContext(ProcedureInvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				((StatementContext)_localctx).read = match(READ);
				setState(78);
				((StatementContext)_localctx).assignableExpressionList = assignableExpressionList();
				setState(79);
				match(SEMICOLON);

				        ((StatementContext)_localctx).ast =  new Read(((StatementContext)_localctx).read.getLine(), ((StatementContext)_localctx).read.getCharPositionInLine()+1, ((StatementContext)_localctx).assignableExpressionList.ast);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((StatementContext)_localctx).write = match(WRITE);
				setState(83);
				((StatementContext)_localctx).expressionList = expressionList();
				setState(84);
				match(SEMICOLON);

				        ((StatementContext)_localctx).ast =  new Write(((StatementContext)_localctx).write.getLine(), ((StatementContext)_localctx).write.getCharPositionInLine()+1, ((StatementContext)_localctx).expressionList.ast);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				((StatementContext)_localctx).return_ = match(RETURN);
				setState(88);
				((StatementContext)_localctx).expression = expression();
				setState(89);
				match(SEMICOLON);
				 ((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).return_.getLine(), ((StatementContext)_localctx).return_.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				((StatementContext)_localctx).e1 = assignableExpression(0);
				setState(93);
				match(ASSIGN);
				setState(94);
				((StatementContext)_localctx).e2 = expression();
				setState(95);
				match(SEMICOLON);
				 ((StatementContext)_localctx).ast =  new Assignment((((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getLine(), (((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				((StatementContext)_localctx).if_ = match(IF);
				setState(99);
				match(LEFT_PAREN);
				setState(100);
				((StatementContext)_localctx).expression = expression();
				setState(101);
				match(RIGHT_PAREN);
				setState(102);
				((StatementContext)_localctx).thenSt = stmtBlock();
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(103);
					match(ELSE);
					setState(104);
					((StatementContext)_localctx).elseSt = stmtBlock();
					}
					break;
				}

				        ((StatementContext)_localctx).ast =  new IfElse(((StatementContext)_localctx).if_.getLine(), ((StatementContext)_localctx).if_.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).thenSt.ast, ((StatementContext)_localctx).elseSt != null ? ((StatementContext)_localctx).elseSt.ast : new ArrayList<>());
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				((StatementContext)_localctx).while_ = match(WHILE);
				setState(110);
				match(LEFT_PAREN);
				setState(111);
				((StatementContext)_localctx).expression = expression();
				setState(112);
				match(RIGHT_PAREN);
				setState(113);
				((StatementContext)_localctx).stmtBlock = stmtBlock();

				        ((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).while_.getLine(), ((StatementContext)_localctx).while_.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).stmtBlock.ast);
				    
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
		public ExpressionListContext expressionList;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureInvocation; }
	}

	public final ProcedureInvocationContext procedureInvocation() throws RecognitionException {
		ProcedureInvocationContext _localctx = new ProcedureInvocationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_procedureInvocation);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				((ProcedureInvocationContext)_localctx).ID = match(ID);
				setState(123);
				match(LEFT_PAREN);
				setState(124);
				match(RIGHT_PAREN);

				        ((ProcedureInvocationContext)_localctx).ast =  new ProcedureInvocation(((ProcedureInvocationContext)_localctx).ID.getLine(), ((ProcedureInvocationContext)_localctx).ID.getCharPositionInLine()+1, new Id(((ProcedureInvocationContext)_localctx).ID.getLine(), ((ProcedureInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((ProcedureInvocationContext)_localctx).ID!=null?((ProcedureInvocationContext)_localctx).ID.getText():null)), new ArrayList<>());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((ProcedureInvocationContext)_localctx).ID = match(ID);
				setState(127);
				match(LEFT_PAREN);
				setState(128);
				((ProcedureInvocationContext)_localctx).expressionList = expressionList();
				setState(129);
				match(RIGHT_PAREN);

				        ((ProcedureInvocationContext)_localctx).ast =  new ProcedureInvocation(((ProcedureInvocationContext)_localctx).ID.getLine(), ((ProcedureInvocationContext)_localctx).ID.getCharPositionInLine()+1, new Id(((ProcedureInvocationContext)_localctx).ID.getLine(), ((ProcedureInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((ProcedureInvocationContext)_localctx).ID!=null?((ProcedureInvocationContext)_localctx).ID.getText():null)), ((ProcedureInvocationContext)_localctx).expressionList.ast);
				    
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
	public static class DefinitionContext extends ParserRuleContext {
		public Definition ast;
		public VarDefinitionContext varDefinition;
		public FunctionDefinitionContext functionDefinition;
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				((DefinitionContext)_localctx).varDefinition = varDefinition();
				 ((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).varDefinition.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				((DefinitionContext)_localctx).functionDefinition = functionDefinition();
				 ((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).functionDefinition.ast; 
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
	public static class VarDefinitionContext extends ParserRuleContext {
		public VariableDefinition ast;
		public ArrayableTypeContext t;
		public Token ID;
		public List<Token> ids = new ArrayList<Token>();
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public ArrayableTypeContext arrayableType() {
			return getRuleContext(ArrayableTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((VarDefinitionContext)_localctx).t = arrayableType(0);
			setState(143);
			((VarDefinitionContext)_localctx).ID = match(ID);
			((VarDefinitionContext)_localctx).ids.add(((VarDefinitionContext)_localctx).ID);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(144);
					match(COMMA);
					setState(145);
					((VarDefinitionContext)_localctx).ID = match(ID);
					((VarDefinitionContext)_localctx).ids.add(((VarDefinitionContext)_localctx).ID);
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(151);
			match(SEMICOLON);

			        List<Id> ids = new ArrayList<>();
			        if (((VarDefinitionContext)_localctx).ids != null) ((VarDefinitionContext)_localctx).ids.forEach(id -> {if (id != null) ids.add(new Id(id.getLine(), id.getCharPositionInLine()+1, id.getText())); });
			        ((VarDefinitionContext)_localctx).ast =  new VariableDefinition((((VarDefinitionContext)_localctx).t!=null?(((VarDefinitionContext)_localctx).t.start):null).getLine(), (((VarDefinitionContext)_localctx).t!=null?(((VarDefinitionContext)_localctx).t.start):null).getCharPositionInLine()+1, ((VarDefinitionContext)_localctx).t.ast, ids);
			    
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
	public static class VarDefListContext extends ParserRuleContext {
		public List<VariableDefinition> ast;
		public VarDefinitionContext varDefinition;
		public List<VarDefinitionContext> varDefs = new ArrayList<VarDefinitionContext>();
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public VarDefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefList; }
	}

	public final VarDefListContext varDefList() throws RecognitionException {
		VarDefListContext _localctx = new VarDefListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDefList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(154);
					((VarDefListContext)_localctx).varDefinition = varDefinition();
					((VarDefListContext)_localctx).varDefs.add(((VarDefListContext)_localctx).varDefinition);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(157); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

			        List<VariableDefinition> varDefs = new ArrayList<>();
			        if (((VarDefListContext)_localctx).varDefs != null) ((VarDefListContext)_localctx).varDefs.forEach(vd -> {if (vd != null) varDefs.add(vd.ast); });
			        ((VarDefListContext)_localctx).ast =  varDefs;
			    
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
		public VoidableTypeContext returnType;
		public Token id;
		public ParamsListContext paramsList;
		public VarDefListContext varDefList;
		public StmtListContext stmtList;
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(CmmParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CmmParser.RIGHT_BRACE, 0); }
		public VoidableTypeContext voidableType() {
			return getRuleContext(VoidableTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParamsListContext paramsList() {
			return getRuleContext(ParamsListContext.class,0);
		}
		public VarDefListContext varDefList() {
			return getRuleContext(VarDefListContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((FunctionDefinitionContext)_localctx).returnType = voidableType();
			setState(162);
			((FunctionDefinitionContext)_localctx).id = match(ID);
			setState(163);
			match(LEFT_PAREN);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 257698037760L) != 0)) {
				{
				setState(164);
				((FunctionDefinitionContext)_localctx).paramsList = paramsList();
				}
			}

			setState(167);
			match(RIGHT_PAREN);
			setState(168);
			match(LEFT_BRACE);
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(169);
				((FunctionDefinitionContext)_localctx).varDefList = varDefList();
				}
				break;
			}
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(172);
				((FunctionDefinitionContext)_localctx).stmtList = stmtList();
				}
				break;
			}
			setState(175);
			match(RIGHT_BRACE);

			        FunctionType returnType = new FunctionType((((FunctionDefinitionContext)_localctx).returnType!=null?(((FunctionDefinitionContext)_localctx).returnType.start):null).getLine(), (((FunctionDefinitionContext)_localctx).returnType!=null?(((FunctionDefinitionContext)_localctx).returnType.start):null).getCharPositionInLine()+1, ((FunctionDefinitionContext)_localctx).returnType.ast, ((FunctionDefinitionContext)_localctx).paramsList != null ? ((FunctionDefinitionContext)_localctx).paramsList.ast : new ArrayList<>());
			        ((FunctionDefinitionContext)_localctx).ast =  new FunctionDefinition((((FunctionDefinitionContext)_localctx).returnType!=null?(((FunctionDefinitionContext)_localctx).returnType.start):null).getLine(), (((FunctionDefinitionContext)_localctx).returnType!=null?(((FunctionDefinitionContext)_localctx).returnType.start):null).getCharPositionInLine()+1, returnType, new Id(((FunctionDefinitionContext)_localctx).id.getLine(), ((FunctionDefinitionContext)_localctx).id.getCharPositionInLine()+1, (((FunctionDefinitionContext)_localctx).id!=null?((FunctionDefinitionContext)_localctx).id.getText():null)), ((FunctionDefinitionContext)_localctx).varDefList != null ? ((FunctionDefinitionContext)_localctx).varDefList.ast : new ArrayList<>(), ((FunctionDefinitionContext)_localctx).stmtList != null ? ((FunctionDefinitionContext)_localctx).stmtList.ast : new ArrayList<>());
			    
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
	public static class ParamsListContext extends ParserRuleContext {
		public List<VariableDefinition> ast;
		public ParamDefContext paramDef;
		public List<ParamDefContext> params = new ArrayList<ParamDefContext>();
		public List<ParamDefContext> paramDef() {
			return getRuleContexts(ParamDefContext.class);
		}
		public ParamDefContext paramDef(int i) {
			return getRuleContext(ParamDefContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public ParamsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsList; }
	}

	public final ParamsListContext paramsList() throws RecognitionException {
		ParamsListContext _localctx = new ParamsListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramsList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((ParamsListContext)_localctx).paramDef = paramDef();
			((ParamsListContext)_localctx).params.add(((ParamsListContext)_localctx).paramDef);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(179);
					match(COMMA);
					setState(180);
					((ParamsListContext)_localctx).paramDef = paramDef();
					((ParamsListContext)_localctx).params.add(((ParamsListContext)_localctx).paramDef);
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}

			        List<VariableDefinition> params = new ArrayList<>();
			        if (((ParamsListContext)_localctx).params != null) ((ParamsListContext)_localctx).params.forEach(p -> {if (p != null) params.add(p.ast); });
			        ((ParamsListContext)_localctx).ast =  params;
			    
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
	public static class ParamDefContext extends ParserRuleContext {
		public VariableDefinition ast;
		public ArrayableTypeContext t;
		public Token id;
		public ArrayableTypeContext arrayableType() {
			return getRuleContext(ArrayableTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParamDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDef; }
	}

	public final ParamDefContext paramDef() throws RecognitionException {
		ParamDefContext _localctx = new ParamDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			((ParamDefContext)_localctx).t = arrayableType(0);
			setState(189);
			((ParamDefContext)_localctx).id = match(ID);

			        List<Id> ids = new ArrayList<>();
			        ids.add(new Id(((ParamDefContext)_localctx).id.getLine(), ((ParamDefContext)_localctx).id.getCharPositionInLine()+1, ((ParamDefContext)_localctx).id.getText()));
			        ((ParamDefContext)_localctx).ast =  new VariableDefinition((((ParamDefContext)_localctx).t!=null?(((ParamDefContext)_localctx).t.start):null).getLine(), (((ParamDefContext)_localctx).t!=null?(((ParamDefContext)_localctx).t.start):null).getCharPositionInLine()+1, ((ParamDefContext)_localctx).t.ast, ids);
			    
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
	public static class RecordFieldListContext extends ParserRuleContext {
		public List<StructRecordField> ast;
		public RecordFieldContext recordField;
		public List<RecordFieldContext> field = new ArrayList<RecordFieldContext>();
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public List<RecordFieldContext> recordField() {
			return getRuleContexts(RecordFieldContext.class);
		}
		public RecordFieldContext recordField(int i) {
			return getRuleContext(RecordFieldContext.class,i);
		}
		public RecordFieldListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordFieldList; }
	}

	public final RecordFieldListContext recordFieldList() throws RecognitionException {
		RecordFieldListContext _localctx = new RecordFieldListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recordFieldList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			((RecordFieldListContext)_localctx).recordField = recordField();
			((RecordFieldListContext)_localctx).field.add(((RecordFieldListContext)_localctx).recordField);
			setState(193);
			match(SEMICOLON);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(194);
					((RecordFieldListContext)_localctx).recordField = recordField();
					((RecordFieldListContext)_localctx).field.add(((RecordFieldListContext)_localctx).recordField);
					setState(195);
					match(SEMICOLON);
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}

			        List<StructRecordField> fields = new ArrayList<>();
			        if (((RecordFieldListContext)_localctx).field != null) ((RecordFieldListContext)_localctx).field.forEach(f -> {if (f != null) fields.add(f.ast); });
			        ((RecordFieldListContext)_localctx).ast =  fields;
			    
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
	public static class RecordFieldContext extends ParserRuleContext {
		public StructRecordField ast;
		public ArrayableTypeContext type;
		public Token ID;
		public List<Token> id = new ArrayList<Token>();
		public ArrayableTypeContext arrayableType() {
			return getRuleContext(ArrayableTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public RecordFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordField; }
	}

	public final RecordFieldContext recordField() throws RecognitionException {
		RecordFieldContext _localctx = new RecordFieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_recordField);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			((RecordFieldContext)_localctx).type = arrayableType(0);
			setState(205);
			((RecordFieldContext)_localctx).ID = match(ID);
			((RecordFieldContext)_localctx).id.add(((RecordFieldContext)_localctx).ID);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(206);
					match(COMMA);
					setState(207);
					((RecordFieldContext)_localctx).ID = match(ID);
					((RecordFieldContext)_localctx).id.add(((RecordFieldContext)_localctx).ID);
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}

			        List<Id> ids = new ArrayList<>();
			        if (((RecordFieldContext)_localctx).id != null) ((RecordFieldContext)_localctx).id.forEach(i -> {if (i != null) ids.add(new Id(i.getLine(), i.getCharPositionInLine()+1, i.getText())); });
			        ((RecordFieldContext)_localctx).ast =  new StructRecordField(((RecordFieldContext)_localctx).type.ast.getLine(), ((RecordFieldContext)_localctx).type.ast.getColumn(), ((RecordFieldContext)_localctx).type.ast, ids);
			    
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
	public static class StmtBlockContext extends ParserRuleContext {
		public List<Statement> ast;
		public StmtListContext stmtList;
		public StatementContext statement;
		public TerminalNode LEFT_BRACE() { return getToken(CmmParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CmmParser.RIGHT_BRACE, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StmtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtBlock; }
	}

	public final StmtBlockContext stmtBlock() throws RecognitionException {
		StmtBlockContext _localctx = new StmtBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmtBlock);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(LEFT_BRACE);
				setState(217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(216);
					((StmtBlockContext)_localctx).stmtList = stmtList();
					}
					break;
				}
				setState(219);
				match(RIGHT_BRACE);

				        ((StmtBlockContext)_localctx).ast =  ((StmtBlockContext)_localctx).stmtList != null ? ((StmtBlockContext)_localctx).stmtList.ast : new ArrayList<>();
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				((StmtBlockContext)_localctx).statement = statement();

				        List<Statement> stmts = new ArrayList<>();
				        stmts.add(((StmtBlockContext)_localctx).statement.ast);
				        ((StmtBlockContext)_localctx).ast =  stmts;
				    
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
	public static class StmtListContext extends ParserRuleContext {
		public List<Statement> ast;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmtList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(226);
					((StmtListContext)_localctx).statement = statement();
					((StmtListContext)_localctx).stmts.add(((StmtListContext)_localctx).statement);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(229); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

			        List<Statement> stmts = new ArrayList<>();
			        if (((StmtListContext)_localctx).stmts != null) ((StmtListContext)_localctx).stmts.forEach(s -> {if (s != null) stmts.add(s.ast); });
			        ((StmtListContext)_localctx).ast =  stmts;
			    
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
		public LogicalOrExpressionContext logicalOrExpression;
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			((ExpressionContext)_localctx).logicalOrExpression = logicalOrExpression();
			 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).logicalOrExpression.ast; 
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
	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public Expression ast;
		public LogicalAndExpressionContext e1;
		public Token op;
		public LogicalAndExpressionContext e2;
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OR() { return getTokens(CmmParser.LOGICAL_OR); }
		public TerminalNode LOGICAL_OR(int i) {
			return getToken(CmmParser.LOGICAL_OR, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			((LogicalOrExpressionContext)_localctx).e1 = logicalAndExpression();
			 ((LogicalOrExpressionContext)_localctx).ast =  ((LogicalOrExpressionContext)_localctx).e1.ast; 
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OR) {
				{
				{
				setState(238);
				((LogicalOrExpressionContext)_localctx).op = match(LOGICAL_OR);
				setState(239);
				((LogicalOrExpressionContext)_localctx).e2 = logicalAndExpression();
				 ((LogicalOrExpressionContext)_localctx).ast =  new Logical((((LogicalOrExpressionContext)_localctx).e1!=null?(((LogicalOrExpressionContext)_localctx).e1.start):null).getLine(), (((LogicalOrExpressionContext)_localctx).e1!=null?(((LogicalOrExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, _localctx.ast, (((LogicalOrExpressionContext)_localctx).op!=null?((LogicalOrExpressionContext)_localctx).op.getText():null), ((LogicalOrExpressionContext)_localctx).e2.ast); 
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public Expression ast;
		public RelationalExpressionContext e1;
		public Token op;
		public RelationalExpressionContext e2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> LOGICAL_AND() { return getTokens(CmmParser.LOGICAL_AND); }
		public TerminalNode LOGICAL_AND(int i) {
			return getToken(CmmParser.LOGICAL_AND, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			((LogicalAndExpressionContext)_localctx).e1 = relationalExpression();
			 ((LogicalAndExpressionContext)_localctx).ast =  ((LogicalAndExpressionContext)_localctx).e1.ast; 
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_AND) {
				{
				{
				setState(249);
				((LogicalAndExpressionContext)_localctx).op = match(LOGICAL_AND);
				setState(250);
				((LogicalAndExpressionContext)_localctx).e2 = relationalExpression();
				 ((LogicalAndExpressionContext)_localctx).ast =  new Logical((((LogicalAndExpressionContext)_localctx).e1!=null?(((LogicalAndExpressionContext)_localctx).e1.start):null).getLine(), (((LogicalAndExpressionContext)_localctx).e1!=null?(((LogicalAndExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, _localctx.ast, (((LogicalAndExpressionContext)_localctx).op!=null?((LogicalAndExpressionContext)_localctx).op.getText():null), ((LogicalAndExpressionContext)_localctx).e2.ast); 
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression ast;
		public AdditiveExpressionContext e1;
		public Token op;
		public AdditiveExpressionContext e2;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> RELATIONAL_EQUAL() { return getTokens(CmmParser.RELATIONAL_EQUAL); }
		public TerminalNode RELATIONAL_EQUAL(int i) {
			return getToken(CmmParser.RELATIONAL_EQUAL, i);
		}
		public List<TerminalNode> RELATIONAL_NOT_EQUAL() { return getTokens(CmmParser.RELATIONAL_NOT_EQUAL); }
		public TerminalNode RELATIONAL_NOT_EQUAL(int i) {
			return getToken(CmmParser.RELATIONAL_NOT_EQUAL, i);
		}
		public List<TerminalNode> RELATIONAL_LESS_THAN() { return getTokens(CmmParser.RELATIONAL_LESS_THAN); }
		public TerminalNode RELATIONAL_LESS_THAN(int i) {
			return getToken(CmmParser.RELATIONAL_LESS_THAN, i);
		}
		public List<TerminalNode> RELATIONAL_LESS_EQUAL() { return getTokens(CmmParser.RELATIONAL_LESS_EQUAL); }
		public TerminalNode RELATIONAL_LESS_EQUAL(int i) {
			return getToken(CmmParser.RELATIONAL_LESS_EQUAL, i);
		}
		public List<TerminalNode> RELATIONAL_GREATER_THAN() { return getTokens(CmmParser.RELATIONAL_GREATER_THAN); }
		public TerminalNode RELATIONAL_GREATER_THAN(int i) {
			return getToken(CmmParser.RELATIONAL_GREATER_THAN, i);
		}
		public List<TerminalNode> RELATIONAL_GREATER_EQUAL() { return getTokens(CmmParser.RELATIONAL_GREATER_EQUAL); }
		public TerminalNode RELATIONAL_GREATER_EQUAL(int i) {
			return getToken(CmmParser.RELATIONAL_GREATER_EQUAL, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			((RelationalExpressionContext)_localctx).e1 = additiveExpression();
			 ((RelationalExpressionContext)_localctx).ast =  ((RelationalExpressionContext)_localctx).e1.ast; 
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33030144L) != 0)) {
				{
				{
				setState(260);
				((RelationalExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33030144L) != 0)) ) {
					((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(261);
				((RelationalExpressionContext)_localctx).e2 = additiveExpression();
				 ((RelationalExpressionContext)_localctx).ast =  new Relational((((RelationalExpressionContext)_localctx).e1!=null?(((RelationalExpressionContext)_localctx).e1.start):null).getLine(), (((RelationalExpressionContext)_localctx).e1!=null?(((RelationalExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, _localctx.ast, (((RelationalExpressionContext)_localctx).op!=null?((RelationalExpressionContext)_localctx).op.getText():null), ((RelationalExpressionContext)_localctx).e2.ast); 
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression ast;
		public MultiplicativeExpressionContext e1;
		public Token op;
		public MultiplicativeExpressionContext e2;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CmmParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CmmParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CmmParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CmmParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			((AdditiveExpressionContext)_localctx).e1 = multiplicativeExpression();
			 ((AdditiveExpressionContext)_localctx).ast =  ((AdditiveExpressionContext)_localctx).e1.ast; 
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(271);
				((AdditiveExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((AdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(272);
				((AdditiveExpressionContext)_localctx).e2 = multiplicativeExpression();
				 ((AdditiveExpressionContext)_localctx).ast =  new Arithmetic((((AdditiveExpressionContext)_localctx).e1!=null?(((AdditiveExpressionContext)_localctx).e1.start):null).getLine(), (((AdditiveExpressionContext)_localctx).e1!=null?(((AdditiveExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, _localctx.ast, (((AdditiveExpressionContext)_localctx).op!=null?((AdditiveExpressionContext)_localctx).op.getText():null), ((AdditiveExpressionContext)_localctx).e2.ast); 
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression ast;
		public UnaryExpressionContext e1;
		public Token op;
		public UnaryExpressionContext e2;
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(CmmParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(CmmParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(CmmParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(CmmParser.DIVIDE, i);
		}
		public List<TerminalNode> MODULO() { return getTokens(CmmParser.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(CmmParser.MODULO, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			((MultiplicativeExpressionContext)_localctx).e1 = unaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).ast =  ((MultiplicativeExpressionContext)_localctx).e1.ast; 
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) {
				{
				{
				setState(282);
				((MultiplicativeExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) ) {
					((MultiplicativeExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(283);
				((MultiplicativeExpressionContext)_localctx).e2 = unaryExpression();

				            if ((((MultiplicativeExpressionContext)_localctx).op!=null?((MultiplicativeExpressionContext)_localctx).op.getType():0) == CmmParser.MODULO) {
				                ((MultiplicativeExpressionContext)_localctx).ast =  new Modulus((((MultiplicativeExpressionContext)_localctx).e1!=null?(((MultiplicativeExpressionContext)_localctx).e1.start):null).getLine(), (((MultiplicativeExpressionContext)_localctx).e1!=null?(((MultiplicativeExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, _localctx.ast, ((MultiplicativeExpressionContext)_localctx).e2.ast);
				            } else {
				                ((MultiplicativeExpressionContext)_localctx).ast =  new Arithmetic((((MultiplicativeExpressionContext)_localctx).e1!=null?(((MultiplicativeExpressionContext)_localctx).e1.start):null).getLine(), (((MultiplicativeExpressionContext)_localctx).e1!=null?(((MultiplicativeExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, _localctx.ast, (((MultiplicativeExpressionContext)_localctx).op!=null?((MultiplicativeExpressionContext)_localctx).op.getText():null), ((MultiplicativeExpressionContext)_localctx).e2.ast);
				            }
				        
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class UnaryExpressionContext extends ParserRuleContext {
		public Expression ast;
		public Token lp;
		public BuiltInTypeContext castType;
		public UnaryExpressionContext e;
		public Token min;
		public Token logNot;
		public PrimaryExpressionContext primaryExpression;
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public TerminalNode LOGICAL_NOT() { return getToken(CmmParser.LOGICAL_NOT, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryExpression);
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				((UnaryExpressionContext)_localctx).lp = match(LEFT_PAREN);
				setState(292);
				((UnaryExpressionContext)_localctx).castType = builtInType();
				setState(293);
				match(RIGHT_PAREN);
				setState(294);
				((UnaryExpressionContext)_localctx).e = unaryExpression();
				 ((UnaryExpressionContext)_localctx).ast =  new Cast(((UnaryExpressionContext)_localctx).lp.getLine(), ((UnaryExpressionContext)_localctx).lp.getCharPositionInLine()+1, ((UnaryExpressionContext)_localctx).castType.ast, ((UnaryExpressionContext)_localctx).e.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				((UnaryExpressionContext)_localctx).min = match(MINUS);
				setState(298);
				((UnaryExpressionContext)_localctx).e = unaryExpression();
				 ((UnaryExpressionContext)_localctx).ast =  new UnaryMinus(((UnaryExpressionContext)_localctx).min.getLine(), ((UnaryExpressionContext)_localctx).min.getCharPositionInLine()+1, ((UnaryExpressionContext)_localctx).e.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				((UnaryExpressionContext)_localctx).logNot = match(LOGICAL_NOT);
				setState(302);
				((UnaryExpressionContext)_localctx).e = unaryExpression();
				 ((UnaryExpressionContext)_localctx).ast =  new LogicalNot(((UnaryExpressionContext)_localctx).logNot.getLine(), ((UnaryExpressionContext)_localctx).logNot.getCharPositionInLine()+1, ((UnaryExpressionContext)_localctx).e.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
				((UnaryExpressionContext)_localctx).primaryExpression = primaryExpression();
				 ((UnaryExpressionContext)_localctx).ast =  ((UnaryExpressionContext)_localctx).primaryExpression.ast; 
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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public Expression ast;
		public Token lp;
		public ExpressionContext expression;
		public Token INT_CONSTANT;
		public Token DOUBLE_CONSTANT;
		public Token CHAR_CONSTANT;
		public FunctionInvocationContext functionInvocation;
		public AssignableExpressionContext assignableExpression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode DOUBLE_CONSTANT() { return getToken(CmmParser.DOUBLE_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public AssignableExpressionContext assignableExpression() {
			return getRuleContext(AssignableExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryExpression);
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				((PrimaryExpressionContext)_localctx).lp = match(LEFT_PAREN);
				setState(311);
				((PrimaryExpressionContext)_localctx).expression = expression();
				setState(312);
				match(RIGHT_PAREN);
				 ((PrimaryExpressionContext)_localctx).ast =  new Parenthesis(((PrimaryExpressionContext)_localctx).lp.getLine(), ((PrimaryExpressionContext)_localctx).lp.getCharPositionInLine()+1, ((PrimaryExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				((PrimaryExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((PrimaryExpressionContext)_localctx).ast =  new IntLiteral(((PrimaryExpressionContext)_localctx).INT_CONSTANT.getLine(), ((PrimaryExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((PrimaryExpressionContext)_localctx).INT_CONSTANT!=null?((PrimaryExpressionContext)_localctx).INT_CONSTANT.getText():null))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				((PrimaryExpressionContext)_localctx).DOUBLE_CONSTANT = match(DOUBLE_CONSTANT);
				 ((PrimaryExpressionContext)_localctx).ast =  new DoubleLiteral(((PrimaryExpressionContext)_localctx).DOUBLE_CONSTANT.getLine(), ((PrimaryExpressionContext)_localctx).DOUBLE_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToDouble((((PrimaryExpressionContext)_localctx).DOUBLE_CONSTANT!=null?((PrimaryExpressionContext)_localctx).DOUBLE_CONSTANT.getText():null))); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				((PrimaryExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((PrimaryExpressionContext)_localctx).ast =  new CharLiteral(((PrimaryExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((PrimaryExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((PrimaryExpressionContext)_localctx).CHAR_CONSTANT!=null?((PrimaryExpressionContext)_localctx).CHAR_CONSTANT.getText():null))); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(321);
				((PrimaryExpressionContext)_localctx).functionInvocation = functionInvocation();
				 ((PrimaryExpressionContext)_localctx).ast =  ((PrimaryExpressionContext)_localctx).functionInvocation.ast; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(324);
				((PrimaryExpressionContext)_localctx).assignableExpression = assignableExpression(0);
				 ((PrimaryExpressionContext)_localctx).ast =  ((PrimaryExpressionContext)_localctx).assignableExpression.ast; 
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
	public static class AssignableExpressionContext extends ParserRuleContext {
		public Expression ast;
		public AssignableExpressionContext e;
		public Token ID;
		public Token lb;
		public ExpressionContext ai;
		public Token rb;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public AssignableExpressionContext assignableExpression() {
			return getRuleContext(AssignableExpressionContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(CmmParser.LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CmmParser.RIGHT_BRACKET, 0); }
		public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
		public AssignableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableExpression; }
	}

	public final AssignableExpressionContext assignableExpression() throws RecognitionException {
		return assignableExpression(0);
	}

	private AssignableExpressionContext assignableExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AssignableExpressionContext _localctx = new AssignableExpressionContext(_ctx, _parentState);
		AssignableExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_assignableExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(330);
				((AssignableExpressionContext)_localctx).ID = match(ID);
				 ((AssignableExpressionContext)_localctx).ast =  new Id(((AssignableExpressionContext)_localctx).ID.getLine(), ((AssignableExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((AssignableExpressionContext)_localctx).ID!=null?((AssignableExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(344);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new AssignableExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_assignableExpression);
						setState(334);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(335);
						((AssignableExpressionContext)_localctx).lb = match(LEFT_BRACKET);
						setState(336);
						((AssignableExpressionContext)_localctx).ai = expression();
						setState(337);
						((AssignableExpressionContext)_localctx).rb = match(RIGHT_BRACKET);
						 ((AssignableExpressionContext)_localctx).ast =  new ArrayAccess((((AssignableExpressionContext)_localctx).e!=null?(((AssignableExpressionContext)_localctx).e.start):null).getLine(), (((AssignableExpressionContext)_localctx).e!=null?(((AssignableExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1, ((AssignableExpressionContext)_localctx).e.ast, ((AssignableExpressionContext)_localctx).ai.ast); 
						}
						break;
					case 2:
						{
						_localctx = new AssignableExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_assignableExpression);
						setState(340);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(341);
						match(DOT);
						setState(342);
						((AssignableExpressionContext)_localctx).ID = match(ID);
						 ((AssignableExpressionContext)_localctx).ast =  new StructAccess((((AssignableExpressionContext)_localctx).e!=null?(((AssignableExpressionContext)_localctx).e.start):null).getLine(), (((AssignableExpressionContext)_localctx).e!=null?(((AssignableExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1, ((AssignableExpressionContext)_localctx).e.ast, (((AssignableExpressionContext)_localctx).ID!=null?((AssignableExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
	public static class ExpressionListContext extends ParserRuleContext {
		public List<Expression> ast;
		public ExpressionContext expression;
		public List<ExpressionContext> exp = new ArrayList<ExpressionContext>();
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
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			((ExpressionListContext)_localctx).expression = expression();
			((ExpressionListContext)_localctx).exp.add(((ExpressionListContext)_localctx).expression);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(350);
				match(COMMA);
				setState(351);
				((ExpressionListContext)_localctx).expression = expression();
				((ExpressionListContext)_localctx).exp.add(((ExpressionListContext)_localctx).expression);
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        List<Expression> exp = new ArrayList<>();
			        if (((ExpressionListContext)_localctx).exp != null) ((ExpressionListContext)_localctx).exp.forEach(e -> {if (e.ast != null) exp.add(e.ast); });
			        ((ExpressionListContext)_localctx).ast =  exp;
			    
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
	public static class AssignableExpressionListContext extends ParserRuleContext {
		public List<Expression> ast;
		public AssignableExpressionContext assignableExpression;
		public List<AssignableExpressionContext> exp = new ArrayList<AssignableExpressionContext>();
		public List<AssignableExpressionContext> assignableExpression() {
			return getRuleContexts(AssignableExpressionContext.class);
		}
		public AssignableExpressionContext assignableExpression(int i) {
			return getRuleContext(AssignableExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public AssignableExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableExpressionList; }
	}

	public final AssignableExpressionListContext assignableExpressionList() throws RecognitionException {
		AssignableExpressionListContext _localctx = new AssignableExpressionListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assignableExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			((AssignableExpressionListContext)_localctx).assignableExpression = assignableExpression(0);
			((AssignableExpressionListContext)_localctx).exp.add(((AssignableExpressionListContext)_localctx).assignableExpression);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(360);
				match(COMMA);
				setState(361);
				((AssignableExpressionListContext)_localctx).assignableExpression = assignableExpression(0);
				((AssignableExpressionListContext)_localctx).exp.add(((AssignableExpressionListContext)_localctx).assignableExpression);
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        List<Expression> exp = new ArrayList<>();
			        if (((AssignableExpressionListContext)_localctx).exp != null) ((AssignableExpressionListContext)_localctx).exp.forEach(e -> {if (e.ast != null) exp.add(e.ast); });
			        ((AssignableExpressionListContext)_localctx).ast =  exp;
			    
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
	public static class FunctionInvocationContext extends ParserRuleContext {
		public Expression ast;
		public Token ID;
		public ExpressionListContext expressionList;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CmmParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(CmmParser.RIGHT_PAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionInvocation);
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				((FunctionInvocationContext)_localctx).ID = match(ID);
				setState(370);
				match(LEFT_PAREN);
				setState(371);
				match(RIGHT_PAREN);

				        ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, new Id(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null)), new ArrayList<>());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				((FunctionInvocationContext)_localctx).ID = match(ID);
				setState(374);
				match(LEFT_PAREN);
				setState(375);
				((FunctionInvocationContext)_localctx).expressionList = expressionList();
				setState(376);
				match(RIGHT_PAREN);

				        ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, new Id(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null)), ((FunctionInvocationContext)_localctx).expressionList.ast);
				    
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
	public static class VoidableTypeContext extends ParserRuleContext {
		public Type ast;
		public BuiltInTypeContext baseType;
		public Token void_;
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public VoidableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidableType; }
	}

	public final VoidableTypeContext voidableType() throws RecognitionException {
		VoidableTypeContext _localctx = new VoidableTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_voidableType);
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				((VoidableTypeContext)_localctx).baseType = builtInType();
				 ((VoidableTypeContext)_localctx).ast =  ((VoidableTypeContext)_localctx).baseType.ast; 
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				((VoidableTypeContext)_localctx).void_ = match(VOID);
				 ((VoidableTypeContext)_localctx).ast =  new VoidType(((VoidableTypeContext)_localctx).void_.getLine(), ((VoidableTypeContext)_localctx).void_.getCharPositionInLine()+1); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayableTypeContext extends ParserRuleContext {
		public Type ast;
		public ArrayableTypeContext type;
		public BuiltInTypeContext baseType;
		public Token struct;
		public RecordFieldListContext recordFieldList;
		public Token INT_CONSTANT;
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(CmmParser.LEFT_BRACE, 0); }
		public RecordFieldListContext recordFieldList() {
			return getRuleContext(RecordFieldListContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(CmmParser.RIGHT_BRACE, 0); }
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(CmmParser.LEFT_BRACKET, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(CmmParser.RIGHT_BRACKET, 0); }
		public ArrayableTypeContext arrayableType() {
			return getRuleContext(ArrayableTypeContext.class,0);
		}
		public ArrayableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayableType; }
	}

	public final ArrayableTypeContext arrayableType() throws RecognitionException {
		return arrayableType(0);
	}

	private ArrayableTypeContext arrayableType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayableTypeContext _localctx = new ArrayableTypeContext(_ctx, _parentState);
		ArrayableTypeContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_arrayableType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case CHAR:
				{
				setState(389);
				((ArrayableTypeContext)_localctx).baseType = builtInType();
				 ((ArrayableTypeContext)_localctx).ast =  ((ArrayableTypeContext)_localctx).baseType.ast; 
				}
				break;
			case STRUCT:
				{
				setState(392);
				((ArrayableTypeContext)_localctx).struct = match(STRUCT);
				setState(393);
				match(LEFT_BRACE);
				setState(394);
				((ArrayableTypeContext)_localctx).recordFieldList = recordFieldList();
				setState(395);
				match(RIGHT_BRACE);

				        int line = _localctx.getStart().getLine();
				        int col = _localctx.getStart().getCharPositionInLine()+1;
				        ((ArrayableTypeContext)_localctx).ast =  new StructType(line, col, ((ArrayableTypeContext)_localctx).recordFieldList.ast);
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayableTypeContext(_parentctx, _parentState);
					_localctx.type = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arrayableType);
					setState(400);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(401);
					match(LEFT_BRACKET);
					setState(402);
					((ArrayableTypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
					setState(403);
					match(RIGHT_BRACKET);

					                  int size = LexerHelper.lexemeToInt((((ArrayableTypeContext)_localctx).INT_CONSTANT!=null?((ArrayableTypeContext)_localctx).INT_CONSTANT.getText():null));
					                  ((ArrayableTypeContext)_localctx).ast =  new ArrayType(((ArrayableTypeContext)_localctx).type.ast.getLine(), ((ArrayableTypeContext)_localctx).type.ast.getColumn(), ((ArrayableTypeContext)_localctx).type.ast, size);
					              
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
	public static class BuiltInTypeContext extends ParserRuleContext {
		public Type ast;
		public Token int_;
		public Token double_;
		public Token char_;
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(CmmParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(CmmParser.CHAR, 0); }
		public BuiltInTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInType; }
	}

	public final BuiltInTypeContext builtInType() throws RecognitionException {
		BuiltInTypeContext _localctx = new BuiltInTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_builtInType);
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				((BuiltInTypeContext)_localctx).int_ = match(INT);
				 ((BuiltInTypeContext)_localctx).ast =  new IntType(((BuiltInTypeContext)_localctx).int_.getLine(), ((BuiltInTypeContext)_localctx).int_.getCharPositionInLine()+1); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				((BuiltInTypeContext)_localctx).double_ = match(DOUBLE);
				 ((BuiltInTypeContext)_localctx).ast =  new DoubleType(((BuiltInTypeContext)_localctx).double_.getLine(), ((BuiltInTypeContext)_localctx).double_.getCharPositionInLine()+1); 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(414);
				((BuiltInTypeContext)_localctx).char_ = match(CHAR);
				 ((BuiltInTypeContext)_localctx).ast =  new CharType(((BuiltInTypeContext)_localctx).char_.getLine(), ((BuiltInTypeContext)_localctx).char_.getCharPositionInLine()+1); 
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
		case 21:
			return assignableExpression_sempred((AssignableExpressionContext)_localctx, predIndex);
		case 26:
			return arrayableType_sempred((ArrayableTypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean assignableExpression_sempred(AssignableExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arrayableType_sempred(ArrayableTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u01a3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"E\b\u0000\u0001\u0000\u0003\u0000H\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001j\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001y\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0085\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u008d"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0093"+
		"\b\u0004\n\u0004\f\u0004\u0096\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0004\u0005\u009c\b\u0005\u000b\u0005\f\u0005\u009d\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00a6\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00ab"+
		"\b\u0006\u0001\u0006\u0003\u0006\u00ae\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00b6\b\u0007"+
		"\n\u0007\f\u0007\u00b9\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00c6"+
		"\b\t\n\t\f\t\u00c9\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0005\n\u00d1\b\n\n\n\f\n\u00d4\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00da\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00e1\b\u000b\u0001\f\u0004\f\u00e4\b\f"+
		"\u000b\f\f\f\u00e5\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00f3\b\u000e\n\u000e\f\u000e\u00f6\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00fe\b\u000f\n"+
		"\u000f\f\u000f\u0101\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0109\b\u0010\n\u0010\f\u0010"+
		"\u010c\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u0114\b\u0011\n\u0011\f\u0011\u0117\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u011f\b\u0012\n\u0012\f\u0012\u0122\t\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0135\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0148\b\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u014d\b\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0159\b\u0015\n\u0015"+
		"\f\u0015\u015c\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u0161\b\u0016\n\u0016\f\u0016\u0164\t\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u016b\b\u0017\n\u0017\f\u0017"+
		"\u016e\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u017c\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u0183\b\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u018f\b\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0196\b\u001a\n\u001a"+
		"\f\u001a\u0199\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u01a1\b\u001b\u0001\u001b\u0005;"+
		"\u0094\u00b7\u00c7\u00d2\u0002*4\u001c\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246\u0000\u0003"+
		"\u0001\u0000\u0013\u0018\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0012"+
		"\u01b5\u0000;\u0001\u0000\u0000\u0000\u0002x\u0001\u0000\u0000\u0000\u0004"+
		"\u0084\u0001\u0000\u0000\u0000\u0006\u008c\u0001\u0000\u0000\u0000\b\u008e"+
		"\u0001\u0000\u0000\u0000\n\u009b\u0001\u0000\u0000\u0000\f\u00a1\u0001"+
		"\u0000\u0000\u0000\u000e\u00b2\u0001\u0000\u0000\u0000\u0010\u00bc\u0001"+
		"\u0000\u0000\u0000\u0012\u00c0\u0001\u0000\u0000\u0000\u0014\u00cc\u0001"+
		"\u0000\u0000\u0000\u0016\u00e0\u0001\u0000\u0000\u0000\u0018\u00e3\u0001"+
		"\u0000\u0000\u0000\u001a\u00e9\u0001\u0000\u0000\u0000\u001c\u00ec\u0001"+
		"\u0000\u0000\u0000\u001e\u00f7\u0001\u0000\u0000\u0000 \u0102\u0001\u0000"+
		"\u0000\u0000\"\u010d\u0001\u0000\u0000\u0000$\u0118\u0001\u0000\u0000"+
		"\u0000&\u0134\u0001\u0000\u0000\u0000(\u0147\u0001\u0000\u0000\u0000*"+
		"\u014c\u0001\u0000\u0000\u0000,\u015d\u0001\u0000\u0000\u0000.\u0167\u0001"+
		"\u0000\u0000\u00000\u017b\u0001\u0000\u0000\u00002\u0182\u0001\u0000\u0000"+
		"\u00004\u018e\u0001\u0000\u0000\u00006\u01a0\u0001\u0000\u0000\u00008"+
		":\u0003\u0006\u0003\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<>\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005&\u0000\u0000?@\u0005\'"+
		"\u0000\u0000@A\u0005\u0005\u0000\u0000AB\u0005\u0006\u0000\u0000BD\u0005"+
		"\u0007\u0000\u0000CE\u0003\n\u0005\u0000DC\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FH\u0003\u0018\f\u0000GF\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IJ\u0005\b\u0000\u0000JK\u0005\u0000\u0000\u0001KL\u0006\u0000\uffff\uffff"+
		"\u0000L\u0001\u0001\u0000\u0000\u0000MN\u0005\u001c\u0000\u0000NO\u0003"+
		".\u0017\u0000OP\u0005\u0004\u0000\u0000PQ\u0006\u0001\uffff\uffff\u0000"+
		"Qy\u0001\u0000\u0000\u0000RS\u0005\u001d\u0000\u0000ST\u0003,\u0016\u0000"+
		"TU\u0005\u0004\u0000\u0000UV\u0006\u0001\uffff\uffff\u0000Vy\u0001\u0000"+
		"\u0000\u0000WX\u0005\u001e\u0000\u0000XY\u0003\u001a\r\u0000YZ\u0005\u0004"+
		"\u0000\u0000Z[\u0006\u0001\uffff\uffff\u0000[y\u0001\u0000\u0000\u0000"+
		"\\]\u0003*\u0015\u0000]^\u0005\r\u0000\u0000^_\u0003\u001a\r\u0000_`\u0005"+
		"\u0004\u0000\u0000`a\u0006\u0001\uffff\uffff\u0000ay\u0001\u0000\u0000"+
		"\u0000bc\u0005\u001f\u0000\u0000cd\u0005\u0005\u0000\u0000de\u0003\u001a"+
		"\r\u0000ef\u0005\u0006\u0000\u0000fi\u0003\u0016\u000b\u0000gh\u0005 "+
		"\u0000\u0000hj\u0003\u0016\u000b\u0000ig\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0006\u0001\uffff\uffff"+
		"\u0000ly\u0001\u0000\u0000\u0000mn\u0005!\u0000\u0000no\u0005\u0005\u0000"+
		"\u0000op\u0003\u001a\r\u0000pq\u0005\u0006\u0000\u0000qr\u0003\u0016\u000b"+
		"\u0000rs\u0006\u0001\uffff\uffff\u0000sy\u0001\u0000\u0000\u0000tu\u0003"+
		"\u0004\u0002\u0000uv\u0005\u0004\u0000\u0000vw\u0006\u0001\uffff\uffff"+
		"\u0000wy\u0001\u0000\u0000\u0000xM\u0001\u0000\u0000\u0000xR\u0001\u0000"+
		"\u0000\u0000xW\u0001\u0000\u0000\u0000x\\\u0001\u0000\u0000\u0000xb\u0001"+
		"\u0000\u0000\u0000xm\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000"+
		"y\u0003\u0001\u0000\u0000\u0000z{\u0005(\u0000\u0000{|\u0005\u0005\u0000"+
		"\u0000|}\u0005\u0006\u0000\u0000}\u0085\u0006\u0002\uffff\uffff\u0000"+
		"~\u007f\u0005(\u0000\u0000\u007f\u0080\u0005\u0005\u0000\u0000\u0080\u0081"+
		"\u0003,\u0016\u0000\u0081\u0082\u0005\u0006\u0000\u0000\u0082\u0083\u0006"+
		"\u0002\uffff\uffff\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084z\u0001"+
		"\u0000\u0000\u0000\u0084~\u0001\u0000\u0000\u0000\u0085\u0005\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000\u0087\u0088\u0006\u0003\uffff"+
		"\uffff\u0000\u0088\u008d\u0001\u0000\u0000\u0000\u0089\u008a\u0003\f\u0006"+
		"\u0000\u008a\u008b\u0006\u0003\uffff\uffff\u0000\u008b\u008d\u0001\u0000"+
		"\u0000\u0000\u008c\u0086\u0001\u0000\u0000\u0000\u008c\u0089\u0001\u0000"+
		"\u0000\u0000\u008d\u0007\u0001\u0000\u0000\u0000\u008e\u008f\u00034\u001a"+
		"\u0000\u008f\u0094\u0005(\u0000\u0000\u0090\u0091\u0005\f\u0000\u0000"+
		"\u0091\u0093\u0005(\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093"+
		"\u0096\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096"+
		"\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0004\u0000\u0000\u0098"+
		"\u0099\u0006\u0004\uffff\uffff\u0000\u0099\t\u0001\u0000\u0000\u0000\u009a"+
		"\u009c\u0003\b\u0004\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0006\u0005\uffff\uffff\u0000\u00a0\u000b\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u00032\u0019\u0000\u00a2\u00a3\u0005(\u0000\u0000\u00a3\u00a5\u0005"+
		"\u0005\u0000\u0000\u00a4\u00a6\u0003\u000e\u0007\u0000\u00a5\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005\u0006\u0000\u0000\u00a8\u00aa\u0005"+
		"\u0007\u0000\u0000\u00a9\u00ab\u0003\n\u0005\u0000\u00aa\u00a9\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ae\u0003\u0018\f\u0000\u00ad\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005\b\u0000\u0000\u00b0\u00b1\u0006\u0006\uffff\uffff"+
		"\u0000\u00b1\r\u0001\u0000\u0000\u0000\u00b2\u00b7\u0003\u0010\b\u0000"+
		"\u00b3\u00b4\u0005\f\u0000\u0000\u00b4\u00b6\u0003\u0010\b\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8"+
		"\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0006\u0007\uffff\uffff\u0000\u00bb\u000f\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u00034\u001a\u0000\u00bd\u00be\u0005(\u0000\u0000\u00be\u00bf"+
		"\u0006\b\uffff\uffff\u0000\u00bf\u0011\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0003\u0014\n\u0000\u00c1\u00c7\u0005\u0004\u0000\u0000\u00c2\u00c3\u0003"+
		"\u0014\n\u0000\u00c3\u00c4\u0005\u0004\u0000\u0000\u00c4\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c2\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0006\t\uffff\uffff\u0000\u00cb\u0013\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u00034\u001a\u0000\u00cd\u00d2\u0005(\u0000\u0000"+
		"\u00ce\u00cf\u0005\f\u0000\u0000\u00cf\u00d1\u0005(\u0000\u0000\u00d0"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0006\n\uffff\uffff\u0000\u00d6\u0015\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d9\u0005\u0007\u0000\u0000\u00d8\u00da\u0003\u0018\f\u0000\u00d9\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\b\u0000\u0000\u00dc\u00e1\u0006"+
		"\u000b\uffff\uffff\u0000\u00dd\u00de\u0003\u0002\u0001\u0000\u00de\u00df"+
		"\u0006\u000b\uffff\uffff\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0"+
		"\u00d7\u0001\u0000\u0000\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000\u00e1"+
		"\u0017\u0001\u0000\u0000\u0000\u00e2\u00e4\u0003\u0002\u0001\u0000\u00e3"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0006\f\uffff\uffff\u0000\u00e8"+
		"\u0019\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003\u001c\u000e\u0000\u00ea"+
		"\u00eb\u0006\r\uffff\uffff\u0000\u00eb\u001b\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0003\u001e\u000f\u0000\u00ed\u00f4\u0006\u000e\uffff\uffff\u0000"+
		"\u00ee\u00ef\u0005\u001a\u0000\u0000\u00ef\u00f0\u0003\u001e\u000f\u0000"+
		"\u00f0\u00f1\u0006\u000e\uffff\uffff\u0000\u00f1\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f2\u00ee\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u001d\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0003 \u0010\u0000\u00f8\u00ff\u0006\u000f\uffff\uffff"+
		"\u0000\u00f9\u00fa\u0005\u0019\u0000\u0000\u00fa\u00fb\u0003 \u0010\u0000"+
		"\u00fb\u00fc\u0006\u000f\uffff\uffff\u0000\u00fc\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fd\u00f9\u0001\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000"+
		"\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000"+
		"\u0000\u0100\u001f\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0003\"\u0011\u0000\u0103\u010a\u0006\u0010\uffff\uffff"+
		"\u0000\u0104\u0105\u0007\u0000\u0000\u0000\u0105\u0106\u0003\"\u0011\u0000"+
		"\u0106\u0107\u0006\u0010\uffff\uffff\u0000\u0107\u0109\u0001\u0000\u0000"+
		"\u0000\u0108\u0104\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000\u0000"+
		"\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000"+
		"\u0000\u010b!\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0003$\u0012\u0000\u010e\u0115\u0006\u0011\uffff\uffff\u0000"+
		"\u010f\u0110\u0007\u0001\u0000\u0000\u0110\u0111\u0003$\u0012\u0000\u0111"+
		"\u0112\u0006\u0011\uffff\uffff\u0000\u0112\u0114\u0001\u0000\u0000\u0000"+
		"\u0113\u010f\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000"+
		"\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000"+
		"\u0116#\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0003&\u0013\u0000\u0119\u0120\u0006\u0012\uffff\uffff\u0000\u011a"+
		"\u011b\u0007\u0002\u0000\u0000\u011b\u011c\u0003&\u0013\u0000\u011c\u011d"+
		"\u0006\u0012\uffff\uffff\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e"+
		"\u011a\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000\u0000\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		"%\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0005\u0005\u0000\u0000\u0124\u0125\u00036\u001b\u0000\u0125\u0126\u0005"+
		"\u0006\u0000\u0000\u0126\u0127\u0003&\u0013\u0000\u0127\u0128\u0006\u0013"+
		"\uffff\uffff\u0000\u0128\u0135\u0001\u0000\u0000\u0000\u0129\u012a\u0005"+
		"\u000f\u0000\u0000\u012a\u012b\u0003&\u0013\u0000\u012b\u012c\u0006\u0013"+
		"\uffff\uffff\u0000\u012c\u0135\u0001\u0000\u0000\u0000\u012d\u012e\u0005"+
		"\u001b\u0000\u0000\u012e\u012f\u0003&\u0013\u0000\u012f\u0130\u0006\u0013"+
		"\uffff\uffff\u0000\u0130\u0135\u0001\u0000\u0000\u0000\u0131\u0132\u0003"+
		"(\u0014\u0000\u0132\u0133\u0006\u0013\uffff\uffff\u0000\u0133\u0135\u0001"+
		"\u0000\u0000\u0000\u0134\u0123\u0001\u0000\u0000\u0000\u0134\u0129\u0001"+
		"\u0000\u0000\u0000\u0134\u012d\u0001\u0000\u0000\u0000\u0134\u0131\u0001"+
		"\u0000\u0000\u0000\u0135\'\u0001\u0000\u0000\u0000\u0136\u0137\u0005\u0005"+
		"\u0000\u0000\u0137\u0138\u0003\u001a\r\u0000\u0138\u0139\u0005\u0006\u0000"+
		"\u0000\u0139\u013a\u0006\u0014\uffff\uffff\u0000\u013a\u0148\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0005)\u0000\u0000\u013c\u0148\u0006\u0014\uffff"+
		"\uffff\u0000\u013d\u013e\u0005*\u0000\u0000\u013e\u0148\u0006\u0014\uffff"+
		"\uffff\u0000\u013f\u0140\u0005+\u0000\u0000\u0140\u0148\u0006\u0014\uffff"+
		"\uffff\u0000\u0141\u0142\u00030\u0018\u0000\u0142\u0143\u0006\u0014\uffff"+
		"\uffff\u0000\u0143\u0148\u0001\u0000\u0000\u0000\u0144\u0145\u0003*\u0015"+
		"\u0000\u0145\u0146\u0006\u0014\uffff\uffff\u0000\u0146\u0148\u0001\u0000"+
		"\u0000\u0000\u0147\u0136\u0001\u0000\u0000\u0000\u0147\u013b\u0001\u0000"+
		"\u0000\u0000\u0147\u013d\u0001\u0000\u0000\u0000\u0147\u013f\u0001\u0000"+
		"\u0000\u0000\u0147\u0141\u0001\u0000\u0000\u0000\u0147\u0144\u0001\u0000"+
		"\u0000\u0000\u0148)\u0001\u0000\u0000\u0000\u0149\u014d\u0006\u0015\uffff"+
		"\uffff\u0000\u014a\u014b\u0005(\u0000\u0000\u014b\u014d\u0006\u0015\uffff"+
		"\uffff\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000"+
		"\u0000\u0000\u014d\u015a\u0001\u0000\u0000\u0000\u014e\u014f\n\u0003\u0000"+
		"\u0000\u014f\u0150\u0005\t\u0000\u0000\u0150\u0151\u0003\u001a\r\u0000"+
		"\u0151\u0152\u0005\n\u0000\u0000\u0152\u0153\u0006\u0015\uffff\uffff\u0000"+
		"\u0153\u0159\u0001\u0000\u0000\u0000\u0154\u0155\n\u0002\u0000\u0000\u0155"+
		"\u0156\u0005\u000b\u0000\u0000\u0156\u0157\u0005(\u0000\u0000\u0157\u0159"+
		"\u0006\u0015\uffff\uffff\u0000\u0158\u014e\u0001\u0000\u0000\u0000\u0158"+
		"\u0154\u0001\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000\u015a"+
		"\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b"+
		"+\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015d\u0162"+
		"\u0003\u001a\r\u0000\u015e\u015f\u0005\f\u0000\u0000\u015f\u0161\u0003"+
		"\u001a\r\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000"+
		"\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000"+
		"\u0000\u0000\u0165\u0166\u0006\u0016\uffff\uffff\u0000\u0166-\u0001\u0000"+
		"\u0000\u0000\u0167\u016c\u0003*\u0015\u0000\u0168\u0169\u0005\f\u0000"+
		"\u0000\u0169\u016b\u0003*\u0015\u0000\u016a\u0168\u0001\u0000\u0000\u0000"+
		"\u016b\u016e\u0001\u0000\u0000\u0000\u016c\u016a\u0001\u0000\u0000\u0000"+
		"\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016f\u0001\u0000\u0000\u0000"+
		"\u016e\u016c\u0001\u0000\u0000\u0000\u016f\u0170\u0006\u0017\uffff\uffff"+
		"\u0000\u0170/\u0001\u0000\u0000\u0000\u0171\u0172\u0005(\u0000\u0000\u0172"+
		"\u0173\u0005\u0005\u0000\u0000\u0173\u0174\u0005\u0006\u0000\u0000\u0174"+
		"\u017c\u0006\u0018\uffff\uffff\u0000\u0175\u0176\u0005(\u0000\u0000\u0176"+
		"\u0177\u0005\u0005\u0000\u0000\u0177\u0178\u0003,\u0016\u0000\u0178\u0179"+
		"\u0005\u0006\u0000\u0000\u0179\u017a\u0006\u0018\uffff\uffff\u0000\u017a"+
		"\u017c\u0001\u0000\u0000\u0000\u017b\u0171\u0001\u0000\u0000\u0000\u017b"+
		"\u0175\u0001\u0000\u0000\u0000\u017c1\u0001\u0000\u0000\u0000\u017d\u017e"+
		"\u00036\u001b\u0000\u017e\u017f\u0006\u0019\uffff\uffff\u0000\u017f\u0183"+
		"\u0001\u0000\u0000\u0000\u0180\u0181\u0005&\u0000\u0000\u0181\u0183\u0006"+
		"\u0019\uffff\uffff\u0000\u0182\u017d\u0001\u0000\u0000\u0000\u0182\u0180"+
		"\u0001\u0000\u0000\u0000\u01833\u0001\u0000\u0000\u0000\u0184\u0185\u0006"+
		"\u001a\uffff\uffff\u0000\u0185\u0186\u00036\u001b\u0000\u0186\u0187\u0006"+
		"\u001a\uffff\uffff\u0000\u0187\u018f\u0001\u0000\u0000\u0000\u0188\u0189"+
		"\u0005\"\u0000\u0000\u0189\u018a\u0005\u0007\u0000\u0000\u018a\u018b\u0003"+
		"\u0012\t\u0000\u018b\u018c\u0005\b\u0000\u0000\u018c\u018d\u0006\u001a"+
		"\uffff\uffff\u0000\u018d\u018f\u0001\u0000\u0000\u0000\u018e\u0184\u0001"+
		"\u0000\u0000\u0000\u018e\u0188\u0001\u0000\u0000\u0000\u018f\u0197\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\n\u0001\u0000\u0000\u0191\u0192\u0005\t"+
		"\u0000\u0000\u0192\u0193\u0005)\u0000\u0000\u0193\u0194\u0005\n\u0000"+
		"\u0000\u0194\u0196\u0006\u001a\uffff\uffff\u0000\u0195\u0190\u0001\u0000"+
		"\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000"+
		"\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u01985\u0001\u0000\u0000"+
		"\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u019b\u0005#\u0000\u0000"+
		"\u019b\u01a1\u0006\u001b\uffff\uffff\u0000\u019c\u019d\u0005$\u0000\u0000"+
		"\u019d\u01a1\u0006\u001b\uffff\uffff\u0000\u019e\u019f\u0005%\u0000\u0000"+
		"\u019f\u01a1\u0006\u001b\uffff\uffff\u0000\u01a0\u019a\u0001\u0000\u0000"+
		"\u0000\u01a0\u019c\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000"+
		"\u0000\u01a17\u0001\u0000\u0000\u0000#;DGix\u0084\u008c\u0094\u009d\u00a5"+
		"\u00aa\u00ad\u00b7\u00c7\u00d2\u00d9\u00e0\u00e5\u00f4\u00ff\u010a\u0115"+
		"\u0120\u0134\u0147\u014c\u0158\u015a\u0162\u016c\u017b\u0182\u018e\u0197"+
		"\u01a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}