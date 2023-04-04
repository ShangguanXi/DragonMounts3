package net.dragonmounts.entities;

import net.dragonmounts.DragonMounts3Main;
import net.dragonmounts.client.renders.AetherDragonEggEntityRenderer;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
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
    public static void registerEntityRenderer() {
        EntityRendererRegistry.INSTANCE.register(AetherDragonEgg, (dispatcher, context) ->
                new AetherDragonEggEntityRenderer(dispatcher));
    }
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AetherDragonEgg, AetherDragonEggEntity.createAetherDragonEggAttributes());
    }

}
