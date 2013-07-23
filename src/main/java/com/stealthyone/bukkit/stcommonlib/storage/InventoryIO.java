package com.stealthyone.bukkit.stcommonlib.storage;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public final class InventoryIO {

	/**
	 * Saves inventory to file and saves to disk
	 * @param inventory Inventory to save
	 * @param file File to save to (must be empty/used specifically for this purpose for best results)
	 */
	public final static void saveToYaml(Inventory inventory, CustomGenericFileManager file) {
		saveToYaml(inventory, file, true);
	}
	
	/**
	 * Saves inventory to file
	 * @param inventory
	 * @param file
	 * @param save True to save to disk
	 */
	public final static void saveToYaml(Inventory inventory, CustomGenericFileManager file, boolean save) {
		file.getConfig().set("invName", inventory.getName());
		file.getConfig().set("invSize", inventory.getSize());
		file.getConfig().set("items", inventory.getContents());
		if (save)
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
	
	/**
	 * Loads an inventory from a configuration section. Configuration section must include 'title', 'size', and 'items'
	 * @param config
	 * @return
	 */
	public final static Inventory loadFromConfSection(ConfigurationSection config) {
		String title = config.getString("title");
		int size = config.getInt("size");
		
		Inventory inventory = (title.equalsIgnoreCase("")) ? Bukkit.createInventory(null, size) : Bukkit.createInventory(null, size, title);
		
		List<?> list = config.getList("items");
		for (int i = 0; i < size; i++) {
			if (list.get(i) != null)
				inventory.setItem(i, (ItemStack) list.get(i));
		}
		
		return inventory;
	}
	
	/**
	 * Saves config section to file. A save function for the master file should be called after this to save changes to the file
	 * @param inventory
	 * @param config
	 */
	public final static void saveToConfSection(Inventory inventory, ConfigurationSection config) {
		config.set("title", inventory.getName());
		config.set("size", inventory.getSize());
		config.set("items", inventory.getContents());
	}
	
}