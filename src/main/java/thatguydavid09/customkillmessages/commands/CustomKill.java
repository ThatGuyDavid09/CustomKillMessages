package thatguydavid09.customkillmessages.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import thatguydavid09.customkillmessages.CustomKillMessages;

import java.util.Arrays;

public class CustomKill implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length <= 1) {
            return false;
        }

        // This garbage gets the world the command is being send in, as this can be send by console or player so just player.getWorld() doesn't work
        World w = CustomKillMessages.getInstance().getServer().getOnlinePlayers().iterator().next().getWorld();
        boolean sendDeathMessage = w.getGameRuleValue(GameRule.SHOW_DEATH_MESSAGES);

        if (Bukkit.getPlayer(args[0]) != null) {
            if (sendDeathMessage) {
                w.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
                Bukkit.getPlayer(args[0]).setHealth(0D);
                w.setGameRule(GameRule.SHOW_DEATH_MESSAGES, true);

                String killMessage = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                String message = killMessage.replace("%player%", args[0]);
                Bukkit.broadcastMessage(message.replace("&", "§"));
            } else {
                Bukkit.getPlayer(args[0]).setHealth(0D);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Player not found!");
        }
        return true;
    }
}
