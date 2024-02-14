package net.dragonmounts.data.tag;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ForgeTags {
    public static class Items {
        public static final Tag<Item> CHESTS_WOODEN = TagRegistry.item(new Identifier("forge", "chests/wooden"));
    }
}
