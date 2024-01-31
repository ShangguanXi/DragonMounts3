package net.dragonmounts.api;

import net.dragonmounts.registry.DragonType;

public interface IDragonTypified {
    DragonType getDragonType();

    interface Mutable extends IDragonTypified {
        void setDragonType(DragonType type);
    }
}