package pl.barthvisuals.bvblockedcmds;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Uruchomiono plugin...");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    private void onCmd(PlayerCommandPreprocessEvent e){
        if(getConfig().getList("blocked-commands").contains(e.getMessage())){
            e.setCancelled(true);
            e.getPlayer().sendMessage("§cKomenda jest zablokowana!");
        }
    }
}