package com.stealthyone.bukkit.stcommonlib.utils;

import java.util.Random;

public final class RandomUtils {

	public final static String getRandomString(int length) {
		return getRandomString(length, false);
	}
	
	public final static String getRandomString(int length, boolean withNumbers) {
		char[] chars = withNumbers ? "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray() : "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}

		return sb.toString();
	}
	
}