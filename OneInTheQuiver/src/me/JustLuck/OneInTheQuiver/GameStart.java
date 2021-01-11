package me.JustLuck.OneInTheQuiver;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class GameStart implements CommandExecutor {
    private ScoreboardManager scoreboardManager;
    private Scoreboard scoreboard;

    public GameStart(ScoreboardManager scoreboardManager, Scoreboard scoreboard) {
        this.scoreboardManager = scoreboardManager;
        this.scoreboard = scoreboard;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("GameStart")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("You need to be a player to use this");
                return true;
            }
        }

        Player player = (Player) commandSender;
        if (args.length == 0) {
            player.sendMessage("Create a team name");
        }
        if (args.length == 2) {
            Team team = scoreboard.registerNewTeam(args[0]);
            team.addEntry(args[1]);
        }
        return false;
    }
}
