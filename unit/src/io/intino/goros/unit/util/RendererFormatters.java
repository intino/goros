package io.intino.goros.unit.util;

import io.intino.itrules.Formatter;

import java.util.HashMap;
import java.util.Map;

public class RendererFormatters {
	public static Map<String, Formatter> all = new HashMap<>();

	static {
		all.put("validname", validName());
		all.put("camelCaseToKebabCase", camelCaseToKebabCase());
		all.put("camelCaseToSnakeCase", camelCaseToSnakeCase());
		all.put("returnType", returnType());
		all.put("returnTypeFormatter", returnTypeFormatter());
		all.put("validPackage", validPackage());
		all.put("subpath", subPath());
		all.put("shortType", shortType());
		all.put("quoted", quoted());
		all.put("customParameter", customParameter());
		all.put("dotsWithUnderscore", dotsWithUnderscore());
		all.put("slashToCamelCase", slashToCamel());
		all.put("typeFormat", typeFormatter());
	}

	public static Formatter validName() {
		return (value) -> StringHelper.snakeCaseToCamelCase(value.toString().replace(".", "-"));
	}

	public static Formatter camelCaseToKebabCase() {
		return value -> camelCaseTo(value.toString(), "-");
	}

	public static Formatter camelCaseToSnakeCase() {
		return value -> camelCaseTo(value.toString(), "_");
	}

	private static String camelCaseTo(String value, String separator) {
		if (value.isEmpty()) return value;
		StringBuilder result = new StringBuilder(String.valueOf(Character.toLowerCase(value.charAt(0))));
		for (int i = 1; i < value.length(); ++i)
			result.append(Character.isUpperCase(value.charAt(i)) ? separator + Character.toLowerCase(value.charAt(i)) : value.charAt(i));
		return result.toString();
	}

	public static Formatter returnType() {
		return value -> value.equals("Void") ? "void" : value;
	}

	public static String firstLowerCase(String value) {
		return value.substring(0, 1).toLowerCase() + value.substring(1);
	}

	public static String firstUpperCase(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	public static Formatter typeFormatter() {
		return value -> {
			if (value.toString().contains(".")) return RendererFormatters.firstLowerCase(value.toString());
			else return value;
		};
	}

	public static Formatter slashToCamel() {
		return o -> StringHelper.snakeCaseToCamelCase(o.toString().replace("|", "_"));
	}

	public static Formatter returnTypeFormatter() {
		return value -> {
			if (value.equals("Void")) return "void";
			else if (value.toString().contains(".")) return firstLowerCase(value.toString());
			else return value;
		};
	}

	public static Formatter quoted() {
		return value -> '"' + value.toString() + '"';
	}

	public static Formatter validPackage() {
		return value -> value.toString().replace("-", "").toLowerCase();
	}

	private static Formatter subPath() {
		return value -> {
			final String path = value.toString();
			return path.contains(":") ? path.substring(0, path.indexOf(":")) : path;
		};
	}

	public static Formatter shortType() {
		return value -> {
			String type = value.toString();
			final String[] s = type.split("\\.");
			return s[s.length - 1];
		};
	}

	private static Formatter customParameter() {
		return value -> value.toString().substring(1, value.toString().length() - 1);
	}

	private static Formatter dotsWithUnderscore() {
		return value -> value.toString().replaceAll("\\.", "_");
	}

}
