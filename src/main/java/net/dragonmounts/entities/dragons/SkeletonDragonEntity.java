package net.dragonmounts.entities.dragons;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.world.World;

public class SkeletonDragonEntity extends HorseBaseEntity {
    public SkeletonDragonEntity(EntityType<? extends HorseBaseEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createEnchantDragonAttributes(){
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 200);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
    }
}
