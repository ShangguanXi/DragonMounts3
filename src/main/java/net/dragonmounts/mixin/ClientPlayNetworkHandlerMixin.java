package net.dragonmounts.mixin;

import net.dragonmounts.capability.ArmorEffectManager;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin implements ClientPlayPacketListener {
    @Inject(method = "onPlayerRespawn", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/network/ClientPlayerEntity;setEntityId(I)V"
    ), locals = LocalCapture.CAPTURE_FAILHARD)
    public void onPlayerClone(PlayerRespawnS2CPacket $, CallbackInfo info, RegistryKey<World> __, DimensionType _$, ClientPlayerEntity priorPlayer, int $_, String $$, ClientPlayerEntity player) {
        ArmorEffectManager.onPlayerClone(player, priorPlayer);
    }
}
