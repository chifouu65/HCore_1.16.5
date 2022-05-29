package fr.chifouu.hmain;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public enum Servers {

    SERVER1("server1", new ItemStack(Material.DIAMOND), "Server-1", new ArrayList<>(Arrays.asList("Connectez vous au server-1"))),

    SERVERS2("server2", new ItemStack(Material.IRON_INGOT),"Server-2", new ArrayList<>(Arrays.asList("Connectez vous au server-2")));


    private final String bungeeName;
    private final ItemStack is;
    private final String displayName;
    private final ArrayList<String> description;

    public String getBungeeName() {
        return bungeeName;
    }

    public ItemStack getIs() {
        return is;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    Servers(String bungeeName, ItemStack is, String displayName, ArrayList<String> description){
        this.bungeeName = bungeeName;
        this.is = is;
        this.displayName = displayName;
        this.description = description;
    }


}
