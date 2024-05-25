package me.crazyg.crazypixel.events;

import me.crazyg.crazypixel.Crazypixel;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class menuListener implements Listener {
    Crazypixel plugin;

    public menuListener(Crazypixel plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        //Menu list
        final String MAIN_MENU = ChatColor.BLUE+"AS GUI";

        //Determine which inventory is open
        if (e.getView().getTitle().equalsIgnoreCase(MAIN_MENU)){
            //Figure out what button was clicked
            switch(e.getCurrentItem().getType()){
                case ARMOR_STAND:
                    player.sendMessage("Opened Armor Stand Create Menu");
                    //Open the menu for creating an armor stand
                    break;
                case BARRIER:
                    player.sendMessage("Closing Menu.");
                    player.closeInventory();
                    break;
            }

            e.setCancelled(true);
        }
    }
}
