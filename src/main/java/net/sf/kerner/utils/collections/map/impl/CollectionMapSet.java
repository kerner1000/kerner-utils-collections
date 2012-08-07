package net.sf.kerner.utils.collections.map.impl;

import java.util.HashSet;
import java.util.Set;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.collection.MapCollectionAbstract;

public class CollectionMapSet<K, V> extends MapCollectionAbstract<K, V, Set<V>> {

    private final Factory<Set<V>> factory;

    public CollectionMapSet() {
        this.factory = new Factory<Set<V>>() {
            public Set<V> create() {
                return new HashSet<V>();
            }
        };
    }

    public CollectionMapSet(final FactoryMap<K, Set<V>> mapFactory, final Factory<Set<V>> factory) {
        super(mapFactory);
        this.factory = factory;
    }

    @Override
    protected Factory<Set<V>> getFactoryCollection() {
        return factory;
    }

}
