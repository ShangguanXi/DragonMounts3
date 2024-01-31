/*
 ** 2016 March 05
 **
 ** The author disclaims copyright to this source code. In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package net.dragonmounts.util.math;

import net.minecraft.util.math.MathHelper;

/**
 * Interpolation utility class.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class Interpolation {

    private static final float[][] CR = {
            {-0.5F, 1.5F, -1.5F, 0.5F},
            {1.0F, -2.5F, 2.0F, -0.5F},
            {-0.5F, 0.0F, 0.5F, 0.0F},
            {0.0F, 1.0F, 0.0F, 0.0F}
    };

    public static float clampedLinear(float start, float end, float delta) {
        if (delta < 0.0F) return start;
        if (delta > 1.0F) return end;
        return start + delta * (end - start);
    }

    public static float clampedSmoothLinear(float start, float end, float delta) {
        if (delta < 0.0F) return start;
        if (delta > 1.0F) return end;
        return start + delta * delta * (3 - 2 * delta) * (end - start);
    }

    // http://www.java-gaming.org/index.php?topic=24122.0
    public static void catmullRomSpline(float x, float[] result, float[]... knots) {
        int nknots = knots.length;
        int nspans = nknots - 3;
        int knot = 0;
        if (nspans < 1) {
            throw new IllegalArgumentException("Spline has too few knots");
        }
        x = MathHelper.clamp(x, 0, 0.9999F) * nspans;

        int span = (int) x;
        if (span >= nknots - 3) {
            span = nknots - 3;
        }

        x -= span;
        knot += span;

        int dimension = result.length;
        for (int i = 0; i < dimension; i++) {
            float knot0 = knots[knot][i];
            float knot1 = knots[knot + 1][i];
            float knot2 = knots[knot + 2][i];
            float knot3 = knots[knot + 3][i];
            float c3 = CR[0][0] * knot0 + CR[0][1] * knot1 + CR[0][2] * knot2 + CR[0][3] * knot3;
            float c2 = CR[1][0] * knot0 + CR[1][1] * knot1 + CR[1][2] * knot2 + CR[1][3] * knot3;
            float c1 = CR[2][0] * knot0 + CR[2][1] * knot1 + CR[2][2] * knot2 + CR[2][3] * knot3;
            float c0 = CR[3][0] * knot0 + CR[3][1] * knot1 + CR[3][2] * knot2 + CR[3][3] * knot3;
            result[i] = ((c3 * x + c2) * x + c1) * x + c0;
        }
    }

    private Interpolation() {}
}
