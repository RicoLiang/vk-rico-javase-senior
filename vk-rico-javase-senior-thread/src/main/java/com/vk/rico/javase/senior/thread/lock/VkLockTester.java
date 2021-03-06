package com.vk.rico.javase.senior.thread.lock;

class Widget {
	public void doSomething() {
		synchronized (Widget.class) {
			System.out.println("Widget doSomething");
		}
	}
}

class LoggingWidget extends Widget {
	public synchronized void doSomething() {
		System.out.println("LoggingWidget doSomething");
		super.doSomething();
	}

	public void doSomething2() {
		System.out.println("LoggingWidget doSomething");
	}
}

public class VkLockTester {

	public static void main(String[] args) {
		// Lock
		LoggingWidget widget = new LoggingWidget();
		widget.doSomething();

		widget.doSomething2();
	}
}
