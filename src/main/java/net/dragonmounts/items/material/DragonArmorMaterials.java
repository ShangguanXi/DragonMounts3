package net.dragonmounts.items.material;

import net.dragonmounts.items.DragonAxeItems;
import net.dragonmounts.items.DragonScalesItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum DragonArmorMaterials implements ArmorMaterial{
    AetherArmor("aether", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.aether_dragon_scales)),
    EnchantArmor("enchant", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.enchant_dragon_scales)),
    EnderArmor("ender", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.ender_dragon_scales)),
    FireArmor("fire", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.fire_dragon_scales)),
    ForestArmor("forest", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.forest_dragon_scales)),
    IceArmor("ice", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.ice_dragon_scales)),
    MoonlightArmor("moonlight", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.moonlight_dragon_scales)),
    NetherArmor("nether", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.nether_dragon_scales)),
    SculkArmor("sculk", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.sculk_dragon_scales)),
    StormArmor("storm", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.storm_dragon_scales)),
    SunlightArmor("sunlight", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.sunlight_dragon_scales)),
    TerraArmor("terra", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.terra_dragon_scales)),
    WaterArmor("water", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.water_dragon_scales)),
    ZombieArmor("zombie", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.zombie_dragon_scales)),
    ;

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    DragonArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
