package net.dragonmounts.entity.dragon;

import net.dragonmounts.DragonMountsConfig;
import net.dragonmounts.api.IDragonFood;
import net.dragonmounts.block.entity.DragonCoreBlockEntity;
import net.dragonmounts.data.tag.DMItemTags;
import net.dragonmounts.entity.ai.DragonFollowOwnerGoal;
import net.dragonmounts.entity.ai.PlayerControlledGoal;
import net.dragonmounts.init.DMBlocks;
import net.dragonmounts.init.DMEntities;
import net.dragonmounts.init.DragonTypes;
import net.dragonmounts.inventory.DragonInventory;
import net.dragonmounts.inventory.LimitedSlot;
import net.dragonmounts.network.DMPackets;
import net.dragonmounts.registry.DragonType;
import net.dragonmounts.registry.DragonVariant;
import net.dragonmounts.util.DragonFood;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import static net.dragonmounts.util.EntityUtil.addOrMergeEffect;
import static net.dragonmounts.util.EntityUtil.addOrResetEffect;
import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;

public class ServerDragonEntity extends TameableDragonEntity {
    public final PlayerControlledGoal playerControlledGoal;

    public ServerDragonEntity(EntityType<? extends TameableDragonEntity> type, World world) {
        super(type, world);
        this.goalSelector.add(0, this.playerControlledGoal = new PlayerControlledGoal(this));
    }

    public ServerDragonEntity(World world) {
        this(DMEntities.TAMEABLE_DRAGON, world);
    }

    public ServerDragonEntity(HatchableDragonEggEntity egg, DragonLifeStage stage) {
        this(DMEntities.TAMEABLE_DRAGON, egg.world);
        NbtCompound data = egg.writeNbt(new NbtCompound());
        data.remove(AGE_DATA_PARAMETER_KEY);
        data.remove(DragonLifeStage.DATA_PARAMETER_KEY);
        this.readNbt(data);
        this.setDragonType(egg.getDragonType(), false);
        this.setLifeStage(stage, true, true);
        this.setHealth(this.getMaxHealth() + egg.getHealth() - egg.getMaxHealth());
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(3, new DragonFollowOwnerGoal(this));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, (new RevengeGoal(this)).setGroupRevenge());
        this.targetSelector.add(4, new FollowTargetGoal<>(this, MobEntity.class, 5, false, false, entity -> entity instanceof Monster));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putString(DragonVariant.DATA_PARAMETER_KEY, this.getVariant().identifier.toString());
        compound.putString(DragonLifeStage.DATA_PARAMETER_KEY, this.stage.asString());
        compound.putBoolean(AGE_LOCKED_DATA_PARAMETER_KEY, this.isAgeLocked());
        compound.putInt(SHEARED_DATA_PARAMETER_KEY, this.isSheared() ? this.shearCooldown : 0);
        NbtList items = this.inventory.createTag();
        if (!items.isEmpty()) {
            compound.put(DragonInventory.DATA_PARAMETER_KEY, items);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        int age = this.breedingAge;
        DragonLifeStage stage = this.stage;
        if (compound.contains(DragonLifeStage.DATA_PARAMETER_KEY)) {
            this.setLifeStage(DragonLifeStage.byName(compound.getString(DragonLifeStage.DATA_PARAMETER_KEY)), false, false);
        }
        super.readCustomDataFromNbt(compound);
        if (!this.firstUpdate && (this.breedingAge != age || stage != this.stage)) {
            PacketByteBuf buffer = this.syncAgePacket();
            for (ServerPlayerEntity player : PlayerLookup.tracking(this)) {
                ServerPlayNetworking.send(player, DMPackets.SYNC_DRAGON_AGE_PACKET_ID, buffer);
            }
        }
        if (compound.contains(DragonVariant.DATA_PARAMETER_KEY)) {
            this.setVariant(DragonVariant.REGISTRY.get(new Identifier(compound.getString(DragonVariant.DATA_PARAMETER_KEY))));
        } else if (compound.contains(DragonType.DATA_PARAMETER_KEY)) {
            this.setVariant(DragonType.REGISTRY.get(new Identifier(compound.getString(DragonType.DATA_PARAMETER_KEY))).variants.draw(this.random, null));
        }
        if (compound.contains(SADDLE_DATA_PARAMETER_KEY)) {
            this.setSaddle(ItemStack.fromNbt(compound.getCompound(SADDLE_DATA_PARAMETER_KEY)), true);
        }
        if (compound.contains(SHEARED_DATA_PARAMETER_KEY)) {
            this.setSheared(compound.getInt(SHEARED_DATA_PARAMETER_KEY));
        }
        if (compound.contains(AGE_LOCKED_DATA_PARAMETER_KEY)) {
            this.setAgeLocked(compound.getBoolean(AGE_LOCKED_DATA_PARAMETER_KEY));
        }
        if (compound.contains(DragonInventory.DATA_PARAMETER_KEY)) {
            this.inventory.fromTag(compound.getList(DragonInventory.DATA_PARAMETER_KEY, 10));
        }
    }

