package com.laudandjolynn.test.annotation;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-3-27 上午9:16:42
 * @copyright: www.armisi.com.cn
 */
public class Student {
	@AgreementField(agreementName = "STU1")
	private String name;
	@AgreementField(agreementName = "STU2")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
