package net.dragonmounts.api;

import net.dragonmounts.capability.ArmorEffectManager;
import net.dragonmounts.capability.IArmorEffectManager;
import net.dragonmounts.registry.CooldownCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

import static net.dragonmounts.util.TimeUtil.formatAsFloat;
import static net.minecraft.util.Util.createTranslationKey;

public interface IDragonScaleArmorEffect extends IArmorEffect {
    default void appendTriggerInfo(ItemStack stack, World world, List<Text> components) {
        components.add(new TranslatableText("tooltip.dragonmounts.armor_effect_piece_4"));
    }

    default void appendHoverText(ItemStack stack, World world, List<Text> components) {}

    class Advanced extends CooldownCategory implements IDragonScaleArmorEffect {
        public final int cooldown;
        private String description;

        public Advanced(Identifier identifier, int cooldown) {
            super(identifier);
            this.cooldown = cooldown;
        }

        protected String getOrCreateDescription() {
            if (this.description == null)
                this.description = createTranslationKey("tooltip.armor_effect", this.identifier);
            return this.description;
        }

        protected String getDescription() {
            return this.getOrCreateDescription();
        }

        public void appendCooldownInfo(ItemStack stack, World world, List<Text> components) {
            components.add(new TranslatableText(this.getDescription()));
            int value = ArmorEffectManager.getLocalCooldown(this);
            if (value > 0)
                components.add(new TranslatableText("tooltip.dragonmounts.armor_effect_remaining_cooldown", formatAsFloat(value)));
            else if (this.cooldown > 0)
                components.add(new TranslatableText("tooltip.dragonmounts.armor_effect_cooldown", formatAsFloat(this.cooldown)));
        }

        @Override
        public void appendHoverText(ItemStack stack, World world, List<Text> components) {
            components.add(LiteralText.EMPTY);
            this.appendTriggerInfo(stack, world, components);
            this.appendCooldownInfo(stack, world, components);
        }

        @Override
        public boolean activate(IArmorEffectManager manager, PlayerEntity player, int level) {
            return level > 3;
        }
    }
}
