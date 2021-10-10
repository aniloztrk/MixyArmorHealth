package mixy.armor.health.mixyarmorhealth.Events;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ArmorHealthManager;
import mixy.armor.health.mixyarmorhealth.Utils.ItemTypeControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerInteractEvent_ implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction() == Action.PHYSICAL) return;

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getItem() == null) return;
            if(ItemTypeControl.itemIsArmor(e.getItem()))
            {
                new BukkitRunnable(){
                    @Override
                    public void run(){
                        ArmorHealthManager.setHealth(e.getPlayer());
                    }
                }.runTaskLater(MixyArmorHealth.Instance, 5);
            }
        }
    }
}
