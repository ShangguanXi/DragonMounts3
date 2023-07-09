package net.dragonmounts.client.renders.stormDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.StormDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class StormDragonEntityRenderer extends MobEntityRenderer<StormDragonEntity, DragonDefaultModel<StormDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/storm_dragon/storm_dragon.png");

    public StormDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(StormDragonEntity entity) {
        return TEXTURE;
    }
}
