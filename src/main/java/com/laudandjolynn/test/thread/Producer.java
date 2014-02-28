package com.laudandjolynn.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2014年2月28日
 */
public class Producer extends Thread {
	private CountDownLatch countDownLatch = null;
	private Warehouse warehouse = null;
	private int num = 0;

	public Producer(int num, Warehouse warehouse, CountDownLatch countDownLatch) {
		this.num = num;
		this.warehouse = warehouse;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		warehouse.produce(num);
		countDownLatch.countDown();
	}
}
