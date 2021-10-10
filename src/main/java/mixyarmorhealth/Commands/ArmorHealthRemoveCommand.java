package mixy.armor.health.mixyarmorhealth.Commands;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ItemLoreManager;
import mixy.armor.health.mixyarmorhealth.Utils.ItemTypeControl;
import mixy.armor.health.mixyarmorhealth.Utils.PersistentDataContainerUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorHealthRemoveCommand implements CommandExecutor {
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
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Bu komutu kullanabilmek için elinde bir armor bulunmalı.");
                return true;
            }

            if(!PersistentDataContainerUtil.hasInteger(item, "Health")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Bu armorda zaten bir can ayarı bulunmuyor.");
                return true;
            }

            PersistentDataContainerUtil.removeTag(item, "Health");
            ItemLoreManager.optimizeArmorLore(item, player);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.GREEN + "Armor temizlendi.");
        }
        return true;
    }
}
