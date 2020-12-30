package me.JustLuck.Launch;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender commandSender, Command command,String label, String[] args) {
        if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("*Console goes flying*");
                return true;
            }
            Player player = (Player) commandSender;
            // /launch    /launch <number>
            if (args.length == 0) {
                // /launch
                player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Weeeeeee!");
                player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                return true;
            }

            player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Weeeeeee!");
            player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
            return true;
        }
        return false;
    }
}
