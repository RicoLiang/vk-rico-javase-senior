package vk.rico.javase.senior.bean.util.jackson;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;

/**
 * JodaTime日期时间工具类
 * 
 * @author liangxf
 *
 */
public class JodaTimeUtil {

	public final static String YYYYMMDD = "yyyyMMdd";
	public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public final static String YYYYMMDDHHMMSS2 = "yyyyMMddHHmmss";
	public final static String MMDDYYYYHHMMSS = "MM/dd/yyyy HH:mm:ss";
	public final static String YYYYMMDDHHMMSSSSSZ = "yyyyMMddHHmmssSSSZ";
	public final static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public final static String UTCYYYYMMDDHHMMSSSSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	/**
	 * 中原标准时区 GMT+8，即北京时区
	 */
	public final static DateTimeZone CTT = DateTimeZone.forID("Asia/Shanghai");

	public static String getNowDateStr(String ymdFormat) {
		DateTime now = getNow();
		ymdFormat = StringUtils.isNotBlank(ymdFormat) ? ymdFormat : YYYYMMDD;
		return now.toString(DateTimeFormat.forPattern(ymdFormat));
	}

	public static String getNowStr(String format) {
		DateTime now = getNow();
		format = StringUtils.isNotBlank(format) ? format : YYYYMMDDHHMMSS;
		return now.toString(DateTimeFormat.forPattern(format));
	}

	/**
	 * 获取系统当前时间，北京时区
	 * 
	 * @return
	 */
	public static DateTime getNow() {
		DateTime now = new DateTime(CTT);
		return now;
	}

	/**
	 * 
	 * @param timeZone
	 *            时区，默认为UTC
	 * @return
	 */
	public static DateTime getNow(DateTimeZone timeZone) {
		if (null == timeZone) {
			timeZone = DateTimeZone.UTC;
		}
		DateTime now = new DateTime(timeZone);
		return now;
	}

	/**
	 * 将dateTime格式化成字符串
	 * 
	 * @param dateTime
	 *            日期
	 * @param format
	 *            格式字符串，默认是yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String convert2String(DateTime dateTime, String format) {
		format = StringUtils.isNotBlank(format) ? format : YYYYMMDDHHMMSS;
		return dateTime.toString(DateTimeFormat.forPattern(format));
	}

	/**
	 * java.util.Date转换成 org.joda.time.DateTime
	 * 
	 * @param date
	 *            java.util.Date对象，不能为null
	 * @param timeZone
	 *            时区，默认是北京时区
	 * @return
	 */
	public static DateTime convert2DateTime(Date date, DateTimeZone timeZone) {
		if (null == date) {
			throw new IllegalArgumentException("date parameters cannot be null");
		}
		if (null == timeZone) {
			timeZone = CTT;
		}
		return new DateTime(date.getTime(), timeZone);
	}

	/**
	 * 日期减少指定天数
	 * 
	 * @param date
	 *            默认为当前时间
	 * @param hours
	 *            天数，必须大于0
	 * @return
	 */
	public static DateTime minusDays(DateTime date, int days) {
		if (days < 0) {
			throw new IllegalArgumentException("days parameters must be greater than zero");
		}
		date = (null == date ? getNow() : date);
		return date.minusDays(days);
	}

	/**
	 * 日期减少小时数
	 * 
	 * @param date
	 *            默认为当前时间
	 * @param hours
	 *            小时数，必须大于0
	 * @return
	 */
	public static DateTime minusHours(DateTime date, int hours) {
		if (hours < 0) {
			throw new IllegalArgumentException("hours parameters must be greater than zero");
		}
		date = (null == date ? getNow() : date);
		return date.minusHours(hours);
	}

	/**
	 * 日期增加小时数
	 * 
	 * @param date
	 *            默认为当前时间
	 * @param hours
	 *            小时数，必须大于0
	 * @return
	 */
	public static DateTime plusHours(DateTime date, int hours) {
		if (hours < 0) {
			throw new IllegalArgumentException("hours parameters must be greater than zero");
		}
		date = (null == date ? getNow() : date);
		return date.plusHours(hours);
	}

