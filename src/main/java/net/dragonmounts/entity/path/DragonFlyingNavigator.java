package net.dragonmounts.entity.path;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.world.World;

/**
 * Based on {@link SwimNavigation} but for air blocks.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonFlyingNavigator extends SwimNavigation {
    public DragonFlyingNavigator(TameableDragonEntity dragon, World level) {
        super(dragon, level);
    }

    @Override
    protected PathNodeNavigator createPathNodeNavigator(int maxVisitedNodes) {
        return new PathNodeNavigator(new DragonFlyingNodeProcessor(), maxVisitedNodes);
    }

    @Override
    protected boolean isAtValidPosition() {
        return true;
    }
}
