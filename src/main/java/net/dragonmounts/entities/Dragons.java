package net.dragonmounts.entities;

import net.dragonmounts.client.renders.aetherDragon.AetherDragonEntityRenderer;
import net.dragonmounts.client.renders.enchantDragon.EnchantDragonEntityRenderer;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.EnchantDragonEntity;
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
    public static final EntityType<EnchantDragonEntity> EnchantDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "enchant_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, EnchantDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static void registerEntityRenderer() {
        EntityRendererRegistry.INSTANCE.register(AetherDragon, (dispatcher, context) ->
                new AetherDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EnchantDragon, (dis, context) -> new EnchantDragonEntityRenderer(dis));
    }
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AetherDragon, AetherDragonEntity.createAetherDragonAttributes());
        FabricDefaultAttributeRegistry.register(EnchantDragon, EnchantDragonEntity.createEnchantDragonAttributes());
    }
}
