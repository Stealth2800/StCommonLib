package com.stealthyone.bukkit.stcommonlib.utils;

import org.bukkit.GameMode;

public final class GameModeUtils {

	public final static GameMode getGameMode(String input) throws IllegalArgumentException {
		if (StringUtils.equalsIgnoreCaseMultiple(input, "survival", "s")) {
			return GameMode.SURVIVAL;
		} else if (StringUtils.equalsIgnoreCaseMultiple(input, "creative", "c")) {
			return GameMode.CREATIVE;
		} else if (StringUtils.equalsIgnoreCaseMultiple(input, "adventure", "a")) {
			return GameMode.ADVENTURE;
		} else {
			throw new IllegalArgumentException("Illegal input: " + input + " for getGameMode()!");
		}
	}
}