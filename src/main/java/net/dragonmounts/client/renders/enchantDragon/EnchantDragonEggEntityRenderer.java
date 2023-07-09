package net.dragonmounts.client.renders.enchantDragon;

import net.dragonmounts.client.models.DragonEggEntityModel;
import net.dragonmounts.entities.dragonEggs.AetherDragonEggEntity;
import net.dragonmounts.entities.dragonEggs.EnchantDragonEggEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class EnchantDragonEggEntityRenderer extends MobEntityRenderer<EnchantDragonEggEntity, DragonEggEntityModel<EnchantDragonEggEntity>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/eggs/enchant_dragon_egg.png");

    public EnchantDragonEggEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonEggEntityModel<>(), 0.5f);
    }

    @Override
    public Identifier getTexture(EnchantDragonEggEntity entity) {
        return TEXTURE;
    }
}
