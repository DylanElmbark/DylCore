package com.spindel.dylcore.dylcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class DylCore extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin Enable
        System.out.println("Kickstarting this bad boy up...");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin Disable
        System.out.println("Disabling DylCore please wait!");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        // This runs once the event is triggered
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.RED + "Don't sleep too long you moron...");
    }

    @EventHandler
    public void onShear(PlayerShearEntityEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_AQUA + "Hah you tried it xd.");

    }

    // /dylcore <-- Main command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("dylcore")) {
            if (sender instanceof Player) {
                // if player executes the command
                Player player = (Player) sender;
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("fly")) {
                        if (player.hasPermission("dylcore.flight")) {
                            player.setAllowFlight(true);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&cDylCore&6] &cFlight mode enabled!"));
                            return true;
                        }

                    }

                }
                if (player.hasPermission("dylcore.use")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&cDylCore&6] &cYou're running the latest version of DylCore!"));
                    return true;

                } else {
                    // if console executes the command
                    sender.sendMessage(ChatColor.RED + "[DylCore] You're running the latest version of DylCore!");

                }

                }
        }
        return true;
    }
}