	/**
	 * 日期增加秒数
	 * 
	 * @param date
	 *            日期，不能为null
	 * @param seconds
	 *            秒数，必须大于0
	 * @return
	 */
	public static DateTime plusSeconds(DateTime date, int seconds) {
		if (null == date) {
			throw new IllegalArgumentException("date parameters cannot be null");
		}
		if (seconds < 0) {
			throw new IllegalArgumentException("seconds parameters must be greater than zero");
		}
		return date.plusSeconds(seconds);
	}

	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param d1
	 *            开始日期
	 * @param d2
	 *            结束日期
	 * @return
	 */
	public static int daysBetween(DateTime d1, DateTime d2) {
		if (null == d1 || null == d2) {
			throw new IllegalArgumentException("parameters cannot be null");
		}
		return Days.daysBetween(d1, d2).getDays();
	}

	/**
	 * 计算两个日期相差的小时数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int hoursBetween(DateTime d1, DateTime d2) {
		if (null == d1 || null == d2) {
			throw new IllegalArgumentException("parameters cannot be null");
		}
		return Hours.hoursBetween(d1, d2).getHours();
	}

	/**
	 * 计算两个日期相差的秒数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int secondsBetween(DateTime d1, DateTime d2) {
		if (null == d1 || null == d2) {
			throw new IllegalArgumentException("parameters cannot be null");
		}
		return Seconds.secondsBetween(d1, d2).getSeconds();
	}

	/**
	 * @return a new ISO 8601 date formatter
	 */
	public static DateFormat createISODateFormat() {
		DateFormat df = new SimpleDateFormat(UTCYYYYMMDDHHMMSSSSSZ);
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		return df;
	}

	/**
	 * Date转换成Timestamp
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp parseDate2Timestamp(DateTime date) {
		if (null == date) {
			date = getNow();
		}
		return new Timestamp(date.getMillis());
	}

	/**
	 * 转换成本地时间，本地时区是东8区
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            转换格式，默认是yyyyMMddHHmmssSSSZ
	 * @return
	 */
	public static Date parse2Date(String dateStr, String format) {
		format = StringUtils.isBlank(format) ? YYYYMMDDHHMMSSSSSZ : format;
		DateTime d = parse2DateTime(dateStr, format);
		return d.toDate();
	}

	/**
	 * 转换成本地时间，本地时区是东8区
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            转换格式，默认是yyyyMMddHHmmssSSSZ
	 * @return
	 */
	public static DateTime parse2DateTime(String dateStr, String format) {
		format = StringUtils.isBlank(format) ? YYYYMMDDHHMMSSSSSZ : format;
		DateTime d = DateTime.parse(dateStr, DateTimeFormat.forPattern(format));
		return d;
	}

	/**
	 * 将日期字符串转换成DateTime，丢弃时区
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            转换格式，默认是YYYYMMDDHHMMSSSSS
	 * @return
	 */
	public static DateTime parse2DateTimeDiscardTimeZone(String dateStr, String format) {
		format = StringUtils.isBlank(format) ? YYYYMMDDHHMMSSSSS : format;
		if (dateStr.contains("-")) {
			dateStr = StringUtils.split(dateStr, "-")[0];
		}
		if (StringUtils.contains(dateStr, "+")) {
			dateStr = StringUtils.split(dateStr, "+")[0];
		}
		DateTime d = DateTime.parse(dateStr, DateTimeFormat.forPattern(format));
		return d;
	}

	/**
	 * 将日期字符串转换成DateTime，丢弃时区
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            转换格式，默认是YYYYMMDDHHMMSSSSS
	 * @return
	 */
	public static Date parse2DateDiscardTimeZone(String dateStr, String format) {
		DateTime d = parse2DateTimeDiscardTimeZone(dateStr, format);
		return d.toDate();
	}

}
