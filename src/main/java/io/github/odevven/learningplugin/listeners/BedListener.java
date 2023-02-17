package io.github.odevven.learningplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedListener implements Listener {

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();

        if (!player.isOp()) {
            e.setCancelled(true);
            player.sendMessage("<Bed> Hey! I only like people with OP.");
        }
        else {
            player.sendMessage("<Bed> Hey ;)");
        }
    }
}
