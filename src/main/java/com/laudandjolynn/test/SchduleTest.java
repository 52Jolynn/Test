package com.laudandjolynn.test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2015年5月11日 下午2:50:31
 * @copyright: www.laudandjolynn.com
 */
public class SchduleTest {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
				1);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				System.out.println("dddd");
			}
		}, 0, 1, TimeUnit.SECONDS);
		scheduledExecutorService.shutdown();
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
}
