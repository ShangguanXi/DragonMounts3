package net.dragonmounts.util;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;

public class BlockEntityUtil {
    public static Inventory getInventory(PlayerEntity player, PacketByteBuf buffer, int size) {
        if (buffer != null) {
            BlockEntity entity = player.world.getBlockEntity(buffer.readBlockPos());
            if (entity instanceof Inventory) return (Inventory) entity;
        }
        return new SimpleInventory(size);
    }
}
