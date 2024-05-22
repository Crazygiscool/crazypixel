package me.crazyg.crazypixel.Listeners;


import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class teleportBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        if ((e.getEntity().getShooter() instanceof Player p)) {
            ItemStack mainHandItem = p.getInventory().getItemInMainHand();

            if (mainHandItem.getItemMeta().getDisplayName().equalsIgnoreCase("Teleport Bow")){

                Location location = e.getEntity().getLocation();

                p.teleport(location);
                e.getEntity().remove();
                p.sendMessage("You have been teleported by the teleport bow!");

            }

        }

    }
}
