package mixy.armor.health.mixyarmorhealth.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemLoreManager 
{
    public static void optimizeArmorLore(ItemStack item, Player player)
    {
        if(!ItemTypeControl.itemIsArmor(item))
        {
            player.sendMessage(ChatColor.RED + "Item not found");
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();

        if(PersistentDataContainerUtil.hasInteger(item, "Health"))
        {
            int health = PersistentDataContainerUtil.getInteger(item, "Health");

            if(itemMeta.getLore() == null)
            {
                ArrayList<String> itemLore = new ArrayList<>();
                itemLore.add("");
                itemLore.add(ChatColor.RED + "" + ChatColor.BOLD + "+" + health/2 + "❤");
                itemLore.add("");
                itemMeta.setLore(itemLore);
            }
            else
            {
                List<String> itemLore = new ArrayList<>(itemMeta.getLore());
                itemLore.set(1, ChatColor.RED + "" + ChatColor.BOLD + "+" + health/2 + "❤");
                itemMeta.setLore(itemLore);
            }
            item.setItemMeta(itemMeta);
            return;
        }
        itemMeta.setLore(new ArrayList<>());
        item.setItemMeta(itemMeta);
    }
}
