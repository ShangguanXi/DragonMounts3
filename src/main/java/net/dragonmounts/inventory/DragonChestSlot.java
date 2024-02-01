package net.dragonmounts.inventory;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.screen.slot.Slot;

public class DragonChestSlot extends Slot {
    public final TameableDragonEntity dragon;

    public DragonChestSlot(DragonInventory inventory, TameableDragonEntity dragon, int index, int x, int y) {
        super(inventory, index, x, y);
        this.dragon = dragon;
    }

    @Override
    public boolean doDrawHoveringEffect() {
        return this.dragon.hasChest();
    }
}
