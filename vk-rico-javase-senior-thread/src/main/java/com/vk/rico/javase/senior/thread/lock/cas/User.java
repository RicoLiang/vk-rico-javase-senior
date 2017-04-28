package com.vk.rico.javase.senior.thread.lock.cas;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7239240057038181676L;

	private String name = "default name value";

	private int age = 1;

	public User() {
		System.out.println("这是无参构造器");
	}

	public User(String name, int age) {
		System.out.println("这是有参构造器");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("name = %s\tage = %d", this.name, this.age);
	}
}
