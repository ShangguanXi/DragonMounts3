package net.dragonmounts.item;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

/**
 * @see net.minecraft.item.ToolItem
 */
public class TieredShearsItem extends ShearsItem {
    protected final ToolMaterial tier;
    private final float speedFactor;

    public TieredShearsItem(ToolMaterial tier, Settings settings) {
        super(settings.maxDamageIfAbsent((int) (tier.getDurability() * 0.952F)));
        this.tier = tier;
        this.speedFactor = tier.getMiningSpeedMultiplier() / ToolMaterials.IRON.getMiningSpeedMultiplier();
    }

    public ToolMaterial getTier() {
        return this.tier;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (player.world.isClient) return super.useOnEntity(stack, player, entity, hand);
        if (entity instanceof TameableDragonEntity) {
            /*TameableDragonEntity dragon = (TameableDragonEntity) entity;
            BlockPos pos = dragon.getBlockPos();
            if (dragon.isShearable(stack, dragon.world, pos)) {
                if (dragon.isOwnedBy(player)) {
                    List<ItemStack> drops = dragon.onSheared(player, stack, dragon.world, pos, EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack));
                    Random random = dragon.getRandom();
                    boolean flag = false;
                    for (ItemStack drop : drops) {
                        ItemEntity item = entity.spawnAtLocation(drop, 1.0F);
                        if (item != null) {
                            flag = true;
                            item.setDeltaMovement(item.getDeltaMovement().add((random.nextFloat() - random.nextFloat()) * 0.1D, random.nextFloat() * 0.05D, (random.nextFloat() - random.nextFloat()) * 0.1D));
                        }
                    }
                    if (flag) {
                        stack.hurtAndBreak(20, dragon, e -> e.broadcastBreakEvent(hand));
                        return ActionResultType.SUCCESS;
                    }
                } else player.displayClientMessage(new TranslatableText("message.dragonmounts.not_owner"), true);
                return ActionResultType.FAIL;
            }*/
            return ActionResult.PASS;
        }
        return super.useOnEntity(stack, player, entity, hand);
    }

    @Override
    public int getEnchantability() {
        return this.tier.getEnchantability();
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return this.tier.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        float speed = super.getMiningSpeedMultiplier(stack, state);
        return speed > 1.0F ? speed * this.speedFactor : speed;
    }
}
