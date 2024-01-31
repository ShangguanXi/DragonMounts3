package net.dragonmounts.init;

import net.fabricmc.fabric.impl.item.group.ItemGroupExtensions;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMItemGroups {
    private static int getIndex() {
        ((ItemGroupExtensions) ItemGroup.INVENTORY).fabric_expandArray();
        return ItemGroup.GROUPS.length - 1;
    }

    public static final ItemGroup BLOCK_TAB = new Impl(getIndex(), "blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DMBlocks.ENDER_DRAGON_EGG);
        }
    };
    public static final ItemGroup ITEM_TAB = new Impl(getIndex(), "items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DMItems.ENDER_DRAGON_SCALES);
        }
    };
    public static final ItemGroup TOOL_TAB = new Impl(getIndex(), "tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DMItems.ENDER_DRAGON_SCALE_SWORD);
        }
    };

    public static Settings none() {
        return new Settings();
    }

    public static Settings block() {
        return new Settings().group(BLOCK_TAB);
    }

    public static Settings item() {
        return new Settings().group(ITEM_TAB);
    }

    public static Settings tool() {
        return new Settings().group(TOOL_TAB);
    }

    public static abstract class Impl extends ItemGroup {
        public Impl(int index, String name) {
            super(index, MOD_ID + '.' + name);
            super.setName(MOD_ID + '/' + name);
        }

        @Override
        public ItemGroup setName(String name) {
            return this;
        }
    }
}
