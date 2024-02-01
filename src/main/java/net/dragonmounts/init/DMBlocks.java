package net.dragonmounts.init;

import net.dragonmounts.block.HatchableDragonEggBlock;
import net.dragonmounts.registry.DragonType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.ToIntFunction;

import static net.dragonmounts.DragonMounts.MOD_ID;
import static net.dragonmounts.init.DMItemGroups.block;

public class DMBlocks {
    private static final ToIntFunction<BlockState> DRAGON_EGG_LUMINANCE = state -> 1;
    public static final HatchableDragonEggBlock AETHER_DRAGON_EGG = registerDragonEggBlock("aether_dragon_egg", DragonTypes.AETHER, MapColor.LIGHT_BLUE, block());
    public static final HatchableDragonEggBlock ENCHANT_DRAGON_EGG = registerDragonEggBlock("enchant_dragon_egg", DragonTypes.ENCHANT, MapColor.PURPLE, block());
    public static final HatchableDragonEggBlock ENDER_DRAGON_EGG = registerDragonEggBlock("ender_dragon_egg", DragonTypes.ENDER, MapColor.BLACK, block());
    public static final HatchableDragonEggBlock FIRE_DRAGON_EGG = registerDragonEggBlock("fire_dragon_egg", DragonTypes.FIRE, MapColor.BRIGHT_RED, block());
    public static final HatchableDragonEggBlock FOREST_DRAGON_EGG = registerDragonEggBlock("forest_dragon_egg", DragonTypes.FOREST, MapColor.GREEN, block());
    public static final HatchableDragonEggBlock ICE_DRAGON_EGG = registerDragonEggBlock("ice_dragon_egg", DragonTypes.ICE, MapColor.WHITE, block());
    public static final HatchableDragonEggBlock MOONLIGHT_DRAGON_EGG = registerDragonEggBlock("moonlight_dragon_egg", DragonTypes.MOONLIGHT, MapColor.BLUE, block());
    public static final HatchableDragonEggBlock SCULK_DRAGON_EGG = registerDragonEggBlock("sculk_dragon_egg", DragonTypes.SCULK, MapColor.BLACK, block());
    public static final HatchableDragonEggBlock NETHER_DRAGON_EGG = registerDragonEggBlock("nether_dragon_egg", DragonTypes.NETHER, MapColor.DARK_RED, block());
    public static final HatchableDragonEggBlock SKELETON_DRAGON_EGG = registerDragonEggBlock("skeleton_dragon_egg", DragonTypes.SKELETON, MapColor.OFF_WHITE, block());
    public static final HatchableDragonEggBlock STORM_DRAGON_EGG = registerDragonEggBlock("storm_dragon_egg", DragonTypes.STORM, MapColor.WHITE_GRAY, block());
    public static final HatchableDragonEggBlock SUNLIGHT_DRAGON_EGG = registerDragonEggBlock("sunlight_dragon_egg", DragonTypes.SUNLIGHT, MapColor.YELLOW, block());
    public static final HatchableDragonEggBlock TERRA_DRAGON_EGG = registerDragonEggBlock("terra_dragon_egg", DragonTypes.TERRA, MapColor.DIRT_BROWN, block());
    public static final HatchableDragonEggBlock WATER_DRAGON_EGG = registerDragonEggBlock("water_dragon_egg", DragonTypes.WATER, MapColor.WATER_BLUE, block());
    public static final HatchableDragonEggBlock WITHER_DRAGON_EGG = registerDragonEggBlock("wither_dragon_egg", DragonTypes.WITHER, MapColor.GRAY, block());
    public static final HatchableDragonEggBlock ZOMBIE_DRAGON_EGG = registerDragonEggBlock("zombie_dragon_egg", DragonTypes.ENDER, MapColor.TERRACOTTA_GREEN, block());

    private static HatchableDragonEggBlock registerDragonEggBlock(String name, DragonType type, MapColor color, Item.Settings settings) {
        final Identifier identifier = new Identifier(MOD_ID, name);
        final HatchableDragonEggBlock block = new HatchableDragonEggBlock(type, FabricBlockSettings.of(Material.EGG, color).strength(0.0F, 9.0F).luminance(DRAGON_EGG_LUMINANCE).nonOpaque());
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, settings));
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    public static void init() {}
}
