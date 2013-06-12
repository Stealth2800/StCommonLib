package com.stealthyone.bukkit.stcommonlib.utils;

public final class BlockNotSignException extends RuntimeException {

	private static final long serialVersionUID = -632809061733056838L;

	public BlockNotSignException() {
		super();
	}
	
	@Deprecated
	public BlockNotSignException(String message) {
		super(message);
	}

	public BlockNotSignException(String worldName, int x, int y , int z) {
		super(String.format("Block at %d, %d, %d in world %s is not a sign!", x, y, z, worldName));
	}
	
}