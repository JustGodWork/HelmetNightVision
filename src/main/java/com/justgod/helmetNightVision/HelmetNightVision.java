package com.justgod.helmetNightVision;

import com.justgod.helmetNightVision.controllers.PlayerController;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelmetNightVision extends JavaPlugin {

    private static HelmetNightVision _instance;

    public static HelmetNightVision getInstance() {
        return _instance;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        _instance = this;
        getServer().getPluginManager().registerEvents(new PlayerController(), this);
    }
}
