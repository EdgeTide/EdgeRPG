package edge.rpg.Listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import edge.rpg.main.Main;

public class Inventory implements Listener {
	@EventHandler
	public void onCaonm(InventoryClickEvent e) {
		org.bukkit.inventory.Inventory inventory = e.getInventory();
		File file = new File(Main.getPlugin().getDataFolder(), "//PlayerData");
		File filec = new File(file.getAbsoluteFile(), e.getWhoClicked().getName() + ".yml");
		if (inventory.getTitle().equalsIgnoreCase("§c§l职业面板")) {
			e.setCancelled(true);
		}
		if (inventory.getTitle().equalsIgnoreCase("§a§l选择职业")) {
			e.setCancelled(true);
			if (e.getRawSlot() == 10) {
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
				FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
				yaml.set("isChance", true);
				yaml.set("Job", "刺客");
				yaml.set("health", Main.getPlugin().getConfig().getInt("health"));
				yaml.set("damage", 0);
				try {
					yaml.save(filec);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.sendMessage("§a你已经选择了职业！");
				p.sendMessage("§a输入§e/jobs§a来打开信息面板");
				return;
			}

			if (e.getRawSlot() == 12) {
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
				FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
				yaml.set("isChance", true);
				yaml.set("Job", "肉盾");
				yaml.set("health", Main.getPlugin().getConfig().getInt("health"));
				yaml.set("damage", 0);
				try {
					yaml.save(filec);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.sendMessage("§a你已经选择了职业！");
				p.sendMessage("§a输入§e/jobs§a来打开信息面板");
				return;
			}
		}

		return;
	}
}
