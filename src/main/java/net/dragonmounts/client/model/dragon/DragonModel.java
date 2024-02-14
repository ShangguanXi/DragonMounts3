package net.dragonmounts.client.model.dragon;

import net.dragonmounts.client.ClientDragonEntity;
import net.dragonmounts.client.variant.VariantAppearance;
import net.dragonmounts.util.ModelHolder;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;

public class DragonModel extends EntityModel<ClientDragonEntity> {
    private static final Matrix4f INVERSE_SCALE = Matrix4f.scale(-1, 1, 1);
    private static final Matrix3f INVERSE_NORMS = new Matrix3f(INVERSE_SCALE);
    public final DragonHeadModel.Part head;
    public final DragonNeckModelPart neck;
    public final DragonBodyModelPart body;
    public final DragonTailModelPart tail;
    public final DragonWingModelPart wing;
    public final ModelHolder<DragonLegConfig, DragonLegModelPart> foreLeftLeg;
    public final ModelHolder<DragonLegConfig, DragonLegModelPart> foreRightLeg;
    public final ModelHolder<DragonLegConfig, DragonLegModelPart> hindLeftLeg;
    public final ModelHolder<DragonLegConfig, DragonLegModelPart> hindRightLeg;

    public DragonModel() {
        this.textureWidth = this.textureHeight = 256;
        this.head = new DragonHeadModel.Part(this);
        this.neck = new DragonNeckModelPart(this);
        this.body = new DragonBodyModelPart(this);
        this.tail = new DragonTailModelPart(this);
        this.wing = new DragonWingModelPart(this);
        DragonLegConfig[] configs = new DragonLegConfig[]{DragonLegConfig.DEFAULT, DragonLegConfig.SKELETON};
        this.foreLeftLeg = new ModelHolder<>(type -> new DragonLegModelPart.Fore(this, true, type), configs);
        this.foreRightLeg = new ModelHolder<>(type -> new DragonLegModelPart.Fore(this, false, type), configs);
        this.hindLeftLeg = new ModelHolder<>(type -> new DragonLegModelPart.Hind(this, true, type), configs);
        this.hindRightLeg = new ModelHolder<>(type -> new DragonLegModelPart.Hind(this, false, type), configs);
    }

    @Override
    public void animateModel(ClientDragonEntity dragon, float limbSwing, float limbSwingAmount, float partialTick) {
        dragon.context.partialTicks = partialTick;
    }

    @Override
    public void setAngles(ClientDragonEntity dragon, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        dragon.context.animate(this, MathHelper.clamp(netHeadYaw, -120, 120), MathHelper.clamp(headPitch, -90, 90), limbSwing, limbSwingAmount * dragon.getScaleFactor());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer buffer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, buffer, light, overlay, red, green, blue, alpha);
        this.body.render(matrices, buffer, light, overlay, red, green, blue, alpha);
        this.neck.render(matrices, buffer, light, overlay, red, green, blue, alpha);
        this.tail.render(matrices, buffer, light, overlay, red, green, blue, alpha);
        renderWings(matrices, buffer, light, overlay, red, green, blue, alpha);
        renderLegs(matrices, buffer, light, overlay, red, green, blue, alpha);
    }

    public void renderOnShoulder(VariantAppearance appearance, MatrixStack matrices, VertexConsumerProvider buffer, int light, float size) {
        matrices.pop();
        float scale = size * appearance.renderScale;
        matrices.scale(-scale, -scale, scale);
        boolean hasSideTailScale = appearance.hasSideTailScaleOnShoulder();
        this.tail.leftScale.visible = this.tail.rightScale.visible = hasSideTailScale;
        this.tail.middleScale.visible = !hasSideTailScale;
        this.head.scaleX = this.head.scaleY = this.head.scaleZ = 0.92F;
        this.render(matrices, buffer.getBuffer(appearance.getBodyForShoulder()), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        this.render(matrices, buffer.getBuffer(appearance.getGlowForShoulder()), 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    public void renderWings(MatrixStack matrices, VertexConsumer buffer, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.scale(1.1F, 1.1F, 1.1F);
        this.wing.render(matrices, buffer, light, overlay, red, green, blue, alpha);
        matrices.peek().getModel().multiply(INVERSE_SCALE);
        matrices.peek().getNormal().multiply(INVERSE_NORMS);
        this.wing.render(matrices, buffer, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }

    protected void renderLegs(MatrixStack matrices, VertexConsumer buffer, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        this.foreRightLeg.getCurrent().render(matrices, buffer, light, overlay, red, green, blue, alpha);
        this.hindRightLeg.getCurrent().render(matrices, buffer, light, overlay, red, green, blue, alpha);
        matrices.peek().getModel().multiply(INVERSE_SCALE);
        matrices.peek().getNormal().multiply(INVERSE_NORMS);
        this.foreLeftLeg.getCurrent().render(matrices, buffer, light, overlay, red, green, blue, alpha);
        this.hindLeftLeg.getCurrent().render(matrices, buffer, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }
}
