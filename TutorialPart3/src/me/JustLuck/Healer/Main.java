package me.JustLuck.Healer;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("Healer").setExecutor(new Heal());
    }

    @Override
    public void onDisable() {
    }
}
