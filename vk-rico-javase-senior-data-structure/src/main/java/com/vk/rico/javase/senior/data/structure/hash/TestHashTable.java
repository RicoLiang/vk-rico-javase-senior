package com.vk.rico.javase.senior.data.structure.hash;

import java.util.HashMap;
import java.util.Map;

public class TestHashTable {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, "a");
		map.put(null, "b");
		map.put("0", "c");
	}
}
