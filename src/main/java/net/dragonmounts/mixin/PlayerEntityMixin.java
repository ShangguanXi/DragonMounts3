package net.dragonmounts.mixin;

import net.dragonmounts.capability.ArmorEffectManager;
import net.dragonmounts.capability.IArmorEffectManager.Provider;
import net.dragonmounts.init.DMArmorEffects;
import net.dragonmounts.item.DragonScaleShieldItem;
import net.dragonmounts.network.DMPacketHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Consumer;

import static net.dragonmounts.capability.ArmorEffectManager.DATA_PARAMETER_KEY;
import static net.dragonmounts.util.EntityUtil.addOrMergeEffect;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements Provider {
    @Shadow
    public abstract void incrementStat(Stat<?> stat);

    @Shadow
    public abstract ItemCooldownManager getItemCooldownManager();

    @Unique
    private static final Consumer<LivingEntity> ON_SHIELD_BREAK = entity -> entity.sendToolBreakStatus(entity.getActiveHand());
    @Unique
    protected ArmorEffectManager manager = new ArmorEffectManager((PlayerEntity) (Object) this);

    private PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tickManager(CallbackInfo ci) {
        this.manager.tick();
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void saveCooldown(NbtCompound nbt, CallbackInfo info) {
        NbtCompound data = this.manager.saveNBT();
        if (data.isEmpty()) return;
        NbtCompound caps = nbt.getCompound("ForgeCaps");
        caps.put(DATA_PARAMETER_KEY, data);
        nbt.put("ForgeCaps", caps);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCooldown(NbtCompound nbt, CallbackInfo info) {
        this.manager.readNBT(nbt.getCompound("ForgeCaps").getCompound(DATA_PARAMETER_KEY));
    }

    @Inject(method = "damageShield", at = @At("HEAD"))
    public void damageDragonScaleShield(float amount, CallbackInfo info) {
        final Item item = this.activeItemStack.getItem();
        if (item instanceof DragonScaleShieldItem) {
            if (!this.world.isClient) this.incrementStat(Stats.USED.getOrCreateStat(item));
            if (amount >= 3.0F) {
                this.activeItemStack.damage(1 + MathHelper.floor(amount), this, ON_SHIELD_BREAK);
                if (this.activeItemStack.isEmpty()) {
                    this.activeItemStack = ItemStack.EMPTY;
                    if (this.getActiveHand() == Hand.OFF_HAND) this.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    else this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.world.random.nextFloat() * 0.4F);
                }
            }
        }
    }

    @Inject(method = "disableShield", at = @At("HEAD"), cancellable = true)
    public void disableDragonScaleShield(boolean sprinting, CallbackInfo info) {
        final Item item = this.activeItemStack.getItem();
        if (item instanceof DragonScaleShieldItem) {
            if (this.random.nextFloat() < (sprinting ? 1.0F : 0.25F + EnchantmentHelper.getEfficiency(this) * 0.05f)) {
                this.getItemCooldownManager().set(item, 100);
                this.clearActiveItem();
                this.world.sendEntityStatus(this, (byte) 30);
            }
            info.cancel();
        }
    }

    @Inject(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setHealth(F)V"))
    public void riposte(DamageSource source, float amount, CallbackInfo info) {
        if (this.world.isClient) return;//In fact, this.world.isClientSide -> false
        final boolean ice = this.manager.isActive(DMArmorEffects.ICE) && this.manager.getCooldown(DMArmorEffects.ICE) <= 0;
        final boolean nether = this.manager.isActive(DMArmorEffects.NETHER) && this.manager.getCooldown(DMArmorEffects.NETHER) <= 0;
        if (!ice && !nether) return;
        final List<Entity> entities = this.world.getOtherEntities(this, this.getBoundingBox().expand(5.0D), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);
        if (entities.isEmpty()) return;
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) entity;
                target.takeKnockback(0.4F, 1, 1);
                if (ice) {
                    addOrMergeEffect(target, StatusEffects.SLOWNESS, 200, 1, false, true, true);
                    entity.damage(DamageSource.GENERIC, 1F);
                }
            } else if (ice) entity.damage(DamageSource.GENERIC, 1F);
            if (nether) entity.setOnFireFor(10);
        }
        if (ice) this.manager.setCooldown(DMArmorEffects.ICE, DMArmorEffects.ICE.cooldown);
        if (nether) this.manager.setCooldown(DMArmorEffects.NETHER, DMArmorEffects.NETHER.cooldown);
        PacketByteBuf buffer = PacketByteBufs.create().writeVarInt(this.getEntityId()).writeVarInt((ice ? 0b01 : 0b00) | (nether ? 0b10 : 0b00));
        for (ServerPlayerEntity player : PlayerLookup.tracking(this))
            ServerPlayNetworking.send(player, DMPacketHandler.ARMOR_RIPOSTE_PACKET_ID, buffer);
        ServerPlayNetworking.send((ServerPlayerEntity) this.manager.player, DMPacketHandler.ARMOR_RIPOSTE_PACKET_ID, buffer);
    }

    @Override
    public ArmorEffectManager dragonMounts3_Fabric$getManager() {
        return this.manager;
    }
}
