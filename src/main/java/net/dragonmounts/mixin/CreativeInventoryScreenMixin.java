package net.dragonmounts.mixin;

import net.dragonmounts.client.gui.IWrappedTooltipRenderer;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(CreativeInventoryScreen.class)
public abstract class CreativeInventoryScreenMixin implements IWrappedTooltipRenderer {
    @Redirect(
            method = "renderTooltip",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Ljava/util/List;II)V")
    )
    public void renderWrappedTooltip(CreativeInventoryScreen instance, MatrixStack matrices, List<Text> list, int x, int y) {
        if (!list.isEmpty()) this.forge$renderWrappedTooltip(matrices, list, x, y);
    }
}
