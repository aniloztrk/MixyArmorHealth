package mixy.armor.health.mixyarmorhealth.Events;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ArmorHealthManager;
import mixy.armor.health.mixyarmorhealth.Utils.ItemTypeControl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemBreakEvent_ implements Listener {
    @EventHandler
    public void onIteamBreak(PlayerItemBreakEvent e){
        if(ItemTypeControl.itemIsArmor(e.getBrokenItem())){
            Player player = e.getPlayer();
            new BukkitRunnable(){
                @Override
                public void run(){
                    ArmorHealthManager.setHealth(player);
                }
            }.runTaskLater(MixyArmorHealth.Instance, 5);
        }
    }
}
