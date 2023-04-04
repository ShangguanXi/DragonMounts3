package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonBow;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class DragonBowItems {
    public static Item dragon_bow_aether = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_enchant = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_ender = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_fire = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_forest = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_ice = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_moonlight = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_nether = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_sculk = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_storm = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_sunlight = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_terra = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_water = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_bow_zombie = new DragonBow(new Item.Settings().maxDamage(725).group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_aether"), dragon_bow_aether);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_enchant"), dragon_bow_enchant);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_end"), dragon_bow_ender);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_fire"), dragon_bow_fire);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_forest"), dragon_bow_forest);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_ice"), dragon_bow_ice);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_moonlight"), dragon_bow_moonlight);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_nether"), dragon_bow_nether);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_sculk"), dragon_bow_sculk);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_storm"), dragon_bow_storm);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_sunlight"), dragon_bow_sunlight);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_terra"), dragon_bow_terra);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_water"), dragon_bow_water);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_bow_zombie"), dragon_bow_zombie);

    }
}
