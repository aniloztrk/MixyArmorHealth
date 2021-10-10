package mixy.armor.health.mixyarmorhealth.Commands;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(!sender.hasPermission(MixyArmorHealth.Instance.getConfig().getString("plugin-perm"))){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "Gerekli izinlere sahip değilsin.");
                return true;
            }
        }

        if(args.length != 1){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.RED + "/armorhealth help");
            return true;
        }

        if(args[0].equalsIgnoreCase("reload")){
            MixyArmorHealth.Instance.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.GREEN + "Config yenileme başarılı!");
            return true;
        }

        if(args[0].equalsIgnoreCase("help")){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.LIGHT_PURPLE + "/armorhealth reload" + ChatColor.GREEN + " - Config dosyasını yeniler.");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.LIGHT_PURPLE + "/aaddlore <text>" + ChatColor.GREEN + " - Armora lore ekler.");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.LIGHT_PURPLE + "/asetname <text>" + ChatColor.GREEN + " - Armorun ismini değiştirir.");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.LIGHT_PURPLE + "/asethealth <amount>" + ChatColor.AQUA + " - Armor üzerine can atanır.");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.LIGHT_PURPLE + "/aremovehealth" + ChatColor.GREEN + " - Armoru sıfırlar.");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MixyArmorHealth.Instance.getConfig().getString("message-title")) + ChatColor.LIGHT_PURPLE + "/adellore" + ChatColor.GREEN + " - Armordan lore siler. (En alttaki)");
            return true;
        }
        return true;
    }
}
