package vk.rico.javase.senior.bean.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import vk.rico.javase.senior.bean.util.jackson.JsonUtils;

public class BeanUtilTest {
	// Map --> Bean 2: 利用org.apache.commons.beanutils 工具类实现 Map --> Bean
	public static void transMap2Bean2(Map<String, Object> map, Object obj) {
		if (map == null || obj == null) {
			return;
		}
		try {
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			System.out.println("transMap2Bean2 Error " + e);
		}
	}

	// Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
	public static void transMap2Bean(Map<String, Object> map, Object obj) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (map.containsKey(key)) {
					Object value = map.get(key);
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}
			}
		} catch (Exception e) {
			System.out.println("transMap2Bean Error " + e);
		}
		return;
	}

	// Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
	public static Map<String, Object> transBean2Map(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}
			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}
		return map;
	}

	public static void main(String[] args) {
		PersonBean person = new PersonBean();
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("name", "Mike");
		mp.put("age", 25);
		mp.put("mN", "male");
		mp.put("score", 1.12F);
		mp.put("money", 3.19);
		mp.put("flag", false);
		mp.put("amount", new BigDecimal(90.3F));
		mp.put("date", new Date());
		mp.put("id", 20170721);
		mp.put("Total", 89);

		// 将map转换为bean
		transMap2Bean2(mp, person);
		// transMap2Bean(mp, person);

		System.out.println("--- transMap2Bean Map Info: ");
		for (Map.Entry<String, Object> entry : mp.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("--- Bean Info: ");
		System.out.println("name: " + person.getName());
		System.out.println("age: " + person.getAge());
		System.out.println("mN: " + person.getmN());

		// 将javaBean 转换为map
		Map<String, Object> map = transBean2Map(person);

		System.out.println("--- transBean2Map Map Info: ");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		try {
			PersonBean convertValue = JsonUtils.convertValue(mp, PersonBean.class);

			String json = JsonUtils.toJson(convertValue);
			System.out.println(json);
			Map convertValue2 = JsonUtils.convertValue(convertValue, Map.class);
			System.out.println(convertValue);
			System.out.println(convertValue2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
