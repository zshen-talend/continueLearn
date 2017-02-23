// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g 2011-08-26 18:21:42

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class thecalcLexer extends Lexer {
    public static final int EOF=-1;
    public static final int PLUS=4;
    public static final int SEMI=5;
    public static final int JKLJ=6;
    public static final int STAR=7;
    public static final int INT=8;
    public static final int WS=9;
    public static final int LPAREN=10;
    public static final int RPAREN=11;
    public static final int DIGIT=12;

    // delegates
    // delegators

    public thecalcLexer() {;} 
    public thecalcLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public thecalcLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g"; }

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:16:4: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:16:6: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _ttype = Token.SKIP; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:23:7: ( '(' )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:23:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:26:7: ( ')' )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:26:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:29:5: ( '*' )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:29:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:32:5: ( '+' )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:32:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:35:5: ( ';' )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:35:7: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:40:2: ( '0' .. '9' )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:40:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:43:5: ( ( DIGIT )+ )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:43:7: ( DIGIT )+
            {
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:43:7: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:43:8: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    public void mTokens() throws RecognitionException {
        // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:8: ( WS | LPAREN | RPAREN | STAR | PLUS | SEMI | INT )
        int alt2=7;
        switch ( input.LA(1) ) {
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt2=1;
            }
            break;
        case '(':
            {
            alt2=2;
            }
            break;
        case ')':
            {
            alt2=3;
            }
            break;
        case '*':
            {
            alt2=4;
            }
            break;
        case '+':
            {
            alt2=5;
            }
            break;
        case ';':
            {
            alt2=6;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt2=7;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 2, 0, input);

            throw nvae;
        }

        switch (alt2) {
            case 1 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:10: WS
                {
                mWS(); 

                }
                break;
            case 2 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:13: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 3 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:20: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 4 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:27: STAR
                {
                mSTAR(); 

                }
                break;
            case 5 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:32: PLUS
                {
                mPLUS(); 

                }
                break;
            case 6 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:37: SEMI
                {
                mSEMI(); 

                }
                break;
            case 7 :
                // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:1:42: INT
                {
                mINT(); 

                }
                break;

        }

    }


 

}