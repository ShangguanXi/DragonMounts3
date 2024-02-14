package net.dragonmounts.client;

import net.dragonmounts.api.DragonScaleArmorSuit;
import net.dragonmounts.block.HatchableDragonEggBlock;
import net.dragonmounts.client.gui.DragonCoreScreen;
import net.dragonmounts.client.render.DragonEggRenderer;
import net.dragonmounts.client.render.block.DragonCoreRenderer;
import net.dragonmounts.client.render.block.DragonHeadRenderer;
import net.dragonmounts.client.render.dragon.TameableDragonRenderer;
import net.dragonmounts.client.variant.VariantAppearances;
import net.dragonmounts.entity.dragon.HatchableDragonEggEntity;
import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.dragonmounts.init.*;
import net.dragonmounts.item.DragonScaleBowItem;
import net.dragonmounts.item.DragonScaleShieldItem;
import net.dragonmounts.network.ClientHandler;
import net.dragonmounts.registry.DragonType;
import net.dragonmounts.registry.DragonVariant;
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

import static net.dragonmounts.network.DMPackets.*;
import static net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.registerGlobalReceiver;

@Environment(EnvType.CLIENT)
public class DragonMountsClient implements ClientModInitializer {
    private static final ModelPredicateProvider DURATION = (stack, world, entity) -> entity == null ? 0.0F : entity.getActiveItem() != stack ? 0.0F : (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
    private static final ModelPredicateProvider IS_USING_ITEM = (stack, world, entity) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;

    @Override
    public void onInitializeClient() {
        VariantAppearances.bindAppearance();
        ClientPickBlockGatherCallback.EVENT.register((player, result) -> {
            if (result.getType() == HitResult.Type.ENTITY) {
                Entity entity = ((EntityHitResult) result).getEntity();
                if (entity instanceof HatchableDragonEggEntity) {
                    return new ItemStack(
                            ((HatchableDragonEggEntity) entity).getDragonType().getInstance(HatchableDragonEggBlock.class, DMBlocks.ENDER_DRAGON_EGG)
                    );
                }
                if (entity instanceof TameableDragonEntity) {
                    //TODO Dragon Spawn Egg
                }
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
        ScreenRegistry.register(DMScreenHandlers.DRAGON_CORE, DragonCoreScreen::new);
        BlockEntityRendererRegistry.INSTANCE.register(DMBlockEntities.DRAGON_CORE, DragonCoreRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(DMBlockEntities.DRAGON_HEAD, DragonHeadRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(DMBlocks.DRAGON_CORE, DragonCoreRenderer.ITEM_RENDERER);
        for (DragonVariant variant : DragonVariants.VALUES) {
            BuiltinItemRendererRegistry.INSTANCE.register(variant.headItem, DragonHeadRenderer.ITEM_RENDERER);
        }
        EntityRendererRegistry.INSTANCE.register(DMEntities.HATCHABLE_DRAGON_EGG, (dispatcher, context) -> new DragonEggRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(DMEntities.TAMEABLE_DRAGON, (dispatcher, context) -> new TameableDragonRenderer(dispatcher));
        registerPacketHandler();
    }

    private static void registerPacketHandler() {
        registerGlobalReceiver(ARMOR_RIPOSTE_PACKET_ID, ClientHandler::handleArmorRiposte);
        registerGlobalReceiver(INIT_COOLDOWN_PACKET_ID, ClientHandler::handleCooldownInit);
        registerGlobalReceiver(SYNC_COOLDOWN_PACKET_ID, ClientHandler::handleCooldownSync);
        registerGlobalReceiver(SHAKE_DRAGON_EGG_PACKET_ID, ClientHandler::handleEggShake);
        registerGlobalReceiver(SYNC_DRAGON_AGE_PACKET_ID, ClientHandler::handleAgeSync);
    }
}
