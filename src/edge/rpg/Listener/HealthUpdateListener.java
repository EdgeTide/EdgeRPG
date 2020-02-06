package edge.rpg.Listener;

import java.io.File;

import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import edge.rpg.main.Main;
import edge.rpg.util.AttitudeUtil;
import edge.rpg.util.ConfigUtil;

@SuppressWarnings("all")
public class HealthUpdateListener implements Listener {

	@EventHandler
	public void onInventoryOpen(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		File file = new File(Main.getPlugin().getDataFolder(), "//PlayerData");
		File filec = new File(file.getAbsoluteFile(), p.getName() + ".yml");
		FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
		switch (AttitudeUtil.getAttitudeFromName(p.getName()).getString("Job")) {
		case "´Ì¿Í":
			p.setMaxHealth(Main.getPlugin().getConfig().getInt("health")
					+ (yaml.getInt("health") * Main.getPlugin().getConfig().getInt("cike.health")));
			break;
		case "Èâ¶Ü":
			p.setMaxHealth(Main.getPlugin().getConfig().getInt("health")
					+ (yaml.getInt("health") * Main.getPlugin().getConfig().getInt("roudun.health")));
			break;
		}
	}
}
