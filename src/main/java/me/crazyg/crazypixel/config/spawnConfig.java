package me.crazyg.crazypixel.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class spawnConfig {
    public static File file;
    public static FileConfiguration spawnConfig;
    //finds or generates the file.
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Crazypixel").getDataFolder(), "spawn.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //owwww
            }
        }
        spawnConfig = YamlConfiguration.loadConfiguration(file);
    }
    //get instance of spawnConfig
    public static FileConfiguration get(){
        return spawnConfig;
    }

    //save method
    public static void save(){
        try{
            spawnConfig.save(file);
        }catch (IOException e){
            System.out.println("COULDNT SAVE CONFIG FILE");
        }
    }

    public static void reload(){
        spawnConfig = YamlConfiguration.loadConfiguration(file);
    }

}
