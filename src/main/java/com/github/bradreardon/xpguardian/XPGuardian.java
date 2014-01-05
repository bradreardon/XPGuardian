package com.github.bradreardon.xpguardian;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class XPGuardian extends JavaPlugin implements Listener {
    public void onDisable() {
        getLogger().info(this + " disabled.");
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(this + " enabled.");
    }
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerXPDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Entity killer = player.getKiller();
        
        if (killer instanceof Player && !player.hasPermission("xpguardian.pvp")) {
            return;
        } else if (!(killer instanceof Player) && !player.hasPermission("xpguardian.pve")) {
            return;
        }
        event.setKeepLevel(true);
        event.setDroppedExp(0);
    }
}