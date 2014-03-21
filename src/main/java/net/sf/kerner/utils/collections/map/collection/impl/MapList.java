package net.sf.kerner.utils.collections.map.collection.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.kerner.utils.Factory;
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

    public MapList(final Map<K, List<V>> map) {
        super(map);
        this.factory = new Factory<List<V>>() {

            public List<V> create() {
                return new ArrayList<V>();
            }
        };
    }

    public MapList(final Map<K, List<V>> map, final Factory<List<V>> factory) {
        super(map);
        this.factory = factory;
    }

    @Override
    protected Factory<List<V>> getFactoryCollection() {
        return factory;
    }

}
