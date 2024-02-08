package net.dragonmounts.util;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.util.math.MatrixStack;

public class ScaledModelPart extends ModelPart {
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public float scaleZ = 1.0F;

    public ScaledModelPart(Model model) {
        super(model);
    }

    public ScaledModelPart(Model model, int offsetX, int offsetY) {
        this(model.textureWidth, model.textureHeight, offsetX, offsetY);
        model.accept(this);
    }

    public ScaledModelPart(int textureWidth, int textureHeight, int offsetX, int offsetY) {
        super(textureWidth, textureHeight, offsetX, offsetY);
    }

    @Override
    public void rotate(MatrixStack matrices) {
        super.rotate(matrices);
        matrices.scale(this.scaleX, this.scaleY, this.scaleZ);
    }
}
