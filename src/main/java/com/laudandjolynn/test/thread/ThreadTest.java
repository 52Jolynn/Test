package com.laudandjolynn.test.thread;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午1:14:49
 * @copyright: www.armisi.com.cn
 */
public class ThreadTest extends Thread {
	private int count;

	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();
		ThreadTest test2 = new ThreadTest();
		test.start();
		test2.start();

		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);

		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				count++;
				System.out.println(Thread.currentThread().getName() + ":"
						+ count);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
