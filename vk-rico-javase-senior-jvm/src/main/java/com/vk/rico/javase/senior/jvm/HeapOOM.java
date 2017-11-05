package com.vk.rico.javase.senior.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * 
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError<br/>
 * -XX:+HeapDumpOnOutOfMemoryError：jvm出现内存溢出时Dump(转储)出当前的"内存堆转储快照文件"以便事后进行分析(内存映像分析工具)
 * 
 * @author Administrator
 *
 */
public class HeapOOM {

	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
