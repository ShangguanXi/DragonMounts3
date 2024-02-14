package net.dragonmounts.entity.dragon;

import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.MathHelper;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static net.dragonmounts.command.StageCommand.egg;
import static net.dragonmounts.command.StageCommand.set;
import static net.dragonmounts.util.TimeUtil.TICKS_PER_GAME_HOUR;

public enum DragonLifeStage implements StringIdentifiable {
    NEWBORN(48 * TICKS_PER_GAME_HOUR, 0.04F, 0.09F),
    INFANT(24 * TICKS_PER_GAME_HOUR, 0.10F, 0.18F),
    PREJUVENILE(32 * TICKS_PER_GAME_HOUR, 0.19F, 0.60F),
    JUVENILE(60 * TICKS_PER_GAME_HOUR, 0.61F, 0.99F),
    ADULT(0, 1.00F, 1.00F);
    public static final String DATA_PARAMETER_KEY = "LifeStage";
    public static final String EGG_TRANSLATION_KEY = "dragon.life_stage.egg";
    private static final DragonLifeStage[] VALUES = values();
    private static final Map<String, DragonLifeStage> BY_NAME = Arrays.stream(VALUES)
            .collect(Collectors.toMap(DragonLifeStage::asString, value -> value));
    public final int duration;
    private final float startSize;
    private final float endSize;
    private final String name;
    private final String text;

    DragonLifeStage(int duration, float startSize, float endSize) {
        this.duration = duration;
        this.startSize = startSize;
        this.endSize = endSize;
        this.name = this.name().toLowerCase();
        this.text = "dragon.life_stage." + this.name;
    }

    public Text getText() {
        return new TranslatableText(this.text);
    }

    @Override
    public String asString() {
        return this.name;
    }

    public static DragonLifeStage byId(int id) {
        return id < 0 || id >= VALUES.length ? DragonLifeStage.ADULT : VALUES[id];
    }

    public static DragonLifeStage byName(String name) {
        return BY_NAME.getOrDefault(name, ADULT);
    }

    public static float getSize(DragonLifeStage stage, int age) {
        return stage.duration == 0 ? 1.00F : MathHelper.lerp(Math.abs(age) / (float) stage.duration, stage.endSize, stage.startSize);
    }

    public static float getSizeAverage(DragonLifeStage stage) {
        return 0.5F * (stage.endSize + stage.startSize);
    }

    public static RequiredArgumentBuilder<ServerCommandSource, EntitySelector> applyValues(RequiredArgumentBuilder<ServerCommandSource, EntitySelector> builder) {
        builder.then(CommandManager.literal("egg").executes(context -> egg(context.getSource(), EntityArgumentType.getEntity(context, "target"))));
        for (DragonLifeStage stage : VALUES) {
            builder.then(CommandManager.literal(stage.name).executes(context -> set(context.getSource(), EntityArgumentType.getEntity(context, "target"), stage)));
        }
        return builder;
    }
}
