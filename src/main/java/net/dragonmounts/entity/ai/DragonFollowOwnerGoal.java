package net.dragonmounts.entity.ai;

import net.dragonmounts.entity.dragon.ServerDragonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.EntityNavigation;

import java.util.EnumSet;

public class DragonFollowOwnerGoal extends AbstractDragonGoal {
    public static final double START_DISTANCE_SQUARE = 400D;//20
    public static final double STOP_DISTANCE_SQUARE = 64D;//8
    private LivingEntity owner;
    private int pathTicks;
    private EntityNavigation navigator;

    public DragonFollowOwnerGoal(ServerDragonEntity dragon) {
        super(dragon);
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        return !(this.dragon.isSitting() || this.dragon.isLeashed() || this.dragon.hasVehicle() || (this.owner = this.dragon.getOwner()) == null || this.owner.isSpectator() || this.dragon.squaredDistanceTo(this.owner) < START_DISTANCE_SQUARE);
    }

    @Override
    public boolean shouldContinue() {
        return !(this.dragon.isSitting() || this.dragon.isLeashed() || this.dragon.hasVehicle() || (this.navigator = this.dragon.getNavigation()).isIdle() || this.dragon.squaredDistanceTo(this.owner) <= STOP_DISTANCE_SQUARE);
    }

    @Override
    public void start() {
        this.navigator = this.dragon.getNavigation();
        this.pathTicks = 0;
    }

    @Override
    public void stop() {
        this.owner = null;
        this.dragon.getNavigation().stop();
    }

    @Override
    public void tick() {
        this.dragon.getLookControl().lookAt(this.owner, 10F, (float) this.dragon.getBodyYawSpeed());
        if (++this.pathTicks > 0) {
            this.pathTicks = -10;
            this.navigator.startMovingTo(this.owner, 1D);
        }
    }
}
