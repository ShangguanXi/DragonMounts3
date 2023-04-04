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
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonShovelItems {
    public static ToolItem aether_dragon_shovel = new ShovelItem(AetherMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_shovel = new ShovelItem(EnchantMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_shovel = new ShovelItem(EnderMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_shovel = new ShovelItem(FireMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_shovel = new ShovelItem(ForestMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_shovel = new ShovelItem(IceMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_shovel = new ShovelItem(MoonlightMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_shovel = new ShovelItem(NetherMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_shovel = new ShovelItem(SculkMaterial.INSTANCE, -0.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_shovel = new ShovelItem(StormMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_shovel = new ShovelItem(SunlightMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_shovel = new ShovelItem(TerraMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_shovel = new ShovelItem(WaterMaterial.INSTANCE, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_shovel = new ShovelItem(ZombieMaterial.INSTANCE, 0, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_shovel"), aether_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_shovel"), enchant_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_shovel"), ender_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_shovel"), fire_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_shovel"), forest_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_shovel"), ice_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_shovel"), moonlight_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_shovel"), nether_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_shovel"), sculk_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_shovel"), storm_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_shovel"), sunlight_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_shovel"), terra_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_shovel"), water_dragon_shovel);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_shovel"), zombie_dragon_shovel);
    }
}
