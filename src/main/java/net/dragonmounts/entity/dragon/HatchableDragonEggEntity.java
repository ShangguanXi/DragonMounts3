package net.dragonmounts.entity.dragon;

import net.dragonmounts.DragonMountsConfig;
import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.block.HatchableDragonEggBlock;
import net.dragonmounts.init.DMBlocks;
import net.dragonmounts.init.DMEntities;
import net.dragonmounts.init.DragonTypes;
import net.dragonmounts.item.DragonScalesItem;
import net.dragonmounts.network.DMPacketHandler;
import net.dragonmounts.registry.DragonType;
import net.dragonmounts.registry.DragonVariant;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerConfigHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

import static net.dragonmounts.entity.dragon.TameableDragonEntity.AGE_DATA_PARAMETER_KEY;
import static net.dragonmounts.util.math.MathUtil.getColor;

public class HatchableDragonEggEntity extends LivingEntity implements IDragonTypified.Mutable {
    protected static final TrackedData<DragonType> DATA_DRAGON_TYPE = DataTracker.registerData(HatchableDragonEggEntity.class, DragonType.SERIALIZER);
    public static final int MIN_HATCHING_TIME = 36000;
    private static final float EGG_CRACK_PROCESS_THRESHOLD = 0.9F;
    private static final float EGG_SHAKE_PROCESS_THRESHOLD = 0.75F;
    private static final int EGG_SHAKE_THRESHOLD = (int) (EGG_SHAKE_PROCESS_THRESHOLD * MIN_HATCHING_TIME);
    private static final float EGG_SHAKE_BASE_CHANCE = 20F;
    protected String variant;
    protected UUID owner;
    protected float rotationAxis = 0;
    protected int amplitude = 0;
    protected int age = 0;
    protected boolean hatched = false;

    public HatchableDragonEggEntity(EntityType<? extends HatchableDragonEggEntity> type, World world) {
        super(type, world);
        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(DragonMountsConfig.SERVER.base_health.get());
    }

    public HatchableDragonEggEntity(World world) {
        this(DMEntities.HATCHABLE_DRAGON_EGG, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, DragonMountsConfig.SERVER.base_health.get())
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_DRAGON_TYPE, DragonTypes.ENDER);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putString(DragonType.DATA_PARAMETER_KEY, DragonType.REGISTRY.getId(this.dataTracker.get(DATA_DRAGON_TYPE)).toString());
        compound.putInt(AGE_DATA_PARAMETER_KEY, this.age);
        if (this.owner != null) {
            compound.putUuid("Owner", this.owner);
        }
        if (this.variant != null) {
            compound.putString(DragonVariant.DATA_PARAMETER_KEY, this.variant);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        if (compound.contains(DragonType.DATA_PARAMETER_KEY)) {
            this.setDragonType(DragonType.REGISTRY.get(new Identifier(compound.getString(DragonType.DATA_PARAMETER_KEY))), false);
        }
        if (compound.contains(DragonVariant.DATA_PARAMETER_KEY)) {
            this.variant = compound.getString(DragonVariant.DATA_PARAMETER_KEY);
        }
        if (compound.contains(AGE_DATA_PARAMETER_KEY)) {
            this.age = compound.getInt(AGE_DATA_PARAMETER_KEY);
        }
        if (compound.containsUuid("Owner")) {
            this.owner = compound.getUuid("Owner");
        } else {
            MinecraftServer server = this.getServer();
            if (server != null) {
                this.owner = ServerConfigHandler.getPlayerUuidByName(server, compound.getString("Owner"));
            }
        }
    }

    protected void spawnScales(int amount) {
        if (amount > 0) {
            DragonScalesItem scales = this.getDragonType().getInstance(DragonScalesItem.class, null);
            if (scales != null && this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
                this.dropStack(new ItemStack(scales, amount), 1.25F);
            }
        }
    }

    public void hatch() {
        if (!this.world.isClient) {
            this.spawnScales(this.random.nextInt(4) + 4);
            this.hatched = true;
        }
        this.remove();
    }

