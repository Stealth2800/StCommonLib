package com.stealthyone.bukkit.stcommonlib.utils;

public final class StringUtils {

	public final static boolean equalsIgnoreCaseMultiple(String main, String... comparisons) {
		for (String cur : comparisons) {
			if (cur.equalsIgnoreCase(main)) {
				return true;
			}
		}
		return false;
	}
}