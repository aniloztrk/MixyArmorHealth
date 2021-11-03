package mixy.armor.health.mixyarmorhealth.Utils;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class ArmorHealthManager 
{
    public static void setHealth(Player player) 
    {
        Configuration config = MixyArmorHealth.Instance.getConfig();
        PlayerInventory inv = player.getInventory();
        if (inv.getArmorContents().length == 0) return;

        int maxhealth = config.getInt("player-default-health");

        if (inv.getChestplate() != null) 
            maxhealth += PersistentDataContainerUtil.getInteger(inv.getChestplate(), "Health");
        
        if (inv.getHelmet() != null) 
            maxhealth += PersistentDataContainerUtil.getInteger(inv.getHelmet(), "Health");
        
        if (inv.getLeggings() != null) 
            maxhealth += PersistentDataContainerUtil.getInteger(inv.getLeggings(), "Health");
        
        if (inv.getBoots() != null) 
            maxhealth += PersistentDataContainerUtil.getInteger(inv.getBoots(), "Health");

        player.setMaxHealth(maxhealth);
    }
}
