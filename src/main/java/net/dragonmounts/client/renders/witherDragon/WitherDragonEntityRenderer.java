package net.dragonmounts.client.renders.witherDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.WitherDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class WitherDragonEntityRenderer extends MobEntityRenderer<WitherDragonEntity, DragonDefaultModel<WitherDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/wither_dragon/wither_dragon.png");

    public WitherDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(WitherDragonEntity entity) {
        return TEXTURE;
    }
}
