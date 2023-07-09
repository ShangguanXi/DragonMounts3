package net.dragonmounts.client.renders.zombieDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.ZombieDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ZombieDragonEntityRenderer extends MobEntityRenderer<ZombieDragonEntity, DragonDefaultModel<ZombieDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/zombie_dragon/zombie_dragon.png");

    public ZombieDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(ZombieDragonEntity entity) {
        return TEXTURE;
    }
}
