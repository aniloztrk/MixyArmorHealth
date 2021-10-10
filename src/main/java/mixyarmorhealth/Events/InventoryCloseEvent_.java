package mixy.armor.health.mixyarmorhealth.Events;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ArmorHealthManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryCloseEvent_ implements Listener {
    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e){
        Player player = (Player) e.getPlayer();
        new BukkitRunnable(){
            @Override
            public void run(){
                ArmorHealthManager.setHealth(player);
            }
        }.runTaskLater(MixyArmorHealth.Instance, 5);
    }
}
