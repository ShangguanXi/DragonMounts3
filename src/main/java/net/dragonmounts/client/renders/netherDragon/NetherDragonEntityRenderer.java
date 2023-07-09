package net.dragonmounts.client.renders.netherDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.NetherDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NetherDragonEntityRenderer extends MobEntityRenderer<NetherDragonEntity, DragonDefaultModel<NetherDragonEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/nether_dragon/nether_dragon.png");

    public NetherDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(NetherDragonEntity entity) {
        return TEXTURE;
    }
}
