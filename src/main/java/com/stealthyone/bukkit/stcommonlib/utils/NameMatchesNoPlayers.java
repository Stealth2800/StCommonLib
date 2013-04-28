package com.stealthyone.bukkit.stcommonlib.utils;

public final class NameMatchesNoPlayers extends Exception {

	private static final long serialVersionUID = 2341660402990565702L;

	public NameMatchesNoPlayers() {
		super();
	}
	
	public NameMatchesNoPlayers(String message) {
		super(message);
	}
	
}