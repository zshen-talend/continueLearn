// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g 2011-08-26 18:21:41

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class thecalcParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "SEMI", "JKLJ", "STAR", "INT", "WS", "LPAREN", "RPAREN", "DIGIT"
    };
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


        public thecalcParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public thecalcParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return thecalcParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g"; }


    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:3:1: expr : mexpr ( PLUS mexpr )* SEMI ;
    public final thecalcParser.expr_return expr() throws RecognitionException {
        thecalcParser.expr_return retval = new thecalcParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS2=null;
        Token SEMI4=null;
        thecalcParser.mexpr_return mexpr1 = null;

        thecalcParser.mexpr_return mexpr3 = null;


        Object PLUS2_tree=null;
        Object SEMI4_tree=null;

        try {
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:4:2: ( mexpr ( PLUS mexpr )* SEMI )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:4:4: mexpr ( PLUS mexpr )* SEMI
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mexpr_in_expr11);
            mexpr1=mexpr();

            state._fsp--;

            adaptor.addChild(root_0, mexpr1.getTree());
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:4:10: ( PLUS mexpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PLUS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:4:11: PLUS mexpr
            	    {
            	    PLUS2=(Token)match(input,PLUS,FOLLOW_PLUS_in_expr14); 
            	    PLUS2_tree = (Object)adaptor.create(PLUS2);
            	    root_0 = (Object)adaptor.becomeRoot(PLUS2_tree, root_0);

            	    pushFollow(FOLLOW_mexpr_in_expr17);
            	    mexpr3=mexpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mexpr3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            SEMI4=(Token)match(input,SEMI,FOLLOW_SEMI_in_expr21); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class kjhszj_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "kjhszj"
    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:7:1: kjhszj : JKLJ ;
    public final thecalcParser.kjhszj_return kjhszj() throws RecognitionException {
        thecalcParser.kjhszj_return retval = new thecalcParser.kjhszj_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token JKLJ5=null;

        Object JKLJ5_tree=null;

        try {
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:7:8: ( JKLJ )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:7:11: JKLJ
            {
            root_0 = (Object)adaptor.nil();

            JKLJ5=(Token)match(input,JKLJ,FOLLOW_JKLJ_in_kjhszj34); 
            JKLJ5_tree = (Object)adaptor.create(JKLJ5);
            adaptor.addChild(root_0, JKLJ5_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "kjhszj"

    public static class mexpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mexpr"
    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:8:1: mexpr : atom ( STAR atom )* ;
    public final thecalcParser.mexpr_return mexpr() throws RecognitionException {
        thecalcParser.mexpr_return retval = new thecalcParser.mexpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STAR7=null;
        thecalcParser.atom_return atom6 = null;

        thecalcParser.atom_return atom8 = null;


        Object STAR7_tree=null;

        try {
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:9:2: ( atom ( STAR atom )* )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:9:4: atom ( STAR atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_mexpr44);
            atom6=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom6.getTree());
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:9:9: ( STAR atom )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==STAR) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:9:10: STAR atom
            	    {
            	    STAR7=(Token)match(input,STAR,FOLLOW_STAR_in_mexpr47); 
            	    STAR7_tree = (Object)adaptor.create(STAR7);
            	    root_0 = (Object)adaptor.becomeRoot(STAR7_tree, root_0);

            	    pushFollow(FOLLOW_atom_in_mexpr50);
            	    atom8=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mexpr"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:12:1: atom : INT ;
    public final thecalcParser.atom_return atom() throws RecognitionException {
        thecalcParser.atom_return retval = new thecalcParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT9=null;

        Object INT9_tree=null;

        try {
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:12:5: ( INT )
            // E:\\tdp_trunk1\\shenzetest\\src\\antlrTest\\java\\calc\\thecalc.g:12:7: INT
            {
            root_0 = (Object)adaptor.nil();

            INT9=(Token)match(input,INT,FOLLOW_INT_in_atom61); 
            INT9_tree = (Object)adaptor.create(INT9);
            adaptor.addChild(root_0, INT9_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_mexpr_in_expr11 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_PLUS_in_expr14 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_mexpr_in_expr17 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_SEMI_in_expr21 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JKLJ_in_kjhszj34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_mexpr44 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_STAR_in_mexpr47 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_atom_in_mexpr50 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_INT_in_atom61 = new BitSet(new long[]{0x0000000000000002L});

}