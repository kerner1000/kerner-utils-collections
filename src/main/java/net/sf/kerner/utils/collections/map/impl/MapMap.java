package net.sf.kerner.utils.collections.map.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.kerner.utils.collections.map.FactoryMap;

public class MapMap<T, K, V> {

    private final Map<T, Map<K, V>> map;

    private final FactoryMap<K, V> factory;

    public MapMap(final Map<T, Map<K, V>> map, final FactoryMap<K, V> factory) {
        this.map = map;
        this.factory = factory;
    }

    public MapMap(final Map<T, Map<K, V>> map) {
        this(map, new LinkedHashMapFactory<K, V>());
    }

    public MapMap() {
        this(new LinkedHashMap<T, Map<K, V>>(), new LinkedHashMapFactory<K, V>());
    }

    /**
     * TODO description
     * 
     * @return number of key1 to map mappings
     */
    public int size1() {
        return map.size();
    }

    /**
     * TODO description
     * 
     * @return number of key2 value mappings
     */
    public int size2() {
        int size = 0;
        for (final Entry<T, Map<K, V>> e : map.entrySet()) {
            size += e.getValue().size();
        }
        return size;
    }

    /**
     * TODO description
     * 
     * @return {@code true} if {{@link #size1()} == 0}; {@code false} otherwise
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey1(final T key) {
        return map.containsKey(key);
    }

    public boolean containsKey2(final K key) {
        for (final Map<K, V> v : map.values()) {
            if (v.keySet().contains(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(final V value) {
        for (final Map<K, V> v : map.values()) {
            if (v.values().contains(value))
                return true;
        }
        return false;
    }

    public Map<K, V> get(final T key1) {
        return map.get(key1);
    }

    public void put(final T key1, final K key2, final V value) {
        MapUtils.addToMapMap(map, key1, key2, value, factory);
    }

    public Map<K, V> remove1(final T key1) {
        return map.remove(key1);
    }

    public void remove2(final K key2) {
        for (final Map<K, V> c : map.values()) {
            c.remove(key2);
        }
    }

    public void clear() {
        map.clear();
    }

    public Set<T> keySet1() {
        return map.keySet();
    }

    public List<K> keyList2() {
        final List<K> result = new ArrayList<K>();
        for (final Map<K, V> v : map.values()) {
            result.addAll(v.keySet());
        }
        return result;
    }

    /**
     * TODO description
     * 
     * @param key1
     *            Type of key1
     * @return all values that are mapped by this key
     */
    public Collection<V> values(final K key1) {
        return map.get(key1).values();
    }

    public Collection<V> values() {
        final Collection<V> result = new ArrayList<V>();
        for (final Map<K, V> c : map.values()) {
            result.addAll(c.values());
        }
        return result;
    }

    public Set<Entry<T, Map<K, V>>> entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean equals(final Object o) {
        return map.equals(o);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }

    @Override
    public String toString() {
        return map.toString();
    }

}
