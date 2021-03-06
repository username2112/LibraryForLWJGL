package com.oroarmor.util;

public class StringUtils {

	/**
	 * Returns the count of {@code token} in {@code search}
	 * 
	 * @param token  The substring to search for
	 * @param search The string to search in
	 * @return The count of {@code token} in {@code search}
	 */
	public static int countOf(String token, String search) {
		int count = 0;

		for (int i = search.indexOf(token); i <= Math.min(search.lastIndexOf(token),
				search.length() - token.length() + 1); i++) {
			if (search.substring(i, i + token.length()).equals(token)) {
				count++;
			}
		}
		return count;
	}
}
