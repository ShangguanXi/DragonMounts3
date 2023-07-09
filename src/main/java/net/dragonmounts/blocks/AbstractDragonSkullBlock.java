package net.dragonmounts.blocks;

import net.dragonmounts.client.blockEntities.DragonSkullEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.Wearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AbstractDragonSkullBlock extends BlockWithEntity implements Wearable {
    private final DragonSkullBlock.SkullType type;

    public AbstractDragonSkullBlock(DragonSkullBlock.SkullType type, AbstractBlock.Settings settings) {
        super(settings);
        this.type = type;
    }

    public BlockEntity createBlockEntity(BlockView world) {
        return new DragonSkullEntity();
    }

    @Environment(EnvType.CLIENT)
    public DragonSkullBlock.SkullType getSkullType() {
        return this.type;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
