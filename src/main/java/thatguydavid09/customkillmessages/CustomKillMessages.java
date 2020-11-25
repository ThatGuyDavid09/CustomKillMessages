package thatguydavid09.customkillmessages;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import thatguydavid09.customkillmessages.commands.CustomKill;
import thatguydavid09.customkillmessages.commands.CustomKillTabComplete;

public final class CustomKillMessages extends JavaPlugin {
    private static CustomKillMessages instance;
    @Override
    public void onEnable() {
        this.getCommand("ckill").setExecutor(new CustomKill());
        this.getCommand("ckill").setTabCompleter(new CustomKillTabComplete());
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CustomKillMessages getInstance() {
        return instance;
    }
}
