package net.dragonmounts.client.renders.enderDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.EnderDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class EnderDragonEntityRenderer extends MobEntityRenderer<EnderDragonEntity, DragonDefaultModel<EnderDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/ender_dragon/ender_dragon.png");

    public EnderDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(EnderDragonEntity entity) {
        return TEXTURE;
    }
}
