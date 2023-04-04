package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
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
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonSwordItems {
    public static ToolItem aether_dragon_sword = new SwordItem(AetherMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_sword = new SwordItem(EnchantMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_sword = new SwordItem(EnderMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_sword = new SwordItem(FireMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_sword = new SwordItem(ForestMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_sword = new SwordItem(IceMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_sword = new SwordItem(MoonlightMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_sword = new SwordItem(NetherMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_sword = new SwordItem(SculkMaterial.INSTANCE, 1, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_sword = new SwordItem(StormMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_sword = new SwordItem(SunlightMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_sword = new SwordItem(TerraMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_sword = new SwordItem(WaterMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_sword = new SwordItem(ZombieMaterial.INSTANCE, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_sword"), aether_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_sword"), enchant_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_sword"), ender_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_sword"), fire_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_sword"), forest_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_sword"), ice_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_sword"), moonlight_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_sword"), nether_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_sword"), sculk_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_sword"), storm_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_sword"), sunlight_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_sword"), terra_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_sword"), water_dragon_sword);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_sword"), zombie_dragon_sword);
    }
}
