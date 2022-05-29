package fr.chifouu.hmain;


import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemstackHelper {

    public static ItemStack builditemStack (ItemStack is, String displayName, ArrayList<String> description){
        final ItemMeta im = is.getItemMeta();

                im.setDisplayName(displayName);
                im.setLore(description);
                im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_DESTROYS,ItemFlag.HIDE_UNBREAKABLE);

                is.setItemMeta(im);

                return is;
    }

}


