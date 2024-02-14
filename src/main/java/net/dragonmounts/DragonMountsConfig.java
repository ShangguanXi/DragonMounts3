package net.dragonmounts;

import net.dragonmounts.util.config.BooleanConfig;
import net.dragonmounts.util.config.ConfigHolder;
import net.dragonmounts.util.config.DoubleConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.nbt.NbtCompound;

import java.io.File;

import static net.dragonmounts.DragonMounts.MOD_ID;

public class DragonMountsConfig {
    public static final Client CLIENT;
    public static final Server SERVER;

    public static class Client extends ConfigHolder {
        public final DoubleConfig camera_distance = new DoubleConfig("CameraDistance", "camera_distance", 20D);
        public final DoubleConfig camera_offset = new DoubleConfig("CameraOffset", "camera_offset", 0D);
        public final BooleanConfig converge_pitch_angle = new BooleanConfig("ConvergePitchAngle", "converge_pitch_angle", true);
        public final BooleanConfig converge_yaw_angle = new BooleanConfig("ConvergeYawAngle", "converge_yaw_angle", true);
        public final BooleanConfig hover_animation = new BooleanConfig("HoverAnimation", "hover_animation", true);
        public final BooleanConfig redirect_inventory = new BooleanConfig("RedirectInventory", "redirect_inventory", true);
        public final BooleanConfig toggle_descent = new BooleanConfig("ToggleDescent", "toggle_descent", false);

        private Client(File dir, String file) {
            super(dir, file, false);
            this.load();
        }

        @Override
        protected void read(NbtCompound compound) {
            this.debug.read(compound);
            this.camera_distance.read(compound);
            this.camera_offset.read(compound);
            this.converge_pitch_angle.read(compound);
            this.converge_yaw_angle.read(compound);
            this.hover_animation.read(compound);
            this.redirect_inventory.read(compound);
            this.toggle_descent.read(compound);
        }

        @Override
        protected NbtCompound write(NbtCompound compound) {
            this.debug.save(compound);
            this.camera_distance.save(compound);
            this.camera_offset.save(compound);
            this.converge_pitch_angle.save(compound);
            this.converge_yaw_angle.save(compound);
            this.hover_animation.save(compound);
            this.redirect_inventory.save(compound);
            this.toggle_descent.save(compound);
            return compound;
        }
    }

    public static class Server extends ConfigHolder {
        public final DoubleConfig base_health = new DoubleConfig("BaseHealth", "dragon_data.base_health", 90D, 1D, 1024D);
        public final DoubleConfig base_damage = new DoubleConfig("BaseDamage", "dragon_data.base_damage", 12D);
        public final DoubleConfig base_armor = new DoubleConfig("BaseArmor", "dragon_data.base_armor", 12D);
        public final BooleanConfig block_override = new BooleanConfig("BlockOverride", "gameplay.block_override", true);

        private Server(File dir, String file) {
            super(dir, file, false);
            this.load();
        }

        @Override
        protected void read(NbtCompound compound) {
            NbtCompound dragon = compound.getCompound("DragonData");
            NbtCompound gameplay = compound.getCompound("Gameplay");
            this.debug.read(compound);
            this.base_health.read(dragon);
            this.base_damage.read(dragon);
            this.base_armor.read(dragon);
            this.block_override.read(gameplay);
        }

        @Override
        protected NbtCompound write(NbtCompound compound) {
            NbtCompound dragon = compound.getCompound("DragonData");
            NbtCompound gameplay = compound.getCompound("Gameplay");
            this.debug.save(compound);
            this.base_health.save(dragon);
            this.base_damage.save(dragon);
            this.base_armor.save(dragon);
            this.block_override.save(gameplay);
            if (!dragon.isEmpty()) compound.put("DragonData", dragon);
            if (!gameplay.isEmpty()) compound.put("Gameplay", gameplay);
            return compound;
        }
    }

    static {
        File config = FabricLoader.getInstance().getConfigDir().resolve(MOD_ID).toFile();
        CLIENT = new Client(config, "client.dat");
        SERVER = new Server(config, "server.dat");
    }

    public static void init() {}
}