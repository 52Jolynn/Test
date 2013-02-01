package com.laudandjolynn.test.thread;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2013-2-1 下午12:59:25
 * @copyright: www.armisi.com.cn
 */
public class RunnableTest implements Runnable {
	private int count;

	public static void main(String[] args) {
		RunnableTest test = new RunnableTest();
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
			}
		}
	}
}
