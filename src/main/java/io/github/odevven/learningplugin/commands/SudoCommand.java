package io.github.odevven.learningplugin.commands;

import io.github.odevven.learningplugin.LearningPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class SudoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("learningplugin.sudo")) {
            if (args.length >= 2) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    builder.append(args[i]);
                    builder.append(" ");
                }

                for (Player p : LearningPlugin.getPlugin().getServer().getOnlinePlayers()) {
                    p.sendMessage("<" + args[0] + "> " + builder.toString().stripTrailing());
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
        }

        return true;
    }
}
