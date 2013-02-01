package com.laudandjolynn.test.file;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午2:44:49
 * @copyright: www.armisi.com.cn
 */
public class FileTest3 {
	public static void main(String[] args) throws Exception {
		File file = new File("G:\\Laud\\Software\\应用\\YoudaoDictFull.exe");
		FileInputStream fis = new FileInputStream(file);
		while (fis.read() != -1) {
			System.out.println("dddd");
		}
		fis.close();
	}
}
