/*package net.dragonmounts.formatting;

import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum DragonFormatting {
    Aether("Aether", '0', 0, 0X0294BD),
    Enchant("Enchant", '1', 1, 0X8359AE),
    Ender("Ender", '2', 2, 0XAB39BE),
    Fire("Fire", '3', 3, 0X960B0F),
    Forest("Forest", '4', 4, 0X298317),
    Ice("Ice", '5', 5, 0X00F2FF),
    Moonlight("Moonlight", '6', 6, 0X2C427C),
    Nether("Nether", '7', 7, 0XE5B81B),
    Sculk("Sculk", '8', 8, 0X29DFEB),
    Storm("Storm", '9', 9, 0XF5F1E9),
    Sunlight("Sunlight", 'a', 10, 0XFFDE00),
    Terra("Terra", 'b', 11, 0XA56C21),
    Water("Water", 'c', 12, 0X4F69A8),
    Zombie("Zombie", 'd', 13, 0X5A5602);

    private static final Map<String, DragonFormatting> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap((f) -> sanitize(f.name), (f) -> f));
    private static final Pattern FORMATTING_CODE_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");
    private final String name;
    private final char code;
    private final boolean modifier;
    private final String stringValue;
    private final int colorIndex;
    @Nullable
    private final Integer colorValue;

    private static String sanitize(String name) {
        return name.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");
    }

    DragonFormatting(String name, char code, int colorIndex, @Nullable Integer colorValue) {
        this(name, code, false, colorIndex, colorValue);
    }

    DragonFormatting(String name, char code, boolean modifier) {
        this(name, code, modifier, -1, null);
    }

    DragonFormatting(String name, char code, boolean modifier, int colorIndex, @Nullable Integer colorValue) {
        this.name = name;
        this.code = code;
        this.modifier = modifier;
        this.colorIndex = colorIndex;
        this.colorValue = colorValue;
        this.stringValue = "§" + code;
    }

    public int getColorIndex() {
        return this.colorIndex;
    }

    public boolean isModifier() {
        return this.modifier;
    }

    public boolean isColor() {
        return !this.modifier ;
    }

    public Formatting getColorValue() {
        return Formatting.byColorIndex(this.colorValue);
    }

    public String getName() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public String toString() {
        return this.stringValue;
    }

    @Nullable
    public static String strip(@Nullable String string) {
        return string == null ? null : FORMATTING_CODE_PATTERN.matcher(string).replaceAll("");
    }

    @Nullable
    public static DragonFormatting byName(@Nullable String name) {
        return name == null ? null : BY_NAME.get(sanitize(name));
    }

    public static DragonFormatting byColorIndex(int colorIndex) {

            DragonFormatting[] var1 = values();
            int var2 = var1.length;

            for (DragonFormatting formatting : var1) {
                if (formatting.getColorIndex() == colorIndex) {
                    return formatting;
                }
            }

            return null;
    }

    @Environment(EnvType.CLIENT)
    public static DragonFormatting byCode(char code) {
        char c = Character.toString(code).toLowerCase(Locale.ROOT).charAt(0);
        DragonFormatting[] var2 = values();
        int var3 = var2.length;

        for (DragonFormatting formatting : var2) {
            if (formatting.code == c) {
                return formatting;
            }
        }

        return null;
    }

    public static Collection<String> getNames(boolean colors, boolean modifiers) {
        List<String> list = Lists.newArrayList();
        DragonFormatting[] var3 = values();
        int var4 = var3.length;

        for (DragonFormatting formatting : var3) {
            if ((!formatting.isColor() || colors) && (!formatting.isModifier() || modifiers)) {
                list.add(formatting.getName());
            }
        }

        return list;
    }
}*/
