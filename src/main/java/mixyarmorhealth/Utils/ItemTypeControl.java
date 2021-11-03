package mixy.armor.health.mixyarmorhealth.Utils;

import org.bukkit.inventory.ItemStack;

public class ItemTypeControl 
{
    public static boolean itemIsArmor(ItemStack item)
    {
        if (item.getType().toString().endsWith("_CHESTPLATE") || item.getType().toString().endsWith("_LEGGINGS") || item.getType().toString().endsWith("_BOOTS") || item.getType().toString().endsWith("_HELMET")) 
        {
            return true;
        }
        return false;
    }
}
