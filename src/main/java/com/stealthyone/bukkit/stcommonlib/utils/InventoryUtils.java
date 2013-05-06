package com.stealthyone.bukkit.stcommonlib.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public final class InventoryUtils {

	public static void removeItemFromHand(Player player, int amount) {
		PlayerInventory pi = player.getInventory();
		ItemStack handItem = pi.getItemInHand();
		if (handItem.getAmount() == 1) {
			pi.setItemInHand(null);
		} else {
			handItem.setAmount(handItem.getAmount() - 1);
			pi.setItemInHand(handItem);
		}
	}
	
	public static void removeItemsFromInventory(Player player, Material item, int amount) {
		PlayerInventory inventory = player.getInventory();
		
		ItemStack itemStack = inventory.getItem(item.getId());
		int itemCount = itemStack.getAmount();
		if (itemCount == 1) {
			inventory.remove(1);
			inventory.remove(itemStack);
		} else {
			itemStack.setAmount(itemCount - amount);
		}
	}
}