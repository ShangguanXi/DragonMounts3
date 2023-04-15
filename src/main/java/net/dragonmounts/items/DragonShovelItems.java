package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonShovelItems {
    public static ToolItem aether_dragon_shovel = new ShovelItem(DragonToolMaterial.Aether, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_shovel = new ShovelItem(DragonToolMaterial.Enchant, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_shovel = new ShovelItem(DragonToolMaterial.Ender, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_shovel = new ShovelItem(DragonToolMaterial.Fire, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_shovel = new ShovelItem(DragonToolMaterial.Forest, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_shovel = new ShovelItem(DragonToolMaterial.Ice, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_shovel = new ShovelItem(DragonToolMaterial.Moonlight, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_shovel = new ShovelItem(DragonToolMaterial.Nether, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_shovel = new ShovelItem(DragonToolMaterial.Sculk, -0.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_shovel = new ShovelItem(DragonToolMaterial.Storm, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_shovel = new ShovelItem(DragonToolMaterial.Sunlight, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_shovel = new ShovelItem(DragonToolMaterial.Terra, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_shovel = new ShovelItem(DragonToolMaterial.Water, -1.5F, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_shovel = new ShovelItem(DragonToolMaterial.Zombie, 0, -2.6F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
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
