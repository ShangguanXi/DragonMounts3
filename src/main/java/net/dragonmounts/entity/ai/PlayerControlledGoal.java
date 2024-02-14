package net.dragonmounts.entity.ai;

import net.dragonmounts.entity.dragon.ServerDragonEntity;
import net.dragonmounts.init.DragonTypes;
import net.dragonmounts.util.EntityUtil;
import net.dragonmounts.util.math.MathUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class PlayerControlledGoal extends AbstractDragonGoal {
    protected PlayerEntity controller;
    protected boolean climbing;
    protected boolean descending;
    protected boolean convergePitch;
    protected boolean convergeYaw;

    public PlayerControlledGoal(ServerDragonEntity dragon) {
        super(dragon);
    }

    public final void handlePacket(boolean climbing, boolean descending, boolean convergePitch, boolean convergeYaw) {
        this.climbing = climbing;
        this.descending = descending;
        this.convergePitch = convergePitch;
        this.convergeYaw = convergeYaw;
    }

    @Override
    public boolean canStop() {
        return false;
    }

    @Override
    public boolean canStart() {
        Entity entity = this.dragon.getPrimaryPassenger();
        if (entity instanceof PlayerEntity) {
            this.controller = (PlayerEntity) entity;
            return true;
        }
        this.controller = null;
        return false;
    }

    @Override
    public void start() {
        this.dragon.setSitting(false);
        this.dragon.getNavigation().stop();
    }

    @Override
    public void tick() {
        if (this.dragon.getDragonType() == DragonTypes.WATER && this.controller.isInsideWaterOrBubbleColumn()) {
            EntityUtil.addOrResetEffect(this.controller, StatusEffects.WATER_BREATHING, 200, 0, true, true, true, 21);
        }
        Vec3d view = this.controller.getRotationVec(1.0F);
        double x = dragon.getX();
        double y = dragon.getY();
        double z = dragon.getZ();
        // if we're breathing at a target, look at it
        /*if ((dragon.isUsingBreathWeapon() && dragon.getBreed().canUseBreathWeapon())) {
            Vec3d dragonEyePos = dragon.getPositionVector().add(0, dragon.getEyeHeight(), 0);
            Vec3d lookDirection = rider.getLook(1.0F);
            Vec3d endOfLook = dragonEyePos.add(lookDirection.x, lookDirection.y, lookDirection.z);
            dragon.getLookHelper().setLookPosition(endOfLook.x, endOfLook.y, endOfLook.z,
                    90, 120);
            dragon.updateIntendedRideRotation(rider);
        }*/
        if (this.convergeYaw && this.dragon.sidewaysSpeed == 0) {
            if (this.controller.forwardSpeed == 0) {
                this.dragon.prevYaw = this.dragon.bodyYaw = this.dragon.yaw = this.controller.yaw;
                this.dragon.pitch = this.controller.pitch;
            }
        }
        // control direction with movement keys
        if (this.controller.sidewaysSpeed != 0 || this.controller.forwardSpeed != 0) {
            if (this.controller.forwardSpeed < 0) {
                view = view.rotateY(MathUtil.PI);
            } else if (this.controller.sidewaysSpeed > 0) {
                view = view.rotateY(MathUtil.PI * 0.5F);
            } else if (this.controller.sidewaysSpeed < 0) {
                view = view.rotateY(MathUtil.PI * -0.5F);
            }
            x += view.x * 10;
            if (this.convergePitch) y += view.y * 10;
            z += view.z * 10;
        }
        //lift off from a jump
        if (this.dragon.isFlying()) {
            y += (this.climbing ? 10 : 0) + (this.descending ? 0 : -10);
        } else if (this.climbing) {
            this.dragon.liftOff();
        }
        this.dragon.getMoveControl().moveTo(x, y, z, 1.2);
    }
}
