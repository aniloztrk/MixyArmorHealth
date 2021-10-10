package mixy.armor.health.mixyarmorhealth.Events;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ArmorHealthManager;
import mixy.armor.health.mixyarmorhealth.Utils.ItemTypeControl;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryClickEvent_ implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player){
            Player player = (Player) e.getWhoClicked();

            if(player.getInventory() == e.getClickedInventory()){
                if(ItemTypeControl.itemIsArmor(e.getCurrentItem()) || e.getCurrentItem().getType().equals(Material.AIR)){
                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            ArmorHealthManager.setHealth(player);
                        }
                    }.runTaskLater(MixyArmorHealth.Instance, 5);
                }
            }
        }
    }
}
