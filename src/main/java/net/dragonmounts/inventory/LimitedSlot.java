package net.dragonmounts.inventory;

import net.dragonmounts.item.DragonArmorItem;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SaddleItem;
import net.minecraft.screen.slot.Slot;

public abstract class LimitedSlot extends Slot {
    public LimitedSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public abstract boolean canInsert(ItemStack stack);

    public static class Reject extends LimitedSlot {
        public Reject(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }
    }

    public static class Saddle extends LimitedSlot {
        public static boolean canInsert(Item item) {
            return item instanceof SaddleItem;
        }

        public Saddle(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public int getMaxItemCount() {
            return 1;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return Saddle.canInsert(stack.getItem());
        }

        @Override
        public void markDirty() {
            if (this.inventory instanceof DragonInventory) {
                ((DragonInventory) this.inventory).dragon.setSaddle(this.getStack(), false);
            } else {
                this.inventory.markDirty();
            }
        }
    }

    public static class DragonArmor extends LimitedSlot {
        public static boolean canInsert(Item item) {
            return item instanceof DragonArmorItem;
        }

        public DragonArmor(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public int getMaxItemCount() {
            return 1;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return DragonArmor.canInsert(stack.getItem());
        }

        @Override
        public void markDirty() {
            if (this.inventory instanceof DragonInventory) {
                ((DragonInventory) this.inventory).dragon.setArmor(this.getStack(), false);
            } else {
                this.inventory.markDirty();
            }
        }
    }

    public static class SingleWoodenChest extends LimitedSlot {
        public static boolean canInsert(Item item) {
            return Items.CHEST == item || Items.TRAPPED_CHEST == item;//ItemTags.CHESTS_WOODEN.contains(item)
        }

        public SingleWoodenChest(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public int getMaxItemCount() {
            return 1;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return SingleWoodenChest.canInsert(stack.getItem());
        }

        @Override
        public void markDirty() {
            if (this.inventory instanceof DragonInventory)
                ((DragonInventory) this.inventory).dragon.setChest(this.getStack(), false);
            else this.inventory.markDirty();
        }
    }
}
