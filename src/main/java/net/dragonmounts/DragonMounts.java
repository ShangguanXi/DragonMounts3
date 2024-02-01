package net.dragonmounts;

import net.dragonmounts.capability.ArmorEffectManager;
import net.dragonmounts.init.DMArmorEffects;
import net.dragonmounts.init.DMBlocks;
import net.dragonmounts.init.DMEntities;
import net.dragonmounts.init.DMItems;
import net.dragonmounts.registry.CarriageType;
import net.dragonmounts.registry.DragonType;
import net.dragonmounts.registry.DragonVariant;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;

public class DragonMounts implements ModInitializer {
    public static final String MOD_ID = "dragonmounts";
    public static final String ITEM_TRANSLATION_KEY_PREFIX = "item." + MOD_ID + '.';
    public static final String BLOCK_TRANSLATION_KEY_PREFIX = "block." + MOD_ID + '.';

    public void onInitialize() {
        DMEntities.init();
        DMItems.init();
        DMBlocks.init();
        TrackedDataHandlerRegistry.register(CarriageType.SERIALIZER);
        TrackedDataHandlerRegistry.register(DragonType.SERIALIZER);
        TrackedDataHandlerRegistry.register(DragonVariant.SERIALIZER);
        ServerPlayerEvents.COPY_FROM.register(ArmorEffectManager::onPlayerClone);
        AttackEntityCallback.EVENT.register(DMArmorEffects::meleeChanneling);
    }
}
