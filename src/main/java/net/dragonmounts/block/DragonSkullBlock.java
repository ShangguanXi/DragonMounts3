package net.dragonmounts.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DragonSkullBlock extends AbstractDragonSkullBlock {
    public static final IntProperty ROTATION;
    protected static final VoxelShape SHAPE;

    public DragonSkullBlock(SkullType skullType, AbstractBlock.Settings settings) {
        super(skullType, settings);
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(ROTATION, 0));
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(ROTATION, MathHelper.floor((double) (ctx.getPlayerYaw() * 16.0F / 360.0F) + 0.5) & 15);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(ROTATION, rotation.rotate((Integer) state.get(ROTATION), 16));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return (BlockState) state.with(ROTATION, mirror.mirror((Integer) state.get(ROTATION), 16));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ROTATION});
    }

    static {
        ROTATION = Properties.ROTATION;
        SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
    }

    public static enum Type implements DragonSkullBlock.SkullType {
        SKELETON,
        WITHER_SKELETON,
        PLAYER,
        ZOMBIE,
        CREEPER,
        DRAGON;

        private Type() {
        }
    }

    public interface SkullType {
    }
}
