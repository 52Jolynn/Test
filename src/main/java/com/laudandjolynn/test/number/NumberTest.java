package com.laudandjolynn.test.number;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-4 下午12:53:16
 * @copyright: www.armisi.com.cn
 */
public class NumberTest {
	public static void main(String[] args) {
		int l = Float.floatToIntBits(1.23f);
		byte[] data = new byte[4];
		for (int i = 0; i < 4; i++) {
			data[i] = new Integer(l).byteValue();
			l = l >> 8;
		}
		System.out.println(data);
	}
}
