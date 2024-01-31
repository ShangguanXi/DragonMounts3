package net.dragonmounts.mixin;

import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.minecraft.entity.Entity;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
    @Redirect(method = "unloadEntity", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/scoreboard/ServerScoreboard;resetEntityScore(Lnet/minecraft/entity/Entity;)V"
    ))
    public void tryKeepScores(ServerScoreboard scoreboard, Entity entity) {
        if (!(entity instanceof HatchableDragonEggEntity && ((HatchableDragonEggEntity) entity).isHatched()))
            scoreboard.resetEntityScore(entity);
    }
}
