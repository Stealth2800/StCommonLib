package com.stealthyone.bukkit.stcommonlib.utils;

import java.math.BigDecimal;

public final class NumberUtils {

	public final static boolean isStringInteger(String input) {
		try {
			Integer.valueOf(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public final static double round(double unrounded, int precision, int roundingMode) {
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}
}