package com.vk.rico.javase.senior.thread.lock;

/**
 * 
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC。
 * 
 * @author liangxf
 *
 */
public class VkWaitTester implements Runnable {

	private static volatile String msg = "线程一打印A";
	private String message;
	private String next;

	public VkWaitTester(String message, String next) {
		this.message = message;
		this.next = next;
	}

	public static void main(String[] args) {
		new Thread(new VkWaitTester("线程一打印A", "线程二打印B")).start();
		new Thread(new VkWaitTester("线程二打印B", "线程三打印C")).start();
		new Thread(new VkWaitTester("线程三打印C", "线程一打印A")).start();
	}

	public void run() {
		for (int i = 0; i < 10;) {
			if (this.message.equals(VkWaitTester.msg)) {
				System.out.println(this.message);
				VkWaitTester.msg = next;
				i++;
			}
		}
	}
}
