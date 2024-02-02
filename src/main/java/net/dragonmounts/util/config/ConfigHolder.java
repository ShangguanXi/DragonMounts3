package net.dragonmounts.util.config;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public abstract class ConfigHolder {
    private static final Logger LOGGER = LogManager.getLogger();
    private final File file;
    public final BooleanConfig debug;

    public ConfigHolder(File dir, String file, boolean debug) {
        this.file = new File(dir, file);
        this.debug = new BooleanConfig("Debug", debug);
    }

    public final void load() {
        if (this.file.exists()) {
            try {
                this.read(NbtIo.readCompressed(this.file));
            } catch (Exception exception) {
                LOGGER.error("Exception reading {}", file, exception);
            }
        }
    }

    public final void save() {
        try {
            if (this.file.exists())
                NbtIo.writeCompressed(this.write(NbtIo.readCompressed(this.file)), this.file);
            else {
                File parent = this.file.getParentFile();
                if ((parent.exists() || parent.mkdir()) && this.file.createNewFile())
                    NbtIo.writeCompressed(this.write(new NbtCompound()), this.file);
                else LOGGER.error("Failed to create {}", this.file);
            }
        } catch (Exception exception) {
            LOGGER.error("Exception writing {}", this.file, exception);
        }
    }

    protected abstract void read(NbtCompound compound);

    protected abstract NbtCompound write(NbtCompound compound);
}
