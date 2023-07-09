package net.dragonmounts.client.renders.sunlightDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.SunlightDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SunlightDragonEntityRenderer extends MobEntityRenderer<SunlightDragonEntity, DragonDefaultModel<SunlightDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/sunlight_dragon/sunlight_dragon.png");

    public SunlightDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(SunlightDragonEntity entity) {
        return TEXTURE;
    }
}
