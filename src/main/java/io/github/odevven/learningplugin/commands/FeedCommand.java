package io.github.odevven.learningplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("learningplugin.feed")) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "You now have maximum hunger.");
            }
            else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "/feed can only be executed by a player!");
        }

        return true;
    }
}
