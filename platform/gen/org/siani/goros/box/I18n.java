package org.siani.goros.box.ui;

import java.util.HashMap;
import java.util.Map;

public class I18n {
	private static Map<String, Map<String, String>> dictionaries = new HashMap<>();

	public static String translate(String word, String language) {
		language = dictionaries.containsKey(language) ? language : "en";
		Map<String, String> languageDictionary = dictionaries.get(language);
		return languageDictionary != null && languageDictionary.containsKey(word) ? languageDictionary.get(word) : word;
	}
}