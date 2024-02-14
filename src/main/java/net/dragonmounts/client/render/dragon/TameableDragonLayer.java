package net.dragonmounts.client.render.dragon;

import net.dragonmounts.client.ClientDragonEntity;
import net.dragonmounts.client.model.dragon.DragonLegConfig;
import net.dragonmounts.client.model.dragon.DragonModel;
import net.dragonmounts.client.variant.VariantAppearance;
import net.dragonmounts.client.variant.VariantAppearances;
import net.dragonmounts.entity.dragon.DragonLifeStage;
import net.dragonmounts.init.DMEntities;
import net.dragonmounts.item.DragonArmorItem;
import net.dragonmounts.registry.DragonVariant;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

public class TameableDragonLayer extends FeatureRenderer<ClientDragonEntity, DragonModel> {
    public TameableDragonLayer(FeatureRendererContext<ClientDragonEntity, DragonModel> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider buffer, int light, ClientDragonEntity dragon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        DragonModel model = this.getContextModel();
        VariantAppearance appearance = dragon.getVariant().getAppearance(VariantAppearances.ENDER_FEMALE);
        if (dragon.deathTime > 0) {
            model.render(matrices, buffer.getBuffer(appearance.getDissolve(dragon)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            model.render(matrices, buffer.getBuffer(appearance.getDecal(dragon)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            model.render(matrices, buffer.getBuffer(appearance.getGlowDecal(dragon)), 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            return;
        }
        //saddle
        if (dragon.isSaddled()) {
            renderModel(model, appearance.getSaddle(dragon), matrices, buffer, light, dragon, 1.0F, 1.0F, 1.0F);
        }
        //chest
        if (dragon.hasChest()) {
            renderModel(model, appearance.getChest(dragon), matrices, buffer, light, dragon, 1.0F, 1.0F, 1.0F);
        }
        //armor
        ItemStack stack = dragon.getArmorStack();
        Item item = stack.getItem();
        if (item instanceof DragonArmorItem) {
            VertexConsumer builder = ItemRenderer.getArmorGlintConsumer(buffer, RenderLayer.getArmorCutoutNoCull(((DragonArmorItem) item).getDragonArmorTexture(stack, dragon)), false, stack.hasGlint());
            model.render(matrices, builder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        //glow
        model.render(matrices, buffer.getBuffer(appearance.getGlow(dragon)), 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static class Player {
        private static final DragonModel MODEL = new DragonModel();
        private static final Predicate<EntityType<?>> FILTER = type -> type == DMEntities.TAMEABLE_DRAGON;

        public static void render(PlayerEntity player, MatrixStack matrices, VertexConsumerProvider buffer, int light, boolean left) {
            NbtCompound tag = left ? player.getShoulderEntityLeft() : player.getShoulderEntityRight();
            EntityType.get(tag.getString("id")).filter(FILTER).ifPresent($ -> {
                DragonVariant variant = DragonVariant.REGISTRY.get(new Identifier(tag.getString(DragonVariant.DATA_PARAMETER_KEY)));
                DragonLifeStage stage = DragonLifeStage.byName(tag.getString(DragonLifeStage.DATA_PARAMETER_KEY));
                DragonLegConfig config = variant.type.isSkeleton ? DragonLegConfig.SKELETON : DragonLegConfig.DEFAULT;
                MODEL.foreRightLeg.load(config);
                MODEL.hindRightLeg.load(config);
                MODEL.foreLeftLeg.load(config);
                MODEL.hindLeftLeg.load(config);
                matrices.push();
                matrices.translate(left ? 0.4D : -0.4D, player.isInSneakingPose() ? -1.3D : -1.5D, 0.0D);
                MODEL.renderOnShoulder(
                        variant.getAppearance(VariantAppearances.ENDER_FEMALE),
                        matrices,
                        buffer,
                        light,
                        DragonLifeStage.getSize(stage, tag.getInt("Age"))
                );
                matrices.pop();
            });
        }
    }
}
