package de.LukasDev.events;

import de.LukasDev.events.Points.Spawn.SetSpawnCommand;
import de.LukasDev.events.Points.Spawn.SpawnCommand;
import de.LukasDev.events.Points.Utils;
import de.LukasDev.events.chatappend.ATEvent;
import de.LukasDev.events.chatappend.hashtagEvent;
import de.LukasDev.events.commands.FlyCommand;
import de.LukasDev.events.commands.healCommand;
import de.LukasDev.events.commands.serverinfo;
import de.LukasDev.events.listeners.Listeners;
import de.LukasDev.events.teamevents.TeamChat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public final class Events extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getLogger().info("Public Events wurden geladen ...");
        getLogger().info("Public Command wurde geladen ...");

        getCommand("serverinfo").setExecutor(new serverinfo());
        getCommand("Fly").setExecutor(new FlyCommand());
        getCommand("heal").setExecutor(new healCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Listeners(), this);
        pluginManager.registerEvents(new TeamChat(), this);
        pluginManager.registerEvents(new hashtagEvent(), this);
        pluginManager.registerEvents(new ATEvent(), this);
        pluginManager.registerEvents(new Utils(), this);




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
