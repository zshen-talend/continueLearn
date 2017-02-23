// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\tdp_trunk1\\shenzetest\\BasicParser.g 2011-08-26 18:21:36

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BasicParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WHITESPACE", "CHAR_IGNORED", "CURRENCY", "ROMAN_NUMERAL", "DECIMAL", "FRACTION", "CHAR_CJK", "INT", "CAPWORD", "WORD", "ALPHANUM", "UNDEFINED"
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

    // delegates
    // delegators


        public BasicParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BasicParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BasicParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\tdp_trunk1\\shenzetest\\BasicParser.g"; }


    org.talend.dataquality.parser.util.Interpreter interp;

    public void setInterpreter(org.talend.dataquality.parser.util.Interpreter interp) {
    	this.interp = interp;
    }



    // $ANTLR start "separator"
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:11:1: separator : ( WHITESPACE | CHAR_IGNORED );
    public final void separator() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:12:3: ( WHITESPACE | CHAR_IGNORED )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:19:1: extended : ( currency | roman_numeral | decimal | fraction | cjk );
    public final void extended() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:20:3: ( currency | roman_numeral | decimal | fraction | cjk )
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
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:21:3: currency
                    {
                    pushFollow(FOLLOW_currency_in_extended45);
                    currency();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:22:5: roman_numeral
                    {
                    pushFollow(FOLLOW_roman_numeral_in_extended51);
                    roman_numeral();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:23:5: decimal
                    {
                    pushFollow(FOLLOW_decimal_in_extended57);
                    decimal();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:24:5: fraction
                    {
                    pushFollow(FOLLOW_fraction_in_extended63);
                    fraction();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:25:5: cjk
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:28:1: currency : CURRENCY ;
    public final BasicParser.currency_return currency() throws RecognitionException {
        BasicParser.currency_return retval = new BasicParser.currency_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:29:3: ( CURRENCY )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:30:3: CURRENCY
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:36:1: roman_numeral : ROMAN_NUMERAL ;
    public final BasicParser.roman_numeral_return roman_numeral() throws RecognitionException {
        BasicParser.roman_numeral_return retval = new BasicParser.roman_numeral_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:37:3: ( ROMAN_NUMERAL )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:38:3: ROMAN_NUMERAL
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:44:1: decimal : DECIMAL ;
    public final BasicParser.decimal_return decimal() throws RecognitionException {
        BasicParser.decimal_return retval = new BasicParser.decimal_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:45:3: ( DECIMAL )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:46:3: DECIMAL
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:52:1: fraction : FRACTION ;
    public final BasicParser.fraction_return fraction() throws RecognitionException {
        BasicParser.fraction_return retval = new BasicParser.fraction_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:53:3: ( FRACTION )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:54:3: FRACTION
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:60:1: cjk : CHAR_CJK ;
    public final BasicParser.cjk_return cjk() throws RecognitionException {
        BasicParser.cjk_return retval = new BasicParser.cjk_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:61:3: ( CHAR_CJK )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:62:3: CHAR_CJK
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:70:1: basic : ( integer | capword | word | alphanum | undefined );
    public final void basic() throws RecognitionException {
        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:71:3: ( integer | capword | word | alphanum | undefined )
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
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:72:3: integer
                    {
                    pushFollow(FOLLOW_integer_in_basic235);
                    integer();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:73:5: capword
                    {
                    pushFollow(FOLLOW_capword_in_basic241);
                    capword();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:74:5: word
                    {
                    pushFollow(FOLLOW_word_in_basic247);
                    word();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:75:5: alphanum
                    {
                    pushFollow(FOLLOW_alphanum_in_basic253);
                    alphanum();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:76:5: undefined
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:79:1: integer : INT ;
    public final BasicParser.integer_return integer() throws RecognitionException {
        BasicParser.integer_return retval = new BasicParser.integer_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:80:3: ( INT )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:81:3: INT
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:87:1: capword : CAPWORD ;
    public final BasicParser.capword_return capword() throws RecognitionException {
        BasicParser.capword_return retval = new BasicParser.capword_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:88:3: ( CAPWORD )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:89:3: CAPWORD
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:95:1: word : WORD ;
    public final BasicParser.word_return word() throws RecognitionException {
        BasicParser.word_return retval = new BasicParser.word_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:96:3: ( WORD )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:97:3: WORD
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:103:1: alphanum : ALPHANUM ;
    public final BasicParser.alphanum_return alphanum() throws RecognitionException {
        BasicParser.alphanum_return retval = new BasicParser.alphanum_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:104:3: ( ALPHANUM )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:105:3: ALPHANUM
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
    // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:111:1: undefined : UNDEFINED ;
    public final BasicParser.undefined_return undefined() throws RecognitionException {
        BasicParser.undefined_return retval = new BasicParser.undefined_return();
        retval.start = input.LT(1);

        try {
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:112:3: ( UNDEFINED )
            // E:\\tdp_trunk1\\shenzetest\\BasicParser.g:113:3: UNDEFINED
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