package com.vk.rico.javase.senior.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class PerformanceTestTool {

	public long timecost(int times, Runnable task) throws InterruptedException {
		if (times <= 0) {
			throw new IllegalArgumentException("times参数必须大于0");
		}
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch overLatch = new CountDownLatch(times);
		for (int i = 0; i < times; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// 当前线程阻塞，直到门闩锁计数为0。除非线程被中断
						// 如果当前的门闩锁计数为零为0，则该方法立刻返回
						startLatch.await();
						task.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						// 递减门闩的个数，当计数为0时，释放所有等待的线程（所有线程都可执行状态，一旦获得CPU的执行权时，则立刻执行，因此线程不是FIFO的,就好比内部使用的是非公平所一样）
						overLatch.countDown();
					}
				}
			}).start();
		}
		long start = System.nanoTime();
		startLatch.countDown();
		overLatch.await();
		return System.nanoTime() - start;
	}

	public static void main(String[] args) {
		Thread task = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
 
		PerformanceTestTool tool = new PerformanceTestTool();
		try {
			long time = tool.timecost(3, task);
			System.out.println(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
