package io.github.odevven.learningplugin;

import io.github.odevven.learningplugin.commands.*;
import io.github.odevven.learningplugin.listeners.BedListener;
import io.github.odevven.learningplugin.listeners.JoinLeaveListeners;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningPlugin extends JavaPlugin {
    public static LearningPlugin plugin;

    @Override
    public void onEnable() { //Plugin startup logic
        System.out.println("[LearningPlugin] Plugin starting!");
        plugin = this;

        //Do something with config
        getConfig().options().copyDefaults();
        saveConfig();
        System.out.println("[LearningPlugin] Loaded configurations");

        //Registers all of the events (listeners)
        getServer().getPluginManager().registerEvents(new BedListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListeners(), this);
        System.out.println("[LearningPlugin] All of the events have been registered");

        //Registers all of the commands -- god i need to code some sort of command manager to stop this huge mess
        getCommand("god").setExecutor(new GodModeCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("sudo").setExecutor(new SudoCommand());
        getCommand("setspawn").setExecutor(new SpawnCommands());
        getCommand("spawn").setExecutor(new SpawnCommands());
        System.out.println("[LearningPlugin] All of the commands have been registered");
    }

    @Override
    public void onDisable() { //Plugin shutdown logic
        System.out.println("[LearningPlugin] Plugin stopping");
        saveConfig();
    }


    public static LearningPlugin getPlugin() {
        return plugin;
    }
}
