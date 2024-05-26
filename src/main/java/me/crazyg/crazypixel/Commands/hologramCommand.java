package me.crazyg.crazypixel.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class hologramCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            ArmorStand hologram = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
            hologram.setVisible(false);
            hologram.setCustomNameVisible(true);
            hologram.setCustomName(ChatColor.DARK_RED+"WELCOME TO CRAZYPIXEL");
            hologram.setGravity(false);
            hologram.setInvulnerable(true);
            ArmorStand hologram2 = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0,-0.25,0), EntityType.ARMOR_STAND);
            hologram2.setVisible(false);
            hologram2.setCustomNameVisible(true);
            hologram2.setCustomName(ChatColor.DARK_RED+"HAVE SOME FUN!");
            hologram2.setGravity(false);
            hologram2.setInvulnerable(true);
        }

        return true;
    }
}
