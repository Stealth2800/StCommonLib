package com.stealthyone.bukkit.stcommonlib.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class PlayerUtils {

	public final static Player getPlayer(String name) throws NameMatchesNoPlayers, NameMatchesMultiplePlayersException {
		List<Player> matchedPlayers = Bukkit.matchPlayer(name);
		
		if (matchedPlayers.size() == 0) {
			throw new NameMatchesNoPlayers("Name: " + name + " doesn't match any online players!");
		} else if (matchedPlayers.size() > 1) {
			throw new NameMatchesMultiplePlayersException("Name: " + name + " matches multiple online players!");
		} else {
			return Bukkit.getPlayer(name);
		}
	}
}