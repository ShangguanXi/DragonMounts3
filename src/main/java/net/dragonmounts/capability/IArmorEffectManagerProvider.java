package net.dragonmounts.capability;

public interface IArmorEffectManagerProvider {
    default ArmorEffectManager dragonMounts3_Fabric$getArmorEffectManager() {
        throw new NullPointerException();
    }
}
