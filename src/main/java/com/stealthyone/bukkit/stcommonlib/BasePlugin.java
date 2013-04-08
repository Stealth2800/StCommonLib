package com.stealthyone.bukkit.stcommonlib;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public final class BasePlugin extends JavaPlugin {
	
	public final void onEnable() {
		getLogger().log(Level.INFO, String.format("%s v%s by Stealth2800 enabled!", getName(), getVersion()));
	}
	
	public final void onDisable() {
		getLogger().log(Level.INFO, String.format("%s v%s by Stealth2800 disabled!", getName(), getVersion()));
	}
	
	/**
	 * Returns the version of the plugin
	 * @return String
	 */
	public final String getVersion() {
		return this.getDescription().getVersion();
	}
	
}