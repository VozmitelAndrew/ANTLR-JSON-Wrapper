// Generated from C:/Users/andre/IdeaProjects/LatTryFR/src/main/antlr4/Kotlin.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KotlinLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, INTERFACE=2, FUN=3, ID=4, WS=5, LBRACE=6, RBRACE=7, LPAREN=8, 
		RPAREN=9, COMMA=10, COLON=11, SEMICOLON=12, DOT=13, EQ=14, STRING=15, 
		MULTILINE_STRING=16, LINE_COMMENT=17, BLOCK_COMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CLASS", "INTERFACE", "FUN", "ID", "WS", "LBRACE", "RBRACE", "LPAREN", 
			"RPAREN", "COMMA", "COLON", "SEMICOLON", "DOT", "EQ", "STRING", "MULTILINE_STRING", 
			"LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'interface'", "'fun'", null, null, "'{'", "'}'", "'('", 
			"')'", "','", "':'", "';'", "'.'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS", "INTERFACE", "FUN", "ID", "WS", "LBRACE", "RBRACE", "LPAREN", 
			"RPAREN", "COMMA", "COLON", "SEMICOLON", "DOT", "EQ", "STRING", "MULTILINE_STRING", 
			"LINE_COMMENT", "BLOCK_COMMENT"
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


	public KotlinLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Kotlin.g4"; }

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
		"\u0004\u0000\u0012\u008f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003<\b\u0003"+
		"\n\u0003\f\u0003?\t\u0003\u0001\u0004\u0004\u0004B\b\u0004\u000b\u0004"+
		"\f\u0004C\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e^\b\u000e\n\u000e"+
		"\f\u000ea\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000fl\b"+
		"\u000f\n\u000f\f\u000fo\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010{\b\u0010\n\u0010\f\u0010~\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0086"+
		"\b\u0011\n\u0011\f\u0011\u0089\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0002m\u0087\u0000\u0012\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003"+
		"\u0000\t\n\r\r  \u0002\u0000\"\"\\\\\u0002\u0000\n\n\r\r\u0095\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0003"+
		"+\u0001\u0000\u0000\u0000\u00055\u0001\u0000\u0000\u0000\u00079\u0001"+
		"\u0000\u0000\u0000\tA\u0001\u0000\u0000\u0000\u000bG\u0001\u0000\u0000"+
		"\u0000\rI\u0001\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000\u0011"+
		"M\u0001\u0000\u0000\u0000\u0013O\u0001\u0000\u0000\u0000\u0015Q\u0001"+
		"\u0000\u0000\u0000\u0017S\u0001\u0000\u0000\u0000\u0019U\u0001\u0000\u0000"+
		"\u0000\u001bW\u0001\u0000\u0000\u0000\u001dY\u0001\u0000\u0000\u0000\u001f"+
		"f\u0001\u0000\u0000\u0000!v\u0001\u0000\u0000\u0000#\u0081\u0001\u0000"+
		"\u0000\u0000%&\u0005c\u0000\u0000&\'\u0005l\u0000\u0000\'(\u0005a\u0000"+
		"\u0000()\u0005s\u0000\u0000)*\u0005s\u0000\u0000*\u0002\u0001\u0000\u0000"+
		"\u0000+,\u0005i\u0000\u0000,-\u0005n\u0000\u0000-.\u0005t\u0000\u0000"+
		"./\u0005e\u0000\u0000/0\u0005r\u0000\u000001\u0005f\u0000\u000012\u0005"+
		"a\u0000\u000023\u0005c\u0000\u000034\u0005e\u0000\u00004\u0004\u0001\u0000"+
		"\u0000\u000056\u0005f\u0000\u000067\u0005u\u0000\u000078\u0005n\u0000"+
		"\u00008\u0006\u0001\u0000\u0000\u00009=\u0007\u0000\u0000\u0000:<\u0007"+
		"\u0001\u0000\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\b\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@B\u0007\u0002\u0000\u0000A@\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0006\u0004\u0000\u0000"+
		"F\n\u0001\u0000\u0000\u0000GH\u0005{\u0000\u0000H\f\u0001\u0000\u0000"+
		"\u0000IJ\u0005}\u0000\u0000J\u000e\u0001\u0000\u0000\u0000KL\u0005(\u0000"+
		"\u0000L\u0010\u0001\u0000\u0000\u0000MN\u0005)\u0000\u0000N\u0012\u0001"+
		"\u0000\u0000\u0000OP\u0005,\u0000\u0000P\u0014\u0001\u0000\u0000\u0000"+
		"QR\u0005:\u0000\u0000R\u0016\u0001\u0000\u0000\u0000ST\u0005;\u0000\u0000"+
		"T\u0018\u0001\u0000\u0000\u0000UV\u0005.\u0000\u0000V\u001a\u0001\u0000"+
		"\u0000\u0000WX\u0005=\u0000\u0000X\u001c\u0001\u0000\u0000\u0000Y_\u0005"+
		"\"\u0000\u0000Z^\b\u0003\u0000\u0000[\\\u0005\\\u0000\u0000\\^\t\u0000"+
		"\u0000\u0000]Z\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^a\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\"\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000de\u0006\u000e\u0000\u0000e\u001e\u0001\u0000"+
		"\u0000\u0000fg\u0005\'\u0000\u0000gh\u0005\'\u0000\u0000hi\u0005\'\u0000"+
		"\u0000im\u0001\u0000\u0000\u0000jl\t\u0000\u0000\u0000kj\u0001\u0000\u0000"+
		"\u0000lo\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000mk\u0001\u0000"+
		"\u0000\u0000np\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005"+
		"\'\u0000\u0000qr\u0005\'\u0000\u0000rs\u0005\'\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tu\u0006\u000f\u0000\u0000u \u0001\u0000\u0000\u0000vw\u0005"+
		"/\u0000\u0000wx\u0005/\u0000\u0000x|\u0001\u0000\u0000\u0000y{\b\u0004"+
		"\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0006\u0010\u0000\u0000\u0080"+
		"\"\u0001\u0000\u0000\u0000\u0081\u0082\u0005/\u0000\u0000\u0082\u0083"+
		"\u0005*\u0000\u0000\u0083\u0087\u0001\u0000\u0000\u0000\u0084\u0086\t"+
		"\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0005*\u0000\u0000\u008b\u008c\u0005/\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0006\u0011\u0000"+
		"\u0000\u008e$\u0001\u0000\u0000\u0000\b\u0000=C]_m|\u0087\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}