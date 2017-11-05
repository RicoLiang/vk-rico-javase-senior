package com.vk.rico.javase.senior.jvm;

/**
 * java虚拟机栈、本地方法栈抛出StackOverflowError异常<br/>
 * -Xss128k减少栈内存容量<br/>
 * -Xss64k：The stack size specified is too small, Specify at least 108k
 * 
 * @author Administrator
 *
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length : " + oom.stackLength);
			throw e;
		}
	}
}
