package net.jineric.optilite.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsOL {
	
	// Converts a snake case string into separated words which are capitalized
	// EX: "first_second" becomes "First Second"
	// USE: Convert a resource path into a title
	public static String snakeCaseToCapitalized(String path) {
		String trimUnderscore = path.replace('_', ' ');
		StringBuilder result = new StringBuilder(path.length());
		StringBuilder wordBuilder = new StringBuilder();
		int stringLength = 0;
		for (char c : trimUnderscore.toCharArray()) {
			stringLength++;
			wordBuilder.append(c);
			if (Character.isSpaceChar(c) || stringLength == path.length()) {
				result.append(StringUtils.capitalize(wordBuilder.toString()));
				wordBuilder = new StringBuilder();
			}
		}
		return result.toString();
	}
	
	// Converts a snake case string into camel case
	// EX: "first_second" becomes "firstSecond"
	// USE: Convert a resource path into a translation key
	public static String snakeToCamelCase(String path) {
		String trimUnderscore = path.replace('_', ' ');
		StringBuilder result = new StringBuilder(path.length());
		StringBuilder wordBuilder = new StringBuilder();
		int stringLength = 0;
		boolean capitalizeNext = false;
		for (char c : trimUnderscore.toCharArray()) {
			stringLength++;
			wordBuilder.append(c);
			if (Character.isSpaceChar(c) || stringLength == path.length()) {
				result.append(capitalizeNext ? StringUtils.capitalize(wordBuilder.toString()) : wordBuilder);
				capitalizeNext = true;
				wordBuilder = new StringBuilder();
			}
		}
		return result.toString().replace(" ", "");
	}
}
