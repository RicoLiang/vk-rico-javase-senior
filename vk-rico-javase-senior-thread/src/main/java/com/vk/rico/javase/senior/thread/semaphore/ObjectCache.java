package com.vk.rico.javase.senior.thread.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectCache<T> {

	public interface ObjectFactory<T> {
		T makeObject();
	}

	class Node {
		T obj;

		Node next;
	}

	private ObjectFactory<T> factory;

	private Lock lock = new ReentrantLock();

	/**
	 * 计数信号量
	 */
	private Semaphore semaphore;

	private Node head;
	private Node tail;

	public ObjectCache(int capacity, ObjectFactory<T> factory) {
		this.factory = factory;
		this.semaphore = new Semaphore(capacity);
		this.head = null;
		this.tail = null;
	}

	public T getObject() throws InterruptedException {
		// 从信号量获取一个许可证，如果有可用的许可证，则立即返回，并许可证的可用数量减少一个；否则线程阻塞，直到有可用的许可证，或者当前线程被打断
		this.semaphore.acquire();

		return this.getNextObject();
	}

	private T getNextObject() {
		lock.lock();
		try {
			if (null == this.head) {
				return this.factory.makeObject();
			}
			Node ret = head;
			head = head.next;
			if (null == head) {
				tail = null;
			}
			ret.next = null;
			return ret.obj;
		} finally {
			lock.unlock();
		}
	}

	public void returnObject(T t) {
		this.returnObjectToPoll(t);

		// 释放许可证给信号量，信号量的可用许可证加1，没调用release方法，可用许可证就自增1，甚至超过初始可用许可证数量
		this.semaphore.release();
	}

	public void returnObjectToPoll(T t) {
		lock.lock();
		try {
			Node node = new Node();
			node.obj = t;
			if (null == tail) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = node;
			}
		} finally {
			lock.unlock();
		}
	}

	class StringObjectFactory implements ObjectFactory<String> {
		@Override
		public String makeObject() {
			Random random = new Random(System.currentTimeMillis());
			long longVal = random.nextLong();
			return String.valueOf(longVal);
		}
	}

	public static void main(String[] args) {
		ObjectCache<String> cache = new ObjectCache<String>(2, new ObjectFactory<String>() {
			@Override
			public String makeObject() {
				Random random = new Random(System.currentTimeMillis());
				long longVal = random.nextLong();
				return String.valueOf(longVal);
			}
		});

		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new Thread() {
			public void run() {
				// try {
				// String str = cache.getObject();
				// System.out.println(Thread.currentThread().getName() + "\t" +
				// str);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				cache.returnObject("a1");
			}
		});
		executor.execute(new Thread() {
			public void run() {
				// try {
				// String str = cache.getObject();
				// System.out.println(Thread.currentThread().getName() + "\t" +
				// str);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				cache.returnObject("a1");
			}
		});
		executor.execute(new Thread() {
			public void run() {
				// try {
				// String str = cache.getObject();
				// System.out.println(Thread.currentThread().getName() + "\t" +
				// str);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				cache.returnObject("a1");
			}
		});

		// 释放一个许可证给信号量，但此时可用的许可证只有0个，若有其他线程尝试获取许可证时，将会一直阻塞，直到有可用的许可证或线程被打断
		cache.returnObject("a1");

		executor.shutdown();
		System.out.println(Thread.currentThread().getName());
	}
}
