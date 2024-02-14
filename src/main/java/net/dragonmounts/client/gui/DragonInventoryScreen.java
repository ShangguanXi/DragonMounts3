package net.dragonmounts.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dragonmounts.entity.dragon.TameableDragonEntity;
import net.dragonmounts.inventory.DragonInventoryScreenHandler;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

/**
 * @see net.minecraft.client.gui.screen.ingame.HorseScreen
 */
public class DragonInventoryScreen extends AbstractInventoryScreen<DragonInventoryScreenHandler> {
    private static final Identifier TEXTURE_LOCATION = new Identifier(MOD_ID, "textures/gui/dragon.png");

    public DragonInventoryScreen(DragonInventoryScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title);
        this.passEvents = false;
        this.backgroundHeight = 224;
        this.playerInventoryTitleY = 131;//224 - 94 + 1
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float ticks) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, ticks);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrixStack, float ticks, int x, int y) {
        //noinspection DataFlowIssue
        this.client.getTextureManager().bindTexture(TEXTURE_LOCATION);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        int i = (this.width - this.backgroundWidth) >> 1;
        int j = (this.height - this.backgroundHeight) >> 1;
        this.drawTexture(matrixStack, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        final TameableDragonEntity dragon = this.handler.dragon;
        final EndCrystalEntity crystal = dragon.nearestCrystal;
        if (dragon.hasChest()) {
            this.drawTexture(matrixStack, (this.width - 162) >> 1, (this.height - 74) >> 1, 7, 141, 162, 54);
        }
        dragon.nearestCrystal = null;// to disable crystal beam
        InventoryScreen.drawEntity(i + 60, j + 62, 5, i - x + 60F, j - y + 13F, dragon);
        dragon.nearestCrystal = crystal;
    }
}
