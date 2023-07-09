package net.dragonmounts.client.renders.iceDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.IceDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class IceDragonEntityRenderer extends MobEntityRenderer<IceDragonEntity, DragonDefaultModel<IceDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/ice_dragon/ice_dragon.png");

    public IceDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(IceDragonEntity entity) {
        return TEXTURE;
    }
}
