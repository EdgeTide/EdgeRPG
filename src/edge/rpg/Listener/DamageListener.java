package edge.rpg.Listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import edge.rpg.util.AttitudeUtil;

public class DamageListener implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) {
			return;
		}else if (!(e.getEntity() instanceof LivingEntity)) {
			return;
		}
		
		Player damager = (Player) e.getDamager();
		
		FileConfiguration attitude = AttitudeUtil.getAttitudeFromName(damager.getName());
		
		e.setDamage(e.getDamage()+attitude.getInt("damage"));
		
	}
}
