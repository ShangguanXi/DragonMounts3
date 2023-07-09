package net.dragonmounts.entities;

import net.dragonmounts.client.renders.aetherDragon.AetherDragonEntityRenderer;
import net.dragonmounts.client.renders.enchantDragon.EnchantDragonEntityRenderer;
import net.dragonmounts.client.renders.enderDragon.EnderDragonEntityRenderer;
import net.dragonmounts.client.renders.fireDragon.FireDragonEntityRenderer;
import net.dragonmounts.client.renders.forestDragon.ForestDragonEntityRenderer;
import net.dragonmounts.client.renders.iceDragon.IceDragonEntityRenderer;
import net.dragonmounts.client.renders.moonlightDragon.MoonlightDragonEntityRenderer;
import net.dragonmounts.client.renders.netherDragon.NetherDragonEntityRenderer;
import net.dragonmounts.client.renders.skeletonDragon.SkeletonDragonEntityRenderer;
import net.dragonmounts.client.renders.stormDragon.StormDragonEntityRenderer;
import net.dragonmounts.client.renders.sunlightDragon.SunlightDragonEntityRenderer;
import net.dragonmounts.client.renders.terraDragon.TerraDragonEntityRenderer;
import net.dragonmounts.client.renders.waterDragon.WaterDragonEntityRenderer;
import net.dragonmounts.client.renders.witherDragon.WitherDragonEntityRenderer;
import net.dragonmounts.client.renders.zombieDragon.ZombieDragonEntityRenderer;
import net.dragonmounts.entities.dragons.*;
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
    public static final EntityType<EnderDragonEntity> EnderDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "ender_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, EnderDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<FireDragonEntity> FireDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "fire_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<ForestDragonEntity> ForestDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "forest_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ForestDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<IceDragonEntity> IceDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "ice_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, IceDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<MoonlightDragonEntity> MoonDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "moonlight_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, MoonlightDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<NetherDragonEntity> NetherDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "nether_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, NetherDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<SkeletonDragonEntity> SkeletonDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "skeleton_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, SkeletonDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<StormDragonEntity> StormDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "storm_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, StormDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<SunlightDragonEntity> SunlightDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "sunlight_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, SunlightDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<TerraDragonEntity> TerraDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "terra_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, TerraDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<WaterDragonEntity> WaterDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "water_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, WaterDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<WitherDragonEntity> WitherDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "wither_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, WitherDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static final EntityType<ZombieDragonEntity> ZombieDragon =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier("dragonmounts", "zombie_dragon"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ZombieDragonEntity::new)
                            .dimensions(EntityDimensions.fixed(0.875F, 0.875F))
                            .build());
    public static void registerEntityRenderer() {
        EntityRendererRegistry.INSTANCE.register(AetherDragon, (dispatcher, context) ->
                new AetherDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EnchantDragon, (d, c) -> new EnchantDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(EnderDragon, (d, c) -> new EnderDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(FireDragon, (d, c) -> new FireDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(ForestDragon, (d, c) -> new ForestDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(IceDragon, (d, c) -> new IceDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(MoonDragon, (d, c) -> new MoonlightDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(NetherDragon, (d, c) -> new NetherDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(SkeletonDragon, (d, c) -> new SkeletonDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(StormDragon, (d, c) -> new StormDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(SunlightDragon, (d, c) -> new SunlightDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(TerraDragon, (d, c) -> new TerraDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(WaterDragon, (d, c) -> new WaterDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(WitherDragon, (d, c) -> new WitherDragonEntityRenderer(d));
        EntityRendererRegistry.INSTANCE.register(ZombieDragon, (d, c) -> new ZombieDragonEntityRenderer(d));
    }
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AetherDragon, AetherDragonEntity.createAetherDragonAttributes());
        FabricDefaultAttributeRegistry.register(EnchantDragon, EnchantDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(EnderDragon, EnderDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(FireDragon, FireDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(ForestDragon, ForestDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(IceDragon, IceDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(MoonDragon, MoonlightDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(NetherDragon, NetherDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(SkeletonDragon, SkeletonDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(StormDragon, StormDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(SunlightDragon, SunlightDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(TerraDragon, TerraDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(WaterDragon, WaterDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(WitherDragon, WitherDragonEntity.createEnchantDragonAttributes());
        FabricDefaultAttributeRegistry.register(ZombieDragon, ZombieDragonEntity.createEnchantDragonAttributes());
    }
}
