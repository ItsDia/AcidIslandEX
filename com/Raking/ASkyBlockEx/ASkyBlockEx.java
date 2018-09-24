package com.Raking.ASkyBlockEx;

import org.bukkit.plugin.java.*;
import com.wasteofplastic.acidisland.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import com.Raking.ASkyBlockEx.Listener.*;
import java.util.logging.*;

public class ASkyBlockEx extends JavaPlugin
{
    public static ASkyBlockAPI AskyblockApi;
    private static World SkyBlockWorld;
    
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents((Listener)new OnBlockBreakEvent(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new OnBlockPlaceEvent(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new OnPlayerInteractEvent(), (Plugin)this);
        this.getServer().getLogger().log(Level.INFO, "[AcidIslandEx ]Plugin Enabled");
        ASkyBlockEx.AskyblockApi = ASkyBlockAPI.getInstance();
    }
    
    public static World getSkyBlockWorld() {
        if (ASkyBlockEx.SkyBlockWorld == null) {
            ASkyBlockEx.SkyBlockWorld = ASkyBlockEx.AskyblockApi.getIslandWorld();
        }
        return ASkyBlockEx.SkyBlockWorld;
    }
    
    public void onDisable() {
        this.getServer().getLogger().log(Level.INFO, "[AcidIslandEx]Plugin Disable");
    }
}
