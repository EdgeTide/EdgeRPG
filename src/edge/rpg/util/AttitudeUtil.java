package edge.rpg.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import edge.rpg.main.Main;

public class AttitudeUtil {

	// ��ȡ��ҵ����ԣ����������ļ���getInt("health"/"damage")
	public static FileConfiguration getAttitudeFromName(String name) {
		return YamlConfiguration.loadConfiguration(
				new File(Main.getPlugin().getDataFolder(), "//PlayerData" + File.separator + name + ".yml"));
	}

	public static void increaseDeterminedAttitude(String name, String attitude, Double incerase) {
		FileConfiguration f = getAttitudeFromName(name);
		f.set(attitude, f.getDouble(attitude) + incerase);
		try {
			f.save(new File(Main.getPlugin().getDataFolder(), "//PlayerData" + File.separator + name + ".yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void decreaseDeterminedAttitude(String name, String attitude, Double decrease) {
		FileConfiguration f = getAttitudeFromName(name);
		if (f.getDouble(attitude) - decrease < 0) {
			f.set(attitude, 0);
			return;
		}
		f.set(attitude, f.getDouble(attitude) - decrease);
		try {
			f.save(new File(Main.getPlugin().getDataFolder(), "//PlayerData" + File.separator + name + ".yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
