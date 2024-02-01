package net.dragonmounts.init;

import net.dragonmounts.block.entity.DragonCoreBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMBlockEntities {
    public static final BlockEntityType<DragonCoreBlockEntity> DRAGON_CORE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "dragon_core"), BlockEntityType.Builder.create(DragonCoreBlockEntity::new, DMBlocks.DRAGON_CORE).build(null));
}
