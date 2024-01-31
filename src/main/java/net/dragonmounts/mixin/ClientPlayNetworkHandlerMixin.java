package net.dragonmounts.mixin;

import net.dragonmounts.capability.ArmorEffectManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.stat.StatHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin implements ClientPlayPacketListener {
    @Shadow
    private MinecraftClient client;

    @Redirect(method = "onPlayerRespawn", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;createPlayer(Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/stat/StatHandler;Lnet/minecraft/client/recipebook/ClientRecipeBook;ZZ)Lnet/minecraft/client/network/ClientPlayerEntity;"
    ))
    public ClientPlayerEntity onPlayerClone(ClientPlayerInteractionManager instance, ClientWorld world, StatHandler statHandler, ClientRecipeBook recipeBook, boolean lastSneaking, boolean lastSprinting) {
        ClientPlayerEntity priorPlayer = this.client.player;
        //noinspection DataFlowIssue
        ClientPlayerEntity player = this.client.interactionManager.createPlayer(world, priorPlayer.getStatHandler(), priorPlayer.getRecipeBook(), priorPlayer.isSneaking(), priorPlayer.isSprinting());
        ArmorEffectManager.onPlayerClone(player, priorPlayer, true);
        return player;
    }
}
