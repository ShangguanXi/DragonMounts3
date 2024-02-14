package net.dragonmounts.inventory;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

/**
 * @see net.minecraft.inventory.Inventory
 */
public class DragonInventory implements Inventory, NamedScreenHandlerFactory, ExtendedScreenHandlerFactory {
    public static final String DATA_PARAMETER_KEY = "Items";
    public static final int SLOT_SADDLE_INDEX = 0;
    public static final int SLOT_ARMOR_INDEX = 1;
    public static final int SLOT_CHEST_INDEX = 2;
    public static final int INVENTORY_SIZE = 30;

    public final TameableDragonEntity dragon;
    protected final DefaultedList<ItemStack> items = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);

    public DragonInventory(TameableDragonEntity dragon) {
        this.dragon = dragon;
    }

    @Override
    public final int size() {
        return this.dragon.hasChest() ? INVENTORY_SIZE : 3;
    }

    @Override
    public boolean isEmpty() {
        return this.items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getStack(int index) {
        switch (index) {
            case SLOT_SADDLE_INDEX:
                return this.dragon.getSaddleStack();
            case SLOT_ARMOR_INDEX:
                return this.dragon.getArmorStack();
            case SLOT_CHEST_INDEX:
                return this.dragon.getChestStack();
            default:
                return index >= 0 && index < this.items.size() ? this.items.get(index) : ItemStack.EMPTY;
        }
    }

    @Override
    public ItemStack removeStack(int index, int count) {
        ItemStack stack;
        if (count <= 0) return ItemStack.EMPTY;
        ItemStack original;
        switch (index) {
            case SLOT_SADDLE_INDEX:
                original = this.dragon.getSaddleStack();
                if (original.isEmpty()) return ItemStack.EMPTY;
                count = Math.min(count, original.getCount());
                stack = original.copy();
                stack.setCount(count);
                original.decrement(count);
                this.dragon.setSaddle(original, true);
                break;
            case SLOT_ARMOR_INDEX:
                original = this.dragon.getArmorStack();
                if (original.isEmpty()) return ItemStack.EMPTY;
                count = Math.min(count, original.getCount());
                stack = original.copy();
                stack.setCount(count);
                original.decrement(count);
                this.dragon.setArmor(original, true);
                break;
            case SLOT_CHEST_INDEX:
                original = this.dragon.getChestStack();
                if (original.isEmpty()) return ItemStack.EMPTY;
                count = Math.min(count, original.getCount());
                stack = original.copy();
                stack.setCount(count);
                original.decrement(count);
                this.dragon.setChest(original, true);
                break;
            default:
                stack = Inventories.splitStack(this.items, index, count);
                if (!stack.isEmpty()) {
                    this.markDirty();
                }
        }
        return stack;
    }

    @Override
    public ItemStack removeStack(int index) {
        ItemStack stack;
        switch (index) {
            case SLOT_SADDLE_INDEX:
                stack = this.dragon.getSaddleStack();
                if (stack.isEmpty()) return ItemStack.EMPTY;
                this.dragon.setSaddle(ItemStack.EMPTY, false);
                break;
            case SLOT_ARMOR_INDEX:
                stack = this.dragon.getArmorStack();
                if (stack.isEmpty()) return ItemStack.EMPTY;
                this.dragon.setSaddle(ItemStack.EMPTY, false);
                break;
            case SLOT_CHEST_INDEX:
                stack = this.dragon.getChestStack();
                if (stack.isEmpty()) return ItemStack.EMPTY;
                this.dragon.setChest(ItemStack.EMPTY, false);
                break;
            default:
                stack = Inventories.removeStack(this.items, index);
        }
        return stack;
    }

    @Override
    public void setStack(int index, ItemStack stack) {
        switch (index) {
            case SLOT_SADDLE_INDEX:
                this.dragon.setSaddle(stack, true);
                break;
            case SLOT_ARMOR_INDEX:
                this.dragon.setArmor(stack, true);
                break;
            case SLOT_CHEST_INDEX:
                this.dragon.setChest(stack, true);
                break;
            default:
                if (index < 0 || index >= this.items.size()) return;
                if (!stack.isEmpty() && stack.getCount() > this.getMaxCountPerStack())
                    stack.setCount(this.getMaxCountPerStack());
                this.items.set(index, stack);
                this.markDirty();
        }
    }

    public boolean setItemAfterChecked(int index, ItemStack stack) {
        Item item = stack.getItem();
        switch (index) {
            case SLOT_SADDLE_INDEX:
                if (item == Items.AIR || LimitedSlot.Saddle.canInsert(item)) {
                    this.dragon.setSaddle(stack, true);
                    return true;
                }
                return false;
            case SLOT_ARMOR_INDEX:
                if (item == Items.AIR || LimitedSlot.DragonArmor.canInsert(item)) {
                    this.dragon.setArmor(stack, true);
                    return true;
                }
                return false;
            case SLOT_CHEST_INDEX:
                if (item == Items.AIR || LimitedSlot.SingleWoodenChest.canInsert(item)) {
                    this.dragon.setChest(stack, true);
                    return true;
                }
                return false;
            default:
                if (index < 0 || index >= this.items.size() || !this.dragon.hasChest()) return false;
                if (!stack.isEmpty() && stack.getCount() > this.getMaxCountPerStack())
                    stack.setCount(this.getMaxCountPerStack());
                this.items.set(index, stack);
                this.markDirty();
                return true;
        }
    }

    @Override
    public void markDirty() {
        this.dragon.inventoryChanged();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        if (!this.dragon.isAlive()) return false;
        return player.squaredDistanceTo(this.dragon) <= 64.0D;//8 blocks
    }

    @Override
    public void clear() {
        this.items.clear();
        this.dragon.setSaddle(ItemStack.EMPTY, true);
        this.dragon.setArmor(ItemStack.EMPTY, true);
        this.dragon.setChest(ItemStack.EMPTY, true);
        this.markDirty();
    }

    @Override
    public Text getDisplayName() {
        return this.dragon.getDisplayName();
    }

    @Override
    public DragonInventoryScreenHandler createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
        return new DragonInventoryScreenHandler(id, inventory, this, this.dragon);
    }

    public void dropContents(boolean keepEquipments, double offsetY) {
        World world = this.dragon.world;
        double x = this.dragon.getX();
        double y = this.dragon.getY() + offsetY;
        double z = this.dragon.getZ();
        if (!keepEquipments) {
            ItemScatterer.spawn(world, x, y, z, this.dragon.getSaddleStack());
            ItemScatterer.spawn(world, x, y, z, this.dragon.getArmorStack());
            ItemScatterer.spawn(world, x, y, z, this.dragon.getChestStack());
        }
        for (ItemStack stack : this.items)
            ItemScatterer.spawn(world, x, y, z, stack);
    }

    public void fromTag(NbtList list) {
        boolean saddle = false;
        boolean armor = false;
        boolean chest = false;
        for (int i = 3; i < this.items.size(); ++i)
            this.items.set(i, ItemStack.EMPTY);
        for (int i = 0; i < list.size(); ++i) {
            NbtCompound compound = list.getCompound(i);
            int j = compound.getByte("Slot") & 255;
            saddle |= j == SLOT_SADDLE_INDEX;
            armor |= j == SLOT_ARMOR_INDEX;
            chest |= j == SLOT_CHEST_INDEX;
            this.setStack(j, ItemStack.fromNbt(compound));
        }
        if (!saddle) this.dragon.setSaddle(ItemStack.EMPTY, true);
        if (!armor) this.dragon.setArmor(ItemStack.EMPTY, true);
        if (!chest) this.dragon.setChest(ItemStack.EMPTY, true);
    }

    public NbtList createTag() {
        NbtList list = new NbtList();
        for (int i = 0; i < INVENTORY_SIZE; ++i) {
            ItemStack stack = this.getStack(i);
            if (!stack.isEmpty()) {
                NbtCompound compound = new NbtCompound();
                compound.putByte("Slot", (byte) i);
                list.add(stack.writeNbt(compound));
            }
        }
        return list;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buffer) {
        this.dragon.writeId(buffer);
    }
}
