package mixy.armor.health.mixyarmorhealth;

import mixy.armor.health.mixyarmorhealth.Commands.*;
import mixy.armor.health.mixyarmorhealth.Events.*;
import mixy.armor.health.mixyarmorhealth.Utils.RegisterUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class MixyArmorHealth extends JavaPlugin {

    public static MixyArmorHealth Instance;
    @Override
    public void onEnable() {
        Instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        RegisterUtil.event(new InventoryClickEvent_());
        RegisterUtil.event(new PlayerDeathEvent_());
        RegisterUtil.event(new ItemBreakEvent_());
        RegisterUtil.event(new PlayerInteractEvent_());
        RegisterUtil.event(new PlayerJoinEvent_());

        RegisterUtil.command("armorsethealth", new ArmorSetHealthCommand());
        RegisterUtil.command("armorsetname", new ArmorSetNameCommand());
        RegisterUtil.command("armorremovehealth", new ArmorHealthRemoveCommand());
        RegisterUtil.command("armordellastlore", new ArmorDeleteLastLoreCommand());
        RegisterUtil.command("armoraddlore", new ArmorAddLoreCommand());
        RegisterUtil.command("armorhealth", new MainCommand());
    }
}
