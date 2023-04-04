package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonAxe;
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

public class DragonAxeItems {
    public static ToolItem aether_dragon_axe = new DragonAxe(AetherMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_axe = new DragonAxe(EnchantMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_axe = new DragonAxe(EnderMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_axe = new DragonAxe(FireMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_axe = new DragonAxe(ForestMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_axe = new DragonAxe(IceMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_axe = new DragonAxe(MoonlightMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_axe = new DragonAxe(NetherMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_axe = new DragonAxe(SculkMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_axe = new DragonAxe(StormMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_axe = new DragonAxe(SunlightMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_axe = new DragonAxe(TerraMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_axe = new DragonAxe(WaterMaterial.INSTANCE, 2, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_axe = new DragonAxe(ZombieMaterial.INSTANCE, 0, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_axe"), aether_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_axe"), enchant_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_axe"), ender_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_axe"), fire_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_axe"), forest_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_axe"), ice_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_axe"), moonlight_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_axe"), nether_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_axe"), sculk_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_axe"), storm_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_axe"), sunlight_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_axe"), terra_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_axe"), water_dragon_axe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_axe"), zombie_dragon_axe);
    }
}
