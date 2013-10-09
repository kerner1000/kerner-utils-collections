package net.sf.kerner.utils.collections.map.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.kerner.utils.math.UtilMath;

public class MapCount<T> implements Map<T, Integer> {

    private final Map<T, Integer> delegate;

    public MapCount() {
        this.delegate = new HashMap<T, Integer>();
    }

    public MapCount(final Map<T, Integer> delegate) {
        this.delegate = delegate;
    }

    public void clear() {
        delegate.clear();
    }

    public boolean containsKey(final Object key) {
        return delegate.containsKey(key);
    }

    public boolean containsValue(final Object value) {
        return delegate.containsValue(value);
    }

    public Set<java.util.Map.Entry<T, Integer>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public boolean equals(final Object o) {
        return delegate.equals(o);
    }

    public Integer get(final Object key) {
        return delegate.get(key);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public Set<T> keySet() {
        return delegate.keySet();
    }

    public synchronized Integer put(final T key) {
        if (key != null) {
            final int i = 0;
        }
        final Integer value = delegate.get(key);
        if (value != null) {
            return delegate.put(key, UtilMath.increment(value));
        } else {
            return delegate.put(key, Integer.valueOf(1));
        }
    }

    public Integer put(final T key, final Integer value) {
        if (value.intValue() <= 1) {
            throw new IllegalArgumentException();
        }
        return delegate.put(key, value);
    }

    public void putAll(final Map<? extends T, ? extends Integer> m) {
        delegate.putAll(m);
    }

    public Integer remove(final Object key) {
        return delegate.remove(key);
    }

    public int size() {
        return delegate.size();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    public Collection<Integer> values() {
        return delegate.values();
    }

}
