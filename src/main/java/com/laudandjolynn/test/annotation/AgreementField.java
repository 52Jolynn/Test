package com.laudandjolynn.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-3-27 上午9:13:21
 * @copyright: www.armisi.com.cn
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface AgreementField {
	/**
	 * 协议/映射名
	 * 
	 * @return
	 */
	public String agreementName();
}
