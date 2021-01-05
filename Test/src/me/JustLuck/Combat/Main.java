package me.JustLuck.Combat;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("kit")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("You are not a player");
                return true;
            }

            Player player = (Player) commandSender;
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
            return true;
        }
        commandSender.sendMessage("Error");
        return false;
    }
}
