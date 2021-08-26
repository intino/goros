package io.intino.goros.unit.util;

import java.text.Normalizer;

public class StringHelper {

	public static String validName(String name) {
		if (name == null) return null;
		name = name.replace("/", "-").replace(" ", "-").replace("_", "-");
		return stripAccents(firstLowerCase(snakeCaseToCamelCase(name)));
	}

	public static String stripAccents(String s) {
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return s;
	}

	public static String firstUpperCase(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	public static String firstLowerCase(String value) {
		return value.substring(0, 1).toLowerCase() + value.substring(1);
	}

	public static String snakeCaseToCamelCase(String string) {
		if (string.isEmpty()) {
			return string;
		} else {
			String result = "";
			String[] var2 = string.replace("_", "-").split("-");
			int var3 = var2.length;

			for(int var4 = 0; var4 < var3; ++var4) {
				String part = var2[var4];
				result = result + String.valueOf(Character.toUpperCase(part.charAt(0))) + part.substring(1);
			}

			return result;
		}
	}

	public static String clean(String text) {
		return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^a-zA-Z]", "");
	}

}
