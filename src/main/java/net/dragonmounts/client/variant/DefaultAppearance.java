package net.dragonmounts.client.variant;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static net.dragonmounts.util.RenderStateAccessor.createGlowDecalRenderLayer;
import static net.dragonmounts.util.RenderStateAccessor.createGlowRenderLayer;

public class DefaultAppearance extends VariantAppearance {
    public final Identifier body;
    public final RenderLayer bodyForShoulder;
    public final RenderLayer bodyForBlock;
    public final RenderLayer decal;
    public final RenderLayer glow;
    public final RenderLayer glowDecal;
    public final boolean hasTailHorns;
    public final boolean hasSideTailScale;

    public DefaultAppearance(Identifier body, Identifier glow, boolean hasTailHorns, boolean hasSideTailScale) {
        super(1.6F);
        this.body = body;
        this.bodyForShoulder = RenderLayer.getEntityCutoutNoCull(body);
        this.bodyForBlock = RenderLayer.getEntityCutoutNoCullZOffset(body);
        this.decal = RenderLayer.getEntityDecal(body);
        this.glow = createGlowRenderLayer(glow);
        this.glowDecal = createGlowDecalRenderLayer(glow);
        this.hasTailHorns = hasTailHorns;
        this.hasSideTailScale = hasSideTailScale;
    }

    @Override
    public boolean hasTailHorns(TameableDragonEntity dragon) {
        return this.hasTailHorns;
    }

    @Override
    public boolean hasSideTailScale(TameableDragonEntity dragon) {
        return this.hasSideTailScale;
    }

    @Override
    public boolean hasTailHornsOnShoulder() {
        return this.hasTailHorns;
    }

    @Override
    public boolean hasSideTailScaleOnShoulder() {
        return this.hasSideTailScale;
    }

    @Override
    public Identifier getBody(TameableDragonEntity dragon) {
        return this.body;
    }

    @Override
    public RenderLayer getGlow(TameableDragonEntity dragon) {
        return this.glow;
    }

    @Override
    public RenderLayer getDecal(TameableDragonEntity dragon) {
        return this.decal;
    }

    @Override
    public RenderLayer getGlowDecal(TameableDragonEntity dragon) {
        return this.glowDecal;
    }

    @Override
    public RenderLayer getBodyForShoulder() {
        return this.bodyForShoulder;
    }

    @Override
    public RenderLayer getGlowForShoulder() {
        return this.glow;
    }

    @Override
    public RenderLayer getBodyForBlock() {
        return this.bodyForBlock;
    }

    @Override
    public RenderLayer getGlowForBlock() {
        return this.glow;
    }
}
