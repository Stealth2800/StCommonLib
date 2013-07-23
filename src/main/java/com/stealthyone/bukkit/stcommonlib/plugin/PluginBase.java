package com.stealthyone.bukkit.stcommonlib.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.stealthyone.bukkit.stcommonlib.logging.PluginLogger;

@Deprecated
public abstract class PluginBase extends JavaPlugin {

	protected PluginLogger log;
	
	public final String getVersion() {
		return this.getDescription().getVersion();
	}
	
	public final boolean isDebug() {
		return getConfig().getBoolean("Debug");
	}
	
	public final PluginLogger getLog() {
		return this.log;
	}
	
	public final void onLoad() {
		log = new PluginLogger(this);
	}
	
	public void onEnable() {		
		log.info(String.format("v%s enabled!", getVersion()));
	}
	
	public void onDisable() {
		log.info(String.format("v%s disabled!", getVersion()));
	}
}