package mixy.armor.health.mixyarmorhealth.Commands;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import mixy.armor.health.mixyarmorhealth.Utils.ItemLoreManager;
import mixy.armor.health.mixyarmorhealth.Utils.ItemTypeControl;
import mixy.armor.health.mixyarmorhealth.Utils.PersistentDataContainerUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorSetHealthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){

            if(!sender.hasPermission(MixyArmorHealth.Instance.getConfig().getString("plugin-perm"))){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Gerekli izinlere sahip değilsin.");
                return true;
            }

            Player player = (Player) sender;
            if(args.length == 0){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "/armorsethealth <amount>");
                return true;
            }

            try{
                int health = Integer.parseInt(args[0]);

                ItemStack item = player.getItemInHand();

                if(item.getType().equals(Material.AIR) || !ItemTypeControl.itemIsArmor(item)){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Bu komutu kullanabilmek için elinde armor olmalı.");
                    return true;
                }

                PersistentDataContainerUtil.putInteger("Health", health, item);

                ItemLoreManager.optimizeArmorLore(item, player);
            }
            catch (Exception e){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "/armorsethealth <amount>(Number)");
            }
        }
        return true;
    }
}
