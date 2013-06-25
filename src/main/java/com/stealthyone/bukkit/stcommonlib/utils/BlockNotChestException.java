package com.stealthyone.bukkit.stcommonlib.utils;

public final class BlockNotChestException extends RuntimeException {

	private static final long serialVersionUID = -632809061733056838L;

	public BlockNotChestException() {
		super();
	}

	public BlockNotChestException(String worldName, int x, int y , int z) {
		super(String.format("Block at %d, %d, %d in world %s is not a chest!", x, y, z, worldName));
	}
	
}