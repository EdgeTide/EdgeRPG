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
		if (inventory.getTitle().equalsIgnoreCase("��c��lְҵ���")) {
			e.setCancelled(true);
		}
		if (inventory.getTitle().equalsIgnoreCase("��a��lѡ��ְҵ")) {
			e.setCancelled(true);
			if (e.getRawSlot() == 10) {
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
				FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
				yaml.set("isChance", true);
				yaml.set("Job", "�̿�");
				yaml.set("health", Main.getPlugin().getConfig().getInt("health"));
				yaml.set("damage", 0);
				try {
					yaml.save(filec);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.sendMessage("��a���Ѿ�ѡ����ְҵ��");
				p.sendMessage("��a�����e/jobs��a������Ϣ���");
				return;
			}

			if (e.getRawSlot() == 12) {
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
				FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
				yaml.set("isChance", true);
				yaml.set("Job", "���");
				yaml.set("health", Main.getPlugin().getConfig().getInt("health"));
				yaml.set("damage", 0);
				try {
					yaml.save(filec);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.sendMessage("��a���Ѿ�ѡ����ְҵ��");
				p.sendMessage("��a�����e/jobs��a������Ϣ���");
				return;
			}
		}

		return;
	}
}
