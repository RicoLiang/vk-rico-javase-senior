package com.vk.rico.javase.senior.thread.lock.locks;

public class BoundedBufferTester {

	private static BoundedBuffer bb = new BoundedBuffer();
	
	
	public static void main(String[] args) {
		RunTarget t = new RunTarget(bb);
		Thread t1 = new Thread(t);
		t1.start();
	}
}

class RunTarget implements Runnable{

	private BoundedBuffer bb;
	public RunTarget(BoundedBuffer bb){
		this.bb = bb;
	}
	
	@Override
	public void run() {
		try{
			bb.take();
		}catch(Exception e){}
	}

}