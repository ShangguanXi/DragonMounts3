package net.dragonmounts.client.renders.terraDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.TerraDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TerraDragonEntityRenderer extends MobEntityRenderer<TerraDragonEntity, DragonDefaultModel<TerraDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/terra_dragon/terra_dragon.png");

    public TerraDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(TerraDragonEntity entity) {
        return TEXTURE;
    }
}
