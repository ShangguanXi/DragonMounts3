package net.dragonmounts.registry;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class CooldownCategory {
    public static final SimpleRegistry<CooldownCategory> REGISTRY = FabricRegistryBuilder.createSimple(CooldownCategory.class, new Identifier(MOD_ID, "cooldown_category")).buildAndRegister();

    public final Identifier identifier;
    public final int id;

    public CooldownCategory(Identifier identifier) {
        this.id = REGISTRY.getRawId(Registry.register(REGISTRY, this.identifier = identifier, this));
    }
}
