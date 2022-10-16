package de.LukasDev.events.teamevents;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ChatClearCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] strings) {
        if (sender.hasPermission("events.teamcommand.clearchat")) {
            for (int i = 0; i < 100; ++i) {
                Bukkit.broadcastMessage("");
            }
            Bukkit.broadcastMessage("§7Der Chat wurde von §b" + sender.getName() + " §7geleert!");
        }
        else {
            sender.sendMessage("§cUnzureichende Rechte!");
        }
        return false;
    }
}
