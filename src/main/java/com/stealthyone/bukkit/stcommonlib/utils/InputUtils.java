package com.stealthyone.bukkit.stcommonlib.utils;

public final class InputUtils {

	/**
	 * Gets a boolean value out of a certain 
	 * @param value Input value
	 * @return True for yes/y/true/t, False for no/n/false/f
	 */
	public final static boolean parseBoolean(String value) {
		switch (value) {
			case "yes": case "y": case "true": case "t":
				return true;
			case "no": case "n": case "false": case "f":
				return false;
		}
		throw new IllegalArgumentException();
	}
	
}