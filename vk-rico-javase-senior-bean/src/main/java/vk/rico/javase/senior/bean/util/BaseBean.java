package vk.rico.javase.senior.bean.util;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -149054033520991407L;

	private Integer id;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd，HH：00", timezone = "CET")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",with={JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
