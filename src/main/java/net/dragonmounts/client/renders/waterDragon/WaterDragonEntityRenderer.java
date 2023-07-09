package net.dragonmounts.client.renders.waterDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.WaterDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class WaterDragonEntityRenderer extends MobEntityRenderer<WaterDragonEntity, DragonDefaultModel<WaterDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/water_dragon/water_dragon.png");

    public WaterDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(WaterDragonEntity entity) {
        return TEXTURE;
    }
}
