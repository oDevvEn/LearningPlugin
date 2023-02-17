package io.github.odevven.learningplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (player.hasPlayedBefore()) {
            if (player.isOp()) {
                e.setJoinMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.DARK_GREEN + ", our holy god has joined!!");
            } else {
                e.setJoinMessage(ChatColor.GREEN + "Welcome back " + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + ", we missed you.");
            }
        }
        else {
            e.setJoinMessage(ChatColor.GREEN + "Welcome " + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN +" to the server! We hope you enjoy your time here.");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.RED + "" + ChatColor.BOLD + player.getDisplayName() + " has left the server... :(");
    }
}
