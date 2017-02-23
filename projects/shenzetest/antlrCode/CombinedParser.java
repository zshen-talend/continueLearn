// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\tdp_trunk1\\shenzetest\\Combined.g 2011-08-26 18:21:31

package org.talend.dataquality.parser.generate;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CombinedParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WHITESPACE", "CHAR_IGNORED", "CURRENCY", "ROMAN_NUMERAL", "DECIMAL", "FRACTION", "CHAR_CJK", "INT", "CAPWORD", "WORD", "ALPHANUM", "UNDEFINED", "DIGIT", "UpperCasedLetter", "LETTER_ASCII", "LETTER", "SYMBOL_ASCII"
    };
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

    // delegates
    public Combined_BasicParser gBasicParser;
    // delegators


        public CombinedParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CombinedParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gBasicParser = new Combined_BasicParser(input, state, this);         
        }
        

    public String[] getTokenNames() { return CombinedParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\tdp_trunk1\\shenzetest\\Combined.g"; }


    org.talend.dataquality.parser.util.Interpreter interp;

    public CombinedParser(TokenStream tokenStream,
            org.talend.dataquality.parser.util.Interpreter interp) {
        this(tokenStream);
        this.interp = interp;
        gBasicParser.setInterpreter(interp);
    }

    /** Override this method to change where error messages go */
    public void emitErrorMessage(String msg) {
        org.talend.dataquality.parser.util.RecognitionError.set(false, msg);
        // System.err.println(msg);
    }



    // $ANTLR start "rule"
    // E:\\tdp_trunk1\\shenzetest\\Combined.g:38:1: rule : ( WHITESPACE | CHAR_IGNORED )* ( ( extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )* ;
    public final void rule() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\Combined.g:39:3: ( ( WHITESPACE | CHAR_IGNORED )* ( ( extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )* )
            // E:\\tdp_trunk1\\shenzetest\\Combined.g:40:3: ( WHITESPACE | CHAR_IGNORED )* ( ( extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )*
            {
            // E:\\tdp_trunk1\\shenzetest\\Combined.g:40:3: ( WHITESPACE | CHAR_IGNORED )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=WHITESPACE && LA1_0<=CHAR_IGNORED)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\Combined.g:
            	    {
            	    if ( (input.LA(1)>=WHITESPACE && input.LA(1)<=CHAR_IGNORED) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // E:\\tdp_trunk1\\shenzetest\\Combined.g:41:3: ( ( extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CURRENCY && LA4_0<=UNDEFINED)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\Combined.g:42:5: ( extended | basic ) ( WHITESPACE | CHAR_IGNORED )*
            	    {
            	    // E:\\tdp_trunk1\\shenzetest\\Combined.g:42:5: ( extended | basic )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( ((LA2_0>=CURRENCY && LA2_0<=CHAR_CJK)) ) {
            	        alt2=1;
            	    }
            	    else if ( ((LA2_0>=INT && LA2_0<=UNDEFINED)) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // E:\\tdp_trunk1\\shenzetest\\Combined.g:42:6: extended
            	            {
            	            pushFollow(FOLLOW_extended_in_rule74);
            	            extended();

            	            state._fsp--;


            	            }
            	            break;
            	        case 2 :
            	            // E:\\tdp_trunk1\\shenzetest\\Combined.g:42:17: basic
            	            {
            	            pushFollow(FOLLOW_basic_in_rule78);
            	            basic();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    // E:\\tdp_trunk1\\shenzetest\\Combined.g:43:5: ( WHITESPACE | CHAR_IGNORED )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>=WHITESPACE && LA3_0<=CHAR_IGNORED)) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // E:\\tdp_trunk1\\shenzetest\\Combined.g:
            	    	    {
            	    	    if ( (input.LA(1)>=WHITESPACE && input.LA(1)<=CHAR_IGNORED) ) {
            	    	        input.consume();
            	    	        state.errorRecovery=false;
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rule"

    // Delegated rules
    public Combined_BasicParser.fraction_return fraction() throws RecognitionException { return gBasicParser.fraction(); }
    public Combined_BasicParser.capword_return capword() throws RecognitionException { return gBasicParser.capword(); }
    public void separator() throws RecognitionException { gBasicParser.separator(); }
    public Combined_BasicParser.cjk_return cjk() throws RecognitionException { return gBasicParser.cjk(); }
    public Combined_BasicParser.word_return word() throws RecognitionException { return gBasicParser.word(); }
    public Combined_BasicParser.undefined_return undefined() throws RecognitionException { return gBasicParser.undefined(); }
    public void extended() throws RecognitionException { gBasicParser.extended(); }
    public Combined_BasicParser.integer_return integer() throws RecognitionException { return gBasicParser.integer(); }
    public Combined_BasicParser.roman_numeral_return roman_numeral() throws RecognitionException { return gBasicParser.roman_numeral(); }
    public Combined_BasicParser.currency_return currency() throws RecognitionException { return gBasicParser.currency(); }
    public Combined_BasicParser.decimal_return decimal() throws RecognitionException { return gBasicParser.decimal(); }
    public void basic() throws RecognitionException { gBasicParser.basic(); }
    public Combined_BasicParser.alphanum_return alphanum() throws RecognitionException { return gBasicParser.alphanum(); }


 

    public static final BitSet FOLLOW_set_in_rule54 = new BitSet(new long[]{0x000000000000FFF2L});
    public static final BitSet FOLLOW_extended_in_rule74 = new BitSet(new long[]{0x000000000000FFF2L});
    public static final BitSet FOLLOW_basic_in_rule78 = new BitSet(new long[]{0x000000000000FFF2L});
    public static final BitSet FOLLOW_set_in_rule87 = new BitSet(new long[]{0x000000000000FFF2L});

}