package com.stealthyone.bukkit.stcommonlib.storage;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public final class InventoryIO {

	/**
	 * Saves inventory to file
	 * @param inventory Inventory to save
	 * @param file File to save to (must be empty/used specifically for this purpose for best results)
	 */
	public final static void saveToYaml(Inventory inventory, CustomGenericFileManager file) {
		file.getConfig().set("invName", inventory.getName());
		file.getConfig().set("invSize", inventory.getSize());
		file.getConfig().set("items", inventory.getContents());
		file.saveFile();
	}
	
	/**
	 * Loads inventory from file
	 * @param file File to load inventory from
	 * @return New inventory loaded from file
	 */
	public final static Inventory loadFromYaml(CustomGenericFileManager file) {
		String name = file.getConfig().getString("invName", "Unable to load name");
		int size = file.getConfig().getInt("invSize", 54);
		
		Inventory inventory = (name.equalsIgnoreCase("")) ? Bukkit.createInventory(null, size) : Bukkit.createInventory(null, size, name);
		
		List<?> list = file.getConfig().getList("items");
		
		for (int i = 0; i < size; i++) {
			if (list.get(i) != null) {
				inventory.setItem(i, (ItemStack) list.get(i));
			}
		}
		
		return inventory;
	}
}