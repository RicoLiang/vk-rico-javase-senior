package com.vk.rico.javase.senior.jvm;

/**
 * Java虚拟机栈（或本地方法栈）是线程私有的，生命周期与线程相同<br/>
 * Java虚拟机栈描述的是Java方法执行的内存模型；本地方法栈则是为虚拟机使用到的Native方法服务<br/>
 * -Xss 参数减少栈内存容量 -verbose:gc -Xss2M
 * 
 * @author Administrator
 *
 */
public class JavaVMStackOOM {

	/**
	 * 每一个方法被调用直至执行完成的过程，就对应一个栈帧在java虚拟机栈（或本地方法栈）中从入栈道出栈的过程
	 * 
	 */
	private void dontStop() {
		// 死循环，模拟栈帧只入栈不出栈，从而导致栈内存溢出
		while (true) {
			// 栈内存泄漏，即局部变量表发生了内存泄漏
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
