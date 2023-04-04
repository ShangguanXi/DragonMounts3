package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonPickaxe;
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

public class DragonPickaxeItems {
    public static ToolItem aether_dragon_pickaxe = new DragonPickaxe(AetherMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_pickaxe = new DragonPickaxe(EnchantMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_pickaxe = new DragonPickaxe(EnderMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_pickaxe = new DragonPickaxe(FireMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_pickaxe = new DragonPickaxe(ForestMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_pickaxe = new DragonPickaxe(IceMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_pickaxe = new DragonPickaxe(MoonlightMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_pickaxe = new DragonPickaxe(NetherMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_pickaxe = new DragonPickaxe(SculkMaterial.INSTANCE, 0, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_pickaxe = new DragonPickaxe(StormMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_pickaxe = new DragonPickaxe(SunlightMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_pickaxe = new DragonPickaxe(TerraMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_pickaxe = new DragonPickaxe(WaterMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_pickaxe = new DragonPickaxe(ZombieMaterial.INSTANCE, 0, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_pickaxe"), aether_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_pickaxe"), enchant_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_pickaxe"), ender_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_pickaxe"), fire_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_pickaxe"), forest_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_pickaxe"), ice_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_pickaxe"), moonlight_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_pickaxe"), nether_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_pickaxe"), sculk_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_pickaxe"), storm_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_pickaxe"), sunlight_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_pickaxe"), terra_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_pickaxe"), water_dragon_pickaxe);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_pickaxe"), zombie_dragon_pickaxe);
    }
}
