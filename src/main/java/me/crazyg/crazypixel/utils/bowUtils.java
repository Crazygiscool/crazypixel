package me.crazyg.crazypixel.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class bowUtils {
    public static ItemStack createTeleportBow() {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName("Teleport Bow");
        List<String> lore = new ArrayList<>();
        lore.add("Right click and shoot an arrow");
        lore.add("And the bow will teleport you to where the arrow lands");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(bowMeta);

        return bow;

    }
}
