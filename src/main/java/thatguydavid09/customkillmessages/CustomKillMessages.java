package thatguydavid09.customkillmessages;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomKillMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendRawMessage(ChatColor.GREEN + "CustomKill has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
