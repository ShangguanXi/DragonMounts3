package net.dragonmounts.api;

import net.dragonmounts.item.DragonScaleArmorItem;
import net.dragonmounts.registry.DragonType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;

import java.util.function.Function;

import static net.dragonmounts.init.DMItemGroups.TOOL_TAB;

public class DragonScaleArmorSuit extends ArmorSuit<DragonScaleArmorItem, DragonScaleMaterial> implements IDragonTypified {
    public static final Function<EquipmentSlot, Item.Settings> DRAGONMOUNTS_TOOL_TAB = slot -> new Item.Settings().group(TOOL_TAB);
    public final IDragonScaleArmorEffect effect;

    public DragonScaleArmorSuit(DragonScaleMaterial material, IDragonScaleArmorEffect effect, Function<EquipmentSlot, Item.Settings> properties) {
        super(material,
                new DragonScaleArmorItem(material, EquipmentSlot.HEAD, effect, properties.apply(EquipmentSlot.HEAD)),
                new DragonScaleArmorItem(material, EquipmentSlot.CHEST, effect, properties.apply(EquipmentSlot.CHEST)),
                new DragonScaleArmorItem(material, EquipmentSlot.LEGS, effect, properties.apply(EquipmentSlot.LEGS)),
                new DragonScaleArmorItem(material, EquipmentSlot.FEET, effect, properties.apply(EquipmentSlot.FEET))
        );
        this.effect = effect;
    }

    @Override
    public DragonType getDragonType() {
        return this.material.type;
    }
}
