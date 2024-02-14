package net.dragonmounts.data.tag;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMBlockTags {
    public static final Tag<Block> DRAGON_EGGS = TagRegistry.block(new Identifier(MOD_ID, "dragon_eggs"));
}
