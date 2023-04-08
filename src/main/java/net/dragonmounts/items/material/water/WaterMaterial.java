package net.dragonmounts.items.material.water;

import net.dragonmounts.items.DragonScalesItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WaterMaterial implements ToolMaterial {

    public static final ToolMaterial INSTANCE = new WaterMaterial();

    @Override
    public int getDurability() {
        return 2700;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2;
    }

    @Override
    public float getAttackDamage() {
        return 8;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(DragonScalesItems.water_dragon_scales);
    }
}
