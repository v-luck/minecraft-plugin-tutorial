package me.JustLuck.Doctor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatColor;


public class Heal implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command,String label, String[] args) {
        if (label.equalsIgnoreCase("doctor")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("You are a console and thus cannot be healed");
                return true;
            }
            Player player = (Player) commandSender;
            if (!player.hasPermission("healer.use")) {
                player.sendMessage(ChatColor.RED + "YOU CANNOT USE THIS COMMAND");
                return true;
            }
            if (args.length == 0) {
                // /doctor
                TextComponent message = new TextComponent("Would you like to be healed");
                message.setColor(ChatColor.GOLD);
                message.setBold(true);
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        new ComponentBuilder("Click here to be healed!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(message);

                TextComponent message2 = new TextComponent("Would you like to be a goliath");
                message2.setColor(net.md_5.bungee.api.ChatColor.GOLD);
                message2.setBold(true);
                message2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/healer goliath"));
                message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        new ComponentBuilder("Click here to be goliath!").color(net.md_5.bungee.api.ChatColor.GREEN).italic(true).create()));
                player.spigot().sendMessage(message2);

                return true;
            }
            if (args[0].equalsIgnoreCase("healme")) {
                player.setHealth(20);
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"heal " + player.getName());
                player.sendMessage(ChatColor.GREEN + "You've been healed!");
                return true;
            }
            if (args[0].equalsIgnoreCase("goliath")) {
                player.setHealth(20);
                player.setAllowFlight(true);
                player.setLevel(69);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"heal " + player.getName());
                return true;
            }
            if (args[0].equalsIgnoreCase("removegoliath")) {
                player.setHealth(20);
                player.setAllowFlight(false);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"heal " + player.getName());
                return true;
            }
            player.sendMessage(ChatColor.RED + "Usage: /doctor");
            // /healer healme
            return true;
        }
        return false;
    }
}
