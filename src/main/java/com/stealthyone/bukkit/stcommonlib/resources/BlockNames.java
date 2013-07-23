package com.stealthyone.bukkit.stcommonlib.resources;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;

import com.stealthyone.bukkit.stcommonlib.BasePlugin;
import com.stealthyone.bukkit.stcommonlib.storage.CustomJarFileManager;

public final class BlockNames {

	private final static Map<String, Material> blockNames = initMap();
	
	private final static Map<String, Material> initMap() {
		CustomJarFileManager blockNamesFile = new CustomJarFileManager(BasePlugin.getInstance(), "blocks.yml");
		Map<String, Material> m = new HashMap<String, Material>();
		for (String blockName : blockNamesFile.getConfig().getKeys(false)) {
			if (Material.valueOf(blockName) == null)
				continue;
			for (String alias : blockNamesFile.getConfig().getStringList(blockName)) {
				m.put(alias, Material.valueOf(blockName));
			}
		}
		return Collections.unmodifiableMap(m);
	}

	/**
	 * Attempts to match a material name from a given string
	 * @param input
	 * @return Null if unable to find/doesn't exist
	 */
	public final static Material getMaterialByName(String input) {
		Material returnMaterial = Material.valueOf(input);
		if (returnMaterial == null) {
			returnMaterial = Material.valueOf(input.toUpperCase());
			if (returnMaterial == null) {
				returnMaterial = blockNames.get(input);
			}
		}
		return returnMaterial;
	}
	
}