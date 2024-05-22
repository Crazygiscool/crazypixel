package me.crazyg.crazypixel.Commands;

import me.crazyg.crazypixel.Crazypixel;
import me.crazyg.crazypixel.utils.bowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveBowCommand implements CommandExecutor {

    private final Crazypixel plugin;
    private final bowUtils bowUtils;

    public GiveBowCommand(Crazypixel plugin) {
        this.plugin = plugin;
        this.bowUtils = new bowUtils(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length == 0) {
                ItemStack bow = bowUtils.createTeleportBow();
                p.getInventory().addItem(bow);
                p.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                p.sendMessage(ChatColor.GREEN + "You have been given a teleport bow!");

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    p.sendMessage(ChatColor.DARK_RED + "The Player You Are Targetting Is Not Online");

                    return true;
                } else {
                    ItemStack bow = bowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                    target.sendMessage(plugin.getConfig().getString("teleport-message"));

                }

            }

        }
        return true;
    }
}
