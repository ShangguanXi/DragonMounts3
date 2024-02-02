package net.dragonmounts.client.gui;

import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.util.OrderableTooltip;
import net.minecraft.text.LiteralText;
import net.minecraft.text.OrderedText;

import java.util.List;
import java.util.Optional;

public class ConfigSliderWidget extends SliderWidget implements OrderableTooltip {
    protected final LazySliderConfigOption option;

    public ConfigSliderWidget(int x, int y, int width, int height, LazySliderConfigOption option) {
        super(x, y, width, height, LiteralText.EMPTY, option.toPct(option.get()));
        this.option = option;
        this.updateMessage();
    }

    @Override
    protected void applyValue() {
        this.option.set(this.option.toValue(this.value));
    }

    @Override
    protected void updateMessage() {
        this.setMessage(this.option.getMessage());
    }

    @Override
    public Optional<List<OrderedText>> getOrderedTooltip() {
        return this.option.getTooltip();
    }
}
