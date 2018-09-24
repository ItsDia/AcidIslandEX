package com.Raking.ASkyBlockEx.Listener;

import org.bukkit.event.player.*;
import com.Raking.ASkyBlockEx.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class OnPlayerInteractEvent implements Listener
{
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerInteractEvent(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (player == null) {
            return;
        }
        if (player.getWorld() != ASkyBlockEx.getSkyBlockWorld()) {
            return;
        }
        if (!ASkyBlockEx.AskyblockApi.playerIsOnIsland(player) && (!player.isOp() || !player.hasPermission("*"))) {
            player.sendMessage(ChatColor.RED + "你无权与本岛屿交互");
            event.setCancelled(true);
        }
    }
}
