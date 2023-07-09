package net.dragonmounts.entities.dragonEggs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EnchantDragonEggEntity extends AnimalEntity {

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return EnchantDragonEggEntity.this;
    }

    public EnchantDragonEggEntity(EntityType<? extends  EnchantDragonEggEntity> entityType, World world){
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAetherDragonEggAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
    }
}
