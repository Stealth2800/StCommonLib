package com.stealthyone.bukkit.stcommonlib.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class MiscUtils {

	public final static String convertWeVectorToString(com.sk89q.worldedit.Vector vector) {
		String x = Integer.toString(vector.getBlockX());
		String y = Integer.toString(vector.getBlockY());
		String z = Integer.toString(vector.getBlockZ());
		return x + ", " + y + ", " + z;
	}
	
	public final static ItemStack[] replaceNullItems(ItemStack[] items) {
		ItemStack[] returnArray = new ItemStack[items.length];
		for (int i = 0; i < items.length; i++) {
			if (items[0] == null) {
				returnArray[i] = new ItemStack(Material.AIR, 1);
			} else {
				returnArray[i] = items[i];
			}
		}
		return returnArray;
	}
	
}