package net.sf.kerner.utils.collections.map.collection.impl;

import java.util.Set;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.collection.MapCollectionAbstract;
import net.sf.kerner.utils.collections.set.impl.FactoryLinkedHashSet;

public class MapSet<K, V> extends MapCollectionAbstract<K, V, Set<V>> {

    private final Factory<Set<V>> factory;

    public MapSet() {
        this.factory = new FactoryLinkedHashSet<V>();
    }

    public MapSet(final FactoryMap<K, Set<V>> mapFactory) {
        super(mapFactory);
        this.factory = new FactoryLinkedHashSet<V>();
    }

    public MapSet(final FactoryMap<K, Set<V>> mapFactory, final Factory<Set<V>> factory) {
        super(mapFactory);
        this.factory = factory;
    }

    public MapSet(final FactoryMap<K, Set<V>> mapFactory, final MapCollectionAbstract<K, V, Set<V>> template) {
        super(mapFactory);
        this.factory = new FactoryLinkedHashSet<V>();
        putAll(template);
    }

    public MapSet(final MapCollectionAbstract<K, V, Set<V>> template) {
        this.factory = new FactoryLinkedHashSet<V>();
        putAll(template);
    }

    @Override
    protected Factory<Set<V>> getFactoryCollection() {
        return factory;
    }

}
