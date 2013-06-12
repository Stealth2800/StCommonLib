package com.stealthyone.bukkit.stcommonlib.utils;

import java.util.Random;

public final class RandomUtils {

	public final static String getRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}

		return sb.toString();
	}
	
}