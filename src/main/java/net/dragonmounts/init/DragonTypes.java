package net.dragonmounts.init;

import net.dragonmounts.registry.DragonType;
import net.minecraft.block.Blocks;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DragonTypes {
    public static final DragonType AETHER = new DragonType(
            new Identifier(MOD_ID, "aether"),
            new DragonType.Properties(0x0294BD)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.LAPIS_BLOCK)
                    .addHabitat(Blocks.LAPIS_ORE)
                    .setEnvironmentPredicate(egg -> egg.getY() >= egg.world.getHeight() * 0.625)
    );
    public static final DragonType ENCHANT = new DragonType(
            new Identifier(MOD_ID, "enchant"),
            new DragonType.Properties(0x8359AE)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.BOOKSHELF)
                    .addHabitat(Blocks.ENCHANTING_TABLE)
    );
    public static final DragonType ENDER = new DragonType(
            DragonType.DEFAULT_KEY,
            new DragonType.Properties(0xAB39BE)
                    .notConvertible()
                    .putAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "DragonTypeBonus", 10.0D, EntityAttributeModifier.Operation.ADDITION)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .setSneezeParticle(ParticleTypes.PORTAL)
                    .setEggParticle(ParticleTypes.PORTAL)
    );
    public static final DragonType FIRE = new DragonType(
            new Identifier(MOD_ID, "fire"),
            new DragonType.Properties(0x960B0F)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.FIRE)
                    //.addHabitat(Blocks.LIT_FURNACE)
                    .addHabitat(Blocks.LAVA)
            //.addHabitat(Blocks.FLOWING_LAVA)
    );
    public static final DragonType FOREST = new DragonType(
            new Identifier(MOD_ID, "forest"),
            new DragonType.Properties(0x298317)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    //.addHabitat(Blocks.YELLOW_FLOWER)
                    //.addHabitat(Blocks.RED_FLOWER)
                    .addHabitat(Blocks.MOSSY_COBBLESTONE)
                    .addHabitat(Blocks.VINE)
                    //.addHabitat(Blocks.SAPLING)
                    //.addHabitat(Blocks.LEAVES)
                    //.addHabitat(Blocks.LEAVES2)
                    .addHabitat(BiomeKeys.JUNGLE)
                    .addHabitat(BiomeKeys.JUNGLE_HILLS)
    );
    public static final DragonType ICE = new DragonType(
            new Identifier(MOD_ID, "ice"),
            new DragonType.Properties(0x00F2FF)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.SNOW)
                    .addHabitat(Blocks.ICE)
                    .addHabitat(Blocks.PACKED_ICE)
                    .addHabitat(Blocks.FROSTED_ICE)
                    .addHabitat(BiomeKeys.FROZEN_OCEAN)
                    .addHabitat(BiomeKeys.FROZEN_RIVER)
            //.addHabitat(BiomeKeys.JUNGLE)
            //.addHabitat(BiomeKeys.JUNGLE_HILLS)
    );
    public static final DragonType MOONLIGHT = new DragonType(
            new Identifier(MOD_ID, "moonlight"),
            new DragonType.Properties(0x2C427C)
                    .addHabitat(Blocks.BLUE_GLAZED_TERRACOTTA)
    );
    public static final DragonType NETHER = new DragonType(
            new Identifier(MOD_ID, "nether"),
            new DragonType.Properties(0xE5B81B)
                    .putAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "DragonTypeBonus", 5.0D, EntityAttributeModifier.Operation.ADDITION)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    //.addHabitat(BiomeKeys.HELL)
                    .setEggParticle(ParticleTypes.DRIPPING_LAVA)
    );
    public static final DragonType SCULK = new DragonType(
            new Identifier(MOD_ID, "sculk"),
            new DragonType.Properties(0x29DFEB)
                    .notConvertible()
                    .putAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "DragonTypeBonus", 10.0D, EntityAttributeModifier.Operation.ADDITION)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
    );
    public static final DragonType SKELETON = new DragonType(
            new Identifier(MOD_ID, "skeleton"),
            new DragonType.Properties(0xFFFFFF)
                    .isSkeleton()
                    .putAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "DragonTypeBonus", -15.0D, EntityAttributeModifier.Operation.ADDITION)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.BONE_BLOCK)
                    .setEnvironmentPredicate(egg -> egg.getY() <= egg.world.getHeight() * 0.25 || egg.world.getBaseLightLevel(egg.getBlockPos(), 0) < 4)
    );
    public static final DragonType STORM = new DragonType(new Identifier(MOD_ID, "storm"), new DragonType.Properties(0xF5F1E9));
    public static final DragonType SUNLIGHT = new DragonType(
            new Identifier(MOD_ID, "sunlight"),
            new DragonType.Properties(0xFFDE00)
                    .addHabitat(Blocks.GLOWSTONE)
                    .addHabitat(Blocks.JACK_O_LANTERN)
                    .addHabitat(Blocks.SHROOMLIGHT)
                    .addHabitat(Blocks.YELLOW_GLAZED_TERRACOTTA)
    );
    public static final DragonType TERRA = new DragonType(
            new Identifier(MOD_ID, "terra"),
            new DragonType.Properties(0xA56C21)
                    .addHabitat(Blocks.TERRACOTTA)
                    .addHabitat(Blocks.SAND)
                    .addHabitat(Blocks.SANDSTONE)
                    .addHabitat(Blocks.SANDSTONE_SLAB)
                    .addHabitat(Blocks.SANDSTONE_STAIRS)
                    .addHabitat(Blocks.SANDSTONE_WALL)
                    .addHabitat(Blocks.RED_SAND)
                    .addHabitat(Blocks.RED_SANDSTONE)
                    .addHabitat(Blocks.RED_SANDSTONE_SLAB)
                    .addHabitat(Blocks.RED_SANDSTONE_STAIRS)
                    .addHabitat(Blocks.RED_SANDSTONE_WALL)
            //.addHabitat(BiomeKeys.MESA)
            //.addHabitat(BiomeKeys.MESA_ROCK)
            //.addHabitat(BiomeKeys.MESA_CLEAR_ROCK)
            //.addHabitat(BiomeKeys.MUTATED_MESA_CLEAR_ROCK)
            //.addHabitat(BiomeKeys.MUTATED_MESA_ROCK)
    );
    public static final DragonType WATER = new DragonType(
            new Identifier(MOD_ID, "water"),
            new DragonType.Properties(0x4F69A8)
                    .addImmunity(DamageSource.DROWN)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.WATER)
                    .addHabitat(BiomeKeys.OCEAN)
                    .addHabitat(BiomeKeys.RIVER)
    );
    public static final DragonType WITHER = new DragonType(
            new Identifier(MOD_ID, "wither"),
            new DragonType.Properties(0x50260A)
                    .notConvertible()
                    .isSkeleton()
                    .putAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "DragonTypeBonus", -10.0D, EntityAttributeModifier.Operation.ADDITION)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
    );
    public static final DragonType ZOMBIE = new DragonType(
            new Identifier(MOD_ID, "zombie"),
            new DragonType.Properties(0x5A5602)
                    .addImmunity(DamageSource.MAGIC)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LIGHTNING_BOLT)
                    .addImmunity(DamageSource.WITHER)
                    .addHabitat(Blocks.SOUL_SAND)
                    .addHabitat(Blocks.SOUL_SAND)
                    .addHabitat(Blocks.NETHER_WART_BLOCK)
                    .addHabitat(Blocks.WARPED_WART_BLOCK)
    );
/*
    public static void register(RegistryEvent.Register<DragonType> event) {
        IForgeRegistry<DragonType> registry = event.getRegistry();
        registry.register(AETHER);
        registry.register(ENCHANT);
        registry.register(ENDER);
        registry.register(FIRE);
        registry.register(FOREST);
        registry.register(ICE);
        registry.register(MOONLIGHT);
        registry.register(NETHER);
        registry.register(SCULK);
        registry.register(SKELETON);
        registry.register(STORM);
        registry.register(SUNLIGHT);
        registry.register(TERRA);
        registry.register(WATER);
        registry.register(WITHER);
        registry.register(ZOMBIE);
    }*/
}
