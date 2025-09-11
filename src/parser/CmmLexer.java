// Generated from src/parser/Cmm.g4 by ANTLR 4.13.2
package parser;

	import ast.*;
	import ast.types.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		COMMENT=18, INT_CONSTANT=19, REAL_CONSTANT=20, ID=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "WS", "COMMENT", 
			"INT_CONSTANT", "REAL_CONSTANT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'{'", "'}'", "';'", "'int'", 
			"'double'", "'write'", "'='", "'*'", "'/'", "'%'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "WS", "COMMENT", "INT_CONSTANT", "REAL_CONSTANT", 
			"ID"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015\u0082\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0004\u0010^\b\u0010\u000b\u0010\f\u0010_\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"h\b\u0011\n\u0011\f\u0011k\t\u0011\u0001\u0011\u0003\u0011n\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0004\u0012s\b\u0012\u000b\u0012\f\u0012"+
		"t\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013z\b\u0013\u000b\u0013"+
		"\f\u0013{\u0001\u0014\u0004\u0014\u007f\b\u0014\u000b\u0014\f\u0014\u0080"+
		"\u0001i\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014"+
		")\u0015\u0001\u0000\u0004\u0003\u0000\t\n\r\r  \u0002\u0001\n\n\r\r\u0001"+
		"\u000009\u0002\u0000AZaz\u0086\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u00030"+
		"\u0001\u0000\u0000\u0000\u00055\u0001\u0000\u0000\u0000\u00077\u0001\u0000"+
		"\u0000\u0000\t9\u0001\u0000\u0000\u0000\u000b;\u0001\u0000\u0000\u0000"+
		"\r=\u0001\u0000\u0000\u0000\u000f?\u0001\u0000\u0000\u0000\u0011C\u0001"+
		"\u0000\u0000\u0000\u0013J\u0001\u0000\u0000\u0000\u0015P\u0001\u0000\u0000"+
		"\u0000\u0017R\u0001\u0000\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001b"+
		"V\u0001\u0000\u0000\u0000\u001dX\u0001\u0000\u0000\u0000\u001fZ\u0001"+
		"\u0000\u0000\u0000!]\u0001\u0000\u0000\u0000#c\u0001\u0000\u0000\u0000"+
		"%r\u0001\u0000\u0000\u0000\'v\u0001\u0000\u0000\u0000)~\u0001\u0000\u0000"+
		"\u0000+,\u0005v\u0000\u0000,-\u0005o\u0000\u0000-.\u0005i\u0000\u0000"+
		"./\u0005d\u0000\u0000/\u0002\u0001\u0000\u0000\u000001\u0005m\u0000\u0000"+
		"12\u0005a\u0000\u000023\u0005i\u0000\u000034\u0005n\u0000\u00004\u0004"+
		"\u0001\u0000\u0000\u000056\u0005(\u0000\u00006\u0006\u0001\u0000\u0000"+
		"\u000078\u0005)\u0000\u00008\b\u0001\u0000\u0000\u00009:\u0005{\u0000"+
		"\u0000:\n\u0001\u0000\u0000\u0000;<\u0005}\u0000\u0000<\f\u0001\u0000"+
		"\u0000\u0000=>\u0005;\u0000\u0000>\u000e\u0001\u0000\u0000\u0000?@\u0005"+
		"i\u0000\u0000@A\u0005n\u0000\u0000AB\u0005t\u0000\u0000B\u0010\u0001\u0000"+
		"\u0000\u0000CD\u0005d\u0000\u0000DE\u0005o\u0000\u0000EF\u0005u\u0000"+
		"\u0000FG\u0005b\u0000\u0000GH\u0005l\u0000\u0000HI\u0005e\u0000\u0000"+
		"I\u0012\u0001\u0000\u0000\u0000JK\u0005w\u0000\u0000KL\u0005r\u0000\u0000"+
		"LM\u0005i\u0000\u0000MN\u0005t\u0000\u0000NO\u0005e\u0000\u0000O\u0014"+
		"\u0001\u0000\u0000\u0000PQ\u0005=\u0000\u0000Q\u0016\u0001\u0000\u0000"+
		"\u0000RS\u0005*\u0000\u0000S\u0018\u0001\u0000\u0000\u0000TU\u0005/\u0000"+
		"\u0000U\u001a\u0001\u0000\u0000\u0000VW\u0005%\u0000\u0000W\u001c\u0001"+
		"\u0000\u0000\u0000XY\u0005+\u0000\u0000Y\u001e\u0001\u0000\u0000\u0000"+
		"Z[\u0005-\u0000\u0000[ \u0001\u0000\u0000\u0000\\^\u0007\u0000\u0000\u0000"+
		"]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0006\u0010"+
		"\u0000\u0000b\"\u0001\u0000\u0000\u0000cd\u0005/\u0000\u0000de\u0005/"+
		"\u0000\u0000ei\u0001\u0000\u0000\u0000fh\t\u0000\u0000\u0000gf\u0001\u0000"+
		"\u0000\u0000hk\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000"+
		"ln\u0007\u0001\u0000\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000op\u0006\u0011\u0000\u0000p$\u0001\u0000\u0000\u0000qs\u0007\u0002"+
		"\u0000\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u&\u0001\u0000\u0000\u0000"+
		"vw\u0003%\u0012\u0000wy\u0005.\u0000\u0000xz\u0007\u0002\u0000\u0000y"+
		"x\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|(\u0001\u0000\u0000\u0000}\u007f\u0007"+
		"\u0003\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081*\u0001\u0000\u0000\u0000\u0007\u0000_imt{\u0080\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}