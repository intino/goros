package io.intino.goros.unit.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class Formatters {

	private static final String DateFormat = "EEEE, d MMM yyyy HH:mm:ss Z";
	private static final String ShortDateFormat = "dd-MM-yyyy HH:mm";
	private static final String DownloadDateFormat = "ddMMYYYY";
	private static final String OnlyMonthFormat = "MMMM yyyy";
	private static final String OnlyDateFormat = "EEEE, d MMMM yyyy";
	private static final String OnlyShortDateFormat = "dd-MM-yyyy";
	private static final String OnlyShortMonthFormat = "MM-yyyy";
	private static final String OnlyDayFormat = "dd";
	private static final String OnlyHourFormat = "HH:mm:ss Z";
	private static final String OnlyShortHourFormat = "HH:mm";

	public static String date(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(DateFormat, fecha);
	}

	public static String shortDate(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(ShortDateFormat, fecha);
	}

	public static String onlyMonthOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyMonthFormat, fecha);
	}

	public static String onlyDateOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyDateFormat, fecha);
	}

	public static String onlyDayOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyDayFormat, fecha);
	}

	public static String onlyShortDateOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyShortDateFormat, fecha);
	}

	public static String onlyShortMonthOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyShortMonthFormat, fecha);
	}

	public static String onlyHourOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyHourFormat, fecha);
	}

	public static String onlyShortHourOf(Instant fecha) {
		if (fecha == null) return null;
		return formatDate(OnlyShortHourFormat, fecha);
	}

	public static String downloadDate(Instant fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat(DownloadDateFormat, new Locale("es", "ES"));
		return formatter.format(new Date(fecha.toEpochMilli()));
	}

	public static String downloadDate(Instant fecha, String extension) {
		return downloadDate(fecha) + "." + extension;
	}

	public static String firstUpperCase(String content) {
		return content.substring(0, 1).toUpperCase() + content.substring(1);
	}

	public static String countMessage(long count, String singleLabel, String pluralLabel) {
		if (count <= 0) return "Sin " + pluralLabel;
		if (count == 1) return "1 " + singleLabel;
		return count + " " + pluralLabel;
	}

	public static String formattedNumber(double value) {
		return formattedNumber(value, Locale.getDefault());
	}

	public static String formattedNumber(double value, Locale locale) {
		return NumberFormat.getNumberInstance(locale).format(round(value, 2));
	}

	private static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	private static String formatDate(String pattern, Instant instant) {
		SimpleDateFormat format = new SimpleDateFormat(pattern, new Locale("es", "ES"));
		return format.format(Date.from(instant));
	}
}
