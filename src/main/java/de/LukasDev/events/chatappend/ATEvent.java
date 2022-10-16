package de.LukasDev.events.chatappend;

import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;

public class ATEvent implements Listener
{
    @EventHandler
    public boolean playerChatEvent(final AsyncPlayerChatEvent e) {
        final StringBuilder builder = new StringBuilder();
        String message = e.getMessage();
        while (!message.isEmpty()) {
            if (message.contains("@")) {
                builder.append(message.substring(0, message.indexOf("@"))).append(ChatColor.AQUA);
                message = message.substring(message.indexOf("@"));
                if (message.contains(" ")) {
                    builder.append(message.substring(0, message.indexOf(" "))).append(ChatColor.RESET);
                    message = message.substring(message.indexOf(" "));
                }
                else {
                    builder.append(message);
                    message = "";
                }
            }
            else {
                builder.append(message);
                message = "";
            }
        }
        e.setMessage(builder.toString());
        return true;
    }
}