package net.dragonmounts.client.renders.skeletonDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.SkeletonDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SkeletonDragonEntityRenderer extends MobEntityRenderer<SkeletonDragonEntity, DragonDefaultModel<SkeletonDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/skeleton_dragon/skeleton_dragon.png");

    public SkeletonDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(SkeletonDragonEntity entity) {
        return TEXTURE;
    }
}
