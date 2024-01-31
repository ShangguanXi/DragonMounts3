package net.dragonmounts.item;

import net.dragonmounts.api.IDragonTypified;
import net.dragonmounts.registry.DragonType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.dragonmounts.DragonMounts.ITEM_TRANSLATION_KEY_PREFIX;

public class DragonScalesItem extends Item implements IDragonTypified {
    private static final String TRANSLATION_KEY = ITEM_TRANSLATION_KEY_PREFIX + "dragon_scales";

    protected DragonType type;

    public DragonScalesItem(DragonType type, Settings settings) {
        super(settings);
        this.type = type;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
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
