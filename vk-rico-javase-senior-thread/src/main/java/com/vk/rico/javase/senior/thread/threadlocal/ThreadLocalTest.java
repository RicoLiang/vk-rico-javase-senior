package com.vk.rico.javase.senior.thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					new CommercialLogic().doTask();
				}
			}.start();
		}
	}
}

class IdGenerator {
	private final static AtomicInteger num = new AtomicInteger(1000);
	private final static ThreadLocal<Integer> id = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return num.incrementAndGet();
		}
	};

	public static int getId() {
		return id.get();
	}
}

class CommercialLogic {
	public void doTask() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "线程ID是" + IdGenerator.getId());
		}
	}
}