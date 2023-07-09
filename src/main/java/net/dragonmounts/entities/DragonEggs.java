package net.dragonmounts.entities;

import net.dragonmounts.client.renders.aetherDragon.AetherDragonEggEntityRenderer;
import net.dragonmounts.client.renders.enchantDragon.EnchantDragonEggEntityRenderer;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.dragonmounts.entities.dragonEggs.EnchantDragonEggEntity;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonEggs {
    public static final EntityType<AetherDragonEggEntity> AetherDragonEgg =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "aether_dragon_egg"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, AetherDragonEggEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<EnchantDragonEggEntity> EnchantDragonEgg =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "enchant_dragon_egg"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, EnchantDragonEggEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static void registerEntityRenderer() {
        EntityRendererRegistry.INSTANCE.register(AetherDragonEgg, (dispatcher, context) ->
                new AetherDragonEggEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EnchantDragonEgg, (dis, context) ->
                new EnchantDragonEggEntityRenderer(dis));
    }
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AetherDragonEgg, AetherDragonEggEntity.createAetherDragonEggAttributes());
        FabricDefaultAttributeRegistry.register(EnchantDragonEgg, EnchantDragonEggEntity.createAetherDragonEggAttributes());
    }

}
