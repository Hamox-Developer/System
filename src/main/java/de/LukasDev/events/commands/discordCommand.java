package de.LukasDev.events.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class discordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("");
        sender.sendMessage("§7Unser Discord: discord.mydiscord.de");
        sender.sendMessage("");
        return false;
    }
}
