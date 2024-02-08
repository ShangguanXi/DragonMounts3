package net.dragonmounts.util;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;

import java.util.List;

public class ModelHolder<K, V extends ModelPart> {
    public interface Supplier<K, V extends ModelPart> {
        V get(Model model, K type);
    }

    protected Reference2ObjectOpenHashMap<K, V> map = new Reference2ObjectOpenHashMap<>();
    protected K key = null;
    protected V current = null;

    public ModelHolder(Model model, Supplier<K, V> supplier, List<K> keys) {
        for (K key : keys) {
            this.map.put(key, supplier.get(model, key));
        }
    }

    public V getCurrent() {
        return this.current;
    }

    public V load(K key) {
        if (key != this.key) {
            this.current = this.map.get(key);
        }
        return this.current;
    }
}