    /**
     * Causes this entity to lift off if it can fly.
     */
    public void liftOff() {
        if (!this.isBaby()) {
            boolean flag = this.hasPassengers() && (this.isInLava() || this.isInsideWaterOrBubbleColumn());
            this.velocityDirty = true;
            // stronger jump for an easier lift-off
            this.setVelocity(this.getVelocity().add(0, flag ? 0.7 : 6, 0));
            this.flightTicks += flag ? 3 : 4;
        }
    }

    public void spawnEssence(ItemStack stack) {
        BlockPos pos = this.getBlockPos();
        if (this.world.isAir(pos)) {
            BlockState state = DMBlocks.DRAGON_CORE.getDefaultState().with(HORIZONTAL_FACING, this.getHorizontalFacing());
            if (this.world.setBlockState(pos, state, 3)) {
                BlockEntity entity = this.world.getBlockEntity(pos);
                if (entity instanceof DragonCoreBlockEntity) {
                    ((DragonCoreBlockEntity) entity).setStack(0, stack);
                    return;
                }
            }
        }
        this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), stack));
    }

    @Override
    protected void checkCrystals() {
        if (this.nearestCrystal != null && this.nearestCrystal.isAlive()) {
            if (++this.crystalTicks > 0 && this.getHealth() < this.getMaxHealth()) {
                this.crystalTicks = -10;
                this.setHealth(this.getHealth() + 1.0F);
                addOrResetEffect(this, StatusEffects.STRENGTH, 300, 0, false, true, true, 101);//15s
            }
            if (this.random.nextInt(20) == 0) {
                this.nearestCrystal = this.findCrystal();
            }
        } else {
            this.nearestCrystal = this.random.nextInt(10) == 0 ? this.findCrystal() : null;
        }
    }

    @Override
    public void tickMovement() {
        if (this.isDead()) {
            this.nearestCrystal = null;
        } else {
            this.checkCrystals();
        }
        if (this.shearCooldown > 0) {
            this.setSheared(this.shearCooldown - 1);
        }
        if (this.isAgeLocked()) {
            int age = this.breedingAge;
            this.breedingAge = 0;
            super.tickMovement();
            this.breedingAge = age;
        } else {
            super.tickMovement();
        }
        /*if (this.isOnGround()) {
            this.flightTicks = 0;
            this.setFlying(false);
        } else {
            this.setFlying(++this.flightTicks > LIFTOFF_THRESHOLD && !this.isBaby() && this.getControllingPassenger() != null);
                if (this.isFlying() != flag) {
                    getEntityAttribute(FOLLOW_RANGE).setBaseValue(getDragonSpeed());
                }
        }*/
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        Item item = stack.getItem();
        IDragonFood food = DragonFood.get(item, null);
        if (food != null) {
            if (!food.isEatable(this, player, stack, hand)) return ActionResult.FAIL;
            food.eat(this, player, stack, hand);
            PacketByteBuf buffer = this.syncAgePacket().writeVarInt(Item.getRawId(item));
            for (ServerPlayerEntity target : PlayerLookup.tracking(this)) {
                ServerPlayNetworking.send(target, DMPackets.FEED_DRAGON_PACKET_ID, buffer);
            }
        } else if (!this.isOwner(player)) {
            return ActionResult.PASS;
        } else if (DMItemTags.BATONS.contains(item)) {
            this.setSitting(!this.isSitting());
        } else if (!this.isBaby() && this.getSaddleStack().isEmpty() && LimitedSlot.Saddle.canInsert(item)) {
            this.setSaddle(stack.split(1), true);
        } else if (this.getArmorStack().isEmpty() && LimitedSlot.DragonArmor.canInsert(item)) {
            this.setArmor(stack.split(1), true);
        } else if (this.getChestStack().isEmpty() && LimitedSlot.SingleWoodenChest.canInsert(item)) {
            this.setChest(stack.split(1), true);
        } else {
            ActionResult result = item.useOnEntity(stack, player, this, hand);
            if (result.isAccepted()) return result;
            if (!DragonMountsConfig.SERVER.debug.get() || player.shouldCancelInteraction()) {
                this.openInventory((ServerPlayerEntity) player);
            } else if (this.isBaby()) {
                this.setTarget(null);
                this.getNavigation().stop();
                this.setInSittingPose(false);
                NbtCompound tag = new NbtCompound();
                if (this.saveSelfNbt(tag) && player.addShoulderEntity(tag)) {
                    this.remove();
                }
            } else if (this.isSaddled) {
                player.yaw = this.pitch;
                player.pitch = this.pitch;
                player.startRiding(this);
            } else {
                this.openInventory((ServerPlayerEntity) player);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        super.onStruckByLightning(world, lightning);
        addOrMergeEffect(this, StatusEffects.STRENGTH, 700, 0, false, true, true);//35s
        DragonType current = this.getDragonType();
        if (current == DragonTypes.SKELETON) {
            this.setDragonType(DragonTypes.WITHER, false);
        } else if (current == DragonTypes.WATER) {
            this.setDragonType(DragonTypes.STORM, false);
        } else return;
        this.playSound(SoundEvents.BLOCK_END_PORTAL_SPAWN, 2, 1);
        this.playSound(SoundEvents.BLOCK_PORTAL_TRIGGER, 2, 1);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (this.isTamed()) {
            //TODO this.spawnEssence(this.getDragonType().getInstance(DragonEssenceItem.class, DMItems.ENDER_DRAGON_ESSENCE).saveEntity(this));
        }
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, DMPackets.SYNC_DRAGON_AGE_PACKET_ID, this.syncAgePacket());
    }

    @Override
    public void setLifeStage(DragonLifeStage stage, boolean reset, boolean sync) {
        EntityAttributeInstance attribute = this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            double temp = attribute.getValue();
            attribute.removeModifier(AGE_MODIFIER_UUID);
            attribute.addTemporaryModifier(new EntityAttributeModifier(
                    AGE_MODIFIER_UUID,
                    "DragonAgeBonus",
                    Math.max(DragonLifeStage.getSizeAverage(stage), 0.1F),
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL
            ));
            temp = attribute.getValue() - temp;
            this.setHealth(temp > 0 ? this.getHealth() + (float) temp : this.getHealth());
        }
        if (this.stage == stage) return;
        this.stage = stage;
        if (reset) {
            this.refreshAge();
        }
        this.refreshPosition();
        this.calculateDimensions();
        if (sync) {
            PacketByteBuf buffer = this.syncAgePacket();
            for (ServerPlayerEntity player : PlayerLookup.tracking(this)) {
                ServerPlayNetworking.send(player, DMPackets.SYNC_DRAGON_AGE_PACKET_ID, buffer);
            }
        }
    }

    @Override
    public void travel(Vec3d vector) {
        // disable method while flying, the movement is done entirely by
        // moveEntity() and this one just makes the dragon to fall slowly when
        if (!this.isFlying()) {
            super.travel(vector);
        }
    }

    @Override
    public void setBreedingAge(int age) {
        if (this.breedingAge == age) return;
        if (this.breedingAge < 0 && age >= 0 || this.breedingAge > 0 && age <= 0) {
            this.onGrowUp();
        } else {
            this.breedingAge = age;
        }
        PacketByteBuf buffer = this.syncAgePacket();
        for (ServerPlayerEntity player : PlayerLookup.tracking(this)) {
            ServerPlayNetworking.send(player, DMPackets.SYNC_DRAGON_AGE_PACKET_ID, buffer);
        }
    }

    public final void openInventory(ServerPlayerEntity player) {
        player.openHandledScreen(this.inventory);
    }

    public final PacketByteBuf syncAgePacket() {
        return this.writeId(PacketByteBufs.create()).writeVarInt(this.breedingAge).writeVarInt(this.stage.ordinal());
    }
}
