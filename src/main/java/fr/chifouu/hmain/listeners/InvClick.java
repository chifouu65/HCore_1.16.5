package fr.chifouu.hmain.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.chifouu.hmain.HMain;
import fr.chifouu.hmain.Servers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        event.getInventory().clear();
        final Player player = (Player) event.getWhoClicked();
        final Inventory inventory = event.getClickedInventory();

        if(inventory.getType().equals(InventoryType.CHEST)){
            final int clickSlots = event.getSlot();
            final ItemStack itemStack = inventory.getItem(clickSlots);

            if(itemStack != null){
                if(itemStack.hasItemMeta()){
                    final ItemMeta itemMeta = itemStack.getItemMeta();

                if(itemMeta.hasDisplayName()) {
                    final String displayName = itemMeta.getDisplayName();

                    for (Servers servers : Servers.values()) {
                        if (servers.getDisplayName().equals(displayName)) {
                            //envoi du signal a bungee

                            final ByteArrayDataOutput out = ByteStreams.newDataOutput();

                            out.writeUTF("Connect");
                            out.writeUTF(servers.getBungeeName());

                            player.sendPluginMessage(HMain.INSTANCE, "BungeeCord", out.toByteArray());
                            }
                        }
                    }
                }
            }
        }
        event.setCancelled(true);
    }

}
