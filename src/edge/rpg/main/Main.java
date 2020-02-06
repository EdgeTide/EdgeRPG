package edge.rpg.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import edge.rpg.Config.EdgeLoader;
import edge.rpg.Listener.DamageListener;
import edge.rpg.Listener.HealthUpdateListener;
import edge.rpg.Listener.Inventory;
import edge.rpg.Listener.LevelUpListener;
import edge.rpg.commands.EdgeCommands;
import edge.rpg.util.ConfigUtil;

public class Main extends JavaPlugin {
	private static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginCommand("jobs").setExecutor(new EdgeCommands());
		ConfigUtil.reload();
		Bukkit.getPluginManager().registerEvents(new EdgeLoader(), this);
		Bukkit.getPluginManager().registerEvents(new Inventory(), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new HealthUpdateListener(), this);
		Bukkit.getPluginManager().registerEvents(new LevelUpListener(), this);
	}

	public static Main getPlugin() {
		return plugin;
	}
}
