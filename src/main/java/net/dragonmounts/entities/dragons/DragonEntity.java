package net.dragonmounts.entities.dragons;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.world.World;

public class DragonEntity extends HorseBaseEntity {
    protected DragonEntity(EntityType<? extends HorseBaseEntity> entityType, World world) {
        super(entityType, world);
    }

}
