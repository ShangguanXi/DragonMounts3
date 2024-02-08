package net.dragonmounts.mixin;

import net.dragonmounts.util.IModdedItemPredicate;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.predicate.item.ItemPredicate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MatchToolLootCondition.Serializer.class)
public abstract class MatchToolLootConditionSerializerMixin {
    @ModifyArg(
            method = "fromJson(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/loot/condition/MatchToolLootCondition;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/loot/condition/MatchToolLootCondition;<init>(Lnet/minecraft/predicate/item/ItemPredicate;)V")
    )
    public ItemPredicate useFabricShears(ItemPredicate predicate) {
        ((IModdedItemPredicate) predicate).dragonmounts$useFabricShears();
        return predicate;
    }
}
