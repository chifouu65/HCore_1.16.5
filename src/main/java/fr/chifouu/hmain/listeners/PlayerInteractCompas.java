package fr.chifouu.hmain.listeners;

import fr.chifouu.hmain.HMain;
import fr.chifouu.hmain.ItemstackHelper;
import fr.chifouu.hmain.Servers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractCompas implements Listener {

    @EventHandler
    public void onInteractCompass(PlayerInteractEvent event){
        final Player player = event.getPlayer();
        final Action action = event.getAction();
        final ItemStack is = player.getInventory().getItemInMainHand();

        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if(is.getType().equals(HMain.COMPASS.getType())){
                if(is.hasItemMeta()){
                    if(is.getItemMeta().getDisplayName().equalsIgnoreCase(HMain.COMPASS.getItemMeta().getDisplayName())){
                        final Inventory menuServer = Bukkit.createInventory(player, InventoryType.CHEST, "Menu de servers");

                        for(Servers servers : Servers.values()) {
                            menuServer.addItem(ItemstackHelper.builditemStack(servers.getIs(), servers.getDisplayName(), servers.getDescription()));
                        }

                        player.openInventory(menuServer);
                    }
                }
            }
        }
    }
}
