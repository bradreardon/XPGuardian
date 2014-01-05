package com.github.bradreardon.xpguardian;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class XPGuardian extends JavaPlugin implements Listener {
    public void onDisable() {
        getLogger().info(this + " disabled.");
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(this + " enabled.");
    }
}

