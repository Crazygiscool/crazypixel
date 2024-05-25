package me.crazyg.crazypixel.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class armorStandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p){
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
        return false;
    }
}