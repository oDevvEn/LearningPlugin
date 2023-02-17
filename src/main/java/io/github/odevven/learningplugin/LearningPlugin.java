package io.github.odevven.learningplugin;

import io.github.odevven.learningplugin.listeners.BedListener;
import io.github.odevven.learningplugin.listeners.JoinLeaveListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningPlugin extends JavaPlugin {

    @Override
    public void onEnable() { //Plugin startup logic
        System.out.println("[LearningPlugin] Plugin starting!");

        //Registers all of the events (listeners)
        getServer().getPluginManager().registerEvents(new BedListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListeners(), this);
        System.out.println("[LearningPlugin] All of the events have been registered.");

    }

    @Override
    public void onDisable() { //Plugin shutdown logic
        System.out.println("[LearningPlugin] Plugin stopping.");

    }
}
