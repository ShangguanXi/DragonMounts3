package net.dragonmounts.api;

import net.dragonmounts.capability.IArmorEffectManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface IArmorEffectSource {
    void affect(IArmorEffectManager manager, PlayerEntity player, ItemStack stack);
}
