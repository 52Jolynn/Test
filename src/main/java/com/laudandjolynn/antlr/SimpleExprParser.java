package com.laudandjolynn.antlr;
// $ANTLR 3.5 C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g 2013-10-11 11:30:35

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SimpleExprParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SimpleExprParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SimpleExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SimpleExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g"; }



	// $ANTLR start "prog"
	// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:2:1: prog : stat ;
	public final void prog() throws RecognitionException {
		try {
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:2:5: ( stat )
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:2:7: stat
			{
			pushFollow(FOLLOW_stat_in_prog8);
			stat();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:5:1: stat : ( expr | NEWLINE );
	public final void stat() throws RecognitionException {
		try {
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:5:5: ( expr | NEWLINE )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( ((LA1_0 >= ID && LA1_0 <= INT)||LA1_0==8) ) {
				alt1=1;
			}
			else if ( (LA1_0==NEWLINE) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:5:7: expr
					{
					pushFollow(FOLLOW_expr_in_stat18);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:6:5: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat25); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:8:1: expr : multExpr ( ( '+' | '-' ) multExpr )* ;
	public final void expr() throws RecognitionException {
		try {
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:8:6: ( multExpr ( ( '+' | '-' ) multExpr )* )
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:8:8: multExpr ( ( '+' | '-' ) multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr35);
			multExpr();
			state._fsp--;

			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:8:17: ( ( '+' | '-' ) multExpr )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 11 && LA2_0 <= 12)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:8:18: ( '+' | '-' ) multExpr
					{
					if ( (input.LA(1) >= 11 && input.LA(1) <= 12) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr44);
					multExpr();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:11:1: multExpr : atom ( ( '*' | '/' ) atom )* ;
	public final void multExpr() throws RecognitionException {
		try {
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:11:10: ( atom ( ( '*' | '/' ) atom )* )
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:11:12: atom ( ( '*' | '/' ) atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr57);
			atom();
			state._fsp--;

			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:11:17: ( ( '*' | '/' ) atom )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==10||LA3_0==13) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:11:18: ( '*' | '/' ) atom
					{
					if ( input.LA(1)==10||input.LA(1)==13 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_atom_in_multExpr66);
					atom();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atom"
	// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:14:1: atom : ( '(' expr ')' | INT | ID );
	public final void atom() throws RecognitionException {
		try {
			// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:14:5: ( '(' expr ')' | INT | ID )
			int alt4=3;
			switch ( input.LA(1) ) {
			case 8:
				{
				alt4=1;
				}
				break;
			case INT:
				{
				alt4=2;
				}
				break;
			case ID:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:14:8: '(' expr ')'
					{
					match(input,8,FOLLOW_8_in_atom79); 
					pushFollow(FOLLOW_expr_in_atom80);
					expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_atom81); 
					}
					break;
				case 2 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:15:10: INT
					{
					match(input,INT,FOLLOW_INT_in_atom93); 
					}
					break;
				case 3 :
					// C:\\Users\\tdhuang\\git\\Test\\src\\main\\java\\com\\laudandjolynn\\antlr\\SimpleExpr.g:16:7: ID
					{
					match(input,ID,FOLLOW_ID_in_atom103); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog8 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_stat18 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat25 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr35 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_set_in_expr38 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr44 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_atom_in_multExpr57 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_set_in_multExpr60 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_atom_in_multExpr66 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_8_in_atom79 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_atom80 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom103 = new BitSet(new long[]{0x0000000000000002L});
}
