package net.dragonmounts.entity.ai;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.util.math.MathHelper;

public class DragonBodyController extends BodyControl {
    public static final int MAX_TICKS = 20;
    protected final TameableDragonEntity dragon;
    protected float lastYHeadRot;
    protected int ticks;

    public DragonBodyController(TameableDragonEntity dragon) {
        super(dragon);
        this.dragon = dragon;
    }

    @Override
    public void tick() {
        double deltaX = this.dragon.getX() - this.dragon.prevX;
        double deltaZ = this.dragon.getZ() - this.dragon.prevZ;
        double distance = deltaX * deltaX + deltaZ * deltaZ;
        float maxDifference = 90.0F;
        // rotate instantly if flying, sitting or moving
        if (this.dragon.isFlying() || this.dragon.isInSittingPose() || distance > 0.0001) {
            this.dragon.bodyYaw = this.dragon.yaw;
            this.dragon.headYaw = MathHelper.stepUnwrappedAngleTowards(this.dragon.bodyYaw, this.dragon.headYaw, maxDifference);
            this.lastYHeadRot = this.dragon.headYaw;
            this.ticks = 0;
            return;
        }

        double changeInHeadYaw = Math.abs(this.dragon.headYaw - this.lastYHeadRot);
        if (changeInHeadYaw > 15) {
            this.ticks = 0;
            this.lastYHeadRot = this.dragon.headYaw;
        } else {
            if (++this.ticks > MAX_TICKS) {
                maxDifference = Math.max(1 - (float) (this.ticks - MAX_TICKS) / MAX_TICKS, 0) * 75;
            }
        }
        this.dragon.bodyYaw = MathHelper.stepAngleTowards(this.dragon.bodyYaw, this.dragon.headYaw, maxDifference);
        this.dragon.yaw = this.dragon.bodyYaw;
    }
}
