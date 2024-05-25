package me.crazyg.crazypixel.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ciMenuListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){

        //did the player click the custom inventory
        if (e.getView().getTitle().equals(ChatColor.AQUA+"Custom Menu")){
            Player player = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getType()){
                case BREAD:
                    player.setFoodLevel(20);
                    player.sendMessage("YUMMY!");
                    break;
                case SPECTRAL_ARROW:
                    player.setGlowing(true);
                    player.sendMessage("A loom of light");
                    break;
                case CREEPER_HEAD:
                    player.setHealth(0);
                    player.sendMessage("GGs!");
                    break;
            }

        }

    }
}
