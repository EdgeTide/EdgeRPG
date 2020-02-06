package edge.rpg.util;

import org.bukkit.configuration.file.FileConfiguration;

import edge.rpg.main.Main;

public class ConfigUtil {
	
	private static FileConfiguration config;
	
	public static void reload() {
		config = Main.getPlugin().getConfig();
		Main.getPlugin().saveDefaultConfig();
		Main.getPlugin().reloadConfig();
	}
	
	public static FileConfiguration getConfig() {
		return config;
	}
	
	public static Double getDeterminedValue(String path) {
		return getConfig().getDouble(path);
	}
}
