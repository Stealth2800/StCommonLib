package com.stealthyone.bukkit.stcommonlib.storage;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Custom file that uses YML config
 * @author austin
 */
public class CustomGenericFileManager {

	private File customFile;
	private FileConfiguration customConfig;

	@Deprecated
	public CustomGenericFileManager(JavaPlugin plugin, File file) {
		this.customFile = file;
		this.reloadConfig();
	}
	
	public CustomGenericFileManager(File file) {
		this.customFile = file;
		this.reloadConfig();
	}
	
	public final void copyDefaults(FileConfiguration otherConfig) {
		customConfig.addDefaults(otherConfig);
		customConfig.options().copyDefaults(true);
		saveFile();
	}
	
	/**
	 * Returns the file
	 * @return Custom file
	 */
	public final File getFile() {
		return this.customFile;
	}
	
	public final void rename(String newName) {
		File newDest = new File(newName);
		customFile.renameTo(newDest);
		customFile = newDest;
	}
	
	/**
	 * Reload file from disk
	 */
	public void reloadConfig() {
		if (!customFile.exists()) {
			try {
				customFile.createNewFile();
				saveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		customConfig = YamlConfiguration.loadConfiguration(customFile);
	}

	/**
	 * Return the config from file
	 * @return
	 */
	public FileConfiguration getConfig() {
		if (customConfig == null) {
			this.reloadConfig();
		}
		return customConfig;
	}

	/**
	 * Returns if the config is empty or not
	 * @return True if empty
	 */
	public boolean isEmpty() {
		return customConfig.getKeys(false).size() == 0;
	}
	
	/**
	 * Save changes to file on disk
	 * @throws IOException 
	 */
	public void saveFile() {
        if (customConfig == null || customFile == null) {
        	this.reloadConfig();
        } else {
        	try {
				this.getConfig().save(customFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

}