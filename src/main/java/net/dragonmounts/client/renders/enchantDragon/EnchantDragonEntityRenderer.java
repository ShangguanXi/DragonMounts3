package net.dragonmounts.client.renders.enchantDragon;

import net.dragonmounts.client.models.DragonDefaultModel;
import net.dragonmounts.entities.dragons.AetherDragonEntity;
import net.dragonmounts.entities.dragons.EnchantDragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

//public class EnchantDragonEntityRenderer extends MobEntityRenderer<AetherDragonEntity, DragonDefaultModel<AetherDragonEntity>> {
public class EnchantDragonEntityRenderer extends MobEntityRenderer<EnchantDragonEntity, DragonDefaultModel<EnchantDragonEntity>>{

    //private static final Identifier TEXTURE = new Identifier("textures/entity/aether_dragon/aether_dragon.png");
    private static final Identifier TEXTURE = new Identifier("textures/entity/enchant_dragon/enchant_dragon.png");

    public EnchantDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonDefaultModel<>(), 0.5f);
        //发光渲染 GlowRenderer
        //this.addFeature(new AetherDragonGlowRenderer<>(this));
    }

    @Override
    public Identifier getTexture(EnchantDragonEntity entity) {
        return TEXTURE;
    }
}
