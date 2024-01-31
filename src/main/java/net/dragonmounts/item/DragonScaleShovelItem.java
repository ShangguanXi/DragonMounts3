package net.dragonmounts.item;

import net.dragonmounts.api.DragonScaleTier;
import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.registry.DragonType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

import static net.dragonmounts.DragonMounts.ITEM_TRANSLATION_KEY_PREFIX;

public class DragonScaleShovelItem extends ShovelItem implements IDragonTypified {
    private static final String TRANSLATION_KEY = ITEM_TRANSLATION_KEY_PREFIX + "dragon_scale_shovel";

    protected DragonType type;

    public DragonScaleShovelItem(
            DragonScaleTier tier,
            float attackDamageModifier,
            float attackSpeedModifier,
            Settings settings
    ) {
        super(tier, attackDamageModifier, attackSpeedModifier, settings);
        this.type = tier.getDragonType();
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