package net.sf.kerner.utils.collections.map.collection.impl;

import java.util.List;

import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.ArrayListFactory;
import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.collection.MapCollectionAbstract;

public class MapCollectionList<K, V> extends MapCollectionAbstract<K, V, List<V>> {

    private final FactoryList<V> factory;

    public MapCollectionList() {
        this.factory = new ArrayListFactory<V>();
    }

    public MapCollectionList(FactoryMap<K, List<V>> mapFactory, FactoryList<V> factory) {
        super(mapFactory);
        this.factory = factory;
    }

    public List<V> get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {

        // TODO see {@link MapUtils#addToCollectionsMap()}

        List<V> col = map.get(key);
        if (col == null) {
            col = factory.createCollection();
            map.put(key, col);
        }
        col.add(value);
    }

    public List<V> values() {
        final List<V> result = factory.createCollection();
        for (List<V> c : map.values()) {
            result.addAll(c);
        }
        return result;
    }

}
