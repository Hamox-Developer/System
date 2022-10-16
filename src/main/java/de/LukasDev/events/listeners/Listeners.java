package de.LukasDev.events.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import java.net.InetAddress;
import java.util.Collection;

public class Listeners implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String eventName = event.getEventName();
        event.setJoinMessage(ChatColor.GREEN + "+" + "" + ChatColor.GRAY + event.getPlayer());

    }
    @EventHandler
    public void onLeft(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.DARK_RED + "-" + ChatColor.GRAY + event.getPlayer());

    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        boolean keepInventory = event.getKeepInventory();
        String eventName = event.getEventName();

        event.setDeathMessage("👀" + ChatColor.RED + "Ein Spieler ist gestorben :D");

    }
    @EventHandler
    public void AdvancementDone(PlayerAdvancementDoneEvent event){
        Player player = event.getPlayer();
        Advancement advancement = event.getAdvancement();
        event.notifyAll();
        event.getAdvancement().notify();
        event.getPlayer().sendMessage(ChatColor.GRAY + "Du hast" + ChatColor.GREEN + event.getAdvancement() + ChatColor.GRAY + "erreicht!" );



    }
    @EventHandler
    public void PlayerDropEvent(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        Item itemDrop = event.getItemDrop();
        HandlerList handlers = event.getHandlers();
        event.getPlayer().sendMessage(ChatColor.GRAY + "Du hast ein Item Gedroppt." + "" + "(" + ChatColor.RED + event.getItemDrop()+ ChatColor.GRAY + ")");



    }

    @EventHandler
    public void NewGamemode(PlayerGameModeChangeEvent event){
        GameMode newGameMode = event.getNewGameMode();
        Player player = event.getPlayer();
        event.getPlayer().sendMessage(ChatColor.GRAY + "Neuer Gamemode:" + ChatColor.GREEN + event.getNewGameMode());



    }
    @EventHandler
    public void kickEvent(PlayerKickEvent event){
        String reason = event.getReason();
        Player player = event.getPlayer();
        String leaveMessage = event.getLeaveMessage();
        event.getPlayer().getInventory().remove(Material.DIAMOND);
        event.setReason("Du wurdest gekickt. (Ich habe deine DIAS entfernt xD)");




    }
    @EventHandler
    public void CommandSendEvent(PlayerCommandSendEvent event){
        Collection<String> commands = event.getCommands();
        Player player = event.getPlayer();
        long playerTime = event.getPlayer().getPlayerTime();
        event.getPlayer().sendMessage("Du hast einen Command Ausgeführt... " + event.getCommands() + " Uhrzeit: " + event.getPlayer().getPlayerTime());


    }
}
