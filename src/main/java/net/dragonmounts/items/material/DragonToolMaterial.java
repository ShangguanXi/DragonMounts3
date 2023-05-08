package net.dragonmounts.items.material;

import net.dragonmounts.items.DragonScalesItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Lazy;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Supplier;

public enum DragonToolMaterial implements ToolMaterial {
    Aether("aether",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.aether_dragon_scales)),
    Enchant("enchant",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.enchant_dragon_scales)),
    Ender("ender",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.ender_dragon_scales)),
    Fire("fire",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.fire_dragon_scales)),
    Forest("forest",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.forest_dragon_scales)),
    Ice("ice",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.ice_dragon_scales)),
    Moonlight("moonlight",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.moonlight_dragon_scales)),
    Nether("nether",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.nether_dragon_scales)),
    Sculk("sculk",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.sculk_dragon_scales)),
    Storm("storm",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.storm_dragon_scales)),
    Sunlight("sunlight",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.sunlight_dragon_scales)),
    Terra("terra",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.terra_dragon_scales)),
    Water("water",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.water_dragon_scales)),
    Zombie("zombie",2700,2,8,4,22,() -> Ingredient.ofItems(DragonScalesItems.zombie_dragon_scales)),
    ;
    private final String name;
    private final int durability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredientSupplier;

    DragonToolMaterial(String name, int durability, float miningSpeedMultiplier, float attackDamage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durability = durability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
    }
    @Override
    public int getDurability() {
        return  this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }
    public String getName() {
        return this.name;
    }
}
