package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonScalesItems {
    public static final Item aether_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item enchant_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item ender_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item fire_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item forest_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item ice_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item moonlight_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item nether_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item sculk_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item storm_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item sunlight_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item terra_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item water_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item zombie_dragonscales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragonscales"), aether_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragonscales"), enchant_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragonscales"), ender_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragonscales"), fire_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragonscales"), forest_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragonscales"), ice_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragonscales"), moonlight_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragonscales"), nether_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragonscales"), sculk_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragonscales"), storm_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragonscales"), sunlight_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragonscales"), terra_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragonscales"), water_dragonscales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragonscales"), zombie_dragonscales);
    }
}
