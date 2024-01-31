package net.dragonmounts.registry;

import net.dragonmounts.api.IDragonTypified;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;

import java.util.Random;

import static it.unimi.dsi.fastutil.Arrays.MAX_ARRAY_SIZE;
import static net.dragonmounts.DragonMounts.MOD_ID;

public class DragonVariant implements IDragonTypified {
    public static final String DATA_PARAMETER_KEY = "Variant";
    public static final Identifier DEFAULT_KEY = new Identifier(MOD_ID, "ender_female");
    public static final DefaultedRegistry<DragonVariant> REGISTRY = FabricRegistryBuilder.createDefaulted(DragonVariant.class, new Identifier(MOD_ID, "dragon_variant"), DEFAULT_KEY).buildAndRegister();
    public static final TrackedDataHandler<DragonVariant> SERIALIZER = new TrackedDataHandler<DragonVariant>() {
        @Override
        public void write(PacketByteBuf buffer, DragonVariant value) {
            buffer.writeVarInt(REGISTRY.getRawId(value));
        }

        @Override
        public DragonVariant read(PacketByteBuf buffer) {
            return REGISTRY.get(buffer.readVarInt());
        }

        @Override
        public DragonVariant copy(DragonVariant value) {
            return value;
        }
    };

    public final DragonType type;
    public final Identifier identifier;
    private int index = -1;
    //private VariantAppearance appearance;

    public DragonVariant(Identifier identifier, DragonType type) {
        this.identifier = identifier;
        this.type = type;
        type.variants.register(this);
    }

    @Override
    public final DragonType getDragonType() {
        return this.type;
    }

    /*public VariantAppearance getAppearance(VariantAppearance defaultValue) {
        return this.appearance == null ? defaultValue : this.appearance;
    }

    @SuppressWarnings("UnusedReturnValue")
    public VariantAppearance setAppearance(VariantAppearance value) {
        VariantAppearance old = this.appearance;
        this.appearance = value;
        return old;
    }*/

    /**
     * Simplified {@link it.unimi.dsi.fastutil.objects.ReferenceArrayList}
     */
    public static final class Manager implements IDragonTypified {
        public static final int DEFAULT_INITIAL_CAPACITY = 8;
        public final DragonType type;
        private DragonVariant[] variants = {};
        private int size;

        public Manager(DragonType type) {
            this.type = type;
        }

        private void grow(int capacity) {
            if (capacity <= this.variants.length)
                return;
            if (this.variants.length > 0)
                capacity = (int) Math.max(Math.min((long) this.variants.length + (this.variants.length >> 1), MAX_ARRAY_SIZE), capacity);
            else if (capacity < DEFAULT_INITIAL_CAPACITY)
                capacity = DEFAULT_INITIAL_CAPACITY;
            final DragonVariant[] array = new DragonVariant[capacity];
            System.arraycopy(this.variants, 0, array, 0, size);
            this.variants = array;
            assert this.size <= this.variants.length;
        }

        @SuppressWarnings("UnusedReturnValue")
        private boolean add(final DragonVariant variant) {
            if (variant.type != this.type || variant.index >= 0) return false;
            this.grow(this.size + 1);
            variant.index = this.size;
            this.variants[this.size++] = variant;
            assert this.size <= this.variants.length;
            return true;
        }

        @SuppressWarnings("UnusedReturnValue")
        private boolean remove(final DragonVariant variant) {
            if (variant.type != this.type || variant.index < 0) return false;
            if (variant.index >= this.size)
                throw new IndexOutOfBoundsException("Index (" + variant.index + ") is greater than or equal to list size (" + this.size + ")");
            this.size--;
            if (variant.index != this.size) {
                System.arraycopy(this.variants, variant.index + 1, this.variants, variant.index, this.size - variant.index);
            }
            variant.index = -1;
            this.variants[this.size] = null;
            assert this.size <= this.variants.length;
            return true;
        }

        private void clear() {
            for (int i = 0; i < this.size; ++i) {
                this.variants[i].index = -1;
                this.variants[i] = null;
            }
            this.size = 0;
        }

        public DragonVariant draw(Random random, DragonVariant current) {
            switch (this.size) {
                case 0: return current;
                case 1: return this.variants[0];
            }
            if (current == null || current.type != this.type) {
                return this.variants[random.nextInt(this.size)];
            }
            if (this.size == 2) return this.variants[(current.index ^ 1) & 1];//current.index == 0 ? 1 : 0
            int index = random.nextInt(this.size - 1);
            return this.variants[index < current.index ? index : index + 1];
        }

        public int size() {
            return this.size;
        }

        @Override
        public DragonType getDragonType() {
            return this.type;
        }

        public void register(DragonVariant variant) {
            if (variant.type == this.type) this.add(Registry.register(REGISTRY, variant.identifier, variant));
        }
    }
}
