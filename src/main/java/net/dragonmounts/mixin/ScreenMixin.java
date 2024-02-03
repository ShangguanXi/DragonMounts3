package net.dragonmounts.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.dragonmounts.client.gui.IWrappedTooltipRenderer;
import net.minecraft.client.font.TextHandler;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Language;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractParentElement implements IWrappedTooltipRenderer {
    @Shadow
    public abstract List<Text> getTooltipFromItem(ItemStack stack);

    @Shadow
    protected TextRenderer textRenderer;

    @Shadow
    public int width;

    @Shadow
    public int height;

    @Inject(method = "renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/item/ItemStack;II)V", at = @At("HEAD"), cancellable = true)
    public void renderWrappedTooltip(MatrixStack matrices, ItemStack stack, int x, int y, CallbackInfo info) {
        final List<Text> raw = this.getTooltipFromItem(stack);
        if (!raw.isEmpty()) {
            this.dragonMounts3_Fabric$renderWrappedTooltip(matrices, raw, x, y);
            info.cancel();
        }
    }

    @Override
    public void dragonMounts3_Fabric$renderWrappedTooltip(MatrixStack matrices, List<? extends Text> raw, int x, int y) {
        ObjectArrayList<OrderedText> texts = new ObjectArrayList<>(raw.size());
        OrderedText temp;
        int textWidth = 0;
        int titleSize = 0;
        int textX = x + 12;
        for (Text text : raw) {
            texts.add(temp = text.asOrderedText());
            int width = this.textRenderer.getWidth(temp);
            if (width > textWidth) textWidth = width;
        }
        if (textX + textWidth + 4 > this.width) {
            textX = x - 16 - textWidth;
            if (textX < 4) {
                int _textWidth = 0;
                final boolean flag = x << 1 > this.width;
                final Language language = Language.getInstance();
                final TextHandler handler = this.textRenderer.getTextHandler();
                final ObjectArrayList<OrderedText> _texts = new ObjectArrayList<>();
                if (flag) textWidth = x - 20;
                else textWidth = this.width - x - 16;
                for (int i = 0, j; i < texts.size(); ++i) {
                    List<StringVisitable> lines = handler.wrapLines(raw.get(i), textWidth, Style.EMPTY);
                    if ((i == 0 ? titleSize = lines.size() : lines.size()) != 0) {
                        for (StringVisitable v : lines) {
                            _texts.add(temp = language.reorder(v));
                            if ((j = this.textRenderer.getWidth(temp)) > _textWidth) _textWidth = j;
                        }
                    } else _texts.add(texts.get(i));
                }
                textWidth = _textWidth;
                texts = _texts;
                if (flag) textX = x - textWidth - 16;
                else textX = x + 12;
            }
        }
        int textHeight = texts.size() > 1 ? texts.size() == titleSize ? titleSize * 10 - 2 : texts.size() * 10 : 8;
        int textY = y - 12;
        if (textY < 4) textY = 4;
        else if (textY + textHeight + 4 > this.height) textY = this.height - textHeight - 4;
        matrices.push();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(7, VertexFormats.POSITION_COLOR);
        Matrix4f matrix4f = matrices.peek().getModel();
        fillGradient(matrix4f, buffer, textX - 3, textY - 4, textX + textWidth + 3, textY - 3, 400, -267386864, -267386864);
        fillGradient(matrix4f, buffer, textX - 3, textY + textHeight + 3, textX + textWidth + 3, textY + textHeight + 4, 400, -267386864, -267386864);
        fillGradient(matrix4f, buffer, textX - 3, textY - 3, textX + textWidth + 3, textY + textHeight + 3, 400, -267386864, -267386864);
        fillGradient(matrix4f, buffer, textX - 4, textY - 3, textX - 3, textY + textHeight + 3, 400, -267386864, -267386864);
        fillGradient(matrix4f, buffer, textX + textWidth + 3, textY - 3, textX + textWidth + 4, textY + textHeight + 3, 400, -267386864, -267386864);
        fillGradient(matrix4f, buffer, textX - 3, textY - 2, textX - 2, textY + textHeight + 2, 400, 1347420415, 1344798847);
        fillGradient(matrix4f, buffer, textX + textWidth + 2, textY - 2, textX + textWidth + 3, textY + textHeight + 3 - 1, 400, 1347420415, 1344798847);
        fillGradient(matrix4f, buffer, textX - 3, textY - 3, textX + textWidth + 3, textY - 3 + 1, 400, 1347420415, 1347420415);
        fillGradient(matrix4f, buffer, textX - 3, textY + textHeight + 2, textX + textWidth + 3, textY + textHeight + 3, 400, 1344798847, 1344798847);
        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.shadeModel(7425);
        buffer.end();
        BufferRenderer.draw(buffer);
        RenderSystem.shadeModel(7424);
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
        VertexConsumerProvider.Immediate immediate = VertexConsumerProvider.immediate(buffer);
        matrices.translate(0.0, 0.0, 400.0);
        for (int i = 0; i < texts.size(); ++i, textY += 10) {
            if ((temp = texts.get(i)) != null)
                this.textRenderer.draw(temp, (float) textX, (float) textY, -1, true, matrix4f, immediate, false, 0, 15728880);
            if (i == 0) textY += 2;
        }
        immediate.draw();
        matrices.pop();
    }
}
