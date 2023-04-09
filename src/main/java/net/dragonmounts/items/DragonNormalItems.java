package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonNormalItems {
    public static final Item dragonarmor_diamond = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item dragonarmor_emerald = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item dragonarmor_gold = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item dragonarmor_iron = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));
    public static final Item dragonarmor_netherite = new Item(new Item.Settings().group(DragonMountsGroup.ItemsGroup));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragonarmor_diamond"), dragonarmor_diamond);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragonarmor_emerald"), dragonarmor_emerald);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragonarmor_gold"), dragonarmor_gold);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragonarmor_iron"), dragonarmor_iron);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragonarmor_netherite"), dragonarmor_netherite);

    }
}
