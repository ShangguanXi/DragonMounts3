package net.dragonmounts.client.models;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class DragonEggEntityModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart bone;

    public DragonEggEntityModel() {
        super();
        textureWidth = 80;
        textureHeight = 80;
        bone = new ModelPart(this);
        bone.setPivot(0.0F, 16.0F, 0.0F);
        bone.setTextureOffset(0, 0).addCuboid(-2.0F, -8.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(43, 12).addCuboid(-3.0F, -7.0F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
        bone.setTextureOffset(0, 7).addCuboid(-5.0F, -5.0F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);
        bone.setTextureOffset(0, 19).addCuboid(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);
        bone.setTextureOffset(0, 34).addCuboid(-7.0F, 0.0F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);
        bone.setTextureOffset(0, 53).addCuboid(-6.0F, 5.0F, -6.0F, 12.0F, 2.0F, 12.0F, 0.0F, false);
        bone.setTextureOffset(0, 67).addCuboid(-5.0F, 7.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
