package net.dragonmounts.items.material;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class DragonArmorItem extends Item {
    private final int bonus;
    private final String entityTexture;

    public DragonArmorItem(int bonus, String name, Item.Settings settings) {
        super(settings);
        this.bonus = bonus;
        this.entityTexture = "textures/entity/dragonarmor/" + name + ".png";
    }

    @Environment(EnvType.CLIENT)
    public Identifier getEntityTexture() {
        return new Identifier(this.entityTexture);
    }

    public int getBonus() {
        return this.bonus;
    }
}
