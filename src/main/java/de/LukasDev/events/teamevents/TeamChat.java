package de.LukasDev.events.teamevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TeamChat implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        final Player p = event.getPlayer();
        if (p.hasPermission("events.teamcommand.teamchat.use") && event.getMessage().startsWith("@team")) {
            for (final Player a : Bukkit.getOnlinePlayers()) {
                if (a.hasPermission("events.teamcommand.teamchat.use")) {
                    a.sendMessage("§6§lTEAM" + "§8| §7" + p.getDisplayName() + "» " + event.getMessage().replaceAll("@t", ""));


                }

            }
        }
    }
}
