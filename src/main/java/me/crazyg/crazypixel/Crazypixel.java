package me.crazyg.crazypixel;

import me.crazyg.crazypixel.Commands.*;
import me.crazyg.crazypixel.Listeners.MenuListener;
import me.crazyg.crazypixel.Listeners.onJoinleaveListener;
import me.crazyg.crazypixel.Listeners.teleportBowListener;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class Crazypixel extends JavaPlugin {
    private Logger log = this.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info("Plugin Made By " + ChatColor.DARK_AQUA + "Crazyg");
        log.info("Thanks for using the plugin");
        log.info("\n" +
                "░█████╗░██████╗░░█████╗░███████╗██╗░░░██╗██████╗░██╗██╗░░██╗███████╗██╗░░░░░\n" +
                "██╔══██╗██╔══██╗██╔══██╗╚════██║╚██╗░██╔╝██╔══██╗██║╚██╗██╔╝██╔════╝██║░░░░░\n" +
                "██║░░╚═╝██████╔╝███████║░░███╔═╝░╚████╔╝░██████╔╝██║░╚███╔╝░█████╗░░██║░░░░░\n" +
                "██║░░██╗██╔══██╗██╔══██║██╔══╝░░░░╚██╔╝░░██╔═══╝░██║░██╔██╗░██╔══╝░░██║░░░░░\n" +
                "╚█████╔╝██║░░██║██║░░██║███████╗░░░██║░░░██║░░░░░██║██╔╝╚██╗███████╗███████╗\n" +
                "░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░░░░╚═╝╚═╝░░╚═╝╚══════╝╚══════╝");
        // Commands
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("ci").setExecutor(new CiCommand());
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("givebow").setExecutor(new GiveBowCommand(this));
        getCommand("armorstand").setExecutor(new armorStandCommand());
        // Listeners
        getServer().getPluginManager().registerEvents((Listener) new onJoinleaveListener(this), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new MenuListener(), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new teleportBowListener(this), (Plugin) this);
        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("CYA!!!!");
    }
}
