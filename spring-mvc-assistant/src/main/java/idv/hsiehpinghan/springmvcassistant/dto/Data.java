package idv.hsiehpinghan.springmvcassistant.dto;

import java.util.Date;

public class Data {
	private Integer integerValue;
	private Float floatValue;
	private String stringValue;
	private Date dateValue;

	public Data(Integer integerValue, Float floatValue, String stringValue,
			Date dateValue) {
		super();
		this.integerValue = integerValue;
		this.floatValue = floatValue;
		this.stringValue = stringValue;
		this.dateValue = dateValue;
	}

	public Integer getIntegerValue() {
		return integerValue;
	}

	public void setIntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}

	public Float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

}
