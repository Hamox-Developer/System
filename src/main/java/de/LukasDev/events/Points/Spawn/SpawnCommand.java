package de.LukasDev.events.Points.Spawn;

import de.LukasDev.events.Events;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private Events plugin = null;

    public SpawnCommand() {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                player.teleport(location);
                player.sendMessage("§aDu wurdest zum Spawn teleportiert.");
            }else player.sendMessage("Es ist kein Spawn Punkt definiert. 😎");

        }

        return true;
    }
}