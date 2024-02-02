package net.dragonmounts.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.block.HatchableDragonEggBlock;
import net.dragonmounts.init.DragonTypes;
import net.dragonmounts.registry.DragonType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.command.argument.BlockPosArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;

import java.util.Map;

import static net.dragonmounts.command.DMCommand.HAS_PERMISSION_LEVEL_3;
import static net.dragonmounts.command.DMCommand.createClassCastException;

public class TypeCommand {
    public abstract static class CommandHandler<A> {
        protected abstract A getArgument(CommandContext<ServerCommandSource> context) throws CommandSyntaxException;

        protected abstract int setType(CommandContext<ServerCommandSource> context, A argument, DragonType type);

        protected abstract int getType(CommandContext<ServerCommandSource> context, A argument);

        public <T> RequiredArgumentBuilder<ServerCommandSource, T> load(RequiredArgumentBuilder<ServerCommandSource, T> builder) {
            for (Map.Entry<RegistryKey<DragonType>, DragonType> entry : DragonType.REGISTRY.getEntries())
                builder.then(CommandManager.literal(entry.getKey().getValue().toString()).executes(context -> this.setType(context, this.getArgument(context), entry.getValue())));
            builder.executes(context -> this.getType(context, this.getArgument(context)));
            return builder;
        }
    }

    public static class BlockHandler extends CommandHandler<BlockPos> {
        @FunctionalInterface
        public interface Getter {
            DragonType get(Block block, ServerWorld level, BlockPos pos, BlockState state);
        }

        @FunctionalInterface
        public interface Setter {
            BlockState set(Block block, ServerWorld level, BlockPos pos, BlockState state, DragonType type);
        }

        public static final Getter GETTER_DRAGON_EEG = (block, level, pos, state) -> DragonTypes.ENDER;
        public static final Setter SETTER_DRAGON_EEG = (block, level, pos, state, type) -> {
            Block egg = type.getInstance(HatchableDragonEggBlock.class, null);
            return egg == null ? state : egg.getDefaultState();
        };

        private final Reference2ObjectOpenHashMap<Class<? extends Block>, Getter> getters = new Reference2ObjectOpenHashMap<>();
        private final Reference2ObjectOpenHashMap<Class<? extends Block>, Setter> setters = new Reference2ObjectOpenHashMap<>();

        @SuppressWarnings("UnusedReturnValue")
        public Getter bind(Class<? extends Block> clazz, Getter getter) {
            return getter == null ? this.getters.remove(clazz) : this.getters.put(clazz, getter);
        }

        @SuppressWarnings("UnusedReturnValue")
        public Setter bind(Class<? extends Block> clazz, Setter setter) {
            return setter == null ? this.setters.remove(clazz) : this.setters.put(clazz, setter);
        }

        @Override
        protected BlockPos getArgument(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
            return BlockPosArgumentType.getLoadedBlockPos(context, "pos");
        }

        @Override
        protected int setType(CommandContext<ServerCommandSource> context, BlockPos pos, DragonType type) {
            ServerCommandSource source = context.getSource();
            ServerWorld world = source.getWorld();
            BlockState original = world.getBlockState(pos);
            Block block = original.getBlock();
            Class<? extends Block> clazz = block.getClass();
            Setter setter = this.setters.get(clazz);
            if (setter != null) {
                BlockState state = setter.set(block, world, pos, original, type);
                if (state != original) {
                    world.setBlockState(pos, state);
                    source.sendFeedback(new TranslatableText("commands.dragonmounts.type.block.set", pos.getX(), pos.getY(), pos.getZ(), type.getName()), true);
                    return 1;
                }
            }
            source.sendError(new LiteralText("java.lang.NullPointerException: " + clazz.getName() + " has not bound to a handler"));
            return 0;
        }

        @Override
        protected int getType(CommandContext<ServerCommandSource> context, BlockPos pos) {
            ServerCommandSource source = context.getSource();
            ServerWorld world = source.getWorld();
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            Class<? extends Block> clazz = block.getClass();
            Getter getter = this.getters.get(clazz);
            if (getter != null) {
                DragonType type = getter.get(block, world, pos, state);
                if (type != null) {
                    source.sendFeedback(new TranslatableText("commands.dragonmounts.type.block.get", pos.getX(), pos.getY(), pos.getZ(), type.getName()), true);
                    return 1;
                }
            }
            if (block instanceof IDragonTypified) {
                source.sendFeedback(new TranslatableText("commands.dragonmounts.type.block.get", pos.getX(), pos.getY(), pos.getZ(), ((IDragonTypified) block).getDragonType().getName()), true);
                return 1;
            }
            source.sendError(createClassCastException(clazz, IDragonTypified.class));
            return 0;
        }
    }

    public static class EntityHandler extends CommandHandler<Entity> {
        @Override
        protected Entity getArgument(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
            return EntityArgumentType.getEntity(context, "target");
        }

        @Override
        protected int setType(CommandContext<ServerCommandSource> context, Entity entity, DragonType type) {
            ServerCommandSource source = context.getSource();
            if (entity instanceof IDragonTypified.Mutable) {
                ((IDragonTypified.Mutable) entity).setDragonType(type);
                source.sendFeedback(new TranslatableText("commands.dragonmounts.type.entity.set", entity.getDisplayName(), type.getName()), true);
                return 1;
            }
            source.sendError(createClassCastException(entity, IDragonTypified.Mutable.class));
            return 0;
        }

        @Override
        protected int getType(CommandContext<ServerCommandSource> context, Entity entity) {
            ServerCommandSource source = context.getSource();
            if (entity instanceof IDragonTypified) {
                source.sendFeedback(new TranslatableText("commands.dragonmounts.type.entity.get", entity.getDisplayName(), ((IDragonTypified) entity).getDragonType().getName()), true);
                return 1;
            }
            source.sendError(createClassCastException(entity, IDragonTypified.class));
            return 0;
        }
    }

    public static final BlockHandler BLOCK_HANDLER = new BlockHandler();
    public static final EntityHandler ENTITY_HANDLER = new EntityHandler();

    static {
        BLOCK_HANDLER.bind(DragonEggBlock.class, BlockHandler.GETTER_DRAGON_EEG);
        BLOCK_HANDLER.bind(DragonEggBlock.class, BlockHandler.SETTER_DRAGON_EEG);
        BLOCK_HANDLER.bind(HatchableDragonEggBlock.class, BlockHandler.SETTER_DRAGON_EEG);
    }

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("type").requires(HAS_PERMISSION_LEVEL_3)
                .then(CommandManager.literal("block").then(BLOCK_HANDLER.load(CommandManager.argument("pos", BlockPosArgumentType.blockPos()))))
                .then(CommandManager.literal("entity").then(ENTITY_HANDLER.load(CommandManager.argument("target", EntityArgumentType.entity()))));
    }
}
