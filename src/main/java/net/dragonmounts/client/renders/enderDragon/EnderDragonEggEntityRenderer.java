package net.dragonmounts.client.renders.enderDragon;

import net.dragonmounts.client.models.DragonEggEntityModel;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class EnderDragonEggEntityRenderer extends MobEntityRenderer<AetherDragonEggEntity, DragonEggEntityModel<AetherDragonEggEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/eggs/aether_egg.png");

    public EnderDragonEggEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonEggEntityModel<>(), 0.5f);
    }

    @Override
    public Identifier getTexture(AetherDragonEggEntity entity) {
        return TEXTURE;
    }
}