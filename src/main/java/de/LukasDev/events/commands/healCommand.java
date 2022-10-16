package de.LukasDev.events.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import de.LukasDev.events.Events;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class healCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("events.command.heal")) {
                if (args.length == 0) {
                    player.setHealth(20.0);
                    player.setFoodLevel(20);
                    player.sendMessage(ChatColor.GREEN.toString() + "Du wurdest geheilt.");
                }
                else if (args.length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20.0);
                        target.setFoodLevel(20);
                        player.sendMessage(ChatColor.GREEN.toString() + ChatColor.ITALIC + "Du hast" + target.getName() + " geheilt.");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Dieser Spieler ist gerade nicht auf dem Server.");
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED + "Richtig, /heal <Spieler>");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Unzureichende Rechte (events.commands.heal)");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein");
        }
        return false;
    }
}