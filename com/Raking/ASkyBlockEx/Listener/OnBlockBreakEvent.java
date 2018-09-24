package com.Raking.ASkyBlockEx.Listener;

import org.bukkit.event.block.*;
import com.Raking.ASkyBlockEx.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class OnBlockBreakEvent implements Listener
{
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBlockBreakEvent(final BlockBreakEvent event) {
        final Player player = event.getPlayer();
        if (player == null) {
            return;
        }
        if (player.getWorld() != ASkyBlockEx.getSkyBlockWorld()) {
            return;
        }
        final boolean type = ASkyBlockEx.AskyblockApi.playerIsOnIsland(player);
        if (!type && (!player.isOp() || !player.hasPermission("*"))) {
            player.sendMessage(ChatColor.RED + "你无权破坏本岛屿方块");
            event.setCancelled(true);
        }
    }
}
