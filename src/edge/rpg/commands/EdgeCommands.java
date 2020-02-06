package edge.rpg.commands;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.collect.Lists;

import edge.rpg.main.Main;
@SuppressWarnings("all")
public class EdgeCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§c后台无法使用！");
			return true;
		}
		Player p = (Player) sender;
		File file = new File(Main.getPlugin().getDataFolder(), "//PlayerData");
		File filec = new File(file.getAbsoluteFile(), p.getName() + ".yml");
		FileConfiguration yaml = YamlConfiguration.loadConfiguration(filec);
		Inventory inv = Bukkit.createInventory(null, 1 * 9, "§c§l职业面板");
		ItemStack pStack = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta pMeta = pStack.getItemMeta();
		pMeta.setDisplayName("§6§l个人信息");
		ArrayList<String> pp = Lists.newArrayList();
		pp.add("§a您的职业：§e " + yaml.getString("Job"));
		pp.add("§7§m§l                 ");
		pp.add("");
		pp.add("§3§l>>> §7生命加成： §e"+ yaml.getInt("health"));
		pp.add("§3§l>>> §7伤害加成： §e"+ yaml.getInt("damage"));
		pp.add("");
		pp.add("§7§m§l                 ");
		pMeta.setLore(pp);
		pStack.setItemMeta(pMeta);
		ItemStack iStack = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta im = iStack.getItemMeta();
		im.setDisplayName("§6§l分割线");
		iStack.setItemMeta(im);
		int a = 9;
		for (int i = 0; i < a; i++) {
			inv.setItem(i, iStack);
		}
		inv.setItem(4, pStack);
		if (args.length == 0) {
			p.openInventory(inv);
			return true;
		}
		return true;
	}

}
