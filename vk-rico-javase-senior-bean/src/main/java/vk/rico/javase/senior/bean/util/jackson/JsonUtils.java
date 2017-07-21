package vk.rico.javase.senior.bean.util.jackson;

import java.util.Calendar;

import javax.xml.datatype.Duration;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.module.SimpleModule;

import vk.rico.javase.senior.bean.util.jackson.deserializer.CalendarDeserializer;
import vk.rico.javase.senior.bean.util.jackson.deserializer.DurationDeserializer;

/**
 * jackson工具类
 * 
 * @author liangxf
 *
 */
public class JsonUtils {

	private final static ObjectMapper om = new ObjectMapper();

	static {
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		om.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(Visibility.ANY));
		om.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true); // 排序转换,用于字符串比较

		// 解析器
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Calendar.class, new CalendarDeserializer());
		module.addDeserializer(Duration.class, new DurationDeserializer());
		om.registerModule(module);
	}

	/**
	 * 对象转为string
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object obj) throws Exception {
		return om.writeValueAsString(obj);
	}

	/**
	 * 支持大小写字段转换；匹配不上字段会赋予初始值
	 * 
	 * @param classtype
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static <T> T toObject(String jsonStr, Class<T> classtype) throws Exception {
		return om.readValue(jsonStr, classtype);
	}

	/**
	 * 转换成泛型List对象
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param collectionClass
	 *            List.class
	 * @param elementClasses
	 *            Bean.class
	 * @return List<Bean>
	 * @throws Exception
	 */
	public static <T> T toObject(String jsonStr, Class<?> collectionClass, Class<?> elementClasses) throws Exception {
		JavaType javaType = om.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		return om.readValue(jsonStr, javaType);
	}

	/**
	 * 转换成泛型VO对象
	 */
	public static <T> T convertValue(Object fromValue, Class<T> toValueType) throws Exception {
		return om.convertValue(fromValue, toValueType);
	}
}
