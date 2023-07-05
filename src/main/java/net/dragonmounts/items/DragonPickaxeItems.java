package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonPickaxe;
import net.dragonmounts.items.material.DragonToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonPickaxeItems {
        public static ToolItem aether_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Aether, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem enchant_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Enchant, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ender_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Ender, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem fire_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Fire, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem forest_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Forest, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem ice_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Ice, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem moonlight_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Moonlight, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem nether_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Nether, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sculk_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Sculk, 0, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem storm_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Storm, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem sunlight_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Sunlight, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem terra_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Terra, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static ToolItem water_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Water, -1, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static ToolItem zombie_dragon_pickaxe = new DragonPickaxe(DragonToolMaterial.Zombie, 0, -2.4F, new Item.Settings().group(DragonMountsGroup.ItemsGroup));
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
