package com.laudandjolynn.test;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.impl.DefaultCamelContext;


/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2015年7月21日 上午9:51:44
 * @copyright: www.laudandjolynn.com
 */
public class XpathTest {
	public static void main(String[] args) {
		XPathBuilder builder = XPathBuilder.xpath("foo/bar/text()").saxon();
		CamelContext ctx = new DefaultCamelContext();
		String result = builder.evaluate(ctx,
				"<foo><bar>abc_def_ghi</bar></foo>");
		System.out.println(result);
		
	}
}
