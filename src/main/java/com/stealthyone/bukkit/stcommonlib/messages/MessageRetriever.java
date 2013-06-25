package com.stealthyone.bukkit.stcommonlib.messages;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.stealthyone.bukkit.stcommonlib.storage.CustomGenericFileManager;
import com.stealthyone.bukkit.stcommonlib.utils.FileUtils;

public final class MessageRetriever {

	private JavaPlugin plugin;
	private CustomGenericFileManager messageFile;
	
	public MessageRetriever(JavaPlugin plugin) {
		this(plugin, "messages.yml");
	}
	
	public MessageRetriever(JavaPlugin plugin, String fileName) {
		this.plugin = plugin;
		messageFile = new CustomGenericFileManager(new File(plugin.getDataFolder() + File.separator + fileName));
		if (!messageFile.getFile().exists() || messageFile.isEmpty()) {
			FileUtils.copyGenericFileFromJar(plugin, fileName);
			messageFile.reloadConfig();
		} else {
			messageFile.copyDefaults(YamlConfiguration.loadConfiguration(plugin.getResource(fileName))); 
		}
	}
	
	public final void reloadMessages() {
		messageFile.reloadConfig();
	}
	
	public final String[] getMessage(IMessagePath message) {
		String[] returnString;
		String path = message.getPrefix() + message.getMessagePath();
		
		if (message.isList()) {
			returnString = (String[]) messageFile.getConfig().getStringList(path).toArray();
		} else {
			returnString = new String[]{messageFile.getConfig().getString(path)};
		}
		
		return returnString;
	}
}