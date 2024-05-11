package me.crazyg.crazypixel.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            // the number can be multiplys of 9, the max is 54
            Inventory menu = Bukkit.createInventory(p,27, ChatColor.AQUA+"Custom Menu");

            //item as buttons
            //define item as a name
            ItemStack glow = new ItemStack(Material.SPECTRAL_ARROW);
            ItemStack creep = new ItemStack(Material.CREEPER_HEAD);
            ItemStack bread = new ItemStack(Material.BREAD);
            //define the item's meta
            ItemMeta glowMeta = glow.getItemMeta();
            ItemMeta creepMeta = creep.getItemMeta();
            ItemMeta breadMeta = bread.getItemMeta();
            //adds the meta
            glowMeta.setDisplayName(ChatColor.GOLD+"GLOW");
            creepMeta.setDisplayName(ChatColor.GREEN+"CREEPER!");
            breadMeta.setDisplayName(ChatColor.YELLOW+"FOOD");

            glowMeta.setLore(List.of(ChatColor.GRAY+"Gives you a custom brewing stand"));
            creepMeta.setLore(List.of(ChatColor.GRAY+"KILLs you"));
            breadMeta.setLore(List.of(ChatColor.GRAY+"Feeds you"));
            //accually set the itemMeta
            glow.setItemMeta(glowMeta);
            creep.setItemMeta(creepMeta);
            bread.setItemMeta(glowMeta);

            //set the item in the menu
            menu.setItem(11, glow);
            menu.setItem(13,creep);
            menu.setItem(15, glow);

        }else{
            sender.sendMessage("Only players can execute this command");
        }
        return true;
    }
}
