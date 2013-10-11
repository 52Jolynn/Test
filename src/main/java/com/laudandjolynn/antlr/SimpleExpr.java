package com.laudandjolynn.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

/**
 * @author: huangtiande Email:tdhuang@intple.com Date: 2013年10月11日
 */

public class SimpleExpr {
	public static void main(String[] args) throws Exception {
		String expr = "1+3";
		ANTLRStringStream in = new ANTLRStringStream(expr);

		SimpleExprLexer lexer = new SimpleExprLexer(in);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		SimpleExprParser parser = new SimpleExprParser(tokens);

		parser.prog();
	}
}
