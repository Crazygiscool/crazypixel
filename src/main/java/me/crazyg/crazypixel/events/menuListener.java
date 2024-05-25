package me.crazyg.crazypixel.events;

import me.crazyg.crazypixel.Crazypixel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
    public void onMenuClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        //Menu list
        final String MAIN_MENU = ChatColor.BLUE + "AS GUI";
        final String CREATE_MENU = ChatColor.GREEN + "Create a armor stand";
        final String CONFIRM_MENU = ChatColor.DARK_GREEN + "Confirm your options";

        //Determine which inventory is open
        if (e.getView().getTitle().equalsIgnoreCase(MAIN_MENU)) {
            //Figure out what button was clicked
            switch (e.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    player.sendMessage("Opened Armor Stand Create Menu");
                    //Open the menu for creating an armor stand
                    plugin.openCreatmenu(player);
                    break;
                case BARRIER:
                    player.sendMessage("Closing Menu.");
                    player.closeInventory();
                    break;
            }

            e.setCancelled(true);
            if (e.getView().getTopInventory().equals(MAIN_MENU) && e.getClick().isShiftClick()) {

                e.setCancelled(true);

            }
        } else if (e.getView().getTitle().equalsIgnoreCase(CREATE_MENU)) {
            switch (e.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    player.sendMessage("AddArms?");
                    plugin.openConfirmMenu(player, Material.ARMOR_STAND);
                    break;
                case BEACON:
                    player.sendMessage("AddGlow?");
                    plugin.openConfirmMenu(player, Material.BEACON);
                    break;
                case NETHERITE_CHESTPLATE:
                    player.sendMessage("ARMOR?");
                    //armor select gui
                    break;
                case SMOOTH_STONE_SLAB:
                    player.sendMessage("baseVisible?");
                    plugin.openConfirmMenu(player, Material.SMOOTH_STONE_SLAB);
                    break;
            }
            e.setCancelled(true);
            if (e.getView().getTopInventory().equals(MAIN_MENU) && e.getClick().isShiftClick()) {

                e.setCancelled(true);

            }
        } else if (e.getView().getTitle().equalsIgnoreCase(CONFIRM_MENU)) {
            switch (e.getCurrentItem().getType()) {
                case GREEN_WOOL:
                    player.sendMessage("option confimed");
                    plugin.openCreatmenu(player);
                case RED_WOOL:
                    player.sendMessage("Option cancelled");
                    plugin.openCreatmenu(player);
                    e.setCancelled(true);
            }
        }
    }
}
