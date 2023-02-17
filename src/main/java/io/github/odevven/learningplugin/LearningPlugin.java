package io.github.odevven.learningplugin;

import io.github.odevven.learningplugin.commands.FeedCommand;
import io.github.odevven.learningplugin.commands.GodModeCommand;
import io.github.odevven.learningplugin.commands.HealCommand;
import io.github.odevven.learningplugin.listeners.BedListener;
import io.github.odevven.learningplugin.listeners.JoinLeaveListeners;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningPlugin extends JavaPlugin {

    @Override
    public void onEnable() { //Plugin startup logic
        System.out.println("[LearningPlugin] Plugin starting!");

        //Registers all of the events (listeners)
        getServer().getPluginManager().registerEvents(new BedListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListeners(), this);
        System.out.println("[LearningPlugin] All of the events have been registered.");

        //Registers all of the commands
        getCommand("god").setExecutor(new GodModeCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        System.out.println("[LearningPlugin] All of the commands have been registered.");
    }

    @Override
    public void onDisable() { //Plugin shutdown logic
        System.out.println("[LearningPlugin] Plugin stopping.");

    }
}
