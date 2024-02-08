package net.dragonmounts.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.dragonmounts.capability.IArmorEffectManager.Provider;
import net.dragonmounts.registry.CooldownCategory;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;

import java.util.Collection;

import static net.dragonmounts.command.DMCommand.HAS_PERMISSION_LEVEL_3;

public class CooldownCommand {
    public static ArgumentBuilder<ServerCommandSource, ?> register() {
        RequiredArgumentBuilder<ServerCommandSource, EntitySelector> single = CommandManager.argument("player", EntityArgumentType.player());
        RequiredArgumentBuilder<ServerCommandSource, EntitySelector> multiple = CommandManager.argument("players", EntityArgumentType.players());
        for (CooldownCategory category : CooldownCategory.REGISTRY) {
            final String identifier = category.identifier.toString();
            single.then(CommandManager.literal(identifier).executes(context -> get(context.getSource(), EntityArgumentType.getPlayer(context, "player"), category))
                    .then(CommandManager.argument("value", IntegerArgumentType.integer(0)).executes(context -> set(context.getSource(), EntityArgumentType.getPlayer(context, "player"), category, IntegerArgumentType.getInteger(context, "value"))))
            );
            multiple.then(CommandManager.literal(identifier).executes(context -> get(context.getSource(), EntityArgumentType.getPlayers(context, "players"), category))
                    .then(CommandManager.argument("value", IntegerArgumentType.integer(0)).executes(context -> set(context.getSource(), EntityArgumentType.getPlayers(context, "players"), category, IntegerArgumentType.getInteger(context, "value"))))
            );
        }
        return CommandManager.literal("cooldown").requires(HAS_PERMISSION_LEVEL_3).then(single).then(multiple);
    }

    public static int get(ServerCommandSource source, ServerPlayerEntity player, CooldownCategory category) {
        source.sendFeedback(new TranslatableText("commands.dragonmounts.cooldown.get.success",
                player.getDisplayName(),
                category.identifier,
                ((Provider) player).dragonmounts$getManager().getCooldown(category)
        ), true);
        return 1;
    }

    public static int get(ServerCommandSource source, Collection<ServerPlayerEntity> players, CooldownCategory category) {
        int sum = 0;
        for (ServerPlayerEntity player : players) {
            source.sendFeedback(new TranslatableText("commands.dragonmounts.cooldown.get.success",
                    player.getDisplayName(),
                    category.identifier,
                    ((Provider) player).dragonmounts$getManager().getCooldown(category)
            ), true);
            ++sum;
        }
        if (sum == 0) {
            source.sendError(new TranslatableText("commands.dragonmounts.cooldown.get.failure"));
            return 0;
        }
        return sum;
    }

    public static int set(ServerCommandSource source, ServerPlayerEntity player, CooldownCategory category, int value) {
        ((Provider) player).dragonmounts$getManager().setCooldown(category, value);
        source.sendFeedback(new TranslatableText("commands.dragonmounts.cooldown.set.single", player.getDisplayName(), category.identifier, value), true);
        return 1;
    }

    public static int set(ServerCommandSource source, Collection<ServerPlayerEntity> players, CooldownCategory category, int value) {
        int sum = 0;
        for (ServerPlayerEntity player : players) {
            ((Provider) player).dragonmounts$getManager().setCooldown(category, value);
            ++sum;
        }
        if (sum == 0) {
            source.sendError(new TranslatableText("commands.dragonmounts.cooldown.set.failure"));
            return 0;
        }
        source.sendFeedback(new TranslatableText("commands.dragonmounts.cooldown.set.multiple", source, category.identifier, value), true);
        return sum;
    }
}
