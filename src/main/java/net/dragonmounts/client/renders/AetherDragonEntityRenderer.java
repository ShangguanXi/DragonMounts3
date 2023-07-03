package net.dragonmounts.client.renders;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.client.models.DragonEggEntityModel;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AetherDragonEntityRenderer extends MobEntityRenderer<AetherDragonEntity, DragonDefaultModel<AetherDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/aether_dragon/aether_dragon.tga");

    public AetherDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
    }

    @Override
    public Identifier getTexture(AetherDragonEntity entity) {
        return TEXTURE;
    }
}
