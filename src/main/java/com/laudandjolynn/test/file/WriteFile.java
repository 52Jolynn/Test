package com.laudandjolynn.test.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Calendar;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午2:19:47
 * @copyright: www.armisi.com.cn
 */
public class WriteFile extends Thread {

	@Override
	public void run() {
		Calendar calstart = Calendar.getInstance();
		File file = new File("G:\\test.txt");
		try {
			if (!file.exists())
				file.createNewFile();

			// 对该文件加锁
			RandomAccessFile out = new RandomAccessFile(file, "rw");
			FileChannel fcout = out.getChannel();
			FileLock flout = null;
			while (true) {
				try {
					flout = fcout.tryLock();
					break;
				} catch (Exception e) {
					System.out.println("有其他线程正在操作该文件，"
							+ Thread.currentThread().getName() + "休眠1000毫秒");
					Thread.sleep(1000);
				}

			}

			for (int i = 1; i <= 1000; i++) {
				Thread.sleep(10);
				StringBuffer sb = new StringBuffer();
				sb.append("这是第" + i + "行，应该没啥错哈 ");
				out.write(sb.toString().getBytes("utf-8"));
			}

			flout.release();
			fcout.close();
			out.close();
			out = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Calendar calend = Calendar.getInstance();
		System.out
				.println("写文件共花了"
						+ (calend.getTimeInMillis() - calstart
								.getTimeInMillis()) + "秒");
	}

}
