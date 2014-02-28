package com.laudandjolynn.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2014年2月28日
 */
public class Warehouse {
	private int capacity = 20;
	private int stock = 0;

	public Warehouse() {
	}

	public Warehouse(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * 生产
	 * 
	 * @param num
	 */
	public synchronized void produce(int num) {
		while (stock + num > capacity) {
			System.out.println("现库存量为" + stock + ", 再生产" + num
					+ "将超出库存容量，只允许再生产" + (capacity - stock));
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("线程退出");
				return;
			}
		}
		stock += num;
		System.out.println("已经生产了" + num + ", 现库存量为" + stock);
		notifyAll();
	}

	/**
	 * 消费
	 * 
	 * @param num
	 */
	public synchronized void consume(int num) {
		while (stock < num) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("线程退出");
				return;
			}
		}
		stock -= num;
		System.out.println("已经消费了" + num + ", 现库存量为" + stock);
		notifyAll();
	}

	public static void main(String[] args) throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(15);
		Warehouse warehouse = new Warehouse(30);
		Producer p1 = new Producer(1, warehouse, countDownLatch);
		Producer p2 = new Producer(2, warehouse, countDownLatch);
		Producer p3 = new Producer(3, warehouse, countDownLatch);
		Producer p4 = new Producer(4, warehouse, countDownLatch);
		Producer p5 = new Producer(5, warehouse, countDownLatch);
		Producer p6 = new Producer(6, warehouse, countDownLatch);
		Producer p7 = new Producer(7, warehouse, countDownLatch);
		Producer p8 = new Producer(8, warehouse, countDownLatch);
		Producer p9 = new Producer(9, warehouse, countDownLatch);

		Consumer c1 = new Consumer(3, warehouse, countDownLatch);
		Consumer c2 = new Consumer(4, warehouse, countDownLatch);
		Consumer c3 = new Consumer(5, warehouse, countDownLatch);
		Consumer c4 = new Consumer(6, warehouse, countDownLatch);
		Consumer c5 = new Consumer(7, warehouse, countDownLatch);
		Consumer c6 = new Consumer(8, warehouse, countDownLatch);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		p9.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();

		countDownLatch.await();
		System.exit(0);
	}
}
