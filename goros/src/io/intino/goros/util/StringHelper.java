package io.intino.goros.util;

import java.text.Normalizer;

public class StringHelper {

	public static String validName(String text) {
		StringBuilder sb = new StringBuilder();
		if(!Character.isJavaIdentifierStart(text.charAt(0))) sb.append("_");

		for (char c : text.toCharArray()) {
			if(!Character.isJavaIdentifierPart(c)) {
				sb.append("_");
			} else {
				sb.append(c);
			}
		}

		return clean(sb.toString()).toLowerCase();
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
