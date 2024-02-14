package net.dragonmounts.mixin;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.dragonmounts.DragonMountsConfig.CLIENT;

@Mixin(Camera.class)
public abstract class CameraMixin {
    @Shadow
    protected abstract double clipToSpace(double desiredCameraDistance);

    @Shadow
    protected abstract void moveBy(double x, double y, double z);

    @Inject(method = "update", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/Camera;clipToSpace(D)D"
    ), cancellable = true)
    public void cameraOffset(BlockView area, Entity host, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo info) {
        Entity entity = host.getVehicle();
        if (entity instanceof TameableDragonEntity) {
            this.moveBy(-this.clipToSpace(CLIENT.camera_distance.get()), 0.0D, -CLIENT.camera_offset.get());
            info.cancel();
        }
    }
}
