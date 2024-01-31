package net.dragonmounts.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMPacketHandler {
    public static final Identifier INIT_COOLDOWN_PACKET_ID = new Identifier(MOD_ID, "init_cd");
    public static final Identifier SYNC_COOLDOWN_PACKET_ID = new Identifier(MOD_ID, "sync_cd");

    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(INIT_COOLDOWN_PACKET_ID, ClientHandler::handleCooldownInit);
        ClientPlayNetworking.registerGlobalReceiver(SYNC_COOLDOWN_PACKET_ID, ClientHandler::handleCooldownSync);
    }
}
