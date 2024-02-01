package net.dragonmounts.client;

import net.dragonmounts.api.DragonScaleArmorSuit;
import net.dragonmounts.block.HatchableDragonEggBlock;
import net.dragonmounts.client.gui.DragonCoreScreen;
import net.dragonmounts.client.renders.DragonCoreRenderer;
import net.dragonmounts.client.renders.DragonEggRenderer;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.dragonmounts.init.DMBlockEntities;
import net.dragonmounts.init.DMBlocks;
import net.dragonmounts.init.DMEntities;
import net.dragonmounts.init.DMScreenHandlers;
import net.dragonmounts.item.DragonScaleBowItem;
import net.dragonmounts.item.DragonScaleShieldItem;
import net.dragonmounts.network.DMPacketHandler;
import net.dragonmounts.registry.DragonType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.player.ClientPickBlockGatherCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ArmorProviderExtensions;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

@Environment(EnvType.CLIENT)
public class DragonMountsClient implements ClientModInitializer {
    private static final ModelPredicateProvider DURATION = (stack, world, entity) -> entity == null ? 0.0F : entity.getActiveItem() != stack ? 0.0F : (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
    private static final ModelPredicateProvider IS_USING_ITEM = (stack, world, entity) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;

    @Override
    public void onInitializeClient() {
        ClientPickBlockGatherCallback.EVENT.register((player, result) -> {
            if (result.getType() == HitResult.Type.ENTITY) {
                Entity entity = ((EntityHitResult) result).getEntity();
                if (entity instanceof HatchableDragonEggEntity)
                    return new ItemStack(
                            ((HatchableDragonEggEntity) entity).getDragonType().getInstance(HatchableDragonEggBlock.class, DMBlocks.ENDER_DRAGON_EGG)
                    );
            }
            return ItemStack.EMPTY;
        });
        Identifier pull = new Identifier("pull");
        Identifier pulling = new Identifier("pulling");
        Identifier blocking = new Identifier("blocking");
        for (DragonType type : DragonType.REGISTRY) {
            DragonScaleBowItem bow = type.getInstance(DragonScaleBowItem.class, null);
            if (bow != null) {
                FabricModelPredicateProviderRegistry.register(bow, pull, DURATION);
                FabricModelPredicateProviderRegistry.register(bow, pulling, IS_USING_ITEM);
            }
            DragonScaleShieldItem shield = type.getInstance(DragonScaleShieldItem.class, null);
            if (shield != null) {
                FabricModelPredicateProviderRegistry.register(shield, blocking, IS_USING_ITEM);
            }
            DragonScaleArmorSuit suit = type.getInstance(DragonScaleArmorSuit.class, null);
            if (suit != null) {
                ArmorRenderingRegistry.TextureProvider provider = (entity, stack, slot, upper, suffix, texture) -> new Identifier(suit.material.type.identifier.getNamespace(), "textures/models/armor/" + suit.material.type.identifier.getPath() + "_layer_" + (upper ? 2 : 1) + (suffix == null ? "" : "_" + suffix) + ".png");
                ((ArmorProviderExtensions) suit.helmet).fabric_setArmorTextureProvider(provider);
                ((ArmorProviderExtensions) suit.chestplate).fabric_setArmorTextureProvider(provider);
                ((ArmorProviderExtensions) suit.leggings).fabric_setArmorTextureProvider(provider);
                ((ArmorProviderExtensions) suit.boots).fabric_setArmorTextureProvider(provider);
            }
        }
        BlockEntityRendererRegistry.INSTANCE.register(DMBlockEntities.DRAGON_CORE, DragonCoreRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(DMBlocks.DRAGON_CORE, DragonCoreRenderer.ITEM_RENDERER);
        EntityRendererRegistry.INSTANCE.register(DMEntities.HATCHABLE_DRAGON_EGG, (dispatcher, context) -> new DragonEggRenderer(dispatcher));
        ScreenRegistry.register(DMScreenHandlers.DRAGON_CORE, DragonCoreScreen::new);
        DMPacketHandler.init();
    }
}
