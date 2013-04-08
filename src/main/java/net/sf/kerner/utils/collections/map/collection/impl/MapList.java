package net.sf.kerner.utils.collections.map.collection.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.collection.MapCollectionAbstract;

public class MapList<K, V> extends MapCollectionAbstract<K, V, List<V>> {

    private final Factory<List<V>> factory;

    public MapList() {
        this.factory = new Factory<List<V>>() {

            public List<V> create() {
                return new ArrayList<V>();
            }
        };
    }

    public MapList(final FactoryMap<K, List<V>> mapFactory) {
        super(mapFactory);
        this.factory = new Factory<List<V>>() {

            public List<V> create() {
                return new ArrayList<V>();
            }
        };
    }

    public MapList(final FactoryMap<K, List<V>> mapFactory, final Factory<List<V>> factory) {
        super(mapFactory);
        this.factory = factory;
    }

    @Override
    protected Factory<List<V>> getFactoryCollection() {
        return factory;
    }

}
