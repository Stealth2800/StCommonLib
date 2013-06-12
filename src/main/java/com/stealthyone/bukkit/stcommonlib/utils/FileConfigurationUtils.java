package com.stealthyone.bukkit.stcommonlib.utils;

import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;

public final class FileConfigurationUtils {

	public final static void cloneConfigurationSection(FileConfiguration file, ConfigurationSection oldSection, String newSectionName) {		
		Map<String, Object> oldSectionMap = oldSection.getValues(true);
		for (String key : oldSectionMap.keySet()) {
			if (oldSectionMap.get(key) instanceof ConfigurationSection) {
				cloneConfigurationSection(file, (MemorySection) oldSectionMap.get(key), newSectionName + "." + key);
			} else {
				file.set(newSectionName + "." + key, oldSectionMap.get(key));
			}
		}
	}
	
}