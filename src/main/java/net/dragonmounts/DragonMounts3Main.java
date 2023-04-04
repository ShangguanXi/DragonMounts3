package net.dragonmounts;

import net.dragonmounts.blocks.DragonEggBlocks;
import net.dragonmounts.entities.DragonEggs;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.dragonmounts.items.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DragonMounts3Main implements ModInitializer {

    public void onInitialize() {
        DragonEggBlocks.registerDragonEggBlocks();
        DragonScalesItems.registerItems();
        DragonSwordItems.registerItems();
        DragonShovelItems.registerItems();
        DragonPickaxeItems.registerItems();
        DragonAxeItems.registerItems();
        DragonHoeItems.registerItems();
        DragonArmorItems.registerItems();
        DragonBowItems.registerItems();
        DragonShieldItems.registerItems();
        DragonEggs.registerEntityAttributes();

    }
}
