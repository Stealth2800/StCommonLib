package com.stealthyone.bukkit.stcommonlib.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem {

	private ItemStack item;
	
	public CustomItem(ItemStack item) {
		this.item = item;
	}
	
	public final ItemStack getItemStack() {
		return this.item;
	}
	
	public final void setName(String newName) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(newName);
		item.setItemMeta(meta);
	}
	
	public final String getName() {
		return item.getItemMeta().getDisplayName();
	}
	
	public final void setLore(List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(null);
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	
	public final void addLore(List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	
	public final List<String> getLore() {
		return item.getItemMeta().getLore();
	}
	
	public final void setAuthor(String authorName) {
		if (!(item.getType() == Material.BOOK_AND_QUILL || item.getType() == Material.WRITTEN_BOOK))
			return;
		BookMeta meta = (BookMeta) item.getItemMeta();
		meta.setAuthor(null);
		item.setItemMeta(meta);
	}
	 
}