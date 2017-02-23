// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\tdp_trunk1\\shenzetest\\Combined.g 2011-08-26 18:21:31

package org.talend.dataquality.parser.generate;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CombinedLexer extends Lexer {
    public static final int EOF=-1;
    public static final int WHITESPACE=4;
    public static final int CHAR_IGNORED=5;
    public static final int CURRENCY=6;
    public static final int ROMAN_NUMERAL=7;
    public static final int DECIMAL=8;
    public static final int FRACTION=9;
    public static final int CHAR_CJK=10;
    public static final int INT=11;
    public static final int CAPWORD=12;
    public static final int WORD=13;
    public static final int ALPHANUM=14;
    public static final int UNDEFINED=15;
    public static final int DIGIT=16;
    public static final int UpperCasedLetter=17;
    public static final int LETTER_ASCII=18;
    public static final int LETTER=19;
    public static final int SYMBOL_ASCII=20;
    public static final int Tokens=21;

    /** Override this method to change where error messages go */
    public void emitErrorMessage(String msg) {
        org.talend.dataquality.parser.util.RecognitionError.set(false, msg);
        // System.err.println(msg);
    }


    // delegates
    public Combined_BasicLexer gBasicLexer;
    // delegators

    public CombinedLexer() {;} 
    public CombinedLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CombinedLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        gBasicLexer = new Combined_BasicLexer(input, state, this);
    }
    public String getGrammarFileName() { return "E:\\tdp_trunk1\\shenzetest\\Combined.g"; }

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\tdp_trunk1\\shenzetest\\Combined.g:47:3: ( ' ' | '\\n' | '\\r' | '\\t' | '\\f' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt1=1;
                }
                break;
            case '\n':
                {
                alt1=2;
                }
                break;
            case '\r':
                {
                alt1=3;
                }
                break;
            case '\t':
                {
                alt1=4;
                }
                break;
            case '\f':
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // E:\\tdp_trunk1\\shenzetest\\Combined.g:48:3: ' '
                    {
                    match(' '); 

                          _channel = HIDDEN;
                         

                    }
                    break;
                case 2 :
                    // E:\\tdp_trunk1\\shenzetest\\Combined.g:52:5: '\\n'
                    {
                    match('\n'); 

                             _channel = HIDDEN;
                            

                    }
                    break;
                case 3 :
                    // E:\\tdp_trunk1\\shenzetest\\Combined.g:56:5: '\\r'
                    {
                    match('\r'); 

                             _channel = HIDDEN;
                            

                    }
                    break;
                case 4 :
                    // E:\\tdp_trunk1\\shenzetest\\Combined.g:60:5: '\\t'
                    {
                    match('\t'); 

                             _channel = HIDDEN;
                            

                    }
                    break;
                case 5 :
                    // E:\\tdp_trunk1\\shenzetest\\Combined.g:64:5: '\\f'
                    {
                    match('\f'); 

                             _channel = HIDDEN;
                            

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // E:\\tdp_trunk1\\shenzetest\\Combined.g:1:8: ( WHITESPACE | BasicLexer. Tokens )
        int alt2=2;
        int LA2_0 = input.LA(1);

        if ( ((LA2_0>='\t' && LA2_0<='\n')||(LA2_0>='\f' && LA2_0<='\r')||LA2_0==' ') ) {
            alt2=1;
        }
        else if ( ((LA2_0>='!' && LA2_0<='~')||(LA2_0>='\u00A0' && LA2_0<='\u00FF')||(LA2_0>='\u20A0' && LA2_0<='\u20CF')||(LA2_0>='\u2153' && LA2_0<='\u2182')||(LA2_0>='\u4E00' && LA2_0<='\u9FAF')) ) {
            alt2=2;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("", 2, 0, input);

            throw nvae;
        }
        switch (alt2) {
            case 1 :
                // E:\\tdp_trunk1\\shenzetest\\Combined.g:1:10: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 2 :
                // E:\\tdp_trunk1\\shenzetest\\Combined.g:1:21: BasicLexer. Tokens
                {
                gBasicLexer.mTokens(); 

                }
                break;

        }

    }


 

}