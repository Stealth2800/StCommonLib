package com.stealthyone.bukkit.stcommonlib.utils;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public final class BlockUtils {

	public final static boolean isBlockSign(Block block) {
		return block.getState() instanceof Sign;
	}
	
	public final static Sign getSign(Block block) {
		if (isBlockSign(block)) {
			return (Sign) block.getState();
		}
		throw new BlockNotSignException(block.getWorld().getName(), block.getX(), block.getY(), block.getZ());
	}
}