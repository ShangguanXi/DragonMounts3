package net.dragonmounts.item;

import net.dragonmounts.api.DragonScaleTier;
import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.registry.DragonType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

import static net.dragonmounts.DragonMounts.ITEM_TRANSLATION_KEY_PREFIX;

public class DragonScaleBowItem extends BowItem implements IDragonTypified {
    private static final String TRANSLATION_KEY = ITEM_TRANSLATION_KEY_PREFIX + "dragon_scale_bow";

    protected DragonType type;

    protected final DragonScaleTier tier;

    public DragonScaleBowItem(DragonScaleTier tier, Settings settings) {
        super(settings.maxDamageIfAbsent((int) (tier.getDurability() * 0.25)));
        this.tier = tier;
        this.type = tier.getDragonType();
    }

    public DragonScaleTier getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantability() {
        return this.tier.getEnchantability();
    }

    @Override
    public boolean canRepair(ItemStack toRepair, ItemStack repair) {
        return this.tier.getRepairIngredient().test(repair);
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
