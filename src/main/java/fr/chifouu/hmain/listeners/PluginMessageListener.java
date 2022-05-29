package fr.chifouu.hmain.listeners;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if(channel.equals("AdolaChannel")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            final String sub = in.readUTF();

            if(sub.equals("GetProfile")){
                final int id = in.readInt();
                final String uuid = in.readUTF();
                final String guild = in.readUTF();
                final float coins = in.readFloat();
                final int level = in.readInt();
                final String rank = in.readUTF();
                final int kill = in.readInt();

                player.sendMessage(ChatColor.GREEN + "le compte n: "+ id + "avec l'uuid : " + uuid + "de la guild " + guild +
                        " avec coins : " + coins + "le lvl est de : " + level + "avec kill : " + kill +
                        " et le grade : "+ rank);
            }
        }
    }
}
