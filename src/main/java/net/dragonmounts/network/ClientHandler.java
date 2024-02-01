package net.dragonmounts.network;

import net.dragonmounts.capability.ArmorEffectManager;
import net.dragonmounts.capability.IArmorEffectManager.Provider;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.dragonmounts.registry.CooldownCategory;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class ClientHandler {
    public static void handleArmorRiposte(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        int id = buffer.readVarInt(), flag = buffer.readVarInt();
        client.execute(() -> {
            World world = client.world;
            if (world == null) return;
            Entity entity = world.getEntityById(id);
            if (entity == null) return;
            final double x = entity.getX();
            final double z = entity.getZ();
            if ((flag & 0b01) == 0b01) {
                final double y = entity.getY() + 0.1;
                for (int i = -30; i < 31; ++i)
                    world.addParticle(ParticleTypes.CLOUD, false, x, y, z, Math.sin(i), 0, Math.cos(i));
                world.playSound(client.player, entity.getBlockPos(), SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.PLAYERS, 0.46F, 1.0F);
            }
            if ((flag & 0b10) == 0b10) {
                final double y = entity.getY() + 1;
                for (int i = -27; i < 28; ++i)
                    world.addParticle(ParticleTypes.FLAME, x, y, z, Math.sin(i) / 3, 0, Math.cos(i) / 3);
                world.playSound(client.player, entity.getBlockPos(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 0.46F, 1.0F);
            }
        });
    }

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
            ((Provider) client.player).dragonMounts3_Fabric$getManager().setCooldown(category, cd);
        });
    }

    public static void handleEggShake(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        int id = buffer.readVarInt();
        float axis = buffer.readFloat();
        int amplitude = buffer.readVarInt();
        boolean particle = buffer.readBoolean();
        client.execute(() -> {
            if (client.world == null) return;
            Entity entity = client.world.getEntityById(id);
            if (entity instanceof HatchableDragonEggEntity)
                ((HatchableDragonEggEntity) entity).applyPacket(axis, amplitude, particle);
        });
    }
}
