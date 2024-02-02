package net.dragonmounts.util.config;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.ServerCommandSource;

public abstract class AbstractConfig {
    public final String key;
    public final String display;

    public AbstractConfig(String key) {
        this.display = (this.key = key).toLowerCase();
    }

    public AbstractConfig(String key, String display) {
        this.key = key;
        this.display = display;
    }

    public abstract void read(NbtCompound compound);

    public abstract void save(NbtCompound compound);

    protected abstract int get(CommandContext<ServerCommandSource> context);

    protected abstract int set(CommandContext<ServerCommandSource> context);

    public abstract LiteralArgumentBuilder<ServerCommandSource> generateCommand();
}
