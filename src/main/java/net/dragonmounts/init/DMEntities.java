package net.dragonmounts.init;

import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMEntities {
    public static final EntityType<HatchableDragonEggEntity> HATCHABLE_DRAGON_EGG =
            Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MOD_ID, "dragon_egg"),
                    FabricEntityTypeBuilder.createLiving()
                            .entityFactory((EntityType.EntityFactory<HatchableDragonEggEntity>) HatchableDragonEggEntity::new)
                            .defaultAttributes(HatchableDragonEggEntity::createAttributes)
                            .dimensions(EntityDimensions.fixed(0.875F, 1.0F))
                            .build()
            );

    public static void init() {}
}
