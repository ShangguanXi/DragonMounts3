package net.dragonmounts.entities;

import net.dragonmounts.client.renders.AetherDragonEggEntityRenderer;
import net.dragonmounts.client.renders.AetherDragonEntityRenderer;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Dragons {
    public static final EntityType<AetherDragonEntity> AetherDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "aether_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, AetherDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static void registerEntityRenderer() {
        EntityRendererRegistry.INSTANCE.register(AetherDragon, (dispatcher, context) ->
                new AetherDragonEntityRenderer(dispatcher));
    }
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AetherDragon, AetherDragonEntity.createAetherDragonAttributes());
    }
}
