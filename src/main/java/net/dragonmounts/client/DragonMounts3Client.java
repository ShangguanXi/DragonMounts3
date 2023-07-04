package net.dragonmounts.client;

import net.dragonmounts.client.itemAnim.DragonBowAnim;
import net.dragonmounts.client.itemAnim.DragonShieldAnim;
import net.dragonmounts.entities.DragonEggs;
import net.dragonmounts.entities.Dragons;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DragonMounts3Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DragonEggs.registerEntityRenderer();
        DragonBowAnim.register();
        DragonShieldAnim.register();
        Dragons.registerEntityRenderer();
    }
}
