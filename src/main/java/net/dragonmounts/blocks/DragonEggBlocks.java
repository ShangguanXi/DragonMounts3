package net.dragonmounts.blocks;

import net.dragonmounts.blocks.material.eggs.DragonEgg;
import net.dragonmounts.group.DragonMountsGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonEggBlocks {
    public static Block aether_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.LIGHT_BLUE).strength(3.0F, 9.0F).nonOpaque());
    public static Block enchant_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.PURPLE).strength(3.0F, 9.0F).nonOpaque());
    public static Block ender_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.BLACK).strength(3.0F, 9.0F).nonOpaque());
    public static Block fire_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.RED).strength(3.0F, 9.0F).nonOpaque());
    public static Block forest_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.GREEN).strength(3.0F, 9.0F).nonOpaque());
    public static Block ice_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.WHITE).strength(3.0F, 9.0F).nonOpaque());
    public static Block moonlight_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.BLUE).strength(3.0F, 9.0F).nonOpaque());
    public static Block sculk_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.BLACK).strength(3.0F, 9.0F).nonOpaque());
    public static Block nether_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.DARK_GREEN).strength(3.0F, 9.0F).nonOpaque());
    public static Block skeleton_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.GRAY).strength(3.0F, 9.0F).nonOpaque());
    public static Block storm_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.IRON_GRAY).strength(3.0F, 9.0F).nonOpaque());
    public static Block sunlight_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.YELLOW).strength(3.0F, 9.0F).nonOpaque());
    public static Block terra_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.DIRT_BROWN).strength(3.0F, 9.0F).nonOpaque());
    public static Block water_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.WATER_BLUE).strength(3.0F, 9.0F).nonOpaque());
    public static Block wither_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.STONE_GRAY).strength(3.0F, 9.0F).nonOpaque());
    public static Block zombie_dragon_egg = new DragonEgg(FabricBlockSettings.of(Material.EGG, MapColor.TERRACOTTA_GREEN).strength(3.0F, 9.0F).nonOpaque());
    public static void registerDragonEggBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "aether_dragon_egg"), aether_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_egg"), new BlockItem(aether_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "enchant_dragon_egg"), enchant_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_egg"), new BlockItem(enchant_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "ender_dragon_egg"), ender_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_egg"), new BlockItem(ender_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "fire_dragon_egg"), fire_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_egg"), new BlockItem(fire_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "forest_dragon_egg"), forest_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_egg"), new BlockItem(forest_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "ice_dragon_egg"), ice_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_egg"), new BlockItem(ice_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "moonlight_dragon_egg"), moonlight_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_egg"), new BlockItem(moonlight_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "nether_dragon_egg"), nether_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_egg"), new BlockItem(nether_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "sculk_dragon_egg"), sculk_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_egg"), new BlockItem(sculk_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "skeleton_dragon_egg"), skeleton_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "skeleton_dragon_egg"), new BlockItem(skeleton_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "storm_dragon_egg"), storm_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_egg"), new BlockItem(storm_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "sunlight_dragon_egg"), sunlight_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_egg"), new BlockItem(sunlight_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "terra_dragon_egg"), terra_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_egg"), new BlockItem(terra_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "water_dragon_egg"), water_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_egg"), new BlockItem(water_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "wither_dragon_egg"), wither_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "wither_dragon_egg"), new BlockItem(wither_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));
        Registry.register(Registry.BLOCK, new Identifier("dragonmounts", "zombie_dragon_egg"), zombie_dragon_egg);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_egg"), new BlockItem(zombie_dragon_egg, new Item.Settings().group(DragonMountsGroup.ItemsGroup)));

    }
}
