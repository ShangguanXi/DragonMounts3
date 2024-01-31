package net.dragonmounts.group;

import net.dragonmounts.init.DMItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DragonMountsGroup {
    public static final ItemGroup ItemsGroup = FabricItemGroupBuilder.create(
                    new Identifier("dragonmounts", "items"))
            .icon(() -> new ItemStack(DMItems.ENDER_DRAGON_SCALES)).build();
}