    public boolean isHatched() {
        return this.hatched;
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return Collections.singleton(ItemStack.EMPTY);
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {}

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (this.isAlive() && player.isSneaking()) {
            HatchableDragonEggBlock block = this.getDragonType().getInstance(HatchableDragonEggBlock.class, null);
            if (block == null) return ActionResult.FAIL;
            this.remove();
            this.world.setBlockState(this.getBlockPos(), block.getDefaultState());
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.amplitude > 0) --this.amplitude;
        else if (this.amplitude < 0) ++this.amplitude;
        if (this.world.isClient) {
            // spawn generic particles
            DragonType type = this.getDragonType();
            double px = getX() + (this.random.nextDouble() - 0.5);
            double py = getY() + (this.random.nextDouble() - 0.3);
            double pz = getZ() + (this.random.nextDouble() - 0.5);
            double ox = (this.random.nextDouble() - 0.5) * 2;
            double oy = (this.random.nextDouble() - 0.3) * 2;
            double oz = (this.random.nextDouble() - 0.5) * 2;
            this.world.addParticle(type.eggParticle, px, py, pz, ox, oy, oz);
            if ((this.age & 1) == 0 && type != DragonTypes.ENDER) {
                int color = type.color;
                this.world.addParticle(new DustParticleEffect(getColor(color, 2), getColor(color, 1), getColor(color, 0), 1.0F), px, py + 0.8, pz, ox, oy, oz);
            }
            return;
        }
        // play the egg shake animation based on the time the eggs take to hatch
        if (++this.age > EGG_SHAKE_THRESHOLD && this.amplitude == 0) {
            float progress = (float) this.age / MIN_HATCHING_TIME;
            // wait until the egg is nearly hatched
            float chance = (progress - EGG_SHAKE_PROCESS_THRESHOLD) / EGG_SHAKE_BASE_CHANCE * (1 - EGG_SHAKE_PROCESS_THRESHOLD);
            if (this.age >= MIN_HATCHING_TIME && this.random.nextFloat() * 2 < chance) {
                this.hatch();
                return;
            }
            if (this.random.nextFloat() < chance) {
                final PacketByteBuf buffer = PacketByteBufs.create().writeVarInt(this.getEntityId());
                buffer.writeFloat(this.rotationAxis = this.random.nextFloat() * 2F);
                buffer.writeVarInt(this.amplitude = this.random.nextBoolean() ? 10 : 20);
                final boolean flag = progress > EGG_CRACK_PROCESS_THRESHOLD;
                buffer.writeBoolean(flag);
                if (flag) this.spawnScales(1);
                for (ServerPlayerEntity player : PlayerLookup.tracking(this))
                    ServerPlayNetworking.send(player, DMPacketHandler.SHAKE_DRAGON_EGG_PACKET_ID, buffer);
            }
        }
    }

    @Override
    protected Text getDefaultName() {
        return this.getDragonType().getFormattedName("entity.dragonmounts.dragon_egg.name");
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || this.getDragonType().isInvulnerableTo(source);
    }

    @Override
    protected boolean canClimb() {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public void pushAwayFrom(Entity entity) {}

    @Override
    public void addVelocity(double x, double y, double z) {}

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public float getRotationAxis() {
        return this.rotationAxis;
    }

    public int getAmplitude() {
        return this.amplitude;
    }

    public BlockState handlePacket(float axis, int amplitude) {
        this.rotationAxis = axis;
        this.amplitude = amplitude;
        return this.getDragonType().getInstance(HatchableDragonEggBlock.class, DMBlocks.ENDER_DRAGON_EGG).getDefaultState();
    }

    public void setDragonType(DragonType type, boolean resetHealth) {
        AttributeContainer manager = this.getAttributes();
        manager.removeModifiers(this.getDragonType().attributes);
        this.dataTracker.set(DATA_DRAGON_TYPE, type);
        manager.addTemporaryModifiers(type.attributes);
        if (resetHealth) {
            EntityAttributeInstance health = this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
            if (health != null) {
                this.setHealth((float) health.getValue());
            }
        }
    }

    @Override
    public void setDragonType(DragonType type) {
        this.setDragonType(type, false);
    }

    @Override
    public DragonType getDragonType() {
        return this.dataTracker.get(DATA_DRAGON_TYPE);
    }
}
