package me.crazyg.crazypixel.utils;

import me.crazyg.crazypixel.Crazypixel;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class bowUtils {

    private final Crazypixel plugin;

    public bowUtils(Crazypixel plugin) {
        this.plugin = plugin;
    }

    public ItemStack createTeleportBow() {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(plugin.getConfig().getString("bow-name"));
        List<String> lore = new ArrayList<>();
        lore.add(plugin.getConfig().getString("bow-descryption"));
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(bowMeta);

        return bow;

    }
}
