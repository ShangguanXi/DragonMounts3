package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonArmorMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonArmorItems {
    public static  Item aether_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.AetherArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item aether_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.AetherArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item aether_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.AetherArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item aether_dragonscale_boots = new ArmorItem(DragonArmorMaterials.AetherArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item enchant_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.EnchantArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item enchant_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.EnchantArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item enchant_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.EnchantArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item enchant_dragonscale_boots = new ArmorItem(DragonArmorMaterials.EnchantArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item ender_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.EnderArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item ender_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.EnderArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item ender_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.EnderArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item ender_dragonscale_boots = new ArmorItem(DragonArmorMaterials.EnderArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item fire_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.FireArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item fire_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.FireArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item fire_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.FireArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item fire_dragonscale_boots = new ArmorItem(DragonArmorMaterials.FireArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item forest_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.ForestArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item forest_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.ForestArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item forest_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.ForestArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item forest_dragonscale_boots = new ArmorItem(DragonArmorMaterials.ForestArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item ice_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.IceArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item ice_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.IceArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item ice_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.IceArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item ice_dragonscale_boots = new ArmorItem(DragonArmorMaterials.IceArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item moonlight_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.MoonlightArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item moonlight_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.MoonlightArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item moonlight_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.MoonlightArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item moonlight_dragonscale_boots = new ArmorItem(DragonArmorMaterials.MoonlightArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item nether_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.NetherArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item nether_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.NetherArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item nether_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.NetherArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item nether_dragonscale_boots = new ArmorItem(DragonArmorMaterials.NetherArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item sculk_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.SculkArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item sculk_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.SculkArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item sculk_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.SculkArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item sculk_dragonscale_boots = new ArmorItem(DragonArmorMaterials.SculkArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item storm_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.StormArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item storm_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.StormArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item storm_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.StormArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item storm_dragonscale_boots = new ArmorItem(DragonArmorMaterials.StormArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item sunlight_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.SunlightArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item sunlight_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.SunlightArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item sunlight_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.SunlightArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item sunlight_dragonscale_boots = new ArmorItem(DragonArmorMaterials.SunlightArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item terra_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.TerraArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item terra_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.TerraArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item terra_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.TerraArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item terra_dragonscale_boots = new ArmorItem(DragonArmorMaterials.TerraArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item water_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.WaterArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item water_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.WaterArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item water_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.WaterArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item water_dragonscale_boots = new ArmorItem(DragonArmorMaterials.WaterArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static  Item zombie_dragonscale_helmet = new ArmorItem(DragonArmorMaterials.ZombieArmor, EquipmentSlot.HEAD, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item zombie_dragonscale_chestplate = new ArmorItem(DragonArmorMaterials.ZombieArmor, EquipmentSlot.CHEST, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item zombie_dragonscale_leggings = new ArmorItem(DragonArmorMaterials.ZombieArmor, EquipmentSlot.LEGS, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static  Item zombie_dragonscale_boots = new ArmorItem(DragonArmorMaterials.ZombieArmor, EquipmentSlot.FEET, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragonscale_helmet"), aether_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragonscale_chestplate"), aether_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragonscale_leggings"), aether_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragonscale_boots"), aether_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragonscale_helmet"), enchant_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragonscale_chestplate"), enchant_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragonscale_leggings"), enchant_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragonscale_boots"), enchant_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragonscale_helmet"), ender_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragonscale_chestplate"), ender_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragonscale_leggings"), ender_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragonscale_boots"), ender_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragonscale_helmet"), fire_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragonscale_chestplate"), fire_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragonscale_leggings"), fire_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragonscale_boots"), fire_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragonscale_helmet"), forest_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragonscale_chestplate"), forest_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragonscale_leggings"), forest_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragonscale_boots"), forest_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragonscale_helmet"), ice_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragonscale_chestplate"), ice_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragonscale_leggings"), ice_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragonscale_boots"), ice_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragonscale_helmet"), moonlight_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragonscale_chestplate"), moonlight_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragonscale_leggings"), moonlight_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragonscale_boots"), moonlight_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragonscale_helmet"), nether_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragonscale_chestplate"), nether_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragonscale_leggings"), nether_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragonscale_boots"), nether_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragonscale_helmet"), sculk_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragonscale_chestplate"), sculk_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragonscale_leggings"), sculk_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragonscale_boots"), sculk_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragonscale_helmet"), storm_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragonscale_chestplate"), storm_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragonscale_leggings"), storm_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragonscale_boots"), storm_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragonscale_helmet"), sunlight_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragonscale_chestplate"), sunlight_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragonscale_leggings"), sunlight_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragonscale_boots"), sunlight_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragonscale_helmet"), terra_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragonscale_chestplate"), terra_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragonscale_leggings"), terra_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragonscale_boots"), terra_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragonscale_helmet"), water_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragonscale_chestplate"), water_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragonscale_leggings"), water_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragonscale_boots"), water_dragonscale_boots );

        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragonscale_helmet"), zombie_dragonscale_helmet);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragonscale_chestplate"), zombie_dragonscale_chestplate);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragonscale_leggings"), zombie_dragonscale_leggings);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragonscale_boots"), zombie_dragonscale_boots );

    }
}
