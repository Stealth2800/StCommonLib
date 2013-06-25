package com.stealthyone.bukkit.stcommonlib.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.plugin.java.JavaPlugin;

import com.stealthyone.bukkit.stcommonlib.storage.CustomGenericFileManager;

public final class FileUtils {

	/**
	 * Copies a file from the plugin .jar to the datafolder
	 * @param plugin
	 * @param fileName
	 */
	public final static void copyGenericFileFromJar(JavaPlugin plugin, String fileName) {
		CustomGenericFileManager file = new CustomGenericFileManager(new File(fileName));
		InputStream in = plugin.getResource(fileName);
		
		try {
			OutputStream out = new FileOutputStream(file.getFile());
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Deprecated
	public final static void copyFileFromJar(JavaPlugin plugin, String fileName) throws Exception {
		throw new Exception("copyFileFromJar is deprecated! Use copyGenericFileFromJar");
	}
}