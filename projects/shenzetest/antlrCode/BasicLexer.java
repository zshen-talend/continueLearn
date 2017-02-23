// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\tdp_trunk1\\shenzetest\\BasicLexer.g 2011-08-26 18:21:33

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BasicLexer extends Lexer {
    public static final int EOF=-1;
    public static final int DIGIT=4;
    public static final int UpperCasedLetter=5;
    public static final int LETTER_ASCII=6;
    public static final int LETTER=7;
    public static final int SYMBOL_ASCII=8;
    public static final int CHAR_CJK=9;
    public static final int INT=10;
    public static final int ALPHANUM=11;
    public static final int CAPWORD=12;
    public static final int WORD=13;
    public static final int DECIMAL=14;
    public static final int FRACTION=15;
    public static final int CURRENCY=16;
    public static final int ROMAN_NUMERAL=17;
    public static final int CHAR_IGNORED=18;
    public static final int UNDEFINED=19;

    // delegates
    // delegators

    public BasicLexer() {;} 
    public BasicLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BasicLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\tdp_trunk1\\shenzetest\\BasicLexer.g"; }

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:5:3: ( '0' .. '9' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:6:3: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "UpperCasedLetter"
    public final void mUpperCasedLetter() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:11:3: ( 'A' .. 'Z' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:12:3: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UpperCasedLetter"

    // $ANTLR start "LETTER_ASCII"
    public final void mLETTER_ASCII() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:17:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER_ASCII"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:24:3: ( LETTER_ASCII | '\\u00a0' .. '\\u00ff' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SYMBOL_ASCII"
    public final void mSYMBOL_ASCII() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:31:3: ( '#' .. '&' | '*' | '+' | '-' | '/' | '<' .. '>' | '@' | '\\u005b' .. '\\u0060' | '\\u007b' .. '\\u007e' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
            {
            if ( (input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||(input.LA(1)>='<' && input.LA(1)<='>')||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<='`')||(input.LA(1)>='{' && input.LA(1)<='~') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SYMBOL_ASCII"

    // $ANTLR start "CHAR_CJK"
    public final void mCHAR_CJK() throws RecognitionException {
        try {
            int _type = CHAR_CJK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:39:3: ( ( '\\u4e00' .. '\\u9faf' )+ )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:40:3: ( '\\u4e00' .. '\\u9faf' )+
            {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:40:3: ( '\\u4e00' .. '\\u9faf' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u4E00' && LA1_0<='\u9FAF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:40:4: '\\u4e00' .. '\\u9faf'
            	    {
            	    matchRange('\u4E00','\u9FAF'); 

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
    // $ANTLR end "CHAR_CJK"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:44:3: ( DIGIT ( DIGIT )* )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:45:3: DIGIT ( DIGIT )*
            {
            mDIGIT(); 
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:45:9: ( DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:45:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "ALPHANUM"
    public final void mALPHANUM() throws RecognitionException {
        try {
            int _type = ALPHANUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:49:3: ( ( LETTER )+ DIGIT ( DIGIT | LETTER )* | ( DIGIT )+ LETTER ( DIGIT | LETTER )* )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='A' && LA7_0<='Z')||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00A0' && LA7_0<='\u00FF')) ) {
                alt7=1;
            }
            else if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:50:3: ( LETTER )+ DIGIT ( DIGIT | LETTER )*
                    {
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:50:3: ( LETTER )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00A0' && LA3_0<='\u00FF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:50:3: LETTER
                    	    {
                    	    mLETTER(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    mDIGIT(); 
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:50:17: ( DIGIT | LETTER )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00A0' && LA4_0<='\u00FF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:51:5: ( DIGIT )+ LETTER ( DIGIT | LETTER )*
                    {
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:51:5: ( DIGIT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:51:5: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    mLETTER(); 
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:51:19: ( DIGIT | LETTER )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00A0' && LA6_0<='\u00FF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALPHANUM"

    // $ANTLR start "CAPWORD"
    public final void mCAPWORD() throws RecognitionException {
        try {
            int _type = CAPWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:55:3: ( UpperCasedLetter ( UpperCasedLetter )* )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:56:3: UpperCasedLetter ( UpperCasedLetter )*
            {
            mUpperCasedLetter(); 
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:56:20: ( UpperCasedLetter )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='A' && LA8_0<='Z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:56:20: UpperCasedLetter
            	    {
            	    mUpperCasedLetter(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CAPWORD"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:60:3: ( ( LETTER )+ ( ( '-' | '.' ) ( LETTER )+ )* ( '.' )? )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:3: ( LETTER )+ ( ( '-' | '.' ) ( LETTER )+ )* ( '.' )?
            {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:3: ( LETTER )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='A' && LA9_0<='Z')||(LA9_0>='a' && LA9_0<='z')||(LA9_0>='\u00A0' && LA9_0<='\u00FF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:3: LETTER
            	    {
            	    mLETTER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:11: ( ( '-' | '.' ) ( LETTER )+ )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='.') ) {
                    int LA11_1 = input.LA(2);

                    if ( ((LA11_1>='A' && LA11_1<='Z')||(LA11_1>='a' && LA11_1<='z')||(LA11_1>='\u00A0' && LA11_1<='\u00FF')) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0=='-') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:12: ( '-' | '.' ) ( LETTER )+
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:22: ( LETTER )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( ((LA10_0>='A' && LA10_0<='Z')||(LA10_0>='a' && LA10_0<='z')||(LA10_0>='\u00A0' && LA10_0<='\u00FF')) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:22: LETTER
            	    	    {
            	    	    mLETTER(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:32: ( '.' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='.') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:61:32: '.'
                    {
                    match('.'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            int _type = DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:65:3: ( ( DIGIT )* '.' ( DIGIT )+ )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:66:3: ( DIGIT )* '.' ( DIGIT )+
            {
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:66:3: ( DIGIT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:66:3: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match('.'); 
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:66:14: ( DIGIT )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:66:14: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "FRACTION"
    public final void mFRACTION() throws RecognitionException {
        try {
            int _type = FRACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:70:3: ( ( DIGIT )+ '/' ( DIGIT )+ | '\\u2153' .. '\\u215f' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                alt17=1;
            }
            else if ( ((LA17_0>='\u2153' && LA17_0<='\u215F')) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:71:3: ( DIGIT )+ '/' ( DIGIT )+
                    {
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:71:3: ( DIGIT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:71:3: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    match('/'); 
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:71:14: ( DIGIT )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:71:14: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:72:5: '\\u2153' .. '\\u215f'
                    {
                    matchRange('\u2153','\u215F'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FRACTION"

    // $ANTLR start "CURRENCY"
    public final void mCURRENCY() throws RecognitionException {
        try {
            int _type = CURRENCY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:76:3: ( '\\u0024' | '\\u00a2' .. '\\u00a5' | '\\u20a0' .. '\\u20cf' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20CF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CURRENCY"

    // $ANTLR start "ROMAN_NUMERAL"
    public final void mROMAN_NUMERAL() throws RecognitionException {
        try {
            int _type = ROMAN_NUMERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:83:3: ( '\\u2160' .. '\\u2182' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:84:3: '\\u2160' .. '\\u2182'
            {
            matchRange('\u2160','\u2182'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROMAN_NUMERAL"

    // $ANTLR start "CHAR_IGNORED"
    public final void mCHAR_IGNORED() throws RecognitionException {
        try {
            int _type = CHAR_IGNORED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:88:3: ( '.' | ',' | ':' | ';' | '!' | '?' | '\"' | '\\'' | '(' | ')' )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
            {
            if ( (input.LA(1)>='!' && input.LA(1)<='\"')||(input.LA(1)>='\'' && input.LA(1)<=')')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1)>=':' && input.LA(1)<=';')||input.LA(1)=='?' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_IGNORED"

    // $ANTLR start "UNDEFINED"
    public final void mUNDEFINED() throws RecognitionException {
        try {
            int _type = UNDEFINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:102:3: ( SYMBOL_ASCII ( SYMBOL_ASCII | CHAR_IGNORED )* )
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:103:3: SYMBOL_ASCII ( SYMBOL_ASCII | CHAR_IGNORED )*
            {
            mSYMBOL_ASCII(); 
            // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:103:16: ( SYMBOL_ASCII | CHAR_IGNORED )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='!' && LA18_0<='/')||(LA18_0>=':' && LA18_0<='@')||(LA18_0>='[' && LA18_0<='`')||(LA18_0>='{' && LA18_0<='~')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:
            	    {
            	    if ( (input.LA(1)>='!' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<='`')||(input.LA(1)>='{' && input.LA(1)<='~') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDEFINED"

    public void mTokens() throws RecognitionException {
        // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:8: ( CHAR_CJK | INT | ALPHANUM | CAPWORD | WORD | DECIMAL | FRACTION | CURRENCY | ROMAN_NUMERAL | CHAR_IGNORED | UNDEFINED )
        int alt19=11;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:10: CHAR_CJK
                {
                mCHAR_CJK(); 

                }
                break;
            case 2 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:19: INT
                {
                mINT(); 

                }
                break;
            case 3 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:23: ALPHANUM
                {
                mALPHANUM(); 

                }
                break;
            case 4 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:32: CAPWORD
                {
                mCAPWORD(); 

                }
                break;
            case 5 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:40: WORD
                {
                mWORD(); 

                }
                break;
            case 6 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:45: DECIMAL
                {
                mDECIMAL(); 

                }
                break;
            case 7 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:53: FRACTION
                {
                mFRACTION(); 

                }
                break;
            case 8 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:62: CURRENCY
                {
                mCURRENCY(); 

                }
                break;
            case 9 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:71: ROMAN_NUMERAL
                {
                mROMAN_NUMERAL(); 

                }
                break;
            case 10 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:85: CHAR_IGNORED
                {
                mCHAR_IGNORED(); 

                }
                break;
            case 11 :
                // E:\\tdp_trunk1\\shenzetest\\BasicLexer.g:1:98: UNDEFINED
                {
                mUNDEFINED(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\2\uffff\1\15\1\21\1\23\1\12\1\uffff\1\23\1\13\5\uffff\1\15\3\uffff"+
        "\1\21\1\uffff";
    static final String DFA19_eofS =
        "\24\uffff";
    static final String DFA19_minS =
        "\1\41\1\uffff\1\56\1\55\2\60\1\uffff\1\60\1\41\5\uffff\1\56\3\uffff"+
        "\1\55\1\uffff";
    static final String DFA19_maxS =
        "\1\u9faf\1\uffff\3\u00ff\1\71\1\uffff\1\u00ff\1\176\5\uffff\1\u00ff"+
        "\3\uffff\1\u00ff\1\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\4\uffff\1\7\2\uffff\1\11\1\12\1\10\1\13\1\2\1\uffff"+
        "\1\3\1\6\1\4\1\uffff\1\5";
    static final String DFA19_specialS =
        "\24\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\12\1\14\1\10\2\14\3\12\2\14\1\12\1\14\1\5\1\14\12\2\2\12"+
            "\3\14\1\12\1\14\32\3\6\14\32\7\4\14\41\uffff\2\7\4\4\132\7\u1fa0"+
            "\uffff\60\13\u0083\uffff\15\6\43\11\u2c7d\uffff\u51b0\1",
            "",
            "\1\20\1\6\12\16\7\uffff\32\17\6\uffff\32\17\45\uffff\140\17",
            "\2\23\1\uffff\12\17\7\uffff\32\22\6\uffff\32\7\45\uffff\140"+
            "\7",
            "\12\17\7\uffff\32\7\6\uffff\32\7\45\uffff\140\7",
            "\12\20",
            "",
            "\12\17\7\uffff\32\7\6\uffff\32\7\45\uffff\140\7",
            "\17\14\12\uffff\7\14\32\uffff\6\14\32\uffff\4\14",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\6\12\16\7\uffff\32\17\6\uffff\32\17\45\uffff\140\17",
            "",
            "",
            "",
            "\2\23\1\uffff\12\17\7\uffff\32\22\6\uffff\32\7\45\uffff\140"+
            "\7",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( CHAR_CJK | INT | ALPHANUM | CAPWORD | WORD | DECIMAL | FRACTION | CURRENCY | ROMAN_NUMERAL | CHAR_IGNORED | UNDEFINED );";
        }
    }
 

}