package net.dragonmounts.util.math;

public class MathUtil {
    public static final float PI = (float) Math.PI;
    public static final float TO_RAD_FACTOR = PI / 180F;

    public static float getColor(int color, int area) {
        return (color >> (area * 8) & 0xFF) / 255F;
    }
}
