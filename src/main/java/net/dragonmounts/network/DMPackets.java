package net.dragonmounts.network;

import net.minecraft.util.Identifier;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DMPackets {
    public static final Identifier ARMOR_RIPOSTE_PACKET_ID = new Identifier(MOD_ID, "armor_riposte");
    public static final Identifier INIT_COOLDOWN_PACKET_ID = new Identifier(MOD_ID, "init_cd");
    public static final Identifier SYNC_COOLDOWN_PACKET_ID = new Identifier(MOD_ID, "sync_cd");
    public static final Identifier SHAKE_DRAGON_EGG_PACKET_ID = new Identifier(MOD_ID, "shake_egg");
    public static final Identifier SYNC_DRAGON_AGE_PACKET_ID = new Identifier(MOD_ID, "sync_age");
    public static final Identifier FEED_DRAGON_PACKET_ID = new Identifier(MOD_ID, "feed_dragon");
    public static final Identifier RIDE_DRAGON_PACKET_ID = new Identifier(MOD_ID, "ride_dragon");
}
