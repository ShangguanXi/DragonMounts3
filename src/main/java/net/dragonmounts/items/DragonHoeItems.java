package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonHoe;
import net.dragonmounts.items.material.DragonToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonHoeItems {
    public static ToolItem aether_dragon_hoe= new DragonHoe(DragonToolMaterial.Aether, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_hoe= new DragonHoe(DragonToolMaterial.Enchant, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_hoe= new DragonHoe(DragonToolMaterial.Ender, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_hoe= new DragonHoe(DragonToolMaterial.Fire, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_hoe= new DragonHoe(DragonToolMaterial.Forest, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_hoe= new DragonHoe(DragonToolMaterial.Ice, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_hoe= new DragonHoe(DragonToolMaterial.Moonlight, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_hoe= new DragonHoe(DragonToolMaterial.Nether, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_hoe= new DragonHoe(DragonToolMaterial.Sculk, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_hoe= new DragonHoe(DragonToolMaterial.Storm, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_hoe= new DragonHoe(DragonToolMaterial.Sunlight, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_hoe= new DragonHoe(DragonToolMaterial.Terra, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_hoe= new DragonHoe(DragonToolMaterial.Water, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem zombie_dragon_hoe= new DragonHoe(DragonToolMaterial.Zombie, -3, 0, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
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
