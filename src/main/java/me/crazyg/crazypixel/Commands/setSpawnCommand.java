package me.crazyg.crazypixel.Commands;

import me.crazyg.crazypixel.Crazypixel;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static me.crazyg.crazypixel.config.spawnConfig.file;
import static me.crazyg.crazypixel.config.spawnConfig.spawnConfig;

public class setSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            Location location = p.getLocation();
            spawnConfig.set("spawn", location);
            try {
                spawnConfig.save(file);
            } catch (IOException e) {
                //eeeee
            }

            p.sendMessage("Spawn saved");

        }

        return true;
    }
}
