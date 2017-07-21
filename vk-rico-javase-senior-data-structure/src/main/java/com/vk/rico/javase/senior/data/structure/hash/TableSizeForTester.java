package com.vk.rico.javase.senior.data.structure.hash;

import com.vk.rico.javase.senior.data.structure.hash.hashmap.VkHashMap;

public class TableSizeForTester {

	public static void main(String[] args) {
		int cap = 33;
		int n = cap - 1; // 32 = 2^5

		n |= n >>> 1; // n = 32 + 16 = 48
		n |= n >>> 2; // n =
		System.out.println(n);
		System.out.println(tableSizeFor(-109));

		int hashCode = Long.hashCode(Long.MAX_VALUE);
		System.out.println(hashCode);

		long i = 8589934591L;
		int index = (3 % (int) (i >>> 32)); // i >>> 32是i的的hashcode值
		System.out.println("index = " + index);
		int index2 = 3 & (int) (i >>> 32);
		System.out.println("index2 = " + index2);

		int code = hashCode(8589934591L);
		System.out.println("code = " + code);
		int hash = hash(8589934591L);
		System.out.println("hash = " + hash);

		VkHashMap<Long, Long> vals = new VkHashMap<Long, Long>(8);
		vals.put(8589934591L, 8589934591L);
		System.out.println(vals);
	}

	public static int hashCode(long value) {
		return (int) (value ^ (value >>> 32));
	}

	public static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	/**
	 * table的最大容量，capacity值的必须是2^n，且最大值是 2^30<br/>
	 * HashMap的构造方法中可以指定capacity值<br/>
	 */
	private static final int MAXIMUM_CAPACITY = 1 << 30;

	/**
	 * Returns a power of two size for the given target capacity.
	 */
	public static final int tableSizeFor(int cap) {
		// 返回结果x，x>=cap，且x是2^n(n>=0)，且最小的2^n
		int n = cap - 1;
		n |= n >>> 1; // 2^0
		n |= n >>> 2; // 2^1
		n |= n >>> 4; // 2^2
		n |= n >>> 8; // 2^3
		n |= n >>> 16; // 2^4

		// 返回值的范围是：2^0 <= x <= 2^30
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}
}
