package net.dragonmounts.mixin;

import net.dragonmounts.util.IModdedItemPredicate;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemPredicate.class)
public abstract class ItemPredicateMixin implements IModdedItemPredicate {
    @Mutable
    @Final
    @Shadow
    private Tag<Item> tag;
    @Mutable
    @Final
    @Shadow
    private Item item;

    @Override
    public void dragonMounts3_Fabric$useFabricShears() {
        if (this.tag == null && this.item == Items.SHEARS) {
            this.tag = FabricToolTags.SHEARS;
            this.item = null;
        }
    }
}
