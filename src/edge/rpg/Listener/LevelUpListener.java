package edge.rpg.Listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import edge.rpg.main.Main;

@SuppressWarnings("all")
public class LevelUpListener implements Listener {
	@EventHandler
	public void onLevelUp(PlayerLevelChangeEvent e) {
		Player p = e.getPlayer();
		if (e.getNewLevel() <= e.getOldLevel()) {
			return;
		}
		File file = new File(Main.getPlugin().getDataFolder(), "//PlayerData");
		File filec = new File(file.getAbsoluteFile(), p.getName() + ".yml");
		FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
		String zy = yaml.getString("Job");
		if (zy.equalsIgnoreCase("´Ì¿Í")) {
			yaml.set("health", p.getLevel() * Main.getPlugin().getConfig().getInt("cike.health"));
			yaml.set("damage", p.getLevel() * Main.getPlugin().getConfig().getInt("cike.damage"));
			try {
				yaml.save(filec);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}

		if (zy.equalsIgnoreCase("Èâ¶Ü")) {
			yaml.set("health", p.getLevel() * Main.getPlugin().getConfig().getInt("roudun.health"));
			yaml.set("damage", p.getLevel() * Main.getPlugin().getConfig().getInt("roudun.damage"));
			try {
				yaml.save(filec);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}
	}
}
