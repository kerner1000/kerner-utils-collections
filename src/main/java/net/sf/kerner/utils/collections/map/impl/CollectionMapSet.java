package net.sf.kerner.utils.collections.map.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.set.FactorySet;

public class CollectionMapSet<K, V> extends CollectionMapAbstract<K, V, Set<V>> {

    private final FactorySet<V> factory;

    public CollectionMapSet() {
        this.factory = new FactorySet<V>() {
            public Set<V> createCollection() {
                return new HashSet<V>();
            }

            public Set<V> createCollection(Collection<? extends V> template) {
                return new HashSet<V>(template);
            }
        };
    }

    public CollectionMapSet(FactoryMap<K, Set<V>> mapFactory, FactorySet<V> factory) {
        super(mapFactory);
        this.factory = factory;
    }

    public Set<V> get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {

        // TODO see {@link MapUtils#addToCollectionsMap()}

        Set<V> col = map.get(key);
        if (col == null) {
            col = factory.createCollection();
            map.put(key, col);
        }
        col.add(value);
    }

    public Set<V> values() {
        final Set<V> result = factory.createCollection();
        for (Set<V> c : map.values()) {
            result.addAll(c);
        }
        return result;
    }
}
