package de.LukasDev.events.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Set;

public class serverinfo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Collection<? extends Player> onlinePlayers = sender.getServer().getOnlinePlayers();
        int maxPlayers = sender.getServer().getMaxPlayers();
        GameMode defaultGameMode = sender.getServer().getDefaultGameMode();
        Set<OfflinePlayer> operators = sender.getServer().getOperators();

        sender.hasPermission("events.command.playerinfo");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GRAY + "Maximale Spieler Anzahl: " + sender.getServer().getMaxPlayers());
        sender.sendMessage(ChatColor.GRAY + "Derzeit Online: " + sender.getServer().getOnlinePlayers());
        sender.sendMessage(ChatColor.GRAY + "Normaler Gamemode: " + sender.getServer().getDefaultGameMode());
        sender.sendMessage(ChatColor.GRAY + "Unsere Operatoren: " + sender.getServer().getOperators());
        sender.sendMessage("");



        return false;
    }

}



