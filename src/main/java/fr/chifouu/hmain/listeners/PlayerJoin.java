package fr.chifouu.hmain.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.chifouu.hmain.HMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final Inventory inventory = player.getInventory();
        final ItemStack[] itemStacks = inventory.getContents();

        for (ItemStack itemStack : itemStacks) {
            if (itemStack == null) continue;
            if (itemStack.getType().equals(HMain.COMPASS.getType())) {
                if (itemStack.hasItemMeta()) {
                    if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(HMain.COMPASS.getItemMeta().getDisplayName()))
                        ;
                    return;
                }
            }
        }
        inventory.addItem(HMain.COMPASS);
    }

    @EventHandler
    public void onJoinaa(PlayerJoinEvent event) {
        final ByteArrayDataOutput out = ByteStreams.newDataOutput();
        final Player player = event.getPlayer();

        out.writeUTF("GetProfile");
        out.writeUTF(player.getUniqueId().toString());

        Bukkit.getScheduler().scheduleSyncDelayedTask(HMain.INSTANCE, () -> {
            player.sendPluginMessage(HMain.INSTANCE, "Channel", out.toByteArray());

        }, 5L);

    }
}
