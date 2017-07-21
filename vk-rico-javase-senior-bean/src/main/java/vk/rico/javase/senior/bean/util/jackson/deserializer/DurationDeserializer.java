package vk.rico.javase.senior.bean.util.jackson.deserializer;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * json转换Duration类特殊处理
 * 
 */
public class DurationDeserializer extends JsonDeserializer<Duration> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DurationDeserializer.class);

	@Override
	public Duration deserialize(JsonParser jp, com.fasterxml.jackson.databind.DeserializationContext dc)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);

		Duration duration = null;
		try {
			if (StringUtils.isNotEmpty(node.asText())) {
				duration = DatatypeFactory.newInstance().newDuration(node.asText());
			} else {
				String result = "P";
				result += (node.get("days") != null ? node.get("days").asText() : 0) + "DT";
				result += (node.get("hours") != null ? node.get("hours").asText() : 0) + "H";
				result += (node.get("minutes") != null ? node.get("minutes").asText() : 0) + "M";
				result += (node.get("seconds") != null ? node.get("seconds").asText() : 0) + "S";
				duration = DatatypeFactory.newInstance().newDuration(result);
			}
		} catch (DatatypeConfigurationException e) {
			LOGGER.error("转换Duration失败", e);
		}
		return duration;
	}
}
