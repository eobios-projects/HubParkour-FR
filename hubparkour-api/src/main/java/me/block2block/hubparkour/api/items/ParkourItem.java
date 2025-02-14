package me.block2block.hubparkour.api.items;

import me.block2block.hubparkour.api.HubParkourAPI;
import me.block2block.hubparkour.api.IHubParkourPlayer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a generic parkour item.
 *
 * <strong>WARNING:</strong> never create ParkourItem objects. Always extend this class.
 */
public abstract class ParkourItem {

    protected final IHubParkourPlayer player;
    protected ItemStack originalItem;
    protected final int slot;
    protected final ItemStack item;

    public ParkourItem(IHubParkourPlayer player, int slot) {
        this.player = player;
        this.slot = slot;
        item = HubParkourAPI.getItem(this.getType());
    }

    public abstract int getType();

    public ItemStack getItem() {
        return item;
    }

    public void giveItem() {
        if (slot >= 0 && slot < 9) {
            originalItem = player.getPlayer().getInventory().getItem(slot);
            if (originalItem == null) {
                originalItem = new ItemStack(Material.AIR);
            }
            player.getPlayer().getInventory().setItem(slot, item);
        }
    }

    public void removeItem() {
        if (slot >= 0 && slot < 9 && originalItem != null) {
            player.getPlayer().getInventory().setItem(slot, originalItem);
            originalItem = null;
        } else if (slot >= 0 && slot < 9) {
            player.getPlayer().getInventory().setItem(slot, new ItemStack(Material.AIR));
        }
    }

    public IHubParkourPlayer getPlayer() {
        return player;
    }

    public int getSlot() {
        return slot;
    }

    public ItemStack getOriginalItem() {
        return originalItem;
    }
}
