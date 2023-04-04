package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonHoe;
import net.dragonmounts.items.material.aether.AetherMaterial;
import net.dragonmounts.items.material.enchant.EnchantMaterial;
import net.dragonmounts.items.material.ender.EnderMaterial;
import net.dragonmounts.items.material.fire.FireMaterial;
import net.dragonmounts.items.material.forest.ForestMaterial;
import net.dragonmounts.items.material.ice.IceMaterial;
import net.dragonmounts.items.material.moonlight.MoonlightMaterial;
import net.dragonmounts.items.material.nether.NetherMaterial;
import net.dragonmounts.items.material.sculk.SculkMaterial;
import net.dragonmounts.items.material.storm.StormMaterial;
import net.dragonmounts.items.material.sunlight.SunlightMaterial;
import net.dragonmounts.items.material.terra.TerraMaterial;
import net.dragonmounts.items.material.water.WaterMaterial;
import net.dragonmounts.items.material.zombie.ZombieMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonHoeItems {
    public static ToolItem aether_dragon_hoe= new DragonHoe(AetherMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_hoe= new DragonHoe(EnchantMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_hoe= new DragonHoe(EnderMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_hoe= new DragonHoe(FireMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_hoe= new DragonHoe(ForestMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_hoe= new DragonHoe(IceMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_hoe= new DragonHoe(MoonlightMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_hoe= new DragonHoe(NetherMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_hoe= new DragonHoe(SculkMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_hoe= new DragonHoe(StormMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_hoe= new DragonHoe(SunlightMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_hoe= new DragonHoe(TerraMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_hoe= new DragonHoe(WaterMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_hoe= new DragonHoe(ZombieMaterial.INSTANCE, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_hoe"), aether_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_hoe"), enchant_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_hoe"), ender_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_hoe"), fire_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_hoe"), forest_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_hoe"), ice_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_hoe"), moonlight_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_hoe"), nether_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_hoe"), sculk_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_hoe"), storm_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_hoe"), sunlight_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_hoe"), terra_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_hoe"), water_dragon_hoe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_hoe"), zombie_dragon_hoe);
    }
}
