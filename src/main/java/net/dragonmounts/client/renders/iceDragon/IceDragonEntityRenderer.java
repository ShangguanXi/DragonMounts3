package net.dragonmounts.client.renders.iceDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class IceDragonEntityRenderer extends MobEntityRenderer<AetherDragonEntity, DragonDefaultModel<AetherDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/aether_dragon/aether_dragon.png");

    public IceDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(AetherDragonEntity entity) {
        return TEXTURE;
    }
}
