package org.monet.bpi.types;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

	public static final String INTERNAL = "internal";
	private static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss,SS";

	@Attribute(name = INTERNAL)
	private java.util.Date value;
	@Text
	private String formattedValue;

	public Date(Date date) {
	}

	public Date() {
	}

	public Date(java.util.Date date) {
	}

	public Date(long time) {
		this(new java.util.Date(time));
	}

	public Date(String format) {
	}

	public Date(java.util.Date date, String format) {
	}

	public Date(String date, String format) throws ParseException {

	}

	public void setValue(java.util.Date value) {
		this.value = value;
		this.formattedValue = buildFormatter(DEFAULT_DATE_FORMAT).format(this.value);
	}

	public java.util.Date getValue() {
		return value;
	}

	public void setFormattedValue(String formattedValue) {
		this.formattedValue = formattedValue;
	}

	public String getFormattedValue() {
		return formattedValue;
	}

	public boolean equals(Date obj) {
		return this.value.equals(obj.getValue()) && this.formattedValue.equals(obj.getFormattedValue());
	}

	@Override
	public String toString() {
		return this.formattedValue;
	}

	public String toString(String format) {
		SimpleDateFormat formatter = buildFormatter(format);
		return formatter.format(this.value);
	}

	public int millisecondsUntil(Date dateTime) {
		return -1;
	}

	public int secondsUntil(Date dateTime) {
		return -1;
	}

	public int minutesUntil(Date dateTime) {
		return -1;
	}

	public int hoursUntil(Date dateTime) {
		return -1;
	}

	public int daysUntil(Date dateTime) {
		return -1;
	}

	public int weeksUntil(Date dateTime) {
		return -1;
	}

	public int monthsUntil(Date dateTime) {
		return -1;
	}

	public int yearsUntil(Date dateTime) {
		return -1;
	}

	public Date plus(long l) {
		return this;
	}

	public Date plusYears(int years) {
		return this;
	}

	public Date plusMonths(int months) {
		return this;
	}

	public Date plusWeeks(int weeks) {
		return this;
	}

	public Date plusDays(int days) {
		return this;
	}

	public Date plusHours(int hours) {
		return this;
	}

	public Date plusMinutes(int minutes) {
		return this;
	}

	public Date plusSeconds(int seconds) {
		return this;
	}

	public Date plusMillis(int milliseconds) {
		return this;
	}

	public Date minus(long l) {
		return this;
	}

	public Date minusYears(int years) {
		return this;
	}

	public Date minusMonths(int months) {
		return this;
	}

	public Date minusWeeks(int weeks) {
		return this;
	}

	public Date minusDays(int days) {
		return this;
	}

	public Date minusHours(int hours) {
		return this;
	}

	public Date minusMinutes(int minutes) {
		return this;
	}

	public Date minusSeconds(int seconds) {
		return this;
	}

	public Date minusMillis(int milliseconds) {
		return this;
	}

	public boolean before(Date when) {
		return this.value.before(when.value);
	}

	public boolean after(Date when) {
		return this.value.after(when.value);
	}

	public boolean isInInterval(Date from, Date to) {
		return false;
	}

	public static Date parse(String pattern, String text) throws ParseException {
		if (text == null || text.trim().length() == 0)
			return null;
		java.util.Date date = buildFormatter(pattern).parse(text);
		Date datetime = new Date(date);
		return datetime;
	}

	public static SimpleDateFormat buildFormatter(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

//		TimeZone timeZone = BusinessUnit.getTimeZone();
//		if (timeZone != null)
//			formatter.setTimeZone(timeZone);

		return formatter;
	}

}
