package net.dragonmounts.api;

import net.dragonmounts.capability.IArmorEffectManager;
import net.minecraft.entity.player.PlayerEntity;

@FunctionalInterface
public interface IArmorEffect {
    boolean activate(IArmorEffectManager manager, PlayerEntity player, int level);
}
