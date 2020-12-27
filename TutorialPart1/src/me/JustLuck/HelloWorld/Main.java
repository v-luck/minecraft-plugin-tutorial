package me.JustLuck.HelloWorld;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        //startup
        //reloads
        //plugin reloads
    }

    @Override
    public void onDisable() {
        //shutdown
        //reloads
        //plugin reloads
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                player.giveExpLevels(1);
                if (player.hasPermission("hello.use")) {
                    player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Hello " + player.getDisplayName() + ", welcome to the server!");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "H&a&ve& f&un&!"));
                    return true;
                }
                player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "You do not have permission to do that..." + "Woahhh");
                return true;
            } else {
                commandSender.sendMessage("Hello console!");
                return true;
            }
        }
        return false;
    }
}
