package mixy.armor.health.mixyarmorhealth.Utils;

import mixy.armor.health.mixyarmorhealth.MixyArmorHealth;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class RegisterUtil 
{
    public static void event(Listener listener)
    {
        MixyArmorHealth.Instance.getServer().getPluginManager().registerEvents(listener, MixyArmorHealth.Instance);
    }
    public static void command(String commandName, CommandExecutor executor)
    {
        MixyArmorHealth.Instance.getCommand(commandName).setExecutor(executor);
    }
}
