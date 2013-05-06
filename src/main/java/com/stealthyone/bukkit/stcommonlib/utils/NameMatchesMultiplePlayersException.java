package com.stealthyone.bukkit.stcommonlib.utils;

public final class NameMatchesMultiplePlayersException extends Exception {

	private static final long serialVersionUID = -2443148064103607016L;
	
	public NameMatchesMultiplePlayersException() {
		super();
	}
	
	public NameMatchesMultiplePlayersException(String message) {
		super(message);
	}

}