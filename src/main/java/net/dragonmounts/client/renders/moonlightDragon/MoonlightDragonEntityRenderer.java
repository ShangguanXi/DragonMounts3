package net.dragonmounts.client.renders.moonlightDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.MoonlightDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MoonlightDragonEntityRenderer extends MobEntityRenderer<MoonlightDragonEntity, DragonDefaultModel<MoonlightDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/moonlight_dragon/moonlight_dragon.png");

    public MoonlightDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(MoonlightDragonEntity entity) {
        return TEXTURE;
    }
}
