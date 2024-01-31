package net.dragonmounts.api;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;

@FunctionalInterface
public interface IDragonFood {
    void eat(TameableDragonEntity dragon, PlayerEntity player, ItemStack stack, Hand hand);

    default boolean isEatable(TameableDragonEntity dragon, PlayerEntity player, ItemStack stack, Hand hand) {
        return true;
    }

    default void act(TameableDragonEntity dragon, Item item) {
        if (item == Items.AIR) return;
        /*World world = dragon.world;
        if (dragon.getLifeStage() != DragonLifeStage.ADULT) {
            dragon.refreshForcedAgeTimer();
        }
        //noinspection DataFlowIssue
        Vector3d pos = dragon.animator.getThroatPosition(0, 0, -4);
        if (pos == null) return;
        level.playLocalSound(pos.x, pos.y, pos.z, item.getEatingSound(), SoundCategory.NEUTRAL, 1F, 0.75F, false);
        if (item == Items.HONEY_BOTTLE) return;
        if (item instanceof BucketItem) {
            level.playLocalSound(pos.x, pos.y, pos.z, item.getDrinkingSound(), SoundCategory.NEUTRAL, 0.25F, 0.75F, false);
            if (item == Items.COD_BUCKET) {
                item = Items.COD;
            } else if (item == Items.SALMON_BUCKET) {
                item = Items.SALMON;
            } else {
                item = Items.TROPICAL_FISH;
            }
        }
        ItemStack stack = new ItemStack(item);
        Random random = dragon.getRandom();
        for (int i = 0; i < 8; ++i) {
            Vector3d speed = new Vector3d((random.nextFloat() - 0.5D) * 0.1D, random.nextFloat() * 0.1D + 0.1D, 0.0D).xRot(-dragon.xRot * MathUtil.PI / 180F).yRot(-dragon.yRot * MathUtil.PI / 180F);
            level.addParticle(new ItemParticleData(ParticleTypes.ITEM, stack), pos.x, pos.y, pos.z, speed.x, speed.y + 0.05D, speed.z);
        }*/
    }
}
