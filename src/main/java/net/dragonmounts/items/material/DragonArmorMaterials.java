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
    AetherArmor("aether", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.aether_dragonscales)),
    EnchantArmor("enchant", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.enchant_dragonscales)),
    EnderArmor("ender", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.ender_dragonscales)),
    FireArmor("fire", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.fire_dragonscales)),
    ForestArmor("forest", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.forest_dragonscales)),
    IceArmor("ice", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.ice_dragonscales)),
    MoonlightArmor("moonlight", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.moonlight_dragonscales)),
    NetherArmor("nether", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.nether_dragonscales)),
    SculkArmor("sculk", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.sculk_dragonscales)),
    StormArmor("storm", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.storm_dragonscales)),
    SunlightArmor("sunlight", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.sunlight_dragonscales)),
    TerraArmor("terra", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.terra_dragonscales)),
    WaterArmor("water", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.water_dragonscales)),
    ZombieArmor("zombie", 55, new int[]{4, 7, 8, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F, 0.0F, () -> Ingredient.ofItems(DragonScalesItems.zombie_dragonscales)),
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
