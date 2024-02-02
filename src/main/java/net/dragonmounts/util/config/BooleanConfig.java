package net.dragonmounts.util.config;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.dragonmounts.DragonMountsConfig;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

public class BooleanConfig extends AbstractConfig {
    public final boolean defaultValue;
    protected boolean backup;
    protected boolean value;

    public BooleanConfig(String key, boolean init) {
        super(key);
        this.defaultValue = this.value = this.backup = init;
    }

    public BooleanConfig(String key, String display, boolean init) {
        super(key, display);
        this.defaultValue = this.value = this.backup = init;
    }

    public void set(boolean value) {
        this.value = value;
    }

    public boolean get() {
        return this.value;
    }

    @Override
    public void read(NbtCompound compound) {
        if (compound.contains(this.key))
            this.value = this.backup = compound.getBoolean(this.key);
    }

    @Override
    public void save(NbtCompound compound) {
        if (this.backup ^ this.value) {
            if (this.defaultValue ^ this.value) compound.putBoolean(this.key, this.backup = this.value);
            else compound.remove(this.key);
        }
    }

    @Override
    protected int get(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(new TranslatableText("commands.dragonmounts.config.query", this.display, this.get()), true);
        return 1;
    }

    @Override
    protected int set(CommandContext<ServerCommandSource> context) {
        this.set(BoolArgumentType.getBool(context, "value"));
        context.getSource().sendFeedback(new TranslatableText("commands.dragonmounts.config.set", this.display, this.get()), true);
        DragonMountsConfig.SERVER.save();
        return 1;
    }

    @Override
    public LiteralArgumentBuilder<ServerCommandSource> generateCommand() {
        return CommandManager.literal(this.display).executes(this::get).then(CommandManager.argument("value", BoolArgumentType.bool()).executes(this::set));
    }
}
