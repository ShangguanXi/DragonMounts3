package net.dragonmounts.entity.dragon;

import net.dragonmounts.inventory.DragonInventory;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class TameableDragonEntity extends TameableEntity {
    public static final String AGE_DATA_PARAMETER_KEY = "Age";
    public static final String AGE_LOCKED_DATA_PARAMETER_KEY = "AgeLocked";
    public static final String FLYING_DATA_PARAMETER_KEY = "Flying";
    public static final String SADDLE_DATA_PARAMETER_KEY = "Saddle";
    public static final String SHEARED_DATA_PARAMETER_KEY = "ShearCooldown";

    public final DragonInventory inventory = new DragonInventory(this);

    protected TameableDragonEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public void setArmor(ItemStack stack, boolean sync) {}

    public void setChest(ItemStack stack, boolean sync) {}

    public void setSaddle(ItemStack stack, boolean sync) {}

    public boolean hasChest() {return false;}

    public ItemStack getArmorStack() {return ItemStack.EMPTY;}

    public ItemStack getChestStack() {return ItemStack.EMPTY;}

    public ItemStack getSaddleStack() {return ItemStack.EMPTY;}

    public void inventoryChanged() {}
}
