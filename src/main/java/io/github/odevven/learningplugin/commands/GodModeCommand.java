package io.github.odevven.learningplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "/god can only be executed by a player!");
            return true;
        }
        if (!sender.hasPermission("learningplugin.god")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
            return true;
        }


        Player p = (Player) sender;

        if (p.isInvulnerable()) {
            p.setInvulnerable(false);
            p.sendMessage(ChatColor.RED + "God mode has been disabled.");
        } else {
            p.setInvulnerable(true);
            p.sendMessage(ChatColor.GREEN + "God mode has been enabled.");
        }


        return true;
    }
}
