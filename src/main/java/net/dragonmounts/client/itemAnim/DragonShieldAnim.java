package net.dragonmounts.client.itemAnim;

import net.dragonmounts.items.DragonShieldItems;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class DragonShieldAnim {
    public static void register() {
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_aether, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_enchant, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_ender, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_fire, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_forest, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_ice, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_moonlight, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_nether, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_sculk, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_storm, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_sunlight, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_terra, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_water, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry. register(DragonShieldItems.dragon_shield_zombie, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
    }
}
