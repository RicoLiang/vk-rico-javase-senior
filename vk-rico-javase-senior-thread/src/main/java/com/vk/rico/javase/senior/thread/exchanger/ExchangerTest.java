package com.vk.rico.javase.senior.thread.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();

		Producer pro = new Producer(exchanger);
		pro.start();

		Consumer con = new Consumer(exchanger);
		con.start();
	}
}

class Producer extends Thread {
	private List<Integer> list = new ArrayList<Integer>(10);
	private Exchanger<List<Integer>> exchanger;

	public Producer(Exchanger<List<Integer>> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	public void run() {
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			list.clear();
			list.add(rand.nextInt(10000));
			list.add(rand.nextInt(10000));
			list.add(rand.nextInt(10000));
			list.add(rand.nextInt(10000));
			list.add(rand.nextInt(10000));
			try {
				list = exchanger.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	private List<Integer> list = new ArrayList<Integer>(10);
	private Exchanger<List<Integer>> exchanger;

	public Consumer(Exchanger<List<Integer>> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				list = exchanger.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(list.get(0) + ", ");
			System.out.print(list.get(1) + ", ");
			System.out.print(list.get(2) + ", ");
			System.out.print(list.get(3) + ", ");
			System.out.println(list.get(4) + ", ");
		}
	}
}
