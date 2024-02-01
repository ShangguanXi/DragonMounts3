package net.dragonmounts.init;

import net.dragonmounts.inventory.DragonCoreScreenHandler;
import net.dragonmounts.inventory.DragonInventoryScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMScreenHandlers {
    public static final ScreenHandlerType<DragonCoreScreenHandler> DRAGON_CORE = register("dragon_core", DragonCoreScreenHandler::new);
    public static final ScreenHandlerType<DragonInventoryScreenHandler> DRAGON_INVENTORY = register("dragon_inventory", DragonInventoryScreenHandler::fromPacket);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String name, ScreenHandlerRegistry.ExtendedClientHandlerFactory<T> factory) {
        return ScreenHandlerRegistry.registerExtended(new Identifier(MOD_ID, name), factory);
    }
}
