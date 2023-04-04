package net.dragonmounts.client;

import net.dragonmounts.DragonMounts3Main;
import net.dragonmounts.client.itemAnim.DragonBowAnim;
import net.dragonmounts.client.itemAnim.DragonShieldAnim;
import net.dragonmounts.client.models.DragonEggEntityModel;
import net.dragonmounts.client.renders.AetherDragonEggEntityRenderer;
import net.dragonmounts.entities.DragonEggs;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;

@Environment(EnvType.CLIENT)
public class DragonMounts3Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DragonEggs.registerEntityRenderer();
        DragonBowAnim.register();
        DragonShieldAnim.register();
    }
}
