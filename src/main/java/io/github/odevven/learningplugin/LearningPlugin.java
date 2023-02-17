package io.github.odevven.learningplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class LearningPlugin extends JavaPlugin {

    @Override
    public void onEnable() { //Plugin startup logic
        System.out.println("[LearningPlugin] Plugin starting!");

    }

    @Override
    public void onDisable() { //Plugin shutdown logic
        System.out.println("[LearningPlugin] Plugin stopping.");

    }
}
