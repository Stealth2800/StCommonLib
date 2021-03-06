package com.stealthyone.bukkit.stcommonlib.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.stealthyone.bukkit.stcommonlib.permissions.IPermissionNode;

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
	
	public final static List<Player> getPlayerListWithPermission(Player[] onlinePlayers, IPermissionNode... permissions) {
		List<Player> returnList = new ArrayList<Player>();
		
		for (Player player : onlinePlayers) {
			for (IPermissionNode perm : permissions) {
				if (player.hasPermission(perm.get())) {
					returnList.add(player);
				}
			}
		}
		
		return returnList;
	}
	
	/**
	 * Returns the distance between two players
	 * @param player
	 * @param otherPlayer
	 * @return Null if players are in different worlds
	 */
	public final static double distanceFrom(Player player, Player otherPlayer) {
		Location pos1 = player.getLocation();
		Location pos2 = otherPlayer.getLocation();
		if (pos1.getWorld() != pos2.getWorld()) {
			return (Double) null;
		}
		return pos1.distance(pos2);
	}
}