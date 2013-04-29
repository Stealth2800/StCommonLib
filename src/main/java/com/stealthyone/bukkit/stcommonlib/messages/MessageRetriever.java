package com.stealthyone.bukkit.stcommonlib.messages;

import org.bukkit.plugin.java.JavaPlugin;

import com.stealthyone.bukkit.stcommonlib.storage.CustomFileManager;
import com.stealthyone.bukkit.stcommonlib.utils.FileUtils;

public final class MessageRetriever {

	private JavaPlugin plugin;
	private CustomFileManager messageFile;
	
	public MessageRetriever(JavaPlugin plugin) {
		this.plugin = plugin;
		messageFile = new CustomFileManager(plugin, "messages");
		if (!messageFile.getFile().exists()) {
			FileUtils.copyFileFromJar(plugin, "messages.yml");
			messageFile.reloadConfig();
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