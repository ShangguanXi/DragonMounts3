package net.dragonmounts.network;

import net.dragonmounts.capability.ArmorEffectManager;
import net.dragonmounts.capability.IArmorEffectManagerProvider;
import net.dragonmounts.registry.CooldownCategory;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class ClientHandler {
    public static void handleCooldownInit(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        int size = buffer.readVarInt();
        int[] data = new int[size];
        for (int i = 0; i < size; ++i)
            data[i] = buffer.readVarInt();
        client.execute(() -> ArmorEffectManager.init(data));
    }

    public static void handleCooldownSync(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        int id = buffer.readVarInt(), cd = buffer.readVarInt();
        client.execute(() -> {
            CooldownCategory category = CooldownCategory.REGISTRY.get(id);
            if (category == null) return;
            //noinspection DataFlowIssue
            ((IArmorEffectManagerProvider) client.player).dragonMounts3_Fabric$getArmorEffectManager().setCooldown(category, cd);
        });
    }
}
