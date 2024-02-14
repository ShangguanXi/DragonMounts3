package net.dragonmounts.data.tag;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMItemTags {
    public static final Tag<Item> DRAGON_EGGS = TagRegistry.item(new Identifier(MOD_ID, "dragon_eggs"));
    public static final Tag<Item> DRAGON_SCALE_BOWS = TagRegistry.item(new Identifier(MOD_ID, "dragon_scale_bows"));
    public static final Tag<Item> DRAGON_SCALES = TagRegistry.item(new Identifier(MOD_ID, "dragon_scales"));
    public static final Tag<Item> BATONS = TagRegistry.item(new Identifier(MOD_ID, "batons"));
}
