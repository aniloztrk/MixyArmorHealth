package mixy.armor.health.mixyarmorhealth.Events;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ArmorHealthManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinEvent_ implements Listener {
    @EventHandler
    public void onPlayerJoined(PlayerJoinEvent e){
        Player player = e.getPlayer();
        new BukkitRunnable(){
            @Override
            public void run(){
                ArmorHealthManager.setHealth(player);
            }
        }.runTaskLater(MixyArmorHealth.Instance, 5);
    }
}
