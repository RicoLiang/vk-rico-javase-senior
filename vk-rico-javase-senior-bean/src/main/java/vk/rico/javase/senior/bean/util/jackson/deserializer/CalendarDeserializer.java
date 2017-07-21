package vk.rico.javase.senior.bean.util.jackson.deserializer;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * json转换Calendar类特殊处理
 *
 */
public class CalendarDeserializer extends JsonDeserializer<Calendar> {

	@Override
	public Calendar deserialize(JsonParser jp, com.fasterxml.jackson.databind.DeserializationContext dc)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		Calendar c = Calendar.getInstance();
		long timeInMillis = 0;
		if (node.longValue() != 0) {
			timeInMillis = node.longValue();
		} else {
			timeInMillis = node.get("time").asLong();
		}
		c.setTimeInMillis(timeInMillis);
		return c;
	}
}
