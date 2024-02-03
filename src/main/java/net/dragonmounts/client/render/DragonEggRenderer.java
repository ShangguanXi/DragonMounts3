package net.dragonmounts.client.render;

import net.dragonmounts.block.HatchableDragonEggBlock;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.dragonmounts.init.DMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Quaternion;

import java.util.Random;

/**
 * @see net.minecraft.client.render.entity.FallingBlockEntityRenderer
 */
public class DragonEggRenderer extends EntityRenderer<HatchableDragonEggEntity> {
    public DragonEggRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(HatchableDragonEggEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider vertex, int packedLight) {
        BlockState state = entity.getDragonType().getInstance(HatchableDragonEggBlock.class, DMBlocks.ENDER_DRAGON_EGG).getDefaultState();
        BlockPos pos = new BlockPos(entity.getX(), entity.getBoundingBox().maxY, entity.getZ());
        matrixStack.push();
        float axis = entity.getRotationAxis();
        float angle = entity.getAmplitude();
        if (angle != 0) {
            angle = (float) (Math.sin(angle - partialTicks) * Math.PI / 45F);//... * 8 / 360
            double temp = Math.sin(angle);
            matrixStack.multiply(new Quaternion((float) (Math.cos(axis) * temp), 0F, (float) (Math.sin(axis) * temp), (float) (Math.cos(angle))));
                /*It is equivalent (at least assuming so) to:
                matrixStack.mulPose(new Vector3f((float)Math.cos(axis), 0, (float)Math.sin(axis)).rotationDegrees((float) (Math.sin(entity.getAmplitude() - partialTicks) * 8F)));
                */
        }
        matrixStack.translate(-0.5D, 0.0D, -0.5D);
        BlockRenderManager manager = MinecraftClient.getInstance().getBlockRenderManager();
        manager.getModelRenderer().render(entity.world, manager.getModel(state), state, pos, matrixStack, vertex.getBuffer(RenderLayers.getMovingBlockLayer(state)), false, new Random(), state.getRenderingSeed(entity.getBlockPos()), OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(entity, entityYaw, partialTicks, matrixStack, vertex, packedLight);
    }

    @Override
    public Identifier getTexture(HatchableDragonEggEntity entity) {
        return PlayerScreenHandler.BLOCK_ATLAS_TEXTURE;
    }
}
