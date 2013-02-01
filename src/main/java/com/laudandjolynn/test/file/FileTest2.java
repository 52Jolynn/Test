package com.laudandjolynn.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午1:32:38
 * @copyright: www.armisi.com.cn
 */
public class FileTest2 implements Runnable {
	private int mode;
	private File file = new File("G:\\test.txt");
	private FileInputStream fis = null;
	private FileOutputStream fos = null;

	public FileTest2(int mode) {
		this.mode = mode;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fos = new FileOutputStream(file, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	/**
	 * 读
	 */
	private void read(FileInputStream fis) {
		try {
			while (fis.read() != -1) {
				System.out.println(Thread.currentThread().getName() + " read.");
				mode = 1;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写
	 */
	private void write(FileOutputStream fos) {
		for (int i = 48; i < 97; i++) {
			try {
				fos.write(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " write.");
			mode = 0;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		if (mode == 0) {
			read(fis);
		} else if (mode == 1) {
			write(fos);
		}
		try {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FileTest2 test = new FileTest2(1);
		Thread t1 = new Thread(test);
		FileTest2 test2 = new FileTest2(0);
		Thread t2 = new Thread(test2);
		t1.start();
		t2.start();
	}
}
