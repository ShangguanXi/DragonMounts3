package net.dragonmounts.capability;

public interface IArmorEffectManagerProvider {
    default ArmorEffectManager dragonMounts3_Fabric$getManager() {
        throw new NullPointerException();
    }
}
