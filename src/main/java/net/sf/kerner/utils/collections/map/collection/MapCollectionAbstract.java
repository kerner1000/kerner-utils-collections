package net.sf.kerner.utils.collections.map.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.map.FactoryMap;
import net.sf.kerner.utils.collections.map.impl.FactoryLinkedHashMap;
import net.sf.kerner.utils.impl.util.Util;

public abstract class MapCollectionAbstract<K, V, L extends Collection<V>> implements MapCollection<K, V, L> {

    protected final Map<K, L> map;

    public MapCollectionAbstract() {
        this(new FactoryLinkedHashMap<K, L>());
    }

    public MapCollectionAbstract(final FactoryMap<K, L> mapFactory) {
        this.map = mapFactory.create();
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(final K key) {
        return map.containsKey(key);
    }

    public synchronized boolean containsValue(final V value) {
        for (final Collection<V> v : map.values()) {
            if (v.contains(value))
                return true;
        }
        return false;
    }

    public Set<Map.Entry<K, L>> entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean equals(final Object o) {
        return Util.equalsOnHashCode(this, o);
    }

    public L get(final K key) {
        return map.get(key);
    }

    protected abstract Factory<L> getFactoryCollection();

    @Override
    public int hashCode() {
        return map.hashCode();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean isEmpty(final K k) {
        return map.get(k).isEmpty();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public void put(final K key, final V value) {

        // TODO see {@link MapUtils#addToCollectionsMap()}

        L col = map.get(key);
        if (col == null) {
            col = getFactoryCollection().create();
            map.put(key, col);
        }
        col.add(value);
    }

    public synchronized void putAll(final K k, final Collection<? extends V> elements) {
        for (final V v : elements) {
            put(k, v);
        }
    };

    public synchronized void putAll(final Map<? extends K, ? extends V> m) {
        for (final java.util.Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }

    public synchronized void putAll(final MapCollection<? extends K, ? extends V, L> m) {
        for (final Entry<? extends K, L> e : m.entrySet()) {
            this.putAll(e.getKey(), e.getValue());
        }
    }

    public synchronized void remove(final K key) {
        map.remove(key);
    }

    public synchronized void removeValue(final K k, final V v) {
        map.get(k).remove(v);
    }

    public synchronized void removeValue(final V v) {
        final Iterator<Entry<K, L>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            final Entry<K, L> next = it.next();
            next.getValue().remove(v);
            if (next.getValue().isEmpty()) {
                it.remove();
            }
        }
    }

    public int size() {
        return map.size();
    }

    public int size(final K k) {
        return map.get(k).size();
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public Collection<L> values() {
        return map.values();
    }

}
