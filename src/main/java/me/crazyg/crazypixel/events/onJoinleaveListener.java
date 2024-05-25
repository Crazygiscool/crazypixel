package me.crazyg.crazypixel.events;

import me.crazyg.crazypixel.Crazypixel;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import java.util.logging.Logger;

public class onJoinleaveListener implements Listener {

    private Logger log = this.getLogger();

    private Logger getLogger() {
        return null;
    }

    private final Crazypixel plugin;

    public onJoinleaveListener(Crazypixel plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){

        Player player = e.getPlayer();

        String leavemsg = this.plugin.getConfig().getString("leave-message");

        if(leavemsg != null){
            leavemsg = leavemsg.replace("%player%", e.getPlayer().getDisplayName());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', leavemsg));

        }else{
            log.info("SET THE LEAVE-MESSAGE IN CONFIG.YML");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        String joinmsg = this.plugin.getConfig().getString("join-message");

        String firstjoinmsg = this.plugin.getConfig().getString("first-join-message");
        if (player.hasPlayedBefore()){

            if(joinmsg != null){
                joinmsg = joinmsg.replace("%player%", e.getPlayer().getDisplayName());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', joinmsg));

            }else{
                log.info("SET THE JOIN-MESSAGE IN CONFIG.YML");
            }

        }else{

            if(firstjoinmsg != null){
                firstjoinmsg = firstjoinmsg.replace("%player%", e.getPlayer().getDisplayName());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', firstjoinmsg));

            }else{
                log.info("SET THE FIRST-JOIN-MESSAGE IN CONFIG.YML");
            }

        }

    }
}
