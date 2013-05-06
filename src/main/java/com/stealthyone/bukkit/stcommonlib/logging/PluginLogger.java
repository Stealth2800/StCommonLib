package com.stealthyone.bukkit.stcommonlib.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.stealthyone.bukkit.stcommonlib.plugin.PluginBase;

public final class PluginLogger {

	private PluginBase plugin;
	private Logger logger;
	
	public PluginLogger(PluginBase plugin) {
		this.plugin = plugin;
		logger = plugin.getServer().getLogger();
	}
	
	public final void debug(String s) {
		if (plugin.isDebug()) {
			logger.log(Level.INFO, String.format("[%s DEBUG] %s", plugin.getName(), s));
		}
	}
	
	public final void info(String s) {
		logger.log(Level.INFO, String.format("[%s] %s", plugin.getName(), s));
	}
	
	public final void warning(String s) {
		logger.log(Level.WARNING, String.format("[%s] %s", plugin.getName(), s));
	}
	
	public final void severe(String s) {
		logger.log(Level.SEVERE, String.format("[%s] %s", plugin.getName(), s));
	}
}