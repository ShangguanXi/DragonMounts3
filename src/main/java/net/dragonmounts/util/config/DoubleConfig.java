package net.dragonmounts.util.config;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.dragonmounts.DragonMountsConfig;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static net.minecraft.util.math.MathHelper.clamp;

public class DoubleConfig extends AbstractConfig {
    private static final double MIN_DOUBLE = -Double.MAX_VALUE;
    public final double defaultValue;
    public final double min;
    public final double max;
    protected double backup;
    protected double value;

    public DoubleConfig(String key, double init) {
        this(key, init, MIN_DOUBLE, Double.MAX_VALUE);
    }

    public DoubleConfig(String key, String display, double init) {
        this(key, display, init, MIN_DOUBLE, Double.MAX_VALUE);
    }

    public DoubleConfig(String key, double init, double min, double max) {
        super(key);
        this.min = min;
        this.max = max;
        this.defaultValue = this.value = this.backup = clamp(init, min, max);
    }

    public DoubleConfig(String key, String display, double init, double min, double max) {
        super(key, display);
        this.min = min;
        this.max = max;
        this.defaultValue = this.value = this.backup = clamp(init, min, max);
    }

    public void set(double value) {
        this.value = clamp(value, this.min, this.max);
    }

    public double get() {
        return this.value;
    }

    @Override
    public void read(NbtCompound compound) {
        if (compound.contains(this.key))
            this.backup = this.value = clamp(compound.getDouble(this.key), this.min, this.max);
    }

    @Override
    public void save(NbtCompound compound) {
        if (this.backup != this.value) {
            if (this.defaultValue != this.value) compound.putDouble(this.key, this.backup = this.value);
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
        this.set(DoubleArgumentType.getDouble(context, "value"));
        context.getSource().sendFeedback(new TranslatableText("commands.dragonmounts.config.set", this.display, this.get()), true);
        DragonMountsConfig.SERVER.save();
        return 1;
    }

    public LiteralArgumentBuilder<ServerCommandSource> generateCommand(double min, double max) {
        return CommandManager.literal(this.display).executes(this::get).then(CommandManager.argument("value", DoubleArgumentType.doubleArg(min, max)).executes(this::set));
    }

    @Override
    public final LiteralArgumentBuilder<ServerCommandSource> generateCommand() {
        return this.generateCommand(this.min, this.max);
    }
}
