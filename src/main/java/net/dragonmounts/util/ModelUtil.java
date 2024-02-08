package net.dragonmounts.util;

import net.minecraft.client.model.ModelPart;

public class ModelUtil {
    public static ModelPart applyRotateAngle(ModelPart part, double x, double y, double z) {
        part.pitch = (float) x;
        part.yaw = (float) y;
        part.roll = (float) z;
        return part;
    }

    public static ModelPart applyRotateAngle(ModelPart part, float x, float y, float z) {
        part.pitch = x;
        part.yaw = y;
        part.roll = z;
        return part;
    }
}
