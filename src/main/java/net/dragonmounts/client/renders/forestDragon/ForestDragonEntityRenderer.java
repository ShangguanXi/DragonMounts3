package net.dragonmounts.client.renders.forestDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.ForestDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ForestDragonEntityRenderer extends MobEntityRenderer<ForestDragonEntity, DragonDefaultModel<ForestDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/forest_dragon/forest_dragon.png");

    public ForestDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(ForestDragonEntity entity) {
        return TEXTURE;
    }
}
