package net.dragonmounts.client.renders.fireDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.FireDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FireDragonEntityRenderer extends MobEntityRenderer<FireDragonEntity, DragonDefaultModel<FireDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/fire_dragon/fire_dragon.png");

    public FireDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(FireDragonEntity entity) {
        return TEXTURE;
    }
}
