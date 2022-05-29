package fr.chifouu.hmain;

import fr.chifouu.hmain.listeners.InvClick;
import fr.chifouu.hmain.listeners.PlayerInteractCompas;
import fr.chifouu.hmain.listeners.PlayerJoin;
import fr.chifouu.hmain.listeners.PluginMessageListener;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;
import java.util.Arrays;


public final class HMain extends JavaPlugin {
    public static HMain INSTANCE;

    public static final ItemStack COMPASS = ItemstackHelper.builditemStack(
            new ItemStack(Material.COMPASS, 1), "Clique ici", new ArrayList<>(Arrays.asList("utilise la bousole pour changer des server")));

    public void onEnable() {

        INSTANCE = this;

        this.getServer().getMessenger().registerIncomingPluginChannel(this, "AdolaChannel", new PluginMessageListener());
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "AdolaChannel");

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getServer().getPluginManager().registerEvents(new InvClick(),this);
        getServer().getPluginManager().registerEvents(new PlayerInteractCompas(),this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
    }


    public void onDisable() {
        // Plugin shutdown logic
    }
}
