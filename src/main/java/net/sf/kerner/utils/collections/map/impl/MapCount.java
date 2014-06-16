/*******************************************************************************
 * Copyright (c) 2010-2014 Alexander Kerner. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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

    public T getHighest() {
        Integer max = null;
        T key = null;
        for (final java.util.Map.Entry<T, Integer> e : delegate.entrySet()) {
            final Integer cnt = e.getValue();
            if (max == null || cnt.compareTo(max) > 0) {
                max = cnt;
                key = e.getKey();
            }
        }
        return key;
    }

    public T getLoweset() {
        Integer min = null;
        T key = null;
        for (final java.util.Map.Entry<T, Integer> e : delegate.entrySet()) {
            final Integer cnt = e.getValue();
            if (min == null || cnt.compareTo(min) < 0) {
                min = cnt;
                key = e.getKey();
            }
        }
        return key;
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

    public Integer put(final T key) {
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

    public void putAll(final Collection<? extends T> values) {
        for (final T t : values) {
            put(t);
        }
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
