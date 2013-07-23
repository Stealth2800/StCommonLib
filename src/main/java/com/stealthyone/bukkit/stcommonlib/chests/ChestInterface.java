package com.stealthyone.bukkit.stcommonlib.chests;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import com.stealthyone.bukkit.stcommonlib.storage.CustomGenericFileManager;
import com.stealthyone.bukkit.stcommonlib.storage.InventoryIO;
import com.stealthyone.bukkit.stcommonlib.utils.InventoryUtils;

/**
 * Used for storing items. Has the ability load and save in a configuration section
 * CONFIGURATION SECTION FORMAT:
 *   size: (size in int)
 *   title: (string)
 *   items:
 *     - (item list)
 * @author Stealth2800
 */
public class ChestInterface implements InventoryHolder {

	protected Inventory inventory;
	
	protected ConfigurationSection storageSection;
	protected CustomGenericFileManager storageFile;
	
	public ChestInterface(int size, String title) {
		this(size, title, null, null);
	}
	
	public ChestInterface(int size, String title, ConfigurationSection conf, CustomGenericFileManager file) {
		inventory = Bukkit.createInventory(this, size, title);
		setStorageLoc(conf, file);
	}
	
	public ChestInterface(ConfigurationSection conf, CustomGenericFileManager file) {
		this(conf.getInt("size"), conf.getString("title"), conf, file);
	}
	
	public final void setStorageLoc(ConfigurationSection conf, CustomGenericFileManager file) {
		this.storageSection = conf;
		this.storageFile = file;
	}
	
	public final void loadFromStorage() {
		if (storageSection == null)
			return;
		try {
			if (storageSection.getList("items").size() == 0) {
				return;
			}
		} catch (NullPointerException e) {
			return;
		}
		inventory = InventoryIO.loadFromConfSection(storageSection);
	}
	
	public final void saveToStorage() {
		saveToStorage(true);
	}
	
	public final void saveToStorage(boolean saveFile) {
		if (storageSection == null)
			return;
		InventoryIO.saveToConfSection(inventory, storageSection);
		if (saveFile)
			storageFile.saveFile();
	}
	
	public final void openInventory(Player player) {
		player.openInventory(inventory);
	}
	
	@Override
	public final Inventory getInventory() {
		return inventory;
	}
	
	public final int getContentCount() {
		return InventoryUtils.getItemCount(inventory);
	}

}