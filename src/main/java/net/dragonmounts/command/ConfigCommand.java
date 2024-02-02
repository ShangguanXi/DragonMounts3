package net.dragonmounts.command;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import static net.dragonmounts.DragonMountsConfig.SERVER;
import static net.dragonmounts.command.DMCommand.HAS_PERMISSION_LEVEL_3;


public class ConfigCommand {
    public static final String OPEN_CONFIG_SCREEN = "/dragonmounts config client";

    public static ArgumentBuilder<ServerCommandSource, ?> register(boolean dedicated) {
        LiteralArgumentBuilder<ServerCommandSource> builder = CommandManager.literal("config")
                .then(CommandManager.literal("server")
                        .requires(HAS_PERMISSION_LEVEL_3)
                        .then(SERVER.debug.generateCommand())
                        .then(SERVER.base_armor.generateCommand(0D, 30D))
                        .then(SERVER.base_damage.generateCommand(0D, 2048D))
                        .then(SERVER.base_health.generateCommand())
                        .then(SERVER.block_override.generateCommand())
                );
        return dedicated ? builder : builder.then(CommandManager.literal("client"));
    }

    /*public static class Client {
        private static final String OPEN_CONFIG_SCREEN = "/dragonmounts config client";
        private static boolean OPEN_CONFIG_SCREEN_FLAG = false;

        public static void onClientSendMessage(ClientChatEvent event) {
            if (OPEN_CONFIG_SCREEN.equals(event.getOriginalMessage())) {
                event.setCanceled(true);
                OPEN_CONFIG_SCREEN_FLAG = true;
            }
        }

        public static void onGuiOpen(GuiOpenEvent event) {
            if (OPEN_CONFIG_SCREEN_FLAG && event.getGui() == null) {
                OPEN_CONFIG_SCREEN_FLAG = false;
                Minecraft minecraft = Minecraft.getInstance();
                minecraft.gui.getChat().addRecentChat(OPEN_CONFIG_SCREEN);
                event.setGui(new DMConfigScreen(minecraft, minecraft.screen));
            }
        }
    }*/
}
