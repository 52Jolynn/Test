package com.laudandjolynn.test.file;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午2:21:46
 * @copyright: www.armisi.com.cn
 */
public class FileLockTest {
	public static void main(String[] args) {
		ReadFile read = new ReadFile();
		read.setName("读线程");
		WriteFile write = new WriteFile();
		write.setName("写线程");
		read.start();
		write.start();
	}
}
