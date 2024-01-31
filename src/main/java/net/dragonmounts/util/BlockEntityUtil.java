package net.dragonmounts.util;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;

public class BlockEntityUtil {
    public static Inventory getInventory(PlayerEntity player, PacketByteBuf extraData, int size) {
        if (extraData != null) {
            BlockEntity blockEntity = player.world.getBlockEntity(extraData.readBlockPos());
            if (blockEntity instanceof Inventory) {
                return (Inventory) blockEntity;
            }
        }
        return new SimpleInventory(size);
    }
}
