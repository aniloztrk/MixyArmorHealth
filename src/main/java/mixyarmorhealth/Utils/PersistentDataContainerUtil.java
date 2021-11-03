package mixy.armor.health.mixyarmorhealth.Utils;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PersistentDataContainerUtil 
{
    public static boolean hasInteger(ItemStack itemStack, String key) 
    {
        if (itemStack.hasItemMeta()) 
        {
            ItemMeta itemMeta = itemStack.getItemMeta();
            NamespacedKey namespacedKey = new NamespacedKey(MixyArmorHealth.Instance, key);
            PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
            return persistentDataContainer.has(namespacedKey, PersistentDataType.INTEGER);
        }
        return false;
    }
    public static void putInteger(String key, int value, ItemStack itemStack) 
    {
        ItemMeta itemMeta = itemStack.getItemMeta();
        NamespacedKey namespacedKey = new NamespacedKey(MixyArmorHealth.Instance, key);
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(namespacedKey, PersistentDataType.INTEGER, value);
        itemStack.setItemMeta(itemMeta);
    }
    public static int getInteger(ItemStack itemStack, String key) 
    {
        if (itemStack.hasItemMeta()) 
        {
            ItemMeta itemMeta = itemStack.getItemMeta();
            NamespacedKey namespacedKey = new NamespacedKey(MixyArmorHealth.Instance, key);
            PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
            return persistentDataContainer.get(namespacedKey, PersistentDataType.INTEGER);
        }
        return 0;
    }
    public static void removeTag(ItemStack itemStack, String key) 
    {
        ItemMeta itemMeta = itemStack.getItemMeta();
        NamespacedKey namespacedKey = new NamespacedKey(MixyArmorHealth.Instance, key);
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.remove(namespacedKey);
        itemStack.setItemMeta(itemMeta);
    }
}
