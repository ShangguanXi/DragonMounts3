package net.dragonmounts.client.variant;

import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static net.dragonmounts.util.RenderStateAccessor.createGlowDecalRenderLayer;
import static net.dragonmounts.util.RenderStateAccessor.createGlowRenderLayer;

public class AgeableAppearance extends VariantAppearance {
    public final Identifier body;
    public final Identifier babyBody;
    public final RenderLayer bodyForShoulder;
    public final RenderLayer bodyForBlock;
    public final RenderLayer decal;
    public final RenderLayer babyDecal;
    public final RenderLayer glow;
    public final RenderLayer babyGlow;
    public final RenderLayer glowDecal;
    public final RenderLayer babyGlowDecal;
    public final boolean hasTailHorns;
    public final boolean hasSideTailScale;

    public AgeableAppearance(
            Identifier body,
            Identifier babyBody,
            Identifier babyGlow,
            Identifier glow,
            boolean hasTailHorns,
            boolean hasSideTailScale
    ) {
        super(1.6F);
        this.body = body;
        this.bodyForShoulder = RenderLayer.getEntityCutoutNoCull(babyBody);
        this.bodyForBlock = RenderLayer.getEntityCutoutNoCullZOffset(body);
        this.decal = RenderLayer.getEntityDecal(body);
        this.babyBody = babyBody;
        this.babyDecal = RenderLayer.getEntityDecal(babyBody);
        this.glow = createGlowRenderLayer(glow);
        this.glowDecal = createGlowDecalRenderLayer(glow);
        this.babyGlow = createGlowRenderLayer(babyGlow);
        this.babyGlowDecal = createGlowDecalRenderLayer(babyGlow);
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
        return dragon.isBaby() ? this.babyBody : this.body;
    }

    @Override
    public RenderLayer getGlow(TameableDragonEntity dragon) {
        return dragon.isBaby() ? this.babyGlow : this.glow;
    }

    @Override
    public RenderLayer getDecal(TameableDragonEntity dragon) {
        return dragon.isBaby() ? this.babyDecal : this.decal;
    }

    @Override
    public RenderLayer getGlowDecal(TameableDragonEntity dragon) {
        return dragon.isBaby() ? this.babyGlowDecal : this.glowDecal;
    }

    @Override
    public RenderLayer getBodyForShoulder() {
        return this.bodyForShoulder;
    }

    @Override
    public RenderLayer getGlowForShoulder() {
        return this.babyGlow;
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
