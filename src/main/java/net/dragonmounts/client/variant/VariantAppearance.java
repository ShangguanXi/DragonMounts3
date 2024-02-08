package net.dragonmounts.client.variant;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public abstract class VariantAppearance {
    public final static String TEXTURES_ROOT = "textures/entities/dragon/";
    public final static Identifier DEFAULT_CHEST = new Identifier(MOD_ID, TEXTURES_ROOT + "chest.png");
    public final static Identifier DEFAULT_SADDLE = new Identifier(MOD_ID, TEXTURES_ROOT + "saddle.png");
    public final static Identifier DEFAULT_DISSOLVE = new Identifier(MOD_ID, TEXTURES_ROOT + "dissolve.png");
    public final float positionScale;
    public final float renderScale;

    public VariantAppearance(float modelScale) {
        this.renderScale = modelScale;
        this.positionScale = modelScale / 16.0F;
    }

    public abstract boolean hasTailHorns(TameableDragonEntity dragon);

    public abstract boolean hasSideTailScale(TameableDragonEntity dragon);

    public abstract boolean hasTailHornsOnShoulder();

    public abstract boolean hasSideTailScaleOnShoulder();

    public abstract Identifier getBody(TameableDragonEntity dragon);

    public abstract RenderLayer getGlow(TameableDragonEntity dragon);

    public abstract RenderLayer getDecal(TameableDragonEntity dragon);

    public abstract RenderLayer getGlowDecal(TameableDragonEntity dragon);

    public abstract RenderLayer getBodyForShoulder();

    public abstract RenderLayer getGlowForShoulder();

    public abstract RenderLayer getBodyForBlock();

    public abstract RenderLayer getGlowForBlock();

    public Identifier getChest(TameableDragonEntity dragon) {
        return DEFAULT_CHEST;
    }

    public Identifier getSaddle(TameableDragonEntity dragon) {
        return DEFAULT_SADDLE;
    }

    public RenderLayer getDissolve(TameableDragonEntity dragon) {
        return RenderLayer.getEntityAlpha(DEFAULT_DISSOLVE, dragon.deathTime / dragon.getMaxDeathTime());
    }
}
