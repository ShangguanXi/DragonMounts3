package net.dragonmounts.entity.ai;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class DragonMovementController extends MoveControl {
    public final TameableDragonEntity dragon;

    public DragonMovementController(TameableDragonEntity dragon) {
        super(dragon);
        this.dragon = dragon;
        this.speed = 0.9D;
    }

    @Override
    public void tick() {
        // original movement behavior if the entity isn't flying
        if (this.dragon.isFlying()) {
            Vec3d current = dragon.getPos();
            Vec3d movePos = new Vec3d(this.targetX, this.targetY, this.targetZ);
            boolean uncontrolled = !(this.dragon.getPrimaryPassenger() instanceof PlayerEntity);
            // get direction vector by subtracting the current position from the
            // target position and normalizing the result
            Vec3d direction = movePos.subtract(current).normalize();
            // get euclidean distance to target
            double distance = current.distanceTo(movePos);
            // move towards target if it's far away enough   dragon.width
            if (distance > this.dragon.getWidth()) {
                double speed = this.dragon.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED) * (this.dragon.isSprinting() ? 4 : 1);
                // update velocity to approach target
                this.dragon.setVelocity(direction.multiply(speed, speed, speed));
            } else if (uncontrolled) {
                // just slow down and hover at current location
                this.dragon.setVelocity(direction
                        .multiply(0.8, 0.8, 0.8)
                        .add(0, Math.sin(dragon.age / 5.0) * 0.03, 0)
                );
            }
            // face entity towards target
            if (distance > 2.5E-7) {
                float newYaw = (float) Math.toDegrees(Math.PI * 2 - Math.atan2(direction.x, direction.z));
                this.dragon.yaw = wrapDegrees(this.dragon.yaw, newYaw, uncontrolled ? 15 : 5);
                this.dragon.setMovementSpeed((float) (this.speed * dragon.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
            }
            // apply movement
            this.dragon.move(MovementType.SELF, this.dragon.getVelocity());
        } else {
            super.tick();
        }
    }
}
