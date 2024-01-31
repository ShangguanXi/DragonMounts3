package net.dragonmounts.item;

import net.dragonmounts.api.DragonScaleMaterial;
import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.registry.DragonType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

import static net.dragonmounts.DragonMounts.ITEM_TRANSLATION_KEY_PREFIX;

public class DragonScaleShieldItem extends ShieldItem implements IDragonTypified {
    private static final String TRANSLATION_KEY = ITEM_TRANSLATION_KEY_PREFIX + "dragon_scale_shield";

    protected DragonType type;

    protected final DragonScaleMaterial material;

    public DragonScaleShieldItem(DragonScaleMaterial material, Settings settings) {
        super(settings.maxDamageIfAbsent(material.getDurabilityForShield()));
        this.material = material;
        this.type = material.getDragonType();
    }

    public DragonScaleMaterial getMaterial() {
        return this.material;
    }

    @Override
    public int getEnchantability() {
        return this.material.getEnchantability();
    }

    @Override
    public boolean canRepair(ItemStack toRepair, ItemStack repair) {
        return this.material.getRepairIngredient().test(repair);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(this.type.getName());
    }

    @Override
    public String getTranslationKey() {
        return TRANSLATION_KEY;
    }

    @Override
    public DragonType getDragonType() {
        return this.type;
    }
}
