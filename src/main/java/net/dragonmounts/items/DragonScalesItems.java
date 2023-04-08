package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonScalesItems {
    public static final Item aether_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item enchant_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item ender_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item fire_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item forest_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item ice_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item moonlight_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item nether_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item sculk_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item storm_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item sunlight_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item terra_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item water_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item zombie_dragon_scales = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "aether_dragon_scales"), aether_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "enchant_dragon_scales"), enchant_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ender_dragon_scales"), ender_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "fire_dragon_scales"), fire_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "forest_dragon_scales"), forest_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "ice_dragon_scales"), ice_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "moonlight_dragon_scales"), moonlight_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "nether_dragon_scales"), nether_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sculk_dragon_scales"), sculk_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "storm_dragon_scales"), storm_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "sunlight_dragon_scales"), sunlight_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "terra_dragon_scales"), terra_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "water_dragon_scales"), water_dragon_scales);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "zombie_dragon_scales"), zombie_dragon_scales);
    }
}
