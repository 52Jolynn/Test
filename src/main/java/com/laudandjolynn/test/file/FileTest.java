package com.laudandjolynn.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午1:19:24
 * @copyright: www.armisi.com.cn
 */
public class FileTest implements Runnable {
	private File file = new File(
			"G:\\Laud\\Software\\应用\\ExpressoSetup3.msi");

	public static void main(String[] args) {
		FileTest test = new FileTest();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);

		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] data = new byte[128];
			while ((fis.read(data)) != -1) {
				System.out.println(Thread.currentThread().getName() + ":"
						+ new String(data));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
