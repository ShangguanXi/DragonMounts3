package net.dragonmounts.block;

import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.dragonmounts.registry.DragonType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.dragonmounts.DragonMounts.BLOCK_TRANSLATION_KEY_PREFIX;

public class HatchableDragonEggBlock extends DragonEggBlock implements IDragonTypified {
    public static ActionResult spawn(World world, BlockPos pos, DragonType type) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        HatchableDragonEggEntity entity = new HatchableDragonEggEntity(world);
        entity.setDragonType(type, true);
        entity.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        world.spawnEntity(entity);
        return ActionResult.CONSUME;
    }

    private static final String TRANSLATION_KEY = BLOCK_TRANSLATION_KEY_PREFIX + "dragon_egg";
    protected DragonType type;

    public HatchableDragonEggBlock(DragonType type, Settings settings) {
        super(settings);
        this.type = type;
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (world.getRegistryKey().equals(World.END)) super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    @SuppressWarnings("deprecation")
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        if (player.world.getRegistryKey().equals(World.END)) return 0.0F;
        return super.calcBlockBreakingDelta(state, player, world, pos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        if (world.getRegistryKey().equals(World.END)) return super.onUse(state, world, pos, player, hand, hit);
        return spawn(world, pos, this.type);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(this.type.getName());
    }

    @Override
    public String getTranslationKey() {
        return TRANSLATION_KEY;
    }

    @Override
    public DragonType getDragonType() {
        return this.type;
    }
}
