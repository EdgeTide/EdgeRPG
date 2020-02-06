package edge.rpg.Config;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.collect.Lists;

import edge.rpg.main.Main;

@SuppressWarnings("all")
public class EdgeLoader implements Listener {

	private static YamlConfiguration edgedata;
	private static boolean iss;

	@EventHandler
	public void onJoinGarry(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		File file = new File(Main.getPlugin().getDataFolder(), "//PlayerData");
		if (!file.exists()) {
			file.mkdirs();
		}
		File filec = new File(file.getAbsoluteFile(), player.getName() + ".yml");
		if (!filec.exists()) {
			try {
				filec.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
			yaml.set("isChance", false);
			yaml.set("Job", "null");
			yaml.set("health", Main.getPlugin().getConfig().getInt("health"));
			yaml.set("damage", 0);
			try {
				yaml.save(filec);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
		iss = yaml.getBoolean("isChance");
		if (!iss) {
			Inventory inv = Bukkit.createInventory(null, 3 * 9, "��a��lѡ��ְҵ");
			ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE);
			ItemStack js = new ItemStack(276);
			ItemStack rd = new ItemStack(299);
			ItemStack zw = new ItemStack(166);
			ItemMeta jsm = js.getItemMeta();
			ItemMeta rdm = rd.getItemMeta();
			ItemMeta zwm = zw.getItemMeta();
			jsm.setDisplayName("��b��l�̿�");

			rdm.setDisplayName("��a��l���");
			zwm.setDisplayName("��6��l����ְҵ");
			ArrayList<String> jsl = Lists.newArrayList();
			jsl.add("��8��m                            ");
			jsl.add("��8- ��a���ݵȼ������������������");
			jsl.add("��8- ��c������ü��ٵġ�aѪ������");
			jsl.add("��8- ��c���ǻ��ǿ��ġ�6��������");
			jsl.add("��8��m                            ");
			jsl.add("��5��l���ѡ���ְҵ");
			jsm.setLore(jsl);
			js.setItemMeta(jsm);
			ArrayList<String> rdl = Lists.newArrayList();
			rdl.add("��8��m                            ");
			rdl.add("��8- ��a���ݵȼ������������������");
			rdl.add("��8- ��c������ô����ġ�aѪ������");
			rdl.add("��8- ��c���ǻ�ü��ٵġ�6��������");
			rdl.add("��8��m                            ");
			rdl.add("��5��l���ѡ���ְҵ");
			rdm.setLore(rdl);
			rd.setItemMeta(rdm);
			zw.setItemMeta(zwm);
			is.setDurability((short) 14);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName("��6��l�ָ���");
			is.setItemMeta(im);
			int a = 9;
			for (int i = 0; i < a; i++) {
				inv.setItem(i, is);
			}
			int b = 27;
			for (int i = 18; i < b; i++) {
				inv.setItem(i, is);
			}
			inv.setItem(9, is);
			inv.setItem(11, is);
			inv.setItem(13, is);
			inv.setItem(15, is);
			inv.setItem(17, is);

			inv.setItem(10, js);
			inv.setItem(12, rd);
			inv.setItem(14, zw);
			inv.setItem(16, zw);
			new BukkitRunnable() {

				@Override
				public void run() {
					player.openInventory(inv);
				}
			}.runTaskLater(Main.getPlugin(), 3 * 20L);
		}

	}
}
