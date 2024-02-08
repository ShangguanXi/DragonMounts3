package net.dragonmounts.client.gui;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.List;

public interface IWrappedTooltipRenderer {
    default void forge$renderWrappedTooltip(MatrixStack matrices, List<? extends Text> raw, int x, int y) {}
}
