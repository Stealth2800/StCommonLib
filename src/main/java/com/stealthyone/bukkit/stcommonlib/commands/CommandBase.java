package com.stealthyone.bukkit.stcommonlib.commands;

import com.stealthyone.bukkit.stcommonlib.plugin.PluginBase;

@Deprecated
public abstract class CommandBase implements ICommandExecutor {

	protected PluginBase plugin;
	
	public CommandBase(PluginBase plugin) {
		this.plugin = plugin;
	}
}