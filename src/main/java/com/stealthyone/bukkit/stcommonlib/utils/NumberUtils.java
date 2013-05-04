package com.stealthyone.bukkit.stcommonlib.utils;

public final class NumberUtils {

	public final static boolean isStringInteger(String input) {
		try {
			Integer.valueOf(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}