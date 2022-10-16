package de.LukasDev.events.Points.Spawn;

import de.LukasDev.events.Events;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    private Events plugin = null;

    public SetSpawnCommand() {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            Location location = player.getLocation();
            plugin.getConfig().set("spawn", location);

            plugin.saveConfig();

            player.sendMessage("Spawn wurde gesetzt.");
        }

        return true;
    }
}