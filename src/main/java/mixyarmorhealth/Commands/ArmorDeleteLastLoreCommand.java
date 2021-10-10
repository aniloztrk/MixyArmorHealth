package mixy.armor.health.mixyarmorhealth.Commands;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ItemTypeControl;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ArmorDeleteLastLoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(!sender.hasPermission(MixyArmorHealth.Instance.getConfig().getString("plugin-perm"))){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Gerekli izinlere sahip değilsin.");
                return true;
            }

            Player player = (Player) sender;
            ItemStack item = player.getItemInHand();

            if(!ItemTypeControl.itemIsArmor(item)){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Bu komutu sadece armorlar üzerinde kullanabilirsin.");
                return true;
            }

            ItemMeta itemMeta = item.getItemMeta();
            ArrayList<String> itemLore = new ArrayList<>(itemMeta.getLore());

            if(itemLore.size() == 1){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Silinecek bir lore yok.");
                return true;
            }

            int index = itemLore.size() - 1;
            itemLore.remove(index);
            itemMeta.setLore(itemLore);
            item.setItemMeta(itemMeta);
        }
        return true;
    }
}
