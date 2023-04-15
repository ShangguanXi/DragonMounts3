package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonSwordItems {
    public static ToolItem aether_dragon_sword = new SwordItem(DragonToolMaterial.Aether, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_sword = new SwordItem(DragonToolMaterial.Enchant, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_sword = new SwordItem(DragonToolMaterial.Ender, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_sword = new SwordItem(DragonToolMaterial.Fire, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_sword = new SwordItem(DragonToolMaterial.Forest, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_sword = new SwordItem(DragonToolMaterial.Ice, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_sword = new SwordItem(DragonToolMaterial.Moonlight, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_sword = new SwordItem(DragonToolMaterial.Nether, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_sword = new SwordItem(DragonToolMaterial.Sculk, 1, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_sword = new SwordItem(DragonToolMaterial.Storm, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_sword = new SwordItem(DragonToolMaterial.Sunlight, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_sword = new SwordItem(DragonToolMaterial.Terra, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_sword = new SwordItem(DragonToolMaterial.Water, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_sword = new SwordItem(DragonToolMaterial.Zombie, 0, -2, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
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
