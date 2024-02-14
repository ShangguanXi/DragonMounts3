package net.dragonmounts.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlockUtil {
    public static boolean isAir(BlockState state) {
        return state.getMaterial() == Material.AIR;
    }

    public static boolean isSolid(BlockView world, BlockPos pos) {
        return world.getBlockState(pos).getMaterial().isSolid();
    }
}
