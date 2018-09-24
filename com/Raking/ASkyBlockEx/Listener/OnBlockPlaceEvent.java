package com.Raking.ASkyBlockEx.Listener;

import org.bukkit.event.block.*;
import com.Raking.ASkyBlockEx.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class OnBlockPlaceEvent implements Listener
{
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBlockPlaceEvent(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        if (player == null) {
            return;
        }
        if (player.getWorld() != ASkyBlockEx.getSkyBlockWorld()) {
            return;
        }
        if (!ASkyBlockEx.AskyblockApi.playerIsOnIsland(player) && (!player.isOp() || !player.hasPermission("*"))) {
            player.sendMessage(ChatColor.RED + "你无权在本岛屿放置方块");
            event.setCancelled(true);
        }
    }
}
