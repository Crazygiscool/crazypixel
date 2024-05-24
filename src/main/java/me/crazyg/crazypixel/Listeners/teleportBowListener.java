package me.crazyg.crazypixel.Listeners;


import me.crazyg.crazypixel.Crazypixel;
import me.crazyg.crazypixel.utils.bowUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class teleportBowListener implements Listener {

    private final Crazypixel plugin;
    private final bowUtils bowUtils;

    public teleportBowListener(Crazypixel plugin) {
        this.plugin = plugin;
        this.bowUtils = new bowUtils(plugin);
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        if ((e.getEntity().getShooter() instanceof Player p)) {
            ItemStack mainHandItem = p.getInventory().getItemInMainHand();

            if (mainHandItem.getItemMeta().getDisplayName().equalsIgnoreCase("Teleport Bow")){

                Location location = e.getEntity().getLocation();

                p.teleport(location);
                e.getEntity().remove();
                p.sendMessage("You have been teleported by the teleport bow!");
                p.playSound(p, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f );

            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if (plugin.getConfig().getBoolean("give-on-join")){
            Player p = e.getPlayer();
            p.getInventory().addItem(bowUtils.createTeleportBow());
            p.getInventory().addItem(new ItemStack(Material.BOW, 1));
        }

    }
}
