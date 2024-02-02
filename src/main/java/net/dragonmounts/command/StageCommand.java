package net.dragonmounts.command;
/*
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;

import static net.dragonmounts.command.DMCommand.createClassCastException;
import static net.dragonmounts.entity.dragon.TameableDragonEntity.AGE_DATA_PARAMETER_KEY;

public class StageCommand {
    public static ArgumentBuilder<ServerCommandSource, ?> register() {
        return CommandManager.literal("stage").requires(HAS_PERMISSION_LEVEL_3).then(
                DragonLifeStage.applyValues(CommandManager.argument("target", EntityArgumentType.entity()))
                        .executes(context -> get(context.getSource(), EntityArgumentType.getEntity(context, "target")))
        );
    }

    public static int egg(ServerCommandSource source, Entity target) {
        if (target instanceof TameableDragonEntity) {
            ServerWorld world = source.getWorld();
            HatchableDragonEggEntity egg = new HatchableDragonEggEntity(world);
            TameableDragonEntity dragon = (TameableDragonEntity) target;
            dragon.inventory.dropContents(false, 1.25);
            NbtCompound compound = dragon.writeNbt(new NbtCompound());
            compound.remove(AGE_DATA_PARAMETER_KEY);
            egg.readNbt(compound);
            egg.setDragonType(dragon.getDragonType(), false);
            world.removeEntity(dragon, false);
            world.spawnEntity(egg);
        } else if (target instanceof HatchableDragonEggEntity) {
            ((HatchableDragonEggEntity) target).setAge(0);
        } else {
            source.sendError(createClassCastException(target, TameableDragonEntity.class));
            return 0;
        }
        source.sendSuccess(new TranslatableText("commands.dragonmounts.stage.set", target.getDisplayName(), new TranslatableText(EGG_TRANSLATION_KEY)), true);
        return 1;
    }

    public static int get(ServerCommandSource source, Entity target) {
        if (target instanceof TameableDragonEntity)
            source.sendSuccess(new TranslatableText("commands.dragonmounts.stage.get", target.getDisplayName(), ((TameableDragonEntity) target).getLifeStage().getText()), true);
        else if (target instanceof HatchableDragonEggEntity)
            source.sendSuccess(new TranslatableText("commands.dragonmounts.stage.get", target.getDisplayName(), new TranslatableText(EGG_TRANSLATION_KEY)), true);
        else {
            source.sendError(createClassCastException(target, TameableDragonEntity.class));
            return 0;
        }
        return 1;
    }

    public static int set(ServerCommandSource source, Entity target, DragonLifeStage stage) {
        if (target instanceof TameableDragonEntity) {
            TameableDragonEntity dragon = (TameableDragonEntity) target;
            dragon.setLifeStage(stage, true, true);
        } else if (target instanceof HatchableDragonEggEntity) {
            ServerWorld world = source.getWorld();
            TameableDragonEntity dragon = new TameableDragonEntity((HatchableDragonEggEntity) target, stage);
            world.removeEntity(target, false);
            world.spawnEntity(dragon);
        } else {
            source.sendError(createClassCastException(target, TameableDragonEntity.class));
            return 0;
        }
        source.sendFeedback(new TranslatableText("commands.dragonmounts.stage.set", target.getDisplayName(), stage.getText()), true);
        return 1;
    }
}*/
