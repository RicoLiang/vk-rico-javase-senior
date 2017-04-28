package com.vk.rico.javase.senior.thread.lock.cas;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class VkCasTester {

	public static Unsafe getUnsafeByReflect()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Unsafe.class.getDeclaredField("theUnsafe");

		field.setAccessible(true);

		Unsafe unsafe = (Unsafe) field.get(null);
		System.out.println(unsafe);
		return unsafe;
	}

	public static void main(String[] args) {
		try {
			Unsafe unsafe = getUnsafeByReflect();

			User user = (User) unsafe.allocateInstance(User.class);
			System.out.println(user);

			long nameFieldOffset = unsafe.objectFieldOffset(user.getClass().getDeclaredField("name"));
			long ageFieldOffset = unsafe.objectFieldOffset(user.getClass().getDeclaredField("age"));
			System.out.println(
					String.format("nameFieldOffset = %d\tageFieldOffset = %d", nameFieldOffset, ageFieldOffset));

			// 直接往内存地址写数据
			unsafe.putObject(user, nameFieldOffset, "Rico Liang");
			unsafe.putInt(user, ageFieldOffset, 22);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
