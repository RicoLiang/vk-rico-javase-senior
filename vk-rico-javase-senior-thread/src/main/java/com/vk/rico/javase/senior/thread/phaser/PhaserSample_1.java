package com.vk.rico.javase.senior.thread.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserSample_1 {

	public static void main(String[] args) {
		// 相当于CountDownLatch latch = new CountDownLatch(1);
		Phaser phaser = new Phaser(1);
		for (int i = 0; i < 3; i++) {
			new MyThread((char) (97 + i), phaser).start();
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		phaser.arrive();
		System.out.println(Thread.currentThread().getName());
	}
}

class MyThread extends Thread {

	private char c;
	private Phaser phaser;

	public MyThread(char c, Phaser phaser) {
		this.c = c;
		this.phaser = phaser;
	}

	public void run() {
		// 相当于latch.await();
		int num = phaser.awaitAdvance(phaser.getPhase());
		System.out.println(Thread.currentThread().getName() + " " + num);
		for (int i = 0; i < 100; i++) {
			System.out.println(c + " ");
			if (i % 10 == 9) {
				System.out.println();
			}
		}
	}
}