package net.dragonmounts.mixin;

import net.dragonmounts.capability.ArmorEffectManager;
import net.dragonmounts.capability.IArmorEffectManagerProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.dragonmounts.capability.ArmorEffectManager.DATA_PARAMETER_KEY;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements IArmorEffectManagerProvider {
    @Unique
    protected ArmorEffectManager manager = new ArmorEffectManager((PlayerEntity) (Object) this);

    @Inject(method = "tick", at = @At("HEAD"))
    public void tickManager(CallbackInfo ci) {
        this.manager.tick();
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void saveCooldown(NbtCompound nbt, CallbackInfo ci) {
        NbtCompound data = this.manager.saveNBT();
        if (data.isEmpty()) return;
        NbtCompound caps = nbt.getCompound("ForgeCaps");
        caps.put(DATA_PARAMETER_KEY, data);
        nbt.put("ForgeCaps", caps);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCooldown(NbtCompound nbt, CallbackInfo ci) {
        this.manager.readNBT(nbt.getCompound("ForgeCaps").getCompound(DATA_PARAMETER_KEY));
    }

    @Override
    public ArmorEffectManager dragonMounts3_Fabric$getArmorEffectManager() {
        return this.manager;
    }
}
