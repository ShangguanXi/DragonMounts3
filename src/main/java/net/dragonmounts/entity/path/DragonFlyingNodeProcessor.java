package net.dragonmounts.entity.path;

import net.dragonmounts.util.BlockUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;

/**
 * Based on {@link WaterPathNodeMaker} but for air blocks.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonFlyingNodeProcessor extends PathNodeMaker {
    @Override
    public PathNode getStart() {
        return super.getNode(MathHelper.floor(this.entity.getBoundingBox().minX), MathHelper.floor(this.entity.getBoundingBox().minY + 0.5D), MathHelper.floor(this.entity.getBoundingBox().minZ));
    }

    @Override
    public TargetPathNode getNode(double x, double y, double z) {
        return new TargetPathNode(super.getNode(MathHelper.floor(x - this.entity.getWidth() / 2.0F), MathHelper.floor(y + 0.5D), MathHelper.floor(z - this.entity.getWidth() / 2.0F)));
    }

    @Override
    public int getSuccessors(PathNode[] options, PathNode point) {
        int i = 0;
        for (Direction direction : Direction.values()) {
            PathNode target = this.getAirNode(point.x + direction.getOffsetX(), point.y + direction.getOffsetY(), point.z + direction.getOffsetZ());
            if (target != null && !target.visited) {
                options[i++] = point;
            }
        }
        return i;
    }

    @Override
    public PathNodeType getNodeType(BlockView world, int x, int y, int z, MobEntity entity, int sizeX, int sizeY, int sizeZ, boolean canBreakDoors, boolean canEnterDoors) {
        return this.getDefaultNodeType(world, x, y, z);
    }

    /**
     * Returns the node type at the specified position taking the block below into account
     */
    @Override
    public PathNodeType getDefaultNodeType(BlockView world, int x, int y, int z) {
        return BlockUtil.isAir(world.getBlockState(new BlockPos(x, y, z))) ? PathNodeType.OPEN : PathNodeType.BLOCKED;
    }

    /**
     * Returns a point that the entity can move to
     */
    protected PathNode getAirNode(int x, int y, int z) {
        BlockPos.Mutable pos = new BlockPos.Mutable(x, y, z);
        for (int i = x; i < x + this.entityBlockXSize; ++i) {
            for (int j = y; j < y + this.entityBlockYSize; ++j) {
                for (int k = z; k < z + this.entityBlockZSize; ++k) {
                    BlockState state = this.cachedWorld.getBlockState(pos.set(i, j, k));
                    if (!BlockUtil.isAir(state)) {
                        return null;
                    }
                }
            }
        }
        return this.getAvailableNode(x, y, z);
    }

    protected PathNode getAvailableNode(int x, int y, int z) {
        PathNodeType type = this.getDefaultNodeType(this.cachedWorld, x, y, z);
        float f = this.entity.getPathfindingPenalty(type);
        if (f >= 0.0F) {
            PathNode point = this.getNode(x, y, z);
            point.type = type;
            point.penalty = Math.max(point.penalty, f);
            if (type == PathNodeType.WALKABLE) {
                ++point.penalty;
            }
            return point;
        }
        return null;
    }
}
