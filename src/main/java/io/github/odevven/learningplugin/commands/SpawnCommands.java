package io.github.odevven.learningplugin.commands;

import io.github.odevven.learningplugin.LearningPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class SpawnCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Spawn commands can only be executed by a player!");
            return true;
        }


        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("setspawn")) {
            if (!sender.hasPermission("learningplugin.setspawn")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
                return true;
            }

            LearningPlugin.getPlugin().getConfig().set("spawn", p.getLocation());
            LearningPlugin.getPlugin().saveConfig();
            sender.sendMessage(ChatColor.YELLOW + "Spawn location has been set to your current location + rotation!");
        }

        else if (command.getName().equalsIgnoreCase("spawn")) {
            Location location = LearningPlugin.getPlugin().getConfig().getLocation("spawn");
            if (location != null) {
                p.teleport(location);
                sender.sendMessage(ChatColor.YELLOW + "Teleported you to spawn!");
            }
            else {
                sender.sendMessage(ChatColor.RED + "There is no /setspawn set!");
            }
        }


        return true;
    }
}
