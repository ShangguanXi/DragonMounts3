package net.dragonmounts.registry;

import net.dragonmounts.entity.CarriageEntity;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;

import java.util.function.Supplier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public abstract class CarriageType {
    public static final Identifier DEFAULT_KEY = new Identifier(MOD_ID, "oak");
    public static final DefaultedRegistry<CarriageType> REGISTRY = FabricRegistryBuilder.createDefaulted(CarriageType.class, new Identifier(MOD_ID, "carriage_type"), DEFAULT_KEY).buildAndRegister();
    public static final TrackedDataHandler<CarriageType> SERIALIZER = new TrackedDataHandler<CarriageType>() {
        @Override
        public void write(PacketByteBuf buffer, CarriageType value) {
            buffer.writeVarInt(REGISTRY.getRawId(value));
        }

        @Override
        public CarriageType read(PacketByteBuf buffer) {
            return REGISTRY.get(buffer.readVarInt());
        }

        @Override
        public CarriageType copy(CarriageType value) {
            return value;
        }
    };

    public abstract Item getItem(CarriageEntity entity);

    public abstract Identifier getTexture(CarriageEntity entity);

    public static class Default extends CarriageType {
        public final Supplier<? extends Item> item;
        public final Identifier texture;

        public Default(Supplier<? extends Item> item, Identifier texture) {
            this.item = item;
            this.texture = texture;
        }

        @Override
        public Item getItem(CarriageEntity entity) {
            return this.item.get();
        }

        @Override
        public Identifier getTexture(CarriageEntity entity) {
            return this.texture;
        }
    }
}
