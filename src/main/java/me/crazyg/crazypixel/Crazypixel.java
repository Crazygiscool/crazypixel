package me.crazyg.crazypixel;

import me.crazyg.crazypixel.Commands.*;
import me.crazyg.crazypixel.config.spawnConfig;
import me.crazyg.crazypixel.events.ciMenuListener;
import me.crazyg.crazypixel.events.menuListener;
import me.crazyg.crazypixel.events.onJoinleaveListener;
import me.crazyg.crazypixel.events.teleportBowListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.logging.Logger;



public final class Crazypixel extends JavaPlugin {

    private Logger log = this.getLogger();
    //armor stand hash map
    public HashMap<Player , ArmorStand> armorstands = new HashMap<>();
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
        getCommand("hologram").setExecutor(new hologramCommand());
        getCommand("setspawn").setExecutor(new setSpawnCommand());
        // Event Listeners
        getServer().getPluginManager().registerEvents((Listener) new onJoinleaveListener(this), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new ciMenuListener(), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new teleportBowListener(this), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new menuListener(this), this);
        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //spawn.yml
        spawnConfig.setup();
        spawnConfig.get().options().copyDefaults(true);
        spawnConfig.save();
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

    //create menu
    public void openCreatmenu(Player p ){
        Inventory create_menu = Bukkit.createInventory(p, 9, ChatColor.GREEN+"Create a armor stand" );
        //options
        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemStack glow = new ItemStack(Material.BEACON);
        ItemStack armor = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemStack base = new ItemStack(Material.SMOOTH_STONE_SLAB);
        ItemStack complete = new ItemStack(Material.GREEN_WOOL);
        ItemStack cancel = new ItemStack(Material.RED_WOOL);
        //position
        create_menu.setItem(0,arms);
        create_menu.setItem(1,glow);
        create_menu.setItem(2,armor);
        create_menu.setItem(3,base);
        create_menu.setItem(7,complete);
        create_menu.setItem(8,cancel);
        //option meta
        ItemMeta arms_meta = arms.getItemMeta();
        ItemMeta glow_meta = glow.getItemMeta();
        ItemMeta armor_meta = armor.getItemMeta();
        ItemMeta base_meta = base.getItemMeta();
        ItemMeta complete_meta = complete.getItemMeta();
        ItemMeta cancel_meta = cancel.getItemMeta();
        arms_meta.setDisplayName("Arms");
        glow_meta.setDisplayName("Glow");
        armor_meta.setDisplayName("Armor");
        base_meta.setDisplayName("Base");
        complete_meta.setDisplayName("Complete");
        cancel_meta.setDisplayName("Cancel");

        //open the menu
        p.openInventory(create_menu);
    }
    public void openConfirmMenu(Player p, Material option){
        Inventory confirm_Menu = Bukkit.createInventory(p, 9, ChatColor.DARK_GREEN+"Confirm your options");
        ItemStack option_item = new ItemStack(option);
        ItemMeta option_meta = option_item.getItemMeta();
        if(option == Material.ARMOR_STAND){
            option_meta.setDisplayName(ChatColor.YELLOW+"Give arms?");
            option_item.setItemMeta(option_meta);
        } else if (option == Material.BEACON) {
            option_meta.setDisplayName(ChatColor.YELLOW+"Add glow?");
            option_item.setItemMeta(option_meta);
        } else if (option == Material.SMOOTH_STONE_SLAB) {
            option_meta.setDisplayName(ChatColor.YELLOW+"visible base?");
            option_item.setItemMeta(option_meta);
        }
        ItemStack yes = new ItemStack(Material.GREEN_WOOL);
        ItemStack no = new ItemStack(Material.RED_WOOL);
        ItemMeta yes_meta = yes.getItemMeta();
        ItemMeta no_meta = no.getItemMeta();
        yes_meta.setDisplayName("Yes");
        no_meta.setDisplayName("No");
        yes.setItemMeta(yes_meta);
        no.setItemMeta(no_meta);

        confirm_Menu.setItem(13, option_item);
        confirm_Menu.setItem( 21, yes);
        confirm_Menu.setItem( 23, no);

        p.openInventory(confirm_Menu);
    }

    public void openArmorMenu(Player p){
        Inventory armor_menu = Bukkit.createInventory(p, 45, ChatColor.BLUE+"Change some armor");
        //options for armor
        ItemStack dimhead = new ItemStack(Material.DIAMOND_HELMET);

        //confirm button
        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.GREEN+"Done");
        confirm.setItemMeta(confirm_meta);

        //slots for the item
        armor_menu.setItem(45, confirm);
        armor_menu.setItem(1,dimhead);

        //open the gui
        p.openInventory(armor_menu);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("CYA!!!!");
    }
}
