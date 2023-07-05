package net.dragonmounts;

import net.dragonmounts.blocks.DragonEggBlocks;
import net.dragonmounts.entities.DragonEggs;
import net.dragonmounts.entities.Dragons;
import net.dragonmounts.items.*;
import net.fabricmc.api.ModInitializer;

public class DragonMounts3Main implements ModInitializer {

    public void onInitialize() {
        DragonEggBlocks.registerDragonEggBlocks();
        DragonNormalItems.registerItems();
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
        Dragons.registerEntityAttributes();

    }
}
