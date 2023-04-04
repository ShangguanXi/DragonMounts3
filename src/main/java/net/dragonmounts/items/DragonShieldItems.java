package net.dragonmounts.items;

import net.dragonmounts.group.DragonMountsGroup;
import net.dragonmounts.items.material.DragonShield;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonShieldItems {
    public static Item dragon_shield_aether = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_enchant = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_ender = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_fire = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_forest = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_ice = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_moonlight = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_nether = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_sculk = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_storm = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_sunlight = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_terra = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_water = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static Item dragon_shield_zombie = new DragonShield(new Item.Settings().maxDamage(2500).group(DragonMountsGroup.ItemsGroup));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_aether"), dragon_shield_aether);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_enchant"), dragon_shield_enchant);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_end"), dragon_shield_ender);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_fire"), dragon_shield_fire);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_forest"), dragon_shield_forest);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_ice"), dragon_shield_ice);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_moonlight"), dragon_shield_moonlight);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_nether"), dragon_shield_nether);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_sculk"), dragon_shield_sculk);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_storm"), dragon_shield_storm);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_sunlight"), dragon_shield_sunlight);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_terra"), dragon_shield_terra);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_water"), dragon_shield_water);
        Registry.register(Registry.ITEM, new Identifier("dragonmounts", "dragon_shield_zombie"), dragon_shield_zombie);

    }
}
