package net.dragonmounts.client.render.dragon;

import net.dragonmounts.client.ClientDragonEntity;
import net.dragonmounts.client.model.dragon.DragonModel;
import net.dragonmounts.client.variant.VariantAppearances;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EndCrystalEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

import static net.minecraft.client.render.entity.EnderDragonEntityRenderer.renderCrystalBeam;


public class TameableDragonRenderer extends LivingEntityRenderer<ClientDragonEntity, DragonModel> {

    public TameableDragonRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new DragonModel(), 0);
        this.addFeature(new TameableDragonLayer(this));
    }

    @Override
    protected RenderLayer getRenderLayer(ClientDragonEntity dragon, boolean visible, boolean invisibleToClient, boolean glowing) {
        // During death, do not use the standard rendering and let the death layer handle it. Hacky, but better than mixins.
        return dragon.deathTime > 0 ? null : super.getRenderLayer(dragon, visible, invisibleToClient, glowing);
    }

    @Override
    protected void setupTransforms(ClientDragonEntity dragon, MatrixStack matrices, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupTransforms(dragon, matrices, ageInTicks, rotationYaw, partialTicks);
        float scale = dragon.getScaleFactor() * dragon.getVariant().getAppearance(VariantAppearances.ENDER_FEMALE).renderScale;
        matrices.scale(scale, scale, scale);
        this.shadowRadius = dragon.isBaby() ? 4 * scale : 2 * scale;
        matrices.translate(dragon.context.getModelOffsetX(), dragon.context.getModelOffsetY(), dragon.context.getModelOffsetZ());
        matrices.translate(0, 1.5, 0.5); // change rotation point
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(dragon.context.getModelPitch(partialTicks))); // rotate near the saddle so we can support the player
        matrices.translate(0, -1.5, -0.5); // restore rotation point
    }

    @Override
    public void render(ClientDragonEntity dragon, float entityYaw, float partialTicks, MatrixStack matrices, VertexConsumerProvider buffer, int light) {
        if (dragon.nearestCrystal != null) {
            matrices.push();
            float x = (float) (dragon.nearestCrystal.getX() - MathHelper.lerp(partialTicks, dragon.prevX, dragon.getX()));
            float y = (float) (dragon.nearestCrystal.getY() - MathHelper.lerp(partialTicks, dragon.prevY, dragon.getY()));
            float z = (float) (dragon.nearestCrystal.getZ() - MathHelper.lerp(partialTicks, dragon.prevZ, dragon.getZ()));
            renderCrystalBeam(x, y + EndCrystalEntityRenderer.getYOffset(dragon.nearestCrystal, partialTicks), z, partialTicks, dragon.timeUntilRegen, matrices, buffer, light);
            matrices.pop();
        }
        super.render(dragon, entityYaw, partialTicks, matrices, buffer, light);
    }

    @Override
    protected float getLyingAngle(ClientDragonEntity dragon) {
        // dragons dissolve during death, not flip.
        return 0;
    }

    @Override
    public Identifier getTexture(ClientDragonEntity dragon) {
        return dragon.getVariant().getAppearance(VariantAppearances.ENDER_FEMALE).getBody(dragon);
    }

    @Override
    protected boolean hasLabel(ClientDragonEntity dragon) {
        return (dragon.shouldRenderName() || dragon.hasCustomName() && dragon == this.dispatcher.targetedEntity) && super.hasLabel(dragon);
    }
}
