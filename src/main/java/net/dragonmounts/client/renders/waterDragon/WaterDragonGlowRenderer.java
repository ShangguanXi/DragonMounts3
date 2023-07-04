package net.dragonmounts.client.renders.waterDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class WaterDragonGlowRenderer<T extends LivingEntity> extends EyesFeatureRenderer<T, DragonDefaultModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("textures/entity/aether_dragon/aether_dragon_glow.png"));

    public WaterDragonGlowRenderer(FeatureRendererContext<T, DragonDefaultModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
