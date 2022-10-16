package de.LukasDev.events.lift;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
    @EventHandler
    private void onJump(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();
        Block block = location.getBlock();
        if (event.getFrom().getY())


    }
}
