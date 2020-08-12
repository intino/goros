package org.siani.goros.util;

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

	public static String clean(String text) {
		return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^a-zA-Z]", "");
	}

}
