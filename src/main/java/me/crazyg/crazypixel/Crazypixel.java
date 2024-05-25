package me.crazyg.crazypixel;

import me.crazyg.crazypixel.Commands.*;
import me.crazyg.crazypixel.events.ciMenuListener;
import me.crazyg.crazypixel.events.menuListener;
import me.crazyg.crazypixel.events.onJoinleaveListener;
import me.crazyg.crazypixel.events.teleportBowListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
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
        getCommand("armorstand").setExecutor(new armorStandCommand(this));
        // Listeners
        getServer().getPluginManager().registerEvents((Listener) new onJoinleaveListener(this), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new ciMenuListener(), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new teleportBowListener(this), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new menuListener(this), this);
        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
    // main menu for armor stand
    public void openMainMenu(Player p){
        //create a GUI
        Inventory main_menu = Bukkit.createInventory(p, 9, ChatColor.BLUE+"AS GUI");

        //Item stack for the options for menu
        ItemStack create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta create_meta = create.getItemMeta();
        create_meta.setDisplayName(ChatColor.GREEN+"Create");
        ArrayList<String> create_lore = new ArrayList<>();
        create_lore.add(ChatColor.DARK_PURPLE+"Create a new armor stand");
        create_meta.setLore(create_lore);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta close_meta = close.getItemMeta();
        close_meta.setDisplayName(ChatColor.DARK_RED+"Close");
        close.setItemMeta(close_meta);

        //add the item to the slots on the menu
        main_menu.setItem(0, create);
        main_menu.setItem(8, close);

        //show the player the menu
        p.openInventory(main_menu);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("CYA!!!!");
    }
}
