package me.JustLuck.OneInTheQuiver;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        this.getCommand("GameStart").setExecutor(new GameStart(manager, scoreboard));
    }
    @Override
    public void onDisable() {

    }
}
