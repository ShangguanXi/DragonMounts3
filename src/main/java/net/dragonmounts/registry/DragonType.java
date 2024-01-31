package net.dragonmounts.registry;

import com.google.common.collect.ImmutableMultimap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Style;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DragonType {
    public static final String DATA_PARAMETER_KEY = "DragonType";
    public static final Identifier DEFAULT_KEY = new Identifier(MOD_ID, "ender");
    public static final DefaultedRegistry<DragonType> REGISTRY = FabricRegistryBuilder.createDefaulted(DragonType.class, new Identifier(MOD_ID, "dragon_type"), DEFAULT_KEY).buildAndRegister();
    public static final TrackedDataHandler<DragonType> SERIALIZER = new TrackedDataHandler<DragonType>() {
        @Override
        public void write(PacketByteBuf buffer, DragonType value) {
            buffer.writeVarInt(REGISTRY.getRawId(value));
        }

        @Override
        public DragonType read(PacketByteBuf buffer) {
            return REGISTRY.get(buffer.readVarInt());
        }

        @Override
        public DragonType copy(DragonType value) {
            return value;
        }
    };
    public static final Predicate<HatchableDragonEggEntity> DEFAULT_ENVIRONMENT_PREDICATE = egg -> false;
    public static final BiFunction<Integer, Boolean, Vec3d> DEFAULT_PASSENGER_OFFSET = (index, sitting) -> {
        double yOffset = sitting ? 3.4 : 4.4;
        double yOffset2 = sitting ? 2.1 : 2.5; // maybe not needed
        // dragon position is the middle of the model, and the saddle is on
        // the shoulders, so move player forwards on Z axis relative to the
        // dragon's rotation to fix that
        switch (index) {
            case 1:
                return new Vec3d(0.6, yOffset, 0.1);
            case 2:
                return new Vec3d(-0.6, yOffset, 0.1);
            case 3:
                return new Vec3d(1.6, yOffset2, 0.2);
            case 4:
                return new Vec3d(-1.6, yOffset2, 0.2);
            default:
                return new Vec3d(0, yOffset, 2.2);
        }
    };

    public final int color;
    public final boolean convertible;
    public final boolean isSkeleton;
    public final Identifier identifier;
    public final ImmutableMultimap<EntityAttribute, EntityAttributeModifier> attributes;
    public final Predicate<HatchableDragonEggEntity> isHabitatEnvironment;
    public final BiFunction<Integer, Boolean, Vec3d> passengerOffset;
    public final ParticleEffect sneezeParticle;
    public final ParticleEffect eggParticle;
    public final DragonVariant.Manager variants = new DragonVariant.Manager(this);
    private final Reference2ObjectOpenHashMap<Class<?>, Object> map = new Reference2ObjectOpenHashMap<>();
    private final Style style;
    private final Set<DamageSource> immunities;
    private final Set<Block> blocks;
    private final List<RegistryKey<Biome>> biomes;
    private String translationKey;
    private Identifier lootTable;

    public DragonType(Identifier identifier, Properties properties) {
        Registry.register(REGISTRY, this.identifier = identifier, this);
        this.color = properties.color;
        this.convertible = properties.convertible;
        this.isSkeleton = properties.isSkeleton;
        this.style = Style.EMPTY.withColor(TextColor.fromRgb(this.color));
        this.attributes = properties.attributes.build();
        this.immunities = new HashSet<>(properties.immunities);
        this.blocks = new HashSet<>(properties.blocks);
        this.biomes = new ArrayList<>();
        this.biomes.addAll(properties.biomes);
        this.sneezeParticle = properties.sneezeParticle;
        this.eggParticle = properties.eggParticle;
        this.passengerOffset = properties.passengerOffset;
        this.isHabitatEnvironment = properties.isHabitatEnvironment;
    }

    public String getTranslationKey() {
        if (this.translationKey == null) {
            this.translationKey = Util.createTranslationKey("dragon_type", this.identifier);
        }
        return this.translationKey;
    }

    public TranslatableText getName() {
        return (TranslatableText) new TranslatableText(this.getTranslationKey()).fillStyle(this.style);
    }

    public TranslatableText getFormattedName(String pattern) {
        return new TranslatableText(pattern, new TranslatableText(this.getTranslationKey()));
    }

    public Identifier getLootTable() {
        if (this.lootTable == null) {
            this.lootTable = new Identifier(this.identifier.getNamespace(), "entities/dragon/" + this.identifier.getPath());
        }
        return this.lootTable;
    }

    public boolean isInvulnerableTo(DamageSource source) {
        return !this.immunities.isEmpty() && this.immunities.contains(source);
    }

    public boolean isHabitat(Block block) {
        return !this.blocks.isEmpty() && this.blocks.contains(block);
    }

    public boolean isHabitat(RegistryKey<Biome> biome) {
        return biome != null && !this.biomes.isEmpty() && this.biomes.contains(biome);
    }

    @SuppressWarnings("UnusedReturnValue")
    public <T> T bindInstance(Class<T> clazz, T instance) {
        return clazz.cast(this.map.put(clazz, instance));
    }

    public <T> T getInstance(Class<T> clazz, T defaultValue) {
        return clazz.cast(this.map.getOrDefault(clazz, defaultValue));
    }

    public static class Properties {
        protected static final UUID MODIFIER_UUID = UUID.fromString("12e4cc82-db6d-5676-afc5-86498f0f6464");
        public final ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> attributes = ImmutableMultimap.builder();
        public final int color;
        public final Set<DamageSource> immunities = new HashSet<>();
        public final Set<Block> blocks = new HashSet<>();
        public final Set<RegistryKey<Biome>> biomes = new HashSet<>();
        public boolean convertible = true;
        public boolean isSkeleton = false;
        public ParticleEffect sneezeParticle = ParticleTypes.LARGE_SMOKE;
        public ParticleEffect eggParticle = ParticleTypes.MYCELIUM;
        public BiFunction<Integer, Boolean, Vec3d> passengerOffset = DragonType.DEFAULT_PASSENGER_OFFSET;
        public Predicate<HatchableDragonEggEntity> isHabitatEnvironment = DragonType.DEFAULT_ENVIRONMENT_PREDICATE;

        public Properties(int color) {
            this.color = color;
            // ignore suffocation damage
            this.addImmunity(DamageSource.ON_FIRE).addImmunity(DamageSource.IN_FIRE)
                    .addImmunity(DamageSource.HOT_FLOOR)
                    .addImmunity(DamageSource.LAVA)
                    .addImmunity(DamageSource.DROWN)
                    .addImmunity(DamageSource.IN_WALL)
                    .addImmunity(DamageSource.CACTUS) // assume that cactus needles don't do much damage to animals with horned scales
                    .addImmunity(DamageSource.DRAGON_BREATH); // ignore damage from vanilla ender dragon. I kinda disabled this because it wouldn't make any sense, feel free to re enable
        }

        public Properties notConvertible() {
            this.convertible = false;
            return this;
        }

        public Properties isSkeleton() {
            this.isSkeleton = true;
            return this;
        }

        public Properties putAttributeModifier(EntityAttribute attribute, String name, double value, EntityAttributeModifier.Operation operation) {
            this.attributes.put(attribute, new EntityAttributeModifier(MODIFIER_UUID, name, value, operation));
            return this;
        }

        public Properties addImmunity(DamageSource source) {
            this.immunities.add(source);
            return this;
        }

        public Properties addHabitat(Block block) {
            this.blocks.add(block);
            return this;
        }

        public Properties addHabitat(RegistryKey<Biome> block) {
            this.biomes.add(block);
            return this;
        }

        public Properties setSneezeParticle(ParticleEffect particle) {
            this.sneezeParticle = particle;
            return this;
        }

        public Properties setEggParticle(ParticleEffect particle) {
            this.eggParticle = particle;
            return this;
        }

        public Properties setPassengerOffset(BiFunction<Integer, Boolean, Vec3d> passengerOffset) {
            this.passengerOffset = passengerOffset;
            return this;
        }

        public Properties setEnvironmentPredicate(Predicate<HatchableDragonEggEntity> predicate) {
            this.isHabitatEnvironment = predicate;
            return this;
        }
    }
}
