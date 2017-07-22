package com.vk.rico.javase.senior.thread.cyclicbarrier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {

	// 徒步索要的时间：Shenzhen、Guangzhou、Shaoguan、Changsha、Wuhan
	private static int[] timeWalk = { 5, 8, 15, 15, 10 };

	// 自驾游
	private static int[] timeSelf = { 1, 3, 4, 4, 5 };

	// 旅游大巴
	private static int[] timeBus = { 2, 4, 6, 6, 7 };

	private static String now() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date()) + ":";
	}

	private static class Tour implements Runnable {
		private int[] times;
		private CyclicBarrier barrier;
		private String tourName;

		public Tour(CyclicBarrier barrier, String tourName, int[] times) {
			this.barrier = barrier;
			this.tourName = tourName;
			this.times = times;
		}

		public void run() {
			try {
				Thread.sleep(times[0] * 1000);
				System.out.println(now() + tourName + " Reached Shenzhen");
				barrier.await();

				Thread.sleep(times[1] * 1000);
				System.out.println(now() + tourName + " Reached Guangzhou");
				barrier.await();

				Thread.sleep(times[2] * 1000);
				System.out.println(now() + tourName + " Reached Shaoguan");
				barrier.await();
				System.out.println();

				Thread.sleep(times[3] * 1000);
				System.out.println(now() + tourName + " Reached Changsha");
				barrier.await();

				Thread.sleep(times[4] * 1000);
				System.out.println(now() + tourName + " Reached Wuhan");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "\n");
			}
		});
		ExecutorService execu = Executors.newFixedThreadPool(3);
		execu.submit(new Tour(barrier, "WalkTour", timeWalk));
		execu.submit(new Tour(barrier, "SelfTour", timeSelf));
		execu.submit(new Tour(barrier, "BusTour", timeBus));
		execu.shutdown();
	}
}
