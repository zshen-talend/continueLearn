// $ANTLR 3.3 Nov 30, 2010 12:45:30 BasicParser.g 2011-08-26 18:21:31

package org.talend.dataquality.parser.generate;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Combined_BasicParser extends Parser {
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
    // delegators
    public CombinedParser gCombined;
    public CombinedParser gParent;


        public Combined_BasicParser(TokenStream input, CombinedParser gCombined) {
            this(input, new RecognizerSharedState(), gCombined);
        }
        public Combined_BasicParser(TokenStream input, RecognizerSharedState state, CombinedParser gCombined) {
            super(input, state);
            this.gCombined = gCombined;
             
            gParent = gCombined;
        }
        

    public String[] getTokenNames() { return CombinedParser.tokenNames; }
    public String getGrammarFileName() { return "BasicParser.g"; }


    org.talend.dataquality.parser.util.Interpreter interp;

    public void setInterpreter(org.talend.dataquality.parser.util.Interpreter interp) {
    	this.interp = interp;
    }



    // $ANTLR start "separator"
    // BasicParser.g:11:1: separator : ( WHITESPACE | CHAR_IGNORED );
    public final void separator() throws RecognitionException {
        try {
            // BasicParser.g:12:3: ( WHITESPACE | CHAR_IGNORED )
            // BasicParser.g:
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "separator"


    // $ANTLR start "extended"
    // BasicParser.g:19:1: extended : ( currency | roman_numeral | decimal | fraction | cjk );
    public final void extended() throws RecognitionException {
        try {
            // BasicParser.g:20:3: ( currency | roman_numeral | decimal | fraction | cjk )
            int alt1=5;
            switch ( input.LA(1) ) {
            case CURRENCY:
                {
                alt1=1;
                }
                break;
            case ROMAN_NUMERAL:
                {
                alt1=2;
                }
                break;
            case DECIMAL:
                {
                alt1=3;
                }
                break;
            case FRACTION:
                {
                alt1=4;
                }
                break;
            case CHAR_CJK:
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
                    // BasicParser.g:21:3: currency
                    {
                    pushFollow(FOLLOW_currency_in_extended45);
                    currency();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // BasicParser.g:22:5: roman_numeral
                    {
                    pushFollow(FOLLOW_roman_numeral_in_extended51);
                    roman_numeral();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // BasicParser.g:23:5: decimal
                    {
                    pushFollow(FOLLOW_decimal_in_extended57);
                    decimal();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // BasicParser.g:24:5: fraction
                    {
                    pushFollow(FOLLOW_fraction_in_extended63);
                    fraction();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // BasicParser.g:25:5: cjk
                    {
                    pushFollow(FOLLOW_cjk_in_extended69);
                    cjk();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "extended"

    public static class currency_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "currency"
    // BasicParser.g:28:1: currency : CURRENCY ;
    public final Combined_BasicParser.currency_return currency() throws RecognitionException {
        Combined_BasicParser.currency_return retval = new Combined_BasicParser.currency_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:29:3: ( CURRENCY )
            // BasicParser.g:30:3: CURRENCY
            {
            match(input,CURRENCY,FOLLOW_CURRENCY_in_currency84); 

                        interp.store("CURRENCY", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "currency"

    public static class roman_numeral_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "roman_numeral"
    // BasicParser.g:36:1: roman_numeral : ROMAN_NUMERAL ;
    public final Combined_BasicParser.roman_numeral_return roman_numeral() throws RecognitionException {
        Combined_BasicParser.roman_numeral_return retval = new Combined_BasicParser.roman_numeral_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:37:3: ( ROMAN_NUMERAL )
            // BasicParser.g:38:3: ROMAN_NUMERAL
            {
            match(input,ROMAN_NUMERAL,FOLLOW_ROMAN_NUMERAL_in_roman_numeral113); 

                             interp.store("ROMAIN_NUMERAL", input.toString(retval.start,input.LT(-1)));
                            

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "roman_numeral"

    public static class decimal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "decimal"
    // BasicParser.g:44:1: decimal : DECIMAL ;
    public final Combined_BasicParser.decimal_return decimal() throws RecognitionException {
        Combined_BasicParser.decimal_return retval = new Combined_BasicParser.decimal_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:45:3: ( DECIMAL )
            // BasicParser.g:46:3: DECIMAL
            {
            match(input,DECIMAL,FOLLOW_DECIMAL_in_decimal147); 

                       interp.store("DECIMAL", input.toString(retval.start,input.LT(-1)));
                      

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decimal"

    public static class fraction_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "fraction"
    // BasicParser.g:52:1: fraction : FRACTION ;
    public final Combined_BasicParser.fraction_return fraction() throws RecognitionException {
        Combined_BasicParser.fraction_return retval = new Combined_BasicParser.fraction_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:53:3: ( FRACTION )
            // BasicParser.g:54:3: FRACTION
            {
            match(input,FRACTION,FOLLOW_FRACTION_in_fraction175); 

                        interp.store("FRACTION", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fraction"

    public static class cjk_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "cjk"
    // BasicParser.g:60:1: cjk : CHAR_CJK ;
    public final Combined_BasicParser.cjk_return cjk() throws RecognitionException {
        Combined_BasicParser.cjk_return retval = new Combined_BasicParser.cjk_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:61:3: ( CHAR_CJK )
            // BasicParser.g:62:3: CHAR_CJK
            {
            match(input,CHAR_CJK,FOLLOW_CHAR_CJK_in_cjk204); 

                        interp.store("CJK", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cjk"


    // $ANTLR start "basic"
    // BasicParser.g:70:1: basic : ( integer | capword | word | alphanum | undefined );
    public final void basic() throws RecognitionException {
        try {
            // BasicParser.g:71:3: ( integer | capword | word | alphanum | undefined )
            int alt2=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt2=1;
                }
                break;
            case CAPWORD:
                {
                alt2=2;
                }
                break;
            case WORD:
                {
                alt2=3;
                }
                break;
            case ALPHANUM:
                {
                alt2=4;
                }
                break;
            case UNDEFINED:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // BasicParser.g:72:3: integer
                    {
                    pushFollow(FOLLOW_integer_in_basic235);
                    integer();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // BasicParser.g:73:5: capword
                    {
                    pushFollow(FOLLOW_capword_in_basic241);
                    capword();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // BasicParser.g:74:5: word
                    {
                    pushFollow(FOLLOW_word_in_basic247);
                    word();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // BasicParser.g:75:5: alphanum
                    {
                    pushFollow(FOLLOW_alphanum_in_basic253);
                    alphanum();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // BasicParser.g:76:5: undefined
                    {
                    pushFollow(FOLLOW_undefined_in_basic259);
                    undefined();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "basic"

    public static class integer_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "integer"
    // BasicParser.g:79:1: integer : INT ;
    public final Combined_BasicParser.integer_return integer() throws RecognitionException {
        Combined_BasicParser.integer_return retval = new Combined_BasicParser.integer_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:80:3: ( INT )
            // BasicParser.g:81:3: INT
            {
            match(input,INT,FOLLOW_INT_in_integer274); 

                   interp.store("INT", input.toString(retval.start,input.LT(-1)));
                  

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integer"

    public static class capword_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "capword"
    // BasicParser.g:87:1: capword : CAPWORD ;
    public final Combined_BasicParser.capword_return capword() throws RecognitionException {
        Combined_BasicParser.capword_return retval = new Combined_BasicParser.capword_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:88:3: ( CAPWORD )
            // BasicParser.g:89:3: CAPWORD
            {
            match(input,CAPWORD,FOLLOW_CAPWORD_in_capword298); 

                       interp.store("CAPWORD", input.toString(retval.start,input.LT(-1)));
                      

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "capword"

    public static class word_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "word"
    // BasicParser.g:95:1: word : WORD ;
    public final Combined_BasicParser.word_return word() throws RecognitionException {
        Combined_BasicParser.word_return retval = new Combined_BasicParser.word_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:96:3: ( WORD )
            // BasicParser.g:97:3: WORD
            {
            match(input,WORD,FOLLOW_WORD_in_word326); 

                    interp.store("WORD", input.toString(retval.start,input.LT(-1)));
                   

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "word"

    public static class alphanum_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "alphanum"
    // BasicParser.g:103:1: alphanum : ALPHANUM ;
    public final Combined_BasicParser.alphanum_return alphanum() throws RecognitionException {
        Combined_BasicParser.alphanum_return retval = new Combined_BasicParser.alphanum_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:104:3: ( ALPHANUM )
            // BasicParser.g:105:3: ALPHANUM
            {
            match(input,ALPHANUM,FOLLOW_ALPHANUM_in_alphanum351); 

                        interp.store("ALPHANUM", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "alphanum"

    public static class undefined_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "undefined"
    // BasicParser.g:111:1: undefined : UNDEFINED ;
    public final Combined_BasicParser.undefined_return undefined() throws RecognitionException {
        Combined_BasicParser.undefined_return retval = new Combined_BasicParser.undefined_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:112:3: ( UNDEFINED )
            // BasicParser.g:113:3: UNDEFINED
            {
            match(input,UNDEFINED,FOLLOW_UNDEFINED_in_undefined380); 

                         interp.store("UNDEFINED", input.toString(retval.start,input.LT(-1)));
                        

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "undefined"

    // Delegated rules


 

    public static final BitSet FOLLOW_set_in_separator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currency_in_extended45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_roman_numeral_in_extended51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_in_extended57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fraction_in_extended63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cjk_in_extended69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENCY_in_currency84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROMAN_NUMERAL_in_roman_numeral113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_in_decimal147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FRACTION_in_fraction175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_CJK_in_cjk204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_in_basic235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_capword_in_basic241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_basic247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alphanum_in_basic253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_undefined_in_basic259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integer274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPWORD_in_capword298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_word326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHANUM_in_alphanum351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDEFINED_in_undefined380 = new BitSet(new long[]{0x0000000000000002L});

}